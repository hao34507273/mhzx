/*     */ package mzm.gsp.backgameactivity.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity3.confbean.BackGameActivitySignAward;
/*     */ import mzm.gsp.activity3.confbean.BackGameActivitySignLevelTier;
/*     */ import mzm.gsp.activity3.confbean.SBackGameActivityCfg;
/*     */ import mzm.gsp.activity3.confbean.SBackGameActivitySignAwardCfg;
/*     */ import mzm.gsp.activity3.confbean.SBackGameActivitySignCfg;
/*     */ import mzm.gsp.activity3.confbean.SBackGameActivitySignLevelTierCfg;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.backgameactivity.SBackGameSignFail;
/*     */ import mzm.gsp.backgameactivity.SBackGameSignSuccess;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BackGameActivityInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2backgameactivity;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCBackGameSignReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int index;
/*     */   
/*     */   public PCBackGameSignReq(long roleId, int index)
/*     */   {
/*  33 */     this.roleId = roleId;
/*  34 */     this.index = index;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */   {
/*  41 */     if (!BackGameActivityManager.isBackGameActivityOpen(this.roleId))
/*     */     {
/*  43 */       String logStr = String.format("[backgameactivity]PCBackGameSignReq.processImp@BackGameActivity not open!|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  45 */       GameServer.logger().info(logStr);
/*  46 */       return false;
/*     */     }
/*  48 */     if (!isBackGameActivitySignOpen())
/*     */     {
/*  50 */       String logStr = String.format("[backgameactivity]PCBackGameSignReq.processImp@BackGameActivitySign not open!|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  52 */       GameServer.logger().info(logStr);
/*  53 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  58 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  59 */     if (null == userId)
/*     */     {
/*  61 */       String logStr = String.format("[backgameactivity]PCBackGameSignReq.processImp@userId not exist!|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  63 */       GameServer.logger().error(logStr);
/*  64 */       return false;
/*     */     }
/*  66 */     lock(Lockeys.get(User.getTable(), userId));
/*  67 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*     */ 
/*  71 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1671, true, true))
/*     */     {
/*  73 */       String logStr = String.format("[backgameactivity]PCBackGameSignReq.processImp@state confict!|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  75 */       GameServer.logger().info(logStr);
/*  76 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  80 */     BackGameActivityInfo xBackGameActivityInfo = Role2backgameactivity.get(Long.valueOf(this.roleId));
/*  81 */     if (null == xBackGameActivityInfo)
/*     */     {
/*  83 */       onFail(-1, xBackGameActivityInfo);
/*     */     }
/*  85 */     if (!BackGameActivityManager.isBackGameActivityInfoAvailable(xBackGameActivityInfo))
/*     */     {
/*  87 */       onFail(-1, xBackGameActivityInfo);
/*  88 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  92 */     long currentTime = DateTimeUtils.getCurrTimeInMillis();
/*  93 */     if (!DateTimeUtils.needDailyReset(xBackGameActivityInfo.getLast_sign_time(), currentTime, 0))
/*     */     {
/*  95 */       onFail(-2, xBackGameActivityInfo);
/*  96 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 100 */     if (this.index != xBackGameActivityInfo.getSign_count() + 1)
/*     */     {
/* 102 */       onFail(-3, xBackGameActivityInfo);
/* 103 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 107 */     SBackGameActivityCfg sBackGameActivityCfg = SBackGameActivityCfg.get(xBackGameActivityInfo.getActivity_id());
/* 108 */     SBackGameActivitySignCfg sBackGameActivitySignCfg = SBackGameActivitySignCfg.get(sBackGameActivityCfg.signCfgId);
/* 109 */     BackGameActivitySignLevelTier signAwardTierBean = getSignAwardTierBean(Integer.valueOf(sBackGameActivitySignCfg.levelTierTypeId), xBackGameActivityInfo);
/* 110 */     SBackGameActivitySignAwardCfg sBackGameActivitySignAwardCfg = SBackGameActivitySignAwardCfg.get(signAwardTierBean.signAwardCfgTypeId);
/* 111 */     BackGameActivitySignAward backGameActivitySignAward = (BackGameActivitySignAward)sBackGameActivitySignAwardCfg.awards.get(this.index - 1);
/* 112 */     if (null == backGameActivitySignAward)
/*     */     {
/* 114 */       onFail(-3, xBackGameActivityInfo);
/* 115 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 119 */     int awardId = backGameActivitySignAward.awardId;
/* 120 */     mzm.gsp.award.main.AwardModel result = AwardInterface.awardFixAward(awardId, userId, this.roleId, true, true, new AwardReason(LogReason.BACK_GAME_ACTIVITY_SIGN_AWARD));
/*     */     
/* 122 */     if (null == result)
/*     */     {
/* 124 */       onFail(-4, xBackGameActivityInfo);
/* 125 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 129 */     xBackGameActivityInfo.setSign_count(this.index);
/* 130 */     xBackGameActivityInfo.setLast_sign_time(currentTime);
/*     */     
/* 132 */     onSuccess(xBackGameActivityInfo);
/*     */     
/* 134 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFail(int errorCode, BackGameActivityInfo xBackGameActivityInfo)
/*     */   {
/* 140 */     String logStr = String.format("[backgameactivity]PCBackGameSignReq.processImp@sign fail!|roleId=%d,errorCode=%d,index=%d,xBackGameActivityInfo=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(errorCode), Integer.valueOf(this.index), xBackGameActivityInfo });
/*     */     
/*     */ 
/* 143 */     GameServer.logger().info(logStr);
/*     */     
/*     */ 
/* 146 */     OnlineManager.getInstance().sendAtOnce(this.roleId, new SBackGameSignFail(errorCode));
/*     */   }
/*     */   
/*     */ 
/*     */   private void onSuccess(BackGameActivityInfo xBackGameActivityInfo)
/*     */   {
/* 152 */     String logStr = String.format("[backgameactivity]PCBackGameSignReq.processImp@sign success!|roleId=%d,index=%d,xBackGameActivityInfo=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.index), xBackGameActivityInfo });
/*     */     
/* 154 */     GameServer.logger().info(logStr);
/*     */     
/*     */ 
/* 157 */     BackGameActivityTlogManager.addBackGameActivitySignTlog(this.roleId, xBackGameActivityInfo.getActivity_id(), xBackGameActivityInfo.getJoin_time(), this.index);
/*     */     
/*     */ 
/* 160 */     OnlineManager.getInstance().send(this.roleId, new SBackGameSignSuccess(this.index));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isBackGameActivitySignOpen()
/*     */   {
/* 170 */     if (!OpenInterface.getOpenStatus(420))
/*     */     {
/* 172 */       return false;
/*     */     }
/* 174 */     if (OpenInterface.isBanPlay(this.roleId, 420))
/*     */     {
/* 176 */       OpenInterface.sendBanPlayMsg(this.roleId, 420);
/* 177 */       return false;
/*     */     }
/* 179 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private BackGameActivitySignLevelTier getSignAwardTierBean(Integer levelTierTypeId, BackGameActivityInfo xBackGameActivityInfo)
/*     */   {
/* 185 */     SBackGameActivitySignLevelTierCfg sBackGameActivitySignLevelTierCfg = SBackGameActivitySignLevelTierCfg.get(levelTierTypeId.intValue());
/*     */     
/* 187 */     for (BackGameActivitySignLevelTier signAwardTierBean : sBackGameActivitySignLevelTierCfg.levelTiers)
/*     */     {
/* 189 */       int joinRoleLevel = xBackGameActivityInfo.getJoin_level();
/* 190 */       if ((signAwardTierBean.levelMax >= joinRoleLevel) && (signAwardTierBean.levelMin <= joinRoleLevel))
/*     */       {
/* 192 */         return signAwardTierBean;
/*     */       }
/*     */     }
/*     */     
/* 196 */     String logStr = String.format("[backgameactivity]PCBackGameSignReq.getSignAwardTierBean@no match level in tierCfgs!|roleId=%d,xBackGameActivityInfo=%s", new Object[] { Long.valueOf(this.roleId), xBackGameActivityInfo });
/*     */     
/*     */ 
/* 199 */     GameServer.logger().error(logStr);
/* 200 */     return (BackGameActivitySignLevelTier)sBackGameActivitySignLevelTierCfg.levelTiers.get(0);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\main\PCBackGameSignReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */