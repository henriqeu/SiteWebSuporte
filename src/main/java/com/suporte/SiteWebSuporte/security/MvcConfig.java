package com.suporte.SiteWebSuporte.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    // * Procedimento para retornar uma pagina de erro / ou sem permissão */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/EditarChamado").setViewName("EditarChamado");
        registry.addViewController("/EditarProcedimento").setViewName("EditarProcedimento");
        registry.addViewController("/ListaChamados").setViewName("ListaChamados");
        registry.addViewController("/ListaProcedimentos").setViewName("ListaProcedimentos");
        registry.addViewController("/MostrarProcedimento").setViewName("MostrarProcedimento");
        registry.addViewController("/NovoChamado").setViewName("NovoChamado");
        registry.addViewController("/NovoProcedimento").setViewName("NovoProcedimento");

    }

}
