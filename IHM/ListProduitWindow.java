package StoreManagement.IHM;

import StoreManagement.DAO.Produit;
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

public class ListProduitWindow {


    Stage window = new Stage();
    private VBox root=new VBox(10);
    private Scene scene=new Scene(root);
    private Label titleLabel=new Label("La liste des produits");
    private TableView<Produit> table = new TableView<>();;
    Label totalLabel=new Label("Total : ");
    Label totalLabelValue=new Label();
    HBox totalHBox=new HBox();
    TableColumn<Produit,Long> idColumn=new TableColumn<>("Id");
    TableColumn<Produit,String> designationColumn=new TableColumn<>("Designation");
    TableColumn<Produit,Double> prixColumn=new TableColumn<>("Prix");
    TableColumn<Produit,Integer> quantiteColumn=new TableColumn<>("Quantité");
    TableColumn<Produit, LocalDate> dateColumn=new TableColumn<>("Date");
    TableColumn<Produit,Double> sTotalColumn=new TableColumn<>("STotal");
    ObservableList<Produit> productsObservableList = FXCollections.observableArrayList();

    ProduitsListHandler produitsListHandler = new ProduitsListHandler(this);

    Button deleteButton = new Button("Delete");
    Button deleteAllButton = new Button("Delete all");
    Button modifyButton = new Button("Modify");
    HBox buttonsHBox=new HBox(20);

    private void addStylesToNodes(){
        scene.getStylesheets().add("/StoreManagement/style.css");
        titleLabel.getStyleClass().add("sceneTitle");
        titleLabel.setMinWidth(window.getWidth());
        totalLabel.getStyleClass().add("totalLabel");
        totalLabelValue.getStyleClass().add("totalLabel");
        totalHBox.getStyleClass().add("boxTotal");
        table.getStyleClass().add("table-row-cell");
        table.setMinHeight(500);
        totalHBox.setSpacing(15);
    }

    private void addNodesToPane(){
        totalHBox.getChildren().addAll(totalLabel,totalLabelValue);
        buttonsHBox.getChildren().addAll(deleteButton,deleteAllButton,modifyButton);
        root.getChildren().addAll(titleLabel,table,totalHBox,buttonsHBox);
    }

    private void addEvents(){
        deleteButton.setOnAction(e->{
            new DeleteProduitWindow(this);
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

        designationColumn.setCellValueFactory(new PropertyValueFactory("designation"));
        designationColumn.setMinWidth(250);

        prixColumn.setCellValueFactory(new PropertyValueFactory("prix"));
        prixColumn.setMinWidth(150);

        quantiteColumn.setCellValueFactory(new PropertyValueFactory("quantity"));
        quantiteColumn.setMinWidth(150);

        dateColumn.setCellValueFactory(new PropertyValueFactory("date"));
        dateColumn.setMinWidth(200);

        sTotalColumn.setCellValueFactory(new PropertyValueFactory("sTotal"));
        sTotalColumn.setMinWidth(150);


    }

    private void addColumnsToTableView(){
        table.getColumns().addAll(idColumn,designationColumn,prixColumn,quantiteColumn,sTotalColumn,dateColumn);
        table.setItems(productsObservableList);
    }


    private void calculerTotal(){
        double total=0;
        for(Produit produit : productsObservableList){
            total+=produit.getSTotal();
        }
        totalLabelValue.setText(total+"");
    }

    public ListProduitWindow(){
        initiWindow();
        addStylesToNodes();
        updateColmuns();
        addColumnsToTableView();
        produitsListHandler.updateProduitsListWIndow();
        calculerTotal();
        addNodesToPane();
        addEvents();
        window.show();
    }
}
