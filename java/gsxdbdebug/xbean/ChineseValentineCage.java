package xbean;

import xdb.Bean;

public abstract interface ChineseValentineCage
  extends Bean
{
  public abstract ChineseValentineCage copy();
  
  public abstract ChineseValentineCage toData();
  
  public abstract ChineseValentineCage toBean();
  
  public abstract ChineseValentineCage toDataIf();
  
  public abstract ChineseValentineCage toBeanIf();
  
  public abstract int getHighlightindex();
  
  public abstract int getPressindex();
  
  public abstract long getPresstime();
  
  public abstract void setHighlightindex(int paramInt);
  
  public abstract void setPressindex(int paramInt);
  
  public abstract void setPresstime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChineseValentineCage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */