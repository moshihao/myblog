package cn.moshihao.entity.account;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springside.modules.utils.reflection.ConvertUtils;

import cn.moshihao.entity.IdEntity;

import com.google.common.collect.Lists;

/**
 * 角色.
 * 
 * 注释见{@link User}.
 * 
 * @author calvin
 */
@Entity
@Table(name = "BLOG_ROLE")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Role extends IdEntity {

	private String name;
	private List<Authority> authorityList = Lists.newArrayList();

	public Role() {

	}

	public Role(String id, String name) {
		this.uuid = id;
		this.name = name;
	}

	@Column(nullable = false, unique = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany
	@JoinTable(name = "BLOG_ROLE_AUTHORITY", joinColumns = { @JoinColumn(name = "ROLE_UUID") }, inverseJoinColumns = { @JoinColumn(name = "AUTHORITY_UUID") })
	@Fetch(FetchMode.SUBSELECT)
	@OrderBy("uuid")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<Authority> getAuthorityList() {
		return authorityList;
	}

	public void setAuthorityList(List<Authority> authorityList) {
		this.authorityList = authorityList;
	}

	@Transient
	public String getAuthNames() {
		return ConvertUtils.convertElementPropertyToString(authorityList, "name", ", ");
	}

	@Transient
	@SuppressWarnings("unchecked")
	public List<String> getAuthIds() {
		return ConvertUtils.convertElementPropertyToList(authorityList, "uuid");
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
