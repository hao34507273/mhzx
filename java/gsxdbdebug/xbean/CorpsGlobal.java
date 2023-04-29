package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface CorpsGlobal
  extends Bean
{
  public abstract CorpsGlobal copy();
  
  public abstract CorpsGlobal toData();
  
  public abstract CorpsGlobal toBean();
  
  public abstract CorpsGlobal toDataIf();
  
  public abstract CorpsGlobal toBeanIf();
  
  public abstract Set<Long> getAllcorpsids();
  
  public abstract Set<Long> getAllcorpsidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CorpsGlobal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */