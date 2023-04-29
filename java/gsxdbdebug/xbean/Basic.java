package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface Basic
  extends Bean
{
  public abstract Basic copy();
  
  public abstract Basic toData();
  
  public abstract Basic toBean();
  
  public abstract Basic toDataIf();
  
  public abstract Basic toBeanIf();
  
  public abstract String getUser_id();
  
  public abstract Octets getUser_idOctets();
  
  public abstract long getQqid();
  
  public abstract String getName();
  
  public abstract Octets getNameOctets();
  
  public abstract int getGender();
  
  public abstract int getOccupationid();
  
  public abstract long getCreatetime();
  
  public abstract void setUser_id(String paramString);
  
  public abstract void setUser_idOctets(Octets paramOctets);
  
  public abstract void setQqid(long paramLong);
  
  public abstract void setName(String paramString);
  
  public abstract void setNameOctets(Octets paramOctets);
  
  public abstract void setGender(int paramInt);
  
  public abstract void setOccupationid(int paramInt);
  
  public abstract void setCreatetime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Basic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */