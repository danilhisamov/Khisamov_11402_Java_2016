package ru.kpfu.itis.form;

import org.hibernate.annotations.Cache;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import ru.kpfu.itis.entity.enums.Role;
import ru.kpfu.itis.entity.enums.Sex;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class RegistrationForm {
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 2,max = 30, message = "Максимальная длина 30 символов")
    private String lastname;

    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 2, max = 30, message = "Максимальная длина 30 символов")
    private String firstname;

    @Pattern(message = "Поле не может быть пустым, должно содержать латинские символы или цифры", regexp = "^[a-zA-Z0-9_-]{3,16}")
    private String login;

    @Pattern(message = "Поле не может быть пустым",regexp = "\\+7[0-9]{10}")
    private String phone;

    private int age;

    @Size(min = 3, max = 24, message = "Пароль неверной длины")
    private String password;

    @Size(min = 3, max = 24, message = "Пароль неверной длины")
    private String repassword;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @NotEmpty(message = "Поле не может быть пустым")
    @Email(message = "Невалидный email")
    private String email;


    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
