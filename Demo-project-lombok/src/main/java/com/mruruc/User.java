package com.mruruc;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@ToString(exclude = "password")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"password","phone_number"})
public class User {
  

    @NonNull
    private String first_name;
    private String last_name;
    @NonNull
    private String email;
    @NonNull
    private Date date_of_birth;
    @NonNull
    private String phone_number;
    private Gender gender;
    @NonNull
    private String password;
}
