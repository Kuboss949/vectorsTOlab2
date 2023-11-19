public class Vector3DDecorator implements IVector {
    private final IVector srcVector;
    private final double z;

    public Vector3DDecorator(IVector srcVector, double z) {
        this.srcVector = srcVector;
        this.z = z;
    }

    @Override
    public double abs() {
        double[] components = this.getComponents();
        double sum = 0;
        for (double component : components) {
            sum += component * component;
        }
        return Math.sqrt(sum);
    }

    @Override
    public double cdot(IVector vector) {
            if(vector.getComponents().length==2){
                return this.srcVector.cdot(this);
            }else{
                double[] components1 = this.getComponents();
                double[] components2 = vector.getComponents();
                return components1[0] * components2[0] + components1[1] * components2[1] + components1[2] * components2[2];
            }
    }

    @Override
    public double[] getComponents() {
        double[] srcComponents = this.srcVector.getComponents();
        return new double[]{srcComponents[0], srcComponents[1], z};
    }

    public Vector3DDecorator cross(IVector vector) {
        double x, y, z;
        double[] components1 = this.getComponents();
        double[] components2 = vector.getComponents();

        if(components2.length == 2){
            components2 = new double[]{components2[0], components2[1], 0};
        }
        x = (-components1[2])*components2[1] + components1[1]*components2[2];
        y = components1[2] * components2[0] + (-components1[0])*components2[2];
        z = (-components1[1])*components2[0] + components1[0]*components2[1];

        return new Vector3DDecorator(new Vector2D(x, y), z);
    }
    public IVector getSrcV(){
        return this.srcVector;
    }
}
