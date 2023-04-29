package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleShangHuiBean
  extends Bean
{
  public abstract RoleShangHuiBean copy();
  
  public abstract RoleShangHuiBean toData();
  
  public abstract RoleShangHuiBean toBean();
  
  public abstract RoleShangHuiBean toDataIf();
  
  public abstract RoleShangHuiBean toBeanIf();
  
  public abstract Map<Integer, RoleShangHuiItem> getItemmap();
  
  public abstract Map<Integer, RoleShangHuiItem> getItemmapAsData();
  
  public abstract long getTimestamp();
  
  public abstract void setTimestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleShangHuiBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */