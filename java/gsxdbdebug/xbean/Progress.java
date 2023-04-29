package xbean;

import xdb.Bean;

public abstract interface Progress
  extends Bean
{
  public abstract Progress copy();
  
  public abstract Progress toData();
  
  public abstract Progress toBean();
  
  public abstract Progress toDataIf();
  
  public abstract Progress toBeanIf();
  
  public abstract int getChapter();
  
  public abstract int getSection();
  
  public abstract void setChapter(int paramInt);
  
  public abstract void setSection(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Progress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */