import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkTask extends RecursiveAction {

    private String insert;

    public ForkTask(String insert) {
        this.insert = insert;
    }

    @Override
    protected void compute() {
        try {
            DBConnection.executeMultiInsert();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
