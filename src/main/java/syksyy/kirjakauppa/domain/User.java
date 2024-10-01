package syksyy.kirjakauppa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name= "users")
public class User {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id", nullable = false, updatable = false)
 private Long id;
 // Username with unique constraint
 @Column(name = "username", nullable = false, unique = true)
 private String username;
 @Column(name = "password", nullable = false)
 private String passwordHash;
 @Column(name = "role", nullable = false)
 private String role;

public String getRole() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getRole'");
}
public String getPasswordHash() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getPasswordHash'");
}
public void setRole(String string) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setRole'");
}
public void setPasswordHash(String hashPwd) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setPasswordHash'");
}

}