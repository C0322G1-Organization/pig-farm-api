package vn.codegym.pig_farm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(columnDefinition = "BIT")
    private Boolean isDeleted;

    @JsonBackReference
    @OneToMany(mappedBy = "employee")
    private List<Export> exports;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
