/*     */ package mzm.gsp.bandstand.main;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.bandstand.SEndBandstandFail;
/*     */ import mzm.gsp.bandstand.SEndBandstandSuccess;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2bandstandsessionid;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCEndBandstandReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCEndBandstandReq(long roleId)
/*     */   {
/*  22 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  29 */     if (!OpenInterface.getOpenStatus(548))
/*     */     {
/*  31 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  35 */     String userId = RoleInterface.getUserId(this.roleId);
/*  36 */     if (null == userId)
/*     */     {
/*  38 */       String logstr = String.format("[bandstand]PCEndBandstandReq.processImp@user id not exists!|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  40 */       GameServer.logger().info(logstr);
/*  41 */       return false;
/*     */     }
/*  43 */     Lockeys.lock(Lockeys.get(User.getTable(), userId));
/*  44 */     Lockeys.lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*  47 */     Long sessionId = Role2bandstandsessionid.get(Long.valueOf(this.roleId));
/*  48 */     if (null == sessionId)
/*     */     {
/*  50 */       onFail(1);
/*  51 */       return false;
/*     */     }
/*  53 */     BandstandSession session = (BandstandSession)BandstandSession.getSession(sessionId.longValue());
/*  54 */     int activityId = session.getActivityId();
/*  55 */     int musicCfgId = session.getMusicCfgId();
/*  56 */     int loopCount = session.getLoopCount();
/*     */     
/*     */ 
/*  59 */     BandstandManager.stopBandstand(userId, this.roleId, sessionId.longValue());
/*     */     
/*     */ 
/*  62 */     mzm.gsp.status.main.RoleStatusInterface.unsetStatus(this.roleId, 2081);
/*     */     
/*     */ 
/*  65 */     onSuccess(activityId, musicCfgId, loopCount);
/*     */     
/*  67 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onSuccess(int activityId, int musicCfgId, int loopCount)
/*     */   {
/*  76 */     String logstr = String.format("[bandstand]PCEndBandstandReq.onSuccess@end bandstand success!|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */     
/*  78 */     GameServer.logger().info(logstr);
/*     */     
/*     */ 
/*  81 */     SEndBandstandSuccess proto = new SEndBandstandSuccess();
/*  82 */     OnlineManager.getInstance().send(this.roleId, proto);
/*     */     
/*     */ 
/*  85 */     BandstandManager.addEndBandstandTlog(this.roleId, activityId, musicCfgId, loopCount, BandstandManager.BandstandEndReason.ACTIVE_STOP);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFail(int errorCode)
/*     */   {
/*  96 */     String logstr = String.format("[bandstand]PCEndBandstandReq.onFail@end bandstand fail!|roleId=%d, errorCode=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(errorCode) });
/*     */     
/*     */ 
/*  99 */     GameServer.logger().info(logstr);
/*     */     
/*     */ 
/* 102 */     SEndBandstandFail proto = new SEndBandstandFail();
/* 103 */     proto.error_code = errorCode;
/* 104 */     OnlineManager.getInstance().sendAtOnce(this.roleId, proto);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bandstand\main\PCEndBandstandReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */