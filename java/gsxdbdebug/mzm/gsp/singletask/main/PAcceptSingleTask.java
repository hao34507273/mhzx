/*     */ package mzm.gsp.singletask.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.SingleTaskCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PAcceptSingleTask
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityId;
/*     */   SingleTaskCfg cfg;
/*     */   
/*     */   public PAcceptSingleTask(long roleId, int activityId)
/*     */   {
/*  34 */     this.roleId = roleId;
/*  35 */     this.activityId = activityId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 228, true))
/*     */     {
/*  43 */       return false;
/*     */     }
/*  45 */     this.cfg = SingleTaskCfg.get(this.activityId);
/*  46 */     if (this.cfg == null)
/*     */     {
/*  48 */       GameServer.logger().error(String.format("[singleTask]PAcceptSingleTask.processImp@ cfg is null!|activityId=%d", new Object[] { Integer.valueOf(this.activityId) }));
/*     */       
/*  50 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  54 */     String userId = RoleInterface.getUserId(this.roleId);
/*  55 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  57 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */     
/*  59 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityId);
/*  60 */     if (!res.isCanJoin())
/*     */     {
/*  62 */       GameServer.logger().error(String.format("[singleTask]PAcceptSingleTask.processImp@ can not join activity!|roleId=%d|activityId=%d|errCode=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(res.getReasonValue()) }));
/*     */       
/*     */ 
/*     */ 
/*  66 */       if (res.isSingleRoleTeam())
/*     */       {
/*  68 */         SingleTaskManager.sendSingleNotice(this.roleId, false, 1, new String[0]);
/*     */       }
/*  70 */       if (res.isActivityJoinCountMax())
/*     */       {
/*  72 */         SingleTaskManager.sendSingleNotice(this.roleId, false, 4, new String[0]);
/*     */       }
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     if ((!this.cfg.autoGetGraph) && (!MapInterface.isNearByNPC(this.roleId, this.cfg.npcid)))
/*     */     {
/*     */ 
/*  80 */       GameServer.logger().error(String.format("[singleTask]PAcceptSingleTask.processImp@ not near npc!|roleId=%d|npcId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.cfg.npcid), Integer.valueOf(this.activityId) }));
/*     */       
/*     */ 
/*  83 */       SingleTaskManager.sendSingleNotice(this.roleId, false, 5, new String[0]);
/*  84 */       return false;
/*     */     }
/*  86 */     if (SingleTaskManager.containsGraphId(this.cfg.graphLibId, this.roleId))
/*     */     {
/*  88 */       SingleTaskManager.sendSingleNotice(this.roleId, false, 6, new String[0]);
/*  89 */       return false;
/*     */     }
/*  91 */     int lastGraphId = SingleTaskManager.selectLastGraphId(this.roleId, this.activityId);
/*  92 */     if (lastGraphId <= 0)
/*     */     {
/*  94 */       GameServer.logger().error(String.format("[singleTask]PAcceptSingleTask.processImp@ not get graphId!|roleId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId) }));
/*     */       
/*     */ 
/*  97 */       return false;
/*     */     }
/*  99 */     TaskInterface.goNextTask(this.roleId, lastGraphId);
/* 100 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singletask\main\PAcceptSingleTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */