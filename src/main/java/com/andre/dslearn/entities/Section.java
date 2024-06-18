package com.andre.dslearn.entities;

import jakarta.persistence.*;

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
}
