package StoreManagement.IHM.LigneDeCommande;

import StoreManagement.DAO.LigneDeCommande.LigneDeCommande;
import StoreManagement.DAO.Vente.Vente;
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

public class ListLigneDeCommandeWindow {

    Vente vente = null;
    Stage window = new Stage();
    private VBox root=new VBox();
    private Scene scene=new Scene(root);
    private Label titleLabel=new Label("La liste des ligne de commandes");
    private TableView<LigneDeCommande> table = new TableView<>();;
    TableColumn<LigneDeCommande,Long> idColumn = new TableColumn<>("Id");
    TableColumn<LigneDeCommande, Date> qteColumn = new TableColumn<>("Qte");
    TableColumn<LigneDeCommande,Double> sousTotalColumn = new TableColumn<>("Sous total");
    TableColumn<LigneDeCommande,Double> idProduitColumn = new TableColumn<>("Id produit");
    private ObservableList<LigneDeCommande> ligneDeCommandesObservableList = FXCollections.observableArrayList();
    private ListLigneDeCommandeHandler listLigneDeCommandeHandler = null;
    public ObservableList<LigneDeCommande> getLigneDeCommandesObservableList() {
        return ligneDeCommandesObservableList;
    }

    public TableView<LigneDeCommande> getTable() {
        return table;
    }

    Button deleteButton = new Button("Delete");
    Button deleteAllButton = new Button("Delete all");
    Button searchButton = new Button("Search");
    Button refreshButton = new Button("Refresh");
    HBox buttonsHBox=new HBox(20);
    HBox buttonsHBoxParent=new HBox();

    private LigneDeCommande rowLigneDeCommandeClicked = null;

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
            if(rowLigneDeCommandeClicked != null)
                new DeleteLigneDeCommandeHandler(rowLigneDeCommandeClicked.getId(),vente,this);
        });
        deleteAllButton.setOnAction(e->{
            new DeleteAllLigneDeCommandeHandler(vente,this);
        });
        searchButton.setOnAction(e->{
            new SearchLigneDeCommandeWindow(this);
        });
        refreshButton.setOnAction(e->{
            new RefreshLigneDeCommandeListHandler(vente.getNumero(),this);
        });
        table.setOnMouseClicked((MouseEvent event) -> {
            rowLigneDeCommandeClicked = table.getSelectionModel().getSelectedItem();
        });
    }

    private void initiWindow(){
        window.setWidth(870);
        window.setHeight(750);
        window.setTitle("Liste des LigneDeCommandes");
        window.getIcons().add(new Image("icone.png"));
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
    }


    void updateColmuns(){
        idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        idColumn.setMinWidth(100);

        qteColumn.setCellValueFactory(new PropertyValueFactory("qte"));
        qteColumn.setMinWidth(200);

        sousTotalColumn.setCellValueFactory(new PropertyValueFactory("sousTotal"));
        sousTotalColumn.setMinWidth(200);

        idProduitColumn.setCellValueFactory(new PropertyValueFactory("produitId"));
        idProduitColumn.setMinWidth(250);
    }

    void addColumnsToTableView(){
        table.getColumns().addAll(idColumn,qteColumn,sousTotalColumn,idProduitColumn);
        table.setItems(ligneDeCommandesObservableList);
    }

    public ListLigneDeCommandeWindow(Vente vente){
        this.vente = vente;
        initiWindow();
        addStylesToNodes();
        listLigneDeCommandeHandler = new ListLigneDeCommandeHandler(vente, this);
        listLigneDeCommandeHandler.updateVentesListWIndow();
        updateColmuns();
        addColumnsToTableView();
        addNodesToPane();
        addEvents();
        window.show();
    }
}
