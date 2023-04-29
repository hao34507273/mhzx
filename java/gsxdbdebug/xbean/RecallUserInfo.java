package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface RecallUserInfo
  extends Bean
{
  public abstract RecallUserInfo copy();
  
  public abstract RecallUserInfo toData();
  
  public abstract RecallUserInfo toBean();
  
  public abstract RecallUserInfo toDataIf();
  
  public abstract RecallUserInfo toBeanIf();
  
  public abstract String getUser_id();
  
  public abstract Octets getUser_idOctets();
  
  public abstract long getRecall_time();
  
  public abstract long getRecall_role_id();
  
  public abstract String getRecall_openid();
  
  public abstract Octets getRecall_openidOctets();
  
  public abstract long getStart_time();
  
  public abstract int getBe_recall_num();
  
  public abstract void setUser_id(String paramString);
  
  public abstract void setUser_idOctets(Octets paramOctets);
  
  public abstract void setRecall_time(long paramLong);
  
  public abstract void setRecall_role_id(long paramLong);
  
  public abstract void setRecall_openid(String paramString);
  
  public abstract void setRecall_openidOctets(Octets paramOctets);
  
  public abstract void setStart_time(long paramLong);
  
  public abstract void setBe_recall_num(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RecallUserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */