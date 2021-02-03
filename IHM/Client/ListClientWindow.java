package StoreManagement.IHM.Client;

import StoreManagement.DAO.Client.Client;
import StoreManagement.IHM.Produit.SearchProduitWindow;
import StoreManagement.IHM.Produit.refreshProduitHandler;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;

public class ListClientWindow {


    Stage window = new Stage();
    private VBox root=new VBox();
    private Scene scene=new Scene(root);
    private Label titleLabel=new Label("La liste des Clients");
    TableView<Client> table = new TableView<>();;
    TableColumn<Client,Long> idColumn = new TableColumn<>("Code");
    TableColumn<Client,String> nomColumn = new TableColumn<>("Nom");
    TableColumn<Client,String> prenomColumn = new TableColumn<>("Prenom");
    TableColumn<Client,String> telColumn = new TableColumn<>("Téléphone");
    TableColumn<Client,String> emailColumn = new TableColumn<>("Email");
    TableColumn<Client,String> adresseColumn = new TableColumn<>("Adresse");
    ObservableList<Client> clientsObservableList = FXCollections.observableArrayList();

    ListClientHandler ClientsListHandler = new ListClientHandler(this);

    Button deleteButton = new Button("Delete");
    Button deleteAllButton = new Button("Delete all");
    Button modifyButton = new Button("Modify");
    Button searchButton = new Button("Search");
    Button refreshButton = new Button("Refresh");
    HBox buttonsHBox=new HBox(20);
    HBox buttonsHBoxParent=new HBox();

    private void addStylesToNodes(){
        scene.getStylesheets().add("/StoreManagement/style.css");
        titleLabel.getStyleClass().add("sceneTitle");
        titleLabel.setMinWidth(window.getWidth());
        buttonsHBoxParent.getStyleClass().add("btnHbox");
        table.getStyleClass().add("table-row-cell");
        buttonsHBoxParent.setMargin(buttonsHBox,new Insets(20,0,0,0));
        table.setMinHeight(500);
        modifyButton.getStyleClass().add("btn");
        searchButton.getStyleClass().add("btn");
        refreshButton.getStyleClass().add("btn");
        deleteAllButton.getStyleClass().add("btn");
        deleteButton.getStyleClass().add("btn");
    }

    private void addNodesToPane(){
        buttonsHBox.getChildren().addAll(deleteButton,deleteAllButton,modifyButton,searchButton,refreshButton);
        buttonsHBoxParent.getChildren().add(buttonsHBox);
        root.getChildren().addAll(titleLabel,table,buttonsHBoxParent);
    }

    private void addEvents(){
        deleteButton.setOnAction(e->{
            new DeleteClientWindow(this);
        });
        deleteAllButton.setOnAction(e->{
            new DeleteAllClientWindow(this);
        });
        modifyButton.setOnAction(e->{
            new ModifyClientWindow(this);
        });
        searchButton.setOnAction(e->{
            new SearchClientWindow(this);
        });
        refreshButton.setOnAction(e->{
            new refreshClientHandler(this);
        });
    }

    private void initiWindow(){
        window.setWidth(1270);
        window.setHeight(750);
        window.setTitle("Liste des clients");
        window.getIcons().add(new Image("icone.png"));
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
    }


    void updateColmuns(){
        idColumn.setCellValueFactory(new PropertyValueFactory("code"));
        idColumn.setMinWidth(100);

        nomColumn.setCellValueFactory(new PropertyValueFactory("nom"));
        nomColumn.setMinWidth(200);

        prenomColumn.setCellValueFactory(new PropertyValueFactory("prenom"));
        prenomColumn.setMinWidth(200);

        telColumn.setCellValueFactory(new PropertyValueFactory("tel"));
        telColumn.setMinWidth(250);

        emailColumn.setCellValueFactory(new PropertyValueFactory("email"));
        emailColumn.setMinWidth(250);

        adresseColumn.setCellValueFactory(new PropertyValueFactory("adresse"));
        adresseColumn.setMinWidth(250);
    }

    void addColumnsToTableView(ObservableList<Client> clientsObservableList){
        table.getColumns().addAll(idColumn,nomColumn,prenomColumn,telColumn,emailColumn,adresseColumn);
        table.setItems(clientsObservableList);
    }



    public ListClientWindow(){
        initiWindow();
        addStylesToNodes();
        updateColmuns();
        addColumnsToTableView(clientsObservableList);
        ClientsListHandler.updateClientsListWIndow();
        addNodesToPane();
        addEvents();
        window.show();
    }
}
