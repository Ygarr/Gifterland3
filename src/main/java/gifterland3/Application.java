package gifterland3;

import gifterland3.models.ProductCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private ProductCategoryDao productCategoryDao;


  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }


//   NO NEED at  http://www.localhost:8080/h2-console/
//   @Bean(initMethod="start",destroyMethod="stop")

//    public Server initH2DBWebConsole() throws SQLException {
//        return Server.createWebServer("-web","-webAllowOthers","-webDaemon","-webPort", "8082");
//    }

    @Override  //If  added CommandLineRunner
    public void run(String... strings) throws Exception { //TODO move to script or DB
//        productCategoryDao.save(new ProductCategory("Pizza"));
//        productCategoryDao.save(new ProductCategory("Sushi"));
//        productCategoryDao.save(new ProductCategory("Kebab"));
//        productCategoryDao.save(new ProductCategory("Garnish"));
//        productCategoryDao.save(new ProductCategory("Burger"));
//        productCategoryDao.save(new ProductCategory("Sandwich"));
//        productCategoryDao.save(new ProductCategory("Salad"));
//        productCategoryDao.save(new ProductCategory("Drinks"));
    }


}
