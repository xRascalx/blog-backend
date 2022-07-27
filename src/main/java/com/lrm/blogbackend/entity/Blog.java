package com.lrm.blogbackend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_blog")
public class Blog {
    //主鍵
    @Id
    @GeneratedValue
    private Long id;
    //標題
    private String title;
    //內容
    private String content;
    //首圖
    private String firstPicture;
    //標記
    private String flag;
    //瀏覽次數
    private Integer views;
    //讚賞開啟
    private boolean appreciation;
    //轉載聲明開啟
    private boolean shareStatement;
    //評論
    private boolean commentabled;
    //發布
    private boolean published;
    //是否推薦
    private boolean recommened;
    //時間戳
    //對應到資料庫裏面生成的時間，可以選擇類型
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    //對應到資料庫裏面生成的時間，可以選擇類型
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @ManyToOne
    private Type type;
    public Blog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public boolean isAppreciation() {
        return appreciation;
    }

    public void setAppreciation(boolean appreciation) {
        this.appreciation = appreciation;
    }

    public boolean isShareStatement() {
        return shareStatement;
    }

    public void setShareStatement(boolean shareStatement) {
        this.shareStatement = shareStatement;
    }

    public boolean isCommentabled() {
        return commentabled;
    }

    public void setCommentabled(boolean commentabled) {
        this.commentabled = commentabled;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public boolean isRecommened() {
        return recommened;
    }

    public void setRecommened(boolean recommened) {
        this.recommened = recommened;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciation=" + appreciation +
                ", shareStatement=" + shareStatement +
                ", commentabled=" + commentabled +
                ", published=" + published +
                ", recommened=" + recommened +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
