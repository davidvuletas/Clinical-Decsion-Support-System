package sbnz.cdss.model.dto;

import java.util.List;

public class PatientDto {

    private String name;
    private String lastname;
    private Long id;
    private String cardNumber;
    private List<String> alergens;
    private String firstLast;

    public PatientDto(String name, String lastname, Long id, String cardNumber, List<String> alergens, String firstLast) {
        this.name = name;
        this.lastname = lastname;
        this.id = id;
        this.cardNumber = cardNumber;
        this.alergens = alergens;
        this.firstLast = firstLast;
    }

    public PatientDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public List<String> getAlergens() {
        return alergens;
    }

    public void setAlergens(List<String> alergens) {
        this.alergens = alergens;
    }

    public String getFirstLast() {
        return firstLast;
    }

    public void setFirstLast(String firstLast) {
        this.firstLast = firstLast;
    }
}
