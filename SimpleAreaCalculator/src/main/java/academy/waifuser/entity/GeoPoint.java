package academy.waifuser.entity;

/*
* GeoPoint는 위도 경도로 다룬다. 단위는 도를 Double의 소숫점 아래 10여자리의 유효숫자를 적절히 활용
* 사용하려는 지도 앱이 위도 경도를 육십분법으로 제공, 입력값도 참고
* */

public class GeoPoint {
    private double latitude;
    private double longitude;

    public GeoPoint(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return String.format("위도: %.6f, 경도: %.6f", latitude, longitude);
    }
}