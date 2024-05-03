package relience.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Message {


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String name;

    public Message(String name) {
        this.name = name;
    }
}
