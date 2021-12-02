import java.util.Scanner;

public class Caeser {
    public static void main(String[] args) {
        String cipher;
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        int userIn = -1;

        if (args.length == 0) {
            System.out.println("Enter set to decode: ");
            cipher = input.nextLine();
        } else {
            cipher = "";
            for (String str : args) {
                cipher = cipher.concat(str);
            }
        }

        while (true) {
            System.out.println("DECODE: " + cipher);

            System.out.println("1 Encode to x");
            System.out.println("2 Show all encodings");
            System.out.println("3 Increment encode");
            System.out.println("4 Decrement encode");
            System.out.println("5 Redeclare cipher");
            System.out.println("0 Quit");

            do {
                try {
                    System.out.println("Enter command: ");
                    userIn = input.nextInt();

                    if (userIn < 0 || userIn > 5) {
                        throw new Exception("Enter command 1-4");
                    }

                    valid = true;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } while (!valid);

            switch (userIn) {
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("Enter step to Encode to");
                    int in = input.nextInt() % 26;
                    System.out.println(encodeToX(cipher, in));
                case 2:
                    //FIXME
                case 3:
                    //FIXME
                case 4:
                    //FIXME
                case 5:
                    //FIXME
            }
        }
    }

    public static String encodeToX(String pass, int setUps) {
        char[] chars = new char[pass.length()];
        char toAddIn;

        for (int i = 0; i < pass.length(); i++) {
            toAddIn = pass.charAt(i);

            if (Character.isAlphabetic(toAddIn)) {

                if (Character.isUpperCase(toAddIn)) {

                    if ((int) toAddIn + setUps > 90) {
                        toAddIn = (char) (toAddIn - 25 + (setUps - 1));
                    } else if ((int) toAddIn + setUps < 65) {
                        toAddIn = (char) (toAddIn + 25 + (setUps - 1));
                    }

                } else if (Character.isLowerCase(toAddIn)) {

                    if ((int) toAddIn + setUps > 122) {
                        toAddIn = (char) (toAddIn - 25 + (setUps - 1));
                    } else if ((int) toAddIn + setUps < 97) {
                        toAddIn = (char) (toAddIn + 25 + (setUps - 1));
                    }

                } else {

                    toAddIn = (char) (toAddIn + setUps);

                }
            }

            chars[i] = toAddIn;
        }

        return new String(chars);
    }
}
