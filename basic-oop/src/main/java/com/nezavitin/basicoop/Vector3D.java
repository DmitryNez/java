package com.nezavitin.basicoop;

public final class Vector3D {
    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double scalarProduct(Vector3D vector3D) {
        return Math.sqrt(x * vector3D.x + y * vector3D.y + z * vector3D.z);
    }

    public Vector3D crossProduct(Vector3D vector3D) {
        return new Vector3D(
                y * vector3D.z - z * vector3D.y,
                z * vector3D.x - vector3D.z * x,
                x * vector3D.y - y * vector3D.x
        );
    }

    public double getAngleWithVector(Vector3D vector3D) {
        return Math.acos(scalarProduct(vector3D) / (vector3D.length() * length()));
    }

    public Vector3D add(Vector3D vector3D) {
        return new Vector3D(x + vector3D.x, y + vector3D.y, z + vector3D.z);
    }

    public Vector3D subtract(Vector3D vector3D) {
        return new Vector3D(x - vector3D.x, y - vector3D.y, z - vector3D.z);
    }

    static Vector3D getRandomVector3D() {
        return new Vector3D(
                Math.random(),
                Math.random(),
                Math.random()
        );
    }

    static Vector3D[] generate(int length) {
        Vector3D[] vector3DS = new Vector3D[length];
        for (int idx = 0; idx < length; ++idx) {
            vector3DS[idx] = Vector3D.getRandomVector3D();
        }
        return vector3DS;
    }

    @Override
    public String toString() {
        return "Vector3D { " + x + ", " + y + ", " + z + " }";
    }
}
