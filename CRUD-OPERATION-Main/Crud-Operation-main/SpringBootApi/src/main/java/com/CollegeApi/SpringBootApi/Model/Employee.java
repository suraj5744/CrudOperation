package com.CollegeApi.SpringBootApi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.spi.CascadingAction;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @Column(name="First_Name")
    private String firstName;
    @Column(name="Last_Name")
    private String lastName;
    @Column(name="Email_Id")
    private String emailId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="CompanyDetails",referencedColumnName = "cId")
    private Company company;
}
