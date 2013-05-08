package cn.moshihao.dao.account;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springside.modules.orm.hibernate.HibernateDao;

import cn.moshihao.entity.account.Role;
import cn.moshihao.entity.account.User;

/**
 * 角色对象的泛型DAO.
 * 
 * @author calvin
 */
@Component
public class RoleDao extends HibernateDao<Role, String> {

	private static final String QUERY_USER_BY_ROLEID = "select u from User u left join u.roleList r where r.uuid=?";

	/**
	 * 重载函数,因为Role中没有建立与User的关联,因此需要以较低效率的方式进行删除User与Role的多对多中间表.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void delete(String id) {
		Role role = get(id);
		//查询出拥有该角色的用户,并删除该用户的角色.
		List<User> users = createQuery(QUERY_USER_BY_ROLEID, role.getUuid()).list();
		for (User u : users) {
			u.getRoleList().remove(role);
		}
		super.delete(role);
	}
}
