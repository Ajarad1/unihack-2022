import java.util.HashMap;

public class IDPasswords {

    HashMap<String,String> logininf = new HashMap<String,String>();

    IDPasswords (){
        logininf.put("David","cascaval");
    }

    public void setaccount (String a, String b)
    {
        logininf.put(a,b);
    }

    protected HashMap getlogininfo() {
        return logininf;
    }
}