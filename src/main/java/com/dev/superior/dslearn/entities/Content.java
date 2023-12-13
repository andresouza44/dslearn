package com.dev.superior.dslearn.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table (name= "tb_content")
public class Content extends Lesson{
    private String textContent;
    private String videoUri;

    private Content(){

    }

    public Content(Long id, String title, Integer position, String textContent, String videoUri) {
        super(id, title, position);
        this.textContent = textContent;
        this.videoUri = videoUri;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getVideoUri() {
        return videoUri;
    }

    public void setVideoUri(String videoUri) {
        this.videoUri = videoUri;
    }
}
