/*     */ package mzm.gsp.mondayfree.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.common.confbean.STimeDurationCommonCfg;
/*     */ import mzm.gsp.mondayfree.SGetSundayAwardRes;
/*     */ import mzm.gsp.mondayfree.confbean.SMondayFreeConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.MondayFree;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PGetSundayAwardReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PGetSundayAwardReq(long roleid)
/*     */   {
/*  32 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!OpenInterface.getOpenStatus(529)) {
/*  39 */       MondayFreeManager.sendNormalResult(this.roleid, 1);
/*  40 */       MondayFreeManager.logError("PGetSundayAwardReq.processImp@not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  42 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  46 */     int serverLevel = ServerInterface.getCurrentServerLevel();
/*  47 */     if (serverLevel < SMondayFreeConsts.getInstance().NeedServerLevel) {
/*  48 */       MondayFreeManager.logError("PGetSundayAwardReq.processImp@server level invalid|roleid=%d|server_level=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(serverLevel) });
/*     */       
/*     */ 
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  55 */     int durationCfgid = SMondayFreeConsts.getInstance().SundayTimeDurationCfgid;
/*  56 */     STimeDurationCommonCfg timeDurationCfg = TimeCommonUtil.getTimeDurationCfg(durationCfgid);
/*  57 */     if (timeDurationCfg == null) {
/*  58 */       MondayFreeManager.logError("PGetSundayAwardReq.processImp@time duration config null|roleid=%d|cfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(durationCfgid) });
/*     */       
/*     */ 
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     long startTime = TimeCommonUtil.getBeforeStartTime(now, timeDurationCfg);
/*  65 */     long durationMillis = TimeCommonUtil.getDurationMillis(timeDurationCfg);
/*     */     
/*  67 */     long endTime = startTime + durationMillis;
/*     */     
/*     */ 
/*  70 */     if (now > endTime) {
/*  71 */       MondayFreeManager.sendNormalResult(this.roleid, 11);
/*     */       
/*  73 */       MondayFreeManager.logError("PGetSundayAwardReq.processImp@time invalid|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  75 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  79 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  81 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  83 */     MondayFree xMondayFree = MondayFreeManager.createXMondayFreeIfNotExist(this.roleid);
/*     */     
/*  85 */     if (xMondayFree.getSunday_award_time() >= startTime) {
/*  86 */       MondayFreeManager.sendNormalResult(this.roleid, 12);
/*     */       
/*  88 */       MondayFreeManager.logError("PGetSundayAwardReq.processImp@already get award|roleid=%d|award_time=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(xMondayFree.getSunday_award_time()) });
/*     */       
/*     */ 
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     AwardReason awardReason = new AwardReason(LogReason.MONDAY_FREE_SUNDAY_AWARD);
/*  95 */     AwardModel awardModel = AwardInterface.awardFixAward(SMondayFreeConsts.getInstance().SundayAward, userid, this.roleid, true, true, awardReason);
/*     */     
/*  97 */     if (awardModel == null) {
/*  98 */       MondayFreeManager.logError("PGetSundayAwardReq.processImp@award null|roleid=%d|award_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(SMondayFreeConsts.getInstance().SundayAward) });
/*     */       
/*     */ 
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     xMondayFree.setSunday_award_time(now);
/*     */     
/* 106 */     SGetSundayAwardRes res = new SGetSundayAwardRes();
/* 107 */     OnlineManager.getInstance().send(this.roleid, res);
/*     */     
/* 109 */     MondayFreeManager.logInfo("PGetSundayAwardReq.processImp@succeed|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */     
/* 111 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mondayfree\main\PGetSundayAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */