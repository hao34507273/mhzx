package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface BanGraphBean
  extends Bean
{
  public abstract BanGraphBean copy();
  
  public abstract BanGraphBean toData();
  
  public abstract BanGraphBean toBean();
  
  public abstract BanGraphBean toDataIf();
  
  public abstract BanGraphBean toBeanIf();
  
  public abstract Set<Integer> getGraphids();
  
  public abstract Set<Integer> getGraphidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BanGraphBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */