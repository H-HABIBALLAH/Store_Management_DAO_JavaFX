package StoreManagement.IHM.Vente;

import StoreManagement.DAO.Produit.Produit;
import StoreManagement.DAO.Vente.LigneCommande;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FormVenteWindow {
    Stage window=new Stage();
    VBox rootVBox = new VBox();
    Scene scene=new Scene(rootVBox);

    HBox buttonsHBox = new HBox(20);
    HBox bodyHBox = new HBox(5);
    VBox rightVBox = new VBox(5);
    VBox leftVBox = new VBox(5);
    VBox detailVentVBox = new VBox(3);
    VBox inputCommandeVBox = new VBox();
    VBox leftInputCommandeVBox = new VBox();
    VBox rightInputCommandeVBox = new VBox();
    VBox venteReglementVBOX = new VBox();
    VBox lignesCommendeVBOX = new VBox();
    HBox addCommandeHBox = new HBox();
    HBox numVenteHBox = new HBox();
    HBox clientHBox = new HBox();
    HBox dateHBox = new HBox();
    HBox codeProduitHBox = new HBox();
    HBox designationHBox = new HBox();
    HBox numSerieHBox = new HBox();
    HBox prixHBox = new HBox();
    HBox quantiteHBox = new HBox();
    TableView<Produit> produitTable = new TableView();
    TableView<LigneCommande> commandeTable = new TableView();

    Label venteDetailLabel = new Label("Détail de vente");
    Label numVenteLabel = new Label("N°Vente");
    Label clientLabel = new Label("Client: ");
    Label dateLabel = new Label("Date: ");
    Label codeProduitLabel = new Label("Code: ");
    Label designationLabel = new Label("Design: ");
    Label numSerieLabel = new Label("N°Série: ");
    Label prixLabel = new Label("Prix: ");
    Label quantiteLabel = new Label("QTE: ");
    Label venteReglementLabel = new Label("Règlement de vente");
    Label totalHTLabel = new Label("Total HT: ");
    Label tva7Label = new Label("TVA 7%: ");
    Label tva20Label = new Label("TVA 20%: ");
    Label totalLabel = new Label("Total: ");
    Label lignesCommandeLabel = new Label("Lignes de commande");

    TextField numVenteInput = new TextField();
    TextField clientInput = new TextField();
    TextField dateInput = new TextField();
    TextField codeProduitInput = new TextField();
    TextField designationInput = new TextField();
    TextField numSerieInput = new TextField();
    TextField prixInput = new TextField();
    TextField quantiteInput = new TextField();

    Button enregistrerButton = new Button("Enregistrer");
    Button modifierButton = new Button("modifier");
    Button supprimerButton = new Button("Supprimer");
    Button quitterButton = new Button("Quitter");
    Button ajouterButton = new Button("+");
    Button annulerButton = new Button("-");

    private void addNodesToPane(){
        buttonsHBox.getChildren().addAll(enregistrerButton,modifierButton,supprimerButton,quitterButton);

        numVenteHBox.getChildren().addAll(numVenteLabel,numVenteInput);
        clientHBox.getChildren().addAll(clientLabel,clientInput);
        dateHBox.getChildren().addAll(dateLabel,dateInput);
        detailVentVBox.getChildren().addAll(venteDetailLabel,numVenteHBox,clientHBox,dateHBox);

        codeProduitHBox.getChildren().addAll(codeProduitLabel,codeProduitInput);
        designationHBox.getChildren().addAll(designationLabel,designationInput);
        numSerieHBox.getChildren().addAll(numSerieLabel,numSerieInput);
        prixHBox.getChildren().addAll(prixLabel,prixInput);
        quantiteHBox.getChildren().addAll(quantiteLabel,quantiteInput);
        leftInputCommandeVBox.getChildren().addAll(codeProduitHBox,designationHBox,numSerieHBox,prixHBox,quantiteHBox);
        rightInputCommandeVBox.getChildren().addAll(ajouterButton,annulerButton);
        addCommandeHBox.getChildren().addAll(leftInputCommandeVBox,rightInputCommandeVBox);

        venteReglementVBOX.getChildren().addAll(venteReglementLabel,totalHTLabel,tva7Label,tva20Label,totalLabel);

        leftVBox.getChildren().addAll(venteDetailLabel,detailVentVBox,addCommandeHBox,produitTable);
        rightVBox.getChildren().addAll(venteReglementVBOX,lignesCommandeLabel,commandeTable);
        bodyHBox.getChildren().addAll(leftVBox,rightVBox);
        rootVBox.getChildren().addAll(buttonsHBox,bodyHBox);
    }

    private void addStylesToNodes(){
        leftVBox.setMinWidth(600);
        rightVBox.setMinWidth(700);
        scene.getStylesheets().add("/StoreManagement/style.css");
        buttonsHBox.getStyleClass().add("btnHbox");
        enregistrerButton.getStyleClass().add("btn");
        modifierButton.getStyleClass().add("btn");
        supprimerButton.getStyleClass().add("btn");
        quitterButton.getStyleClass().add("btn");
        ajouterButton.getStyleClass().add("btn");
        annulerButton.getStyleClass().add("btn");

        lignesCommandeLabel.getStyleClass().add("venteTitleLabel");
        venteDetailLabel.getStyleClass().add("venteTitleLabel");
        venteReglementLabel.getStyleClass().add("venteTitleLabel");



        venteDetailLabel.setMinWidth(600);
        venteReglementLabel.setMinWidth(700);
        lignesCommandeLabel.setMinWidth(700);

    }

    private void initiWindow(){
        window.setWidth(1300);
        window.setHeight(1000);
        window.setTitle("Gestion des ventes");
        window.getIcons().add(new Image("icone.png"));
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
    }

    public FormVenteWindow() {
        initiWindow();
        addStylesToNodes();
        //updateColmuns();
        //addColumnsToTableView(clientsObservableList);
        //ClientsListHandler.updateClientsListWIndow();
        addNodesToPane();
        //addEvents();
        window.show();
    }
}
