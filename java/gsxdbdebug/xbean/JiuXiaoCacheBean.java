package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface JiuXiaoCacheBean
  extends Bean
{
  public abstract JiuXiaoCacheBean copy();
  
  public abstract JiuXiaoCacheBean toData();
  
  public abstract JiuXiaoCacheBean toBean();
  
  public abstract JiuXiaoCacheBean toDataIf();
  
  public abstract JiuXiaoCacheBean toBeanIf();
  
  public abstract Map<Integer, JiuXiaoFloorCacheBean> getFloorcachemap();
  
  public abstract Map<Integer, JiuXiaoFloorCacheBean> getFloorcachemapAsData();
  
  public abstract int getJiuxiaoactivityid();
  
  public abstract void setJiuxiaoactivityid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\JiuXiaoCacheBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */