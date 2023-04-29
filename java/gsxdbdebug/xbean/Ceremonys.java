package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface Ceremonys
  extends Bean
{
  public abstract Ceremonys copy();
  
  public abstract Ceremonys toData();
  
  public abstract Ceremonys toBean();
  
  public abstract Ceremonys toDataIf();
  
  public abstract Ceremonys toBeanIf();
  
  public abstract List<Ceremony> getCeremonys();
  
  public abstract List<Ceremony> getCeremonysAsData();
  
  public abstract int getCeremonycounter();
  
  public abstract void setCeremonycounter(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Ceremonys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */