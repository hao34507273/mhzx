package xbean;

import com.goldhuman.Common.Marshal.Marshal;
import java.util.List;
import xdb.Bean;

public abstract interface FightRecordInfo
  extends Bean
{
  public abstract FightRecordInfo copy();
  
  public abstract FightRecordInfo toData();
  
  public abstract FightRecordInfo toBean();
  
  public abstract FightRecordInfo toDataIf();
  
  public abstract FightRecordInfo toBeanIf();
  
  public abstract int getVersion();
  
  public abstract <T extends Marshal> T getEnter_fight(T paramT);
  
  public abstract boolean isEnter_fightEmpty();
  
  public abstract byte[] getEnter_fightCopy();
  
  public abstract List<byte[]> getRounds();
  
  public abstract List<byte[]> getRoundsAsData();
  
  public abstract <T extends Marshal> T getFight_end(T paramT);
  
  public abstract boolean isFight_endEmpty();
  
  public abstract byte[] getFight_endCopy();
  
  public abstract void setVersion(int paramInt);
  
  public abstract void setEnter_fight(Marshal paramMarshal);
  
  public abstract void setEnter_fightCopy(byte[] paramArrayOfByte);
  
  public abstract void setFight_end(Marshal paramMarshal);
  
  public abstract void setFight_endCopy(byte[] paramArrayOfByte);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FightRecordInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */