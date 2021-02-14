package StoreManagement.IHM.Paiement;

import StoreManagement.DAO.Paiement.Paiement;
import StoreManagement.DAO.Vente.Vente;
import StoreManagement.IHM.Paiement.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Date;

public class ListPaiementWindow {

    Vente vente = null;
    Stage window = new Stage();
    private VBox root=new VBox();
    private Scene scene=new Scene(root);
    private Label titleLabel=new Label("La liste des Paiements");
    private TableView<Paiement> table = new TableView<>();;
    TableColumn<Paiement,Long> numeroColumn = new TableColumn<>("Id");
    TableColumn<Paiement, Date> dateColumn = new TableColumn<>("Date");
    TableColumn<Paiement,Double> montantColumn = new TableColumn<>("Montant");
    TableColumn<Paiement,String> typeColumn = new TableColumn<>("Type");
    private ObservableList<Paiement> paiementsObservableList = FXCollections.observableArrayList();
    private ListPaiementHandler listPaiementHandler = null;
    public ObservableList<Paiement> getPaiementsObservableList() {
        return paiementsObservableList;
    }

    public TableView<Paiement> getTable() {
        return table;
    }

    Button deleteButton = new Button("Delete");
    Button deleteAllButton = new Button("Delete all");
    Button searchButton = new Button("Search");
    Button refreshButton = new Button("Refresh");
    HBox buttonsHBox=new HBox(20);
    HBox buttonsHBoxParent=new HBox();

    private Paiement rowPaiementClicked = null;

    private void addStylesToNodes(){
        scene.getStylesheets().add("/StoreManagement/style.css");
        titleLabel.getStyleClass().add("sceneTitle");
        titleLabel.setMinWidth(window.getWidth());
        buttonsHBoxParent.getStyleClass().add("btnHbox");
        table.getStyleClass().add("table-row-cell");
        buttonsHBoxParent.setMargin(buttonsHBox,new Insets(20,0,0,0));
        table.setMinHeight(500);
        searchButton.getStyleClass().add("btn");
        refreshButton.getStyleClass().add("btn");
        deleteAllButton.getStyleClass().add("btn");
        deleteButton.getStyleClass().add("btn");
    }

    private void addNodesToPane(){
        buttonsHBox.getChildren().addAll(deleteButton,deleteAllButton,searchButton,refreshButton);
        buttonsHBoxParent.getChildren().add(buttonsHBox);
        root.getChildren().addAll(titleLabel,table,buttonsHBoxParent);
    }

    private void addEvents(){
        deleteButton.setOnAction(e->{
            //if(rowPaiementClicked != null)
               // new DeletePaiementHandler(rowPaiementClicked.getId(),vente,this);
        });
        deleteAllButton.setOnAction(e->{
            //new DeleteAllPaiementHandler(vente,this);
        });
        searchButton.setOnAction(e->{
            //new SearchPaiementWindow(this);
        });
        refreshButton.setOnAction(e->{
            //new RefreshPaiementListHandler(vente.getNumero(),this);
        });
        table.setOnMouseClicked((MouseEvent event) -> {
            rowPaiementClicked = table.getSelectionModel().getSelectedItem();
        });
    }

    private void initiWindow(){
        window.setWidth(1070);
        window.setHeight(750);
        window.setTitle("Liste des Paiements");
        window.getIcons().add(new Image("icone.png"));
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
    }


    void updateColmuns(){
        numeroColumn.setCellValueFactory(new PropertyValueFactory("numero"));
        numeroColumn.setMinWidth(100);

        dateColumn.setCellValueFactory(new PropertyValueFactory("date"));
        dateColumn.setMinWidth(200);

        montantColumn.setCellValueFactory(new PropertyValueFactory("montant"));
        montantColumn.setMinWidth(250);

        typeColumn.setCellValueFactory(new PropertyValueFactory("Type"));
        typeColumn.setMinWidth(200);
    }

    void addColumnsToTableView(){
        table.getColumns().addAll(numeroColumn, dateColumn, montantColumn, typeColumn);
        table.setItems(paiementsObservableList);
    }


    public ListPaiementWindow(Vente vente) {
        this.vente = vente;
        initiWindow();
        addStylesToNodes();
        listPaiementHandler = new ListPaiementHandler(vente, this);
        listPaiementHandler.updateVentesListWIndow();
        updateColmuns();
        addColumnsToTableView();
        addNodesToPane();
        addEvents();
        window.show();
    }
}
