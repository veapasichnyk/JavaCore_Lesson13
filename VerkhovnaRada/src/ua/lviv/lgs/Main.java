package ua.lviv.lgs;

import java.util.Scanner;

public class Main {

    static void menu() {
        System.out.println ( "\n Введіть 1 щоб додати фракцію\n" +
                             " Введіть 2 щоб видалити конкретну фракцію\n" +
                             " Введіть 3 щоб вивести усі  фракції\n" +
                             " Введіть 4 щоб очистити конкретну фракцію\n" +
                             " Введіть 5 щоб вивести конкретну фракцію\n" +
                             " Введіть 6 щоб додати депутата в фракцію\n" +
                             " Введіть 7 щоб видалити депутата з фракції\n" +
                             " Введіть 8 щоб вивести список хабарників\n" +
                             " Введіть 9 щоб вивести найбільшого хабарника\n"

                           );
    }
    public static void main ( String [] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            menu();

            switch (scanner.nextInt()) {

                case 1: {
                    VerkhovnaRada.getInstance().addDelegateGroup();
                    break;
                }

                case 2: {
                    VerkhovnaRada.getInstance().removeDelegateGroup();
                    break;
                }

                case 3: {
                    VerkhovnaRada.getInstance().getAllDelegateGroups();
                    break;
                }

                case 4: {
                    VerkhovnaRada.getInstance().clearDelegateGroup();
                    break;
                }

                case 5: {
                    VerkhovnaRada.getInstance().getDelegateGroup();
                    break;
                }

                case 6: {
                    VerkhovnaRada.getInstance().addDelegateToDelegateGroup ();
                    break;
                }

                case 7: {
                    VerkhovnaRada.getInstance().removeDelegateFromDelegateGroup ();
                    break;
                }

                case 8: {
                    VerkhovnaRada.getInstance().getBribeTakersFromDelegateGroup ();
                    break;
                }

                case 9: {
                    VerkhovnaRada.getInstance().getLargestBribeTakerFromDelegateGroup ();
                    break;
                }

                default: {
                    System.out.println("Введіть число від 1 до 9!");
                    break;
                }
            }
        }
    }
}
