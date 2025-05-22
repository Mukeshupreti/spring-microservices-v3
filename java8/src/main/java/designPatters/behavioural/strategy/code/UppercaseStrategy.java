package designPatters.behavioural.strategy.code;

public class UppercaseStrategy implements PrintStrategy {

  @Override
  public String formatString(String input) {
    return input.toUpperCase();
  }
  
}
