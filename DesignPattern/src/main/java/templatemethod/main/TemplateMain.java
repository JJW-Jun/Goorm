package templatemethod.main;

import templatemethod.AbstGameConnectHelper;
import templatemethod.DefaultGameConnection;

public class TemplateMain {
    public static void main(String args []){
        AbstGameConnectHelper helper = new DefaultGameConnection();
        helper.requestConnection("아이디 암호 등 접속 정보");


    }
}
