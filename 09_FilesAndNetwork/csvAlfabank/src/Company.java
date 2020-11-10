public class Company {
    private String nameCompany;
    private double money;


    public Company(String nameCompany, double money) {
        this.nameCompany = nameCompany;
        this.money = money;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
