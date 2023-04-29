package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface MysteryShopInfo
  extends Bean
{
  public abstract MysteryShopInfo copy();
  
  public abstract MysteryShopInfo toData();
  
  public abstract MysteryShopInfo toBean();
  
  public abstract MysteryShopInfo toDataIf();
  
  public abstract MysteryShopInfo toBeanIf();
  
  public abstract long getReset_time();
  
  public abstract int getRefresh_times();
  
  public abstract List<MysteryGoodsInfo> getGoods_list();
  
  public abstract List<MysteryGoodsInfo> getGoods_listAsData();
  
  public abstract int getUsed_free_refresh_times();
  
  public abstract int getCan_free_refresh_times();
  
  public abstract void setReset_time(long paramLong);
  
  public abstract void setRefresh_times(int paramInt);
  
  public abstract void setUsed_free_refresh_times(int paramInt);
  
  public abstract void setCan_free_refresh_times(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MysteryShopInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */