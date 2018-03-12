package pl.mariuszlyszczarz.AORMtest.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateUser {
    private String login;
    private String password;
    private String repeatPassword;
    private int age;
}
