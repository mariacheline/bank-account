/** @author mariacheline **/

package bankaccount;

public class CC {
    private double balance;
    
    /** constructors **/
    public CC(){
        balance = 0.00;
    }
    
    public CC (double balance){
        setBalance(balance);
    }
    /** end of constructors **/

    /** setters and getters **/
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    /** setters and getters **/
    
    /** methods for deposit and withdraw **/
    public double deposit(int depositAmount){
        return this.balance += depositAmount;
    }
    
    public double withdraw(int withdrawAmount){
        return this.balance -= withdrawAmount;
    }
    /** end of methods for deposit and withdraw **/
}
