import java.math.BigDecimal;

public class Company {

    private BigDecimal incoming = new BigDecimal(0);
/*
    void hire (Employee emp){

    }

    public void hireAll() {

    }

    void fire() {

    }


    void getTopSalaryStaff(int count) {

    }

    void getLowestSalaryStaff(int count) {

    }*/
    public BigDecimal getIncoming() {
        //System.out.println(incoming);

        return incoming;
    }

    public void setIncoming(BigDecimal incoming) {
        this.incoming = incoming;
    }
}

