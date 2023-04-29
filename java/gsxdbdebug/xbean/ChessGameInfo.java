package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ChessGameInfo
  extends Bean
{
  public abstract ChessGameInfo copy();
  
  public abstract ChessGameInfo toData();
  
  public abstract ChessGameInfo toBean();
  
  public abstract ChessGameInfo toDataIf();
  
  public abstract ChessGameInfo toBeanIf();
  
  public abstract long getContext_id();
  
  public abstract int getCfg_id();
  
  public abstract long getSession_id();
  
  public abstract long getStart_time();
  
  public abstract long getPlayer_a();
  
  public abstract long getPlayer_b();
  
  public abstract boolean getCurrent_player_is_a();
  
  public abstract int getRound();
  
  public abstract long getRound_start_time();
  
  public abstract int getLast_kill_round();
  
  public abstract int getPlayer_a_last_operate_round();
  
  public abstract int getPlayer_b_last_operate_round();
  
  public abstract long getNext_operate_time();
  
  public abstract Map<Integer, ChessPiece> getChess_board_index2chess_piece();
  
  public abstract Map<Integer, ChessPiece> getChess_board_index2chess_pieceAsData();
  
  public abstract void setContext_id(long paramLong);
  
  public abstract void setCfg_id(int paramInt);
  
  public abstract void setSession_id(long paramLong);
  
  public abstract void setStart_time(long paramLong);
  
  public abstract void setPlayer_a(long paramLong);
  
  public abstract void setPlayer_b(long paramLong);
  
  public abstract void setCurrent_player_is_a(boolean paramBoolean);
  
  public abstract void setRound(int paramInt);
  
  public abstract void setRound_start_time(long paramLong);
  
  public abstract void setLast_kill_round(int paramInt);
  
  public abstract void setPlayer_a_last_operate_round(int paramInt);
  
  public abstract void setPlayer_b_last_operate_round(int paramInt);
  
  public abstract void setNext_operate_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChessGameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */