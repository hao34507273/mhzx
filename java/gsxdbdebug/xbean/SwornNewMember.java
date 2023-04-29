package xbean;

import com.goldhuman.Common.Octets;
import java.util.List;
import xdb.Bean;

public abstract interface SwornNewMember
  extends Bean
{
  public abstract SwornNewMember copy();
  
  public abstract SwornNewMember toData();
  
  public abstract SwornNewMember toBean();
  
  public abstract SwornNewMember toDataIf();
  
  public abstract SwornNewMember toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract long getNewmemberid();
  
  public abstract String getNewmembertitle();
  
  public abstract Octets getNewmembertitleOctets();
  
  public abstract long getVerifytime();
  
  public abstract List<Long> getVerifyids();
  
  public abstract List<Long> getVerifyidsAsData();
  
  public abstract List<Long> getVoteids();
  
  public abstract List<Long> getVoteidsAsData();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setNewmemberid(long paramLong);
  
  public abstract void setNewmembertitle(String paramString);
  
  public abstract void setNewmembertitleOctets(Octets paramOctets);
  
  public abstract void setVerifytime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SwornNewMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */