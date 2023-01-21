package sg.edu.nus.iss;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BankAccount {
    
    private String customerName;
    private final String accountNumber;
    private List<String> transactions = new LinkedList<>();
    private Float balance;
    private boolean isClosed = true;
    private Date accountStartDate;
    private Date accountEndDate;

    //getters
    public String getCustomerName() {return customerName;}
    public String getAccountNumber() {return accountNumber;}
    public List<String> getTransactions() {return transactions;}
    public Float getBalance() {return balance;}
    public boolean isClosed() {return isClosed;}
    public Date getAccountStartDate() {return accountStartDate;}
    public Date getAccountEndDate() {return accountEndDate;}

    //setters
    public void setAccountStartDate(Date accountStartDate) {this.accountStartDate = accountStartDate;}
    public void setTransactions(List<String> transactions) {this.transactions = transactions;}
    public void setAccountEndDate(Date accountEndDate) {this.accountEndDate = accountEndDate;}
    public void setBalance(Float balance) {this.balance = balance;}
    public void setClosed(boolean isClosed) {this.isClosed = isClosed;}
    public void setOpenDate(String openDate) {this.openDate = openDate;}
    public void setCloseDate(String closeDate) {this.closeDate = closeDate;}

    public BankAccount(String customername){
        this(customername, 0.0F);
    }

    public BankAccount(String customername, Float balance){
        //Get date and time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime now = LocalDateTime.now();
        // Create a random number generator
        Random rand = new SecureRandom();
        // Generate a 7 digit random number rand(high-low) +low
        int randomAccNo = rand.nextInt(9_999_999-1_000_000)+1_000_000;

        this.customerName = customername;
        this.balance = balance;
        this.isClosed = false;
        this.openDate = dtf.format(now); 
        this.accountNumber = Integer.toString(randomAccNo);

    }




    //methods
    public void deposit(Float money){
        if(isClosed||money<0){
            throw new IllegalArgumentException();
        } else{
            balance += money;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime now = LocalDateTime.now();
            String depositTranscation = "deposit $"+money+" at "+ dtf.format(now);
            transactions.add(depositTranscation);
            
        }
    }

    public void withdraw(Float money){
        if ((isClosed||money>balance)||money<0)
            throw new IllegalArgumentException();
            
        else{
            balance -= money;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime now = LocalDateTime.now();
            String withdrawTranscation = "withdraw $"+money+" at "+ dtf.format(now);
            transactions.add(withdrawTranscation);            
        }
    }

}


