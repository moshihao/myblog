package cn.moshihao.dao.account;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springside.modules.orm.hibernate.HibernateDao;

import cn.moshihao.entity.account.Post;
/**
 * @author 莫仕豪  
 * moshihao@gmail.com  muscle1990.com  
 * @version:2013-5-8 上午1:42:12
 * 文章对象的泛型DAO类
 */
@Component
public class PostDao extends HibernateDao<Post, String> {
    private static final String LAST_POST = "select uuid,title from blog_post order by input_time desc limit 0,5";
    
    @SuppressWarnings("unchecked")
	public List<Post> getLastPost() {
		Criterion criterion = Restrictions.isNotNull("uuid");
		Criteria c = createCriteria(criterion);
		c.addOrder(Order.desc("inputTime"));
		return c.list();
	}
}
