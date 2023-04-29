package xbean;

import com.goldhuman.Common.Octets;
import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface ChildInfo
  extends Bean
{
  public static final int NO_ANOTHER_PARENT = -1;
  public static final int NO_ROLE_CARRY = -1;
  public static final int NOT_IN_HOME = 0;
  public static final int IN_ROOM = 1;
  public static final int IN_YARD = 2;
  
  public abstract ChildInfo copy();
  
  public abstract ChildInfo toData();
  
  public abstract ChildInfo toBean();
  
  public abstract ChildInfo toDataIf();
  
  public abstract ChildInfo toBeanIf();
  
  public abstract long getOwn_role_id();
  
  public abstract int getChild_period();
  
  public abstract String getChild_name();
  
  public abstract Octets getChild_nameOctets();
  
  public abstract int getChild_gender();
  
  public abstract long getAnother_parent_role_id();
  
  public abstract BabyPeriodInfo getBaby_period_info();
  
  public abstract ChildhoodInfo getChildhood_info();
  
  public abstract int getHome_state();
  
  public abstract Map<Integer, DressedInfo> getDressed();
  
  public abstract Map<Integer, DressedInfo> getDressedAsData();
  
  public abstract long getCarry_role_id();
  
  public abstract List<AdulthoodInfo> getAdulthood_info();
  
  public abstract List<AdulthoodInfo> getAdulthood_infoAsData();
  
  public abstract int getPosition_x();
  
  public abstract int getPosition_y();
  
  public abstract boolean getIs_discard();
  
  public abstract long getDiscard_time();
  
  public abstract void setOwn_role_id(long paramLong);
  
  public abstract void setChild_period(int paramInt);
  
  public abstract void setChild_name(String paramString);
  
  public abstract void setChild_nameOctets(Octets paramOctets);
  
  public abstract void setChild_gender(int paramInt);
  
  public abstract void setAnother_parent_role_id(long paramLong);
  
  public abstract void setHome_state(int paramInt);
  
  public abstract void setCarry_role_id(long paramLong);
  
  public abstract void setPosition_x(int paramInt);
  
  public abstract void setPosition_y(int paramInt);
  
  public abstract void setIs_discard(boolean paramBoolean);
  
  public abstract void setDiscard_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChildInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */