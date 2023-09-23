// 211490297 Gal Mansuryan
package Game.Levels;

import Animation.Animation;
import Animation.KeyPressStoppableAnimation;
import Animation.AnimationRunner;
import Game.Counter;
import Game.GameEnvironment;
import Movement.Collidable;
import Movement.Sprite;
import Movement.SpriteCollection;
import Movement.Velocity;
import Removers.BallRemover;
import Removers.BlockRemover;
import Score.ScoreIndicator;
import Score.ScoreTrackingListener;
import Shapes.Absract.Point;
import Shapes.Absract.Rectangle;
import Shapes.GameItems.Ball;
import Shapes.GameItems.Block;
import Shapes.GameItems.Paddle;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;
import Animation.PauseScreen;
import Animation.CountdownAnimation;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The GameLevel class holds all the objects required to run the game and manages their behavior.
 */
public class GameLevel implements Animation {

    private boolean running = true;
    private LevelInformation levelInformation;
    private SpriteCollection sprites = new SpriteCollection();
    private GameEnvironment environment = new GameEnvironment();
    private int framesPerSecond = 60;
    private GUI gui;
    private AnimationRunner runner;
    private ScoreTrackingListener score;
    private BlockRemover blockRemover;
    private ScoreIndicator scoreIndicator;
    private BallRemover ballRemover;
    private Sleeper sleeper = new Sleeper();
    private KeyboardSensor keyboard;
    /**
     * Creates a new GameLevel object.
     *
     * @param levelInformation the level information
     * @param score            the score tracking listener
     * @param animationRunner  the animation runner
     * @param gui              the GUI
     */
    public GameLevel(LevelInformation levelInformation, ScoreTrackingListener score, AnimationRunner animationRunner,
                     GUI gui) {
        this.score = score;
        this.levelInformation = levelInformation;
        this.runner = animationRunner;
        this.gui = gui;
        keyboard = gui.getKeyboardSensor();
    }

    /**
     * Add a collidable object to the game environment.
     *
     * @param c the collidable object to add
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * Add a sprite object to the game environment.
     *
     * @param s the sprite object to add
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Initialize a new game by creating the blocks, ball, paddle, and edges, and adding them to the game.
     */
    public void initialize() {
        //initialize listeners
        this.blockRemover = new BlockRemover(this, new Counter(levelInformation.numberOfBlocksToRemove()));
        this.ballRemover = new BallRemover(this, new Counter(levelInformation.numberOfBalls()));

        //initialize score
        scoreIndicator = new ScoreIndicator(score.getScore(), levelInformation.levelName());


        //initialize balls
        List<Ball> balls = new ArrayList<>();
        List<Velocity> ballsVelocity = levelInformation.initialBallVelocities();
        for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
            if (Objects.equals(levelInformation.levelName(), "Level 1")) {
                balls.add(new Ball(new Point(380, 500), 6, new Color(201, 158, 6), this.environment,
                        ballsVelocity.get(i)));

            } else if (Objects.equals(levelInformation.levelName(), "Level 2")) {
                balls.add(new Ball(new Point(380, 500), 6, new Color(201, 6, 169), this.environment,
                        ballsVelocity.get(i)));

            } else {
                balls.add(new Ball(new Point(380, 500), 6, new Color(255, 102, 102), this.environment,
                        ballsVelocity.get(i)));
            }

        }

        // Create the background
        Sprite background = levelInformation.getBackground();
        addSprite(background);
        scoreIndicator.addToGame(this);
        //create the edges
        Block topEdge = new Block(new Rectangle(new Point(0, 20), 800, 20,
                new Color(224, 224, 224), 'f'));
        Block bottomEdge = new Block(new Rectangle(new Point(0, 580), 800, 20,
                new Color(224, 224, 224), 'f'));
        bottomEdge.addHitListener(ballRemover);
        Block leftEdge = new Block(new Rectangle(new Point(0, 20), 20, 600,
                new Color(224, 224, 224), 'f'));
        Block rightEdge = new Block(new Rectangle(new Point(780, 20), 20, 600,
                new Color(224, 224, 224), 'f'));

        // Create the paddle
        Paddle paddle = new Paddle(new Rectangle(new Point(380 - (double) (levelInformation.paddleWidth() / 2), 565),
                levelInformation.paddleWidth(), 15, Color.black, 'p'),
                gui, rightEdge, leftEdge, levelInformation.paddleSpeed());

        // Add the edges to the game
        topEdge.addToGame(this);
        bottomEdge.addToGame(this);
        rightEdge.addToGame(this);
        leftEdge.addToGame(this);

        List<Block> gameBlocks = levelInformation.blocks();
        // Create the blocks and add them to the game

        for (Block block : gameBlocks) {
            block.addHitListener(blockRemover);
            block.addHitListener(score);
            block.addToGame(this);
        }
        // Add the paddle and balls to the game
        paddle.addToGame(this);
        for (Ball ball : balls) {
            ball.addToGame(this);
        }

    }

    /**
     * Run the game loop.
     */
    public void run() {
        this.initialize();
        this.runner.setFramesPerSecond(1);
        this.runner.run(new CountdownAnimation(1, 3, this.sprites));
        this.runner.setFramesPerSecond(60);
        this.running = true;
        this.runner.run(this);
    }

    /**
     * Removes the specified collidable from the game's environment.
     *
     * @param c The collidable to be removed.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * Removes the specified sprite from the game's sprites.
     *
     * @param s The sprite to be removed.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.keyboard.isPressed("p")) {
            Animation pause = new PauseScreen();
            this.runner.run(new KeyPressStoppableAnimation(keyboard, "space", pause));
        }
        if (blockRemover.getRemainingBlocks() == 0) {
            score.finishedGame();
            this.running = false;
        }
        if (ballRemover.getRemainingBalls() == 0) {
            this.running = false;
        }

    }
    /**
     * Returns the number of remaining balls in the game.
     *
     * @return the number of remaining balls
     */
    public int getRemainingBalls() {
        return ballRemover.getRemainingBalls();
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}