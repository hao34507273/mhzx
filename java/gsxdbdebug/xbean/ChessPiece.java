package xbean;

import xdb.Bean;

public abstract interface ChessPiece
  extends Bean
{
  public abstract ChessPiece copy();
  
  public abstract ChessPiece toData();
  
  public abstract ChessPiece toBean();
  
  public abstract ChessPiece toDataIf();
  
  public abstract ChessPiece toBeanIf();
  
  public abstract int getChess_piece_index();
  
  public abstract boolean getOwn_by_a();
  
  public abstract boolean getVisible();
  
  public abstract void setChess_piece_index(int paramInt);
  
  public abstract void setOwn_by_a(boolean paramBoolean);
  
  public abstract void setVisible(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChessPiece.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */