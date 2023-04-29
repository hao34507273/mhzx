package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface FriendsCircleGiftResult
  extends Bean
{
  public abstract FriendsCircleGiftResult copy();
  
  public abstract FriendsCircleGiftResult toData();
  
  public abstract FriendsCircleGiftResult toBean();
  
  public abstract FriendsCircleGiftResult toDataIf();
  
  public abstract FriendsCircleGiftResult toBeanIf();
  
  public abstract long getGive_gift_role_id();
  
  public abstract int getGive_gift_zone_id();
  
  public abstract int getItem_cfg_id();
  
  public abstract int getItem_grade();
  
  public abstract int getItem_num();
  
  public abstract int getAdd_popularity_value();
  
  public abstract String getMessage();
  
  public abstract Octets getMessageOctets();
  
  public abstract boolean getIs_ssp_replied();
  
  public abstract boolean getIs_cross_server();
  
  public abstract void setGive_gift_role_id(long paramLong);
  
  public abstract void setGive_gift_zone_id(int paramInt);
  
  public abstract void setItem_cfg_id(int paramInt);
  
  public abstract void setItem_grade(int paramInt);
  
  public abstract void setItem_num(int paramInt);
  
  public abstract void setAdd_popularity_value(int paramInt);
  
  public abstract void setMessage(String paramString);
  
  public abstract void setMessageOctets(Octets paramOctets);
  
  public abstract void setIs_ssp_replied(boolean paramBoolean);
  
  public abstract void setIs_cross_server(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FriendsCircleGiftResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */