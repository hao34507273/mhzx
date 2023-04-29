package xbean;

import xdb.Bean;

public abstract interface BattleTaskData
  extends Bean
{
  public abstract BattleTaskData copy();
  
  public abstract BattleTaskData toData();
  
  public abstract BattleTaskData toBean();
  
  public abstract BattleTaskData toDataIf();
  
  public abstract BattleTaskData toBeanIf();
  
  public abstract int getParameter();
  
  public abstract void setParameter(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BattleTaskData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */