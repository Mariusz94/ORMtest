package pl.mariuszlyszczarz.AORMtest.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity  //klasa jest encją
@Table(name = "user") //nazwa naszej bazy
@Data
@NoArgsConstructor //encj jest również ziarnem
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String login;
    private String password;
    //@Column(name ="jakaś nazw kolumny")
    private int age;
}
