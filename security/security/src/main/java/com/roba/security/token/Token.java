package com.roba.security.token;

import com.roba.security.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Token {

    @Id
    @GeneratedValue
    private Integer id;
    private String token;
    @Enumerated(EnumType.STRING)
    private TokenType tokenType;
    private boolean expired;
    private boolean revoked;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

}
