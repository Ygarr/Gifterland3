package gifterland3.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Blob;

/**
 * Created by kdiv on 8/1/16.  meal or Product
 * картинка,название, цена, страна производитель, штрихкод товара
 */
@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @NotNull
    private String name;
    private BigDecimal price;
    private String manufacturer;//TODO справочник
    private Integer barcode;

    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductCategory category;

    @JoinColumn(name = "foodstore_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Foodstore foodstore; //HashSet?

    @Column(name="image")
    @Lob
    private Blob image;

//    @Lob @Basic(fetch = FetchType.LAZY)
//    @Column(name="content", nullable=false)
//    private byte[] content;

    //TODO:Поле количество наименования блюда для отдельного магазина?
    public Meal() {
    }

    public Meal(Long id) {
        this.id = id;
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

    public BigDecimal getPrice() {
        return price;
    }


    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory productCategory) {
        this.category = productCategory;
    }


    public Foodstore getFoodstore() {
        return   foodstore;
    }

    public void setFoodstore(Foodstore store) {
        this.foodstore =  store;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public Blob getImage() {
        return image;
    }
}
