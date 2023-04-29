package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface QingData
  extends Bean
{
  public static final int OUT_POST__NORMAL = 1;
  public static final int OUT_POST__ELITE = 2;
  public static final int OUT_POST__HERO = 3;
  
  public abstract QingData copy();
  
  public abstract QingData toData();
  
  public abstract QingData toBean();
  
  public abstract QingData toDataIf();
  
  public abstract QingData toBeanIf();
  
  public abstract Map<Integer, Progress> getType2progress();
  
  public abstract Map<Integer, Progress> getType2progressAsData();
  
  public abstract Map<Integer, HelpData> getType2helpdata();
  
  public abstract Map<Integer, HelpData> getType2helpdataAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\QingData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */