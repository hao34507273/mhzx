/*    */ package mzm.gsp.csprovider.ssp;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenGameAndSocialSpaceArg;
/*    */ import csprovider.DataBetweenGameAndSocialSpaceRes;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.friendscircle.main.POnSspUpdateOrnamentStyleRsp;
/*    */ import org.apache.log4j.Logger;
/*    */ import org.json.JSONObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSP_UpdateSpaceStyle
/*    */   implements SSPHandler
/*    */ {
/*    */   public void onServer(DataBetweenGameAndSocialSpaceArg arg, DataBetweenGameAndSocialSpaceRes res) {}
/*    */   
/*    */   public void onClient(DataBetweenGameAndSocialSpaceArg arg, DataBetweenGameAndSocialSpaceRes res, SSPContext context)
/*    */   {
/* 22 */     String jsonStr = arg.data.getString("UTF-8");
/* 23 */     JSONObject jsonObject = new JSONObject(jsonStr);
/*    */     
/* 25 */     if (res.retcode == 0)
/*    */     {
/* 27 */       long roleId = jsonObject.getLong("roleId");
/* 28 */       String spaceStyle = jsonObject.getString("spaceStyle");
/*    */       
/* 30 */       JSONObject spaceStyleJson = new JSONObject(spaceStyle);
/* 31 */       int pendantItemCfgId = spaceStyleJson.getInt("pendant");
/* 32 */       int rahmenItemCfgId = spaceStyleJson.getInt("rahmen");
/*    */       
/* 34 */       new POnSspUpdateOrnamentStyleRsp(roleId, pendantItemCfgId, rahmenItemCfgId).call();
/*    */     }
/*    */     else
/*    */     {
/* 38 */       StringBuilder sBuilder = new StringBuilder();
/* 39 */       sBuilder.append("[ssp_friendscircle]SSP_UpdateSpaceStyle.onClient@on client,error");
/* 40 */       sBuilder.append("|context=").append(jsonStr);
/* 41 */       sBuilder.append("|ret_code=").append(res.retcode);
/* 42 */       GameServer.logger().error(sBuilder.toString());
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public void onTimeout(DataBetweenGameAndSocialSpaceArg arg, DataBetweenGameAndSocialSpaceRes res, SSPContext context)
/*    */   {
/* 49 */     String jsonStr = arg.data.getString("UTF-8");
/*    */     
/* 51 */     StringBuilder sBuilder = new StringBuilder();
/* 52 */     sBuilder.append("[ssp_friendscircle]SSP_UpdateSpaceStyle.onTimeout@on timeout,error");
/* 53 */     sBuilder.append("|context=").append(jsonStr);
/* 54 */     sBuilder.append("|res_retcode=").append(res.retcode);
/*    */     
/* 56 */     GameServer.logger().error(sBuilder.toString());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\ssp\SSP_UpdateSpaceStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */