import junit.framework.TestCase;
import java.util.HashMap;
import java.util.concurrent.CyclicBarrier;


public class BankTest extends TestCase {
    Bank testBank = new Bank();
    private static HashMap<String, Account> accounts = new HashMap<>();
    final int ACCOUNTS_AMOUNT = 1000;


    @Override
    public void setUp() throws Exception {
        for (int i = 0; i < ACCOUNTS_AMOUNT; i++) {
            long balanceOfAccount = (long) (Math.random() * 1000000);
            accounts.put(String.valueOf(i), new Account(String.valueOf(i), balanceOfAccount));
        }
        testBank.setAccounts(accounts);
        testBank.setTransfersCount(0);
        testBank.setBalanceRequestsCount(0);
    }

    public void testBankBalance() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            new Thread(this :: transferTest).start();
            for (int j = 0; j < (int) (Math.random() * 5 + 5); j++) {
                new Thread(this :: getBalanceTest).start();
            }
        }
        int numCore = Runtime.getRuntime().availableProcessors();
        new CyclicBarrier(numCore);
        System.out.println("Время выполнения: " + (System.currentTimeMillis() - startTime));
        System.out.println("Количество счетов в банке: " + accounts.keySet().size());
        System.out.println("Количество заблокированных счетов: "+ Bank.getFraudList().size());
        System.out.println("Осуществлено " + testBank.getTransfersCount() + " транзакций по переводу средств");
        System.out.println("Осуществлено " + testBank.getRecBalanceCount() + " запросов баланса");
        System.out.println("Транзакций проверенных на мошенничество: " + testBank.getFraudTestCounter());
        Thread.sleep(10000);
        System.out.println("Транзакций проверенных на мошенничество: " + testBank.getFraudTestCounter());


    }

    @Override
    public void tearDown() throws Exception {
    }

    public void transferTest() {
        try {
            String fromAccount = String.valueOf((int) (Math.random() * ACCOUNTS_AMOUNT));
            String toAccount = String.valueOf((int) (Math.random() * ACCOUNTS_AMOUNT));
            long transferSum = (long) (Math.random() * 52500);
            testBank.transfer(fromAccount, toAccount, transferSum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getBalanceTest() {
        String account = String.valueOf((int) (Math.random() * ACCOUNTS_AMOUNT));
        testBank.getBalance(account);
    }
}