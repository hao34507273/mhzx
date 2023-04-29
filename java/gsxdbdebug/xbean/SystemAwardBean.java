package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface SystemAwardBean
  extends Bean
{
  public abstract SystemAwardBean copy();
  
  public abstract SystemAwardBean toData();
  
  public abstract SystemAwardBean toBean();
  
  public abstract SystemAwardBean toDataIf();
  
  public abstract SystemAwardBean toBeanIf();
  
  public abstract long getStarttime();
  
  public abstract long getEndtime();
  
  public abstract Map<Integer, Integer> getItemid2count();
  
  public abstract Map<Integer, Integer> getItemid2countAsData();
  
  public abstract Map<Integer, Integer> getType2value();
  
  public abstract Map<Integer, Integer> getType2valueAsData();
  
  public abstract Map<Integer, String> getContentmap();
  
  public abstract Map<Integer, String> getContentmapAsData();
  
  public abstract void setStarttime(long paramLong);
  
  public abstract void setEndtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SystemAwardBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */