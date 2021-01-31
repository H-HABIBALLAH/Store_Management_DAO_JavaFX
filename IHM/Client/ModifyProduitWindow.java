package StoreManagement.IHM.Client;

import StoreManagement.DAO.Produit.Produit;
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

public class ModifyProduitWindow {
    private Stage window=new Stage();
    private BorderPane root=new BorderPane();
    private Scene scene=new Scene(root);
    private VBox vBox=new VBox(20);
    private HBox idHBox=new HBox(20);
    private HBox quantiteHBox=new HBox(20);
    private HBox prixHBox=new HBox(20);
    private HBox dateHBox=new HBox(20);
    private HBox designationHBox=new HBox(20);
    private HBox buttonsHBox=new HBox(20);
    private Label idLabel=new Label("Id : ");
    private Label quantiteLabel=new Label("Quantite : ");
    private Label designationLabel=new Label("Designation : ");
    private Label prixLabel=new Label("Prix : ");
    private Label dateLabel=new Label("Date : ");
    private TextField idTextField=new TextField();
    private TextField designationTextField=new TextField();
    private TextField quantiteTextField=new TextField();
    private TextField prixTextField=new TextField();
    private DatePicker datePiecker=new DatePicker();
    private Button validerButton=new Button("Valider");
    private Button annulerButton=new Button("Annuler");
    ListProduitWindow listProduitWindow=null;


    private void addNodesToPane(){
        idHBox.getChildren().addAll(idLabel,idTextField);
        designationHBox.getChildren().addAll(designationLabel,designationTextField);
        quantiteHBox.getChildren().addAll(quantiteLabel,quantiteTextField);
        prixHBox.getChildren().addAll(prixLabel,prixTextField);
        dateHBox.getChildren().addAll(dateLabel,datePiecker);
        buttonsHBox.getChildren().addAll(validerButton,annulerButton);
        vBox.getChildren().addAll(idHBox,designationHBox,quantiteHBox,prixHBox,dateHBox,buttonsHBox);
        root.setCenter(vBox);
    }

    private void addStylesToNodes(){
        vBox.setPadding(new Insets(20));
    }

    private void addEventsToNodes(){
        validerButton.setOnAction(e->{
            Long id = Long.valueOf(idTextField.getText());
            String designation  = designationTextField.getText();
            Double prix = Double.valueOf(prixTextField.getText());
            Integer quantite = Integer.valueOf(quantiteTextField.getText());
            LocalDate date = datePiecker.getValue();
            new modifyProduitHandler(new Produit(id,designation,quantite,prix,date),listProduitWindow);
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

    public ModifyProduitWindow(ListProduitWindow listProduitsWindow) {
        listProduitWindow=listProduitsWindow;
        initiWindow();
        addNodesToPane();
        addEventsToNodes();
        addStylesToNodes();
        window.show();
    }
}
