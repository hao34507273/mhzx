package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface HomeOperate
  extends Bean
{
  public static final int HOME_STATE_NONE = 1;
  public static final int HOME_STATE_CREATOR = 2;
  public static final int HOME_STATE_SHARE = 4;
  
  public abstract HomeOperate copy();
  
  public abstract HomeOperate toData();
  
  public abstract HomeOperate toBean();
  
  public abstract HomeOperate toDataIf();
  
  public abstract HomeOperate toBeanIf();
  
  public abstract Map<Integer, FurnitureUuIds> getOwnfurnitures();
  
  public abstract Map<Integer, FurnitureUuIds> getOwnfurnituresAsData();
  
  public abstract Set<Integer> getCanbuyitems();
  
  public abstract Set<Integer> getCanbuyitemsAsData();
  
  public abstract Map<Integer, Integer> getItem2buynum();
  
  public abstract Map<Integer, Integer> getItem2buynumAsData();
  
  public abstract int getDayrefreshcount();
  
  public abstract int getDayrestorevigorcount();
  
  public abstract int getDayrestoresatiationcount();
  
  public abstract int getDayttrainpetcount();
  
  public abstract long getUpdatetime();
  
  public abstract int getHomestate();
  
  public abstract Map<Integer, Integer> getCanbuyitem2num();
  
  public abstract Map<Integer, Integer> getCanbuyitem2numAsData();
  
  public abstract void setDayrefreshcount(int paramInt);
  
  public abstract void setDayrestorevigorcount(int paramInt);
  
  public abstract void setDayrestoresatiationcount(int paramInt);
  
  public abstract void setDayttrainpetcount(int paramInt);
  
  public abstract void setUpdatetime(long paramLong);
  
  public abstract void setHomestate(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\HomeOperate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */