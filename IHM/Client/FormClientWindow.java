package StoreManagement.IHM.Client;

import StoreManagement.DAO.Client.Client;
import StoreManagement.DAO.Client.ClientDaoImpl;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FormClientWindow {

    private VBox vboxForm=new VBox(10);
    private VBox vboxParent=new VBox();
    private Scene scene=new Scene(vboxParent);
    Stage window=new Stage();
    private Label titleLabel=new Label("Ajouter un Client");
    private Label prenomLabel=new Label("Prenom :");
    private Label nomLabel=new Label("Nom :");
    private TextField prenomInput= new TextField();
    private TextField nomInput= new TextField();
    private Label telLabel=new Label("Téléphone :");
    private TextField telInput= new TextField();
    private Label emailLabel=new Label("Email :");
    private TextField emailInput= new TextField();
    private Label adresseLabel=new Label("Adresse :");
    private TextField adresseInput= new TextField();
    private Button ajouter=new Button("Ajouter");
    private Button annuler=new Button("Annuler");
    HBox buttonLine=new HBox(20);
    ClientDaoImpl cdao=new ClientDaoImpl();
    Client client=null;
    HBox hboxTitle=new HBox();

    private void addStylesToNodes(){
        titleLabel.getStyleClass().add("sceneTitle");
        nomLabel.getStyleClass().add("formLabel");
        prenomLabel.getStyleClass().add("formLabel");
        telLabel.getStyleClass().add("formLabel");
        emailLabel.getStyleClass().add("formLabel");
        adresseLabel.getStyleClass().add("formLabel");
        scene.getStylesheets().add("/StoreManagement/style.css");
        ajouter.getStyleClass().add("btn");
        annuler.getStyleClass().add("btn");
        buttonLine.getStyleClass().add("btnHbox");
        titleLabel.setMinWidth(window.getWidth());
        vboxParent.setMargin(vboxForm,new Insets(20,5,0,5));

    }

    private void addNodesToWindow(){
        buttonLine.getChildren().addAll(ajouter,annuler);
        hboxTitle.getChildren().add(titleLabel);
        vboxForm.getChildren().addAll(nomLabel, nomInput, prenomLabel, prenomInput, telLabel, telInput, emailLabel, emailInput, adresseLabel, adresseInput, buttonLine);
        vboxParent.getChildren().addAll(hboxTitle,vboxForm);
    }

    private void addEvents(){
        window.setOnCloseRequest(e->{
            e.consume();
        });
        ajouter.setOnAction(e ->{
            client=new Client(0,nomInput.getText(),prenomInput.getText(),telInput.getText(),emailInput.getText(),adresseInput.getText());
            cdao.add(client);
            window.close();
        });
        annuler.setOnAction(e -> {
            window.close();
        });
    }

    private void initiWindow(){
        window.setWidth(700);
        window.setHeight(650);
        window.setTitle("Ajouter CLient");
        window.getIcons().add(new Image("icone.png"));
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
    }

    public FormClientWindow(){
        initiWindow();
        addStylesToNodes();
        addNodesToWindow();
        addEvents();
        window.show();
    }

}
