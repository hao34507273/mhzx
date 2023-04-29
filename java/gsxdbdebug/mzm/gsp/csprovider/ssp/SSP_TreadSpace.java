/*    */ package mzm.gsp.csprovider.ssp;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenGameAndSocialSpaceArg;
/*    */ import csprovider.DataBetweenGameAndSocialSpaceRes;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.friendscircle.main.POnSSPRoleNotFound;
/*    */ import mzm.gsp.friendscircle.main.POnSspTreadFriendsCircleRsp;
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
/*    */ public class SSP_TreadSpace
/*    */   implements SSPHandler
/*    */ {
/*    */   public void onServer(DataBetweenGameAndSocialSpaceArg arg, DataBetweenGameAndSocialSpaceRes res) {}
/*    */   
/*    */   public void onClient(DataBetweenGameAndSocialSpaceArg arg, DataBetweenGameAndSocialSpaceRes res, SSPContext context)
/*    */   {
/* 27 */     String dataStr = arg.data.getString("UTF-8");
/* 28 */     JSONObject jsonObject = new JSONObject(dataStr);
/*    */     
/* 30 */     if ((res.retcode == 0) || (res.retcode == 40072))
/*    */     {
/*    */ 
/*    */ 
/* 34 */       long stepperRoleIdId = jsonObject.getLong("stepperId");
/* 35 */       long serialId = jsonObject.getLong("serialId");
/*    */       
/* 37 */       long beTrodRoleId = jsonObject.getLong("ownerId");
/*    */       
/* 39 */       new POnSspTreadFriendsCircleRsp(beTrodRoleId, stepperRoleIdId, serialId, res.retcode).call();
/*    */     }
/* 41 */     else if (res.retcode == 40036)
/*    */     {
/*    */ 
/* 44 */       long stepperRoleIdId = jsonObject.getLong("stepperId");
/*    */       
/*    */ 
/* 47 */       long beTrodRoleId = jsonObject.getLong("ownerId");
/*    */       
/* 49 */       new POnSSPRoleNotFound(stepperRoleIdId, beTrodRoleId).execute();
/*    */     }
/*    */     else
/*    */     {
/* 53 */       StringBuilder sBuilder = new StringBuilder();
/* 54 */       sBuilder.append("[ssp_friendscircle]SSP_TreadSpace.onClient@on client,error");
/* 55 */       sBuilder.append("|req_context=").append(dataStr);
/* 56 */       sBuilder.append("|ret_code=").append(res.retcode);
/* 57 */       sBuilder.append("|ret_msg=").append(res.result.getString("UTF-8"));
/*    */       
/* 59 */       if ((context instanceof SSPRepeatTimesContext))
/*    */       {
/* 61 */         SSPRepeatTimesContext sspRepeatTimesContext = (SSPRepeatTimesContext)context;
/* 62 */         sBuilder.append("|repeat_times=").append(sspRepeatTimesContext.repeatTimes);
/* 63 */         sspRepeatTimesContext.repeatTimes += 1;
/*    */         
/* 65 */         if (sspRepeatTimesContext.repeatTimes < 3)
/*    */         {
/* 67 */           Xdb.executor().schedule(new RRepeatSendSspRpc(arg, context), sspRepeatTimesContext.repeatTimes * 20, TimeUnit.SECONDS);
/*    */         }
/*    */       }
/*    */       
/* 71 */       GameServer.logger().error(sBuilder.toString());
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public void onTimeout(DataBetweenGameAndSocialSpaceArg arg, DataBetweenGameAndSocialSpaceRes res, SSPContext context)
/*    */   {
/* 78 */     String dataStr = arg.data.getString("UTF-8");
/*    */     
/* 80 */     StringBuilder sBuilder = new StringBuilder();
/* 81 */     sBuilder.append("[ssp_friendscircle]SSP_TreadSpace.onTimeout@on time out");
/* 82 */     sBuilder.append("|req_context=").append(dataStr);
/* 83 */     sBuilder.append("|ret_code=").append(res.retcode);
/* 84 */     sBuilder.append("|ret_msg=").append(res.result.getString("UTF-8"));
/* 85 */     sBuilder.append("|repeat_times=").append(arg.reserved1);
/*    */     
/* 87 */     if ((context instanceof SSPRepeatTimesContext))
/*    */     {
/* 89 */       SSPRepeatTimesContext sspRepeatTimesContext = (SSPRepeatTimesContext)context;
/* 90 */       sBuilder.append("|repeat_times=").append(sspRepeatTimesContext.repeatTimes);
/* 91 */       sspRepeatTimesContext.repeatTimes += 1;
/*    */       
/* 93 */       if (sspRepeatTimesContext.repeatTimes < 3)
/*    */       {
/* 95 */         Xdb.executor().schedule(new RRepeatSendSspRpc(arg, context), sspRepeatTimesContext.repeatTimes * 20, TimeUnit.SECONDS);
/*    */       }
/*    */     }
/*    */     
/* 99 */     GameServer.logger().error(sBuilder.toString());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\ssp\SSP_TreadSpace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */