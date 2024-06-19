package com.andre.dslearn.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Integer position;
    private String img_Uri;

    @ManyToOne()
    @JoinColumn(name = "prerequisite_id")
    private Section prerequisite;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    @OneToMany(mappedBy = "section")
    private List<Lesson> lessons = new ArrayList<>();

    public Section(){}

    public Section(Long id, String title, String description, Integer position,
                   String img_Uri, Section prerequisite, Resource resource) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.position = position;
        this.img_Uri = img_Uri;
        this.prerequisite = prerequisite;
        this.resource = resource;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getImg_Uri() {
        return img_Uri;
    }

    public void setImg_Uri(String img_Uri) {
        this.img_Uri = img_Uri;
    }

    public Section getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(Section prerequisite) {
        this.prerequisite = prerequisite;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Section section = (Section) o;

        return Objects.equals(id, section.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

