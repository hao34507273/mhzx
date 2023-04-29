package xbean;

import xdb.Bean;

public abstract interface RoleCrossCompete
  extends Bean
{
  public abstract RoleCrossCompete copy();
  
  public abstract RoleCrossCompete toData();
  
  public abstract RoleCrossCompete toBean();
  
  public abstract RoleCrossCompete toDataIf();
  
  public abstract RoleCrossCompete toBeanIf();
  
  public abstract boolean getParticipated();
  
  public abstract void setParticipated(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleCrossCompete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */