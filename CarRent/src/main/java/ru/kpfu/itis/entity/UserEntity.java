package ru.kpfu.itis.entity;

import ru.kpfu.itis.entity.enums.Role;
import ru.kpfu.itis.entity.enums.Sex;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Danil Khisamov
 *         11-402
 */
@Entity
@Table(name = "users")
public class UserEntity  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "phone", nullable = true)
    private String phone;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "age",nullable = false)
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToOne(targetEntity = ClientEntity.class,mappedBy = "user")
    private ClientEntity client;

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", login='" + login + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", age=" + age +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                '}';
    }
}
