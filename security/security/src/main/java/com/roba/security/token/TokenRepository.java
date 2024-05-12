package com.roba.security.token;


import com.roba.security.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;
import java.util.List;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query("""
            select t from Token t inner join User u on t.user.id=u.id
            where u.id=:userId and(t.expired=false or t.revoked=false)
    """)
  List<Token> findAllValidTokenByUser(Integer userId);

    Optional<Token> findByToken(String token);

    List<Token> findByUser(User user);
}
