package academy.waifuser.entity;

import java.io.Serializable;
import java.util.List;

public abstract class TargetData implements Shape {
    protected String name;
    protected List<GeoPoint> geoCoordinates; // 위도/경도
    protected List<Point> cartesianCoordinates; // 데카르트 좌표계 변환값
    protected double area;
    PolygonType type;

    public TargetData(String name, List<GeoPoint> geoCoordinates) {
        this.name = name;
        this.geoCoordinates = geoCoordinates;
    }

    public abstract void showGeoPoint();

    // 위도/경도 → 데카르트 좌표 변환, 자식 클래스에서 상속받아 구현
    public abstract void convertToCartesian();

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public List<GeoPoint> getGeoCoordinates() {
        return geoCoordinates;
    }

    public List<Point> getCartesianCoordinates() {
        return cartesianCoordinates;
    }
}
