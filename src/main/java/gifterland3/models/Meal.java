package gifterland3.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

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
    private Integer id;

    @NotNull
    private String name;
    private BigDecimal price;
    private String manufacturer;//TODO справочник
    private Integer barcode;

    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductCategory category;

    @JoinColumn(name = "foodstore_id", referencedColumnName = "id", nullable=true)
    @OneToOne //Но одно наименование может быть у нескольих магазинов?
    private Foodstore foodstore;

    //TODO:Поле количество наименования блюда для отдельного магазина?


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return foodstore;
    }

    public void setFoodstore(Foodstore store) {
        this.foodstore = store;
    }

}
