package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface DoublePoint
  extends Bean
{
  public abstract DoublePoint copy();
  
  public abstract DoublePoint toData();
  
  public abstract DoublePoint toBean();
  
  public abstract DoublePoint toDataIf();
  
  public abstract DoublePoint toBeanIf();
  
  public abstract int getGettingpoolpointnum();
  
  public abstract int getFrozenpoolpointnum();
  
  public abstract long getOffertimestamp();
  
  public abstract long getResetitemusetimestamp();
  
  public abstract int getItemusecount();
  
  public abstract Set<Integer> getSwitches();
  
  public abstract Set<Integer> getSwitchesAsData();
  
  public abstract Set<Integer> getSwitch_inits();
  
  public abstract Set<Integer> getSwitch_initsAsData();
  
  public abstract void setGettingpoolpointnum(int paramInt);
  
  public abstract void setFrozenpoolpointnum(int paramInt);
  
  public abstract void setOffertimestamp(long paramLong);
  
  public abstract void setResetitemusetimestamp(long paramLong);
  
  public abstract void setItemusecount(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DoublePoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */