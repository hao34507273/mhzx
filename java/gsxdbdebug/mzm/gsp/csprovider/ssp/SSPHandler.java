package mzm.gsp.csprovider.ssp;

import csprovider.DataBetweenGameAndSocialSpaceArg;
import csprovider.DataBetweenGameAndSocialSpaceRes;

public abstract interface SSPHandler
{
  public abstract void onServer(DataBetweenGameAndSocialSpaceArg paramDataBetweenGameAndSocialSpaceArg, DataBetweenGameAndSocialSpaceRes paramDataBetweenGameAndSocialSpaceRes);
  
  public abstract void onClient(DataBetweenGameAndSocialSpaceArg paramDataBetweenGameAndSocialSpaceArg, DataBetweenGameAndSocialSpaceRes paramDataBetweenGameAndSocialSpaceRes, SSPContext paramSSPContext);
  
  public abstract void onTimeout(DataBetweenGameAndSocialSpaceArg paramDataBetweenGameAndSocialSpaceArg, DataBetweenGameAndSocialSpaceRes paramDataBetweenGameAndSocialSpaceRes, SSPContext paramSSPContext);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\ssp\SSPHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */