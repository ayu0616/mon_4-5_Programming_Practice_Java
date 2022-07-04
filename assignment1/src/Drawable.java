public interface Drawable {
    // min / max of the 2D world
    final int minX = 0;
    final int minY = 0;
    final int maxX = 100;
    final int maxY = 100;

    default Boolean isRiver(int x, int y) {
        return Math.random() < 0.1;
    }

    default Boolean isRock(int x, int y) {
        return Math.random() < 0.1;
    }

    default Boolean isTree(int x, int y) {
        return Math.random() < 0.1;
    }

    Boolean drawAt();
}
