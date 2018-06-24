package sbnz.cdss.model.entity;

import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@org.kie.api.definition.type.Role(Role.Type.EVENT)
@Timestamp("date")
@Entity
@Table(name = "Examination")
public class Examination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private User doctor;

    @ManyToOne
    @JoinColumn(name = "disease_id")
    private Disease disease;

    @ManyToMany
    private List<Medical> medicals;

    public Examination() {
    }

    public Examination(Date date, User doctor, Disease disease, List<Medical> medicals) {
        this.date = date;
        this.doctor = doctor;
        this.disease = disease;
        this.medicals = medicals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public List<Medical> getMedicals() {
        return medicals;
    }

    public void setMedicals(List<Medical> medicals) {
        this.medicals = medicals;
    }

    @Override
    public String toString() {
        return "Examination{" +
                "date=" + date +
                "disease=" + disease +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Examination that = (Examination) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(date, that.date) &&
                Objects.equals(doctor, that.doctor) &&
                Objects.equals(disease, that.disease) &&
                Objects.equals(medicals, that.medicals);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, date, doctor, disease, medicals);
    }
}
