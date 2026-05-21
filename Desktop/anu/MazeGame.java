import java.util.Random;
import java.util.Scanner;

// Custom Exception class
class SteppedOnMineException extends Exception {
    public SteppedOnMineException(String message) {
        super(message);
    }
}

// Timer Thread class
class GameTimer extends Thread {
    int time = 15;
    boolean running = true;

    public void run() {
        try {
            while (time > 0 && running) {
                System.out.println("Time left: " + time + " seconds");
                Thread.sleep(1000);
                time--;
            }
            if (time == 0) {
                System.out.println("Time's up! Game Over.");
                System.exit(0);
            }
        } catch (InterruptedException e) {
            System.out.println("Timer interrupted.");
        }
    }
}

// Main Class
public class MazeGame {

    static final int SIZE = 10;
    static char[][] maze = new char[SIZE][SIZE];
    static int playerX = 0, playerY = 0;

    // Initialize Maze
    public static void initializeMaze() {
        Random rand = new Random();

        // Fill with safe path
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                maze[i][j] = 'P';
            }
        }

        // Place mines randomly (avoid duplicates)
        int minesPlaced = 0;
        while (minesPlaced < 15) {
            int x = rand.nextInt(SIZE);
            int y = rand.nextInt(SIZE);

            if ((x != 0 || y != 0) && maze[x][y] != 'X') {
                maze[x][y] = 'X';
                minesPlaced++;
            }
        }

        maze[0][0] = 'S';
        maze[SIZE - 1][SIZE - 1] = 'E';
    }

    // Display Maze (hidden)
    public static void displayMaze() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == playerX && j == playerY) {
                    System.out.print("O ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    // Detect nearby mines
    public static int detectMines(int x, int y) {
        int count = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < SIZE && ny < SIZE) {
                if (maze[nx][ny] == 'X') {
                    count++;
                }
            }
        }
        return count;
    }

    // Move Player
    public static void movePlayer(int move) throws SteppedOnMineException {
        int newX = playerX;
        int newY = playerY;

        switch (move) {
            case 8: newX--; break;
            case 2: newX++; break;
            case 4: newY--; break;
            case 6: newY++; break;
            default:
                System.out.println("Invalid move!");
                return;
        }

        // Boundary check
        if (newX < 0 || newY < 0 || newX >= SIZE || newY >= SIZE) {
            System.out.println("Out of bounds!");
            return;
        }

        playerX = newX;
        playerY = newY;

        if (maze[playerX][playerY] == 'X') {
            throw new SteppedOnMineException("You stepped on a mine!");
        }

        if (maze[playerX][playerY] == 'E') {
            System.out.println("You reached the Exit! You Win!");
            System.exit(0);
        }

        int mines = detectMines(playerX, playerY);
        System.out.println("Nearby mines: " + mines);
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        initializeMaze();
        GameTimer timer = new GameTimer();
        timer.start();

        System.out.println("Maze Game Started!");

        while (true) {
            try {
                displayMaze();

                System.out.println("Enter move (8-Up, 2-Down, 4-Left, 6-Right): ");
                int move = sc.nextInt();

                movePlayer(move);

            } catch (SteppedOnMineException e) {
                System.out.println(e.getMessage());
                System.out.println("Game Over!");
                break;
            }
        }

        sc.close();
    }
}
