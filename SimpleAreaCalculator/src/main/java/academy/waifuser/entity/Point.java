package academy.waifuser.entity;

/*
* 데카르트 좌표계로 간격간 단위는 m로 활용, 밖에서 변환, 정렬 해주면 다시 받을 setter 구현
* */

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setCoordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
