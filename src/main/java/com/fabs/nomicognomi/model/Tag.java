package com.fabs.nomicognomi.model;

import java.util.Set;

import jakarta.persistence.*;
import java.util.HashSet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;



@Entity
@Table(name = "tags")
public class Tag {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;
    @Column(unique = true)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "tags")
    private Set<Person> persons = new HashSet<>();

    public Long getUsageCount() {
        return usageCount;
    }

    public void setUsageCount(Long usageCount) {
        this.usageCount = usageCount;
    }

    @Transient
    private Long usageCount;

    public Set<Person> getPersons() {
        return person;
    }

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Tag tag))
            return false;
        return Objects.equals(tag.getTagId(), this.getTagId()) && Objects.equals(tag.getName(), this.getName());
    }


    @Override
    public int hashCode() {
        return Objects.hash(tagId, name);
    }

}
