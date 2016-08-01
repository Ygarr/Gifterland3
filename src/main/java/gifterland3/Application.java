package gifterland3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }


//   NO NEED at  http://www.localhost:8080/h2-console/
//   @Bean(initMethod="start",destroyMethod="stop")
//    public Server initH2DBWebConsole() throws SQLException {
//        return Server.createWebServer("-web","-webAllowOthers","-webDaemon","-webPort", "8082");
//    }

}
