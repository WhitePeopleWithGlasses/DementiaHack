/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

/**
 *
 * @author Travis
 */
public class UserLog {
    
    private int id;
    private String name;
    private String userEmail;
    private String careTaker;
    private String careTakerEmail;
    
    public UserLog(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getCareTaker() {
        return careTaker;
    }

    public void setCareTaker(String careTaker) {
        this.careTaker = careTaker;
    }

    public String getCareTakerEmail() {
        return careTakerEmail;
    }

    public void setCareTakerEmail(String careTakerEmail) {
        this.careTakerEmail = careTakerEmail;
    }
    
    
}
