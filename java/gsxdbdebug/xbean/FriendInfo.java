package xbean;

import com.goldhuman.Common.Octets;
import java.util.Map;
import xdb.Bean;

public abstract interface FriendInfo
  extends Bean
{
  public abstract FriendInfo copy();
  
  public abstract FriendInfo toData();
  
  public abstract FriendInfo toBean();
  
  public abstract FriendInfo toDataIf();
  
  public abstract FriendInfo toBeanIf();
  
  public abstract int getRelationvalue();
  
  public abstract Map<Integer, Integer> getValuelimitmap();
  
  public abstract Map<Integer, Integer> getValuelimitmapAsData();
  
  public abstract Map<Integer, Integer> getValuelimittotalmap();
  
  public abstract Map<Integer, Integer> getValuelimittotalmapAsData();
  
  public abstract long getBefriendtime();
  
  public abstract String getRemarkname();
  
  public abstract Octets getRemarknameOctets();
  
  public abstract void setRelationvalue(int paramInt);
  
  public abstract void setBefriendtime(long paramLong);
  
  public abstract void setRemarkname(String paramString);
  
  public abstract void setRemarknameOctets(Octets paramOctets);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FriendInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */