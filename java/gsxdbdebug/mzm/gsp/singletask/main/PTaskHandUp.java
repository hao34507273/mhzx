/*     */ package mzm.gsp.singletask.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.SingleTaskCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.tlog.LogReason;
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
/*     */ public class PTaskHandUp
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityId;
/*     */   private final int graphId;
/*     */   private final boolean isEnd;
/*     */   SingleTaskCfg cfg;
/*     */   
/*     */   public PTaskHandUp(long roleId, int activityId, int graphId, boolean isEnd)
/*     */   {
/*  38 */     this.roleId = roleId;
/*  39 */     this.activityId = activityId;
/*  40 */     this.graphId = graphId;
/*  41 */     this.isEnd = isEnd;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     this.cfg = SingleTaskCfg.get(this.activityId);
/*  48 */     if (this.cfg == null)
/*     */     {
/*  50 */       GameServer.logger().error(String.format("[singleTask]PTaskHandUp.processImp@ cfg is null!|activityId=%d", new Object[] { Integer.valueOf(this.activityId) }));
/*     */       
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  56 */     String userId = RoleInterface.getUserId(this.roleId);
/*  57 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  59 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */     
/*  61 */     ActivityInterface.logActivity(this.roleId, this.activityId, ActivityLogStatus.FINISH);
/*  62 */     ActivityInterface.tlogActivity(this.roleId, this.activityId, ActivityLogStatus.FINISH);
/*     */     
/*  64 */     if (!addActivityCount(userId))
/*     */     {
/*  66 */       GameServer.logger().error(String.format("[singleTask]PTaskHandUp.doAward@ add count error!|roleId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId) }));
/*     */       
/*     */ 
/*  69 */       return false;
/*     */     }
/*  71 */     if (!doAward(userId))
/*     */     {
/*  73 */       GameServer.logger().error(String.format("[singleTask]PTaskHandUp.doAward@ do award error!|roleId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId) }));
/*     */       
/*     */ 
/*  76 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  80 */     if (ActivityInterface.isToMaxCount(userId, this.roleId, this.activityId))
/*     */     {
/*  82 */       if (!TaskInterface.closeActivityGraphWithoutEvent(this.roleId, this.graphId))
/*     */       {
/*  84 */         GameServer.logger().error(String.format("[singleTask]PTaskHandUp.doAward@ close graph error!|roleId=%d|graphId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.graphId) }));
/*     */         
/*     */ 
/*  87 */         return false;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  92 */       ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityId);
/*  93 */       if (!res.isCanJoin())
/*     */       {
/*  95 */         GameServer.logger().error(String.format("[singleTask]PTaskHandUp.processImp@ can not join activity!|roleId=%d|activityId=%d|errCode=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(res.getReasonValue()) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 102 */       else if (OpenInterface.getOpenStatus(this.cfg.openId))
/*     */       {
/* 104 */         if (this.cfg.atuoNextTask)
/*     */         {
/* 106 */           TaskInterface.goNextTask(this.roleId, this.graphId);
/*     */         }
/*     */         
/*     */ 
/*     */       }
/*     */       else {
/* 112 */         TaskInterface.closeActivityGraphWithoutEvent(this.roleId, this.graphId);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 117 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean addActivityCount(String userId)
/*     */   {
/* 123 */     boolean ret = ActivityInterface.addActivityCount(userId, this.roleId, this.activityId);
/* 124 */     if (!ret)
/*     */     {
/* 126 */       return false;
/*     */     }
/* 128 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean doAward(String userId)
/*     */   {
/* 139 */     if (this.cfg.awardId <= 0)
/*     */     {
/* 141 */       return true;
/*     */     }
/*     */     
/* 144 */     int curRingNum = ActivityInterface.getActivityCount(userId, this.roleId, this.activityId, true);
/* 145 */     if (curRingNum < 0)
/*     */     {
/* 147 */       GameServer.logger().error(String.format("[singleTask]PTaskHandUp.doAward@ get curRing error!|roleId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId) }));
/*     */       
/*     */ 
/* 150 */       return false;
/*     */     }
/*     */     
/* 153 */     int modId = -1;
/* 154 */     if (this.cfg.needMod)
/*     */     {
/* 156 */       modId = SingleTaskManager.getModId(this.activityId, curRingNum);
/* 157 */       if (modId <= 0)
/*     */       {
/* 159 */         modId = this.cfg.defaultModId;
/*     */       }
/*     */     }
/*     */     
/* 163 */     AwardReason reason = new AwardReason(LogReason.SINGLE_TASK_AWARD, this.activityId);
/* 164 */     AwardModel am = AwardInterface.award(this.cfg.awardId, userId, this.roleId, modId, false, true, reason);
/* 165 */     if (am == null)
/*     */     {
/* 167 */       GameServer.logger().error(String.format("[singleTask]PTaskHandUp.doAward@ award fail!|roleId=%d|activityId=%d|awardId=%d|modId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.cfg.awardId), Integer.valueOf(modId) }));
/*     */       
/*     */ 
/* 170 */       return false;
/*     */     }
/* 172 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singletask\main\PTaskHandUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */