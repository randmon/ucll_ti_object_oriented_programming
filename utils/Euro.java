package utils;

public class Euro {
    private final int totalCents;
    
    public Euro(int euros, int cents){
        totalCents = euros * 100 + cents;
    }

    public Euro (double euros) {
        this((int) euros, (int) (euros % 1) * 10);
    }
    
    public Euro add(Euro amount){
        if (amount == null) throw new IllegalArgumentException("Amount cannot be null");
        int total = this.totalCents + amount.totalCents;
        return new Euro(0, total);
    }

    public Euro minus(Euro amount){
        if (amount == null) throw new IllegalArgumentException("Amount cannot be null");
        int total = this.totalCents - amount.totalCents;
        return new Euro(0, total);
    }

    public Euro multiply(double amount){
        return new Euro(0, (int) (amount * this.totalCents));
    }
    
    public Euro divided(int amount){
        return new Euro(0,this.totalCents /amount);
    }

    public boolean isZero(){
        return this.totalCents == 0;
    }

    public boolean isPositive(){
        return this.totalCents > 0;
    }
    
    public boolean isNegative(){
        return this.totalCents < 0;
    }

    @Override
    public boolean equals(Object o){
        if (o == null) return false;
        if (o instanceof Euro e){
            return this.totalCents == e.totalCents;
        }
        return false;
    }

    public boolean lessThan(Euro amount){
        if (amount == null) throw new IllegalArgumentException("Amount cannot be null");
        return this.totalCents < amount.totalCents;
    }

    public boolean lessOrEqual(Euro amount){
        if (amount == null) throw new IllegalArgumentException("Amount cannot be null");
        return this.totalCents <= amount.totalCents;
    }

    public boolean greaterThan(Euro amount){
        if (amount == null) throw new IllegalArgumentException("Amount cannot be null");
        return this.totalCents > amount.totalCents;
    }

    public boolean greaterOrEqual(Euro amount){
        if (amount == null) throw new IllegalArgumentException("Amount cannot be null");
        return this.totalCents >= amount.totalCents;
    }

    @Override
    public String toString(){
        return this.totalCents /100 + "." +  this.totalCents %100 + "€";
    }

    public int getTotalCents() {
        return totalCents;
    }
}
