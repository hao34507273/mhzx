/*     */ package mzm.gsp.backgameactivity.main;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity3.confbean.SBackGameActivityAwardTierCfg;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.backgameactivity.SGetBackGameAwardFail;
/*     */ import mzm.gsp.backgameactivity.SGetBackGameAwardSuccess;
/*     */ import mzm.gsp.buff.main.BuffInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BackGameActivityInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2backgameactivity;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetBackGameAwardReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int awardTierCfgId;
/*     */   
/*     */   public PCGetBackGameAwardReq(long roleId, int awardTierCfgId)
/*     */   {
/*  28 */     this.roleId = roleId;
/*  29 */     this.awardTierCfgId = awardTierCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */   {
/*  36 */     if (!BackGameActivityManager.isBackGameActivityOpen(this.roleId))
/*     */     {
/*  38 */       String logStr = String.format("[backgameactivity]PCGetBackGameAwardReq.processImp@BackGameActivity not open!|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  40 */       GameServer.logger().info(logStr);
/*  41 */       return false;
/*     */     }
/*  43 */     if (!isBackGameAwardOpen())
/*     */     {
/*  45 */       String logStr = String.format("[backgameactivity]PCGetBackGameAwardReq.processImp@BackGameActivityAward not open!|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  47 */       GameServer.logger().info(logStr);
/*  48 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  52 */     String userId = RoleInterface.getUserId(this.roleId);
/*  53 */     if (null == userId)
/*     */     {
/*  55 */       String logStr = String.format("[backgameactivity]PCGetBackGameAwardReq.processImp@userId not exist!|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  57 */       GameServer.logger().error(logStr);
/*  58 */       return false;
/*     */     }
/*  60 */     lock(Lockeys.get(User.getTable(), userId));
/*  61 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*  64 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1675, true, true))
/*     */     {
/*  66 */       String logStr = String.format("[backgameactivity]PCGetBackGameAwardReq.processImp@state confict!|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  68 */       GameServer.logger().info(logStr);
/*  69 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  73 */     BackGameActivityInfo xBackGameActivityInfo = Role2backgameactivity.get(Long.valueOf(this.roleId));
/*  74 */     if (null == xBackGameActivityInfo)
/*     */     {
/*  76 */       onFail(-1, xBackGameActivityInfo);
/*  77 */       return false;
/*     */     }
/*  79 */     if (!BackGameActivityManager.isBackGameActivityInfoAvailable(xBackGameActivityInfo))
/*     */     {
/*  81 */       onFail(-1, xBackGameActivityInfo);
/*  82 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  86 */     int awardTierCfgId = BackGameActivityManager.getBackGameAwardCfgId(xBackGameActivityInfo.getJoin_recharge(), xBackGameActivityInfo.getActivity_id());
/*     */     
/*  88 */     if (awardTierCfgId != this.awardTierCfgId)
/*     */     {
/*  90 */       onFail(-3, xBackGameActivityInfo);
/*  91 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  95 */     if (xBackGameActivityInfo.getHave_got_back_game_award())
/*     */     {
/*  97 */       onFail(-2, xBackGameActivityInfo);
/*  98 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 102 */     SBackGameActivityAwardTierCfg awardTierCfg = SBackGameActivityAwardTierCfg.get(awardTierCfgId);
/*     */     
/*     */ 
/* 105 */     int awardId = awardTierCfg.awardId;
/* 106 */     mzm.gsp.award.main.AwardModel result = AwardInterface.awardFixAward(awardId, userId, this.roleId, true, true, new AwardReason(LogReason.BACK_GAME_ACTIVITY_AWARD));
/*     */     
/* 108 */     if (null == result)
/*     */     {
/* 110 */       onFail(-4, xBackGameActivityInfo);
/* 111 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 115 */     BuffInterface.installBuff(this.roleId, awardTierCfg.buffId);
/*     */     
/*     */ 
/* 118 */     xBackGameActivityInfo.setHave_got_back_game_award(true);
/*     */     
/* 120 */     onSuccess(xBackGameActivityInfo);
/*     */     
/* 122 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFail(int errorCode, BackGameActivityInfo xBackGameActivityInfo)
/*     */   {
/* 128 */     String logStr = String.format("[backgameactivity]PCGetBackGameAwardReq.processImp@get award fail!|roleId=%d,errorCode=%d,awardTierCfgId=%d,xBackGameActivityInfo=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(errorCode), Integer.valueOf(this.awardTierCfgId), xBackGameActivityInfo });
/*     */     
/*     */ 
/* 131 */     GameServer.logger().info(logStr);
/*     */     
/*     */ 
/* 134 */     OnlineManager.getInstance().sendAtOnce(this.roleId, new SGetBackGameAwardFail(errorCode));
/*     */   }
/*     */   
/*     */ 
/*     */   private void onSuccess(BackGameActivityInfo xBackGameActivityInfo)
/*     */   {
/* 140 */     String logStr = String.format("[backgameactivity]PCGetBackGameAwardReq.processImp@get award success!|roleId=%d,awardTierCfgId=%d,xBackGameActivityInfo=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.awardTierCfgId), xBackGameActivityInfo });
/*     */     
/*     */ 
/* 143 */     GameServer.logger().info(logStr);
/*     */     
/*     */ 
/* 146 */     BackGameActivityTlogManager.addBackGameActivityAwardGetTlog(this.roleId, xBackGameActivityInfo.getActivity_id(), xBackGameActivityInfo.getJoin_time());
/*     */     
/*     */ 
/*     */ 
/* 150 */     OnlineManager.getInstance().sendAtOnce(this.roleId, new SGetBackGameAwardSuccess(this.awardTierCfgId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isBackGameAwardOpen()
/*     */   {
/* 160 */     if (!OpenInterface.getOpenStatus(423))
/*     */     {
/* 162 */       return false;
/*     */     }
/* 164 */     if (OpenInterface.isBanPlay(this.roleId, 423))
/*     */     {
/* 166 */       OpenInterface.sendBanPlayMsg(this.roleId, 423);
/* 167 */       return false;
/*     */     }
/* 169 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\main\PCGetBackGameAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */