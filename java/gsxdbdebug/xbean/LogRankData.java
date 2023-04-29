package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface LogRankData
  extends Bean
{
  public static final int ROLE_FV = 1;
  public static final int ROLE_MFV = 2;
  
  public abstract LogRankData copy();
  
  public abstract LogRankData toData();
  
  public abstract LogRankData toBean();
  
  public abstract LogRankData toDataIf();
  
  public abstract LogRankData toBeanIf();
  
  public abstract Map<Integer, RecordData> getType2rankdata();
  
  public abstract Map<Integer, RecordData> getType2rankdataAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LogRankData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */