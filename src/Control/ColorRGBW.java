package Control;

public class ColorRGBW extends Color {
    private int r, g, b, w;

    public ColorRGBW(){
        r = 0;
        g = 0;
        b = 0;
        w = 0;
    }

    public ColorRGBW(int r, int g, int b, int w){
        if(0<=r && r<256 && 0<=g && g<256 && 0<=b && b<256 && 0<=w && w<256){
            this.r = r;
            this.g = g;
            this.b = b;
            this.w = w;
        }
        else {
            new ColorRGBW();
        }
    }

    @Override
    public String toString() {
        return "ColorRGBW{" +
                "r=" + r +
                ", g=" + g +
                ", b=" + b +
                ", w=" + w +
                '}';
    }
}
