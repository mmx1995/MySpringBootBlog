package com.mmxin.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author mmx
 * es测试，文档类
 * Document是es 的注解，标识是个文档
 * indexName 是指索引的名称
 * type 类型定义为blog类
 * */

@Document(indexName = "blog" , type="blog")
public class EsBlog implements Serializable {

    private static final long serialVersionUID = 1090121247991994503L;
    @Id
    private String id ;

    private String title;

    private String summary ;

    private String content ;

    protected EsBlog(){

    }

    public EsBlog( String title, String summary, String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "EsBlog{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
