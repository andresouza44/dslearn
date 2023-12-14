package com.dev.superior.dslearn.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_enrollment")
public class Enrollment {

    @EmbeddedId
    private EnrollmentPk id = new EnrollmentPk();

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant enrollMoment;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant refundMoment = null;
    private boolean available = true;
    private boolean onlyUpdate;

    @ManyToMany(mappedBy = "enrollmentsDone")
    private Set<Lesson> lessonsDone = new HashSet<>();


    @OneToMany(mappedBy = "enrollment")
    private List<Deliver> deliveries = new ArrayList<>();


    public  Enrollment (){

    }

    public Enrollment(User user, Offer offer, Instant enrollMoment, Instant refundMoment,
                      Boolean available, Boolean onlyUpdate) {
        this.enrollMoment = enrollMoment;
        this.refundMoment = refundMoment;
        this.available = available;
        this.onlyUpdate = onlyUpdate;
        id.setUser(user);
        id.setOffer(offer);
    }

    public Instant getEnrollMoment() {
        return enrollMoment;
    }

    public void setEnrollMoment(Instant enrollMoment) {
        this.enrollMoment = enrollMoment;
    }

    public Instant getRefundMoment() {
        return refundMoment;
    }

    public void setRefundMoment(Instant refundMoment) {
        this.refundMoment = refundMoment;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getOnlyUpdate() {
        return onlyUpdate;
    }

    public void setOnlyUpdate(Boolean onlyUpdate) {
        this.onlyUpdate = onlyUpdate;
    }

    public EnrollmentPk getId() {
        return id;
    }

    public void setId(EnrollmentPk id) {
        this.id = id;
    }

    public User getStudent(){
        return  id.getUser();
    }

    public void setStudent(User user){
        id.setUser(user);

    }

    public List<Deliver> getDeliveries() {
        return deliveries;
    }

    public Offer getOffer (){
        return id.getOffer();
    }

    public void setOffer (Offer offer){
        id.setOffer(offer);
    }

    public Set<Lesson> getLessonsDone() {
        return lessonsDone;
    }
}
