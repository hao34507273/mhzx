package xbean;

import xdb.Bean;

public abstract interface DanceAwardInfo
  extends Bean
{
  public abstract DanceAwardInfo copy();
  
  public abstract DanceAwardInfo toData();
  
  public abstract DanceAwardInfo toBean();
  
  public abstract DanceAwardInfo toDataIf();
  
  public abstract DanceAwardInfo toBeanIf();
  
  public abstract int getPos();
  
  public abstract long getParadeindex();
  
  public abstract void setPos(int paramInt);
  
  public abstract void setParadeindex(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DanceAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */