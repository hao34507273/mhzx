package xbean;

import xdb.Bean;

public abstract interface LonngBoatRaceStat
  extends Bean
{
  public abstract LonngBoatRaceStat copy();
  
  public abstract LonngBoatRaceStat toData();
  
  public abstract LonngBoatRaceStat toBean();
  
  public abstract LonngBoatRaceStat toDataIf();
  
  public abstract LonngBoatRaceStat toBeanIf();
  
  public abstract int getRight();
  
  public abstract int getWrong();
  
  public abstract void setRight(int paramInt);
  
  public abstract void setWrong(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LonngBoatRaceStat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */