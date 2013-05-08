package cn.moshihao.web.account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springside.modules.orm.Page;
import org.springside.modules.orm.PropertyFilter;
import org.springside.modules.security.springsecurity.SpringSecurityUtils;
import org.springside.modules.utils.web.struts2.Struts2Utils;

import cn.moshihao.dao.HibernateUtils;
import cn.moshihao.entity.account.Post;
import cn.moshihao.entity.account.Role;
import cn.moshihao.entity.account.User;
import cn.moshihao.service.ServiceException;
import cn.moshihao.service.account.AccountManager;
import cn.moshihao.service.account.PostManager;
import cn.moshihao.web.CrudActionSupport;

/**
 * 用户管理Action.
 * 
 * 使用Struts2 convention-plugin annotation定义Action参数. 演示带分页的管理界面.
 * 
 * @author calvin
 */
// 定义URL映射对应/account/user.action
@Namespace("/account")
// 定义名为reload的result重定向到user.action, 其他result则按照convention默认.
@Results({
	@Result(name = CrudActionSupport.RELOAD, location = "user.action", type = "redirect"),
	@Result(name = "List", location = "list.action", type = "redirect"),
	@Result(name = "login", location = "login.action", type = "redirect") })
public class UserAction extends CrudActionSupport<User> {

    private static final long serialVersionUID = 8683878162525847072L;

    private AccountManager accountManager;
    private PostAction postAction;

    // -- 页面属性 --//
    private String uuid;
    private User entity;
    private Page<User> page = new Page<User>(5);// 每页5条记录
    private List<String> checkedRoleIds; // 页面中钩选的角色id列表
    

    // -- ModelDriven 与 Preparable函数 --//

    public User getModel() {
	return entity;
    }

    @Override
    protected void prepareModel() throws Exception {
	if (!(StringUtils.isEmpty(uuid))) {
	    entity = accountManager.getUser(uuid);
	} else {
	    entity = new User();
	}
    }

    // -- CRUD Action 函数 --//
    @Override
    public String list() throws Exception {
	List<PropertyFilter> filters = PropertyFilter
		.buildFromHttpRequest(Struts2Utils.getRequest());
	// 设置默认排序方式
	if (!page.isOrderBySetted()) {
	    page.setOrderBy("uuid");
	    page.setOrder(Page.ASC);
	}
	page = accountManager.searchUser(page, filters);
	return SUCCESS;
    }

    @Override
    public String input() throws Exception {
	checkedRoleIds = entity.getRoleIds();
	return INPUT;
    }

    @Override
    public String save() throws Exception {
	// 根据页面上的checkbox选择 整合User的Roles Set
	HibernateUtils.mergeByCheckedIds(entity.getRoleList(), checkedRoleIds,
		Role.class);

	accountManager.saveUser(entity);
	addActionMessage("保存用户成功");
	return RELOAD;
    }

    @Override
    public String delete() throws Exception {
	try {
	    accountManager.deleteUser(uuid);
	    addActionMessage("删除用户成功");
	} catch (ServiceException e) {
	    logger.error(e.getMessage(), e);
	    addActionMessage("删除用户失败");
	}
	return RELOAD;
    }

    // -- 其他Action函数 --//
    /**
     * 支持使用Jquery.validate Ajax检验用户名是否重复.
     */
    public String checkLoginName() {
	HttpServletRequest request = ServletActionContext.getRequest();
	String newLoginName = request.getParameter("loginName");
	String oldLoginName = request.getParameter("oldLoginName");

	if (accountManager.isLoginNameUnique(newLoginName, oldLoginName)) {
	    Struts2Utils.renderText("true");
	} else {
	    Struts2Utils.renderText("false");
	}
	// 因为直接输出内容而不经过jsp,因此返回null.
	return null;
    }

    // -- 页面属性访问函数 --//
    /**
     * list页面显示用户分页列表.
     */
    public Page<User> getPage() {
	return page;
    }

    /**
     * input页面显示所有角色列表.
     */
    public List<Role> getAllRoleList() {
	return accountManager.getAllRole();
    }

    /**
     * input页面显示用户拥有的角色.
     */
    public List<String> getCheckedRoleIds() {
	return checkedRoleIds;
    }

    /**
     * input页面提交用户拥有的角色.
     */
    public void setCheckedRoleIds(List<String> checkedRoleIds) {
	this.checkedRoleIds = checkedRoleIds;
    }

    @Autowired
    public void setAccountManager(AccountManager accountManager) {
	this.accountManager = accountManager;
    }

    public String getUuid() {
	return uuid;
    }

    public void setUuid(String uuid) {
	this.uuid = uuid;
    }

    public void setEntity(User entity) {
	this.entity = entity;
    }
    @Autowired
    public void setPostAction(PostAction postAction) {
        this.postAction = postAction;
    }
}
