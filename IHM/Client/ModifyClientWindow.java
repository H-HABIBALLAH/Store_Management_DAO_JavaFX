package StoreManagement.IHM.Client;

import StoreManagement.DAO.Client.Client;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;

public class ModifyClientWindow {
    private Stage window=new Stage();
    private BorderPane root=new BorderPane();
    private Scene scene=new Scene(root);
    private VBox vBox=new VBox(20);
    private HBox idHBox=new HBox(20);
    private HBox prenomHBox=new HBox(20);
    private HBox nomHBox=new HBox(20);
    private HBox telHBox=new HBox(20);
    private HBox adresseHBox=new HBox(20);
    private HBox emailHBox=new HBox(20);
    private HBox dateHBox=new HBox(20);
    private HBox buttonsHBox=new HBox(20);
    private Label codeLabel=new Label("Code : ");
    private Label telLabel=new Label("Téléphone : ");
    private Label nomLabel=new Label("Nom : ");
    private Label prenomLabel=new Label("Prenom : ");
    private Label emailLabel=new Label("Email : ");
    private Label adresseLabel=new Label("Adresse : ");
    private TextField idTextField=new TextField();
    private TextField nomTextField=new TextField();
    private TextField prenomTextField=new TextField();
    private TextField telTextField=new TextField();
    private TextField adresseTextField=new TextField();
    private TextField emailTextField=new TextField();
    private Button validerButton=new Button("Valider");
    private Button annulerButton=new Button("Annuler");
    ListClientWindow listClientWindow = null;


    private void addNodesToPane(){
        idHBox.getChildren().addAll(codeLabel,idTextField);
        nomHBox.getChildren().addAll(nomLabel,nomTextField);
        prenomHBox.getChildren().addAll(prenomLabel,prenomTextField);
        telHBox.getChildren().addAll(telLabel,telTextField);
        adresseHBox.getChildren().addAll(adresseLabel,adresseTextField);
        emailHBox.getChildren().addAll(emailLabel,emailTextField);
        buttonsHBox.getChildren().addAll(validerButton,annulerButton);
        vBox.getChildren().addAll(idHBox,nomHBox, prenomHBox, telHBox, emailHBox, adresseHBox, buttonsHBox);
        root.setCenter(vBox);
    }

    private void addStylesToNodes(){
        vBox.setPadding(new Insets(20));
        codeLabel.setMinWidth(100);
        nomLabel.setMinWidth(100);
        prenomLabel.setMinWidth(100);
        telLabel.setMinWidth(100);
        emailLabel.setMinWidth(100);
        adresseLabel.setMinWidth(100);
        validerButton.getStyleClass().add("btn");
        annulerButton.getStyleClass().add("btn");
        buttonsHBox.getStyleClass().addAll("btnHbox");
        scene.getStylesheets().add("/StoreManagement/style.css");vBox.setPadding(new Insets(20));
    }

    private void addEventsToNodes(){
        validerButton.setOnAction(e->{
            Long id = Long.valueOf(idTextField.getText());
            String nom  = nomTextField.getText();
            String prenom  = prenomTextField.getText();
            String tel  = telTextField.getText();
            String email  = emailTextField.getText();
            String adresse  = adresseTextField.getText();
            new modifyClientHandler(new Client(id, nom, prenom, tel, email, adresse), listClientWindow);
            window.close();
        });
        annulerButton.setOnAction(e->{
            window.close();
        });
    }

    private void initiWindow(){
        window.setWidth(400);
        window.setHeight(450);
        window.setTitle("Modifier client");
        window.getIcons().add(new Image("icone.png"));
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
    }

    public ModifyClientWindow(ListClientWindow listClientsWindow) {
        listClientWindow =listClientsWindow;
        initiWindow();
        addNodesToPane();
        addEventsToNodes();
        addStylesToNodes();
        window.show();
    }
}
