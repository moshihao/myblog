package cn.moshihao.unit.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.moshihao.dao.HibernateUtils;
import cn.moshihao.entity.account.User;

import com.google.common.collect.Lists;

public class HibernateUtilsTest {

	@Test
	public void mergeByCheckedIds() {
		User a = new User();
		a.setUuid("");

		User b = new User();
		b.setUuid("");

		List<User> srcList = Lists.newArrayList(a, b);
		List<String> idList = Lists.newArrayList("", "");

		HibernateUtils.mergeByCheckedIds(srcList, idList, User.class);

		assertEquals(2, srcList.size());
		assertTrue("" == srcList.get(0).getUuid());
		assertTrue("" == srcList.get(1).getUuid());
	}

}
