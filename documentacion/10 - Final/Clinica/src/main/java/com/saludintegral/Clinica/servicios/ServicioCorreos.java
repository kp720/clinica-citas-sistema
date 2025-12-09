package com.saludintegral.Clinica.servicios;

import com.saludintegral.Clinica.modelos.Cita;
import com.saludintegral.Clinica.modelos.Expediente;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.io.File;
import java.nio.charset.StandardCharsets;


@Service
public class ServicioCorreos {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    public void enviarCorreo(Cita cita) {

        String para = cita.getPaciente().getEmail();
        String asunto = "Detalles de tu cita médica";

        String cuerpoHtml = generarHtml(cita);

        MimeMessage mensaje = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mensaje, true, "UTF-8");

            helper.setTo(para);
            helper.setSubject(asunto);
            helper.setText(cuerpoHtml, true);

            mailSender.send(mensaje);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void enviarCorreo2(Expediente expediente) {

        String para = expediente.getPaciente().getEmail();
        String asunto = "Detalles de tu Expediente médico";

        String cuerpoHtml = generarHtml2(expediente);

        MimeMessage mensaje = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mensaje, true, "UTF-8");

            helper.setTo(para);
            helper.setSubject(asunto);
            helper.setText(cuerpoHtml, true);

            mailSender.send(mensaje);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private String generarHtml2(Expediente expediente) {
        return """
            <!DOCTYPE html>
            <html lang="es">
            <head>
                <meta charset="UTF-8">
                <style>
                    body { font-family: Arial, sans-serif; background:#f4f6f9; padding: 20px; margin: 0; }
                    .container { background: #ffffff; max-width: 600px; margin: auto; border-radius: 10px; padding: 25px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); }
                    .header { text-align: center; margin-bottom: 25px; }
                    .title { font-size: 22px; font-weight: bold; color: #2b4c7e; text-align: center; margin-bottom: 20px; }
                    table { width: 100%%; border-collapse: collapse; margin-top: 15px; }
                    table td { padding: 10px; border-bottom: 1px solid #e8e8e8; }
                    table td.label { font-weight: bold; color: #3a3a3a; width: 35%%; }
                    .footer { text-align: center; margin-top: 30px; color: #666; font-size: 13px; }
                </style>
            </head>
            <body>
            <div class="container">
                <div class="header">
                    <h2 style="margin: 0; color: #2b4c7e;">Centro Médico — Envio de expediente</h2>
                </div>
                <div class="title">Detalles de tu Expediente</div>

                <table>
                    <tr><td class="label">Paciente:</td><td>%s</td></tr>
                    <tr><td class="label">Fecha:</td><td>%s</td></tr>
                    <tr><td class="label">Diagnosticos:</td><td>%s</td></tr>
                    <tr><td class="label">Doctor:</td><td>Dr. %s</td></tr>
                    <tr><td class="label">Recetas:</td><td>%s</td></tr>
                    <tr><td class="label">Tratamientos:</td><td>%s</td></tr>
                    <tr><td class="label">Observaciones:</td><td>%s</td></tr>
                </table>

                <div class="footer">
                    Gracias por confiar en nuestros servicios.<br>
                    Si necesitas cancelar o modificar tu cita, contáctanos.
                </div>
            </div>
            </body>
            </html>
            """.formatted(
                expediente.getPaciente().getNombre(),
                expediente.getFecha(),
                expediente.getDiagnosticos(),
                expediente.getDoctor().getNombre(),
                expediente.getRecetas(),
                expediente.getTratamientos(),
                expediente.getObservaciones()
        );
    }

    private String generarHtml(Cita cita) {
        return """
            <!DOCTYPE html>
            <html lang="es">
            <head>
                <meta charset="UTF-8">
                <style>
                    body { font-family: Arial, sans-serif; background:#f4f6f9; padding: 20px; margin: 0; }
                    .container { background: #ffffff; max-width: 600px; margin: auto; border-radius: 10px; padding: 25px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); }
                    .header { text-align: center; margin-bottom: 25px; }
                    .title { font-size: 22px; font-weight: bold; color: #2b4c7e; text-align: center; margin-bottom: 20px; }
                    table { width: 100%%; border-collapse: collapse; margin-top: 15px; }
                    table td { padding: 10px; border-bottom: 1px solid #e8e8e8; }
                    table td.label { font-weight: bold; color: #3a3a3a; width: 35%%; }
                    .footer { text-align: center; margin-top: 30px; color: #666; font-size: 13px; }
                </style>
            </head>
            <body>
            <div class="container">
                <div class="header">
                    <h2 style="margin: 0; color: #2b4c7e;">Centro Médico — Confirmación de Cita</h2>
                </div>
                <div class="title">Detalles de tu cita</div>

                <table>
                    <tr><td class="label">Paciente:</td><td>%s</td></tr>
                    <tr><td class="label">Fecha:</td><td>%s</td></tr>
                    <tr><td class="label">Hora:</td><td>%s</td></tr>
                    <tr><td class="label">Doctor:</td><td>Dr. %s</td></tr>
                    <tr><td class="label">Tipo de consulta:</td><td>%s</td></tr>
                    <tr><td class="label">Atendido por:</td><td>%s</td></tr>
                </table>

                <div class="footer">
                    Gracias por confiar en nuestros servicios.<br>
                    Si necesitas cancelar o modificar tu cita, contáctanos.
                </div>
            </div>
            </body>
            </html>
            """.formatted(
                cita.getPaciente().getNombre(),
                cita.getFecha(),
                cita.getHora(),
                cita.getDoctor().getNombre(),
                cita.getTipo(),
                cita.getEncargado().getNombre()
        );
    }

}

