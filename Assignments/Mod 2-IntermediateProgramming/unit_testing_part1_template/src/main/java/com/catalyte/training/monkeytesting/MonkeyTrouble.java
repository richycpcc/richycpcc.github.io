package com.catalyte.training.monkeytesting;

public class MonkeyTrouble
{

  public boolean monkeyTrouble(boolean aSmile, boolean bSmile)
  {
    if((aSmile && bSmile) || (!aSmile && !bSmile))
    {
      return true;
    }
    return false;
  }
}
