public class xsign {

    public static void main(String[] args) {
        String[][] array = new String[7][7];


        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i != j) {
                    array[i][j] = " ";
                }
                if ((i == j) | ((i + j) == 6)) {
                    array[i][j] = "X";
                }
            }
        }


        for (String[] strings : array) {
            for (int j = 0; j < strings.length; j++) {
                System.out.print(strings[j] + " ");
            }
            System.out.println();
        }

    }
}

