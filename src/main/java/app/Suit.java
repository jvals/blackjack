package app;

public enum Suit {
  CLUBS,
  DIAMONDS,
  HEARTS,
  SPADES;

  public final char shortName = this.name().charAt(0);
}
