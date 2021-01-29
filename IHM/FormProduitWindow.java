package StoreManagement.IHM;

import StoreManagement.DAO.Produit;
import StoreManagement.DAO.ProduitDaoImpl;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

class FormProduitWindow {

    private VBox root=new VBox(10);
    private Scene scene=new Scene(root);
    private Stage window=new Stage();
    private Label titleLabel=new Label("Ajouter un produit");
    private Label designation=new Label("Designation :");
    private TextField designationInput= new TextField();
    private Label prix=new Label("Prix :");
    private TextField prixInput= new TextField();
    private Label quantite=new Label("Quantité :");
    private TextField quantiteInput= new TextField();
    private Label dateSaisie=new Label("Date saisie :");
    private DatePicker dateSaisieInput= new DatePicker();
    private Button ajouter=new Button("Ajouter");
    private Button annuler=new Button("Annuler");
    HBox buttonLine=new HBox(20);
    ProduitDaoImpl pdao=new ProduitDaoImpl();
    Produit produit=null;

    private void addStylesToNodes(){
        titleLabel.getStyleClass().add("sceneTitle");
        designation.getStyleClass().add("formLabel");
        quantite.getStyleClass().add("formLabel");
        dateSaisie.getStyleClass().add("formLabel");
        prix.getStyleClass().add("formLabel");
        scene.getStylesheets().add("/StoreManagement/style.css");
        ajouter.getStyleClass().add("btn");
        annuler.getStyleClass().add("btn");
        titleLabel.setMinWidth(window.getWidth());
    }

    private void addNodesToWindow(){
        buttonLine.getChildren().addAll(ajouter,annuler);
        root.getChildren().addAll(titleLabel,designation,designationInput,prix,prixInput,quantite,quantiteInput,dateSaisie,dateSaisieInput,buttonLine);
    }

    private void addEvents(){
        window.setOnCloseRequest(e->{
            e.consume();
        });
        ajouter.setOnAction(e ->{
            produit=new Produit(0,designationInput.getText(),Integer.parseInt(quantiteInput.getText()),Double.parseDouble(prixInput.getText()),dateSaisieInput.getValue());
            pdao.add(produit);
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

    FormProduitWindow(){
        initiWindow();
        addStylesToNodes();
        addNodesToWindow();
        addEvents();
        window.show();
    }

}
