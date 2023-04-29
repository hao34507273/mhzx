/*    */ package mzm.gsp.csprovider.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import gnet.GDeliveryManager;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import org.json.JSONException;
/*    */ import org.json.JSONObject;
/*    */ 
/*    */ public abstract class CspReqBaseProcedure extends LogicProcedure
/*    */ {
/*    */   DataBetweenCspAndGame dataReq;
/*    */   static final String ENCODING = "UTF-8";
/*    */   
/*    */   public CspReqBaseProcedure(DataBetweenCspAndGame dataReq)
/*    */   {
/* 21 */     this.dataReq = dataReq;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     String jsonText = this.dataReq.reqdata.getString("UTF-8");
/* 28 */     JSONObject jso = null;
/* 29 */     DataBetweenCspAndGame_Re rep = new DataBetweenCspAndGame_Re();
/* 30 */     rep.xid = this.dataReq.xid;
/* 31 */     rep.flag = this.dataReq.flag;
/* 32 */     rep.serverid = GameServerInfoManager.getZoneId();
/*    */     try
/*    */     {
/* 35 */       jso = new JSONObject(jsonText);
/* 36 */       int retcode = doProcess(jso, rep);
/* 37 */       rep.retcode = retcode;
/* 38 */       return retcode == Retcode.SUCCESS.value;
/*    */     }
/*    */     catch (JSONException e)
/*    */     {
/* 42 */       rep.retcode = Retcode.JSON_PARSE_ERROR.value;
/* 43 */       GameServer.logger().error("[gmt]CspReqBaseProcedure.processImp@pasre json error", e);
/* 44 */       return false;
/*    */     }
/*    */     catch (Exception e) {
/*    */       boolean bool;
/* 48 */       rep.retcode = Retcode.COMMON_ERR.value;
/* 49 */       GameServer.logger().error("[gmt]CspReqBaseProcedure.processImp@common unknown error", e);
/* 50 */       return false;
/*    */     }
/*    */     finally
/*    */     {
/* 54 */       GDeliveryManager.getInstance().send(rep);
/*    */     }
/*    */   }
/*    */   
/*    */   protected abstract int doProcess(JSONObject paramJSONObject, DataBetweenCspAndGame_Re paramDataBetweenCspAndGame_Re) throws Exception;
/*    */   
/*    */   String getJsonTextString()
/*    */   {
/* 62 */     String jsonText = this.dataReq.reqdata.getString("UTF-8");
/* 63 */     if (jsonText == null)
/*    */     {
/* 65 */       return "";
/*    */     }
/*    */     
/*    */ 
/* 69 */     return jsonText;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   int getQtype()
/*    */   {
/* 76 */     return this.dataReq.qtype;
/*    */   }
/*    */   
/*    */   long getTargetRoleId(JSONObject jso)
/*    */   {
/* 81 */     Long cid = Long.valueOf(jso.getLong("roleid"));
/* 82 */     if (cid != null)
/*    */     {
/* 84 */       return cid.longValue();
/*    */     }
/*    */     
/*    */ 
/* 88 */     return -1L;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\main\CspReqBaseProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */