package StoreManagement.IHM.Produit;

import StoreManagement.DAO.Catégorie.Categorie;
import StoreManagement.DAO.Produit.Produit;
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

public class ListProduitWindow {


    Stage window = new Stage();
    private VBox root=new VBox();
    private Scene scene=new Scene(root);
    private Label titleLabel=new Label("La liste des produits");
    TableView<Produit> table = new TableView<>();;
    Label totalLabel=new Label("Total : ");
    Label totalLabelValue=new Label();
    HBox totalHBox=new HBox();
    TableColumn<Produit,Long> idColumn=new TableColumn<>("Id");
    TableColumn<Produit,String> designationColumn=new TableColumn<>("Designation");
    TableColumn<Produit,Double> prixColumn=new TableColumn<>("Prix");
    TableColumn<Produit,Integer> quantiteColumn=new TableColumn<>("Quantité");
    TableColumn<Produit, LocalDate> dateColumn=new TableColumn<>("Date");
    TableColumn<Produit,Double> sTotalColumn=new TableColumn<>("STotal");
    TableColumn<Produit,String> categorieColumn=new TableColumn<>("Catégorie");
    ObservableList<Produit> productsObservableList = FXCollections.observableArrayList();

    ListProduitsHandler produitsListHandler = new ListProduitsHandler(this);

    Button deleteButton = new Button("Delete");
    Button deleteAllButton = new Button("Delete all");
    Button modifyButton = new Button("Modify");
    Button searchButton = new Button("Search");
    HBox buttonsHBox=new HBox(40);
    HBox buttonsHBoxParent=new HBox();

    private void addStylesToNodes(){
        scene.getStylesheets().add("/StoreManagement/style.css");
        titleLabel.getStyleClass().add("sceneTitle");
        titleLabel.setMinWidth(window.getWidth());
        totalLabel.getStyleClass().add("totalLabel");
        totalLabelValue.getStyleClass().add("totalLabel");
        totalHBox.getStyleClass().add("totalHBox");
        buttonsHBoxParent.getStyleClass().add("btnHbox");
        table.getStyleClass().add("table-row-cell");
        buttonsHBoxParent.setMargin(buttonsHBox,new Insets(20,0,0,0));
        table.setMinHeight(500);
        totalHBox.setSpacing(15);
        modifyButton.getStyleClass().add("btn");
        searchButton.getStyleClass().add("btn");
        deleteAllButton.getStyleClass().add("btn");
        deleteButton.getStyleClass().add("btn");
        scene.getStylesheets().add("/StoreManagement/style.css");
    }

    private void addNodesToPane(){
        totalHBox.getChildren().addAll(totalLabel,totalLabelValue);
        buttonsHBox.getChildren().addAll(deleteButton,deleteAllButton,modifyButton,searchButton);
        buttonsHBoxParent.getChildren().add(buttonsHBox);
        root.getChildren().addAll(titleLabel,table,totalHBox,buttonsHBoxParent);
    }

    private void addEvents(){
        deleteButton.setOnAction(e->{
            new DeleteProduitWindow(this);
        });
        deleteAllButton.setOnAction(e->{
            new DeleteAllProduitWindow(this);
        });
        modifyButton.setOnAction(e->{
            new ModifyProduitWindow(this);
        });
        searchButton.setOnAction(e->{
            new SearchProduitWindow(this);
        });
    }

    private void initiWindow(){
        window.setWidth(1100);
        window.setHeight(800);
        window.setTitle("Liste des produits");
        window.getIcons().add(new Image("icone.png"));
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
    }


     void updateColmuns(){
        idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        idColumn.setMinWidth(50);

        designationColumn.setCellValueFactory(new PropertyValueFactory("designation"));
        designationColumn.setMinWidth(250);

        prixColumn.setCellValueFactory(new PropertyValueFactory("prix"));
        prixColumn.setMinWidth(150);

        quantiteColumn.setCellValueFactory(new PropertyValueFactory("quantity"));
        quantiteColumn.setMinWidth(120);

        dateColumn.setCellValueFactory(new PropertyValueFactory("date"));
        dateColumn.setMinWidth(200);

        sTotalColumn.setCellValueFactory(new PropertyValueFactory("sTotal"));
        sTotalColumn.setMinWidth(150);

        categorieColumn.setCellValueFactory(new PropertyValueFactory("intituleCategorie"));
        categorieColumn.setMinWidth(150);


    }

    void addColumnsToTableView(ObservableList productsObservableList){
        table.getColumns().addAll(idColumn,designationColumn,prixColumn,quantiteColumn,sTotalColumn,dateColumn,categorieColumn);
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
        addColumnsToTableView(productsObservableList);
        produitsListHandler.updateProduitsListWIndow();
        calculerTotal();
        addNodesToPane();
        addEvents();
        window.show();
    }
}
