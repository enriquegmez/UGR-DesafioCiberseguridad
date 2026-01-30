package com.mycompany.emailfilter;

import java.io.File;
import java.util.Comparator;
import javafx.application.Application;
import javafx.stage.Stage;
import java.util.List;
import javafx.stage.DirectoryChooser;

/**
 * @author Enrique Gómez
 * @author Pedro Gabriel Fernández
 */

/**
 * Clase que contiene el main del proyecto.
 * En esta clase se pregunta por la ruta de la carpeta de correos, se descargan en una lista y se inicia la interfaz gráfica.
 * Además se pone en marcha la apliucación para filtrar los correos.
 */
public class EmailFilter extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Pedir al usuario que seleccione la carpeta de correos
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Selecciona la carpeta de correos");
        File selectedDirectory = directoryChooser.showDialog(primaryStage);

        if (selectedDirectory == null) {
            System.out.println("No se seleccionó ninguna carpeta. Saliendo...");
            return;
        }

        String emailFolderPath = selectedDirectory.getAbsolutePath();

        List<Email> emails = EmailSave.parseEmailsFromFolder(emailFolderPath);
        emails.sort(Comparator.comparing(Email::getDate).reversed());

        Interfaz interfaz = new Interfaz();
        interfaz.setEmailFolderPath(emailFolderPath); // nueva línea
        interfaz.start(primaryStage, emails);

    }

    public static void main(String[] args) {
        launch(args);
    }
}

