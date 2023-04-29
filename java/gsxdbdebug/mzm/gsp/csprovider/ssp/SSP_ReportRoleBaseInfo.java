/*    */ package mzm.gsp.csprovider.ssp;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenGameAndSocialSpaceArg;
/*    */ import csprovider.DataBetweenGameAndSocialSpaceRes;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.friendscircle.main.POnReportRoleRsp;
/*    */ import mzm.gsp.friendscircle.main.POnSSPRoleNotFound.RoleNotFoundReportRoleContext;
/*    */ import mzm.gsp.friendscircle.main.RRepeatSendSspRpc;
/*    */ import mzm.gsp.friendscircle.main.SSPRepeatTimesContext;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ 
/*    */ public class SSP_ReportRoleBaseInfo
/*    */   implements SSPHandler
/*    */ {
/*    */   public void onServer(DataBetweenGameAndSocialSpaceArg arg, DataBetweenGameAndSocialSpaceRes res) {}
/*    */   
/*    */   public void onClient(DataBetweenGameAndSocialSpaceArg arg, DataBetweenGameAndSocialSpaceRes res, SSPContext context)
/*    */   {
/* 24 */     if (res.retcode != 0)
/*    */     {
/* 26 */       StringBuilder sBuilder = new StringBuilder();
/* 27 */       sBuilder.append("[friendscircle]SSP_ReportRoleBaseInfo.onClient@report role base info error");
/* 28 */       sBuilder.append("|ret_code=").append(res.retcode);
/* 29 */       sBuilder.append("|arg=").append(arg.data.getString("UTF-8"));
/* 30 */       sBuilder.append("|result=").append(res.result.getString("UTF-8"));
/*    */       
/* 32 */       if ((context instanceof SSPRepeatTimesContext))
/*    */       {
/* 34 */         SSPRepeatTimesContext sspRepeatTimesContext = (SSPRepeatTimesContext)context;
/* 35 */         sBuilder.append("|repeat_times=").append(sspRepeatTimesContext.repeatTimes);
/* 36 */         sspRepeatTimesContext.repeatTimes += 1;
/*    */         
/* 38 */         if (sspRepeatTimesContext.repeatTimes < 3)
/*    */         {
/* 40 */           Xdb.executor().schedule(new RRepeatSendSspRpc(arg, context), sspRepeatTimesContext.repeatTimes * 20, TimeUnit.SECONDS);
/*    */         }
/*    */       }
/*    */       
/* 44 */       GameServer.logger().error(sBuilder.toString());
/*    */     }
/*    */     
/* 47 */     if (((context instanceof POnSSPRoleNotFound.RoleNotFoundReportRoleContext)) && (res.retcode == 0))
/*    */     {
/* 49 */       POnSSPRoleNotFound.RoleNotFoundReportRoleContext roleNotFoundReportRoleContext = (POnSSPRoleNotFound.RoleNotFoundReportRoleContext)context;
/*    */       
/*    */ 
/* 52 */       new POnReportRoleRsp(roleNotFoundReportRoleContext.passiveRoleId).execute();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onTimeout(DataBetweenGameAndSocialSpaceArg arg, DataBetweenGameAndSocialSpaceRes res, SSPContext context)
/*    */   {
/* 60 */     StringBuilder sBuilder = new StringBuilder();
/* 61 */     sBuilder.append("[friendscircle]SSP_ReportRoleBaseInfo.onTimeout@report role base info time out");
/* 62 */     sBuilder.append("|ret_code=").append(res.retcode);
/* 63 */     sBuilder.append("|arg=").append(arg.data.getString("UTF-8"));
/* 64 */     sBuilder.append("|result=").append(res.result.getString("UTF-8"));
/*    */     
/* 66 */     if ((context instanceof SSPRepeatTimesContext))
/*    */     {
/* 68 */       SSPRepeatTimesContext sspRepeatTimesContext = (SSPRepeatTimesContext)context;
/* 69 */       sBuilder.append("|repeat_times=").append(sspRepeatTimesContext.repeatTimes);
/* 70 */       sspRepeatTimesContext.repeatTimes += 1;
/*    */       
/* 72 */       if (sspRepeatTimesContext.repeatTimes < 3)
/*    */       {
/* 74 */         Xdb.executor().schedule(new RRepeatSendSspRpc(arg, context), sspRepeatTimesContext.repeatTimes * 20, TimeUnit.SECONDS);
/*    */       }
/*    */     }
/*    */     
/* 78 */     GameServer.logger().error(sBuilder.toString());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\ssp\SSP_ReportRoleBaseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */