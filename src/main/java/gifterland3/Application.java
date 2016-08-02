package gifterland3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

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


    //from ~/src/main/webapp/WEB-INF/applicationContext.xml
    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix("");//empty not .jsp to serve either index.html or index.jsp
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

}
