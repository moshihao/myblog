package cn.moshihao.Listener;
import java.util.Date;

import org.apache.commons.lang.xwork.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.event.SaveOrUpdateEvent;
import org.hibernate.event.SaveOrUpdateEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springside.modules.security.springsecurity.SpringSecurityUtils;

import cn.modhihso.utils.DateUtils;
import cn.moshihao.service.account.AccountManager;

/**
 * 在自动为entity添加审计信息的Hibernate EventListener.
 * 
 * 在hibernate执行saveOrUpdate()时,自动为AuditableEntity的子类添加审计信息.
 * 
 * @author hqm 2012-4-18 下午3:16:46
 */
public class AuditListener implements SaveOrUpdateEventListener {

	private static final long serialVersionUID = -7481545873785342485L;
	private static Logger logger = LoggerFactory.getLogger(AuditListener.class);
	private  AccountManager accountManager;

	@Override
	public void onSaveOrUpdate(SaveOrUpdateEvent event) throws HibernateException {
		Object object = event.getObject();

		// 如果对象是AuditableEntity子类,添加审计信息.
		if (object instanceof AuditableEntity) {
			AuditableEntity entity = (AuditableEntity) object;
			
			String loginerNo = accountManager.findUserByLoginName(SpringSecurityUtils.getCurrentUserName()) == null ? "no logined"
					: accountManager.findUserByLoginName(SpringSecurityUtils.getCurrentUserName()).getLoginName();

			if (StringUtils.isEmpty(entity.getUuid())) {
				// 创建新对象
				entity.setInputTime(DateUtils.now());
				entity.setInputBy(loginerNo);
			} else {
				// 修改旧对象
				entity.setEditTime(DateUtils.now());
				entity.setEditBy(loginerNo);

				logger.info("{}对象(ID:{}) 被 {} 在 {} 修改", new Object[] { event.getEntityName(), entity.getUuid(),
						loginerNo, new Date() });
			}
		}
	}
	public AccountManager getAccountManager() {
		return accountManager;
	    }

	    @Autowired
	    public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	    }
}
