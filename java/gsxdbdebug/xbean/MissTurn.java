package xbean;

import xdb.Bean;

public abstract interface MissTurn
  extends Bean
{
  public abstract MissTurn copy();
  
  public abstract MissTurn toData();
  
  public abstract MissTurn toBean();
  
  public abstract MissTurn toDataIf();
  
  public abstract MissTurn toBeanIf();
  
  public abstract int getTimes();
  
  public abstract void setTimes(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MissTurn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */