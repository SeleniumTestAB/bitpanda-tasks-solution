package com.example.bitpanda.ui.task.solution.data;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.Locale;
@Getter
@Accessors(fluent = true)
public class ClientAccount {
    private final String gender;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String city;
    private final String state;
    private final String postCode;
    private final String mobilePhone;
    private final String password;

    public ClientAccount(String gender) {
        Faker faker = new Faker(new Locale("en-US"));
        this.gender = gender;
        this.email = faker.internet().emailAddress();
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.address = faker.address().fullAddress();
        this.city = faker.address().city();
        this.state = faker.address().state();
        this.postCode = faker.numerify("#####");
        this.mobilePhone = faker.phoneNumber().cellPhone();
        this.password = faker.internet().password(5, 6);
    }


}
