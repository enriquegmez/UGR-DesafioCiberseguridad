package com.mycompany.emailfilter;

import java.util.Comparator;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.List;
import java.util.stream.Collectors;
import javafx.geometry.Pos;

/**
 * @author Enrique Gómez
 * @author Pedro Gabriel Fernández
 */

/**
 * Esta clase realiza la interfaz gráfica para el usuario en la cual se muestran los correos.
 */
public class Interfaz {

    private List<Email> allEmails;
    private String emailFolderPath;
    private BorderPane root;
    private Button refreshButton;

    public void setEmailFolderPath(String path) {
        this.emailFolderPath = path;
    }

    public void start(Stage primaryStage, List<Email> emails) {
        this.allEmails = emails;

        TabPane tabPane = buildTabs();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        refreshButton = new Button("Refrescar correos");
        refreshButton.setOnAction(event -> {
            allEmails = EmailSave.parseEmailsFromFolder(emailFolderPath);
            allEmails.sort(Comparator.comparing(Email::getDate).reversed());
            TabPane updatedTabPane = buildTabs();
            updatedTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
            updateView(updatedTabPane);  // método que actualiza el StackPane
        });

        StackPane stack = new StackPane();
        stack.getChildren().addAll(tabPane, refreshButton);
        StackPane.setAlignment(refreshButton, Pos.TOP_RIGHT);
        StackPane.setMargin(refreshButton, new Insets(4, 10, 0, 0)); // Ajuste fino

        root = new BorderPane();
        root.setCenter(stack);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Anti-Phishing Mail Filter");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void updateView(TabPane newTabPane) {
        StackPane stack = new StackPane();
        stack.getChildren().addAll(newTabPane, refreshButton);
        StackPane.setAlignment(refreshButton, Pos.TOP_RIGHT);
        StackPane.setMargin(refreshButton, new Insets(4, 10, 0, 0));
        root.setCenter(stack);
    }

    private TabPane buildTabs() {
        TabPane tabPane = new TabPane();
        tabPane.getTabs().add(createTab("Buzón", "Inbox"));
        tabPane.getTabs().add(createTab("Spam", "Spam"));
        tabPane.getTabs().add(createTab("Phishing", "Phishing"));
        return tabPane;
    }

    private Tab createTab(String title, String category) {
        Tab tab = new Tab(title);
        tab.setClosable(false);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        List<Email> filtered = allEmails.stream()
                .filter(e -> e.getCategory().equals(category))
                .collect(Collectors.toList());

        for (Email email : filtered) {
            TitledPane pane = new TitledPane(email.getSubject() + " - " + email.getFrom(), new Label(email.getContent()));
            pane.setExpanded(false);
            layout.getChildren().add(pane);
        }

        ScrollPane scrollPane = new ScrollPane(layout);
        tab.setContent(scrollPane);
        return tab;
    }
}
