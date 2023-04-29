package xbean;

import xdb.Bean;

public abstract interface FightStorage
  extends Bean
{
  public abstract FightStorage copy();
  
  public abstract FightStorage toData();
  
  public abstract FightStorage toBean();
  
  public abstract FightStorage toDataIf();
  
  public abstract FightStorage toBeanIf();
  
  public abstract long getLastestendtime();
  
  public abstract void setLastestendtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FightStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */