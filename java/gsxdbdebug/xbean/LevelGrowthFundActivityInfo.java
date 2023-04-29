package xbean;

import xdb.Bean;

public abstract interface LevelGrowthFundActivityInfo
  extends Bean
{
  public abstract LevelGrowthFundActivityInfo copy();
  
  public abstract LevelGrowthFundActivityInfo toData();
  
  public abstract LevelGrowthFundActivityInfo toBean();
  
  public abstract LevelGrowthFundActivityInfo toDataIf();
  
  public abstract LevelGrowthFundActivityInfo toBeanIf();
  
  public abstract boolean getPurchased();
  
  public abstract long getPurchase_num();
  
  public abstract int getSortid();
  
  public abstract boolean getIs_reset();
  
  public abstract void setPurchased(boolean paramBoolean);
  
  public abstract void setPurchase_num(long paramLong);
  
  public abstract void setSortid(int paramInt);
  
  public abstract void setIs_reset(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LevelGrowthFundActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */