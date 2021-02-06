package StoreManagement.IHM.Vente;

import StoreManagement.DAO.Produit.Produit;
import StoreManagement.DAO.Vente.LigneCommande;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FormVenteWindow {
    Stage window=new Stage();
    VBox rootVBox = new VBox(10);
    Scene scene=new Scene(rootVBox);

    StackPane tableStackPane = new StackPane();
    HBox buttonsHBox = new HBox(20);
    HBox bodyHBox = new HBox(5);
    VBox rightVBox = new VBox(5);
    VBox leftVBox = new VBox(10);
    VBox detailVenteInputVBox = new VBox(3);
    VBox detailVenteVBox = new VBox(3);
    VBox leftInputCommandeVBox = new VBox(5);
    VBox venteReglementVBOX = new VBox();
    VBox lignesCommendeVBOX = new VBox();
    VBox addCommandeVBox = new VBox(5);
    HBox inputCommandeHBox = new HBox();
    HBox rightInputCommandeHBox = new HBox();
    HBox rightInputCommandeButtonsHBox = new HBox(10);
    HBox numVenteHBox = new HBox();
    HBox clientHBox = new HBox();
    HBox dateHBox = new HBox();
    HBox codeProduitHBox = new HBox();
    HBox designationHBox = new HBox();
    HBox prixHBox = new HBox();
    HBox quantiteHBox = new HBox();
    TableView<Produit> produitTable = new TableView();
    TableView<LigneCommande> commandeTable = new TableView();

    Label venteDetailLabel = new Label("Détail de vente");
    Label numVenteLabel = new Label("N°Vente");
    Label clientLabel = new Label("Client: ");
    Label dateLabel = new Label("Date: ");
    Label codeProduitLabel = new Label("Code: ");
    Label designationLabel = new Label("Designation : ");
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
    TextField prixInput = new TextField();
    TextField quantiteInput = new TextField();

    Button enregistrerButton = new Button("Enregistrer");
    Button modifierButton = new Button("modifier");
    Button supprimerButton = new Button("Supprimer");
    Button quitterButton = new Button("Quitter");
    Button ajouterButton = new Button("+");
    Button annulerButton = new Button("-");

    TableColumn<Produit,Long> idColumn=new TableColumn<>("Id");
    TableColumn<Produit,String> designationColumn=new TableColumn<>("Designation");
    TableColumn<Produit,Double> prixAchatColumn=new TableColumn<>("prixAchat");
    TableColumn<Produit,Integer> quantiteColumn=new TableColumn<>("Quantité");
    TableColumn<Produit, Double> prixVenteColumn=new TableColumn<>("prixVente");
    TableColumn<Produit,String> categorieColumn=new TableColumn<>("Catégorie");

    ObservableList<Produit> productsObservableList = FXCollections.observableArrayList();
    ListProduitVenteHandler listProduitVenteHandler = new ListProduitVenteHandler(this);

    public ObservableList<Produit> getProductsObservableList() {
        return productsObservableList;
    }

    private void addNodesToPane(){
        buttonsHBox.getChildren().addAll(enregistrerButton,modifierButton,supprimerButton,quitterButton);

        numVenteHBox.getChildren().addAll(numVenteLabel,numVenteInput);
        clientHBox.getChildren().addAll(clientLabel,clientInput);
        dateHBox.getChildren().addAll(dateLabel,dateInput);
        detailVenteInputVBox.getChildren().addAll(numVenteHBox,clientHBox,dateHBox);
        detailVenteVBox.getChildren().addAll(venteDetailLabel,detailVenteInputVBox);

        codeProduitHBox.getChildren().addAll(codeProduitLabel,codeProduitInput);
        designationHBox.getChildren().addAll(designationLabel,designationInput);
        prixHBox.getChildren().addAll(prixLabel,prixInput);
        quantiteHBox.getChildren().addAll(quantiteLabel,quantiteInput);
        leftInputCommandeVBox.getChildren().addAll(detailVenteVBox,codeProduitHBox,designationHBox,prixHBox,quantiteHBox);
        rightInputCommandeButtonsHBox.getChildren().addAll(ajouterButton,annulerButton);
        rightInputCommandeHBox.getChildren().add(rightInputCommandeButtonsHBox);
        inputCommandeHBox.getChildren().addAll(leftInputCommandeVBox,rightInputCommandeHBox);
        tableStackPane.getChildren().add(produitTable);
        addCommandeVBox.getChildren().addAll(inputCommandeHBox,tableStackPane);
        addCommandeVBox.setMargin(inputCommandeHBox,new Insets(10,0,0,5));
        addCommandeVBox.setMargin(produitTable,new Insets(0,0,0,5));

        addCommandeVBox.setStyle("-fx-border-color: gray;\n" + "-fx-border-width: 0.5;");

        venteReglementVBOX.getChildren().addAll(venteReglementLabel,totalHTLabel,tva7Label,tva20Label,totalLabel);


        leftVBox.getChildren().addAll(detailVenteVBox,addCommandeVBox);
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

        leftVBox.getStyleClass().add("rightAndLeftVBox");
        rightVBox.getStyleClass().add("rightAndLeftVBox");
        detailVenteVBox.getStyleClass().add("venteDetailVBox");

        rightInputCommandeHBox.getStyleClass().add("btnHbox");
        rightInputCommandeHBox.setMargin(rightInputCommandeButtonsHBox,new Insets(10,10,0,50));

        ajouterButton.setStyle("-fx-font-size: 50px");
        annulerButton.setStyle("-fx-font-size: 50px");

        numVenteLabel.setMinWidth(100);
        clientLabel.setMinWidth(100);
        dateLabel.setMinWidth(100);
        codeProduitLabel.setMinWidth(100);
        designationLabel.setMinWidth(100);
        prixLabel.setMinWidth(100);
        quantiteLabel.setMinWidth(100);

        venteDetailLabel.setMinWidth(597);
        venteReglementLabel.setMinWidth(700);
        lignesCommandeLabel.setMinWidth(700);

    }

    private void initiWindow(){
        window.setWidth(1300);
        window.setHeight(820);
        window.setTitle("Gestion des ventes");
        window.getIcons().add(new Image("icone.png"));
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
    }

    private void updateColmuns(){
        idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        idColumn.setPrefWidth(100);

        designationColumn.setCellValueFactory(new PropertyValueFactory("designation"));
        designationColumn.setPrefWidth(250);

        prixAchatColumn.setCellValueFactory(new PropertyValueFactory("prixAchat"));
        prixAchatColumn.setPrefWidth(150);

        quantiteColumn.setCellValueFactory(new PropertyValueFactory("quantity"));
        quantiteColumn.setPrefWidth(170);

        prixVenteColumn.setCellValueFactory(new PropertyValueFactory("prixVente"));
        prixVenteColumn.setPrefWidth(200);

        categorieColumn.setCellValueFactory(new PropertyValueFactory("intituleCategorie"));
        categorieColumn.setPrefWidth(200);
    }

    void addProduitColumnsToTableView(){
        produitTable.getColumns().addAll(idColumn,designationColumn,prixAchatColumn,prixVenteColumn,quantiteColumn,categorieColumn);
        produitTable.setItems(productsObservableList);
    }

    public FormVenteWindow() {
        initiWindow();
        addStylesToNodes();
        updateColmuns();
        addProduitColumnsToTableView();
        listProduitVenteHandler.updateObservableProduitsList();
        addNodesToPane();
        //addEvents();
        window.show();
    }
}
