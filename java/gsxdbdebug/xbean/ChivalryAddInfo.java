package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ChivalryAddInfo
  extends Bean
{
  public abstract ChivalryAddInfo copy();
  
  public abstract ChivalryAddInfo toData();
  
  public abstract ChivalryAddInfo toBean();
  
  public abstract ChivalryAddInfo toDataIf();
  
  public abstract ChivalryAddInfo toBeanIf();
  
  public abstract Map<Integer, Integer> getGaintype2addnumonpveend();
  
  public abstract Map<Integer, Integer> getGaintype2addnumonpveendAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChivalryAddInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */