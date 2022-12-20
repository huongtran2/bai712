package huongtran.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;


@Entity
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[A-Z][a-z]{4,48}@$", message = "min 6 max 50, batdau A - ketthuc @")
    private String name;
    private String img;

    @Min(value = 18, message = "Min 18 Max 30")
    @Max(value = 30, message = "Min 18 Max 30")
    private int age;

    @ManyToOne
    private type type;

    public Client() {
    }

    public Client(String name, String img, int age, type type) {
        this.name = name;
        this.img = img;
        this.age = age;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public type getType() {
        return type;
    }

    public void setClassRoom(type type) {
        this.type = type;
    }
}
