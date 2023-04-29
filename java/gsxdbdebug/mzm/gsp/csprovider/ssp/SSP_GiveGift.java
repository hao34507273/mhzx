/*     */ package mzm.gsp.csprovider.ssp;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenGameAndSocialSpaceArg;
/*     */ import csprovider.DataBetweenGameAndSocialSpaceRes;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.friendscircle.main.POnSSPRoleNotFound;
/*     */ import mzm.gsp.friendscircle.main.POnSspGiveGiftRsp;
/*     */ import mzm.gsp.friendscircle.main.RRepeatSendSspRpc;
/*     */ import mzm.gsp.friendscircle.main.SSPRepeatTimesContext;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.json.JSONObject;
/*     */ import xdb.Executor;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSP_GiveGift
/*     */   implements SSPHandler
/*     */ {
/*     */   public void onServer(DataBetweenGameAndSocialSpaceArg arg, DataBetweenGameAndSocialSpaceRes res) {}
/*     */   
/*     */   public void onClient(DataBetweenGameAndSocialSpaceArg arg, DataBetweenGameAndSocialSpaceRes res, SSPContext context)
/*     */   {
/*  28 */     String dataStr = arg.data.getString("UTF-8");
/*  29 */     JSONObject jsonObject = new JSONObject(dataStr);
/*     */     
/*  31 */     if ((res.retcode == 0) || (res.retcode == 40072))
/*     */     {
/*     */ 
/*     */ 
/*  35 */       long receiveRoleId = jsonObject.getLong("targetId");
/*  36 */       long giverRoleId = jsonObject.getLong("giverId");
/*  37 */       long serialId = jsonObject.getLong("serialId");
/*  38 */       int giftId = jsonObject.getInt("giftId");
/*  39 */       int giftCount = jsonObject.getInt("giftCount");
/*  40 */       int addPopularityValue = jsonObject.getInt("popularity");
/*     */       
/*  42 */       new POnSspGiveGiftRsp(giverRoleId, receiveRoleId, giftId, giftCount, addPopularityValue, serialId, res.retcode).call();
/*     */     }
/*  44 */     else if (res.retcode == 40036)
/*     */     {
/*     */ 
/*  47 */       long giverRoleId = jsonObject.getLong("giverId");
/*     */       
/*  49 */       long receiveRoleId = jsonObject.getLong("targetId");
/*     */       
/*  51 */       new POnSSPRoleNotFound(giverRoleId, receiveRoleId).execute();
/*     */     }
/*     */     else
/*     */     {
/*  55 */       StringBuilder sBuilder = new StringBuilder();
/*  56 */       sBuilder.append("[ssp_friendscircle]SSP_GiveGift.onClient@on client,error");
/*  57 */       sBuilder.append("|req_context=").append(jsonObject.toString());
/*  58 */       sBuilder.append("|ret_code=").append(res.retcode);
/*  59 */       sBuilder.append("|ret_msg=").append(res.result.getString("UTF-8"));
/*     */       
/*  61 */       if ((context instanceof SSPRepeatTimesContext))
/*     */       {
/*  63 */         SSPRepeatTimesContext sspRepeatTimesContext = (SSPRepeatTimesContext)context;
/*  64 */         sBuilder.append("|repeat_times=").append(sspRepeatTimesContext.repeatTimes);
/*  65 */         sspRepeatTimesContext.repeatTimes += 1;
/*     */         
/*  67 */         if (sspRepeatTimesContext.repeatTimes < 3)
/*     */         {
/*  69 */           Xdb.executor().schedule(new RRepeatSendSspRpc(arg, context), sspRepeatTimesContext.repeatTimes * 20, TimeUnit.SECONDS);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*  74 */       GameServer.logger().error(sBuilder.toString());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void onTimeout(DataBetweenGameAndSocialSpaceArg arg, DataBetweenGameAndSocialSpaceRes res, SSPContext context)
/*     */   {
/*  81 */     String dataStr = arg.data.getString("UTF-8");
/*  82 */     JSONObject jsonObject = new JSONObject(dataStr);
/*     */     
/*  84 */     StringBuilder sBuilder = new StringBuilder();
/*  85 */     sBuilder.append("[ssp_friendscircle]SSP_GiveGift.onTimeout@on time out");
/*  86 */     sBuilder.append("|req_context=").append(jsonObject.toString());
/*  87 */     sBuilder.append("|ret_code=").append(res.retcode);
/*  88 */     sBuilder.append("|ret_msg=").append(res.result.getString("UTF-8"));
/*     */     
/*  90 */     if ((context instanceof SSPRepeatTimesContext))
/*     */     {
/*  92 */       SSPRepeatTimesContext sspRepeatTimesContext = (SSPRepeatTimesContext)context;
/*  93 */       sBuilder.append("|repeat_times=").append(sspRepeatTimesContext.repeatTimes);
/*  94 */       sspRepeatTimesContext.repeatTimes += 1;
/*     */       
/*  96 */       if (sspRepeatTimesContext.repeatTimes < 3)
/*     */       {
/*  98 */         Xdb.executor().schedule(new RRepeatSendSspRpc(arg, context), arg.reserved1 * 20, TimeUnit.SECONDS);
/*     */       }
/*     */     }
/*     */     
/* 102 */     GameServer.logger().error(sBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\ssp\SSP_GiveGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */