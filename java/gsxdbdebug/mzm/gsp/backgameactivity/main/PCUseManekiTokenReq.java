/*     */ package mzm.gsp.backgameactivity.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity3.confbean.SBackGameActivityManekiTokenCfg;
/*     */ import mzm.gsp.backgameactivity.SUseManekiTokenError;
/*     */ import mzm.gsp.backgameactivity.SUseManekiTokenRsp;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.PresentResult;
/*     */ import mzm.gsp.qingfu.main.PresentType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.BackGameActivityRechargeInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCUseManekiTokenReq extends LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int activityId;
/*     */   final int manekiTokenCfgId;
/*     */   
/*     */   public PCUseManekiTokenReq(long roleId, int activityId, int manekiTokenCfgId)
/*     */   {
/*  30 */     this.roleId = roleId;
/*  31 */     this.activityId = activityId;
/*  32 */     this.manekiTokenCfgId = manekiTokenCfgId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if ((this.activityId <= 0) || (this.manekiTokenCfgId <= 0))
/*     */     {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     if (!OpenInterface.getOpenStatus(419))
/*     */     {
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     if (!OpenInterface.getOpenStatus(521))
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1677, true))
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     SBackGameActivityManekiTokenCfg backGameActivityManekiTokenCfg = SBackGameActivityManekiTokenCfg.get(this.manekiTokenCfgId);
/*     */     
/*  60 */     if (backGameActivityManekiTokenCfg == null)
/*     */     {
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     String userId = RoleInterface.getUserId(this.roleId);
/*  66 */     lock(Lockeys.get(User.getTable(), userId));
/*  67 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*  70 */     boolean ret = BackGameActivityManager.isRoleInBackGameActivity(this.roleId, this.activityId);
/*  71 */     if (!ret)
/*     */     {
/*  73 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  77 */     BackGameActivityRechargeInfo xBackGameActivityRechargeInfo = BackGameActivityManager.getBackGameActivityRechargeInfo(userId, this.activityId);
/*     */     
/*  79 */     if (xBackGameActivityRechargeInfo == null)
/*     */     {
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     Map<Integer, Integer> xManekiTokenCfgId2countMap = xBackGameActivityRechargeInfo.getManekitokencfgid2count();
/*  85 */     if (!xManekiTokenCfgId2countMap.containsKey(Integer.valueOf(this.manekiTokenCfgId)))
/*     */     {
/*  87 */       return false;
/*     */     }
/*  89 */     int manekiTokenCount = ((Integer)xManekiTokenCfgId2countMap.get(Integer.valueOf(this.manekiTokenCfgId))).intValue();
/*  90 */     if (manekiTokenCount <= 0)
/*     */     {
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     Map<Integer, Integer> tLog_manekiTokenCfgId2count = new HashMap();
/*  96 */     tLog_manekiTokenCfgId2count.putAll(xManekiTokenCfgId2countMap);
/*     */     
/*  98 */     SUseManekiTokenError useManekiTokenError = new SUseManekiTokenError();
/*  99 */     useManekiTokenError.activityid = this.activityId;
/* 100 */     useManekiTokenError.manekitokencfgid = this.manekiTokenCfgId;
/*     */     
/* 102 */     PresentResult presentResult = QingfuInterface.presentYuanbao(userId, this.roleId, backGameActivityManekiTokenCfg.getYuanBaoCount, PresentType.PRESENT_BIND_BACK_GAME_ACTIVITY_USE_MANEKI_TOKEN, new TLogArg(LogReason.BACK_GAME_ACTIVITY_USE_MANEKI_TOKEN, this.manekiTokenCfgId));
/*     */     
/*     */ 
/* 105 */     if (presentResult != PresentResult.Success)
/*     */     {
/* 107 */       useManekiTokenError.errorcode = 1;
/* 108 */       OnlineManager.getInstance().sendAtOnce(this.roleId, useManekiTokenError);
/* 109 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 113 */     xManekiTokenCfgId2countMap.put(Integer.valueOf(this.manekiTokenCfgId), Integer.valueOf(manekiTokenCount - 1));
/*     */     
/* 115 */     SUseManekiTokenRsp useManekiTokenRsp = new SUseManekiTokenRsp();
/* 116 */     useManekiTokenRsp.activityid = this.activityId;
/* 117 */     useManekiTokenRsp.manekitokencfgid = this.manekiTokenCfgId;
/* 118 */     OnlineManager.getInstance().send(this.roleId, useManekiTokenRsp);
/*     */     
/*     */ 
/* 121 */     BackGameActivityTlogManager.addBackGameActivityUseManekiTokenTLog(this.roleId, this.activityId, tLog_manekiTokenCfgId2count, xManekiTokenCfgId2countMap);
/*     */     
/*     */ 
/* 124 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\main\PCUseManekiTokenReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */