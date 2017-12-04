package com.teamb.controller;

import com.teamb.model.Event;
import com.teamb.model.Profile;
import com.teamb.model.VolunteerizeModel;
import com.teamb.view.BasicView;
import com.teamb.view.CreateEventView;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDate;
import java.util.Date;

public class CreateEventController extends BasicController {

    CreateEventView view;
    Event event;

    public CreateEventController(Stage s, VolunteerizeModel m) {
        super(s, m);
        view = new CreateEventView();
        view.submit.setOnAction(new submitEventHandler());
        view.clear.setOnAction(new clearEventHandler());
        view.home.setOnAction(new homeEventHandler());
    }

    class submitEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            createNewEvent();
            completePopUP();
        }
    }


    class homeEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            changeToHomePageView(stage);

        }
    }

    class clearEventHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            view.eventTitleField.clear();
            view.locationField.clear();
            view.descriptionArea.clear();


            view.startDatePicker.setValue(LocalDate.now());
            view.endDatePicker.setValue(view.startDatePicker.getValue().plusDays(1));
        }
    }


    @Override
    public BasicView GetView() {
        return view;
    }


    public void createNewEvent() {
        if(view.startHour.getValue()>23){
            view.startHour.getValueFactory().setValue(23);
        }
        if(view.endHour.getValue()>23){
            view.endHour.getValueFactory().setValue(23);
        }
        if(view.startMin.getValue()>59){
            view.startMin.getValueFactory().setValue(59);
        }
        if(view.endMin.getValue()>59){
            view.endMin.getValueFactory().setValue(59);
        }

        int startTime = (view.startHour.getValue()*100)+view.startMin.getValue();
        int endTime = (view.endHour.getValue()*100)+view.endMin.getValue();
        System.out.println(startTime);
        System.out.println(endTime);

        event = new Event();
        model = new VolunteerizeModel();
       // event.setEventID();
        event.setEventName(view.eventTitleField.getText());
        event.setStartTime(startTime);
        event.setEndTime(endTime);
        event.setStartDate( view.startDatePicker.getEditor().getText());
        event.setEndDate( view.endDatePicker.getEditor().getText());
        event.setLocation(view.locationField.getText());
        event.setDescription(view.descriptionArea.getText());
        model.addEvent(event);
    }

    /**
     * Pop up box to alert user of newly created Event
     * and a button that goes to the upcoming events
     *
     */
    public void completePopUP(){
        Stage popupwindow=new Stage();

        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Volunteerize");


        Label completeInformationLabel= new Label(event.getEventName() + " has now been created");
        Button profileButton= new Button("Go to Manage Events");
        profileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                popupwindow.close();
                ChangeToManageEventsView();

            }
        });

        VBox layout= new VBox(10);
        layout.getChildren().addAll(completeInformationLabel, profileButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene1= new Scene(layout, 300, 250);
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();

    }

    public void changeToHomePageView(Stage s){
        StaffLandingController slc = new StaffLandingController(s, model);

        Scene scene = new Scene(slc.GetView().GetRootPane(), 720, 540);
        s.setScene(scene);
        s.show();

    }


    /*public String CreateDate(String date){
        String day = date.substring(0, 2);
        String month = date.substring(3, 4);
        String year= date.substring(4, 5);

        //Date tempDate = new Date();
        String tempDate = ("" + day + "" + month + "" + year);
        return tempDate;
    }*/

    public void changeToUpcomingEventPageView(Stage s){
        EventController evPageView = new EventController(s, model);

        Scene scene = new Scene(evPageView.GetView().GetRootPane(), 720, 540);
        s.setScene(scene);
        s.show();

    }

}
