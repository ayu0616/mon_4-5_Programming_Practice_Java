public class Game {
    public static void main(String[] args) {
        Player player = new Player("Player1", 5, 100, 0);
        Enemy enemy1 = new Enemy("blue");
        Enemy enemy2 = new Enemy("brown");

        player.up();
        player.drawAt();
        try {
            player.down();
        } catch (UnsupportedOperationException e) {
            player.drawAt();
        }
        player.left();
        player.drawAt();
        try {
            player.right();
        } catch (UnsupportedOperationException e) {
            player.drawAt();
        }
    }
}
