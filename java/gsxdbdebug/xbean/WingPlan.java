package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface WingPlan
  extends Bean
{
  public abstract WingPlan copy();
  
  public abstract WingPlan toData();
  
  public abstract WingPlan toBean();
  
  public abstract WingPlan toDataIf();
  
  public abstract WingPlan toBeanIf();
  
  public abstract int getCurlv();
  
  public abstract int getCurrank();
  
  public abstract int getCurexp();
  
  public abstract int getCurwing();
  
  public abstract Map<Integer, WingContent> getWings();
  
  public abstract Map<Integer, WingContent> getWingsAsData();
  
  public abstract void setCurlv(int paramInt);
  
  public abstract void setCurrank(int paramInt);
  
  public abstract void setCurexp(int paramInt);
  
  public abstract void setCurwing(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WingPlan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */