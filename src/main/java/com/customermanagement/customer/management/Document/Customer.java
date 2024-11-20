package com.customermanagement.customer.management.Document;

import org.springframework.data.annotation.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class Customer {
    @Id
    private  String id;

    @NotEmpty(message = "名字為必填項目")
    private String firstName;
    @NotEmpty(message = "姓氏為必填項目")
    private String lastName;
    @NotEmpty(message = "Email為必填項目")
    @Email(message = "請輸入正確的Email")
    private String email;

    public Customer() {
    }

    public Customer(String id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
