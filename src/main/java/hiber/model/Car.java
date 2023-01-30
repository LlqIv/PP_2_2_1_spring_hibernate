package hiber.model;


import javax.persistence.*;

@Entity
@Table(name = "users_cars")
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;
    public Car() {
    }

    public Car(String model) {
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                '}';
    }

}
