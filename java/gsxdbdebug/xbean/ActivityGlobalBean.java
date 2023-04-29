package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ActivityGlobalBean
  extends Bean
{
  public abstract ActivityGlobalBean copy();
  
  public abstract ActivityGlobalBean toData();
  
  public abstract ActivityGlobalBean toBean();
  
  public abstract ActivityGlobalBean toDataIf();
  
  public abstract ActivityGlobalBean toBeanIf();
  
  public abstract Map<Integer, OpenBeanStore> getActivityopenmap();
  
  public abstract Map<Integer, OpenBeanStore> getActivityopenmapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ActivityGlobalBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */