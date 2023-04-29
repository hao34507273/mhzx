package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface CakeDetailData
  extends Bean
{
  public abstract CakeDetailData copy();
  
  public abstract CakeDetailData toData();
  
  public abstract CakeDetailData toBean();
  
  public abstract CakeDetailData toDataIf();
  
  public abstract CakeDetailData toBeanIf();
  
  public abstract int getCakeid();
  
  public abstract int getState();
  
  public abstract long getCookstarttime();
  
  public abstract int getNextcakeid();
  
  public abstract List<CakeHistoryData> getHistory();
  
  public abstract List<CakeHistoryData> getHistoryAsData();
  
  public abstract void setCakeid(int paramInt);
  
  public abstract void setState(int paramInt);
  
  public abstract void setCookstarttime(long paramLong);
  
  public abstract void setNextcakeid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CakeDetailData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */