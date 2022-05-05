package coe528.project;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author Nihar Sheth
 */
public class BankAccountApplication extends Application {

    private Stage mainStage;
    private Scene managerLoginScene;
    private Scene managerMainMenuScene;
    private Scene customerLoginScene;
    private Scene customerMainMenuScene;
    private Manager manager = new Manager("admin", "admin");
    
    @Override
    public void start(Stage primaryStage) {

        

        mainStage = primaryStage;
        BorderPane mainWindow = new BorderPane();

        Button managerButton = new Button("Login as Manager");
        managerButton.setOnAction(e -> mainStage.setScene(managerLoginScene));

        Button customerButton = new Button("Login as Customer");
        customerButton.setOnAction(e -> mainStage.setScene(customerLoginScene));

        Label creditLabel = new Label("Made by Nihar Sheth (500745364)\nCOE528-03\nFall 2018");

        VBox userSelectVBox = new VBox(10);
        Scene userSelectScene = new Scene(userSelectVBox, 320, 250);
        userSelectVBox.getChildren().addAll(managerButton, customerButton, creditLabel);
        userSelectVBox.setAlignment(Pos.CENTER);

        //Manager login
        VBox managerLoginVBox = new VBox(10);
        managerLoginVBox.setPadding(new Insets(20, 20, 20, 20));

        Button managerLoginButton = new Button("Login");
        Button managerLoginReturnButton = new Button("Return");
        managerLoginReturnButton.setOnAction(e -> mainStage.setScene(userSelectScene));
        TextField managerUsernameTextField = new TextField();
        managerUsernameTextField.setPromptText("Enter username");
        PasswordField managerPasswordTextField = new PasswordField();
        managerPasswordTextField.setPromptText("Enter password");
        Label managerUsernameLabel = new Label("Username");
        Label managerPasswordLabel = new Label("Password");

        managerLoginVBox.getChildren().addAll(managerUsernameLabel, managerUsernameTextField, managerPasswordLabel, managerPasswordTextField, managerLoginButton, managerLoginReturnButton);

        VBox managerMainMenu = new VBox(10);
        managerMainMenuScene = new Scene(managerMainMenu, 320, 250);
        Stage managerStage = primaryStage;

        managerLoginButton.setOnAction(e -> {

            boolean managerLoginValidation = (manager.hasUsername(managerUsernameTextField.getText()) == true) && (manager.hasPassword(managerPasswordTextField.getText()) == true);

            if (managerLoginValidation) {

                managerStage.setScene(managerMainMenuScene);
            }
        });

        //Manager main menu
        Button addCustomerButton = new Button("Add a new customer");
        Button deleteCustomerButton = new Button("Delete an existing customer");
        Button managerReturnButton = new Button("Log out");
        managerReturnButton.setOnAction(e -> {

            mainStage.setScene(userSelectScene);
            managerUsernameTextField.clear();
            managerPasswordTextField.clear();
        });

        managerMainMenu.getChildren().addAll(addCustomerButton, deleteCustomerButton, managerReturnButton);
        managerMainMenu.setAlignment(Pos.CENTER);

        //Add customer menu
        VBox addCustomerVBox = new VBox(10);
        Scene addCustomerScene = new Scene(addCustomerVBox, 320, 250);

        Button addButton = new Button("Add");
        Button addReturnButton = new Button("Return");
        addReturnButton.setOnAction(e -> mainStage.setScene(managerMainMenuScene));
        addCustomerButton.setOnAction(e -> mainStage.setScene(addCustomerScene));

        TextField addUsernameTextField = new TextField();
        TextField addPasswordTextField = new TextField();
        Label addUsernameLabel = new Label("Username of new customer");
        Label addPasswordLabel = new Label("Password of new customer");

        addCustomerVBox.setPadding(new Insets(20, 20, 20, 20));
        addCustomerVBox.getChildren().addAll(addUsernameLabel, addUsernameTextField, addPasswordLabel, addPasswordTextField, addButton, addReturnButton);
        addButton.setOnAction(e -> {

            Customer c = new Customer(addUsernameTextField.getText(), addPasswordTextField.getText());
            c.setBalance(100);
            manager.addCustomer(c);
        });

        //Delete customer menu
        VBox deleteCustomerVBox = new VBox(10);
        Scene deleteCustomerScene = new Scene(deleteCustomerVBox, 320, 250);
        Button deleteButton = new Button("Delete");
        Button deleteReturnButton = new Button("Return");
        deleteReturnButton.setOnAction(e -> mainStage.setScene(managerMainMenuScene));
        deleteCustomerButton.setOnAction(e -> mainStage.setScene(deleteCustomerScene));

        TextField deleteUsernameTextField = new TextField();
        Label deleteUsernameLabel = new Label("Username of customer to be deleted");

        deleteCustomerVBox.setPadding(new Insets(20, 20, 20, 20));
        deleteCustomerVBox.getChildren().addAll(deleteUsernameLabel, deleteUsernameTextField, deleteButton, deleteReturnButton);
        deleteButton.setOnAction(e -> {

            manager.deleteCustomer(deleteUsernameTextField.getText());
        });

        //Customer login
        VBox customerLoginVBox = new VBox(10);
        customerLoginVBox.setPadding(new Insets(20, 20, 20, 20));
        
        TextField customerUsernameTextField = new TextField();
        customerUsernameTextField.setPromptText("Enter username");
        PasswordField customerPasswordTextField = new PasswordField();
        customerPasswordTextField.setPromptText("Enter password");
        Label customerUsernameLabel = new Label("Username");
        Label customerPasswordLabel = new Label("Password");
        Button customerLoginButton = new Button("Login");
        Button customerLoginReturnButton = new Button("Return");
        
        customerLoginReturnButton.setOnAction(e -> mainStage.setScene(userSelectScene));
        customerLoginVBox.getChildren().addAll(customerUsernameLabel, customerUsernameTextField, customerPasswordLabel, customerPasswordTextField, customerLoginButton, customerLoginReturnButton);
        
        VBox customerMainMenu = new VBox(10);
        customerMainMenuScene = new Scene(customerMainMenu, 320, 250);
        Stage customerStage = primaryStage;

        customerLoginButton.setOnAction(e -> {

            Customer c = new Customer(customerUsernameTextField.getText(), customerPasswordTextField.getText());

            boolean customerLoginValidation = manager.readCustomerFile(c);

            if (customerLoginValidation) {

                customerStage.setScene(customerMainMenuScene);
            }
        });

        //Customer main menu
        Button checkBalanceButton = new Button("Check current balance");
        Button depositButton = new Button("Deposit into account");
        Button withdrawButton = new Button("Withdraw from account");
        Button doOnlinePurchaseButton = new Button("Do online purchase");
        Button feeStructureButton = new Button("See fee structure");
        Button customerReturnButton = new Button("Log out");
        customerReturnButton.setOnAction(e -> {

            mainStage.setScene(userSelectScene);
            customerUsernameTextField.clear();
            customerPasswordTextField.clear();
        });

        customerMainMenu.getChildren().addAll(checkBalanceButton, depositButton, withdrawButton, doOnlinePurchaseButton, feeStructureButton, customerReturnButton);
        customerMainMenu.setAlignment(Pos.CENTER);

        //Check balance menu
        VBox checkBalanceVBox = new VBox(10);
        Scene checkBalanceScene = new Scene(checkBalanceVBox, 320, 250);
        Button checkBalanceReturnButton = new Button("Return");
        checkBalanceReturnButton.setOnAction(e -> mainStage.setScene(customerMainMenuScene));

        TextField checkBalanceTextField = new TextField();
        Label checkBalanceLabel = new Label("Current balance");

        checkBalanceButton.setOnAction(e -> {

            Customer c = new Customer(customerUsernameTextField.getText(), customerPasswordTextField.getText());
            mainStage.setScene(checkBalanceScene);
            checkBalanceTextField.setText(manager.getCustomerBalance(c));
        });

        checkBalanceVBox.setPadding(new Insets(20, 20, 20, 20));
        checkBalanceVBox.getChildren().addAll(checkBalanceLabel, checkBalanceTextField, checkBalanceReturnButton);

        //Deposit menu
        VBox depositVBox = new VBox(10);
        Scene depositScene = new Scene(depositVBox, 320, 250);
        Button depositValueButton = new Button("Deposit");
        Button depositReturnButton = new Button("Return");

        TextField depositTextField = new TextField();
        Label depositLabel = new Label("Amount to deposit");

        depositReturnButton.setOnAction(e -> {

            mainStage.setScene(customerMainMenuScene);
            depositTextField.clear();
        });

        depositButton.setOnAction(e -> mainStage.setScene(depositScene));
        depositValueButton.setOnAction(e -> {

            if (!depositTextField.getText().isEmpty()) {

                Customer c = new Customer(customerUsernameTextField.getText(), customerPasswordTextField.getText());
                double deposit = Double.parseDouble(depositTextField.getText());
                double newBalance = Double.parseDouble(manager.getCustomerBalance(c)) + deposit;
                c.deposit(newBalance);
                manager.makeCustomerFile(c);
            }
        });

        depositVBox.setPadding(new Insets(20, 20, 20, 20));
        depositVBox.getChildren().addAll(depositLabel, depositTextField, depositValueButton, depositReturnButton);

        //Withdraw menu
        VBox withdrawVBox = new VBox(10);
        Scene withdrawScene = new Scene(withdrawVBox, 320, 250);
        Button withdrawValueButton = new Button("Withdraw");
        Button withdrawReturnButton = new Button("Return");

        TextField withdrawTextField = new TextField();
        Label withdrawLabel = new Label("Amount to withdraw");

        withdrawReturnButton.setOnAction(e -> {

            mainStage.setScene(customerMainMenuScene);
            withdrawTextField.clear();
        });

        withdrawButton.setOnAction(e -> mainStage.setScene(withdrawScene));
        withdrawValueButton.setOnAction(e -> {

            if (!withdrawTextField.getText().isEmpty()) {

                Customer c = new Customer(customerUsernameTextField.getText(), customerPasswordTextField.getText());
                double withdraw = Double.parseDouble(withdrawTextField.getText());
                double newBalance = Double.parseDouble(manager.getCustomerBalance(c)) - withdraw;
                c.deposit(newBalance);
                manager.makeCustomerFile(c);
            }
        });

        withdrawVBox.setPadding(new Insets(20, 20, 20, 20));
        withdrawVBox.getChildren().addAll(withdrawLabel, withdrawTextField, withdrawValueButton, withdrawReturnButton);

        //Do online purchase menu
        VBox doOnlinePurchaseVBox = new VBox(10);
        Scene doOnlinePurchaseScene = new Scene(doOnlinePurchaseVBox, 320, 250);
        Button doOnlinePurchaseValueButton = new Button("Purchase");
        Button doOnlinePurchaseReturnButton = new Button("Return");

        TextField doOnlinePurchaseTextField = new TextField();
        Label doOnlinePurchaseLabel = new Label("Amount to purchase");
        Label levelLabel = new Label();

        doOnlinePurchaseReturnButton.setOnAction(e -> {

            mainStage.setScene(customerMainMenuScene);
            doOnlinePurchaseTextField.clear();
        });

        doOnlinePurchaseButton.setOnAction(e -> {

            Customer c = new Customer(customerUsernameTextField.getText(), customerPasswordTextField.getText());
            double balance = Double.parseDouble(manager.getCustomerBalance(c));
            c.setBalance(balance);
            c.updateLevel();
            String level = c.getLevelString();
            levelLabel.setText("Current level: " + level);
            mainStage.setScene(doOnlinePurchaseScene);
        });

        doOnlinePurchaseValueButton.setOnAction(e -> {

            if (!doOnlinePurchaseButton.getText().isEmpty()) {

                Customer c = new Customer(customerUsernameTextField.getText(), customerPasswordTextField.getText());
                double balance = Double.parseDouble(manager.getCustomerBalance(c));
                c.setBalance(balance);
                c.updateLevel();
                c.setBalance(0);
                double purchase = Double.parseDouble(doOnlinePurchaseTextField.getText());

                if (c.getLevel() instanceof Silver) {

                    purchase += 20;
                } else if (c.getLevel() instanceof Gold) {

                    purchase += 10;
                } else {

                }

                double newBalance = Double.parseDouble(manager.getCustomerBalance(c)) - purchase;
                c.deposit(newBalance);
                manager.makeCustomerFile(c);

                c.updateLevel();
                String level = c.getLevelString();
                levelLabel.setText("Current level: " + level);
            }
        });

        doOnlinePurchaseVBox.setPadding(new Insets(20, 20, 20, 20));
        doOnlinePurchaseVBox.getChildren().addAll(levelLabel, doOnlinePurchaseLabel, doOnlinePurchaseTextField, doOnlinePurchaseValueButton, doOnlinePurchaseReturnButton);

        //Fee structure menu
        VBox feeStructureVBox = new VBox(10);
        Scene feeStructureScene = new Scene(feeStructureVBox, 320, 250);
        Button feeStructureReturnButton = new Button("Return");

        Label feeStructureLabel = new Label("Silver level - $20 fee\nGold level - $10 fee\nPlatinum level - No fee");

        feeStructureReturnButton.setOnAction(e -> mainStage.setScene(customerMainMenuScene));
        feeStructureButton.setOnAction(e -> mainStage.setScene(feeStructureScene));
        
        feeStructureVBox.setAlignment(Pos.CENTER);
        feeStructureVBox.getChildren().addAll(feeStructureLabel, feeStructureReturnButton);

        managerLoginScene = new Scene(managerLoginVBox, 320, 250);
        customerLoginScene = new Scene(customerLoginVBox, 320, 250);

        mainStage.setTitle("Bank Account Application");
        mainStage.setScene(userSelectScene);
        mainStage.show();
    }

    /**
     * @param args the command line arguments
     * @throws java.lang.CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        launch(args);
    }

}
