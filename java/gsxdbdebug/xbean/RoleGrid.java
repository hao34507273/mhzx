package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface RoleGrid
  extends Bean
{
  public abstract RoleGrid copy();
  
  public abstract RoleGrid toData();
  
  public abstract RoleGrid toBean();
  
  public abstract RoleGrid toDataIf();
  
  public abstract RoleGrid toBeanIf();
  
  public abstract int getMaxgridnum();
  
  public abstract long getLastrefreshtime();
  
  public abstract Map<Long, Long> getShoppingid2channelid();
  
  public abstract Map<Long, Long> getShoppingid2channelidAsData();
  
  public abstract Set<Long> getNeedrecycleshoppingids();
  
  public abstract Set<Long> getNeedrecycleshoppingidsAsData();
  
  public abstract void setMaxgridnum(int paramInt);
  
  public abstract void setLastrefreshtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleGrid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */