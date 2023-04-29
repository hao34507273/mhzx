package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface WAwardBean
  extends Bean
{
  public abstract WAwardBean copy();
  
  public abstract WAwardBean toData();
  
  public abstract WAwardBean toBean();
  
  public abstract WAwardBean toDataIf();
  
  public abstract WAwardBean toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract Map<Integer, Integer> getNbitems();
  
  public abstract Map<Integer, Integer> getNbitemsAsData();
  
  public abstract Map<Integer, Integer> getNmitems();
  
  public abstract Map<Integer, Integer> getNmitemsAsData();
  
  public abstract void setRoleid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WAwardBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */