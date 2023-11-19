public class Vector3DInheritance extends Vector2D{

    private double z;
    public Vector3DInheritance(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public Vector3DInheritance cross(IVector vector) {
        double x, y, z;
        double[] components1 = this.getComponents();
        double[] components2 = vector.getComponents();

        if(components2.length == 2){
            components2 = new double[]{components2[0], components2[1], 0};
        }
        x = (-components1[2])*components2[1] + components1[1]*components2[2];
        y = components1[2] * components2[0] + (-components1[0])*components2[2];
        z = (-components1[1])*components2[0] + components1[0]*components2[1];

        return new Vector3DInheritance(x, y, z);
    }

    @Override
    public double[] getComponents() {
        double[] srcComponents = super.getComponents();
        return new double[]{srcComponents[0], srcComponents[1], z};
    }
}
