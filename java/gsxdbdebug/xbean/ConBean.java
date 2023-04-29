package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ConBean
  extends Bean
{
  public abstract ConBean copy();
  
  public abstract ConBean toData();
  
  public abstract ConBean toBean();
  
  public abstract ConBean toDataIf();
  
  public abstract ConBean toBeanIf();
  
  public abstract int getType();
  
  public abstract Map<Integer, Long> getParammap();
  
  public abstract Map<Integer, Long> getParammapAsData();
  
  public abstract void setType(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ConBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */