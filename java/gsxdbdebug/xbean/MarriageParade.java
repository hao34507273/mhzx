package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface MarriageParade
  extends Bean
{
  public static final int FIGHT_NOT_EXIST = 0;
  public static final int FIGHTING = 1;
  public static final int FIGHT_MODULE_FIGHT_END = 2;
  public static final int MAP_MODULE_FIGHT_END = 4;
  
  public abstract MarriageParade copy();
  
  public abstract MarriageParade toData();
  
  public abstract MarriageParade toBean();
  
  public abstract MarriageParade toDataIf();
  
  public abstract MarriageParade toBeanIf();
  
  public abstract long getRoleid1();
  
  public abstract long getRoleid2();
  
  public abstract int getLevel();
  
  public abstract Set<Integer> getStoppointseqs();
  
  public abstract Set<Integer> getStoppointseqsAsData();
  
  public abstract Set<Integer> getGivemoneypointseqs();
  
  public abstract Set<Integer> getGivemoneypointseqsAsData();
  
  public abstract Set<Integer> getArriveseqs();
  
  public abstract Set<Integer> getArriveseqsAsData();
  
  public abstract long getTimemil();
  
  public abstract Set<Integer> getRobseqs();
  
  public abstract Set<Integer> getRobseqsAsData();
  
  public abstract boolean getCanrob();
  
  public abstract int getBridefightstatus();
  
  public abstract int getGroomfightstatus();
  
  public abstract void setRoleid1(long paramLong);
  
  public abstract void setRoleid2(long paramLong);
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setTimemil(long paramLong);
  
  public abstract void setCanrob(boolean paramBoolean);
  
  public abstract void setBridefightstatus(int paramInt);
  
  public abstract void setGroomfightstatus(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MarriageParade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */