package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface PartnerBag
  extends Bean
{
  public static final int LINEUP_A = 0;
  public static final int LINEUP_B = 1;
  public static final int LINEUP_C = 2;
  
  public abstract PartnerBag copy();
  
  public abstract PartnerBag toData();
  
  public abstract PartnerBag toBean();
  
  public abstract PartnerBag toDataIf();
  
  public abstract PartnerBag toBeanIf();
  
  public abstract int getDefaultlineupnum();
  
  public abstract List<Integer> getOwnpartnerids();
  
  public abstract List<Integer> getOwnpartneridsAsData();
  
  public abstract Map<Integer, LineUp> getLineups();
  
  public abstract Map<Integer, LineUp> getLineupsAsData();
  
  public abstract Map<Integer, Property> getPartner2property();
  
  public abstract Map<Integer, Property> getPartner2propertyAsData();
  
  public abstract void setDefaultlineupnum(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PartnerBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */