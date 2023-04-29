package xbean;

import xdb.Bean;

public abstract interface Camp
  extends Bean
{
  public abstract Camp copy();
  
  public abstract Camp toData();
  
  public abstract Camp toBean();
  
  public abstract Camp toDataIf();
  
  public abstract Camp toBeanIf();
  
  public abstract int getRole_number();
  
  public abstract int getScore();
  
  public abstract void setRole_number(int paramInt);
  
  public abstract void setScore(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Camp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */