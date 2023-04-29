package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface XMournInfo
  extends Bean
{
  public abstract XMournInfo copy();
  
  public abstract XMournInfo toData();
  
  public abstract XMournInfo toBean();
  
  public abstract XMournInfo toDataIf();
  
  public abstract XMournInfo toBeanIf();
  
  public abstract Map<Integer, XMTaskInfo> getMourndatas();
  
  public abstract Map<Integer, XMTaskInfo> getMourndatasAsData();
  
  public abstract XMTaskInfo getLastmourndata();
  
  public abstract List<Integer> getSort();
  
  public abstract List<Integer> getSortAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\XMournInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */