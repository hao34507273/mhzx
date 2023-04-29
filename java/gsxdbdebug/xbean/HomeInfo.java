package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface HomeInfo
  extends Bean
{
  public abstract HomeInfo copy();
  
  public abstract HomeInfo toData();
  
  public abstract HomeInfo toBean();
  
  public abstract HomeInfo toDataIf();
  
  public abstract HomeInfo toBeanIf();
  
  public abstract int getHomelevel();
  
  public abstract int getCleanliness();
  
  public abstract int getPetroomlevel();
  
  public abstract int getBedroomlevel();
  
  public abstract int getDaycleancount();
  
  public abstract int getDrugroomlevel();
  
  public abstract int getKitchenlevel();
  
  public abstract int getMaidroomlevel();
  
  public abstract Map<Long, MaidInfo> getUuid2maidinfo();
  
  public abstract Map<Long, MaidInfo> getUuid2maidinfoAsData();
  
  public abstract long getCurrentmaiduuid();
  
  public abstract boolean getIsmainhome();
  
  public abstract long getUpdatetime();
  
  public abstract Map<Long, FurnitureInfo> getMydisplayfurniture();
  
  public abstract Map<Long, FurnitureInfo> getMydisplayfurnitureAsData();
  
  public abstract Map<Long, FurnitureInfo> getPartnerdisplayfurniture();
  
  public abstract Map<Long, FurnitureInfo> getPartnerdisplayfurnitureAsData();
  
  public abstract int getCourtyardlevel();
  
  public abstract int getFengshui();
  
  public abstract long getWalluuid();
  
  public abstract long getFlooruuid();
  
  public abstract int getCourt_yard_beautiful();
  
  public abstract long getCourt_yard_cleanliness_refresh_time();
  
  public abstract int getCourt_yard_cleanliness();
  
  public abstract int getCourt_yard_day_clean_count();
  
  public abstract long getFence_uuid();
  
  public abstract long getCourt_yard_terrain_uuid();
  
  public abstract long getCourt_yard_road_uuid();
  
  public abstract void setHomelevel(int paramInt);
  
  public abstract void setCleanliness(int paramInt);
  
  public abstract void setPetroomlevel(int paramInt);
  
  public abstract void setBedroomlevel(int paramInt);
  
  public abstract void setDaycleancount(int paramInt);
  
  public abstract void setDrugroomlevel(int paramInt);
  
  public abstract void setKitchenlevel(int paramInt);
  
  public abstract void setMaidroomlevel(int paramInt);
  
  public abstract void setCurrentmaiduuid(long paramLong);
  
  public abstract void setIsmainhome(boolean paramBoolean);
  
  public abstract void setUpdatetime(long paramLong);
  
  public abstract void setCourtyardlevel(int paramInt);
  
  public abstract void setFengshui(int paramInt);
  
  public abstract void setWalluuid(long paramLong);
  
  public abstract void setFlooruuid(long paramLong);
  
  public abstract void setCourt_yard_beautiful(int paramInt);
  
  public abstract void setCourt_yard_cleanliness_refresh_time(long paramLong);
  
  public abstract void setCourt_yard_cleanliness(int paramInt);
  
  public abstract void setCourt_yard_day_clean_count(int paramInt);
  
  public abstract void setFence_uuid(long paramLong);
  
  public abstract void setCourt_yard_terrain_uuid(long paramLong);
  
  public abstract void setCourt_yard_road_uuid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\HomeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */