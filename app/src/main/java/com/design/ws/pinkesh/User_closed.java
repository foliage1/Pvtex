package com.design.ws.pinkesh;

/**
 * Created by praveen on 6/29/2017.
 */
import java.io.Serializable;

/**
 * Created by pratap.kesaboyina on 15-12-2016.
 */

public class User_closed implements Serializable {


    private String firstName;


    /*private String lastName;
    private String emailId;
    private String phone;
    private String cell;*/



    public User_closed() {

    }


    public User_closed(String firstName) {
        this.firstName = firstName;
        /*this.lastName = lastName;
        this.cell = cell;
        this.phone = phone;
        this.emailId = emailId;
*/
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

   /* public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }*/


}