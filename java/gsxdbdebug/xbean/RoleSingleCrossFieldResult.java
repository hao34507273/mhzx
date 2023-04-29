package xbean;

import java.util.List;
import xdb.Bean;
import xio.Protocol;

public abstract interface RoleSingleCrossFieldResult
  extends Bean
{
  public abstract RoleSingleCrossFieldResult copy();
  
  public abstract RoleSingleCrossFieldResult toData();
  
  public abstract RoleSingleCrossFieldResult toBean();
  
  public abstract RoleSingleCrossFieldResult toDataIf();
  
  public abstract RoleSingleCrossFieldResult toBeanIf();
  
  public abstract List<Protocol> getResult();
  
  public abstract long getSession_id();
  
  public abstract void setSession_id(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleSingleCrossFieldResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */