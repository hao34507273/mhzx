package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface OccMFVRankData
  extends Bean
{
  public abstract OccMFVRankData copy();
  
  public abstract OccMFVRankData toData();
  
  public abstract OccMFVRankData toBean();
  
  public abstract OccMFVRankData toDataIf();
  
  public abstract OccMFVRankData toBeanIf();
  
  public abstract Map<Integer, MultiFightValueRank> getOcc2rankdata();
  
  public abstract Map<Integer, MultiFightValueRank> getOcc2rankdataAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\OccMFVRankData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */