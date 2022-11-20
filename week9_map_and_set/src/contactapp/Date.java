package contactapp;

public class Date implements Comparable<Date> {
    private int day, month, year;

    public Date( int day, int month, int year ) {
    	setDate(day, month, year);
    }
    
    private void setDate( int day, int month, int year ) {
        if ( !isValidDate( day, month, year ) ) {
        	throw new IllegalArgumentException("Invalid day-month-year combination.");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public void setYear( int year ) throws IllegalArgumentException {
    	setDate( this.day, this.month, year );
    }

    public void setMonth( int month ) throws IllegalArgumentException {
    	setDate( this.day, month, this.year );
    }

    public void setDay( int day ) throws IllegalArgumentException {
    	setDate( day, this.month, this.year );
    }
    
    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }
    
    public boolean isLeapYear( int year ) {
    	boolean isLeapYear = false;
    	if( year%4 == 0 ){
        	if(! (year%100 == 0 && year%400 != 0)){
        		isLeapYear = true;
        	}
    	}
        return isLeapYear;
    }
    
    public boolean isValidDate( int day, int month, int year ) {
        return day >= 1 && day <= numberOfDaysInMonth(month, year);
    }  

    public int numberOfDaysInMonth( int month, int year ) throws IllegalArgumentException {
    	if(month < 1 || month > 12){
    		throw new IllegalArgumentException("Invalid month.");
    	}
    	return switch ( month ) {
            case 4,6, 9, 11:
                yield 30;
            case 2:
                yield isLeapYear(year) ? 29 : 28;
            default:
                yield 31;
        };
    }

    public boolean isBefore(Date d) {
        if (d == null) throw new IllegalArgumentException("Invalid date.");

        boolean isBefore = false;
        if ( getYear() < d.getYear() ) {
        	isBefore = true;
        } else if ( getYear() == d.getYear() ) {
            if ( getMonth() < d.getMonth() ) {
            	isBefore = true;
            } else if ( getMonth() == d.getMonth() ) {
            	isBefore = getDay() < d.getDay();
            }
        }
        return isBefore;        
    }

    public boolean isAfter(Date d) {
        if (d == null) throw new IllegalArgumentException("Invalid date.");
        return d.isBefore(this);
    }

    public void advanceSingleDay() {
        if ( getDay() == numberOfDaysInMonth( getMonth(), getYear() ) ) {
            if ( getMonth() == 12 ) {
                setDate( 1, 1, getYear() + 1 );
            } else {
            	setDate( 1, getMonth() + 1, getYear() );
            }
        } else {
        	setDate( getDay() + 1, getMonth() , getYear() );
        }
    }
    
    public void goBackSingleDay()  {
        if ( getDay() == 1 ) {
            if ( getMonth() == 1 ) {
            	setDate( 31, 12, getYear() - 1 );
            } else {
            	int nrOfDays =  numberOfDaysInMonth( getMonth() - 1, getYear() );
            	setDate( nrOfDays , getMonth() - 1, getYear() );
            }
        } else {
        	setDate( getDay() - 1 , getMonth(), getYear() );
        }
    }
    
        
    @Override 
    public String toString(){
        return getDay() + "/" + getMonth() + "/" + getYear();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o instanceof Date d) {
            return getDay() == d.getDay() && getMonth() == d.getMonth() && getYear() == d.getYear();
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = day;
        result = 31 * result + month;
        result = 31 * result + year;
        return result;
    }

    //ordening van oudste datum naar meest recente datum
    @Override
    public int compareTo(Date date) {
        if (isBefore(date)) return -1;
        if (isAfter(date)) return 1;
        return 0;
    }
}
