package xbean;

import com.goldhuman.Common.Octets;
import java.util.List;
import xdb.Bean;

public abstract interface SwornNewName
  extends Bean
{
  public abstract SwornNewName copy();
  
  public abstract SwornNewName toData();
  
  public abstract SwornNewName toBean();
  
  public abstract SwornNewName toDataIf();
  
  public abstract SwornNewName toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract String getName1();
  
  public abstract Octets getName1Octets();
  
  public abstract String getName2();
  
  public abstract Octets getName2Octets();
  
  public abstract long getVerifytime();
  
  public abstract List<Long> getVerifyids();
  
  public abstract List<Long> getVerifyidsAsData();
  
  public abstract List<Long> getVoteids();
  
  public abstract List<Long> getVoteidsAsData();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setName1(String paramString);
  
  public abstract void setName1Octets(Octets paramOctets);
  
  public abstract void setName2(String paramString);
  
  public abstract void setName2Octets(Octets paramOctets);
  
  public abstract void setVerifytime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SwornNewName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */