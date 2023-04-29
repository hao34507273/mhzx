package xbean;

import xdb.Bean;

public abstract interface ChessActivityInfo
  extends Bean
{
  public abstract ChessActivityInfo copy();
  
  public abstract ChessActivityInfo toData();
  
  public abstract ChessActivityInfo toBean();
  
  public abstract ChessActivityInfo toDataIf();
  
  public abstract ChessActivityInfo toBeanIf();
  
  public abstract int getToday_win_count();
  
  public abstract int getToday_lose_count();
  
  public abstract int getToday_draw_count();
  
  public abstract void setToday_win_count(int paramInt);
  
  public abstract void setToday_lose_count(int paramInt);
  
  public abstract void setToday_draw_count(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChessActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */