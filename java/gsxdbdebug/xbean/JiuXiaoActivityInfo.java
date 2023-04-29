package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface JiuXiaoActivityInfo
  extends Bean
{
  public abstract JiuXiaoActivityInfo copy();
  
  public abstract JiuXiaoActivityInfo toData();
  
  public abstract JiuXiaoActivityInfo toBean();
  
  public abstract JiuXiaoActivityInfo toDataIf();
  
  public abstract JiuXiaoActivityInfo toBeanIf();
  
  public abstract long getWorldid();
  
  public abstract Set<Integer> getWinlayers();
  
  public abstract Set<Integer> getWinlayersAsData();
  
  public abstract void setWorldid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\JiuXiaoActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */