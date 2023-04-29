package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface TaskDataBean
  extends Bean
{
  public abstract TaskDataBean copy();
  
  public abstract TaskDataBean toData();
  
  public abstract TaskDataBean toBean();
  
  public abstract TaskDataBean toDataIf();
  
  public abstract TaskDataBean toBeanIf();
  
  public abstract Map<Integer, GraphBean> getGraphbeans();
  
  public abstract Map<Integer, GraphBean> getGraphbeansAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TaskDataBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */