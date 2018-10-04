package edu.bu.cs665.resource;

import java.util.List;

public interface Chooser {

  String getSingleChoice(List<String> choices);

  List<String> getMultipleChoices(List<String> choices);
}
