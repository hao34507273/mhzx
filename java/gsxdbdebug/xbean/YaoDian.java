package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface YaoDian
  extends Bean
{
  public abstract YaoDian copy();
  
  public abstract YaoDian toData();
  
  public abstract YaoDian toBean();
  
  public abstract YaoDian toDataIf();
  
  public abstract YaoDian toBeanIf();
  
  public abstract int getLevel();
  
  public abstract long getLevelupendtime();
  
  public abstract Map<Integer, Integer> getYaocaimap();
  
  public abstract Map<Integer, Integer> getYaocaimapAsData();
  
  public abstract MiFang getMifang();
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setLevelupendtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\YaoDian.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */