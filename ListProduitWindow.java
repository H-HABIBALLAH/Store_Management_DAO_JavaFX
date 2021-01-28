package StoreManagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ListProduitWindow {
    Stage window = new Stage();
    private VBox root=new VBox(10);
    private Scene scene=new Scene(root);
    private Label titleLabel=new Label("La liste des produits");

    ProduitDaoImpl pdao=new ProduitDaoImpl();

    private TableView<Produit> table;

    private void addStylesToNodes(){
        scene.getStylesheets().add("/StoreManagement/style.css");
        titleLabel.getStyleClass().add("sceneTitle");
        titleLabel.setMinWidth(window.getWidth());

    }

    private void addNodesToWindow(){
        root.getChildren().add(titleLabel);
        addProductsInfoToTable();
        root.getChildren().add(table);
    }

    private void addEvents(){

    }

    private void initiWindow(){
        window.setWidth(1200);
        window.setHeight(700);
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
    }


    private void addProductsInfoToTable(){
        TableColumn<Produit,Long> idColumn=new TableColumn<>("Id");
        idColumn.setMinWidth(200);
        idColumn.setCellValueFactory(new PropertyValueFactory("id"));

        TableColumn<Produit,String> designationColumn=new TableColumn<>("Designation");
        designationColumn.setMinWidth(200);
        designationColumn.setCellValueFactory(new PropertyValueFactory("designation"));

        TableColumn<Produit,Integer> quantiteColumn=new TableColumn<>("Quantité");
        quantiteColumn.setMinWidth(200);
        quantiteColumn.setCellValueFactory(new PropertyValueFactory("quantity"));

        TableColumn<Produit,Double> prixColumn=new TableColumn<>("Prix");
        prixColumn.setMinWidth(200);
        prixColumn.setCellValueFactory(new PropertyValueFactory("prix"));

        TableColumn<Produit, LocalDate> dateColumn=new TableColumn<>("Date");
        dateColumn.setMinWidth(200);
        dateColumn.setCellValueFactory(new PropertyValueFactory("date"));

        table=new TableView<>();
        table.setItems(addProductsToObservableList());
        table.getColumns().addAll(idColumn,designationColumn,quantiteColumn,prixColumn,dateColumn);

    }

    private ObservableList<Produit> addProductsToObservableList(){
        ObservableList<Produit> productsObservableList = FXCollections.observableArrayList();
        List<Produit> productsList = pdao.getAll();
        for(Produit produit : productsList) {
            productsObservableList.add(produit);
        }
        return productsObservableList;
    }

    ListProduitWindow(){
        initiWindow();
        addProductsInfoToTable();
        addStylesToNodes();
        addNodesToWindow();
        addEvents();
        window.show();
    }
}
