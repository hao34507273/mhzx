package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface CakeHistoryData
  extends Bean
{
  public abstract CakeHistoryData copy();
  
  public abstract CakeHistoryData toData();
  
  public abstract CakeHistoryData toBean();
  
  public abstract CakeHistoryData toDataIf();
  
  public abstract CakeHistoryData toBeanIf();
  
  public abstract long getTimeline();
  
  public abstract int getBeforecakeid();
  
  public abstract int getAftercakeid();
  
  public abstract String getOperrolename();
  
  public abstract Octets getOperrolenameOctets();
  
  public abstract String getMastername();
  
  public abstract Octets getMasternameOctets();
  
  public abstract int getItemid();
  
  public abstract int getHistorytype();
  
  public abstract void setTimeline(long paramLong);
  
  public abstract void setBeforecakeid(int paramInt);
  
  public abstract void setAftercakeid(int paramInt);
  
  public abstract void setOperrolename(String paramString);
  
  public abstract void setOperrolenameOctets(Octets paramOctets);
  
  public abstract void setMastername(String paramString);
  
  public abstract void setMasternameOctets(Octets paramOctets);
  
  public abstract void setItemid(int paramInt);
  
  public abstract void setHistorytype(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CakeHistoryData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */