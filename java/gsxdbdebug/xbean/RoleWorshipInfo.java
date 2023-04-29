package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleWorshipInfo
  extends Bean
{
  public abstract RoleWorshipInfo copy();
  
  public abstract RoleWorshipInfo toData();
  
  public abstract RoleWorshipInfo toBean();
  
  public abstract RoleWorshipInfo toDataIf();
  
  public abstract RoleWorshipInfo toBeanIf();
  
  public abstract int getWorshipid();
  
  public abstract Map<Long, Integer> getLastcycledata();
  
  public abstract Map<Long, Integer> getLastcycledataAsData();
  
  public abstract Map<Long, Integer> getThiscycledata();
  
  public abstract Map<Long, Integer> getThiscycledataAsData();
  
  public abstract long getCurfactionid();
  
  public abstract void setWorshipid(int paramInt);
  
  public abstract void setCurfactionid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleWorshipInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */