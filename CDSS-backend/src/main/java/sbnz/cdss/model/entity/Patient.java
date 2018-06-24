package sbnz.cdss.model.entity;

import sbnz.cdss.model.monitoring.HeartBeatEvent;
import sbnz.cdss.model.monitoring.OxygenEvent;
import sbnz.cdss.model.monitoring.UrinatingEvent;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column
    private String healthCardNumber;

    @ElementCollection
    private List<String> allergens;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Examination> examinations;

    public Patient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<String> getAllergens() {
        return allergens;
    }

    public void setAllergens(List<String> allergens) {
        this.allergens = allergens;
    }

    public List<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(List<Examination> examinations) {
        this.examinations = examinations;
    }

    public String getHealthCardNumber() {
        return healthCardNumber;
    }

    public void setHealthCardNumber(String healthCardNumber) {
        this.healthCardNumber = healthCardNumber;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", healthCardNumber='" + healthCardNumber + '\'' +
                ", examinations=" + examinations +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id) &&
                Objects.equals(firstname, patient.firstname) &&
                Objects.equals(lastname, patient.lastname) &&
                Objects.equals(healthCardNumber, patient.healthCardNumber) &&
                Objects.equals(allergens, patient.allergens) &&
                Objects.equals(examinations, patient.examinations);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstname, lastname, healthCardNumber, allergens, examinations);
    }
}
