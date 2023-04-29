/*     */ package mzm.gsp.grow.daytarget;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.grow.confbean.TargetConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCF5DayTarget
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long curGold;
/*     */   
/*     */   public PCF5DayTarget(long roleId, long curGold)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.curGold = curGold;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (!DayTargetManager.isDayTargetOpen(this.roleId, true))
/*     */     {
/*  38 */       return false;
/*     */     }
/*  40 */     String userId = RoleInterface.getUserId(this.roleId);
/*     */     
/*  42 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  44 */     RoleDayInfo roleDayInfo = new RoleDayInfo(this.roleId, true);
/*     */     
/*  46 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 210, true))
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     if (!roleDayInfo.hasXData())
/*     */     {
/*  53 */       GameServer.logger().error(String.format("[dayTarget]PCF5DayTarget.processImp@ do F5 action, but not has xData!|roleId=%d|roleLv=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(RoleInterface.getLevel(this.roleId)) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  58 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, TargetConsts.getInstance().ACTIVITYID);
/*     */     
/*     */ 
/*  61 */     if (!res.isCanJoin())
/*     */     {
/*  63 */       GameServer.logger().error(String.format("[dayTarget]PCGetInitTargets.processImp@canJoinAndCheckInitActivityData error!res.reason=%d", new Object[] { Integer.valueOf(res.getReasonValue()) }));
/*     */       
/*     */ 
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     if (roleDayInfo.getXSateTargetIds(1).size() == 0)
/*     */     {
/*  71 */       GameServer.logger().error(String.format("[dayTarget]PCF5DayTarget.processImp@ no more need F5!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     if (!payPrice())
/*     */     {
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     DayTargetManager.flushNewTargets(roleDayInfo, 1);
/*     */     
/*  82 */     if (roleDayInfo.getAllTarget().size() != TargetConsts.getInstance().FLUSH_NUM)
/*     */     {
/*  84 */       GameServer.logger().warn(String.format("[dayTarget]PCF5DayTarget.processImp@ targets num not enough!|roleId=%d|needNum=%d|ownNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(TargetConsts.getInstance().FLUSH_NUM), Integer.valueOf(roleDayInfo.getAllTarget().size()) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  90 */     DayTargetManager.synAllTargets(roleDayInfo);
/*  91 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean payPrice()
/*     */   {
/* 101 */     if (this.curGold != RoleInterface.getGold(this.roleId))
/*     */     {
/* 103 */       GameServer.logger().error(String.format("[dayTarget]PCF5DayTarget.payPrice@ curGold S-C not equal!|clientGold=%d|serverGold=%d", new Object[] { Long.valueOf(this.curGold), Long.valueOf(RoleInterface.getGold(this.roleId)) }));
/*     */       
/*     */ 
/* 106 */       return false;
/*     */     }
/* 108 */     int needNum = TargetConsts.getInstance().FLUSH_COST_GOLD;
/* 109 */     RoleInterface.cutGold(this.roleId, needNum, new TLogArg(LogReason.EVERY_DAY_TARGET_FLUSH_COST));
/* 110 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\daytarget\PCF5DayTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */