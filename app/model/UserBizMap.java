package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="m_user_biz_map")
public class UserBizMap {
	
	@EmbeddedId
	public ID Id;
	
	@Column(name="note")
	public String note;
	
	public static class ID implements Serializable {
		@Column(name="user_id")
		public long uId;
		@Column(name="biz_id")
		public long bId;
	}

}
