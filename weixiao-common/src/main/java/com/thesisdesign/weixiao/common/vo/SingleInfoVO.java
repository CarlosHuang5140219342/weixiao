package com.thesisdesign.weixiao.common.vo;

public class SingleInfoVO {
    private Integer id;
    private String type;
    private Integer size;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "SingleInfoVO{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", size=" + size +
                ", content='" + content + '\'' +
                '}';
    }
}
