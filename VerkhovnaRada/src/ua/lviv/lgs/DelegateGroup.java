package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DelegateGroup {
    private String delegateGroupName;

    public DelegateGroup ( String delegateGroupName ) {
        this.delegateGroupName = delegateGroupName;
    }

    public String getDelegateGroupName ( ) {
        return delegateGroupName;
    }

    ArrayList <Delegate> delegatesGroupArray = new ArrayList <Delegate> ( );

    public void addDelegate ( ) {
        Scanner scanner = new Scanner ( System.in );
        System.out.println ( "Введіть прізвище депутата:" );
        String lastName = scanner.next ( );
        System.out.println ( "Введіть ім'я депутата:" );
        String firstName = scanner.next ( );
        System.out.println ( "Введіть вік депутата:" );
        int age = scanner.nextInt ( );
        System.out.println ( "Введіть вагу депутата:" );
        int weight = scanner.nextInt ( );
        System.out.println ( "Введіть ріст депутата:" );
        int height = scanner.nextInt ( );
        System.out.println ( "Чи бере депутат хабарі (true/false):" );
        boolean bribeTaker = scanner.nextBoolean ( );

        Delegate delegate = new Delegate ( lastName , firstName , age , bribeTaker , weight , height );

        if ( delegate.isBribeTaker ( ) ) {
            delegate.takeBribe ();
        }

        delegatesGroupArray.add ( delegate );
        System.out.println ( "Депутат " + delegate.toString () + " успішно доданий у фракцію");
    }

    public void removeDelegate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println ( "Введіть прізвище депутата:" );
        String lastName = scanner.next ( );
        System.out.println ( "Введіть ім'я депутата:" );
        String firstName = scanner.next ( );

        boolean typeCorrect = isDelegateExists(delegatesGroupArray, lastName, firstName);

        if (typeCorrect) {

            Iterator<Delegate> iterator = delegatesGroupArray.iterator();

            while (iterator.hasNext()) {
                Delegate nextDelegate = iterator.next();

                if (nextDelegate.getLastName().equalsIgnoreCase(lastName) && nextDelegate.getFirstName().equalsIgnoreCase(firstName)) {
                    iterator.remove();
                    System.out.println("Депутат " + nextDelegate.toString() + " успішно вилучений із фракції!");
                }
            }

        } else {
            System.out.println("Такого депутата у жодній із фракцій не знайдено!");
        }
    }

    public void getBribeTakers() {
        System.out.println("Депутати хабарники:");
        for (Delegate delegate : delegatesGroupArray) {
            if (delegate.isBribeTaker()) {
                System.out.println(delegate.toString());
            }
        }
    }

    public void getLargestBribeTaker() {
        int bribeSize = 0;
        int delegateIndex = -1;

        for (int i = 0; i < delegatesGroupArray.size(); i++) {
            if (delegatesGroupArray.get(i).isBribeTaker()) {
                if (delegatesGroupArray.get(i).getBribeSize() > bribeSize) {
                    bribeSize = delegatesGroupArray.get(i).getBribeSize();
                    delegateIndex = delegatesGroupArray.indexOf(delegatesGroupArray.get(i));
                }
            }
        }

        if (delegateIndex >= 0) {
            System.out.println("Найбільший хабарник фракції " + delegatesGroupArray.get(delegateIndex).toString() + ". Ганьба!");
        } else {
            System.out.println("У цієї фракції хабарників не має!");
        }
    }

    public void getAllDelegates() {
        System.out.println("Депутати даної фракції: ");
        for (Delegate delegate : delegatesGroupArray) {
            System.out.println(delegate.toString());
        }
    }

    public void clearDelegatesGroup() {
        delegatesGroupArray.clear();
        System.out.println("Всі депутати успішно видалені із фракції!");
    }

    static boolean isDelegateExists ( ArrayList<Delegate> delegatesGroupArray, String lastName, String firstName) {
        boolean flag = false;

        for (Delegate delegate : delegatesGroupArray) {
            if (delegate.getLastName ().equalsIgnoreCase(lastName) && delegate.getFirstName().equalsIgnoreCase(firstName)) {
                flag = true;
            }
        }

        return flag;
    }
}