package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface JiuXiaoActivityBean
  extends Bean
{
  public abstract JiuXiaoActivityBean copy();
  
  public abstract JiuXiaoActivityBean toData();
  
  public abstract JiuXiaoActivityBean toBean();
  
  public abstract JiuXiaoActivityBean toDataIf();
  
  public abstract JiuXiaoActivityBean toBeanIf();
  
  public abstract Map<Integer, JiuXiaoActivityInfo> getActivityinfomap();
  
  public abstract Map<Integer, JiuXiaoActivityInfo> getActivityinfomapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\JiuXiaoActivityBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */