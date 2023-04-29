/*     */ package mzm.gsp.grow.daytarget;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.grow.confbean.TargetConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.TargetData;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCGetAwardReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int targetId;
/*     */   
/*     */   public PCGetAwardReq(long roleId, int targetId)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.targetId = targetId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!DayTargetManager.isDayTargetOpen(this.roleId, true))
/*     */     {
/*  40 */       return false;
/*     */     }
/*  42 */     String userId = RoleInterface.getUserId(this.roleId);
/*     */     
/*  44 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  46 */     RoleDayInfo roleDayInfo = new RoleDayInfo(this.roleId, true);
/*     */     
/*  48 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 211, true))
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, TargetConsts.getInstance().ACTIVITYID);
/*     */     
/*     */ 
/*  56 */     if (!res.isCanJoin())
/*     */     {
/*  58 */       GameServer.logger().error(String.format("[dayTarget]PCGetInitTargets.processImp@canJoinAndCheckInitActivityData error!res.reason=%d", new Object[] { Integer.valueOf(res.getReasonValue()) }));
/*     */       
/*     */ 
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     TargetData xData = roleDayInfo.getTargetData(this.targetId);
/*  65 */     if (xData == null)
/*     */     {
/*  67 */       GameServer.logger().error(String.format("[dayTarget]PCGetAwardReq.processImp@ not own this target!|roleId=%d|targetId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.targetId) }));
/*     */       
/*     */ 
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     if (!setState(xData))
/*     */     {
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     if (!doAward(userId))
/*     */     {
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     DayTargetManager.synTargetInfo(this.roleId, this.targetId, xData.getTargetstate(), xData.getTargetparam());
/*     */     
/*  85 */     return true;
/*     */   }
/*     */   
/*     */   boolean setState(TargetData xData)
/*     */   {
/*  90 */     int state = xData.getTargetstate();
/*  91 */     if (state != 2)
/*     */     {
/*  93 */       GameServer.logger().error(String.format("[DayTarget]PCGetAwardReq.setState@state not finish state!|state=%d", new Object[] { Integer.valueOf(state) }));
/*     */       
/*  95 */       return false;
/*     */     }
/*  97 */     xData.setTargetstate(3);
/*  98 */     return true;
/*     */   }
/*     */   
/*     */   boolean doAward(String userId)
/*     */   {
/* 103 */     int awardId = DayTargetManager.getAwardId(this.targetId);
/* 104 */     if (awardId < 0)
/*     */     {
/* 106 */       GameServer.logger().error(String.format("[dayTarget]PCGetInitTargets.doAward@ awardId illegal!|roleId=%d|targetId=%d|awardId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.targetId), Integer.valueOf(awardId) }));
/*     */       
/*     */ 
/* 109 */       return false;
/*     */     }
/* 111 */     AwardReason reason = new AwardReason(LogReason.EVERY_DAY_TARGET_AWARD);
/* 112 */     AwardModel awardModel = AwardInterface.award(awardId, userId, this.roleId, true, true, reason);
/* 113 */     if (awardModel == null)
/*     */     {
/* 115 */       GameServer.logger().error(String.format("[DayTarget]PCGetAwardReq.processImp@get award failed|roleId=%d|awardId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(awardId) }));
/*     */       
/* 117 */       return false;
/*     */     }
/* 119 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\daytarget\PCGetAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */