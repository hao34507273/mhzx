package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ApplyInfoMap
  extends Bean
{
  public abstract ApplyInfoMap copy();
  
  public abstract ApplyInfoMap toData();
  
  public abstract ApplyInfoMap toBean();
  
  public abstract ApplyInfoMap toDataIf();
  
  public abstract ApplyInfoMap toBeanIf();
  
  public abstract Map<Long, ApplyInfo> getApplymap();
  
  public abstract Map<Long, ApplyInfo> getApplymapAsData();
  
  public abstract long getCleardatatime();
  
  public abstract int getApplyaddcount();
  
  public abstract int getApplyaddrefusecount();
  
  public abstract long getRefusebanchecktime();
  
  public abstract Map<Long, Integer> getRefusecountmap();
  
  public abstract Map<Long, Integer> getRefusecountmapAsData();
  
  public abstract void setCleardatatime(long paramLong);
  
  public abstract void setApplyaddcount(int paramInt);
  
  public abstract void setApplyaddrefusecount(int paramInt);
  
  public abstract void setRefusebanchecktime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ApplyInfoMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */