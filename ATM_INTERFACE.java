package Oasis_tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class ATM_INTERFACE{
    String Full_Name;
    String Date_Of_Birth;
    String Gender;
    String Gender1="M";
    String Gender2="m";
    String Gender3="F";
    String Gender4="f";
    String User_Name;
    String Account_Number;
    String Password;
    String Pin;
    String Phone_Number;
    String Transaction_History="Your Transaction History: \n";
    Scanner input=new Scanner(System.in);
    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    LocalDateTime now =LocalDateTime.now();
    float Balance=0f;
    int Transactions=0;
    public void View_Profile(){
        System.out.println("Your Profile: \n");
        System.out.println("Full-Name: "+this.Full_Name);
        System.out.println("Date of Birth: "+this.Date_Of_Birth);
        System.out.println("Gender: "+this.Gender);
        System.out.println("Username: "+this.User_Name);
        System.out.println("Password: "+this.Password);
        System.out.println("Account Number: "+this.Account_Number);
        System.out.println("4-Digit-Pin(Don't share with anyone): "+this.Pin);
        System.out.println("Phone Number: "+this.Phone_Number);
    }
    public void Register(){
        System.out.println("...Registration...");
        System.out.print("Enter Full Name: ");
        this.Full_Name=input.nextLine();
        System.out.print("Enter Date of Birth(dd/mm/yyyy): ");
        this.Date_Of_Birth=input.nextLine();
        System.out.print("Enter Gender(M/F): ");
        this.Gender=input.nextLine();
        while(!((((this.Gender).equals(this.Gender1)) || ((this.Gender).equals(this.Gender2))) || (((this.Gender).equals(this.Gender3)) || ((this.Gender).equals(this.Gender4))))){
            System.out.print("Invalid...Please enter correct Gender(M/F): ");
            this.Gender=input.nextLine();
        }
        if(this.Gender.equals(this.Gender1) || this.Gender.equals(this.Gender2)){
            this.Gender="Male";
        }
        else{
            this.Gender="Female";
        }
        //System.out.print(this.Gender);
        System.out.print("Enter Username: ");
        this.User_Name=input.nextLine();
        System.out.print("Enter Password: ");
        this.Password=input.nextLine();
        System.out.print("Enter Account_Number: ");
        this.Account_Number=input.nextLine();
        while((Account_Number.length())!=10){
            System.out.print("!!! Please Enter Valid 10 Digit Account Number: ");
            this.Account_Number=input.nextLine();
        }
        System.out.print("Enter 4-Digit-Pin: ");
        this.Pin=input.nextLine();
        while((Pin.length())!=4){
            System.out.print("!!! Please Enter Valid 4 Digit Pin: ");
            this.Pin=input.nextLine();
        }
        System.out.print("Enter Phone Number: ");
        this.Phone_Number=input.nextLine();
        while((Phone_Number.length())!=10){
            System.out.print("!!! Please Enter Valid 10 Digit Mobile Number: ");
            this.Phone_Number=input.nextLine();
        }
        System.out.println("Your are Successfully Registered...");
        System.out.println("Kindly login to your account to perform any transactions...");
    }
    public boolean Login(){
        boolean log=false;
        while(!log){
            System.out.print("Enter Account Number : ");
            String Acct_Number;
            Acct_Number =input.nextLine();
            if (Acct_Number.equals(Account_Number)){
                System.out.print("Enter 4 Digit Pin : ");
                String pinpass;
                pinpass=input.nextLine();
                System.out.print("Conform Your 4 Digit Pin : ");
                String conpin;
                conpin=input.nextLine();
                if(conpin.equals(pinpass)){
                    while(!log){
                        if(pinpass.equals(Pin)){
                            System.out.println("Logged-in Successfully!!");
                            log=true;
                        }
                        else{
                            System.out.println("Enter correct pin!!");
                            break;
                        }
                    }
                }
                else{
                    System.out.println("Please enter the same pin twice...");
                }
            }
            else{
                System.out.println("Register to login...");
            }
        }
        return log;
    }
    public void Deposit(){
        System.out.print("Enter amount to deposit into your Account : ");
        float Deposit_Amount;
        Deposit_Amount=input.nextFloat();
        if(Deposit_Amount>500000f){
            System.out.println("This ATM is not capable to deposit money beyond 5,00,000/-");
        }
        else{
            Balance=Balance+Deposit_Amount;
            Transactions=Transactions+1;
            System.out.println("Successfully deposited Rs. "+Deposit_Amount+" into your account at "+dtf.format(now));
            System.out.println("Your Current Balance after this transaction is: "+Balance);
            String History=" ";
            History="\n Rs "+Deposit_Amount+" deposited at "+dtf.format(now)+" .\n";
            Transaction_History=Transaction_History.concat(History);
        }
    }
    public void Withdraw(){
        System.out.print("Enter amount to withdraw from your account : ");
        float Withdraw_Amount;
        Withdraw_Amount=input.nextFloat();
        if(Withdraw_Amount<500000){
            if (Withdraw_Amount>Balance){
                System.out.println("Sorry! Insufficient Balance...");
            }
            else{
                Balance=Balance-Withdraw_Amount;
                Transactions=Transactions+1;
                System.out.println("Successfully withdrawn Rs. "+Withdraw_Amount+" from your account at "+dtf.format(now));
                System.out.println("Your Current Balance after this transaction is: "+Balance);
                String History=" ";
                History="\n Rs "+Withdraw_Amount+" withdrawn at "+dtf.format(now)+" .\n";
                Transaction_History=Transaction_History.concat(History);
            }
        }
        else{
            System.out.println("This ATM cannot dispence Money more than 5,00,000/-");
        }
    }
    public void Transfer(){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the UserName to transfer: ");
        String Usertotransfer;
        Usertotransfer=input.nextLine();
        System.out.print("Enter the amount to transfer to "+Usertotransfer+" : ");
        float Total_Amount;
        Total_Amount=input.nextFloat();
        if(Total_Amount<500000f){
            if (Total_Amount>Balance){
                System.out.println("Sorry! Amount cant be transferred Due to Insufficient Balance.");
                System.out.println("Your Balance was: "+Balance);
            }
            else{
                Balance=Balance-Total_Amount;
                Transactions=Transactions+1;
                System.out.println("Successfully transferred Rs. "+Total_Amount+" to "+Usertotransfer+" from your account at "+dtf.format(now));
                System.out.println("Your Current Balance after this transaction is: "+Balance);
                String History=" ";
                History="\n Rs "+Total_Amount+" was transferred to "+Usertotransfer+"'s account from your account at "+dtf.format(now)+" .\n";
                Transaction_History=Transaction_History.concat(History);
            }
        }
        else{
            System.out.println("Cannot transfer money beyond 5,00,000/-");
        }
    }
    public void Transaction_history(){
        if(Transactions==0){
            System.out.println("No Transactions");
        }
        else{
            System.out.println(Transaction_History);
        }
    }
    public void Check_Balance(){
        System.out.println("\nBalance amount is : "+Balance);
    }
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        System.out.println("-----------Welcome to ATM-----------");
        System.out.println("\nSelect any one option from the below:");
        System.out.println("1.Register(New Users should Register First)\n2.Exit");
        System.out.print("Your choice:");
        int choice;
        choice=input.nextInt();
        if(choice==1){
            ATM_INTERFACE atm=new ATM_INTERFACE();
            atm.Register();
            while(choice==1){
                System.out.println("\n Select any one option: ");
                System.out.println("1.Login(If already Registered)\n2.Exit");
                System.out.print("Your option :");
                int option=input.nextInt();
                if (option==1){
                    if(atm.Login()){
                        while(true){
                            System.out.println("\n\nThis ATM is able to perform this operations: ");
                            System.out.println("1.View Profile\n2.Deposit\n3.Withdraw\n4.Transfer\n5.Transaction History\n6.Check Balance\n7.Exit");
                            System.out.print("Enter your option :");
                            int select;
                            select=input.nextInt();
                            switch(select){
                                case 1 : atm.View_Profile();
                                    break;
                                case 2 : atm.Deposit();
                                    break;
                                case 3 : atm.Withdraw();
                                    break;
                                case 4 : atm.Transfer();
                                    break;
                                case 5 : atm.Transaction_history();
                                    break;
                                case 6 : atm.Check_Balance();
                                    break;
                                case 7 :System.out.println("\nThank you...Visit Again...:)");
                                    System.exit(0);
                                default: System.out.println("Invalid option!...Enter Valid option...");
                            }
                        }
                    }
                }
                else{
                    System.out.println("\nThank you...Visit Again...:)");
                    System.exit(0);
                }
            }
        }
        else {
            System.out.println("\nThank you...Visit Again...:)");
            System.exit(0);
        }
    }
}
