package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface TaskBean
  extends Bean
{
  public abstract TaskBean copy();
  
  public abstract TaskBean toData();
  
  public abstract TaskBean toBean();
  
  public abstract TaskBean toDataIf();
  
  public abstract TaskBean toBeanIf();
  
  public abstract int getTaskid();
  
  public abstract int getTaskstate();
  
  public abstract Map<Integer, ConBean> getConmap();
  
  public abstract Map<Integer, ConBean> getConmapAsData();
  
  public abstract long getTaskstarttime();
  
  public abstract void setTaskid(int paramInt);
  
  public abstract void setTaskstate(int paramInt);
  
  public abstract void setTaskstarttime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TaskBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */