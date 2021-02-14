package StoreManagement.IHM.Vente;

import StoreManagement.DAO.Client.Client;
import StoreManagement.DAO.Produit.Produit;
import StoreManagement.DAO.LigneDeCommande.LigneDeCommande;
import StoreManagement.DAO.Vente.Vente;
import StoreManagement.IHM.LigneDeCommande.AddLigneDeCommandeHandler;
import StoreManagement.IHM.LigneDeCommande.ModifyCommandeWindow;
import StoreManagement.IHM.Paiement.DeleteAllPaiementHandler;
import StoreManagement.IHM.Paiement.FormPaiementWindow;
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
    Client client;
    GetLastVenteNumHandler getLastVenteNumHandler = new GetLastVenteNumHandler();
    long venteNumInDB = getLastVenteNumHandler.getNum();
    private Vente vente;
    private LigneDeCommande ligneDeCommande;
    private Produit produitClicked;
    private LigneDeCommande ligneDeCommandeClicked;

    private Stage window=new Stage();
    private VBox rootVBox = new VBox(10);
    private Scene scene=new Scene(rootVBox);

    private StackPane tableStackPane = new StackPane();
    private HBox buttonsHBox = new HBox(20);
    private HBox bodyHBox = new HBox(5);
    private VBox rightVBox = new VBox(5);
    private VBox leftVBox = new VBox(10);
    private VBox detailVenteInputVBox = new VBox(3);
    private VBox detailVenteVBox = new VBox(3);
    private VBox leftInputCommandeVBox = new VBox(5);
    private VBox venteReglementVBOX = new VBox();
    private VBox addCommandeVBox = new VBox(5);
    private HBox inputCommandeHBox = new HBox();
    private HBox rightInputCommandeHBox = new HBox();
    private HBox rightInputCommandeButtonsHBox = new HBox(10);
    private HBox numVenteHBox = new HBox();
    private HBox clientHBox = new HBox();
    private HBox dateHBox = new HBox();
    private HBox codeProduitHBox = new HBox();
    private HBox designationHBox = new HBox();
    private HBox prixHBox = new HBox();
    private HBox quantiteHBox = new HBox();

    private Label venteDetailLabel = new Label("Détail de vente");
    private Label numVenteLabel = new Label("N° Vente : "+venteNumInDB);
    private Label clientLabel = new Label("Client: ");
    private Label dateLabel = new Label("Date: ");
    private Label codeProduitLabel = new Label("Code: ");
    private Label designationLabel = new Label("Designation : ");
    private Label prixLabel = new Label("Prix: ");
    private Label quantiteLabel = new Label("QTE: ");
    private Label venteReglementLabel = new Label("Règlement de vente");
    private Label totalLabel = new Label("Total: ");
    private Label lignesCommandeLabel = new Label("Lignes de commande");

    private TextField idProduitInput = new TextField();
    private TextField designationInput = new TextField();
    private TextField prixInput = new TextField();
    private TextField quantiteInput = new TextField();

    private Button enregistrerButton = new Button("Enregistrer");
    private Button modifierButton = new Button("modifier");
    private Button reglementButton = new Button("Règlements");
    private Button quitterButton = new Button("Quitter");
    private Button ajouterCommandeButton = new Button("+");
    private Button supprimerCommandeButton = new Button("-");

    private TableView<Produit> produitTable = new TableView();
    private TableColumn<Produit,Long> idColumnProduit=new TableColumn<>("Id");
    private TableColumn<Produit,String> designationColumnProduit=new TableColumn<>("Designation");
    private TableColumn<Produit,Double> prixAchatColumnProduit=new TableColumn<>("prixAchat");
    private TableColumn<Produit,Integer> quantiteColumnProduit=new TableColumn<>("Quantité");
    private TableColumn<Produit, Double> prixVenteColumnProduit=new TableColumn<>("prixVente");
    private TableColumn<Produit,String> categorieColumnProduit=new TableColumn<>("Catégorie");
    private ObservableList<Produit> productsObservableList = FXCollections.observableArrayList();

    private TableView<LigneDeCommande> commandeTable = new TableView();
    private TableColumn<LigneDeCommande,Long> idColumnCommande=new TableColumn<>("Id produit");
    private TableColumn<LigneDeCommande,String> designationColumnCommande=new TableColumn<>("Produit Designation");
    private TableColumn<LigneDeCommande, Double> prixColumnCommande=new TableColumn<>("Prix");
    private TableColumn<LigneDeCommande,Integer> quantiteColumnCommande=new TableColumn<>("Qte");
    private TableColumn<LigneDeCommande,String> sousTotalColumnCommande=new TableColumn<>("Sous total");
    public ObservableList<LigneDeCommande> commandeObservableList = FXCollections.observableArrayList();

    ListProduitVenteHandler listProduitVenteHandler = new ListProduitVenteHandler(this);


    public ObservableList<Produit> getProductsObservableList() {
        return productsObservableList;
    }

    private void addNodesToPane(){
        buttonsHBox.getChildren().addAll(enregistrerButton,modifierButton,reglementButton,quitterButton);

        clientHBox.getChildren().addAll(clientLabel);
        dateHBox.getChildren().addAll(dateLabel);
        detailVenteInputVBox.getChildren().addAll(numVenteLabel,numVenteHBox,clientHBox,dateHBox);
        detailVenteVBox.getChildren().addAll(venteDetailLabel,detailVenteInputVBox);

        codeProduitHBox.getChildren().addAll(codeProduitLabel,idProduitInput);
        designationHBox.getChildren().addAll(designationLabel,designationInput);
        prixHBox.getChildren().addAll(prixLabel,prixInput);
        quantiteHBox.getChildren().addAll(quantiteLabel,quantiteInput);
        leftInputCommandeVBox.getChildren().addAll(detailVenteVBox,codeProduitHBox,designationHBox,prixHBox,quantiteHBox);
        rightInputCommandeButtonsHBox.getChildren().addAll(ajouterCommandeButton,supprimerCommandeButton);
        rightInputCommandeHBox.getChildren().add(rightInputCommandeButtonsHBox);
        inputCommandeHBox.getChildren().addAll(leftInputCommandeVBox,rightInputCommandeHBox);
        tableStackPane.getChildren().add(produitTable);
        addCommandeVBox.getChildren().addAll(inputCommandeHBox,tableStackPane);
        addCommandeVBox.setMargin(inputCommandeHBox,new Insets(10,0,0,5));
        addCommandeVBox.setMargin(produitTable,new Insets(0,0,0,5));

        addCommandeVBox.setStyle("-fx-border-color: gray;\n" + "-fx-border-width: 0.5;");

        venteReglementVBOX.getChildren().addAll(venteReglementLabel,totalLabel);


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
        reglementButton.getStyleClass().add("btn");
        quitterButton.getStyleClass().add("btn");
        ajouterCommandeButton.getStyleClass().add("btn");
        supprimerCommandeButton.getStyleClass().add("btn");

        numVenteLabel.setStyle("-fx-font-size: 20;");
        clientLabel.setStyle("-fx-font-size: 20;");
        dateLabel.setStyle("-fx-font-size: 20; ");

        lignesCommandeLabel.getStyleClass().add("venteTitleLabel");
        venteDetailLabel.getStyleClass().add("venteTitleLabel");
        venteReglementLabel.getStyleClass().add("venteTitleLabel");

        totalLabel.setStyle("-fx-font-size: 40");

        leftVBox.getStyleClass().add("rightAndLeftVBox");
        rightVBox.getStyleClass().add("rightAndLeftVBox");
        detailVenteVBox.getStyleClass().add("venteDetailVBox");

        rightInputCommandeHBox.getStyleClass().add("btnHbox");
        rightInputCommandeHBox.setMargin(rightInputCommandeButtonsHBox,new Insets(10,10,0,50));

        ajouterCommandeButton.setStyle("-fx-font-size: 50px");
        supprimerCommandeButton.setStyle("-fx-font-size: 50px");

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
        dateLabel.setText("Date :  "+vente.getDate());
        clientLabel.setText("Client :  "+vente.getClient().getPrenom()+" "+vente.getClient().getNom());
    }

    private void updateProduitInputs(Produit produitClicked){
        idProduitInput.setText(String.valueOf(produitClicked.getId()));
        designationInput.setText(String.valueOf(produitClicked.getDesignation()));
        prixInput.setText(String.valueOf(produitClicked.getPrixVente()));
        quantiteInput.setText("1");
    }

    private void clearProduitInputs(){
        idProduitInput.clear();
        designationInput.clear();
        prixInput.clear();
        quantiteInput.clear();
    }

    private void createLigneDeCommande(){
        ligneDeCommande = new LigneDeCommande(0,Integer.valueOf(quantiteInput.getText()),vente,produitClicked);
    }

    LigneDeCommande ligneDeCommandeExisting;
    int index = 0;
    int clickedCommandeIndex = 0;

    private Boolean produitExistInTable(){
        for (int i = 0; i < commandeTable.getItems().size(); i++) {
            ligneDeCommandeExisting = commandeTable.getItems().get(i);
            if (produitClicked.getId() == idColumnCommande.getCellObservableValue(ligneDeCommandeExisting).getValue()) {
                index = i;
                return true;
            }
        }
        return false;
    }

    private void addCommandeToObservableList(LigneDeCommande ligneDeCommande){
        if(produitExistInTable()){
            int newQte = Integer.valueOf(quantiteInput.getText())+ligneDeCommandeExisting.getQte();
            ligneDeCommande.setQte(newQte);
            commandeTable.getItems().set(index, ligneDeCommande);
            vente.getLigneCommandeList().get(index).setQte(newQte);
            updateTotalValue();
        }
        else{
            vente.getLigneCommandeList().add(ligneDeCommande);
            updateTotalValue();
            commandeObservableList.add(ligneDeCommande);
        }
    }

    private void updateTotalValue(){
        totalLabel.setText("Total :  "+vente.getTotal());
    }

    private void addEventsToNodes(){
        window.setOnCloseRequest(e->{
            e.consume();
        });

        produitTable.setOnMouseClicked((MouseEvent e) ->{
            if(e.getClickCount() > 1){
                produitClicked = produitTable.getSelectionModel().getSelectedItem();
                updateProduitInputs(produitClicked);
            }
        });

        ajouterCommandeButton.setOnAction(e->{
            createLigneDeCommande();
            addCommandeToObservableList(ligneDeCommande);
            clearProduitInputs();
            updateCommandeColmuns();
            addCommandeColumnsToTableView(commandeObservableList);
        });

        supprimerCommandeButton.setOnAction(e->{
            vente.getLigneCommandeList().remove(clickedCommandeIndex);
            System.out.println(vente.getLigneCommandeList());
            updateTotalValue();
            commandeObservableList.remove(ligneDeCommandeClicked);
            updateCommandeColmuns();
        });

        commandeTable.setOnMouseClicked((MouseEvent e) ->{
            if(e.getClickCount() == 1){
                ligneDeCommandeClicked = commandeTable.getSelectionModel().getSelectedItem();
                clickedCommandeIndex = commandeTable.getSelectionModel().getSelectedIndex();
            }
        });

        enregistrerButton.setOnAction(e->{
            new UpdateVenteHandler(vente);
            for(LigneDeCommande ligneDeCommande : commandeTable.getItems()){
                ligneDeCommande.getVente().setNumero(vente.getNumero());
                new AddLigneDeCommandeHandler(ligneDeCommande);
            }
            window.close();
        });

        modifierButton.setOnAction(e->{
            new ModifyCommandeWindow(ligneDeCommandeClicked,this);
        });

        reglementButton.setOnAction(e->{
            new FormPaiementWindow(vente);
        });

        quitterButton.setOnAction(e->{
            new DeleteAllPaiementHandler(vente.getNumero());
            new DeleteVenteHandler(vente.getNumero(),client.getCode(),null);
            window.close();
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

    public void updateCommandeColmuns(){
            idColumnCommande.setCellValueFactory(new PropertyValueFactory("produitId"));
            idColumnCommande.setPrefWidth(100);

            designationColumnCommande.setCellValueFactory(new PropertyValueFactory("produitDesignation"));
            designationColumnCommande.setPrefWidth(200);

            prixColumnCommande.setCellValueFactory(new PropertyValueFactory("produitPrixVente"));
            prixColumnCommande.setPrefWidth(100);

            quantiteColumnCommande.setCellValueFactory(new PropertyValueFactory("qte"));
            quantiteColumnCommande.setPrefWidth(70);

            sousTotalColumnCommande.setCellValueFactory(new PropertyValueFactory("sousTotal"));
            sousTotalColumnCommande.setPrefWidth(100);
    }

    public void addCommandeColumnsToTableView(ObservableList<LigneDeCommande> commandeObservableList){
        commandeTable.getColumns().clear();
        commandeTable.getColumns().addAll(idColumnCommande,designationColumnCommande,prixColumnCommande,quantiteColumnCommande,sousTotalColumnCommande);
        commandeTable.setItems(commandeObservableList);
    }

    public FormVenteWindow(Client client) {
        this.client = client;
        vente = new Vente(venteNumInDB,client);
        initiWindow();
        addStylesToNodes();
        addProduitColumnsToTableView();
        updateProduitColmuns();
        updateVenteDetailsInputs();
        listProduitVenteHandler.updateObservableProduitsList();
        addNodesToPane();
        addEventsToNodes();
        window.show();
    }
}
