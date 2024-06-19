package com.andre.dslearn;

import com.andre.dslearn.entities.Lesson;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_content")
public class Content extends Lesson {

    private String textContent;
    private String VideoUri;

    public Content(){
    }

    public Content(Long id, String title, Integer position, String textContent, String videoUri) {
        super(id, title, position);
        this.textContent = textContent;
        VideoUri = videoUri;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getVideoUri() {
        return VideoUri;
    }

    public void setVideoUri(String videoUri) {
        VideoUri = videoUri;
    }

}
