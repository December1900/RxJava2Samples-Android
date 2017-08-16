package net.december1900.rxjava2samples_android.model;

/**
 * Created by december on 2017/8/16.
 */

public class Money{

    public String RMB;
    public String Dollars;
    public String EURCNY;

    public Money(String RMB,String Dollars, String EURCNY){
        this.RMB = RMB;
        this.Dollars = Dollars;
        this.EURCNY = EURCNY;
    }
    public String getRMB() {
        return RMB;
    }

    public void setRMB(String RMB) {
        this.RMB = RMB;
    }

    public String getDollars() {
        return Dollars;
    }

    public void setDollars(String dollars) {
        Dollars = dollars;
    }

    public String getEURCNY() {
        return EURCNY;
    }

    public void setEURCNY(String EURCNY) {
        this.EURCNY = EURCNY;
    }
}


