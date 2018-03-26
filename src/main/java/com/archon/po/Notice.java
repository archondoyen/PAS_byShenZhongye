package com.archon.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class Notice implements Serializable {
	public static Integer NOTICE_IS_DELETE = -1;
	public static Integer NOTICE_NOT_DELETE = 0;
	public static Integer NOTICE_NOT_READ = 0;
	public static Integer NOTICE_IS_READ = 1;
	public static String RECRUITMENT_NOTICE = "招聘消息";
	public static String INTERVIEW_NOTICE = "面试消息";
	public static String NEW_EMPLOYEE_NOTICE = "成功入职";/*入职记录*/
	public static String NEW_TRAIN_NOTICE = "培训通知";
	public static String RAIN_RESULT_NOTICE = "培训结果";
	public static String REWARD_PUNISH_NOTICE = "奖惩信息";
	public static String SAL_NOTICE = "工资单通知";

	private Integer isDeleted;
	private Integer id;
	private String noticeContent;
	private String noticeType;
	private Integer senderId;
	private Integer targetId;
	private Timestamp createTime;
	private Integer isRead;

	public Notice() {

	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}

	public Integer getSenderId() {
		return senderId;
	}

	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}

	public Integer getTargetId() {
		return targetId;
	}

	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getIsRead() {
		return isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}

	@Override
	public String toString() {
		return "Notice{" +
				" isDeleted=" + isDeleted +
				" id=" + id +
				" noticeContent=" + noticeContent +
				" noticeType=" + noticeType +
				" senderId=" + senderId +
				" targetId=" + targetId +
				" createTime=" + createTime +
				" isRead=" + isRead +
				"}";
	}
}