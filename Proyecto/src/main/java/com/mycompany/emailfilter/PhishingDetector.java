package com.mycompany.emailfilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Enrique Gómez
 * @author Pedro Gabriel Fernández
 */

/**
 * Esta clase define las frases claves para considerar si un correo es de phishing.
 */
public class PhishingDetector {

    // Lista de frases clave para phishing
    public static List<String> phishingKeywords() {
        List<String> keywords = new ArrayList<>();
        keywords.add("verifica tu cuenta");
        keywords.add("click aquí");
        keywords.add("haz clic ahora");
        keywords.add("actualiza tu información");
        keywords.add("cambio de contraseña");
        keywords.add("verifica tu identidad");
        keywords.add("acceso no autorizado");
        keywords.add("confirma tu cuenta");
        keywords.add("haz clic para recuperar");
        keywords.add("restablece tu contraseña");
        keywords.add("solicitud urgente");
        keywords.add("actividad sospechosa");
        keywords.add("acción requerida");
        keywords.add("completa tu registro");
        keywords.add("recupera tu cuenta");
        keywords.add("seguridad de tu cuenta");
        keywords.add("verificación de cuenta");
        keywords.add("suspendido");
        keywords.add("límite de seguridad");
        keywords.add("alerta de seguridad");
        keywords.add("si no actúas, tu cuenta será desactivada");
        keywords.add("tu cuenta ha sido bloqueada");
        keywords.add("tu cuenta está en riesgo");
        keywords.add("última oportunidad");
        keywords.add("acción inmediata requerida");
        keywords.add("te bloquearemos si no actúas rápido");
        keywords.add("riesgo de perder tu cuenta");
        keywords.add("actúa ahora o perderás tu acceso");
        keywords.add("tiempo limitado para validar tu cuenta");
        keywords.add("tu cuenta ha sido hackeada");
        keywords.add("no ignores este mensaje");
        keywords.add("correo electrónico oficial de");
        keywords.add("desde el equipo de seguridad de");
        keywords.add("verifica tus datos con");
        keywords.add("autenticación de");
        keywords.add("problemas con tu cuenta de");
        keywords.add("suplantación de identidad detectada en");
        keywords.add("actualización de seguridad de");
        keywords.add("cambios en tu cuenta de");
        keywords.add("confirmación de pago");
        keywords.add("mensaje urgente de");
        keywords.add("accede ahora");
        keywords.add("haz clic para obtener más información");
        keywords.add("enlace de verificación");
        keywords.add("accede desde aquí");
        keywords.add("recibe tus ganancias aquí");
        keywords.add("sigue este enlace para más detalles");
        keywords.add("visítanos para confirmar");
        keywords.add("gratis");
        keywords.add("oferta exclusiva");
        keywords.add("ganaste un premio");
        keywords.add("dinero fácil");
        keywords.add("inversiones rápidas");
        keywords.add("financiamiento urgente");
        keywords.add("ganar dinero ahora");
        keywords.add("seguro de vida gratuito");
        keywords.add("membresía gratuita");
        keywords.add("haz tu solicitud aquí");
        keywords.add("sin esfuerzo");
        keywords.add("ganancias rápidas");
        keywords.add("consigue tu premio");
        keywords.add("dinero extra");
        keywords.add("suscríbete y gana");
        keywords.add("haz clic y gana");
        keywords.add("gana ahora");
        keywords.add("has sido seleccionado");
        keywords.add("ingresos garantizados");
        keywords.add("multiplica tu dinero");
        keywords.add("tu cuenta ha sido seleccionada");
        keywords.add("mensaje importante sobre tu cuenta");
        keywords.add("urgente");
        keywords.add("felicidades");
        keywords.add("responde inmediatamente");
        keywords.add("reclama tu recompensa");

        return keywords;
    }

}
