package com.CollegeApi.SpringBootApi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="company_Data")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cId;
    @Column(name="names")
    private String name;

}
