package xbean;

import xdb.Bean;

public abstract interface LostExpInfo
  extends Bean
{
  public abstract LostExpInfo copy();
  
  public abstract LostExpInfo toData();
  
  public abstract LostExpInfo toBean();
  
  public abstract LostExpInfo toDataIf();
  
  public abstract LostExpInfo toBeanIf();
  
  public abstract int getTotalloststoragevalue();
  
  public abstract int getTotalgainloststoragevalue();
  
  public abstract int getAlreadygetstoragevalue();
  
  public abstract boolean getAlreadygainlostexp();
  
  public abstract boolean getCangainlostexp();
  
  public abstract int getGaincollectexp();
  
  public abstract long getBegintime();
  
  public abstract void setTotalloststoragevalue(int paramInt);
  
  public abstract void setTotalgainloststoragevalue(int paramInt);
  
  public abstract void setAlreadygetstoragevalue(int paramInt);
  
  public abstract void setAlreadygainlostexp(boolean paramBoolean);
  
  public abstract void setCangainlostexp(boolean paramBoolean);
  
  public abstract void setGaincollectexp(int paramInt);
  
  public abstract void setBegintime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LostExpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */