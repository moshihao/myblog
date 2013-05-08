package cn.moshihao.Listener;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import cn.moshihao.entity.IdEntity;
/**
 * 含审计信息的Entity基类.
 * @author 莫仕豪  
 * moshihao@gmail.com  muscle1990.com  
 * @version:2013-3-2 上午10:26:15
 */
@MappedSuperclass
public class AuditableEntity extends IdEntity {

	protected String inputBy;
	protected String inputTime;
	protected String editBy;
	protected String editTime;

	/**
	 * 创建的操作员的登录名.
	 */
	@Column(updatable = false)
	public String getInputBy() {
		return inputBy;
	}

	public void setInputBy(String inputBy) {
		this.inputBy = inputBy;
	}

	/**
	 * 创建时间.
	 */
	// 本属性只在save时有效,update时无效.
	@Column(updatable = false)
	public String getInputTime() {
		return inputTime;
	}

	public void setInputTime(String inputTime) {
		this.inputTime = inputTime;
	}

	/**
	 * 最后修改的操作员的登录名.
	 */
	@Column(insertable = false)
	public String getEditBy() {
		return editBy;
	}

	public void setEditBy(String editBy) {
		this.editBy = editBy;
	}

	/**
	 * 最后修改时间.
	 */
	// 本属性只在update时有效,save时无效.
	@Column(insertable = false)
	public String getEditTime() {
		return editTime;
	}

	public void setEditTime(String editTime) {
		this.editTime = editTime;
	}
}
