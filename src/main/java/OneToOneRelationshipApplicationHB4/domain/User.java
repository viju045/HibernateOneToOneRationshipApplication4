package OneToOneRelationshipApplicationHB4.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
//This is Fourth OneToOne Relationship Mapping Application in Hibernate.
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "foreign", parameters = {@org.hibernate.annotations.Parameter(name = "property", value = "vehical")})

    private long id;
    private String name;
    private String adress;
    private String email;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Vehical vehical;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Vehical getVehical() {
        return vehical;
    }

    public void setVehical(Vehical vehical) {
        this.vehical = vehical;
    }
}