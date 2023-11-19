public class Polar2DInheritance extends Vector2D{
    public Polar2DInheritance(double x, double y) {
        super(x, y);
    }

    public double getAngle(){
        double[] components = this.getComponents();
        if(components[0]>0.0 && components[1]>=0.0)
            return Math.atan(components[1]/components[0]);
        else if(components[0]>0.0 && components[1]<0.0)
            return Math.atan(components[1]/components[0]) + 2 * Math.PI;
        else if(components[0] < 0.0)
            return Math.atan(components[1]/components[0]) + Math.PI;
        else if(components[0] == 0.0 && components[1] > 0.0)
            return Math.PI / 2;
        else
            return 3 * Math.PI / 2;
    }
}
