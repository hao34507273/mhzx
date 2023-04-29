package xbean;

import xdb.Bean;

public abstract interface FightState
  extends Bean
{
  public abstract FightState copy();
  
  public abstract FightState toData();
  
  public abstract FightState toBean();
  
  public abstract FightState toDataIf();
  
  public abstract FightState toBeanIf();
  
  public abstract int getState();
  
  public abstract int getGroup();
  
  public abstract void setState(int paramInt);
  
  public abstract void setGroup(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FightState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */