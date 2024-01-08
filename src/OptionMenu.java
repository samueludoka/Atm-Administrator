import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'#'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogIn() throws IOException {
        int x = 1;
        do {
            try {
                data.put(2070929980, 9944);
                data.put(2090847287, 2342);
                data.put(2090845287, 2322);
                data.put(2075677103, 9942);

                System.out.println("Welcome to smart ATM!");

                System.out.println("Enter Your Account Number");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter your pin: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "invalid character(s). only numbers." + "\n");
                x = 2;
            }
            for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
                    getAccountType();
                }
            }
            System.out.println("\n" + "wrong Customer Number or pin Number." + "\n");
        } while (x == 1);
    }

    public void getAccountType() {
        System.out.println("select Options: ");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Savings Account");
        System.out.println("Type 3 - Exit");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();
        switch (selection) {
            case 1:
                getChecking();
                break;
            case 2:
                getSavings();
                break;
            case 3:
                System.out.println("thank you for using smart ATM, bye.");
                break;
            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getAccountType();
        }
    }

    public void getChecking() {
        System.out.println("Checking Account: ");
        System.out.println("1 - view Balance");
//        System.out.println("2 - withdraw funds");
//        System.out.println("3 - Deposit funds");
        System.out.println("4 - Exit");
        System.out.println("Choice");

        int selection = menuInput.nextInt();
        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
//            case 2:
//                getCheckingWithdrawInput();
//                getAccountType();
//                break;
//            case 3:
//                getCheckingDepositInput();
//                getAccountType();
//                break;
            case 4:
                System.out.println("Thank you for using Smart ATM, bye.");
                break;
            default:
                System.out.println("\n" + "Invalid choice." + "\n");
                getChecking();

        }
    }

    public void getSavings() {
        System.out.println("Savings Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - withdraw Funds");
        System.out.println("Type 3 - Deposit Funds Funds");
        System.out.println("Type 4 - Exist");
        System.out.println("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("savings Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using Smart ATM, bye.");
                break;
            default:
                System.out.println("\n" + "Invalid choice." + "\n");
                getSavings();
        }
    }
}
