package vn.codegym.pig_farm.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(10)")
    private String code;

    @Column(columnDefinition = "VARCHAR(30)")
    private String name;

    @Column(columnDefinition = "DATE")
    private LocalDate birthDay;

    @Column(columnDefinition = "VARCHAR(10)")
    private String gender;

    @Column(columnDefinition = "VARCHAR(15)")
    private String idCard;

    @Column(columnDefinition = "TEXT")
    private String image;


    @Column(columnDefinition = "BIT(1) DEFAULT 0")
    private Boolean isDeleted;


    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Pigsty> pigsties;


    @JsonBackReference
    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Export> exports;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
