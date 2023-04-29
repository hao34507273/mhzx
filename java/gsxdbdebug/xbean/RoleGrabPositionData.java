package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface RoleGrabPositionData
  extends Bean
{
  public abstract RoleGrabPositionData copy();
  
  public abstract RoleGrabPositionData toData();
  
  public abstract RoleGrabPositionData toBean();
  
  public abstract RoleGrabPositionData toDataIf();
  
  public abstract RoleGrabPositionData toBeanIf();
  
  public abstract List<Long> getGrabtime();
  
  public abstract List<Long> getGrabtimeAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleGrabPositionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */