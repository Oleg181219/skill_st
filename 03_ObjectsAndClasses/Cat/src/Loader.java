
public class Loader {
    public static void main(String[] args) {
        Cat murka = new Cat();
        Cat vasiliy = new Cat();
        Cat pushok = new Cat();
        Cat dymok = new Cat();
        Cat kot = new Cat();
        Cat cat = new Cat();
        Cat evil = new Cat();

        // выводим веса всех кошек
        System.out.println(" murka весит - " + murka.getWeight());
        System.out.println(" vasiliy весит - " + vasiliy.getWeight());
        System.out.println(" pushok весит - " + pushok.getWeight());
        System.out.println(" dymok весит - " + dymok.getWeight());
        System.out.println(" kot весит - " + kot.getWeight());
        System.out.println(" cat весит - " + cat.getWeight());
        System.out.println(" evil весит - " + evil.getWeight());
        System.out.println("================================================================");

        // кошка 1 покормлена. проверка в изменении веса
        System.out.println(" Вес кошки evil до приема пищи - " + evil.getWeight() + " gramm ");
        evil.feed(300);
        System.out.println(" Кошка evil стала весить " + evil.getWeight() + " gramm ");

        // кошка 1 покормлена. проверка в изменении веса
        System.out.println(" Вес кошки cat до приема пищи - " + cat.getWeight() + " gramm ");
        cat.feed(500);
        System.out.println(" Кошка cat стала весить - " + cat.getWeight() + " gramm ");
        System.out.println("================================================================");

        // доводим бедного кота  kot до смерти от мяуканья. жесть пример. садисты
        while (kot.getStatus() != "Dead") {
            kot.meow();
        }
        System.out.println("====================");
        System.out.println(" Кот kot расстратил всю энергию, похудел и - " + kot.getStatus());
        System.out.println("====================");

        // доводим кота dymok до состтояния дымка. садисты ( взрыв от переедания)
        while (dymok.getStatus() != "Exploded") {
            dymok.feed(200);
            dymok.drink( 20);
            System.out.println("dymok немного перекусил и стал весить " + dymok.getWeight() + " gramm");
        }
        System.out.println("====================");
        System.out.println(" Кот dymok переел и в результате  - " + dymok.getStatus());
        System.out.println("====================");
    }
}