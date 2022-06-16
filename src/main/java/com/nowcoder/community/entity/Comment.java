package com.nowcoder.community.entity;

import java.util.Date;

public class Comment {
    private int id;
    private int userId;

    /**
     * 1为对帖子进行评论 2为对评论进行回复
     */
    private int entityType;

    /**
     * 对哪一条评论或者回复进行回复，因为既可以对帖子进行回复，
     * 也可以对帖子下面的回复进行回复，具体是帖子还是回复是由entityType属性获得
     */
    private int entityId;

    /**
     * 对帖子下面的评论的评论的回复，具有指向性
     */
    private int targetId;
    private String content;

    /**
     * 0表示正常 1表示禁止显示
     */
    private int status;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEntityType() {
        return entityType;
    }

    public void setEntityType(int entityType) {
        this.entityType = entityType;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userId=" + userId +
                ", entityType=" + entityType +
                ", entityId=" + entityId +
                ", targetId=" + targetId +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
