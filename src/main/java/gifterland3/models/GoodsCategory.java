package gifterland3.models;

import javax.persistence.*;
//import org.apache.commons.lang.WordUtils;

/**
 * Created by kdiv on 8/1/16.
 */
@Entity
@Table(name = "goodscategory")
public class GoodsCategory {

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
    private String name;
    /**
     * Getter
     * @return id
     */
    @OneToMany(mappedBy = "goodscategory")
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
