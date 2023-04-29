package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface TssSumInfo
  extends Bean
{
  public abstract TssSumInfo copy();
  
  public abstract TssSumInfo toData();
  
  public abstract TssSumInfo toBean();
  
  public abstract TssSumInfo toDataIf();
  
  public abstract TssSumInfo toBeanIf();
  
  public abstract long getFirst_buy_time();
  
  public abstract long getBegin_time();
  
  public abstract long getEnd_time();
  
  public abstract long getGrandtotal_opendays();
  
  public abstract long getGrandtotal_presentdays();
  
  public abstract String getPaychan();
  
  public abstract Octets getPaychanOctets();
  
  public abstract String getPaysubchan();
  
  public abstract Octets getPaysubchanOctets();
  
  public abstract String getAutopaychan();
  
  public abstract Octets getAutopaychanOctets();
  
  public abstract String getAutopaysubchan();
  
  public abstract Octets getAutopaysubchanOctets();
  
  public abstract void setFirst_buy_time(long paramLong);
  
  public abstract void setBegin_time(long paramLong);
  
  public abstract void setEnd_time(long paramLong);
  
  public abstract void setGrandtotal_opendays(long paramLong);
  
  public abstract void setGrandtotal_presentdays(long paramLong);
  
  public abstract void setPaychan(String paramString);
  
  public abstract void setPaychanOctets(Octets paramOctets);
  
  public abstract void setPaysubchan(String paramString);
  
  public abstract void setPaysubchanOctets(Octets paramOctets);
  
  public abstract void setAutopaychan(String paramString);
  
  public abstract void setAutopaychanOctets(Octets paramOctets);
  
  public abstract void setAutopaysubchan(String paramString);
  
  public abstract void setAutopaysubchanOctets(Octets paramOctets);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TssSumInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */