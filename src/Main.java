import java.util.*;
import com.insurance.main.*;
import com.insurance.model.*;
public class Main {
    static String userName = "admin";
    static String password = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Are you admin or customer");
        String input = sc.nextLine();
        if (input.equals("admin")) {
            System.out.println("Enter your username");
            String un = sc.nextLine();
            System.out.println("Enter your password");
            String pa = sc.nextLine();

            if (un.equals(userName) && pa.equals(password)) {
                System.out.println("You are verified as admin, choose what you want to do");
                System.out.println("1. create customer");
                System.out.println("2. create bulk customer");
                System.out.println("3. delete customer");
                System.out.println("4. delete policy");
                int a = sc.nextInt();


                switch (a) {
                    case 1:
                        System.out.println("Enter your information");
                        System.out.println("Enter customer's first name: ");
                        String firstName = sc.nextLine();
                        System.out.println("Enter customer's middle name: ");
                        String middleName = sc.nextLine();
                        System.out.println("Enter customer's lastname: ");
                        String lastName = sc.nextLine();
                        System.out.println("Enter customer's password: ");
                        String password = sc.nextLine();
                        System.out.println("Enter customer's date of birth (MM-DD-YYYY): ");
                        String customerDob = sc.nextLine();

                        System.out.println("Enter Address (0000 st-address, city, STATE-CODE zip-code, country): ");
                        String strAddress = sc.nextLine();
                        Address customerAddress = new Address(strAddress); //

                        System.out.println("Enter email: ");
                        String email = sc.nextLine();
                        System.out.println("Enter phone num (123-456-7890): ");
                        String customerMobileNumber = sc.nextLine();

                        Customer newCustomer = new Customer(
                                firstName,
                                middleName,
                                lastName,
                                password,
                                customerDob,
                                customerAddress,   // address object
                                email,
                                customerMobileNumber
                        );
                        break;

                    case 2:
                        CustomerManagementModule.createAuto();
                        break;

                    case 3:
                        System.out.println("Enter the customer id you want to delete");
                        int id = sc.nextInt();
                        CustomerManagementModule.deleteCustomer(id);

                    case 4:
                        System.out.println("Enter the policy ID you want to delete");
                        String ID = sc.nextLine();
                        PolicyManagementModule.deletePolicy(ID);
                }

                if (input.equals("customer")) {
                    System.out.println("Enter your ID");
                    int iD = sc.nextInt();
                    System.out.println("Enter your password");
                    String pA = sc.nextLine();

                    CustomerManagementModule.searchCustomer(iD);

                    System.out.println("You are verified as a customer, choose what you want to do");
                    System.out.println("1. update data");
                    System.out.println("2. buy new policy");
                    System.out.println("3. edit details in policy");
                    System.out.println("4. file claim for policy");
                    int b = sc.nextInt();

                    switch (b) {
                        case 1:
                            System.out.println("What data would you like to update? Enter 1 for customer info and 2 for policy");
                            int c = sc.nextInt();
                            if (c == 1) {
                                CustomerManagementModule.updateCustomer(iD);
                            } else {
                                System.out.println("To update your policy, please enter your policy ID ");
                                String PID = sc.nextLine();
                                PolicyManagementModule.updatePolicy(PID);
                            }
                            break;

                        case 2:
                            System.out.println("Which policy do you want to buy");
                            PolicyManagementModule.createPolicy();
                            break;

                        case 3:
                            System.out.println("To update your policy, please enter your policy ID ");
                            String pID = sc.nextLine();
                            PolicyManagementModule.updatePolicy(pID);
                            break;

                        case 4:
                            break; //file claim for policy
                    }
                }
            }
        }
    }
}