package Control.Color;

public class ColorHSL extends Color {
    private int h, s, l;

    public ColorHSL(){
        h = 0;
        s = 0;
        l = 0;
    }

    public ColorHSL(int h, int s, int l){
        if(0<=h && h<=360 && 0<=s && s<=100 && 0<=l && l<=100){
            this.h = h;
            this.s = s;
            this.l = l;
        }
        else{
            new ColorHSL();
        }
    }

    @Override
    public String toString() {
        return "ColorHSL{" +
                "h=" + h +
                ", s=" + s +
                ", l=" + l +
                '}';
    }
}
