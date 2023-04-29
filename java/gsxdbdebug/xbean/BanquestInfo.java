package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface BanquestInfo
  extends Bean
{
  public abstract BanquestInfo copy();
  
  public abstract BanquestInfo toData();
  
  public abstract BanquestInfo toBean();
  
  public abstract BanquestInfo toDataIf();
  
  public abstract BanquestInfo toBeanIf();
  
  public abstract Map<Integer, Integer> getOwndishes();
  
  public abstract Map<Integer, Integer> getOwndishesAsData();
  
  public abstract int getHoldcount();
  
  public abstract boolean getHoldbanqueststate();
  
  public abstract long getLastbanqueststarttime();
  
  public abstract int getDishescount();
  
  public abstract Map<Long, SingleBanquestInfo> getJoinbanquestinfo();
  
  public abstract Map<Long, SingleBanquestInfo> getJoinbanquestinfoAsData();
  
  public abstract long getFristjoinbanquesttime();
  
  public abstract void setHoldcount(int paramInt);
  
  public abstract void setHoldbanqueststate(boolean paramBoolean);
  
  public abstract void setLastbanqueststarttime(long paramLong);
  
  public abstract void setDishescount(int paramInt);
  
  public abstract void setFristjoinbanquesttime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BanquestInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */