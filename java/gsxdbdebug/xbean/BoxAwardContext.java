package xbean;

import mzm.gsp.instance.main.AwardContext;
import xdb.Bean;

public abstract interface BoxAwardContext
  extends Bean
{
  public abstract BoxAwardContext copy();
  
  public abstract BoxAwardContext toData();
  
  public abstract BoxAwardContext toBean();
  
  public abstract BoxAwardContext toDataIf();
  
  public abstract BoxAwardContext toBeanIf();
  
  public abstract AwardContext getContext();
  
  public abstract void setContext(AwardContext paramAwardContext);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BoxAwardContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */