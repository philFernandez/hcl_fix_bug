
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        List<Integer> expenseList = new ArrayList<>();
        expenseList.add(1000);
        expenseList.add(2300);
        expenseList.add(45000);
        expenseList.add(32000);
        expenseList.add(110);

        optionsSelection(expenseList);

    }

    private static void optionsSelection(List<Integer> expenses) {
        int opt = 0;
        Scanner sc = new Scanner(System.in);
        do {
            String[] arr = {"1. I wish to review my expenditure",
                    "2. I wish to add my expenditure",
                    "3. I wish to delete my expenditure",
                    "4. I wish to sort the expenditures",
                    "5. I wish to search for a particular expenditure",
                    "6. Close the application"};

            for (String str : arr) {
                System.out.println(str);
            }

            System.out.println("\nEnter your choice:\t");
            opt = sc.nextInt();


            switch (opt) {
                case 1:
                    System.out.println("Your saved expenses are listed below: \n");
                    System.out.println(expenses + "\n");
                    break;
                case 2:
                    System.out.println("Enter the value to add your Expense: \n");
                    int value = sc.nextInt();

                    expenses.add(value);
                    System.out.println("Your value is updated\n");
                    System.out.println(expenses + "\n");

                    break;
                case 3:
                    System.out.println(
                            "You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
                    int con_choice = sc.nextInt();
                    if (con_choice == opt) {
                        expenses.clear();
                        System.out.println(expenses + "\n");
                        System.out.println("All your expenses are erased!\n");
                    } else {
                        System.out.println("Oops... try again!");
                    }
                    break;
                case 4:
                    sortExpenses(expenses);
                    break;
                case 5:
                    System.out.println("Enter the expense you need to search:\t");
                    int term = sc.nextInt();
                    searchExpenses(expenses, term);
                    break;
                case 6:
                    closeApp();
                    break;
                default:
                    System.out.println("You have made an invalid choice!");
                    break;

            }

        } while (opt != 6);
        sc.close();
    }

    private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
    }

    private static void searchExpenses(List<Integer> arrayList, int term) {
        List<Integer> copy = new ArrayList<>(arrayList);
        copy.sort((n1, n2) -> n1 - n2);
        int idx = Collections.binarySearch(copy, term);

        if (idx >= 0) {
            System.out.println(copy.get(idx) + " IS in the expenses.\n");
        } else {
            System.out.println(term + " IS NOT in the expenses\n");
        }

    }

    private static void sortExpenses(List<Integer> arrayList) {
        arrayList.sort((n1, n2) -> n1 - n2);
        System.out.println(arrayList);
        System.out.println();
    }
}
