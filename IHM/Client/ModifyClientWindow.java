package StoreManagement.IHM.Client;

import StoreManagement.DAO.Client.Client;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    private HBox ageHBox=new HBox(20);
    private HBox dateHBox=new HBox(20);
    private HBox buttonsHBox=new HBox(20);
    private Label idLabel=new Label("Id : ");
    private Label ageLabel=new Label("Age : ");
    private Label nomLabel=new Label("Nom : ");
    private Label prenomLabel=new Label("Prenom : ");
    private Label dateLabel=new Label("Date : ");
    private TextField idTextField=new TextField();
    private TextField nomTextField=new TextField();
    private TextField prenomTextField=new TextField();
    private TextField ageTextField=new TextField();
    private DatePicker datePiecker=new DatePicker();
    private Button validerButton=new Button("Valider");
    private Button annulerButton=new Button("Annuler");
    ListClientWindow listClientWindow =null;


    private void addNodesToPane(){
        idHBox.getChildren().addAll(idLabel,idTextField);
        nomHBox.getChildren().addAll(nomLabel,nomTextField);
        prenomHBox.getChildren().addAll(prenomLabel,prenomTextField);
        ageHBox.getChildren().addAll(ageLabel,ageTextField);
        dateHBox.getChildren().addAll(dateLabel,datePiecker);
        buttonsHBox.getChildren().addAll(validerButton,annulerButton);
        vBox.getChildren().addAll(idHBox,nomHBox, prenomHBox, ageHBox, dateHBox, buttonsHBox);
        root.setCenter(vBox);
    }

    private void addStylesToNodes(){
        vBox.setPadding(new Insets(20));
    }

    private void addEventsToNodes(){
        validerButton.setOnAction(e->{
            Long id = Long.valueOf(idTextField.getText());
            String nom  = nomTextField.getText();
            String prenom  = prenomTextField.getText();
            Integer age = Integer.valueOf(ageTextField.getText());
            LocalDate date = datePiecker.getValue();
            new modifyClientHandler(new Client(id, nom, prenom, age, date), listClientWindow);
            window.close();
        });
        annulerButton.setOnAction(e->{
            window.close();
        });
    }

    private void initiWindow(){
        window.setWidth(400);
        window.setHeight(370);
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
