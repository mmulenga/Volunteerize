///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.teamb.view;
//
//
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.Pane;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//
//import com.teamb.controller.LoginController;
//
//
///**
// *
// * @author irene
// */
//public class LoginView extends Pane{
//    public GridPane root;
//    public boolean loginOK = false;
//
//    public LoginView(Stage s){
//        root = new GridPane();
//        Text scenetitle = new Text("Welcome to Volunteerize!");
//        scenetitle.setId("scenetitle");
//        LoginController controller = new LoginController(s);
//
//        Label userName = new Label("Username:");
//        Label pw = new Label("Password:");
//        TextField userNameField = new TextField();
//        PasswordField pwField = new PasswordField();
//
//        Button login = new Button("Login");
//        Button Signup = new Button("Sign Up");
//
//        login.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                if(controller.checkCredentials(userNameField.getText(), pwField.getText())) {
//                    loginOK = true;
//                }else{
//                    Label loginError = new Label("username or password is wrong. Please try again.");
//                    root.add(loginError,0,5,3,1);
//                }
//            }
//        });
//
//        root.setAlignment(Pos.CENTER);
//        root.setHgap(10);
//        root.setVgap(10);
//        root.setPadding(new Insets(25,25,25,25));
//
//        root.add(scenetitle,0,0,2,1);
//        root.add(userName,0,1);
//        root.add(pw,0,2);
//        root.add(userNameField,1,1);
//        root.add(pwField,1,2);
//        root.add(login, 1,3);
//        root.add(Signup, 1,4);
//
//    }
//
//}
//
