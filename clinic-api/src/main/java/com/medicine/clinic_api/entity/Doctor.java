package com.medicine.clinic_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Builder
@Table(name = "Doctors", schema = "dbo")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Column(name = "full_name", nullable = false, length = 150)
    private String fullName;

    @Setter
    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Setter
    @Column(nullable = false, unique = true, length = 20)
    private String phone;

    @Setter
    @Column(name = "license_number", nullable = false, unique = true, length = 50)
    private String licenseNumber;

    @Setter
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Setter
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 1, nullable = false)
    private String gender;

    @Setter
    @Column(length = 250)
    private String address;

    @Setter
    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    @Setter
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal salary;

    @Setter
    @Column(name = "is_active", nullable = false)
    private boolean active = true;

//    @Column(name = "created_at", insertable = false, updatable = false)
//    private LocalDateTime createdAt;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")

    private LocalDateTime updatedAt;
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialty_id", nullable = false)
    private Specialty specialty;


}
