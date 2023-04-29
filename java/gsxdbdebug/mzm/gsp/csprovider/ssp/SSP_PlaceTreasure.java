/*    */ package mzm.gsp.csprovider.ssp;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenGameAndSocialSpaceArg;
/*    */ import csprovider.DataBetweenGameAndSocialSpaceRes;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.friendscircle.main.POnSspPlaceTreasureBoxRsp;
/*    */ import mzm.gsp.friendscircle.main.RRepeatSendSspRpc;
/*    */ import mzm.gsp.friendscircle.main.SSPRepeatTimesContext;
/*    */ import org.apache.log4j.Logger;
/*    */ import org.json.JSONObject;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSP_PlaceTreasure
/*    */   implements SSPHandler
/*    */ {
/*    */   public void onServer(DataBetweenGameAndSocialSpaceArg arg, DataBetweenGameAndSocialSpaceRes res) {}
/*    */   
/*    */   public void onClient(DataBetweenGameAndSocialSpaceArg arg, DataBetweenGameAndSocialSpaceRes res, SSPContext context)
/*    */   {
/* 27 */     String dataStr = arg.data.getString("UTF-8");
/*    */     
/* 29 */     if ((res.retcode == 0) || (res.retcode == 40072))
/*    */     {
/*    */ 
/*    */ 
/* 33 */       JSONObject jsonObject = new JSONObject(dataStr);
/* 34 */       long ownerRoleId = jsonObject.getLong("ownerId");
/* 35 */       long serialId = jsonObject.getLong("serialId");
/*    */       
/* 37 */       int placeTreasureCount = jsonObject.getInt("count");
/*    */       
/*    */ 
/* 40 */       Role.addRoleProcedure(ownerRoleId, new POnSspPlaceTreasureBoxRsp(ownerRoleId, serialId, placeTreasureCount, res.retcode));
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 45 */       StringBuilder sBuilder = new StringBuilder();
/* 46 */       sBuilder.append("[ssp_friendscircle]SSP_PlaceTreasure.onClient@on client,error");
/* 47 */       sBuilder.append("|req_context=").append(dataStr);
/* 48 */       sBuilder.append("|ret_code=").append(res.retcode);
/* 49 */       sBuilder.append("|ret_msg=").append(res.result.getString("UTF-8"));
/*    */       
/* 51 */       if ((context instanceof SSPRepeatTimesContext))
/*    */       {
/* 53 */         SSPRepeatTimesContext sspRepeatTimesContext = (SSPRepeatTimesContext)context;
/* 54 */         sBuilder.append("|repeat_times=").append(sspRepeatTimesContext.repeatTimes);
/* 55 */         sspRepeatTimesContext.repeatTimes += 1;
/*    */         
/* 57 */         if (sspRepeatTimesContext.repeatTimes < 3)
/*    */         {
/* 59 */           Xdb.executor().schedule(new RRepeatSendSspRpc(arg, context), sspRepeatTimesContext.repeatTimes * 20, TimeUnit.SECONDS);
/*    */         }
/*    */       }
/*    */       
/* 63 */       GameServer.logger().error(sBuilder.toString());
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public void onTimeout(DataBetweenGameAndSocialSpaceArg arg, DataBetweenGameAndSocialSpaceRes res, SSPContext context)
/*    */   {
/* 70 */     String dataStr = arg.data.getString("UTF-8");
/*    */     
/* 72 */     StringBuilder sBuilder = new StringBuilder();
/* 73 */     sBuilder.append("[ssp_friendscircle]SSP_PlaceTreasure.onTimeout@on time out");
/* 74 */     sBuilder.append("|req_context=").append(dataStr);
/* 75 */     sBuilder.append("|ret_code=").append(res.retcode);
/* 76 */     sBuilder.append("|ret_msg=").append(res.result.getString("UTF-8"));
/*    */     
/* 78 */     GameServer.logger().error(sBuilder.toString());
/*    */     
/* 80 */     if ((context instanceof SSPRepeatTimesContext))
/*    */     {
/* 82 */       SSPRepeatTimesContext sspRepeatTimesContext = (SSPRepeatTimesContext)context;
/* 83 */       sBuilder.append("|repeat_times=").append(sspRepeatTimesContext.repeatTimes);
/* 84 */       sspRepeatTimesContext.repeatTimes += 1;
/*    */       
/* 86 */       if (sspRepeatTimesContext.repeatTimes < 3)
/*    */       {
/* 88 */         Xdb.executor().schedule(new RRepeatSendSspRpc(arg, context), sspRepeatTimesContext.repeatTimes * 20, TimeUnit.SECONDS);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\ssp\SSP_PlaceTreasure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */