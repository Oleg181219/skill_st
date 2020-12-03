import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PurchaseList")
public class PurchaseList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected PurchaseListID id;

    public PurchaseList(PurchaseListID id) {
        this.id = id;
    }

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    @Embeddable
    public class PurchaseListID implements Serializable {
        @Column(name = "student_name")
        protected String studentName;
        @Column(name = "course_name")
        protected String courseName;

        protected PurchaseListID() {
        }

        public PurchaseListID(String studentName, String course_name) {
            this.studentName = studentName;
            this.courseName = courseName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PurchaseListID purchaseListID = (PurchaseListID) o;
            if (!courseName.equals(purchaseListID.courseName)) return false;
            if (!studentName.equals(purchaseListID.studentName)) return false;
            return true;
        }

        @Override
        public int hashCode() {
            int result = studentName.hashCode();
            result = 31 * result + courseName.hashCode();
            return result;
        }

    }

    public PurchaseListID getId() {
        return id;
    }

    public void setId(PurchaseListID id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
