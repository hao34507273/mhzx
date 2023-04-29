package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface HuSongDataBean
  extends Bean
{
  public static final int HU_SONG_CFG_ID_TYPE = 1;
  public static final int HU_SONG_MONEY_CFG_ID_TYPE = 2;
  public static final int HU_SONG_FAIL_COUNT_TYPE = 3;
  public static final int HU_SONG_FIGHT_COUNT_TYPE = 4;
  public static final int HU_SONG_FIGHT_SESSIONID_LOW = 5;
  public static final int HU_SONG_FIGHT_SESSIONID_HIGH = 6;
  
  public abstract HuSongDataBean copy();
  
  public abstract HuSongDataBean toData();
  
  public abstract HuSongDataBean toBean();
  
  public abstract HuSongDataBean toDataIf();
  
  public abstract HuSongDataBean toBeanIf();
  
  public abstract Map<Integer, Integer> getParammap();
  
  public abstract Map<Integer, Integer> getParammapAsData();
  
  public abstract int getSpecialcount();
  
  public abstract void setSpecialcount(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\HuSongDataBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */