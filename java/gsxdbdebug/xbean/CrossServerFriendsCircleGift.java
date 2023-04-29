package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface CrossServerFriendsCircleGift
  extends Bean
{
  public abstract CrossServerFriendsCircleGift copy();
  
  public abstract CrossServerFriendsCircleGift toData();
  
  public abstract CrossServerFriendsCircleGift toBean();
  
  public abstract CrossServerFriendsCircleGift toDataIf();
  
  public abstract CrossServerFriendsCircleGift toBeanIf();
  
  public abstract long getReceive_gift_role_id();
  
  public abstract int getReceive_gift_role_zone_id();
  
  public abstract int getItem_cfg_id();
  
  public abstract int getItem_grade();
  
  public abstract int getItem_num();
  
  public abstract int getAdd_popularity_value();
  
  public abstract String getMessage();
  
  public abstract Octets getMessageOctets();
  
  public abstract boolean getIs_server_replied();
  
  public abstract void setReceive_gift_role_id(long paramLong);
  
  public abstract void setReceive_gift_role_zone_id(int paramInt);
  
  public abstract void setItem_cfg_id(int paramInt);
  
  public abstract void setItem_grade(int paramInt);
  
  public abstract void setItem_num(int paramInt);
  
  public abstract void setAdd_popularity_value(int paramInt);
  
  public abstract void setMessage(String paramString);
  
  public abstract void setMessageOctets(Octets paramOctets);
  
  public abstract void setIs_server_replied(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossServerFriendsCircleGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */