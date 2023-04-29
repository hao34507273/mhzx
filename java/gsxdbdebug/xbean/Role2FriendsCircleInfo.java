package xbean;

import java.util.List;
import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface Role2FriendsCircleInfo
  extends Bean
{
  public abstract Role2FriendsCircleInfo copy();
  
  public abstract Role2FriendsCircleInfo toData();
  
  public abstract Role2FriendsCircleInfo toBean();
  
  public abstract Role2FriendsCircleInfo toDataIf();
  
  public abstract Role2FriendsCircleInfo toBeanIf();
  
  public abstract int getTreasure_box_num();
  
  public abstract int getToday_get_treasure_box_num();
  
  public abstract long getLast_get_treasure_box_time();
  
  public abstract long getLast_week_popularity_value_refresh_time();
  
  public abstract int getCurrent_week_popularity_value();
  
  public abstract int getTotal_popularity_value();
  
  public abstract int getReceive_gift_num();
  
  public abstract Map<Long, Integer> getToday_tread_circle_role_id_map();
  
  public abstract Map<Long, Integer> getToday_tread_circle_role_id_mapAsData();
  
  public abstract long getLast_tread_circle_time();
  
  public abstract Map<Long, Integer> getToday_tread_my_circle_role_id_map();
  
  public abstract Map<Long, Integer> getToday_tread_my_circle_role_id_mapAsData();
  
  public abstract long getLast_tread_my_circle_time();
  
  public abstract Map<Integer, Long> getOwn_pendant_ornament_map();
  
  public abstract Map<Integer, Long> getOwn_pendant_ornament_mapAsData();
  
  public abstract Map<Integer, Long> getOwn_rahmen_ornament_map();
  
  public abstract Map<Integer, Long> getOwn_rahmen_ornament_mapAsData();
  
  public abstract FriendsCircleOrnamentItem getCurrent_pendant_ornament();
  
  public abstract FriendsCircleOrnamentItem getCurrent_rahmen_ornament();
  
  public abstract Map<Long, CrossServerFriendsCircleGift> getCross_server_send_gift();
  
  public abstract Map<Long, CrossServerFriendsCircleGift> getCross_server_send_giftAsData();
  
  public abstract Map<Long, CrossServerFriendsCircleTread> getCross_server_tread();
  
  public abstract Map<Long, CrossServerFriendsCircleTread> getCross_server_treadAsData();
  
  public abstract Map<Long, FriendsCircleGiftResult> getBe_sent_gift();
  
  public abstract Map<Long, FriendsCircleGiftResult> getBe_sent_giftAsData();
  
  public abstract Map<Long, FriendsCircleTreadResult> getBe_trod_result();
  
  public abstract Map<Long, FriendsCircleTreadResult> getBe_trod_resultAsData();
  
  public abstract Map<Long, FriendsCirclePlaceTreasureResult> getPlace_treasure_result();
  
  public abstract Map<Long, FriendsCirclePlaceTreasureResult> getPlace_treasure_resultAsData();
  
  public abstract boolean getUpdate_ornament_result();
  
  public abstract int getToday_get_popularity_from_tread();
  
  public abstract List<Long> getMy_black_role_list();
  
  public abstract List<Long> getMy_black_role_listAsData();
  
  public abstract Set<Long> getCross_server_black_in_role_set();
  
  public abstract Set<Long> getCross_server_black_in_role_setAsData();
  
  public abstract Map<Long, CrossServerFriendsCircleBlackRole> getCross_server_black_operator();
  
  public abstract Map<Long, CrossServerFriendsCircleBlackRole> getCross_server_black_operatorAsData();
  
  public abstract int getRepair_tread();
  
  public abstract void setTreasure_box_num(int paramInt);
  
  public abstract void setToday_get_treasure_box_num(int paramInt);
  
  public abstract void setLast_get_treasure_box_time(long paramLong);
  
  public abstract void setLast_week_popularity_value_refresh_time(long paramLong);
  
  public abstract void setCurrent_week_popularity_value(int paramInt);
  
  public abstract void setTotal_popularity_value(int paramInt);
  
  public abstract void setReceive_gift_num(int paramInt);
  
  public abstract void setLast_tread_circle_time(long paramLong);
  
  public abstract void setLast_tread_my_circle_time(long paramLong);
  
  public abstract void setUpdate_ornament_result(boolean paramBoolean);
  
  public abstract void setToday_get_popularity_from_tread(int paramInt);
  
  public abstract void setRepair_tread(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2FriendsCircleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */