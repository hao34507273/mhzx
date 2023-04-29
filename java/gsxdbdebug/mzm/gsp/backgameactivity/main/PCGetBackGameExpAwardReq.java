/*     */ package mzm.gsp.backgameactivity.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity3.confbean.SBackGameActivityCfg;
/*     */ import mzm.gsp.activity3.confbean.SBackGameActivityExpAwardLevelTier;
/*     */ import mzm.gsp.activity3.confbean.SBackGameActivityExpCfg;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.backgameactivity.SGetBackGameExpAwardFail;
/*     */ import mzm.gsp.backgameactivity.SGetBackGameExpAwardSuccess;
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
/*     */ public class PCGetBackGameExpAwardReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int index;
/*     */   
/*     */   public PCGetBackGameExpAwardReq(long roleId, int index)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.index = index;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */   {
/*  39 */     if (!BackGameActivityManager.isBackGameActivityOpen(this.roleId))
/*     */     {
/*  41 */       String logStr = String.format("[backgameactivity]PCGetBackGameExpAwardReq.processImp@BackGameActivity not open!|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  43 */       GameServer.logger().info(logStr);
/*  44 */       return false;
/*     */     }
/*  46 */     if (!isBackGameExpOpen())
/*     */     {
/*  48 */       String logStr = String.format("[backgameactivity]PCGetBackGameExpAwardReq.processImp@BackGameActivityExp not open!|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*     */ 
/*  51 */       GameServer.logger().info(logStr);
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  56 */     String userId = RoleInterface.getUserId(this.roleId);
/*  57 */     if (null == userId)
/*     */     {
/*  59 */       String logStr = String.format("[backgameactivity]PCGetBackGameExpAwardReq.processImp@userId not exist!|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  61 */       GameServer.logger().error(logStr);
/*  62 */       return false;
/*     */     }
/*  64 */     lock(Lockeys.get(User.getTable(), userId));
/*  65 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*  68 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1673, true, true))
/*     */     {
/*  70 */       String logStr = String.format("[backgameactivity]PCGetBackGameExpAwardReq.processImp@state confict!|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  72 */       GameServer.logger().info(logStr);
/*  73 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  77 */     BackGameActivityInfo xBackGameActivityInfo = Role2backgameactivity.get(Long.valueOf(this.roleId));
/*  78 */     if (null == xBackGameActivityInfo)
/*     */     {
/*  80 */       onFail(-1, xBackGameActivityInfo);
/*  81 */       return false;
/*     */     }
/*  83 */     if (!BackGameActivityManager.isBackGameActivityInfoAvailable(xBackGameActivityInfo))
/*     */     {
/*  85 */       onFail(-1, xBackGameActivityInfo);
/*  86 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  90 */     BackGameActivityManager.updateLoginCountOnline(xBackGameActivityInfo);
/*     */     
/*  92 */     if (this.index > xBackGameActivityInfo.getLogin_count())
/*     */     {
/*  94 */       onFail(-2, xBackGameActivityInfo);
/*  95 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  99 */     if (xBackGameActivityInfo.getAlready_get_exp_awards().contains(Integer.valueOf(this.index)))
/*     */     {
/* 101 */       onFail(-3, xBackGameActivityInfo);
/* 102 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 106 */     SBackGameActivityCfg sBackGameActivityCfg = SBackGameActivityCfg.get(xBackGameActivityInfo.getActivity_id());
/* 107 */     SBackGameActivityExpCfg sBackGameActivityExpCfg = SBackGameActivityExpCfg.get(sBackGameActivityCfg.expCfgId);
/* 108 */     SBackGameActivityExpAwardLevelTier expAwardTierBean = getExpAwardTierBean(sBackGameActivityExpCfg.expAwardLevelTiers, xBackGameActivityInfo);
/* 109 */     Integer awardId = (Integer)expAwardTierBean.index2awardId.get(Integer.valueOf(this.index));
/* 110 */     if (null == awardId)
/*     */     {
/* 112 */       onFail(-4, xBackGameActivityInfo);
/* 113 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 117 */     mzm.gsp.award.main.AwardModel result = AwardInterface.award(awardId.intValue(), userId, this.roleId, true, true, new AwardReason(LogReason.BACK_GAME_ACTIVITY_EXP_AWARD));
/*     */     
/* 119 */     if (null == result)
/*     */     {
/* 121 */       onFail(-5, xBackGameActivityInfo);
/* 122 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 126 */     xBackGameActivityInfo.getAlready_get_exp_awards().add(Integer.valueOf(this.index));
/*     */     
/* 128 */     onSuccess(xBackGameActivityInfo);
/*     */     
/* 130 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFail(int errorCode, BackGameActivityInfo xBackGameActivityInfo)
/*     */   {
/* 136 */     String logStr = String.format("[backgameactivity]PCGetBackGameExpAwardReq.processImp@get exp award fail!|roleId=%d,errorCode=%d,index=%d,xBackGameActivityInfo=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(errorCode), Integer.valueOf(this.index), xBackGameActivityInfo });
/*     */     
/*     */ 
/* 139 */     GameServer.logger().info(logStr);
/*     */     
/*     */ 
/* 142 */     OnlineManager.getInstance().sendAtOnce(this.roleId, new SGetBackGameExpAwardFail(errorCode));
/*     */   }
/*     */   
/*     */ 
/*     */   private void onSuccess(BackGameActivityInfo xBackGameActivityInfo)
/*     */   {
/* 148 */     String logStr = String.format("[backgameactivity]PCGetBackGameExpAwardReq.processImp@get exp award success!|roleId=%d,index=%d,xBackGameActivityInfo=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.index), xBackGameActivityInfo });
/*     */     
/*     */ 
/* 151 */     GameServer.logger().info(logStr);
/*     */     
/*     */ 
/* 154 */     BackGameActivityTlogManager.addBackGameActivityExpAwardGetTlog(this.roleId, xBackGameActivityInfo.getActivity_id(), xBackGameActivityInfo.getJoin_time(), this.index, xBackGameActivityInfo.getLogin_count());
/*     */     
/*     */ 
/*     */ 
/* 158 */     SGetBackGameExpAwardSuccess protocol = new SGetBackGameExpAwardSuccess(this.index);
/* 159 */     OnlineManager.getInstance().send(this.roleId, protocol);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isBackGameExpOpen()
/*     */   {
/* 169 */     if (!OpenInterface.getOpenStatus(422))
/*     */     {
/* 171 */       return false;
/*     */     }
/* 173 */     if (OpenInterface.isBanPlay(this.roleId, 422))
/*     */     {
/* 175 */       OpenInterface.sendBanPlayMsg(this.roleId, 422);
/* 176 */       return false;
/*     */     }
/* 178 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private SBackGameActivityExpAwardLevelTier getExpAwardTierBean(List<SBackGameActivityExpAwardLevelTier> expAwardTierBeans, BackGameActivityInfo xBackGameActivityInfo)
/*     */   {
/* 184 */     for (SBackGameActivityExpAwardLevelTier expAwardTierBean : expAwardTierBeans)
/*     */     {
/* 186 */       int joinRoleLevel = xBackGameActivityInfo.getJoin_level();
/* 187 */       if ((expAwardTierBean.levelMax >= joinRoleLevel) && (expAwardTierBean.levelMin <= joinRoleLevel))
/*     */       {
/* 189 */         return expAwardTierBean;
/*     */       }
/*     */     }
/*     */     
/* 193 */     String logStr = String.format("[backgameactivity]PCGetBackGameExpAwardReq.getExpAwardTierBean@no match level in tierCfgs!|roleId=%d,xBackGameActivityInfo=%s", new Object[] { Long.valueOf(this.roleId), xBackGameActivityInfo });
/*     */     
/*     */ 
/* 196 */     GameServer.logger().error(logStr);
/* 197 */     return (SBackGameActivityExpAwardLevelTier)expAwardTierBeans.get(0);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\main\PCGetBackGameExpAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */