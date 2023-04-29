package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface TaskConfBean
  extends Bean
{
  public abstract TaskConfBean copy();
  
  public abstract TaskConfBean toData();
  
  public abstract TaskConfBean toBean();
  
  public abstract TaskConfBean toDataIf();
  
  public abstract TaskConfBean toBeanIf();
  
  public abstract int getGraphid();
  
  public abstract int getTaskid();
  
  public abstract long getLeaderid();
  
  public abstract int getBattleid();
  
  public abstract List<Long> getAllroles();
  
  public abstract List<Long> getAllrolesAsData();
  
  public abstract List<Long> getAcceptroles();
  
  public abstract List<Long> getAcceptrolesAsData();
  
  public abstract void setGraphid(int paramInt);
  
  public abstract void setTaskid(int paramInt);
  
  public abstract void setLeaderid(long paramLong);
  
  public abstract void setBattleid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TaskConfBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */