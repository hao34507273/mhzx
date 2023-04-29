package xbean;

import xdb.Bean;

public abstract interface FriendsCircleOrnamentItem
  extends Bean
{
  public abstract FriendsCircleOrnamentItem copy();
  
  public abstract FriendsCircleOrnamentItem toData();
  
  public abstract FriendsCircleOrnamentItem toBean();
  
  public abstract FriendsCircleOrnamentItem toDataIf();
  
  public abstract FriendsCircleOrnamentItem toBeanIf();
  
  public abstract int getItem_cfg_id();
  
  public abstract long getItem_uuid();
  
  public abstract void setItem_cfg_id(int paramInt);
  
  public abstract void setItem_uuid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FriendsCircleOrnamentItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */