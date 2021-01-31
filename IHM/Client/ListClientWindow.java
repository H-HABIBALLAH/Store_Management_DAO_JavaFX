package StoreManagement.IHM.Client;

import StoreManagement.DAO.Client.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;

public class ListClientWindow {


    Stage window = new Stage();
    private VBox root=new VBox(10);
    private Scene scene=new Scene(root);
    private Label titleLabel=new Label("La liste des Clients");
    private TableView<Client> table = new TableView<>();;
    TableColumn<Client,Long> idColumn=new TableColumn<>("Id");
    TableColumn<Client,String> nomColumn=new TableColumn<>("Nom");
    TableColumn<Client,String> prenomColumn=new TableColumn<>("Preom");
    TableColumn<Client,Integer> ageColumn=new TableColumn<>("Age");
    TableColumn<Client, LocalDate> dateColumn=new TableColumn<>("Date");
    ObservableList<Client> clientsObservableList = FXCollections.observableArrayList();

    ListClientHandler ClientsListHandler = new ListClientHandler(this);

    Button deleteButton = new Button("Delete");
    Button deleteAllButton = new Button("Delete all");
    Button modifyButton = new Button("Modify");
    HBox buttonsHBox=new HBox(20);

    private void addStylesToNodes(){
        scene.getStylesheets().add("/StoreManagement/style.css");
        titleLabel.getStyleClass().add("sceneTitle");
        titleLabel.setMinWidth(window.getWidth());
        table.getStyleClass().add("table-row-cell");
        table.setMinHeight(500);
    }

    private void addNodesToPane(){
        buttonsHBox.getChildren().addAll(deleteButton,deleteAllButton,modifyButton);
        root.getChildren().addAll(titleLabel,table,buttonsHBox);
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
    }

    private void initiWindow(){
        window.setWidth(1100);
        window.setHeight(900);
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
    }


    private void updateColmuns(){
        idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        idColumn.setMinWidth(50);

        nomColumn.setCellValueFactory(new PropertyValueFactory("nom"));
        nomColumn.setMinWidth(250);

        prenomColumn.setCellValueFactory(new PropertyValueFactory("prenom"));
        prenomColumn.setMinWidth(250);

        ageColumn.setCellValueFactory(new PropertyValueFactory("age"));
        ageColumn.setMinWidth(150);

        dateColumn.setCellValueFactory(new PropertyValueFactory("date"));
        dateColumn.setMinWidth(200);
    }

    private void addColumnsToTableView(){
        table.getColumns().addAll(idColumn,nomColumn,prenomColumn,ageColumn,dateColumn);
        table.setItems(clientsObservableList);
    }



    public ListClientWindow(){
        initiWindow();
        addStylesToNodes();
        updateColmuns();
        addColumnsToTableView();
        ClientsListHandler.updateClientsListWIndow();
        addNodesToPane();
        addEvents();
        window.show();
    }
}
