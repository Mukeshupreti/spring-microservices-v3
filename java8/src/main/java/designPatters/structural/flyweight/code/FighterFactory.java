package designPatters.structural.flyweight.code;

import java.util.HashMap;
import java.util.Map;
// store common charater in factory and draw it when needed instead of putting all in the memory.
public class FighterFactory {
  
  static Map<FighterRank, Fighter> fighters = new HashMap<>();

  public static Fighter getFighter(FighterRank rank) {
    Fighter f = fighters.get(rank);
    if (f == null) {
      f = new Fighter(rank);
      fighters.put(rank, f);
    }
    return f;
  }
}
