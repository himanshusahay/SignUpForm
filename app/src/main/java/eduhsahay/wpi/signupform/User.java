package eduhsahay.wpi.signupform;

import java.io.Serializable;

/**
 * Created by Himanshu on 6/9/2015.
 */
public class User implements Serializable {
    private String mUsername;
    private String mPassword;

    User(String username, String password){
        this.mUsername = username;
        this.mPassword = password;
    }

    public String getmUsername(){
        return mUsername;
    }

}


