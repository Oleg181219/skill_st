import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "PurchaseList")
public class PurchaseList implements Serializable{

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="student_name", referencedColumnName="name")
    private Student student;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="course_name", referencedColumnName="name", nullable = false)
    private Course course;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    private int price;

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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseList)) return false;
        PurchaseList that = (PurchaseList) o;
        return getStudent().equals(that.getStudent()) &&
                getCourse().equals(that.getCourse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudent(), getCourse());
    }

}
