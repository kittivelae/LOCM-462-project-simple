import java.io.*;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Acknowledgements - file copied from LoCM source code
 */
public final class Constants
{

  private static final Map<Integer, Double> costWeights = new HashMap<>() {
    {
      put(0, 0.9);
      put(1, 1.2);
      put(2, 1.1);
      put(3, 1.0);
      put(4, 0.9);
      put(5, 0.8);
      put(6, 0.7);
      put(7, 0.6);
      put(8, 0.4);
      put(9, 0.4);
      put(10, 0.2);
      put(11, 0.2);
      put(12, 0.2);
    }

  };

  public static double getCostWeighting(int cost) {
    return costWeights.get(cost);
  }

  public static final ThreadMXBean timeCounter = ManagementFactory.getThreadMXBean();

  public static int VERBOSE_LEVEL = 3; // 3 - full, 2 - without turn details, 1 - results only, 0 - silent

  public static int LANES = 1;

  public static final int CARDS_IN_DECK = 30; // 30;
  public static final int CARDS_IN_DRAFT = 60; // 60;

  public static final int INITIAL_HAND_SIZE = 4;
  public static final int MAX_CARDS_IN_HAND = 8; // was 10
  public static final int SECOND_PLAYER_CARD_BONUS = 1;
  public static final int SECOND_PLAYER_MAX_CARD_BONUS = 0;
  public static final int SECOND_PLAYER_MANA_BONUS_TURNS = 1;
  //public static final int EMPTY_DECK_DAMAGE = 5;

  public static final int MAX_MANA = 12;
  public static final int INITIAL_HEALTH = 30;

  public static final int MAX_CREATURES_IN_LINE = 6; // was 8

  public static final int TIMELIMIT_FIRSTDRAFTTURN = 1000;
  public static final int TIMELIMIT_DRAFTTURN = 100;
  public static final int TIMELIMIT_FIRSTGAMETURN = 1000;
  public static int TIMELIMIT_GAMETURN = 100;

  public static final int PLAYER_TURNLIMIT = 50;
  public static final int MAX_TURNS_HARDLIMIT = (2*CARDS_IN_DECK + 2*CARDS_IN_DECK + 2*10) * 10;

  public static final HashMap<Integer,Card> CARDSET = new HashMap<>();

  public static final int FRAME_DURATION_SHOWDRAFT = 1;
  public static final int FRAME_DURATION_SHOWDRAFT_LAST = 2500;
  public static final int FRAME_DURATION_DRAFT = 500;
  public static final int FRAME_DURATION_BATTLE = 750;
  public static final int FRAME_DURATION_SUMMON = 600;

}
