package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface InstanceBean
  extends Bean
{
  public abstract InstanceBean copy();
  
  public abstract InstanceBean toData();
  
  public abstract InstanceBean toBean();
  
  public abstract InstanceBean toDataIf();
  
  public abstract InstanceBean toBeanIf();
  
  public abstract Map<Integer, SingleInstance> getSingleinstancemap();
  
  public abstract Map<Integer, SingleInstance> getSingleinstancemapAsData();
  
  public abstract int getSinglefailtime();
  
  public abstract Map<Integer, TeamInstance> getTeaminstancemap();
  
  public abstract Map<Integer, TeamInstance> getTeaminstancemapAsData();
  
  public abstract void setSinglefailtime(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\InstanceBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */