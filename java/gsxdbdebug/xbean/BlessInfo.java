package xbean;

import xdb.Bean;

public abstract interface BlessInfo
  extends Bean
{
  public abstract BlessInfo copy();
  
  public abstract BlessInfo toData();
  
  public abstract BlessInfo toBean();
  
  public abstract BlessInfo toDataIf();
  
  public abstract BlessInfo toBeanIf();
  
  public abstract int getNum();
  
  public abstract long getLast_time();
  
  public abstract void setNum(int paramInt);
  
  public abstract void setLast_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BlessInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */