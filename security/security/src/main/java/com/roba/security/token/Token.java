package com.roba.security.token;

import com.roba.security.user.User;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Token implements Serializable {

    private static final long serialVersionUID = 6529685098267757690L; // Add a serial version UID for serialization

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Make sure to specify the strategy explicitly if not default
    private Integer id;

    private String token;

    @Enumerated(EnumType.STRING)
    private TokenType tokenType;

    private boolean expired;

    private boolean revoked;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // Ensure that the User class is also Serializable if it's being cached or stored

}
