package com.roba.security.token;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.roba.security.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Token implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String token;
    @Enumerated(EnumType.STRING)
    private TokenType tokenType;
    private boolean expired;
    private boolean revoked;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="user_id")
    private User user;

}
