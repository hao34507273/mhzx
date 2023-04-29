package xbean;

import com.goldhuman.Common.Octets;
import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface Sworn
  extends Bean
{
  public abstract Sworn copy();
  
  public abstract Sworn toData();
  
  public abstract Sworn toBean();
  
  public abstract Sworn toDataIf();
  
  public abstract Sworn toBeanIf();
  
  public abstract String getName1();
  
  public abstract Octets getName1Octets();
  
  public abstract String getName2();
  
  public abstract Octets getName2Octets();
  
  public abstract long getCreaterid();
  
  public abstract List<Long> getMembers();
  
  public abstract List<Long> getMembersAsData();
  
  public abstract Map<Long, SwornNewMember> getNewmember();
  
  public abstract Map<Long, SwornNewMember> getNewmemberAsData();
  
  public abstract SwornNewName getNewname();
  
  public abstract SwornKickOut getKickoutmember();
  
  public abstract void setName1(String paramString);
  
  public abstract void setName1Octets(Octets paramOctets);
  
  public abstract void setName2(String paramString);
  
  public abstract void setName2Octets(Octets paramOctets);
  
  public abstract void setCreaterid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Sworn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */