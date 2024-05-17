//package com.roba.user;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.time.LocalDate;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Data
//@Table(name="_user")
//public class User {
//    @Id
//    @SequenceGenerator(
//            name="user_id_sequence",
//            sequenceName="user_id_sequence"
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "user_id_seqeunce"
//    )
//    private Integer id;
//    private String fullName;
//    private String workEmail;
//    private String password;
//    private String role;
//    private LocalDate joinDate;
//    private Integer organizationId;
//
//}
