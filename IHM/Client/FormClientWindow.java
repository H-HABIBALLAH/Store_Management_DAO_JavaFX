package StoreManagement.IHM.Client;

import StoreManagement.DAO.Client.Client;
import StoreManagement.DAO.Client.ClientDaoImpl;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FormClientWindow {

    private VBox root=new VBox(10);
    private Scene scene=new Scene(root);
    Stage window=new Stage();
    private Label titleLabel=new Label("Ajouter un Client");
    private Label prenomLabel=new Label("Prenom :");
    private Label nomLabel=new Label("Nom :");
    private TextField prenomInput= new TextField();
    private TextField nomInput= new TextField();
    private Label ageLabel=new Label("Age :");
    private TextField ageInput= new TextField();
    private Label dateSaisie=new Label("Date saisie :");
    private DatePicker dateSaisieInput= new DatePicker();
    private Button ajouter=new Button("Ajouter");
    private Button annuler=new Button("Annuler");
    HBox buttonLine=new HBox(20);
    ClientDaoImpl cdao=new ClientDaoImpl();
    Client Client=null;

    private void addStylesToNodes(){
        titleLabel.getStyleClass().add("sceneTitle");
        nomLabel.getStyleClass().add("formLabel");
        prenomLabel.getStyleClass().add("formLabel");
        ageLabel.getStyleClass().add("formLabel");
        dateSaisie.getStyleClass().add("formLabel");
        scene.getStylesheets().add("/StoreManagement/style.css");
        ajouter.getStyleClass().add("btn");
        annuler.getStyleClass().add("btn");
        titleLabel.setMinWidth(window.getWidth());
    }

    private void addNodesToWindow(){
        buttonLine.getChildren().addAll(ajouter,annuler);
        root.getChildren().addAll(titleLabel, nomLabel, nomInput, prenomLabel, prenomInput, ageLabel, ageInput, dateSaisie, dateSaisieInput, buttonLine);
    }

    private void addEvents(){
        window.setOnCloseRequest(e->{
            e.consume();
        });
        ajouter.setOnAction(e ->{
            Client=new Client(0,nomInput.getText(),prenomInput.getText(),Integer.parseInt(ageInput.getText()),dateSaisieInput.getValue());
            cdao.add(Client);
            window.close();
        });
        annuler.setOnAction(e -> {
            window.close();
        });
    }

    private void initiWindow(){
        window.setWidth(700);
        window.setHeight(600);
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
