package xbean;

import xdb.Bean;

public abstract interface HelpData
  extends Bean
{
  public abstract HelpData copy();
  
  public abstract HelpData toData();
  
  public abstract HelpData toBean();
  
  public abstract HelpData toDataIf();
  
  public abstract HelpData toBeanIf();
  
  public abstract int getHelpcount();
  
  public abstract long getHelptime();
  
  public abstract void setHelpcount(int paramInt);
  
  public abstract void setHelptime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\HelpData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */