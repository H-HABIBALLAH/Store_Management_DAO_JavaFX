package StoreManagement.IHM.Vente;

import StoreManagement.DAO.Client.Client;
import StoreManagement.DAO.Vente.Vente;
import StoreManagement.DAO.Vente.Vente;
import StoreManagement.IHM.LigneDeCommande.ListLigneDeCommandeWindow;
import StoreManagement.IHM.Vente.*;
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

public class ListVenteWindow {
        Client client = null;
        Stage window = new Stage();
        private VBox root=new VBox();
        private Scene scene=new Scene(root);
        private Label titleLabel=new Label("La liste des ventes");
        private TableView<Vente> table = new TableView<>();;
        TableColumn<Vente,Long> numeroColumn = new TableColumn<>("Numéro");
        TableColumn<Vente, Date> dateColumn = new TableColumn<>("Date");
        TableColumn<Vente,Double> totalColumn = new TableColumn<>("Total");
        TableColumn<Vente,Long> codeClientColumn = new TableColumn<>("Code client");
        private ObservableList<Vente> ventesObservableList = FXCollections.observableArrayList();

    public ObservableList<Vente> getVentesObservableList() {
        return ventesObservableList;
    }

    public TableView<Vente> getTable() {
        return table;
    }

    ListVenteHandler ventesListHandler = null;

        Button deleteButton = new Button("Delete");
        Button deleteAllButton = new Button("Delete all");
        Button searchButton = new Button("Search");
        Button refreshButton = new Button("Refresh");
        Button ListeCommandeButton = new Button("Liste des commandes");
        HBox buttonsHBox=new HBox(20);
        HBox buttonsHBoxParent=new HBox();

        private Vente rowVenteClicked = null;

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
            ListeCommandeButton.getStyleClass().add("btn");
        }

        private void addNodesToPane(){
            buttonsHBox.getChildren().addAll(deleteButton,deleteAllButton,searchButton,refreshButton,ListeCommandeButton);
            buttonsHBoxParent.getChildren().add(buttonsHBox);
            root.getChildren().addAll(titleLabel,table,buttonsHBoxParent);
        }

        private void addEvents(){
            deleteButton.setOnAction(e->{
                if(rowVenteClicked != null)
                    new DeleteVenteHandler(rowVenteClicked.getNumero(),rowVenteClicked.getClient().getCode(),this);
            });
            deleteAllButton.setOnAction(e->{
                new DeleteAllVenteHandler(this);
            });
            searchButton.setOnAction(e->{
                new SearchVenteWindow(this.client,this);
            });
            refreshButton.setOnAction(e->{
                new RefreshVenteListHandler(client.getCode(),this);
            });
            table.setOnMouseClicked((MouseEvent event) -> {
                rowVenteClicked = table.getSelectionModel().getSelectedItem();
            });
            ListeCommandeButton.setOnAction(e->{
                new ListLigneDeCommandeWindow(rowVenteClicked);
            });
        }

        private void initiWindow(){
            window.setWidth(870);
            window.setHeight(750);
            window.setTitle("Liste des ventes");
            window.getIcons().add(new Image("icone.png"));
            window.setScene(scene);
            window.initModality(Modality.APPLICATION_MODAL);
        }


        void updateColmuns(){
            numeroColumn.setCellValueFactory(new PropertyValueFactory("numero"));
            numeroColumn.setMinWidth(100);

            dateColumn.setCellValueFactory(new PropertyValueFactory("date"));
            dateColumn.setMinWidth(200);

            codeClientColumn.setCellValueFactory(new PropertyValueFactory("codeClient"));
            codeClientColumn.setMinWidth(200);

            totalColumn.setCellValueFactory(new PropertyValueFactory("totalOfTable"));
            totalColumn.setMinWidth(250);

            codeClientColumn.setCellValueFactory(new PropertyValueFactory("codeClient"));
            codeClientColumn.setMinWidth(250);
        }

        void addColumnsToTableView(ObservableList<Vente> ventesObservableList){
            table.getColumns().addAll(numeroColumn,dateColumn,totalColumn,codeClientColumn);
            table.setItems(ventesObservableList);
        }

    public ListVenteWindow(Client client){
            this.client = client;
            initiWindow();
            addStylesToNodes();
            updateColmuns();
            ventesListHandler = new ListVenteHandler(client, this);
            addColumnsToTableView(ventesObservableList);
            ventesListHandler.updateVentesListWIndow();
            addNodesToPane();
            addEvents();
            window.show();
        }

}
