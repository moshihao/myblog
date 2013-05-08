package cn.modhihso.utils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 用户登录信息，保存到Session中
 * 
 * @author hqm
 * @email hqm1988.good@163.com
 * @createTime 2012-4-18 下午3:35:49
 * 
 */
public class LoginerInfo implements Serializable {

	private static final long serialVersionUID = -738977103103723814L;
	/**
	 * 在session存放的参数名
	 */
	public static final String NAME = "Username";
	/**
	 * 登录用户UUID
	 */
	private String loginerUuid;
	/**
	 * 登录用户编号[员工编号]
	 */
	private String loginerNo;
	/**
	 * 登录者实际名字
	 */
	private String trueName;
	private boolean isSuper;
	/**
	 * 登录者拥有的所有角色
	 */
	private List<String> roleList;
	/**
	 * 登录者拥有的所有根菜单【Top菜单】
	 */
	//private List<Menu> baseMenuList;
	/**
	 * 登陆者拥有的模块的所有uuid
	 */
	private List<String> moduleUuidList;
	/**
	 * 登陆者拥有的模块对应的系统功能
	 */
	private Map<String, Set<String>> moduleSysFunctions;
	/**
	 * 登陆者拥有的模块对应的功能集
	 */
	private Map<String, Set<String>> moduleFunctions;

	public String getLoginerUuid() {
		return loginerUuid;
	}

	public void setLoginerUuid(String loginerUuid) {
		this.loginerUuid = loginerUuid;
	}

	public String getLoginerNo() {
		return loginerNo;
	}

	public void setLoginerNo(String loginerNo) {
		this.loginerNo = loginerNo;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public List<String> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<String> roleList) {
		this.roleList = roleList;
	}

	/*public List<Menu> getBaseMenuList() {
		return baseMenuList;
	}

	public void setBaseMenuList(List<Menu> baseMenuList) {
		this.baseMenuList = baseMenuList;
	}*/

	public Map<String, Set<String>> getModuleSysFunctions() {
		return moduleSysFunctions;
	}

	public void setModuleSysFunctions(
			Map<String, Set<String>> moduleSysFunctions) {
		this.moduleSysFunctions = moduleSysFunctions;
	}

	public Map<String, Set<String>> getModuleFunctions() {
		return moduleFunctions;
	}

	public void setModuleFunctions(Map<String, Set<String>> moduleFunctions) {
		this.moduleFunctions = moduleFunctions;
	}

	public List<String> getModuleUuidList() {
		return moduleUuidList;
	}

	public void setModuleUuidList(List<String> moduleUuidList) {
		this.moduleUuidList = moduleUuidList;
	}

	public boolean isSuper() {
		return isSuper;
	}

	public void setSuper(boolean isSuper) {
		this.isSuper = isSuper;
	}

}
