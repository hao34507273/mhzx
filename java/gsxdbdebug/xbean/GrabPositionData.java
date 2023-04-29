package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface GrabPositionData
  extends Bean
{
  public abstract GrabPositionData copy();
  
  public abstract GrabPositionData toData();
  
  public abstract GrabPositionData toBean();
  
  public abstract GrabPositionData toDataIf();
  
  public abstract GrabPositionData toBeanIf();
  
  public abstract int getState();
  
  public abstract GrabPositionSessions getSessiondata();
  
  public abstract long getFirstgrabroleid();
  
  public abstract long getFirstgrabtime();
  
  public abstract Map<Long, RoleGrabPositionData> getRole2grabdata();
  
  public abstract Map<Long, RoleGrabPositionData> getRole2grabdataAsData();
  
  public abstract int getCampid();
  
  public abstract long getInstanceid();
  
  public abstract long getGrabingroleid();
  
  public abstract void setState(int paramInt);
  
  public abstract void setFirstgrabroleid(long paramLong);
  
  public abstract void setFirstgrabtime(long paramLong);
  
  public abstract void setCampid(int paramInt);
  
  public abstract void setInstanceid(long paramLong);
  
  public abstract void setGrabingroleid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GrabPositionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */