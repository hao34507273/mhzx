/*     */ package mzm.gsp.storageexp.activity;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.award.SSynSingleLostExpInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.AllLostExpInfo;
/*     */ import xbean.LostExpInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2alllostexpinfo;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCGetLostExpReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityId;
/*  27 */   private int stage = -1;
/*     */   
/*     */   public PCGetLostExpReq(long roleId, int activityId)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.activityId = activityId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!isActivityValid())
/*     */     {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     String userid = RoleInterface.getUserId(this.roleId);
/*  44 */     Lockeys.lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  46 */     AllLostExpInfo xAllLostExpInfo = Role2alllostexpinfo.get(Long.valueOf(this.roleId));
/*  47 */     LostExpInfo xLostExpInfo = getActivityXData(xAllLostExpInfo);
/*  48 */     if (xLostExpInfo == null)
/*     */     {
/*  50 */       LostAwardManager.logError("[lostexp]PCGetLostExpReq.processImp@ xLostExpInfo is null!|roleId=%d|activityId=%d|stage=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.stage) });
/*     */       
/*     */ 
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     LostAwardManager.checkAndInit(userid, this.roleId, xAllLostExpInfo, false);
/*     */     
/*  58 */     if (!canGainExp(xLostExpInfo))
/*     */     {
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     int returnValue = LostAwardManager.getCanGetExp(this.roleId, this.activityId, xLostExpInfo);
/*  64 */     if (returnValue <= 0)
/*     */     {
/*  66 */       LostAwardManager.logError("[lostexp]PCGetLostExpReq.processImp@ have no more exp!|roleId=%d|activityId=%d|stage=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.stage) });
/*     */       
/*     */ 
/*  69 */       return false;
/*     */     }
/*  71 */     RoleInterface.addExp(userid, this.roleId, returnValue, new TLogArg(LogReason.AWARD_LOST_STORAGE_EXP, this.activityId));
/*     */     
/*  73 */     addXGainCollectExp(xLostExpInfo, returnValue);
/*     */     
/*  75 */     synSingleActivityInfo(xLostExpInfo);
/*     */     
/*     */ 
/*  78 */     LostAwardManager.logInfo("[lostexp]PCGetLostExpReq.processImp@ active get lost exp!|roleId=%d|activityId=%d|returnValue=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(returnValue) });
/*     */     
/*     */ 
/*  81 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addXGainCollectExp(LostExpInfo xLostExpInfo, int returnValue)
/*     */   {
/*  92 */     int gainCollectExp = xLostExpInfo.getGaincollectexp();
/*  93 */     xLostExpInfo.setGaincollectexp(gainCollectExp + returnValue);
/*  94 */     xLostExpInfo.setAlreadygainlostexp(true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void synSingleActivityInfo(LostExpInfo xLostExpInfo)
/*     */   {
/* 104 */     SSynSingleLostExpInfo p = new SSynSingleLostExpInfo();
/* 105 */     p.activityid = this.activityId;
/* 106 */     LostAwardManager.fillSIngleLostInfo(this.roleId, this.activityId, xLostExpInfo, p.lostexpinfo);
/* 107 */     OnlineManager.getInstance().send(this.roleId, p);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private LostExpInfo getActivityXData(AllLostExpInfo xAllLostExpInfo)
/*     */   {
/* 118 */     if (xAllLostExpInfo == null)
/*     */     {
/* 120 */       LostAwardManager.logError("[lostexp]PCGetLostExpReq.getActivityXData@ role xdb data is null!|roleId=%d|activityId=%d|stage=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.stage) });
/*     */       
/*     */ 
/* 123 */       return null;
/*     */     }
/* 125 */     Map<Integer, LostExpInfo> xActivityLostInfos = xAllLostExpInfo.getActivityid2lostexpinfo();
/* 126 */     if ((xAllLostExpInfo == null) || (xActivityLostInfos.size() == 0))
/*     */     {
/* 128 */       LostAwardManager.logError("[lostexp]PCGetLostExpReq.getActivityXData@ xActivityLostInfos is null!|roleId=%d|activityId=%d|stage=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.stage) });
/*     */       
/*     */ 
/* 131 */       return null;
/*     */     }
/* 133 */     return (LostExpInfo)xActivityLostInfos.get(Integer.valueOf(this.activityId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isActivityValid()
/*     */   {
/* 143 */     if (!LostAwardManager.isLostExpOpen(this.roleId, true))
/*     */     {
/* 145 */       return false;
/*     */     }
/* 147 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 471, true))
/*     */     {
/* 149 */       LostAwardManager.logInfo("[lostexp]PCGetLostExpReq.isActivityValid@ can not get lost exp for status conflict!|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/* 151 */       return false;
/*     */     }
/* 153 */     this.stage = ActivityInterface.getActivityStage(LostAwardManager.getLostActivityId());
/* 154 */     if (this.stage != 1)
/*     */     {
/* 156 */       LostAwardManager.logError("[lostexp]PCGetLostExpReq.isActivityValid@ not in gain exp stage!|roleId=%d|activityId=%d|stage=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.stage) });
/*     */       
/*     */ 
/* 159 */       return false;
/*     */     }
/* 161 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean canGainExp(LostExpInfo xLostExpInfo)
/*     */   {
/* 172 */     if (!xLostExpInfo.getCangainlostexp())
/*     */     {
/* 174 */       LostAwardManager.logError("[lostexp]PCGetLostExpReq.canGainExp@ can not gain exp!|roleId=%d|activityId=%d|stage=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.stage) });
/*     */       
/*     */ 
/* 177 */       return false;
/*     */     }
/* 179 */     if (xLostExpInfo.getAlreadygainlostexp())
/*     */     {
/* 181 */       LostAwardManager.logError("[lostexp]PCGetLostExpReq.canGainExp@ already gain exp!|roleId=%d|activityId=%d|stage=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.stage) });
/*     */       
/*     */ 
/* 184 */       return false;
/*     */     }
/* 186 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storageexp\activity\PCGetLostExpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */