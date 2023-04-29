package xbean;

import mzm.gsp.musicgame.event.MusicGameContext;
import xdb.Bean;

public abstract interface MusicGameInfo
  extends Bean
{
  public static final int GAME_STATE_START = 1;
  public static final int GAME_STATE_OVER = 2;
  
  public abstract MusicGameInfo copy();
  
  public abstract MusicGameInfo toData();
  
  public abstract MusicGameInfo toBean();
  
  public abstract MusicGameInfo toDataIf();
  
  public abstract MusicGameInfo toBeanIf();
  
  public abstract int getGame_state();
  
  public abstract int getComplete_turn_index();
  
  public abstract int getRight_turn_num();
  
  public abstract long getSessionid();
  
  public abstract long getStart_timestamp();
  
  public abstract MusicGameContext getContext();
  
  public abstract void setGame_state(int paramInt);
  
  public abstract void setComplete_turn_index(int paramInt);
  
  public abstract void setRight_turn_num(int paramInt);
  
  public abstract void setSessionid(long paramLong);
  
  public abstract void setStart_timestamp(long paramLong);
  
  public abstract void setContext(MusicGameContext paramMusicGameContext);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MusicGameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */