package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface AdvertInfo
  extends Bean
{
  public abstract AdvertInfo copy();
  
  public abstract AdvertInfo toData();
  
  public abstract AdvertInfo toBean();
  
  public abstract AdvertInfo toDataIf();
  
  public abstract AdvertInfo toBeanIf();
  
  public abstract int getAdverttype();
  
  public abstract long getRelease_timestamp();
  
  public abstract String getContent();
  
  public abstract Octets getContentOctets();
  
  public abstract int getIstop();
  
  public abstract void setAdverttype(int paramInt);
  
  public abstract void setRelease_timestamp(long paramLong);
  
  public abstract void setContent(String paramString);
  
  public abstract void setContentOctets(Octets paramOctets);
  
  public abstract void setIstop(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AdvertInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */