
package lanchonete.com.br.sistemaaps.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class SpringMvcServlet extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {AppWebConfig.class};
    }

    //Define o padrão das URLs dos Controllers/Servlets - no caso vão ser acessiveis todas as URLs que tem o "/"
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    
}
