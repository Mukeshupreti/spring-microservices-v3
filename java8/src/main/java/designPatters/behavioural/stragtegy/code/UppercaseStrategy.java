package designPatters.behavioural.stragtegy.code;

public class UppercaseStrategy implements PrintStrategy {

  @Override
  public String formatString(String input) {
    return input.toUpperCase();
  }
  
}
