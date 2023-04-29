package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface NodeBean
  extends Bean
{
  public abstract NodeBean copy();
  
  public abstract NodeBean toData();
  
  public abstract NodeBean toBean();
  
  public abstract NodeBean toDataIf();
  
  public abstract NodeBean toBeanIf();
  
  public abstract int getNodeid();
  
  public abstract int getFinishcount();
  
  public abstract Map<Integer, TaskBean> getTaskbeans();
  
  public abstract Map<Integer, TaskBean> getTaskbeansAsData();
  
  public abstract long getRefreshtime();
  
  public abstract void setNodeid(int paramInt);
  
  public abstract void setFinishcount(int paramInt);
  
  public abstract void setRefreshtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\NodeBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */