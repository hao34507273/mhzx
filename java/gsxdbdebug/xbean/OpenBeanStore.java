package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface OpenBeanStore
  extends Bean
{
  public abstract OpenBeanStore copy();
  
  public abstract OpenBeanStore toData();
  
  public abstract OpenBeanStore toBean();
  
  public abstract OpenBeanStore toDataIf();
  
  public abstract OpenBeanStore toBeanIf();
  
  public abstract long getEndtime();
  
  public abstract int getActivityduration();
  
  public abstract Map<Integer, StageBean> getStagemap();
  
  public abstract Map<Integer, StageBean> getStagemapAsData();
  
  public abstract int getStage();
  
  public abstract long getCleardatatime();
  
  public abstract int getOpenstate();
  
  public abstract void setEndtime(long paramLong);
  
  public abstract void setActivityduration(int paramInt);
  
  public abstract void setStage(int paramInt);
  
  public abstract void setCleardatatime(long paramLong);
  
  public abstract void setOpenstate(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\OpenBeanStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */