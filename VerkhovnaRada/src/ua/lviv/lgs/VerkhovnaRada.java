package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class VerkhovnaRada {

    private static VerkhovnaRada instance = new VerkhovnaRada();

    private VerkhovnaRada() {
    }

    public static VerkhovnaRada getInstance() {
        if (instance == null) {
            instance = new VerkhovnaRada();
        }

        return instance;
    }


    ArrayList<DelegateGroup> verkhovnaRadaArray = new ArrayList<DelegateGroup>();

    public void addDelegateGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву фракції:");
        String delegateGroupName = scanner.next();

        DelegateGroup delegateGroup = new DelegateGroup (delegateGroupName);

        verkhovnaRadaArray.add(delegateGroup);
        System.out.println(delegateGroup.toString() + " успішно додана у Верховну Раду!");
    }

    public void removeDelegateGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву фракції:");
        String delegateGroupName = scanner.next();

        boolean typeCorrect = isDelegateGroupExists( verkhovnaRadaArray, delegateGroupName);

        if (typeCorrect) {

            Iterator<DelegateGroup> iterator = verkhovnaRadaArray.iterator();

            while (iterator.hasNext()) {
                DelegateGroup nextDelegateGroup = iterator.next();

                if (nextDelegateGroup.getDelegateGroupName ().equalsIgnoreCase(delegateGroupName)) {
                    iterator.remove();
                    System.out.println( nextDelegateGroup.toString() + " успішно видалена із Верховної Ради!");
                }
            }

        } else {
            System.out.println("Цієї фракції не має у Верховній Раді!");
        }
    }

    public void getAllDelegateGroups() {
        System.out.println("Фракції зареєстровані у Верховній Раді: ");
        for (DelegateGroup delegateGroup : verkhovnaRadaArray) {
            System.out.println(delegateGroup.toString());
        }
    }

    public void clearDelegateGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву фракції:");
        String delegateGroupName = scanner.next();

        boolean typeCorrect = isDelegateGroupExists(verkhovnaRadaArray, delegateGroupName);

        if (typeCorrect) {
            for (DelegateGroup delegateGroup : verkhovnaRadaArray) {
                if (delegateGroup.getDelegateGroupName().equalsIgnoreCase(delegateGroupName)) {
                    delegateGroup.clearDelegatesGroup ();
                }
            }

        } else {
            System.out.println("Цієї фракції не має у Верховній Раді!");
        }
    }

    public void getDelegateGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву фракції: ");
        String delegateGroupName = scanner.next();

        for (DelegateGroup delegateGroup : verkhovnaRadaArray) {
            if (delegateGroup.getDelegateGroupName ().equalsIgnoreCase(delegateGroupName)) {
                System.out.println(delegateGroup.toString());
                delegateGroup.getAllDelegates ();
            }
        }
    }

    public void addDelegateToDelegateGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву фракції:");
        String delegateGroupName = scanner.next();

        boolean typeCorrect = isDelegateGroupExists(verkhovnaRadaArray, delegateGroupName);

        if (typeCorrect) {
            for (DelegateGroup delegateGroup : verkhovnaRadaArray) {
                if (delegateGroup.getDelegateGroupName ().equalsIgnoreCase(delegateGroupName)) {
                    delegateGroup.addDelegate ();
                }
            }

        } else {
            System.out.println("Цієї фракції не має у Верховній Раді!");
        }
    }

    public void removeDelegateFromDelegateGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву фракції:");
        String delegateGroupName = scanner.next();

        boolean typeCorrect = isDelegateGroupExists(verkhovnaRadaArray, delegateGroupName);

        if (typeCorrect) {
            for (DelegateGroup delegateGroup : verkhovnaRadaArray) {
                if (delegateGroup.getDelegateGroupName ().equalsIgnoreCase(delegateGroupName)) {
                    delegateGroup.removeDelegate ();
                }
            }

        } else {
            System.out.println("Цієї фракції не має у Верховній Раді!");
        }
    }

    public void getBribeTakersFromDelegateGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву фракції:");
        String delegateGroupName = scanner.next();

        boolean typeCorrect = isDelegateGroupExists(verkhovnaRadaArray, delegateGroupName);

        if (typeCorrect) {
            for (DelegateGroup delegateGroup : verkhovnaRadaArray) {
                if (delegateGroup.getDelegateGroupName ().equalsIgnoreCase(delegateGroupName)) {
                    delegateGroup.getBribeTakers();
                }
            }

        } else {
            System.out.println("Цієї фракції не має у Верховній Раді!");
        }
    }

    public void getLargestBribeTakerFromDelegateGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву фракції:");
        String delegateGroupName = scanner.next();

        boolean typeCorrect = isDelegateGroupExists( verkhovnaRadaArray, delegateGroupName );

        if (typeCorrect) {
            for ( DelegateGroup delegateGroup : verkhovnaRadaArray ) {
                if (delegateGroup.getDelegateGroupName ().equalsIgnoreCase(delegateGroupName)) {
                    delegateGroup.getLargestBribeTaker();
                }
            }

        } else {
            System.out.println("Цієї фракції не має у Верховній Раді!");
        }
    }

    public void getAllDelegatesFromDelegateGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву фракції:");
        String delegateGroupName = scanner.next();

        boolean typeCorrect = isDelegateGroupExists(verkhovnaRadaArray, delegateGroupName);

        if (typeCorrect) {
            for (DelegateGroup delegateGroup : verkhovnaRadaArray) {
                if (delegateGroup.getDelegateGroupName ().equalsIgnoreCase(delegateGroupName)) {
                    delegateGroup.getAllDelegates ();
                }
            }

        } else {
            System.out.println("Цієї фракції не має у Верховній Раді!");
        }
    }

    static boolean isDelegateGroupExists ( ArrayList <DelegateGroup> verkhovnaRadaArray, String delegateGroupName ) {
        boolean flag = false;

        for (DelegateGroup delegateGroup : verkhovnaRadaArray) {
            if (delegateGroup.getDelegateGroupName ().equalsIgnoreCase(delegateGroupName)) {
                flag = true;
            }
        }

        return flag;
    }
}
