package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface BountyInfo
  extends Bean
{
  public abstract BountyInfo copy();
  
  public abstract BountyInfo toData();
  
  public abstract BountyInfo toBean();
  
  public abstract BountyInfo toDataIf();
  
  public abstract BountyInfo toBeanIf();
  
  public abstract int getBountycount();
  
  public abstract Map<Integer, BTaskInfo> getTaskinfos();
  
  public abstract Map<Integer, BTaskInfo> getTaskinfosAsData();
  
  public abstract Map<Integer, BTaskData> getDonetaskinfo();
  
  public abstract Map<Integer, BTaskData> getDonetaskinfoAsData();
  
  public abstract int getUsedbirdnum();
  
  public abstract int getFreerefreshcount();
  
  public abstract int getPreguaranteecount();
  
  public abstract void setBountycount(int paramInt);
  
  public abstract void setUsedbirdnum(int paramInt);
  
  public abstract void setFreerefreshcount(int paramInt);
  
  public abstract void setPreguaranteecount(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BountyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */