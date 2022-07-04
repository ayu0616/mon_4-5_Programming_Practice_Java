public class Player extends Entity implements Controllable, Drawable {
    String name;
    int lives = 3;
    int score = 0;

    public Player(String name) {
        super();
        this.name = name;
    }

    public Player(String name, int speed) {
        super(speed);
        this.name = name;
    }

    public Player(String name, int speed, int posX, int posY) throws IllegalArgumentException {
        super(speed, posX, posY);
        this.name = name;
    }

    @Override
    public void left() throws UnsupportedOperationException {
        if (posX - speed < minX) {
            throw new UnsupportedOperationException(name + " cannot move left anymore");
        }
        this.posX -= speed;
    }

    @Override
    public void up() throws UnsupportedOperationException {
        if (posY + speed > maxY) {
            throw new UnsupportedOperationException(name + " cannot move up anymore");
        }
        this.posY += speed;
    }

    @Override
    public void right() throws UnsupportedOperationException {
        if (posX + speed > maxX) {
            throw new UnsupportedOperationException(name + " cannot move right anymore");
        }
        this.posX += speed;
    }

    @Override
    public void down() throws UnsupportedOperationException {
        if (posY - speed < minY) {
            throw new UnsupportedOperationException(name + " cannot move down anymore");
        }
        this.posY -= speed;
    }

    @Override
    public Boolean drawAt() {
        Boolean isDrawable = !(isRiver(posX, posY) || isRock(posX, posY) || isTree(posX, posY));
        isDrawable = isDrawable && !(posX < minX || maxX < posX) && !(posY < minY || maxY < posY);
        if (isDrawable) {
            System.out.printf("success : Could draw player at position (%d, %d)\n", posX, posY);
        } else {
            System.out.printf("failure : Could not draw player at position (%d, %d)\n", posX, posY);
        }
        return isDrawable;
    }
}
