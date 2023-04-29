package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface LeiTaiBean
  extends Bean
{
  public abstract LeiTaiBean copy();
  
  public abstract LeiTaiBean toData();
  
  public abstract LeiTaiBean toBean();
  
  public abstract LeiTaiBean toDataIf();
  
  public abstract LeiTaiBean toBeanIf();
  
  public abstract Map<Long, LeiTaiFight> getFightmap();
  
  public abstract Map<Long, LeiTaiFight> getFightmapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LeiTaiBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */