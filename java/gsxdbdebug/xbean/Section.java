package xbean;

import xdb.Bean;

public abstract interface Section
  extends Bean
{
  public abstract Section copy();
  
  public abstract Section toData();
  
  public abstract Section toBean();
  
  public abstract Section toDataIf();
  
  public abstract Section toBeanIf();
  
  public abstract int getPoint();
  
  public abstract long getTimestamp();
  
  public abstract void setPoint(int paramInt);
  
  public abstract void setTimestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Section.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */