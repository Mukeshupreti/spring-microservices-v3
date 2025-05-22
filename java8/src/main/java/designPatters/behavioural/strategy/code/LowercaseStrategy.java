package designPatters.behavioural.strategy.code;

public class LowercaseStrategy implements PrintStrategy {

  @Override
  public String formatString(String input) {
    return input.toLowerCase();
  }
  
}
