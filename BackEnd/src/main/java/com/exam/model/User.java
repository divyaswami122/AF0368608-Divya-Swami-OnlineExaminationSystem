package com.exam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "UserName can't be Empty.")
    @Size(min = 2, max = 30, message = "Minimum 2 and maximum 30 characters allowed.")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets are Allowed.")
    @Column(name="UserName",length=30)
    private String username;
    @NotEmpty(message = "Password can't be Empty.")
    @Size(min=8, max = 10, message = "Minimum 8 and maximum 10 characters allowed.")
    @Pattern(regexp = "^[A-Za-z0-9\\d@$!%*?&]*$", message = "At least one lowercase letter, one uppercase letter, one digit and one spacial character must be there")
    @Column(name="Password",length=20)
    private String password;
    @NotEmpty(message = "FirstName can't be Empty.")
    @Size(min = 2, max = 30, message = "Minimum 2 and maximum 30 characters allowed.")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets are Allowed.")
    @Column(name="FirstName",length=30)
    private String firstName;
    @NotEmpty(message = "LastName can't be Empty.")
    @Size(min = 3, max = 30, message = "Minimum 3 and maximum 30 characters allowed.")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Only Alphabets are Allowed.")
    @Column(name="LastName",length=30)
    private String lastName;
    @NotEmpty(message = "Email can't be Empty.")
    @Size(max = 255, message = "Email address must not exceed 255 characters")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "Only Alphabets and Numeric Values are Allowed")
    @Email(message = "Please provide a valid email address")
    @Column(name="Email",length=30)
    private String email;
    //This regex pattern allows for variations like "(123) 456-7890", "123-456-7890", "1234567890"
    @NotEmpty(message = "PhoneNumber can't be Empty.")
    @Size(min=10,max =10, message = "PhoneNumber must be exactly 10 characters")
    @Pattern(regexp = "^[0-9-()]*$", message = "Only digit are Allowed")
    @Column(name="PhoneNumber",length=10)
    private String phone;
    private boolean enabled = true;
    private String profile;

    //user many roles

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    @JsonIgnore
    private Set<UserRole> userRoles = new HashSet<>();


    public User() {

    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public User(Long id, String username, String password, String firstName, String lastName, String email, String phone, boolean enabled, String profile) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.enabled = enabled;
        this.profile = profile;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<Authority> set = new HashSet<>();
        this.userRoles.forEach(userRole -> {
            set.add(new Authority(userRole.getRole().getRoleName()));
        });


        return set;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
