package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleGrabData
  extends Bean
{
  public abstract RoleGrabData copy();
  
  public abstract RoleGrabData toData();
  
  public abstract RoleGrabData toBean();
  
  public abstract RoleGrabData toDataIf();
  
  public abstract RoleGrabData toBeanIf();
  
  public abstract Map<Integer, Integer> getOwnpositions();
  
  public abstract Map<Integer, Integer> getOwnpositionsAsData();
  
  public abstract RoleGrabSessions getSessiondata();
  
  public abstract int getPoint();
  
  public abstract int getGrabpositionid();
  
  public abstract void setPoint(int paramInt);
  
  public abstract void setGrabpositionid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleGrabData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */