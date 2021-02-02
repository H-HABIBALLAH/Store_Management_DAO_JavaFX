package StoreManagement.IHM.Produit;

import StoreManagement.DAO.Catégorie.Categorie;
import StoreManagement.DAO.Produit.Produit;
import StoreManagement.DAO.Produit.ProduitDaoImpl;
import StoreManagement.IHM.Catégorie.CategorieWindow;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FormProduitWindow {

    private VBox vboxForm=new VBox(20);
    private VBox vboxParent=new VBox();
    private Scene scene=new Scene(vboxParent);
    Stage window=new Stage();
    private Label titleLabel=new Label("Ajouter un produit");
    private Label designation=new Label("Designation :");
    private TextField designationInput= new TextField();
    private Label prixAchat=new Label("prixAchat :");
    private TextField prixAchatInput= new TextField();
    private TextField prixVenteInput= new TextField();
    private Label quantite=new Label("Quantité :");
    private TextField quantiteInput= new TextField();
    private Label prixVente=new Label("prixVente :");
    private Button ajouter=new Button("Ajouter");
    private Button annuler=new Button("Annuler");
    private Button afficherCategorieButton=new Button("Catégorie");
    HBox buttonLine=new HBox(40);
    HBox hboxTitle=new HBox();
    Produit produit=null;
    Categorie categorie=new Categorie(0,"");

    private void addStylesToNodes(){
        titleLabel.getStyleClass().add("sceneTitle");
        designation.getStyleClass().add("formLabel");
        quantite.getStyleClass().add("formLabel");
        prixVente.getStyleClass().add("formLabel");
        prixAchat.getStyleClass().add("formLabel");
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
        vboxForm.getChildren().addAll(designation,designationInput,prixAchat,prixAchatInput,prixVente,prixVenteInput,quantite,quantiteInput,afficherCategorieButton,buttonLine);
        vboxParent.getChildren().addAll(hboxTitle,vboxForm);
    }

    private void addEvents(){
        window.setOnCloseRequest(e->{
            e.consume();
        });
        afficherCategorieButton.setOnAction(e->{
            new CategorieWindow(categorie);
        });
        ajouter.setOnAction(e ->{
            produit=new Produit(0,designationInput.getText(),Integer.parseInt(quantiteInput.getText()),Double.parseDouble(prixAchatInput.getText()),Double.parseDouble(prixVenteInput.getText()),categorie);
            new FormProduitHandler(produit,this);
        });
        annuler.setOnAction(e -> {
            window.close();
        });
    }

    private void initiWindow(){
        window.setWidth(700);
        window.setHeight(700);
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
    }

    public FormProduitWindow(){
        initiWindow();
        addStylesToNodes();
        addNodesToWindow();
        window.setTitle("Ajouter produit");
        window.getIcons().add(new Image("icone.png"));
        addEvents();
        window.show();
    }

}
