package xbean;

import com.goldhuman.Common.Octets;
import java.util.Set;
import xdb.Bean;

public abstract interface AucItemInfo
  extends Bean
{
  public static final int NOT_SEND = 0;
  public static final int SEND = 1;
  
  public abstract AucItemInfo copy();
  
  public abstract AucItemInfo toData();
  
  public abstract AucItemInfo toBean();
  
  public abstract AucItemInfo toDataIf();
  
  public abstract AucItemInfo toBeanIf();
  
  public abstract int getItemcfgid();
  
  public abstract Set<Long> getBidderroleidset();
  
  public abstract Set<Long> getBidderroleidsetAsData();
  
  public abstract long getMaxbidprice();
  
  public abstract long getBidderroleid();
  
  public abstract String getBidderrolename();
  
  public abstract Octets getBidderrolenameOctets();
  
  public abstract long getBidendtimestamp();
  
  public abstract long getBidendfinaltimestamp();
  
  public abstract int getIssend();
  
  public abstract long getBidendsessionid();
  
  public abstract void setItemcfgid(int paramInt);
  
  public abstract void setMaxbidprice(long paramLong);
  
  public abstract void setBidderroleid(long paramLong);
  
  public abstract void setBidderrolename(String paramString);
  
  public abstract void setBidderrolenameOctets(Octets paramOctets);
  
  public abstract void setBidendtimestamp(long paramLong);
  
  public abstract void setBidendfinaltimestamp(long paramLong);
  
  public abstract void setIssend(int paramInt);
  
  public abstract void setBidendsessionid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AucItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */