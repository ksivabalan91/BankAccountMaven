package sg.edu.nus.iss;

import java.util.UUID;

import DBS.BankAccount;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Banking");

        int n =3;

        BankAccount[] bankAccount = new BankAccount[n];

        for (int i =0; i < bankAccount.length;i++){
            String uuid = UUID.randomUUID().toString();

            bankAccount[i] = new BankAccount(uuid);
        }
    }
}
