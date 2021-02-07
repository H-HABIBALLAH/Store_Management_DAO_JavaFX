package StoreManagement.IHM.Vente;

import StoreManagement.DAO.Client.Client;
import StoreManagement.DAO.Produit.Produit;
import StoreManagement.DAO.Vente.LigneDeCommande;
import StoreManagement.DAO.Vente.Vente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FormVenteWindow {
    Vente vente = new Vente();
    LigneDeCommande ligneDeCommande = null;
    Produit produitClicked = null;
    Client client = null;

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

    TextField idProduitInput = new TextField();
    TextField designationInput = new TextField();
    TextField prixInput = new TextField();
    TextField quantiteInput = new TextField();

    Button enregistrerButton = new Button("Enregistrer");
    Button modifierButton = new Button("modifier");
    Button supprimerButton = new Button("Supprimer");
    Button quitterButton = new Button("Quitter");
    Button ajouterButton = new Button("+");
    Button annulerButton = new Button("-");

    TableView<Produit> produitTable = new TableView();
    TableColumn<Produit,Long> idColumnProduit=new TableColumn<>("Id");
    TableColumn<Produit,String> designationColumnProduit=new TableColumn<>("Designation");
    TableColumn<Produit,Double> prixAchatColumnProduit=new TableColumn<>("prixAchat");
    TableColumn<Produit,Integer> quantiteColumnProduit=new TableColumn<>("Quantité");
    TableColumn<Produit, Double> prixVenteColumnProduit=new TableColumn<>("prixVente");
    TableColumn<Produit,String> categorieColumnProduit=new TableColumn<>("Catégorie");
    ObservableList<Produit> productsObservableList = FXCollections.observableArrayList();

    TableView<LigneDeCommande> commandeTable = new TableView();
    TableColumn<LigneDeCommande,Long> idColumnCommande=new TableColumn<>("Id produit");
    TableColumn<LigneDeCommande,String> designationColumnCommande=new TableColumn<>("Produit Designation");
    TableColumn<LigneDeCommande, Double> prixColumnCommande=new TableColumn<>("Prix vente produit");
    TableColumn<LigneDeCommande,Integer> quantiteColumnCommande=new TableColumn<>("Qte");
    TableColumn<LigneDeCommande,String> sousTotalColumnCommande=new TableColumn<>("Sous total");
    ObservableList<Produit> commandeObservableList = FXCollections.observableArrayList();

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

        codeProduitHBox.getChildren().addAll(codeProduitLabel,idProduitInput);
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

    private void updateVenteDetailsInputs(){
        numVenteInput.setText(String.valueOf(vente.getNumero()));
        dateInput.setText(String.valueOf(vente.getDate()));
        clientInput.setText(vente.getClient().getPrenom()+" "+vente.getClient().getNom());
    }

    private void updateProduitInputs(Produit produitClicked){
        idProduitInput.setText(String.valueOf(produitClicked.getId()));
        designationInput.setText(String.valueOf(produitClicked.getDesignation()));
        prixInput.setText(String.valueOf(produitClicked.getPrixVente()));
        quantiteInput.setText("1");
    }

    private void clearProduitInputs(){
        idProduitInput.clear();
        designationInput.clear();;
        prixInput.clear();;
        quantiteInput.clear();;
    }

    private void updateProduitInfos(){

    }

    private void createLigneDeCommandeInfos(){
        ligneDeCommande=new LigneDeCommande(0,Integer.parseInt(quantiteInput.getText()),vente,produitClicked);
    }

    private void addEventsToNodes(){
        produitTable.setOnMouseClicked((MouseEvent e) ->{
            if(e.getClickCount() > 1){
                produitClicked = produitTable.getSelectionModel().getSelectedItem();
                updateProduitInputs(produitClicked);
            }
        });

        ajouterButton.setOnAction(e->{
            createLigneDeCommandeInfos();
            clearProduitInputs();
            new AddLigneDeCommandeHandler(ligneDeCommande,this);
        });
    }

    private void initiWindow(){
        window.setWidth(1300);
        window.setHeight(820);
        window.setTitle("Gestion des ventes");
        window.getIcons().add(new Image("icone.png"));
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
    }

    private void updateProduitColmuns(){
        idColumnProduit.setCellValueFactory(new PropertyValueFactory("id"));
        idColumnProduit.setPrefWidth(100);

        designationColumnProduit.setCellValueFactory(new PropertyValueFactory("designation"));
        designationColumnProduit.setPrefWidth(250);

        prixAchatColumnProduit.setCellValueFactory(new PropertyValueFactory("prixAchat"));
        prixAchatColumnProduit.setPrefWidth(150);

        quantiteColumnProduit.setCellValueFactory(new PropertyValueFactory("quantity"));
        quantiteColumnProduit.setPrefWidth(170);

        prixVenteColumnProduit.setCellValueFactory(new PropertyValueFactory("prixVente"));
        prixVenteColumnProduit.setPrefWidth(200);

        categorieColumnProduit.setCellValueFactory(new PropertyValueFactory("intituleCategorie"));
        categorieColumnProduit.setPrefWidth(200);
    }

    void addProduitColumnsToTableView(){
        produitTable.getColumns().addAll(idColumnProduit,designationColumnProduit,prixAchatColumnProduit,prixVenteColumnProduit,quantiteColumnProduit,categorieColumnProduit);
        produitTable.setItems(productsObservableList);
    }

    void updateCommandeColmuns(){
        idColumnProduit.setCellValueFactory(new PropertyValueFactory("id"));
        idColumnProduit.setPrefWidth(100);

        designationColumnProduit.setCellValueFactory(new PropertyValueFactory("designation"));
        designationColumnProduit.setPrefWidth(250);

        prixAchatColumnProduit.setCellValueFactory(new PropertyValueFactory("prixAchat"));
        prixAchatColumnProduit.setPrefWidth(150);

        quantiteColumnProduit.setCellValueFactory(new PropertyValueFactory("quantity"));
        quantiteColumnProduit.setPrefWidth(170);

        prixVenteColumnProduit.setCellValueFactory(new PropertyValueFactory("prixVente"));
        prixVenteColumnProduit.setPrefWidth(200);

        categorieColumnProduit.setCellValueFactory(new PropertyValueFactory("intituleCategorie"));
        categorieColumnProduit.setPrefWidth(200);
    }

    void addCommandeColumnsToTableView(ObservableList<LigneDeCommande> commandeObservableList){
        commandeTable.getColumns().addAll(idColumnCommande,designationColumnCommande,prixColumnCommande,quantiteColumnCommande,sousTotalColumnCommande);
        commandeTable.setItems(commandeObservableList);
    }

    public FormVenteWindow(Client client) {
        vente.setClient(client);
        initiWindow();
        addStylesToNodes();
        updateProduitColmuns();
        addProduitColumnsToTableView();
        updateVenteDetailsInputs();
        listProduitVenteHandler.updateObservableProduitsList();
        addNodesToPane();
        addEventsToNodes();
        window.show();
    }
}
