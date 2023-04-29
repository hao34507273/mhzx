package xbean;

import com.goldhuman.Common.Octets;
import java.util.Map;
import xdb.Bean;

public abstract interface TransferOccupationWing
  extends Bean
{
  public abstract TransferOccupationWing copy();
  
  public abstract TransferOccupationWing toData();
  
  public abstract TransferOccupationWing toBean();
  
  public abstract TransferOccupationWing toDataIf();
  
  public abstract TransferOccupationWing toBeanIf();
  
  public abstract Map<Integer, WingPlan> getWings();
  
  public abstract Map<Integer, WingPlan> getWingsAsData();
  
  public abstract int getCurplan();
  
  public abstract String getPlanname();
  
  public abstract Octets getPlannameOctets();
  
  public abstract void setCurplan(int paramInt);
  
  public abstract void setPlanname(String paramString);
  
  public abstract void setPlannameOctets(Octets paramOctets);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TransferOccupationWing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */