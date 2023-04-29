package xbean;

import xdb.Bean;

public abstract interface ChristmasTreePositionInfo
  extends Bean
{
  public abstract ChristmasTreePositionInfo copy();
  
  public abstract ChristmasTreePositionInfo toData();
  
  public abstract ChristmasTreePositionInfo toBean();
  
  public abstract ChristmasTreePositionInfo toDataIf();
  
  public abstract ChristmasTreePositionInfo toBeanIf();
  
  public abstract boolean getCanaward();
  
  public abstract long getHangtime();
  
  public abstract long getHangroleid();
  
  public abstract void setCanaward(boolean paramBoolean);
  
  public abstract void setHangtime(long paramLong);
  
  public abstract void setHangroleid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChristmasTreePositionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */