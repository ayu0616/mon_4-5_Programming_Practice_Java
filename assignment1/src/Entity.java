public abstract class Entity {
    int posX;
    int posY;
    int speed;

    public Entity() {
        this(5, 0, 0);
    }

    public Entity(int speed) {
        this(speed, 0, 0);
    }

    public Entity(int speed, int posX, int posY) throws IllegalArgumentException {
        // check speed is valid
        if (speed < 1 || speed > 10) {
            throw new IllegalArgumentException(speed + " is invalid speed");
        } else {
            this.speed = speed;
        }

        this.posX = posX;
        this.posY = posY;
    }
}
