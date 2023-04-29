package xbean;

import xdb.Bean;

public abstract interface DrawCarnivalRoleFreePassInfo
  extends Bean
{
  public abstract DrawCarnivalRoleFreePassInfo copy();
  
  public abstract DrawCarnivalRoleFreePassInfo toData();
  
  public abstract DrawCarnivalRoleFreePassInfo toBean();
  
  public abstract DrawCarnivalRoleFreePassInfo toDataIf();
  
  public abstract DrawCarnivalRoleFreePassInfo toBeanIf();
  
  public abstract int getCount();
  
  public abstract long getReset_time_stamp();
  
  public abstract void setCount(int paramInt);
  
  public abstract void setReset_time_stamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DrawCarnivalRoleFreePassInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */