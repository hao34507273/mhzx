package xbean;

import xdb.Bean;

public abstract interface FillGridInfo
  extends Bean
{
  public abstract FillGridInfo copy();
  
  public abstract FillGridInfo toData();
  
  public abstract FillGridInfo toBean();
  
  public abstract FillGridInfo toDataIf();
  
  public abstract FillGridInfo toBeanIf();
  
  public abstract int getCost();
  
  public abstract int getCost_type();
  
  public abstract void setCost(int paramInt);
  
  public abstract void setCost_type(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FillGridInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */