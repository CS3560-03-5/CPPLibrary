public class fee {
    private float amount;
    private int dueDateInDays;

    public fee(float amount, int dueDateInDays) {
        this.amount = amount;
        this.dueDateInDays = dueDateInDays;
    }

    public float getAmount() { return amount; }
    public void setAmount(float amount) { this.amount = amount; }
    public int getDueDateInDays() { return dueDateInDays; }
    public void setDueDateInDays(int dueDateInDays) { this.dueDateInDays = dueDateInDays; }
}

