public class Enemy extends Entity implements Drawable {
    String type;

    public Enemy(String type) {
        super();
        setType(type);
    }

    public Enemy(String type, int speed) {
        super(speed);
        setType(type);
    }

    public Enemy(String type, int speed, int posX, int posY) {
        super(speed, posX, posY);
        setType(type);
    }

    private void setType(String type) {
        if (!(type == "blue" || type == "brown")) {
            throw new IllegalArgumentException(type + " is invalid type");
        } else {
            this.type = type;
        }
    }

    @Override
    public Boolean drawAt() {
        Boolean isDrawable = !(isRock(posX, posY) || isTree(posX, posY));
        isDrawable = isDrawable && !(posX < minX || maxX < posX) && !(posY < minY || maxY < posY);
        if (isDrawable) {
            System.out.printf("success : Could draw enemy at position (%d, %d)", posX, posY);
        } else {
            System.out.printf("failure : Could not draw enemy at position (%d, %d)", posX, posY);
        }
        return isDrawable;
    }
}
