package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface NoneRealTimeOccMFVRankData
  extends Bean
{
  public abstract NoneRealTimeOccMFVRankData copy();
  
  public abstract NoneRealTimeOccMFVRankData toData();
  
  public abstract NoneRealTimeOccMFVRankData toBean();
  
  public abstract NoneRealTimeOccMFVRankData toDataIf();
  
  public abstract NoneRealTimeOccMFVRankData toBeanIf();
  
  public abstract Map<Integer, NoneRealTimeMultiFightValueRank> getOcc2rankdata();
  
  public abstract Map<Integer, NoneRealTimeMultiFightValueRank> getOcc2rankdataAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\NoneRealTimeOccMFVRankData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */