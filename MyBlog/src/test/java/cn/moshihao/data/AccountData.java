package cn.moshihao.data;

import java.util.List;

import org.springside.modules.test.utils.DataUtils;

import cn.moshihao.entity.account.Authority;
import cn.moshihao.entity.account.Role;
import cn.moshihao.entity.account.User;

import com.google.common.collect.Lists;

/**
 * Account相关实体测试数据生成.
 * 
 * @author calvin
 */
public class AccountData {

	public static final String DEFAULT_PASSWORD = "123456";

	private static List<Role> defaultRoleList = null;

	private static List<Authority> defaultAuthorityList = null;

	public static User getRandomUser() {
		String userName = DataUtils.randomName("User");

		User user = new User();
		user.setLoginName(userName);
		user.setName(userName);
		user.setPassword(DEFAULT_PASSWORD);
		user.setEmail(userName + "@springside.org.cn");

		return user;
	}

	public static User getRandomUserWithRole() {
		User user = getRandomUser();
		user.getRoleList().add(getRandomDefaultRole());

		return user;
	}

	public static Role getRandomRole() {
		Role role = new Role();
		role.setName(DataUtils.randomName("Role"));

		return role;
	}

	public static Role getRandomRoleWithAuthority() {
		Role role = getRandomRole();
		role.getAuthorityList().addAll(getRandomDefaultAuthorityList());
		return role;
	}

	public static List<Role> getDefaultRoleList() {
		if (defaultRoleList == null) {
			defaultRoleList = Lists.newArrayList();
			defaultRoleList.add(new Role("qq", "管理员"));
			defaultRoleList.add(new Role("ww", "用户"));
		}
		return defaultRoleList;
	}

	public static Role getRandomDefaultRole() {
		return DataUtils.randomOne(getDefaultRoleList());
	}

	public static Authority getRandomAuthority() {
		String authName = DataUtils.randomName("Authority");

		Authority authority = new Authority();
		authority.setName(authName);

		return authority;
	}

	public static List<Authority> getDefaultAuthorityList() {
		if (defaultAuthorityList == null) {
			defaultAuthorityList = Lists.newArrayList();
			defaultAuthorityList.add(new Authority("wq", "浏览用户"));
			defaultAuthorityList.add(new Authority("ewq", "修改用户"));
			defaultAuthorityList.add(new Authority("ewq", "浏览角色"));
			defaultAuthorityList.add(new Authority("ewqq", "修改角色"));
		}
		return defaultAuthorityList;
	}

	public static List<Authority> getRandomDefaultAuthorityList() {
		return DataUtils.randomSome(getDefaultAuthorityList());
	}
}
