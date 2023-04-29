package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface DrawCarnivalAwardWinnerInfo
  extends Bean
{
  public abstract DrawCarnivalAwardWinnerInfo copy();
  
  public abstract DrawCarnivalAwardWinnerInfo toData();
  
  public abstract DrawCarnivalAwardWinnerInfo toBean();
  
  public abstract DrawCarnivalAwardWinnerInfo toDataIf();
  
  public abstract DrawCarnivalAwardWinnerInfo toBeanIf();
  
  public abstract long getRole_id();
  
  public abstract String getRole_name();
  
  public abstract Octets getRole_nameOctets();
  
  public abstract int getRandom_type_id();
  
  public abstract long getAward_count();
  
  public abstract long getAward_time_stamp();
  
  public abstract void setRole_id(long paramLong);
  
  public abstract void setRole_name(String paramString);
  
  public abstract void setRole_nameOctets(Octets paramOctets);
  
  public abstract void setRandom_type_id(int paramInt);
  
  public abstract void setAward_count(long paramLong);
  
  public abstract void setAward_time_stamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DrawCarnivalAwardWinnerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */