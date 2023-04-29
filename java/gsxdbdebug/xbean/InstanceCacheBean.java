package xbean;

import java.util.List;
import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface InstanceCacheBean
  extends Bean
{
  public abstract InstanceCacheBean copy();
  
  public abstract InstanceCacheBean toData();
  
  public abstract InstanceCacheBean toBean();
  
  public abstract InstanceCacheBean toDataIf();
  
  public abstract InstanceCacheBean toBeanIf();
  
  public abstract int getInstancecfgid();
  
  public abstract long getWorldid();
  
  public abstract long getOpentime();
  
  public abstract List<Long> getRoleids();
  
  public abstract List<Long> getRoleidsAsData();
  
  public abstract List<Long> getSucroleids();
  
  public abstract List<Long> getSucroleidsAsData();
  
  public abstract Map<Integer, Integer> getExtra();
  
  public abstract Map<Integer, Integer> getExtraAsData();
  
  public abstract Set<Long> getFinishroleids();
  
  public abstract Set<Long> getFinishroleidsAsData();
  
  public abstract void setInstancecfgid(int paramInt);
  
  public abstract void setWorldid(long paramLong);
  
  public abstract void setOpentime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\InstanceCacheBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */