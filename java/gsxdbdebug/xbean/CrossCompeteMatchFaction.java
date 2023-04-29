package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface CrossCompeteMatchFaction
  extends Bean
{
  public abstract CrossCompeteMatchFaction copy();
  
  public abstract CrossCompeteMatchFaction toData();
  
  public abstract CrossCompeteMatchFaction toBean();
  
  public abstract CrossCompeteMatchFaction toDataIf();
  
  public abstract CrossCompeteMatchFaction toBeanIf();
  
  public abstract String getName();
  
  public abstract Octets getNameOctets();
  
  public abstract int getLevel();
  
  public abstract int getServer_level();
  
  public abstract int getMember_count();
  
  public abstract int getWin_times();
  
  public abstract int getLose_times();
  
  public abstract int getActive_member_count();
  
  public abstract void setName(String paramString);
  
  public abstract void setNameOctets(Octets paramOctets);
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setServer_level(int paramInt);
  
  public abstract void setMember_count(int paramInt);
  
  public abstract void setWin_times(int paramInt);
  
  public abstract void setLose_times(int paramInt);
  
  public abstract void setActive_member_count(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossCompeteMatchFaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */