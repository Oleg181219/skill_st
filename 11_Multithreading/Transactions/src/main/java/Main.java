public class Main {

    Bank bank = new Bank();

    public static void main(String[] args)  {
        Bank bank = new Bank();
        bank.setNumberAccounts(10000);
        bank.setMaxSumOnAccount(999999);
        bank.addAccounts();

        for (int i = 0; i < 100000; i++) {
            new Thread(bank).start();
        }

        System.out.println("счетчик переводов: " + bank.getTransferCount());
        System.out.println("баланс банка стартовый: " + bank.getBankBallanceStart());
        System.out.println("количество заблокированных аккаунтов: " + Bank.getFraudList().size()
                + "- тестер количества операций проверки на фрод: " + bank.getFraudTestCounter());
        System.out.println("количество запросов баланса: " + bank.getRecBalanceCount());
    }
}
