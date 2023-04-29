package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface JiuXiaoBean
  extends Bean
{
  public abstract JiuXiaoBean copy();
  
  public abstract JiuXiaoBean toData();
  
  public abstract JiuXiaoBean toBean();
  
  public abstract JiuXiaoBean toDataIf();
  
  public abstract JiuXiaoBean toBeanIf();
  
  public abstract Map<Integer, JiuXiaoFloorBean> getFloormap();
  
  public abstract Map<Integer, JiuXiaoFloorBean> getFloormapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\JiuXiaoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */