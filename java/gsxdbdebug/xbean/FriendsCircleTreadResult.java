package xbean;

import xdb.Bean;

public abstract interface FriendsCircleTreadResult
  extends Bean
{
  public abstract FriendsCircleTreadResult copy();
  
  public abstract FriendsCircleTreadResult toData();
  
  public abstract FriendsCircleTreadResult toBean();
  
  public abstract FriendsCircleTreadResult toDataIf();
  
  public abstract FriendsCircleTreadResult toBeanIf();
  
  public abstract long getTread_me_role_id();
  
  public abstract int getTread_me_zone_id();
  
  public abstract boolean getIs_trigger_box();
  
  public abstract boolean getIs_ssp_replied();
  
  public abstract boolean getIs_cross_server();
  
  public abstract int getAdd_popularity_value();
  
  public abstract void setTread_me_role_id(long paramLong);
  
  public abstract void setTread_me_zone_id(int paramInt);
  
  public abstract void setIs_trigger_box(boolean paramBoolean);
  
  public abstract void setIs_ssp_replied(boolean paramBoolean);
  
  public abstract void setIs_cross_server(boolean paramBoolean);
  
  public abstract void setAdd_popularity_value(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FriendsCircleTreadResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */