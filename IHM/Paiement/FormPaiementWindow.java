package StoreManagement.IHM.Paiement;

import StoreManagement.DAO.Paiement.Paiement;
import StoreManagement.DAO.Vente.Vente;
import StoreManagement.IHM.Compte.FormPaiementCardWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;

public class FormPaiementWindow {
    GetLastPaiementNumHandler getLastPaiementNumHandler;
    long numPaiementInDB;
    int clickedPaiementIndex = 0;
    private Vente vente = null;
    private Paiement paiementClicked;

    GridPane root = new GridPane();
    private Stage window=new Stage();
    private Scene scene=new Scene(root);

    private GridPane leftGridPane = new GridPane();
    private GridPane rightGridPane = new GridPane();
    private GridPane venteDetailLabelGridPane = new GridPane();
    private GridPane venteDetailInfoGridPane = new GridPane();
    private GridPane venteDetailGridPane = new GridPane();
    private GridPane paiementGridPane = new GridPane();
    private GridPane paiementDetailGridPane = new GridPane();
    private GridPane paiementDetailInputGridPane = new GridPane();
    private GridPane paiementDetailLabelGridPane = new GridPane();


    private Label venteDetailLabel = new Label("Détail de vente");
    private Label clientLabel = new Label("Client : ");
    private Label numVenteLabel = new Label("N° Vente : ");
    private Label dateLabel = new Label("Date : ");
    private Label montantLabel = new Label("Montant : ");
    private Label totalLabel = new Label("Total : ");
    private Label totalPayeLabel = new Label("Total payé : 0.0");
    private Label resteLabel = new Label("Reste : ");
    private Label paiementLabel = new Label("Paiements");
    private Label paiementDetailLabel = new Label("Détail de paiements");

    private TextField numeroPaiementInput = new TextField();
    private DatePicker dateInput = new DatePicker();
    private TextField montantInput = new TextField();
    private String s[] = { "Espèce", "Chèque", "Carte"};
    private ChoiceBox choiceBox = new ChoiceBox(FXCollections.observableArrayList(s));


    private Button enregistrerButton = new Button("Enregistrer");
    private Button modifierButton = new Button("modifier");
    private Button reglementButton = new Button("Règlements");
    private Button quitterButton = new Button("Quitter");
    private Button ajouterCommandeButton = new Button("+");
    private Button supprimerCommandeButton = new Button("-");

    private TableView<Paiement> paiementTable = new TableView();
    private TableColumn<Paiement,Long> numeroColumn=new TableColumn<>("N°");
    private TableColumn<Paiement, Double> montantColumn=new TableColumn<>("Montant");
    private TableColumn<Paiement, LocalDate> dateColumn=new TableColumn<>("Date");
    private TableColumn<Paiement,String> typeColumn=new TableColumn<>("Type");
    private TableColumn<Paiement,Long> numeroChequeColumn=new TableColumn<>("N° Chèque");
    private TableColumn<Paiement,String> proprietaireColumn=new TableColumn<>("Propriétaire");
    private TableColumn<Paiement,String> banqueColumn=new TableColumn<>("Banque");
    private ObservableList<Paiement> paiementObservableList = FXCollections.observableArrayList();


    //ListProduitVenteHandler listProduitVenteHandler = new ListProduitVenteHandler(this);



    public ObservableList<Paiement> getPaiementObservableList() {
        return paiementObservableList;
    }

    private void addNodesToPane(){
        venteDetailLabelGridPane.add(venteDetailLabel,0,0);
        venteDetailInfoGridPane.add(numVenteLabel,0,1);
        venteDetailInfoGridPane.add(clientLabel,0,2);
        venteDetailInfoGridPane.add(dateLabel,0,3);
        venteDetailInfoGridPane.add(totalLabel,0,4);
        venteDetailInfoGridPane.add(totalPayeLabel,0,5);
        venteDetailInfoGridPane.add(resteLabel,0,6);
        venteDetailGridPane.add(venteDetailLabelGridPane,0,0);
        venteDetailGridPane.add(venteDetailInfoGridPane,0,1);

        paiementGridPane.add(paiementLabel,0,0);
        paiementGridPane.add(paiementTable,0,1);

        leftGridPane.add(venteDetailGridPane,0,0);
        leftGridPane.add(paiementGridPane,0,1);

        paiementDetailLabelGridPane.add(paiementDetailLabel,0,0);
        paiementDetailInputGridPane.add(new Label("N°"),0,1);
        paiementDetailInputGridPane.add(numeroPaiementInput,0,2);
        paiementDetailInputGridPane.add(new Label("Montant : "),0,3);
        paiementDetailInputGridPane.add(montantInput,0,4);
        paiementDetailInputGridPane.add(new Label("Date : "),0,5);
        paiementDetailInputGridPane.add(dateInput,0,6);
        paiementDetailInputGridPane.add(new Label("Type : "),0,7);
        paiementDetailInputGridPane.add(choiceBox,0,8);
        paiementDetailInputGridPane.add(enregistrerButton,0,9);
        paiementDetailGridPane.add(paiementDetailLabelGridPane,0,0);
        paiementDetailGridPane.add(paiementDetailInputGridPane,0,1);

        rightGridPane.add(paiementDetailGridPane,0,0);

        root.add(leftGridPane,0,0);
        root.add(rightGridPane,1,0);
    }

    private void updatePaiementInput(){
        getLastPaiementNumHandler = new GetLastPaiementNumHandler();
        numPaiementInDB = getLastPaiementNumHandler.getNum();
        this.numeroPaiementInput.setText(String.valueOf(numPaiementInDB+1));
        numeroPaiementInput.setDisable(true);
        montantInput.clear();
        dateInput.setValue(null);
        choiceBox.getSelectionModel().clearSelection();
    }

    private void addStylesToNodes(){
        scene.getStylesheets().add("/StoreManagement/style.css");
        enregistrerButton.getStyleClass().add("btn");
        modifierButton.getStyleClass().add("btn");
        reglementButton.getStyleClass().add("btn");
        quitterButton.getStyleClass().add("btn");
        ajouterCommandeButton.getStyleClass().add("btn");
        supprimerCommandeButton.getStyleClass().add("btn");

        numVenteLabel.setStyle("-fx-font-size: 20;");
        clientLabel.setStyle("-fx-font-size: 20;");
        dateLabel.setStyle("-fx-font-size: 20; ");
        totalLabel.setStyle("-fx-font-size: 20; ");
        totalPayeLabel.setStyle("-fx-font-size: 20; ");
        resteLabel.setStyle("-fx-font-size: 20; ");

        venteDetailLabel.getStyleClass().add("venteTitleLabel");
        paiementLabel.getStyleClass().add("venteTitleLabel");
        paiementDetailLabel.getStyleClass().add("venteTitleLabel");

        root.setHgap(3);
        venteDetailGridPane.setVgap(5);
        paiementDetailInputGridPane.setVgap(10);
        venteDetailInfoGridPane.setPadding(new Insets(0,0,0,5));
        paiementDetailInputGridPane.setPadding(new Insets(0,100,0,10));
        paiementDetailGridPane.setVgap(5);

        leftGridPane.setStyle("-fx-border-width: 1; -fx-border-color: gray");

        venteDetailLabel.setMinWidth(800);
        paiementLabel.setMinWidth(800);
        paiementDetailLabel.setMinWidth(300);
    }

    double totalPaye;
    private void updateVenteDetailsInfos(){
        clientLabel.setText("Client :  "+vente.getClient().getPrenom()+" "+vente.getClient().getNom());
        numVenteLabel.setText("N°Vente :  "+vente.getNumero());
        totalLabel.setText("Total :  "+vente.getTotal());
        dateLabel.setText("Date :  "+vente.getDate());
        if(!montantInput.getText().isEmpty())
        {   totalPaye = 0;
            for (Paiement paiement : paiementObservableList) totalPaye += paiement.getMontant();
            totalPayeLabel.setText("Total payé :  "+totalPaye);
            resteLabel.setText("Reste :  "+(vente.getTotal()-totalPaye));
        }
    }

    private Paiement createPaiementFromInputs(){
        long numero = Long.valueOf(numeroPaiementInput.getText());
        double montant = Double.valueOf(montantInput.getText());
        LocalDate date = dateInput.getValue();
        String type =  choiceBox.getValue().toString();
        return new Paiement(numero, date, montant, type, vente);
    }

    public void addPaiementLine(){
        Paiement paiement = createPaiementFromInputs();
        new AddPaiementHandler(vente, paiement);
        paiementObservableList.add(paiement);
        updateVenteDetailsInfos();
        updatePaiementColmuns();
        addPaimentColumnsToTableView(paiementObservableList);
        updatePaiementInput();
    }

    public TextField getMontantInput() {
        return montantInput;
    }

    private void addEventsToNodes(){
        paiementTable.setOnMouseClicked((MouseEvent e) ->{
            if(e.getClickCount() == 1){
                paiementClicked = paiementTable.getSelectionModel().getSelectedItem();
                clickedPaiementIndex = paiementTable.getSelectionModel().getSelectedIndex();
            }
        });

        enregistrerButton.setOnAction(e->{
            if(choiceBox.getSelectionModel().isSelected(2)) {
                FormPaiementCardWindow formPaiementCardWindow = new FormPaiementCardWindow(montantInput.getText(),this);
                }
            else
                addPaiementLine();
        });
    }

    private void initiWindow(){
        window.setWidth(1100);
        window.setHeight(800);
        window.setTitle("Gestion des ventes");
        window.getIcons().add(new Image("icone.png"));
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
    }

    private void updatePaiementColmuns(){
        numeroColumn.setCellValueFactory(new PropertyValueFactory("numero"));
        numeroColumn.setPrefWidth(100);

        dateColumn.setCellValueFactory(new PropertyValueFactory("date"));
        dateColumn.setPrefWidth(100);

        montantColumn.setCellValueFactory(new PropertyValueFactory("montant"));
        montantColumn.setPrefWidth(150);

        typeColumn.setCellValueFactory(new PropertyValueFactory("type"));
        typeColumn.setPrefWidth(170);

        numeroChequeColumn.setCellValueFactory(new PropertyValueFactory("numCheque"));
        numeroChequeColumn.setPrefWidth(200);

        proprietaireColumn.setCellValueFactory(new PropertyValueFactory("chequeProprietaire"));
        proprietaireColumn.setPrefWidth(200);

        banqueColumn.setCellValueFactory(new PropertyValueFactory("chequeBanque"));
        banqueColumn.setPrefWidth(200);
    }

    public void addPaimentColumnsToTableView(ObservableList<Paiement> paiementObservableList){
        paiementTable.getColumns().clear();
        paiementTable.getColumns().addAll(numeroColumn,montantColumn,dateColumn,typeColumn,numeroChequeColumn);
        paiementTable.setItems(paiementObservableList);
    }

    public FormPaiementWindow(Vente vente) {
        this.vente = vente;
        updateVenteDetailsInfos();
        updatePaiementInput();
        resteLabel = new Label("Reste : "+vente.getTotal());
        initiWindow();
        addStylesToNodes();
        addPaimentColumnsToTableView(paiementObservableList);
        updatePaiementColmuns();
        updateVenteDetailsInfos();
        addNodesToPane();
        addEventsToNodes();
        window.show();
    }
}
