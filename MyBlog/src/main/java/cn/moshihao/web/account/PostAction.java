package cn.moshihao.web.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springside.modules.orm.Page;
import org.springside.modules.orm.PropertyFilter;
import org.springside.modules.utils.web.struts2.Struts2Utils;

import cn.moshihao.entity.account.Post;
import cn.moshihao.service.ServiceException;
import cn.moshihao.service.account.PostManager;
import cn.moshihao.web.CrudActionSupport;

/*
 * @author 莫仕豪  
 * moshihao@gmail.com  muscle1990.com  
 * @version:2013-5-8 上午1:47:29
 *
 */
@Namespace("/account")
@Results({ @Result(name = CrudActionSupport.RELOAD, location = "post.action", type = "redirect") 
,@Result(name = "list", location = "list.action", type = "redirectAction") })
public class PostAction extends CrudActionSupport<Post> {

    private static final long serialVersionUID = 1231243135234L;
    private PostManager postmanager;
    // -- 页面属性 --//
    private String uuid;
    private Post entity;
    private Page<Post> page = new Page<Post>(10);// 每页5条记录
    private Page<Post> postPage = new Page<Post>(10);// 每页10条记录
    private Map<String,String> lastPostMap=new HashMap<String, String>();
    private String tags;
    private List<Post> TranList=new ArrayList();
    @Override
    public Post getModel() {
	return entity;
    }

    /**
     * 等同于prepare()的内部函数,供prepardMethodName()函数调用.
     */
    @Override
    protected void prepareModel() throws Exception {
	if (!(StringUtils.isEmpty(uuid))) {
	    entity = postmanager.getPost(uuid);
	} else {
	    entity = new Post();
	}
    }

  //-- CRUD Action 函数 --//
    @Override
    public String list() throws Exception {
	List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
	//设置默认排序方式
	if (!page.isOrderBySetted()) {
		page.setOrderBy("uuid");
		page.setOrder(Page.ASC);
	}
	page = postmanager.searchPost(page, filters);
	tags=Struts2Utils.getParameter("tags");
	lastPostMap =getLastPost();
	return SUCCESS;
    }
    public Map<String,String> getLastPost(){
	Map<String,String> bitchMap =new HashMap<String, String>();
	TranList=postmanager.getLastPost();
	String title=null,id=null;
	int size=TranList.size();
	for(int i=0;size>i&&i<5;i++){
	    title=TranList.get(i).getTitle();
	    id=TranList.get(i).getUuid();
	    bitchMap.put(title,id);
	}
	return bitchMap;
	
    }
    @Override
    public String input() throws Exception {
	String input=Struts2Utils.getParameter("tags");
	if(!StringUtils.isEmpty(input)){
	    int views=entity.getViews();
	    views +=1;
	    entity.setViews(views);
	    postmanager.savePost(entity);
	}
	lastPostMap =getLastPost();
	return INPUT;
    }

    public String viewContent() throws Exception{
	prepareModel();
	return SUCCESS;
    }
    @Override
    public String save() throws Exception {
	postmanager.savePost(entity);
	addActionMessage("保存用户成功");
	return RELOAD;
    }

    @Override
    public String delete() throws Exception {
	try {
	    postmanager.deletePost(uuid);
		addActionMessage("删除用户成功");
	} catch (ServiceException e) {
		logger.error(e.getMessage(), e);
		addActionMessage("删除用户失败");
	}
	return RELOAD;
    }

    /* setter and getter */

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Post getEntity() {
	return entity;
    }

    public Page<Post> getPage() {
	return page;
    }
@Autowired
    public void setPostmanager(PostManager postmanager) {
	this.postmanager = postmanager;
    }

    public void setEntity(Post entity) {
	this.entity = entity;
    }

    public void setPage(Page<Post> page) {
	this.page = page;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }


    public Page<Post> getPostPage() {
        return postPage;
    }

    public Map<String, String> getLastPostMap() {
        return lastPostMap;
    }

    public void setPostPage(Page<Post> postPage) {
        this.postPage = postPage;
    }

    public void setLastPostMap(Map<String, String> lastPostMap) {
        this.lastPostMap = lastPostMap;
    }

}
