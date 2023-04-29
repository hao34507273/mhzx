package xbean;

import xdb.Bean;

public abstract interface RoleVoipRoom
  extends Bean
{
  public abstract RoleVoipRoom copy();
  
  public abstract RoleVoipRoom toData();
  
  public abstract RoleVoipRoom toBean();
  
  public abstract RoleVoipRoom toDataIf();
  
  public abstract RoleVoipRoom toBeanIf();
  
  public abstract int getVoip_room_type();
  
  public abstract long getOwner_id();
  
  public abstract void setVoip_room_type(int paramInt);
  
  public abstract void setOwner_id(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleVoipRoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */