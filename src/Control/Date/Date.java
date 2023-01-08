package Control.Date;

public class Date {
    private int day, month, year;

    public Date(){
        day = 1;
        month = 1;
        year = 2000;
    }

    public Date(int day, int month, int year){
        if(0<month && month<=12){
            if(0<year){
                if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
                    if(0<day && day<=31){
                        this.day = day;
                        this.month = month;
                        this.year = year;
                    }
                    else {
                        new Date();
                    }
                }
                else if(month == 2 && year%4 == 0){
                    if(0<day && day<=29){
                        this.day = day;
                        this.month = month;
                        this.year = year;
                    }
                    else {
                        new Date();
                    }
                }
                else if(month == 2){
                    if(0<day && day<=28){
                        this.day = day;
                        this.month = month;
                        this.year = year;
                    }
                    else {
                        new Date();
                    }
                }
                else {
                    if(0<day && day<=30){
                        this.day = day;
                        this.month = month;
                        this.year = year;
                    }
                    else {
                        new Date();
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Date: " + day
                + "." + month
                + "." + year;
    }
}
