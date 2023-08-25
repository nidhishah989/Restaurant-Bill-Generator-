/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nidhi
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
//import javafx.geometry.Pos;
public class Try extends Application{
 double subtotalvalue;
 double tax;
 double total;
 final double taxrate = 0.02;

    @Override
    public void start(Stage primaryStage)
    {
         //set image and Title for restaurent
        //load the image
        Image image = new Image("logo.png");
        ImageView logo = new ImageView(image);
        logo.setFitHeight(100);
        logo.setFitWidth(100);
        Label title = new Label("   Nidhi's Cooking Fever",logo);
        title.setContentDisplay(ContentDisplay.LEFT);
        title.setFont(Font.font("Arial",30));
        
        //set labels and two textFields to get detail of waiter and tabel
        Label twdetail = new Label("Table and Waiter information");
       
        Label tableno = new Label("    Table Number:");
        TextField tablenumber = new TextField();
        tablenumber.setMaxSize(150, 5);
       
        Label waiterna = new Label("    Waiter's name:");
        TextField waitername = new TextField();
        waitername.setMaxSize(200,5);
       
        //set the item menu..
        Label menu = new Label("Menu Items");
        Label beverg = new Label("    Beverage:");
        Label appetiz = new Label("   Appetizer:");
        Label main = new Label("    Main Course:");
        Label sweet = new Label("    Dessert:");
        
        //combobox for menu
        //Beverage
        ObservableList<String> beverage = FXCollections.observableArrayList("Soda","Tea","Coffee","Mineral Water","Juice","Milk");
        ComboBox bevcomboBox = new ComboBox(beverage);
        bevcomboBox.setValue("Soda");
        ObservableList<String> beverageprice = FXCollections.observableArrayList("1.95","1.50","1.25","2.95","2.50","1.50");
        ComboBox beveragepriceBox = new ComboBox(beverageprice);
        
        //Appetizer
        ObservableList<String> appetizer = FXCollections.observableArrayList("Buffalo Wings","Buffalo Fingers","Potato Skins","Nacjos","Mushroom Caps","Shrimp Cocktail","Chips and Salsa");
        ComboBox appetcomboBox = new ComboBox(appetizer);
        appetcomboBox.setValue("Buffalo Wings");
        ObservableList<String> apperizerprice = FXCollections.observableArrayList("5.95","6.95","8.95","8.95","10.95","12.95","6.95");
        ComboBox appetizerpriceBox = new ComboBox(apperizerprice);
        
        //MAin Course
        ObservableList<String> maincourse = FXCollections.observableArrayList("Seafood Alfredo","Chicken Alfredo","Chicken Picatta","Turkey Club","Lobster Pie","Prime Rib","Shrimp Scampi","Turkey Dinner","Stuffed Chicken");
        ComboBox maincoursecomboBox = new ComboBox(maincourse);
        maincoursecomboBox.setValue("Seafood Alfredo");
        ObservableList<String> maincourseprice = FXCollections.observableArrayList("15.95","13.95","13.95","11.95","19.95","20.95","18.95","13.95","14.95");
        ComboBox maincoursepriceBox = new ComboBox(maincourseprice);
        
        //Dessert
        ObservableList<String> dessert = FXCollections.observableArrayList("Apple Pie","Sundae","Carrot Cake","Mud Pie","Apple Crisp");
        ComboBox dessertcomboBox = new ComboBox(dessert);
        dessertcomboBox.setValue("Apple Pie");
        ObservableList<String> dessertprice = FXCollections.observableArrayList("5.95","3.95","5.95","4.95","5.95");
        ComboBox dessertpriceBox = new ComboBox(dessertprice);
        
        //Bill detail
        Label bi = new Label("BILL");
        Label subtot = new Label("Subtotal:");
        TextArea subtotal = new TextArea();
        subtotal.setMaxSize(150, 5);
        Label tax = new Label("Tax:");
        TextArea taxval = new TextArea();
        taxval.setMaxSize(150,5);
        Label total = new Label("Total:");
        TextArea totalval = new TextArea();
        totalval.setMaxSize(150, 5);
        Label waitern = new Label("waiter:");
        TextArea waiternam = new TextArea();
        waiternam.setPrefSize(200, 5);
        Label tabno = new Label("Table No:");
        TextArea tbnom = new TextArea();
        tbnom.setPrefSize(150, 5);
        waitername.setOnKeyReleased(e-> waiternam.setText(waitername.getText()));
        tablenumber.setOnKeyReleased(e-> tbnom.setText(tablenumber.getText()));
        Button clear = new Button("Clear Bill");
       
        
        //create selected list
        //beverage selection
        Label select = new Label("Item Ordered:");
        Label bevsel = new Label("Beverage Ordered:");
        ListView<String> beveragelist = new ListView<String>();
        ObservableList<String> beverageselection = FXCollections.observableArrayList();
        beveragelist.setItems(beverageselection);
        beveragelist.setEditable(true);
        beveragelist.setPrefSize(150,100);
       
        bevcomboBox.setOnAction(e ->{ beveragelist.getItems().addAll(beverage.get(beverage.indexOf(bevcomboBox.getValue())));
                                       double i =setsubtotalvalue(Double.parseDouble(beverageprice.get(beverage.indexOf(bevcomboBox.getValue()))));
                                       subtotal.setText(Double.toString(i));
                                       double tax1 = settaxvalue(i);
                                       taxval.setText(Double.toString(tax1));
                                       double t1 = settotal(i,tax1);
                                       totalval.setText(Double.toString(t1));
                                       int size= beveragelist.getItems().size();
                                          System.out.println("size:"+size);
                                     });
        
        
        beveragelist.setOnMouseClicked(e ->{ String q = beveragelist.getSelectionModel().getSelectedItems().toString();
                                           System.out.println(q);
                                           double k1= decreasesubtotalvalue(Double.parseDouble(beverageprice.get(beverage.indexOf(beveragelist.getSelectionModel().getSelectedItem()))));
                                           beveragelist.getItems().remove(beveragelist.getSelectionModel().getSelectedIndex());
                                           subtotal.setText(Double.toString(k1));
                                           double taxr2 = settaxvalue(k1);
                                           taxval.setText(Double.toString(taxr2));
                                           double tr2 = settotal(k1,taxr2);
                                           totalval.setText(Double.toString(tr2));
                                         });
       
       
        
        
        
        
        //appetizer selection
        Label apsel = new Label("Appetizer Ordered:");
        ListView<String> appetizerlist = new ListView<String>();
        ObservableList<String> appetizerselection = FXCollections.observableArrayList();
        appetizerlist.setItems(appetizerselection);
        appetizerlist.setPrefSize(150,100);
        appetizerlist.setEditable(true);
        appetcomboBox.setOnAction(e ->{appetizerlist.getItems().addAll(appetizer.get(appetizer.indexOf(appetcomboBox.getValue())));
                                        double j = setsubtotalvalue(Double.parseDouble(apperizerprice.get(appetizer.indexOf(appetcomboBox.getValue()))));
                                        subtotal.setText(Double.toString(j));
                                        double tax2 = settaxvalue(j);
                                        taxval.setText(Double.toString(tax2));
                                        double t2 = settotal(j,tax2);
                                       totalval.setText(Double.toString(t2));
                                      });
        
        appetizerlist.setOnMouseClicked(e ->{ String q = appetizerlist.getSelectionModel().getSelectedItems().toString();
                                           System.out.println(q);
                                           double ka = decreasesubtotalvalue(Double.parseDouble(apperizerprice.get(appetizer.indexOf(appetizerlist.getSelectionModel().getSelectedItem()))));
                                           appetizerlist.getItems().remove(appetizerlist.getSelectionModel().getSelectedIndex());
                                           subtotal.setText(Double.toString(ka));
                                           double taxr2 = settaxvalue(ka);
                                           taxval.setText(Double.toString(taxr2));
                                           double tr2 = settotal(ka,taxr2);
                                           totalval.setText(Double.toString(tr2));
                                         });
        
        //main course selection
        Label maincsel = new Label("Main Course Ordered:");
        ListView<String> maincourselist = new ListView<String>();
        ObservableList<String> maincourseselection = FXCollections.observableArrayList();
        maincourselist.setItems(maincourseselection);
        maincourselist.setPrefSize(150,100);
        maincourselist.setEditable(true);
        maincoursecomboBox.setOnAction(e ->{ maincourselist.getItems().addAll(maincourse.get(maincourse.indexOf(maincoursecomboBox.getValue())));
                                             double k = setsubtotalvalue(Double.parseDouble( maincourseprice.get(maincourse.indexOf(maincoursecomboBox.getValue()))));
                                             subtotal.setText(Double.toString(k));
                                             double tax3 = settaxvalue(k);
                                             taxval.setText(Double.toString(tax3));
                                             double t3 = settotal(k,tax3);
                                             totalval.setText(Double.toString(t3));
                                         });
         maincourselist.setOnMouseClicked(e ->{ String q = maincourselist.getSelectionModel().getSelectedItems().toString();
                                           System.out.println(q);
                                            double k2= decreasesubtotalvalue(Double.parseDouble(maincourseprice.get(maincourse.indexOf(maincourselist.getSelectionModel().getSelectedItem()))));
                                           maincourselist.getItems().remove(maincourselist.getSelectionModel().getSelectedIndex());
                                           subtotal.setText(Double.toString(k2));
                                           double taxr3 = settaxvalue(k2);
                                           taxval.setText(Double.toString(taxr3));
                                           double tr3 = settotal(k2,taxr3);
                                           totalval.setText(Double.toString(tr3));
                                         });
        
        //Dessert selection
        Label dessel = new Label("Dessert Ordered:");
        ListView<String> dessertlist = new ListView<String>();
        ObservableList<String> dessertselection = FXCollections.observableArrayList();
        dessertlist.setItems(dessertselection);
        dessertlist.setPrefSize(150,100);
        dessertlist.setEditable(true);
        dessertcomboBox.setOnAction(e -> {dessertlist.getItems().addAll(dessert.get(dessert.indexOf(dessertcomboBox.getValue())));
                                          double l = setsubtotalvalue(Double.parseDouble(dessertprice.get(dessert.indexOf(dessertcomboBox.getValue()))));
                                          subtotal.setText(Double.toString(l));
                                          double tax4 = settaxvalue(l);
                                          taxval.setText(Double.toString(tax4));
                                          double t4 = settotal(l,tax4);
                                       totalval.setText(Double.toString(t4));
                                         });
         dessertlist.setOnMouseClicked(e ->{ String q = dessertlist.getSelectionModel().getSelectedItems().toString();
                                           System.out.println(q);
                                           double k4= decreasesubtotalvalue(Double.parseDouble(dessertprice.get(dessert.indexOf(dessertlist.getSelectionModel().getSelectedItem()))));
                                           dessertlist.getItems().remove(dessertlist.getSelectionModel().getSelectedIndex());
                                           
                                           subtotal.setText(Double.toString(k4));
                                           double taxr4 = settaxvalue(k4);
                                           taxval.setText(Double.toString(taxr4));
                                           double tr4 = settotal(k4,taxr4);
                                           totalval.setText(Double.toString(tr4));
                                         });
         
         //clear everything
          clear.setOnMouseClicked(e->{waitername.clear();
                                    tablenumber.clear();
                                    waiternam.clear();
                                    tbnom.clear();
                                    beveragelist.getItems().removeAll(beveragelist.getItems());
                                    appetizerlist.getItems().removeAll(appetizerlist.getItems());
                                    maincourselist.getItems().removeAll(maincourselist.getItems());
                                    dessertlist.getItems().removeAll(dessertlist.getItems());
                                    double clearsub = clearsubtotal();
                                    subtotal.setText(Double.toString(clearsub));
                                    double taxclear = settaxvalue(clearsub);
                                    taxval.setText(Double.toString(taxclear));
                                    double totalclear = settotal(clearsub,taxclear);
                                    totalval.setText(Double.toString(totalclear));
                                    
                                    });
         
        //dispaly setting..
         GridPane pane = new GridPane(); 
         pane.setHgap(10);
         pane.setVgap(10);
         
         //to fit beverageselction
         GridPane paneForselectedList = new GridPane();
        paneForselectedList.setHgap(10);
        paneForselectedList.setVgap(10);
       
         
         HBox overallpane = new HBox();
         overallpane.getChildren().addAll(pane,paneForselectedList);
            
        pane.add(title,0,0);
        pane.add(twdetail, 0, 1);
        pane.add(tableno,0,2);
        pane.add(tablenumber, 1, 2);
        pane.add(waiterna,0,3);
        pane.add(waitername, 1, 3);
        pane.add(menu, 0, 4);
        pane.add(beverg,0,5);
        pane.add(bevcomboBox, 1, 5);
        pane.add(appetiz,0,6);
        pane.add(appetcomboBox, 1, 6);
        pane.add(main,0,7);
        pane.add(maincoursecomboBox, 1, 7);
        pane.add(sweet,0,8);
        pane.add(dessertcomboBox, 1, 8);
        pane.add(bi,0,10);
        pane.add(subtot,0,11);
        pane.add(subtotal,1,11);
        pane.add(tax,0,12);
        pane.add(taxval,1,12);
        pane.add(total,0,13);
        pane.add(totalval,1,13);
        pane.add(waitern,0,15);
        pane.add(waiternam,1,15);
        pane.add(tabno,2,15);
        pane.add(tbnom,3,15);
        pane.add(clear, 1,17 );
        
        //add selected list
        paneForselectedList.add(select, 1,10);
        paneForselectedList.add(bevsel,1,11);
        paneForselectedList.add(beveragelist,2,11);
        paneForselectedList.add(apsel,1,12);
        paneForselectedList.add(appetizerlist,2,12);
        paneForselectedList.add(maincsel,1,13);
        paneForselectedList.add(maincourselist,2,13);
        paneForselectedList.add(dessel,1,14);
        paneForselectedList.add(dessertlist,2,14);
      
        // Create a scene and place it in the stage
        Scene scene = new Scene(overallpane, 450, 150);
        
        primaryStage.setTitle("Restaurant Bill Calculator"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage 
      
       
    }
public static void main(String[] args)
{
    Application.launch(args);
}

public double setsubtotalvalue(double i)
{
    subtotalvalue = subtotalvalue + i;
    return subtotalvalue;
}

public double settaxvalue(double j)
{
    tax = taxrate*j;
    return tax;
}

public double settotal(double sub,double tax)
{
    total = sub + tax;
    return total;
}

public double decreasesubtotalvalue(double d)
{
    subtotalvalue = subtotalvalue - d;
    return subtotalvalue;
}
public double clearsubtotal()
    {
          subtotalvalue = 0.0;
         
          return subtotalvalue;
          
    }
}