package com.medicine.clinic_api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Builder
@Table(name = "Patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Column(name = "full_name",nullable = false,length = 150)
    private String fullName;

    @Setter
    @Column(name = "email",length = 150,unique = true)
    private String email;

    @Setter
    @Column(name = "phone",nullable = false, unique = true,length = 20)
    private String phone;

    @Setter
    @Column(name = "birth_date",nullable = false)
    private LocalDate birthDate;

    @Setter
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "gender",nullable = false,length = 1)
    private String gender;

    @Setter
    @Column(length = 250)
    private String address;

    @Setter
    @Column(name="blood_type",length = 3)
    private String bloodType;

    @Setter
    @Column(name ="emergency_contact",length = 20)
    private String emergencyContact;

//    @CreationTimestamp
    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

//    @UpdateTimestamp
    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;
}
