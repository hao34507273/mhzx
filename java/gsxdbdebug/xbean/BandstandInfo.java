package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface BandstandInfo
  extends Bean
{
  public abstract BandstandInfo copy();
  
  public abstract BandstandInfo toData();
  
  public abstract BandstandInfo toBean();
  
  public abstract BandstandInfo toDataIf();
  
  public abstract BandstandInfo toBeanIf();
  
  public abstract Map<Integer, Integer> getActivityid2todayawardcount();
  
  public abstract Map<Integer, Integer> getActivityid2todayawardcountAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BandstandInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */