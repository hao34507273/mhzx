package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ResourceId2Num
  extends Bean
{
  public abstract ResourceId2Num copy();
  
  public abstract ResourceId2Num toData();
  
  public abstract ResourceId2Num toBean();
  
  public abstract ResourceId2Num toDataIf();
  
  public abstract ResourceId2Num toBeanIf();
  
  public abstract Map<Integer, Long> getId2num();
  
  public abstract Map<Integer, Long> getId2numAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ResourceId2Num.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */