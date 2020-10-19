import java.math.BigDecimal;


/**
 * У каждого клиента есть сумма денег на счету (число).
 * Деньги можно положить на счёт, снять и вернуть остаток на счёте.
 * Каждый класс должен содержать метод, который выводит информацию в консоль о счёте:
 * условие пополнения, условие снятия и баланс.
 * <p>
 * 2. Реализуйте методы, при которых:
 * <p>
 * У физических лиц пополнение и снятие происходит без комиссии.
 * У юридических лиц — снятие с комиссией 1%.
 * У ИП — пополнение с комиссией 1%, если сумма меньше 1000 рублей.
 * И с комиссией 0,5%, если сумма больше либо равна 1000 рублей.
 */

public class main {

    public static void main(String[] args) {
        BigDecimal amount = new BigDecimal("10000");
        BigDecimal subtraction =new BigDecimal("1000") ;

        Clients individual = new Individual();
        Clients entity = new Entity();
        Clients entrepreneur = new Entrepreneur();

        individual.deposit(amount);
        individual.balance();
        individual.withdraw(subtraction);
        individual.balance();
    }
}
