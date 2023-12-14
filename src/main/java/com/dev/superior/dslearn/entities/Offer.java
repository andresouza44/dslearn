package com.dev.superior.dslearn.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "tb_offer")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String edition;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant startMoment;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant endMoment;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "offer")
    public List<Resource> resources = new ArrayList<>();

    @OneToMany(mappedBy = "id.offer")
    private Set<Enrollment> enrolments = new HashSet<>();

    @OneToMany(mappedBy = "offer")
    private List<Topic> topics = new ArrayList<>();

    public Offer() {
    }

    public Offer(Long id, String edition, Instant startMoment, Instant endMoment, Course course) {
        this.id = id;
        this.edition = edition;
        this.startMoment = startMoment;
        this.endMoment = endMoment;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public String getEdition() {
        return edition;
    }

    public Instant getStartMoment() {
        return startMoment;
    }

    public Instant getEndMoment() {
        return endMoment;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setStartMoment(Instant startMoment) {
        this.startMoment = startMoment;
    }

    public void setEndMoment(Instant endMoment) {
        this.endMoment = endMoment;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public Set<Enrollment> getEnrolments() {
        return enrolments;
    }

    public List<User> getUsers(){
        return  enrolments.stream().map(x -> x.getStudent()).toList();
    }

    public List<Topic> getTopics() {
        return topics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Offer offer = (Offer) o;

        return Objects.equals(id, offer.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
