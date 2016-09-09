package gifterland3.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * An entity Foodstore composed by three fields (id, email, name).
 * (Должно быть описание магазина,
 * телефон,
 * адрес,
 * условия доставки,
 * ФИО владельца,
 * картинка)
 * The Entity annotation indicates that this class is a JPA entity.
 * The Table annotation specifies the name for the table in the db.
 *
 * @author borrowed
 */
@Entity
@Table(name = "foodstores") //Capitalize?
public class Foodstore {

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  // An autogenerated id (unique for each user in the db)
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

    // The foodservice's name
    @Column(name = "name")
    @NotNull
    private String name;
  
  // The foodservice's email
  @Column(name = "email")
  @NotNull
  private String email;


    @Column(name = "description")
    private String description;
    //private String deliveryCondition;TODO: case
    @Column(name = "ownerName")
    private String ownerName;
    @Column(name = "ownerSurname")
    private String ownerSurname;
    @Column(name = "ownerPatronymic")
    private String ownerPatronymic;

    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy="foodstore")
    private Set<Meal> meal;

//    //private Blob image;
//    //@Column(name="image")
//    @Lob
//    private Blob image;
//@ManyToOne
//@JoinColumn(name="meal_id",
//        insertable=false, updatable=false,
//        nullable=false)
//@OneToMany(mappedBy="foodstore")
//private Set<Meal> meal;
//private Meal meal;


//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private Set<UserDocument> userDocuments = new HashSet<UserDocument>();

  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  public Foodstore() {
  }

  public Foodstore(long id) {
    this.id = id;
  }
  
  public Foodstore(String email, String name) {
    this.email = email;
    this.name = name;
  }

  // Getter and setter methods

  public long getId() {
    return id;
  }

  public void setId(long value) {
    this.id = value;
  }

  public String getEmail() {
    return email;
  }
  
  public void setEmail(String value) {
    this.email = value;
  }
  
  public String getName() {
    return name;
  }

  public void setName(String value) {
    this.name = value;
  }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    /*
    * ФИО
     */
    public String getOwnerSurname() {
        return ownerSurname;
    }

    public void setOwnerSurname(String value) {
        this.ownerSurname = value;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String value) {
        this.ownerName = value;
    }
    public String getOwnerPatronymic() {
        return ownerPatronymic;
    }

    public void setOwnerPatronymic(String value) {
        this.ownerPatronymic = value;
    }

    /*
    *
     */
    public String getAddress() {
        return address;
    }

    public void setAddress(String value) {
        this.address = value;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String value) {
        this.phone = value;
    }

    public Set<Meal> getMeals() {
        return meal;
    }
} // class Foodstore
