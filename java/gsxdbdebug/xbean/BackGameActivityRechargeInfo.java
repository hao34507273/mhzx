package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface BackGameActivityRechargeInfo
  extends Bean
{
  public abstract BackGameActivityRechargeInfo copy();
  
  public abstract BackGameActivityRechargeInfo toData();
  
  public abstract BackGameActivityRechargeInfo toBean();
  
  public abstract BackGameActivityRechargeInfo toDataIf();
  
  public abstract BackGameActivityRechargeInfo toBeanIf();
  
  public abstract long getInitrechargecount();
  
  public abstract long getAccumulaterechargecount();
  
  public abstract Map<Integer, Integer> getManekitokencfgid2count();
  
  public abstract Map<Integer, Integer> getManekitokencfgid2countAsData();
  
  public abstract void setInitrechargecount(long paramLong);
  
  public abstract void setAccumulaterechargecount(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BackGameActivityRechargeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */