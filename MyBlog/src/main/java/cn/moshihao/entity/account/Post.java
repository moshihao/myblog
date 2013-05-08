package cn.moshihao.entity.account;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import cn.moshihao.Listener.AuditableEntity;

/*
 * @author 莫仕豪  
 * moshihao@gmail.com  muscle1990.com  
 * @version:2013-5-7 下午6:24:07
 *
 */
@Entity
//表名与类名不相同时重新定义表名.
@Table(name = "BLOG_POST")
//默认的缓存策略.
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Post extends AuditableEntity {
    private String title;
    private String content;
    private String keyword;
    private String status;//类别
    private int views;
    
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public String getKeyword() {
        return keyword;
    }
    public String getStatus() {
        return status;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getViews() {
        return views;
    }
    public void setViews(int views) {
        this.views = views;
    }
}
