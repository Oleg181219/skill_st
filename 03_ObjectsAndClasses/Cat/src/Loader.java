
public class Loader {

    public static void main(String[] args) {

        Cat murka = new Cat();
        Cat vasiliy = new Cat();
        Cat pushok = new Cat();
        Cat dymok = new Cat();
        Cat kot = new Cat();
        Cat cat = new Cat();
        Cat evil = new Cat();

        Cat first = getKitten();
        Cat second = getKitten();
        Cat third = getKitten();
        System.out.println("first весит - " + first.getWeight());
        System.out.println("second весит - " + second.getWeight());
        System.out.println("third весит - " + third.getWeight());

        // кошка 1 покормлена. проверка в изменении веса
        System.out.println(" Вес кошки evil до приема пищи - " + evil.getWeight() + " gramm ");
        evil.feed(300);
        System.out.println(" Кошка evil стала весить " + evil.getWeight() + " gramm ");

        // кошка 1 покормлена. проверка в изменении веса
        System.out.println(" Вес кошки cat до приема пищи - " + cat.getWeight() + " gramm ");
        cat.feed(500);
        System.out.println(" Кошка cat стала весить - " + cat.getWeight() + " gramm ");
        System.out.println("================================================================");

        //===========================
        cat.setCatColour(Colour.Bicolor);
        murka.setCatColour(Colour.Chocolate);
        System.out.println( murka.getCatColour() + "  " + murka.getWeight());
       //=====================================
        murka.setNewColour(cat.getCatColour());
        murka.setNewWeight(cat.getWeight());
        System.out.println("================================");
        System.out.println("кошка cat весит " + cat.getWeight() + " цвет кошки " + cat.getCatColour() );
        System.out.println("кошка murka весит " + murka.getWeight() + " цвет кошки " + murka.getCatColour() );

/*


        System.out.println("====================");
        System.out.println(" Кот kot расстратил всю энергию, похудел и - " + kot.getStatus());
        Cat.count--;
        System.out.println("... и их осталось " + Cat.getCount());
        System.out.println("====================");
        kot.meow();                                 // проверка на возможность мяукнуть при статусе dead
        kot.pee();                                  // проверка на возможность сходить в... при статусе dead
        kot.feed(500);                      // проверка на возможность покормить при статусе dead
        System.out.println(kot.getStatus());        // вывод статуса кота Kot(статус не меняется. кот мертв)

        // доводим кота dymok до состтояния дымка. садисты ( взрыв от переедания)
        while (dymok.getStatus() != "Exploded") {
            dymok.feed(200);
            dymok.drink(20);
            if (dymok.getStatus() == "Exploded"){
                Cat.count--;
            }
             System.out.println("dymok немного перекусил и стал весить " + dymok.getWeight() + " gramm");
        }
        System.out.println("====================");
        System.out.println(" Кот dymok переел и в результате  - " + dymok.getStatus());
        System.out.println("... и их осталось " + Cat.getCount());
        System.out.println("====================");

        // Кормим кошку и расчитываем сумму съеденного корма
        pushok.feed(300);
        pushok.feed(200);
        System.out.println("Пушок сумарно съел - " + pushok.getFood() + " грамм еды");
        System.out.println("====================");

        // пушок ходит в туалет
        System.out.println("====================");
        System.out.println(" Пушок весит - " + pushok.getWeight());
        pushok.pee();
        pushok.pee();
        pushok.pee();
        pushok.pee();
        pushok.pee();
        pushok.pee();
        System.out.println(" После походов в туалет Пушок стал весить - " + pushok.getWeight());
        System.out.println("====================");
        System.out.println("... и их осталось  " + Cat.getCount() + " (Агата Кристи) ");

*/
    }


    public static Cat getKitten(){
        return new Cat(1000.00);
    }


}
