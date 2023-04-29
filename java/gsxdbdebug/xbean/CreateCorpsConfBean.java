package xbean;

import com.goldhuman.Common.Octets;
import java.util.List;
import xdb.Bean;

public abstract interface CreateCorpsConfBean
  extends Bean
{
  public abstract CreateCorpsConfBean copy();
  
  public abstract CreateCorpsConfBean toData();
  
  public abstract CreateCorpsConfBean toBean();
  
  public abstract CreateCorpsConfBean toDataIf();
  
  public abstract CreateCorpsConfBean toBeanIf();
  
  public abstract List<Long> getAllroles();
  
  public abstract List<Long> getAllrolesAsData();
  
  public abstract List<Long> getAcceptroles();
  
  public abstract List<Long> getAcceptrolesAsData();
  
  public abstract long getSessionid();
  
  public abstract Octets getCorpsname();
  
  public abstract Octets getCorpsdeclaration();
  
  public abstract int getCorpsbadge();
  
  public abstract void setSessionid(long paramLong);
  
  public abstract void setCorpsname(Octets paramOctets);
  
  public abstract void setCorpsdeclaration(Octets paramOctets);
  
  public abstract void setCorpsbadge(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CreateCorpsConfBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */