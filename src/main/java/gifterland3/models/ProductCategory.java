package gifterland3.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
//import org.apache.commons.lang.WordUtils;

/**
 * Created by kdiv on 8/1/16.
 */
@Entity
@Table(name = "productcategory")
public class ProductCategory {

    public ProductCategory() {
    }

    public ProductCategory(Integer id) {
        this.id = id;
    }

    public ProductCategory(String name) {
        this.name = name;
    }

    /**
     * Колонка для поля
     * id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * Колонка для поля
     * name
     */
    @Column(name = "name")
    @NotNull
    private String name;
    /**
     * Getter
     * @return id
     */
    //@OneToMany(mappedBy = "poductcategory")
    public Integer getId() {
        return id;
    }
    /**
     * Setter
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Getter
     * @param name
     */
    public String getName() {
        return name;
    }
    /**
     * Setter
     * @param name
     */
    public void setName(String name) {
        //this.name = WordUtils.capitalizeFully(name);
        this.name = name;
    }

}
