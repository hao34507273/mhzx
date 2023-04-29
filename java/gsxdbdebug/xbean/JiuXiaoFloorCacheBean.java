package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface JiuXiaoFloorCacheBean
  extends Bean
{
  public abstract JiuXiaoFloorCacheBean copy();
  
  public abstract JiuXiaoFloorCacheBean toData();
  
  public abstract JiuXiaoFloorCacheBean toBean();
  
  public abstract JiuXiaoFloorCacheBean toDataIf();
  
  public abstract JiuXiaoFloorCacheBean toBeanIf();
  
  public abstract Set<Integer> getProcesses();
  
  public abstract Set<Integer> getProcessesAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\JiuXiaoFloorCacheBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */