package main.com.exception;

/**
 * Account类： 银行账号
 */
public class Account {
    //余额
    private double balance;

    /**
     * 获取余额
     *
     * @return balance 余额信息
     */
    public void getBalance() {
        System.out.println("您的余额为:\t" + balance + "元");
    }

    /**
     * 存钱
     *
     * @param money
     * @return balance
     */
    public double deposit(double money) {
        this.balance += money;
        return balance;
    }

    /**
     * 取钱
     *
     * @param money
     * @return balance
     */
    public double withdraw(double money) throws OverdraftException {
        if (balance < 0) {
            throw new OverdraftException("您的账户已透支,无法取钱", this.balance);
        }

        if (this.balance < money) {
            this.balance -= money;
            throw new OverdraftException("您的账户已透支", this.balance);
        }

        return balance -= money;
    }

    public Account() {

    }

    public Account(double balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
        Account act = new Account(1000);
        act.getBalance();
        try {
            act.withdraw(2000);
        } catch (OverdraftException e) {
            e.printStackTrace();
        }
        try {
            act.withdraw(10);
        } catch (OverdraftException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 透支异常，继承Exception
 */
class OverdraftException extends Exception {

    //透支额
    private double deficit;

    public OverdraftException() {

    }

    public OverdraftException(String msg, double deficit) {
        super(msg);
        this.deficit = deficit;
        System.out.println("透支额度是" + this.deficit);
    }
}