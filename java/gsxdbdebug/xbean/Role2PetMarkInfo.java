package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Role2PetMarkInfo
  extends Bean
{
  public abstract Role2PetMarkInfo copy();
  
  public abstract Role2PetMarkInfo toData();
  
  public abstract Role2PetMarkInfo toBean();
  
  public abstract Role2PetMarkInfo toDataIf();
  
  public abstract Role2PetMarkInfo toBeanIf();
  
  public abstract long getNext_pet_mark_id();
  
  public abstract Map<Long, PetMarkInfo> getPetmarkid2info();
  
  public abstract Map<Long, PetMarkInfo> getPetmarkid2infoAsData();
  
  public abstract Map<Long, Long> getPetid2petmarkid();
  
  public abstract Map<Long, Long> getPetid2petmarkidAsData();
  
  public abstract void setNext_pet_mark_id(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2PetMarkInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */