/*     */ package mzm.gsp.constellation.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.constellation.SSetSelfConstellationRes;
/*     */ import mzm.gsp.constellation.confbean.SConstellationConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.RoleConstellation;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class PSetSelfConstellationReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int constellation;
/*     */   private final int setTimes;
/*     */   
/*     */   public PSetSelfConstellationReq(long roleid, int constellation, int setTimes)
/*     */   {
/*  26 */     this.roleid = roleid;
/*  27 */     this.constellation = constellation;
/*  28 */     this.setTimes = setTimes;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (!OpenInterface.getOpenStatus(227)) {
/*  35 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  39 */     if (!ActivityInterface.isActivityOpen(SConstellationConsts.getInstance().Activityid)) {
/*  40 */       ConstellationManager.logError("PSetSelfConstellationReq.processImp@activity not open|roleid=%d|constellation=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.constellation) });
/*     */       
/*     */ 
/*  43 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  47 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  49 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  51 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*     */ 
/*  54 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, SConstellationConsts.getInstance().Activityid);
/*     */     
/*  56 */     if (!result.isCanJoin()) {
/*  57 */       ConstellationManager.logError("PSetSelfConstellationReq.processImp@cannot join activity|roleid=%d|constellation=%d|reason=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.constellation), Integer.valueOf(result.getReasonValue()) });
/*     */       
/*     */ 
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     RoleConstellation xRoleConstellation = ConstellationManager.getXRoleConstellationIfNotExist(this.roleid);
/*     */     
/*     */ 
/*     */ 
/*  67 */     if (xRoleConstellation.getSet_times() != this.setTimes) {
/*  68 */       ConstellationManager.logError("PSetSelfConstellationReq.processImp@set_times not match|roleid=%d|constellation=%d|server_times=%d|client_times=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.constellation), Integer.valueOf(xRoleConstellation.getSet_times()), Integer.valueOf(this.setTimes) });
/*     */       
/*     */ 
/*  71 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  75 */     if (xRoleConstellation.getConstellation() == this.constellation) {
/*  76 */       ConstellationManager.logError("PSetSelfConstellationReq.processImp@same constellation|roleid=%d|constellation=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.constellation) });
/*     */       
/*     */ 
/*  79 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  83 */     if (!ConstellationConfigManager.isConstellationValid(this.constellation)) {
/*  84 */       ConstellationManager.logError("PSetSelfConstellationReq.processImp@invalid constellation|roleid=%d|constellation=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.constellation) });
/*     */       
/*     */ 
/*  87 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  91 */     int times = this.setTimes + 1;
/*  92 */     if (times > SConstellationConsts.getInstance().ChangeTimes) {
/*  93 */       ConstellationManager.logError("PSetSelfConstellationReq.processImp@reach max times|roleid=%d|constellation=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.constellation) });
/*     */       
/*     */ 
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     xRoleConstellation.setConstellation(this.constellation);
/* 100 */     xRoleConstellation.setSet_times(times);
/*     */     
/* 102 */     SSetSelfConstellationRes res = new SSetSelfConstellationRes(this.constellation, times);
/* 103 */     OnlineManager.getInstance().send(this.roleid, res);
/*     */     
/* 105 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\constellation\main\PSetSelfConstellationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */