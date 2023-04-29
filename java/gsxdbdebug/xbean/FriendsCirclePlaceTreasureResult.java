package xbean;

import xdb.Bean;

public abstract interface FriendsCirclePlaceTreasureResult
  extends Bean
{
  public abstract FriendsCirclePlaceTreasureResult copy();
  
  public abstract FriendsCirclePlaceTreasureResult toData();
  
  public abstract FriendsCirclePlaceTreasureResult toBean();
  
  public abstract FriendsCirclePlaceTreasureResult toDataIf();
  
  public abstract FriendsCirclePlaceTreasureResult toBeanIf();
  
  public abstract boolean getIs_ssp_replied();
  
  public abstract int getPlace_treasure_count();
  
  public abstract void setIs_ssp_replied(boolean paramBoolean);
  
  public abstract void setPlace_treasure_count(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FriendsCirclePlaceTreasureResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */