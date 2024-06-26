package com.andre.dslearn.entities;

import com.andre.dslearn.entities.enuns.ResourceType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_resource")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Integer position;
    private String img_Uri;
    private ResourceType type;
    private String externalLink;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    @OneToMany(mappedBy = "resource")
    private List<Section> sections = new ArrayList<>();


    public Resource(){
    }

    public Resource(Long id, String title, String description, Integer position, String img_Uri,
                    ResourceType type, String externalLink, Offer offer) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.position = position;
        this.img_Uri = img_Uri;
        this.type = type;
        this.externalLink = externalLink;
        this.offer = offer;
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

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public String getExternalLink() {
        return externalLink;
    }

    public void setExternalLink(String externalLink) {
        this.externalLink = externalLink;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public List<Section> getSections() {
        return sections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resource resource = (Resource) o;

        return Objects.equals(id, resource.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
