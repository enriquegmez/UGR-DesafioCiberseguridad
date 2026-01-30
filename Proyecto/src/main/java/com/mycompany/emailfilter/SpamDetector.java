package com.mycompany.emailfilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Enrique Gómez
 * @author Pedro Gabriel Fernández
 */
/**
 * Esta clase define las frases claves para considerar si un correo es de spam.
 */
public class SpamDetector {

    // Lista de frases clave para Spam
    public static List<String> spamKeywords() {
        List<String> keywords = new ArrayList<>();
        keywords.add("oferta exclusiva");
        keywords.add("compra ahora y ahorra");
        keywords.add("promoción limitada");
        keywords.add("descuento increíble");
        keywords.add("haz tu solicitud ahora");
        keywords.add("recibe tu bono gratis");
        keywords.add("grandes ganancias");
        keywords.add("sólo hoy");
        keywords.add("no te lo pierdas");
        keywords.add("compra ya");
        keywords.add("sin compromiso");
        keywords.add("última oportunidad");
        keywords.add("completa tu registro");
        keywords.add("sin riesgo");
        keywords.add("prueba gratis");
        keywords.add("haz tu pedido ahora");
        keywords.add("precio increíble");
        keywords.add("aprovecha esta oportunidad");
        keywords.add("envío gratuito");
        keywords.add("no dejes pasar esta oferta");
        keywords.add("nueva oferta");
        keywords.add("mejor precio");
        keywords.add("suscripción gratuita");
        keywords.add("mejor que nunca");
        keywords.add("compra fácil");
        keywords.add("obtén más información");
        keywords.add("oferta solo por hoy");
        keywords.add("la oportunidad de tu vida");
        keywords.add("te invitamos a unirte");
        keywords.add("te esperamos");
        keywords.add("sólo por tiempo limitado");
        keywords.add("no esperes más");
        keywords.add("sin costo");
        keywords.add("esto cambiará tu vida");
        keywords.add("no necesitas experiencia");
        keywords.add("trabaja desde casa");
        keywords.add("fácil y rápido");
        keywords.add("no es una broma");
        keywords.add("esto no es un simulacro");
        keywords.add("solo para ti");
        keywords.add("bono exclusivo");
        keywords.add("oferta exclusiva para ti");
        keywords.add("precios bajos garantizados");
        keywords.add("liquidación total");
        keywords.add("solo quedan pocas unidades");
        keywords.add("ahorra hasta un 70%");
        keywords.add("20% en");
        keywords.add("50% en");
        keywords.add("70% en");
        keywords.add("20% dto");
        keywords.add("50% dto");
        keywords.add("70% dto");
        keywords.add("20% de descuento");
        keywords.add("50% de descuento");
        keywords.add("70% de descuento");
        keywords.add("ahorra");
        keywords.add("falta poco");
        keywords.add("venta flash");
        keywords.add("descuentos solo hoy");
        keywords.add("remate final");
        keywords.add("recibe tu regalo ahora");
        keywords.add("compra con un clic");
        keywords.add("no necesitas tarjeta");
        keywords.add("suscríbete sin pagar");
        keywords.add("promoción especial");
        keywords.add("nuevo producto revolucionario");
        keywords.add("compra directa del fabricante");
        keywords.add("sin intermediarios");
        keywords.add("super promoción");
        keywords.add("haz clic para comprar");
        keywords.add("entrega inmediata");
        keywords.add("precios imbatibles");
        keywords.add("tu producto está listo");
        keywords.add("tu pedido te espera");
        keywords.add("pedido confirmado");
        keywords.add("acceso exclusivo");
        keywords.add("accede a tu oferta");
        keywords.add("ofertas flash");
        keywords.add("reserva ahora");
        keywords.add("quedan pocas plazas");
        keywords.add("mejoramos cualquier oferta");
        keywords.add("sólo este fin de semana");
        keywords.add("envío express gratis");
        keywords.add("envío gratis");

        return keywords;
    }
}
