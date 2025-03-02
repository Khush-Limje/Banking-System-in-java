import java.util.*;

public class BankingSystem {

    public static void main(String[] lund){
        String name ;
        Long phone;
            

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Kwiss Bank.");
        System.out.println("Have a nice day!\n Have a best financial support!\n\n");
        System.out.println("Enter the name");
        name = sc.nextLine();
        System.out.println("Enter the number:-");
        phone= sc.nextLong();
        Accountant acc = new Accountant(name,phone);
        acc.display();

        Integer ch;

        while (true) {
            System.out.println("1.Deposit\n2.Withdrwal\n3.Apply for loan\n4.Loan details\n5.Pay Loan Installments\n6.Check Balance\n7.Digital cards\n8.Add amount to digital card.");
            ch=sc.nextInt();

            switch (ch) {
                case 1:
                    acc.deposit();
                    break;
            
                case 2:
                    acc.Withdrwal();
                    break;
    
                case 3:
                    acc.loan();
                    break;
                case 4:
                    acc.checkLoan();
                    break;
                case 5:
                    acc.PayLoan();
                    break;
                case 6:
                    acc.checkBalance();
                    break;
                case 7:
                    acc.CreateDigitalCard();
                    break;
                case 8:
                    acc.amountToDigitalCard();
                    break;
                default:
                    System.out.println("Invaild");    
                    return;
            }    
        }
    }
}
class Accountant {
    
    BankingSystem p1 = new BankingSystem();
    String sname;
    Long mphone;
    Float balance = 1500.00f;
    Boolean isLoan = false;
    Float loan_Amount;
    Integer time;
    Float total;
    Float RemainingLoanAmount;
    Integer cardChoice;
    Boolean isCreditCard = false;
    Boolean isDebitCard = false;
    Float amountToAddInCreditCard;
    Float amountToAddInDebitCard;
    Float amountInCreditCard;
    Float amountInDebitCard;
    Scanner sc = new Scanner(System.in);


    Accountant(String name ,Long phone){

        this.sname=name;
        this.mphone=phone;

    }

    void display(){

        System.out.println("Name : " + sname);
        System.out.println("Phone : " + mphone);
        System.out.println("Account Balance " + balance);
        System.out.println();
        System.out.println();
    }

    public void deposit(){
        Scanner sc = new Scanner(System.in);
        int Amount;

        System.out.println("Enter Amount :");
        Amount=sc.nextInt();
        balance = balance+Amount;

        System.out.println("Total Balance :" + balance);
        System.out.println();
        System.out.println();

    }
    public void Withdrwal(){
        Scanner sc = new Scanner(System.in);
        int Amount;

        System.out.println("Enter Amount :");
        Amount=sc.nextInt();
        balance = balance-Amount;

        if (balance > 500) {
            System.out.println("Balance ok");
            System.out.println("Total Balance :" + balance);
        }else{
            System.out.println("There is no Balance.");
            balance = balance+Amount;

            System.out.println("Total Balance :" + balance);
        }
        System.out.println();
        System.out.println();
    }

    public void loan(){

        Scanner sc = new Scanner(System.in);
        
        if (isLoan == true) {
            System.out.println("Already have a loan.");
            System.out.println();
            System.out.println();
        }else{
            if (balance > 50000) {
                System.out.println("Enter Amount Of Loan :");
                loan_Amount = sc.nextFloat();
                balance = balance+loan_Amount;
                System.out.println("ROI 0.6& whould you like to apply say plzz and tell me time :");
                time = sc.nextInt();
                total = (float)(loan_Amount * 0.6 * time) /100;
                System.out.println("Your loan has approve here's your installment amount : " + total);
                System.out.println("Your loan has approve here's your balance : " + balance);        
                isLoan = true;
                System.out.println();
                System.out.println();
                
            }else{
                System.err.println("No available balance.");
                System.out.println();
                System.out.println();
            }
            System.out.println();
            System.out.println();
        }

    }
    public void checkLoan(){
        if (isLoan == true) {
            System.out.println("You have loan of Rupees "+loan_Amount);
            System.out.println("You have time frame of "+time+" months.");
            System.out.println("You have installment of "+total);
            System.out.println();
            System.out.println();
        }else{
            System.out.println("YOu dont have any loan.");
            System.out.println();
            System.out.println();
        }
    }
    public void PayLoan(){
        RemainingLoanAmount =(float)loan_Amount;
        if (isLoan == true) {
            System.out.println("You had loan of rupees "+ loan_Amount);
            System.out.println("You have remaning loan amount of "+ RemainingLoanAmount);
            System.out.println("Want to pay one installment?");
            System.out.println("\t 1.Pay \t \t 2.Do not Pay");
            Integer ch = sc.nextInt();
            switch (ch) {
                case 1:
                    if (balance >500) {
                        RemainingLoanAmount = RemainingLoanAmount - total;
                        loan_Amount = loan_Amount - total;
                        System.out.println("Your installment is recived.");
                        System.out.println("Remaining loan amount "+ RemainingLoanAmount);
                        balance = balance - total;
                        System.out.println();
                        System.out.println();
                        break;
                
                    }
                default:
                    return;
            }
        }else{
            System.out.println("No loan amount to pay.");
            System.out.println();
            System.out.println();
        }
    }
    public void checkBalance(){
        System.out.println("Available balance is "+ balance);
        System.out.println();
        System.out.println();
    }
    public void CreateDigitalCard(){
        System.out.println("Which card do you want to create ?");
        System.out.println("1.Credit card\n2.Debit card\n3.Add amount to Digital card");
        cardChoice = sc.nextInt();
        switch (cardChoice) {
            case 1:
                creditCard();
                break;
            case 2:
                debitCard();
                break;
            case 3:
                amountToDigitalCard();
                break;
            default:
                return;
        }
    }
    public void creditCard(){
      if (isCreditCard == true) {
        System.out.println("You already own an Credit card.");
        System.out.println("Card holder name " + sname);
        System.out.println("Card number is 1234 4321 7894 4897.");
        System.out.println();
        System.out.println();
      }else{
        isCreditCard = true;
        System.out.println("Your card is created.");
        System.out.println("Card holder name " + sname);
        System.out.println("Card number is 1234 4321 7894 4897.");
        System.out.println();
        System.out.println();
      } 
    }
    public void debitCard(){
        if (isDebitCard == true) {
            System.out.println("You already own an Debit card.");
            System.out.println("Card holder name " +  sname);
            System.out.println("Card number is 2468 4321 7894 4897.");
            System.out.println();
            System.out.println();
          }else{
            isDebitCard = true;
            System.out.println("Your card is created.");
            System.out.println("Card holder name " +  sname);
            System.out.println("Card number is 2468 4321 7894 4897.");
            System.out.println();
            System.out.println();
          } 
    }
    public void amountToDigitalCard(){
        Integer cardChoice;
        while (true) {
            System.out.println("Choose the card");
            System.out.println("1.Credit card\n 2.Debit card");
            System.out.println("Enter your choice");
            cardChoice = sc.nextInt();
            switch (cardChoice) {
                case 1:
                    amountToCreditCard();
                    break;
                case 2:
                    amountToDebitCard();
                    break;
                default:
                    return;
            }
        }
        
    }
    public void amountToCreditCard(){
        if (isCreditCard == true) {
            System.out.println("Enter the amount ");
            amountToAddInCreditCard = sc.nextInt();
            balance = balance - amountToAddInCreditCard;
            amountInCreditCard = amountInCreditCard + amountToAddInCreditCard;
            System.out.println("Added to Credit Card.");
        }else{
            System.out.println("There is no Credit card.");
        }
    }
    public void amountToDebitCard(){
        if (isDebitCard == true) {
            System.out.println("Enter the amount ");
            amountToAddInDebitCard = sc.nextInt();
            balance = balance - amountToAddInDebitCard;
            amountInCreditCard = amountInCreditCard + amountToAddInDebitCard;
            System.out.println("Added to Debit Card.");
        }else{
            System.out.println("There is no Credit card.");
        }
    }
} 
            
            
            
            
            
      
            
         