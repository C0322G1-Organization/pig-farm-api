package vn.codegym.pig_farm.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.pig_farm.entity.Pigsty;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class VaccinationDto implements Validator {
    private Integer id;
    private String date;
    @NotNull
    @Min(value = 1)
    @Max(value = 10)
    private Integer amount;
    @NotBlank
    private String vaccineType;
    @NotBlank
    private String vaccinatedPerson;
    @Size(min = 1, max = 255)
    private String note;
    private Boolean isDeleted;
    private Pigsty pigsty;

    public VaccinationDto() {
    }

    public VaccinationDto(Integer id, String date, Integer amount, String vaccineType, String vaccinatedPerson, String note, Boolean isDeleted, Pigsty pigsty) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.vaccineType = vaccineType;
        this.vaccinatedPerson = vaccinatedPerson;
        this.note = note;
        this.isDeleted = isDeleted;
        this.pigsty = pigsty;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
    }

    public String getVaccinatedPerson() {
        return vaccinatedPerson;
    }

    public void setVaccinatedPerson(String vaccinatedPerson) {
        this.vaccinatedPerson = vaccinatedPerson;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Pigsty getPigsty() {
        return pigsty;
    }

    public void setPigsty(Pigsty pigsty) {
        this.pigsty = pigsty;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
