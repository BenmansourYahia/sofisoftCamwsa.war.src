 package ma.sofisoft.cam2020ws;
 
 import ma.sofisoft.cam2020ws.Cam2020wsApplication;
 import org.springframework.boot.builder.SpringApplicationBuilder;
 import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
 
 public class ServletInitializer
   extends SpringBootServletInitializer {
   public ServletInitializer() {
    setRegisterErrorPageFilter(false);
   }
 
   
   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
   return application.sources(new Class[] { Cam2020wsApplication.class });
   }
 }

