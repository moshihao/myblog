package cn.moshihao.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.xwork.StringUtils;
import org.hibernate.annotations.GenericGenerator;

/**
 * 统一定义Id的entity基类.
 * 
 * 基类统一定义Id的属性名称、数据类型、列名映射及生成策略.
 * 子类可重载getId()函数重定义Id的列名映射和生成策略.
 * 
 * @author calvin
 */
//JPA 基类的标识
@MappedSuperclass
public abstract class IdEntity {
    protected String uuid = null;

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		if (StringUtils.isEmpty(uuid)) {// 为了解决从页面获取uuid为空时，始终未空字符串，以致把新增操作变为更新操作
			this.uuid = null;
		} else {
			this.uuid = uuid;
		}
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
