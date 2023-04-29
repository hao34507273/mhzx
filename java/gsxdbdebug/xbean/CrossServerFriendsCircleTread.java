package xbean;

import xdb.Bean;

public abstract interface CrossServerFriendsCircleTread
  extends Bean
{
  public abstract CrossServerFriendsCircleTread copy();
  
  public abstract CrossServerFriendsCircleTread toData();
  
  public abstract CrossServerFriendsCircleTread toBean();
  
  public abstract CrossServerFriendsCircleTread toDataIf();
  
  public abstract CrossServerFriendsCircleTread toBeanIf();
  
  public abstract long getBe_trod_role_id();
  
  public abstract int getBe_trod_role_zone_id();
  
  public abstract boolean getIs_server_replied();
  
  public abstract boolean getIs_can_get_more_treasure_box();
  
  public abstract boolean getIs_auto_tread();
  
  public abstract void setBe_trod_role_id(long paramLong);
  
  public abstract void setBe_trod_role_zone_id(int paramInt);
  
  public abstract void setIs_server_replied(boolean paramBoolean);
  
  public abstract void setIs_can_get_more_treasure_box(boolean paramBoolean);
  
  public abstract void setIs_auto_tread(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossServerFriendsCircleTread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */