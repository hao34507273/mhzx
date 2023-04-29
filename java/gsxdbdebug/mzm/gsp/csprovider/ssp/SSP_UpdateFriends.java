/*    */ package mzm.gsp.csprovider.ssp;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenGameAndSocialSpaceArg;
/*    */ import csprovider.DataBetweenGameAndSocialSpaceRes;
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSP_UpdateFriends
/*    */   implements SSPHandler
/*    */ {
/*    */   public void onServer(DataBetweenGameAndSocialSpaceArg arg, DataBetweenGameAndSocialSpaceRes res) {}
/*    */   
/*    */   public void onClient(DataBetweenGameAndSocialSpaceArg arg, DataBetweenGameAndSocialSpaceRes res, SSPContext context)
/*    */   {
/* 19 */     String jsonStr = arg.data.getString("UTF-8");
/* 20 */     if (res.retcode != 0)
/*    */     {
/* 22 */       StringBuilder sBuilder = new StringBuilder();
/* 23 */       sBuilder.append("[ssp_friendscircle]SSP_UpdateFriends.onClient@on client,error");
/* 24 */       sBuilder.append("|context=").append(jsonStr);
/* 25 */       sBuilder.append("|ret_code=").append(res.retcode);
/* 26 */       GameServer.logger().error(sBuilder.toString());
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public void onTimeout(DataBetweenGameAndSocialSpaceArg arg, DataBetweenGameAndSocialSpaceRes res, SSPContext context)
/*    */   {
/* 33 */     String jsonStr = arg.data.getString("UTF-8");
/*    */     
/* 35 */     StringBuilder sBuilder = new StringBuilder();
/* 36 */     sBuilder.append("[ssp_friendscircle]SSP_UpdateFriends.onTimeout@time out,error");
/* 37 */     sBuilder.append("|context=").append(jsonStr);
/* 38 */     sBuilder.append("|ret_code=").append(res.retcode);
/* 39 */     GameServer.logger().error(sBuilder.toString());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\ssp\SSP_UpdateFriends.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */