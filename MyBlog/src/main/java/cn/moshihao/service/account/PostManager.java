package cn.moshihao.service.account;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.orm.Page;
import org.springside.modules.orm.PropertyFilter;

import cn.moshihao.dao.account.PostDao;
import cn.moshihao.entity.account.Post;
import cn.moshihao.entity.account.Role;

/**
 * @author 莫仕豪 moshihao@gmail.com muscle1990.com
 * @version:2013-5-8 上午1:46:16 文章模块控制器
 */
// Spring Bean的标识.
@Component
// 默认将类中的所有函数纳入事务管理.
@Transactional
public class PostManager {

    private PostDao postdao;

    // -- Post Manager --//
    @Transactional(readOnly = true)
    public Post getPost(String uuid) {
	return postdao.get(uuid);
    }

    public Page<Post> searchPost(Page<Post> page, List<PropertyFilter> filters) {
	return postdao.findPage(page, filters);
    }

    public void savePost(Post entity) {
	postdao.save(entity);
    }

    public void deletePost(String uuid) {
	postdao.delete(uuid);
    }

    @Autowired
    public void setPostdao(PostDao postdao) {
	this.postdao = postdao;
    }

    public List<Post> getLastPost(){
	return postdao.getLastPost();
    }

    @Transactional(readOnly = true)
    public List<Post> getAllPost() {
	return postdao.getAll("uuid", true);
    }
}
