/*     */ package mzm.gsp.mondayfree.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.common.confbean.STimeDurationCommonCfg;
/*     */ import mzm.gsp.mondayfree.SFinishShimenRes;
/*     */ import mzm.gsp.mondayfree.confbean.SMondayFreeConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.shimen.main.ShimenInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.MondayFree;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PFinishShimenReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PFinishShimenReq(long roleid)
/*     */   {
/*  29 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     if (!OpenInterface.getOpenStatus(529)) {
/*  36 */       MondayFreeManager.sendNormalResult(this.roleid, 1);
/*  37 */       MondayFreeManager.logError("PFinishShimenReq.processImp@not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  39 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  43 */     int serverLevel = ServerInterface.getCurrentServerLevel();
/*  44 */     if (serverLevel < SMondayFreeConsts.getInstance().NeedServerLevel) {
/*  45 */       MondayFreeManager.logError("PFinishShimenReq.processImp@server level invalid|roleid=%d|server_level=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(serverLevel) });
/*     */       
/*     */ 
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  52 */     int durationCfgid = SMondayFreeConsts.getInstance().MondayTimeDurationCfgid;
/*  53 */     STimeDurationCommonCfg timeDurationCfg = TimeCommonUtil.getTimeDurationCfg(durationCfgid);
/*  54 */     if (timeDurationCfg == null) {
/*  55 */       MondayFreeManager.logError("PFinishShimenReq.processImp@time duration config null|roleid=%d|cfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(durationCfgid) });
/*     */       
/*     */ 
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     long startTime = TimeCommonUtil.getBeforeStartTime(now, timeDurationCfg);
/*  62 */     long durationMillis = TimeCommonUtil.getDurationMillis(timeDurationCfg);
/*     */     
/*  64 */     long endTime = startTime + durationMillis;
/*     */     
/*     */ 
/*  67 */     if (now > endTime) {
/*  68 */       MondayFreeManager.sendNormalResult(this.roleid, 31);
/*     */       
/*  70 */       MondayFreeManager.logError("PFinishShimenReq.processImp@time invalid|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  72 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  76 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  78 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  80 */     MondayFree xMondayFree = MondayFreeManager.createXMondayFreeIfNotExist(this.roleid);
/*     */     
/*  82 */     if (xMondayFree.getFinish_shimen_time() >= startTime) {
/*  83 */       MondayFreeManager.sendNormalResult(this.roleid, 32);
/*     */       
/*  85 */       MondayFreeManager.logError("PFinishShimenReq.processImp@already finish shimen|roleid=%d|award_time=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(xMondayFree.getMonday_award_time()) });
/*     */       
/*     */ 
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     if (!ShimenInterface.autoFinishShiMen(userid, this.roleid)) {
/*  92 */       MondayFreeManager.sendNormalResult(this.roleid, 43);
/*     */       
/*  94 */       MondayFreeManager.logError("PFinishShimenReq.processImp@finish shimen failed|roleid=%d|award_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(SMondayFreeConsts.getInstance().MondayAward) });
/*     */       
/*     */ 
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     xMondayFree.setFinish_shimen_time(now);
/*     */     
/* 102 */     SFinishShimenRes res = new SFinishShimenRes();
/* 103 */     OnlineManager.getInstance().send(this.roleid, res);
/*     */     
/* 105 */     MondayFreeManager.logInfo("PFinishShimenReq.processImp@succeed|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */     
/* 107 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mondayfree\main\PFinishShimenReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */