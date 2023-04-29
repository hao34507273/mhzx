package xbean;

import xdb.Bean;

public abstract interface TeamInstance
  extends Bean
{
  public abstract TeamInstance copy();
  
  public abstract TeamInstance toData();
  
  public abstract TeamInstance toBean();
  
  public abstract TeamInstance toDataIf();
  
  public abstract TeamInstance toBeanIf();
  
  public abstract int getToprocess();
  
  public abstract int getSign();
  
  public abstract void setToprocess(int paramInt);
  
  public abstract void setSign(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TeamInstance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */