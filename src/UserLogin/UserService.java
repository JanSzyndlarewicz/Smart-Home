package UserLogin;

import java.io.Serializable;
import java.util.Scanner;

public class UserService implements Serializable {

    public UserService(){}

    public static void userRegistration(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("User Registration\n");
        System.out.print("Enter login: ");
        String login = scanner.nextLine();
        System.out.print("Enter the password: ");
        String password = scanner.nextLine();

        if(UserDataBase.register(login, password)){
            System.out.println("Registration succeeded\n");
        }
        else {
            System.out.println("Registration failed (login already taken)\n");
        }
    }

    public static void userLogin(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("User Login\n");
        System.out.print("Enter login: ");
        String login = scanner.nextLine();
        System.out.print("Enter the password: ");
        String password = scanner.nextLine();

        if(UserDataBase.login(login, password)){
            System.out.println("Login succeeded\n");
        }
        else {
            System.out.println("Login failed\n");
        }
    }

    public static void userRemove(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("User Removal\n");
        System.out.print("Enter login: ");
        String login = scanner.nextLine();
        System.out.print("Enter the password: ");
        String password = scanner.nextLine();

        if(UserDataBase.remove(login, password)){
            System.out.println("Removal succeeded\n");
        }
        else {
            System.out.println("Removal failed\n");
        }
    }


}
