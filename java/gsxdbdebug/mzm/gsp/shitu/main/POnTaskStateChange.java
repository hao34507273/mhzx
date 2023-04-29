/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.shitu.confbean.SShiTuTaskCfg;
/*     */ import mzm.gsp.shitu.event.FinishOneTask;
/*     */ import mzm.gsp.shitu.event.FinishOneTaskArg;
/*     */ import mzm.gsp.task.event.TaskStateChangeProcedure;
/*     */ import mzm.gsp.task.main.TaskEventArg;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ShiTuTask;
/*     */ import xbean.ShiTuTaskInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2shitutask;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class POnTaskStateChange
/*     */   extends TaskStateChangeProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     if (!ShiTuManager.isShiTuTaskGraph(((TaskEventArg)this.arg).graphId))
/*     */     {
/*  32 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  36 */     String userid = RoleInterface.getUserId(((TaskEventArg)this.arg).roleId);
/*  37 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*     */ 
/*  40 */     ShiTuTaskInfo xShiTuTaskInfo = Role2shitutask.get(Long.valueOf(((TaskEventArg)this.arg).roleId));
/*  41 */     if ((xShiTuTaskInfo == null) || (xShiTuTaskInfo.getPublish_state() != 2))
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     ShiTuTask xShiTuTask = (ShiTuTask)xShiTuTaskInfo.getTask_infos().get(Integer.valueOf(((TaskEventArg)this.arg).graphId));
/*     */     
/*  48 */     if (xShiTuTask == null)
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     if (xShiTuTask.getTask_id() != ((TaskEventArg)this.arg).taskId)
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     if ((xShiTuTask.getTask_state() == 2) || (xShiTuTask.getTask_state() == 4))
/*     */     {
/*     */ 
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     if (8 == ((TaskEventArg)this.arg).taskState)
/*     */     {
/*  66 */       ShiTuManager.changeShiTuTaskState(((TaskEventArg)this.arg).roleId, ((TaskEventArg)this.arg).graphId, xShiTuTask, 2);
/*     */       
/*  68 */       SShiTuTaskCfg sShiTuTaskCfg = SShiTuTaskCfg.get(((TaskEventArg)this.arg).taskId);
/*     */       
/*  70 */       AwardReason reason = new AwardReason(LogReason.SHI_TU_TASK_APPRENTICE_AWARD);
/*     */       
/*  72 */       AwardModel awardModel = null;
/*  73 */       if (sShiTuTaskCfg.apprentice_reward_type == 2)
/*     */       {
/*  75 */         awardModel = AwardInterface.awardFixAward(sShiTuTaskCfg.apprentice_reward_id, userid, ((TaskEventArg)this.arg).roleId, false, true, reason);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*  80 */         awardModel = AwardInterface.award(sShiTuTaskCfg.apprentice_reward_id, userid, ((TaskEventArg)this.arg).roleId, false, true, reason);
/*     */       }
/*  82 */       if (awardModel == null)
/*     */       {
/*  84 */         GameServer.logger().error(String.format("[shitu]POnTaskStateChange.processImp@get task award failed|roleId=%d|taskId=%d|awardId=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(((TaskEventArg)this.arg).taskId), Integer.valueOf(sShiTuTaskCfg.apprentice_reward_id) }));
/*     */         
/*     */ 
/*     */ 
/*  88 */         return false;
/*     */       }
/*  90 */       FinishOneTaskArg eventArg = new FinishOneTaskArg(((TaskEventArg)this.arg).roleId, ((TaskEventArg)this.arg).graphId, ((TaskEventArg)this.arg).taskId);
/*  91 */       TriggerEventsManger.getInstance().triggerEvent(new FinishOneTask(), eventArg);
/*     */     }
/*  93 */     else if (9 == ((TaskEventArg)this.arg).taskState)
/*     */     {
/*  95 */       ShiTuManager.changeShiTuTaskState(((TaskEventArg)this.arg).roleId, ((TaskEventArg)this.arg).graphId, xShiTuTask, 3);
/*     */     }
/*  97 */     else if (2 == ((TaskEventArg)this.arg).taskState)
/*     */     {
/*  99 */       ShiTuManager.changeShiTuTaskState(((TaskEventArg)this.arg).roleId, ((TaskEventArg)this.arg).graphId, xShiTuTask, 1);
/*     */     }
/*     */     
/* 102 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\POnTaskStateChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */