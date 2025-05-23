package designPatters.behavioural.visitor.code;

public interface ReportElement {
  <R> R accept(ReportVisitor<R> visitor);
}
