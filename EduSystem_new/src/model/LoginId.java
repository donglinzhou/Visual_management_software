package model;

import java.util.ArrayList;


public class LoginId {
    private ArrayList<Object> loginTxt = new ArrayList<Object>();

    public LoginId(){
        this.loginTxt = new ArrayList<Object>();
    }

    public ArrayList<Object> textProperty() {
        return loginTxt;
    }

    public final String getId() {
        return textProperty().get(0).toString();
    }
    
    public final String getPassword() {
        return textProperty().get(1).toString();
    }

    
    public final void setText(String id, String password) {
        textProperty().add(0, id);
        textProperty().add(1, password);
    }
    
	
}
