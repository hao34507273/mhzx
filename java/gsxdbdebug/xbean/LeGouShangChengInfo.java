package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface LeGouShangChengInfo
  extends Bean
{
  public abstract LeGouShangChengInfo copy();
  
  public abstract LeGouShangChengInfo toData();
  
  public abstract LeGouShangChengInfo toBean();
  
  public abstract LeGouShangChengInfo toDataIf();
  
  public abstract LeGouShangChengInfo toBeanIf();
  
  public abstract Map<Integer, Integer> getCfgid2buycount();
  
  public abstract Map<Integer, Integer> getCfgid2buycountAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LeGouShangChengInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */