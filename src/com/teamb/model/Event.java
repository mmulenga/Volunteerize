package com.teamb.model;

import java.util.ArrayList;
import java.util.Date;
/**
 * Represents a volunteering event.
 */


public class Event {

	private int eventID;
	private int startTime;    // 24 hour clock
	private int endTime;        // 24 hour clock
	private Date startDate;
	private Date endDate;

	private String eventName;
	private String location;
	private String description;


	///////////////////////////// Sean's edits
	public Event() {
		//sets all to base arbitrary values

		eventID = 00000000;
		eventName = "void";
		startTime = 1200;
		endTime = 1300;
		startDate = new Date(0001,01,01);
		endDate = new Date(0001,01,01);

		location = "void";
		description = "void";
	}

	////////////////////////////////////////////////////////
	// set specified fields

	/**
	 * setAllFields(ID,name,sTime,eTime,sDate,eDate,location,description)
	 *
	 * @param            ID - int eventID
	 * @param            name - String eventName
	 * @param            sTime - int start time
	 * @param            eTime - int end time
	 * @param            sDate - Date start Date
	 * @param            eDate - Date end date
	 * @param            location - String location of event
	 * @param            description - description of event
	 * <p>
	 * post          all values are initialized
	 * return 		void - nothing
	 */
	public void setEventFields(int ID, String name, int sTime, int eTime, Date sDate, Date eDate, String location, String description) {
		setEventID(ID);
		setEventName(name);
		setStartTime(sTime);
		setEndTime(eTime);
		setStartDate(sDate);
		setEndDate(eDate);
		setLocation(location);
		setDescription(description);
	}

	/**
	 * setEventID(ID)
	 *
	 * @param ID - int eventID
	 */
	public void setEventID(int ID) {
		this.eventID = ID;
	}

	/**
	 * setEventName(name)
	 *
	 * @param name - String event name
	 */
	public void setEventName(String name) {
		this.eventName = name;
	}

	/**
	 * setStartDate(time)
	 *
	 * @param time - int event start time (24 hour clock)
	 */
	public void setStartTime(int time) {
		this.startTime = time;
	}

	/**
	 * setEndTime(time)
	 *
	 * @param time - int event end time (24 hour clock)
	 */
	public void setEndTime(int time) {
		this.endTime = time;
	}

	/**
	 * setStartDate(date)
	 *
	 * @param date - int event start date (ddmmyy)
	 */
	public void setStartDate(Date date) {
		this.startDate = date;
	}

	/**
	 * steEndDate(date)
	 *
	 * @param date - int event end date (ddmmyy)
	 */
	public void setEndDate(Date date) {
		this.endDate = date;
	}

	/**
	 * setLocation(local)
	 *
	 * @param local - String event location
	 */
	public void setLocation(String local) {
		this.location = local;
	}

	/**
	 * setDescription(describe)
	 *
	 * @param describe - String event description
	 */
	public void setDescription(String describe) {
		this.description = describe;
	}

	///////////////////////////////////////////////////////
	// get info from specified field

	public int getEventID() {
		return this.eventID;
	}

	public String getEventName() {
		return this.eventName;
	}

	public int getStartTime() {
		return this.startTime;
	}

	public int getEndTime() {
		return this.endTime;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public String getLocation() {
		return this.location;
	}

	public String getDescription() {
		return this.description;
	}


	/////////////////////////////////////////////////////
	// delete a profile
	public boolean deleteEvent() {
		// call dataBase function 

		// delete(this)

		return true;
	}
}

