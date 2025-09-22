package academy.waifuser.entity;

public enum PolygonType {
    TRI("삼각형", 3),
    QUAD("사각형", 4),
    PENTA("오각형", 5);

    private final String displayName;  // 한글 이름
    private final int vertexCount;     // 꼭짓점 개수

    PolygonType(String displayName, int vertexCount) {
        this.displayName = displayName;
        this.vertexCount = vertexCount;
    }
}
