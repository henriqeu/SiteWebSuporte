package com.suporte.SiteWebSuporte.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecuredPasswordGenerator {
    // * Metodo para codificar a senha e transformar o 123 para:
    // $2a$10$AJmfazbG309L99x9X2Q/d.6z6tRhcWSDZQ0uVxiTG8Rj8WFmEMD/q
    // que esta registrado no banco **/

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // * Codifica a senha para que nao seja visualizada no banco de dados */

        // *ADMINISTRADOR */
        String admPassword = "adm4321";
        String encodedPasswordADM = encoder.encode(admPassword);

        // *VISITANTE */
        String visitantePassword = "v1234";
        String encodedPasswordVisitante = encoder.encode(visitantePassword);

        // * Mostra as senhas codfificadas no console para teste*/
        System.out.println(" Senha do administrador : " + admPassword + "\n Codificada : " + encodedPasswordADM);
        System.out
                .println(" Senha do visitante : " + visitantePassword + "\n Codificada : " + encodedPasswordVisitante);
    }

}