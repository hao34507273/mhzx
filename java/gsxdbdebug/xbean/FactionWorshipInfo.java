package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface FactionWorshipInfo
  extends Bean
{
  public abstract FactionWorshipInfo copy();
  
  public abstract FactionWorshipInfo toData();
  
  public abstract FactionWorshipInfo toBean();
  
  public abstract FactionWorshipInfo toDataIf();
  
  public abstract FactionWorshipInfo toBeanIf();
  
  public abstract Map<Integer, Integer> getWorshipdata();
  
  public abstract Map<Integer, Integer> getWorshipdataAsData();
  
  public abstract List<SingleWorshipInfo> getWorshiprecord();
  
  public abstract List<SingleWorshipInfo> getWorshiprecordAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FactionWorshipInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */