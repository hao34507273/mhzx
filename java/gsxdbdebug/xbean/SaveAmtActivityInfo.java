package xbean;

import xdb.Bean;

public abstract interface SaveAmtActivityInfo
  extends Bean
{
  public abstract SaveAmtActivityInfo copy();
  
  public abstract SaveAmtActivityInfo toData();
  
  public abstract SaveAmtActivityInfo toBean();
  
  public abstract SaveAmtActivityInfo toDataIf();
  
  public abstract SaveAmtActivityInfo toBeanIf();
  
  public abstract long getSave_amt();
  
  public abstract int getSortid();
  
  public abstract boolean getIs_reset();
  
  public abstract void setSave_amt(long paramLong);
  
  public abstract void setSortid(int paramInt);
  
  public abstract void setIs_reset(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SaveAmtActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */