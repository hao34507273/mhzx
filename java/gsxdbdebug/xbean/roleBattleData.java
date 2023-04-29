package xbean;

import xdb.Bean;

public abstract interface roleBattleData
  extends Bean
{
  public abstract roleBattleData copy();
  
  public abstract roleBattleData toData();
  
  public abstract roleBattleData toBean();
  
  public abstract roleBattleData toDataIf();
  
  public abstract roleBattleData toBeanIf();
  
  public abstract int getState();
  
  public abstract int getPoint();
  
  public abstract void setState(int paramInt);
  
  public abstract void setPoint(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\roleBattleData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */