package mzm.gsp.csprovider.gmt;

import csprovider.DataBetweenCspAndGame_Re;
import org.json.JSONObject;

public abstract interface GmtHandler
{
  public abstract void handle(JSONObject paramJSONObject, DataBetweenCspAndGame_Re paramDataBetweenCspAndGame_Re)
    throws Exception;
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\GmtHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */