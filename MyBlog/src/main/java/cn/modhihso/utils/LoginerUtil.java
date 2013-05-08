package cn.modhihso.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springside.modules.security.springsecurity.SpringSecurityUtils;
import org.springside.modules.utils.web.struts2.Struts2Utils;

import cn.moshihao.entity.account.User;
import cn.moshihao.service.account.AccountManager;

/**
 * 登录
 * 
 * @author Hyben
 * @createTime 2012-05-05 16:37:07
 * 
 */
public class LoginerUtil {
    private static AccountManager accountManager;

    /**
     * 获取当前登录的用户信息
     * 
     * @return
     */
    public static User getLoginerInfo() {
		if (accountManager.findUserByLoginName(SpringSecurityUtils.getCurrentUserName()) == null) {
			return null;
		}
		return  accountManager.findUserByLoginName(SpringSecurityUtils.getCurrentUserName());
	}

    /**
     * 获取当前登录用户编号
     * 
     * @return
     */
    public static String getLoginerNo() {
	return getLoginerInfo() == null ? "no logined" : getLoginerInfo()
		.getLoginName();
    }

    /**
     * 获取当前登录用户ID
     * 
     * @return
     */
    public static String getLoginerUuid() {
	return getLoginerInfo().getUuid();
    }

    /**
     * 从Application中获取键值
     * 
     * @param key
     * @return
     */
    public static Object getApplicationAttributeValue(String key) {
	return Struts2Utils.getSession().getServletContext().getAttribute(key);
    }

    public AccountManager getAccountManager() {
	return accountManager;
    }

    @Autowired
    public void setAccountManager(AccountManager accountManager) {
	this.accountManager = accountManager;
    }
   

}
