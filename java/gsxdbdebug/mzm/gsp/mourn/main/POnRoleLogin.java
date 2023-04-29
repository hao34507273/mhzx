/*     */ package mzm.gsp.mourn.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity2.confbean.MournConsts;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.AccpetTaskProcedure;
/*     */ import mzm.gsp.task.main.TaskData;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.XMournInfo;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Procedure;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2mourn;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnRoleLogin
/*     */   extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  29 */     long roleId = ((Long)this.arg).longValue();
/*     */     
/*  31 */     String userId = RoleInterface.getUserId(roleId);
/*  32 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  34 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/*  35 */     if (checkActivityEnd(roleId))
/*     */     {
/*  37 */       return true;
/*     */     }
/*  39 */     checkMTask(roleId);
/*  40 */     MournManager.synRoleMournInfo(roleId, Role2mourn.get(Long.valueOf(roleId)));
/*  41 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkActivityEnd(long roleId)
/*     */   {
/*  51 */     if (DateTimeUtils.getCurrTimeInMillis() < ActivityInterface.getActivityEndTime(MournConsts.getInstance().activityId))
/*     */     {
/*  53 */       return false;
/*     */     }
/*  55 */     for (Iterator i$ = MournManager.getAllMournGraphIds().iterator(); i$.hasNext();) { int graphId = ((Integer)i$.next()).intValue();
/*     */       
/*  57 */       TaskInterface.closeActivityGraphWithoutEvent(roleId, graphId);
/*     */     }
/*  59 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void checkMTask(long roleId)
/*     */   {
/*  67 */     XMournInfo xMournInfo = Role2mourn.get(Long.valueOf(roleId));
/*  68 */     if (xMournInfo == null)
/*     */     {
/*  70 */       return;
/*     */     }
/*  72 */     Set<Integer> ownMournIds = xMournInfo.getMourndatas().keySet();
/*  73 */     if (ownMournIds.size() == 0)
/*     */     {
/*  75 */       return;
/*     */     }
/*  77 */     Set<Integer> ownGraphIds = MournManager.getOwnGraphIds(ownMournIds);
/*  78 */     if (ownGraphIds.size() == 0)
/*     */     {
/*  80 */       return;
/*     */     }
/*  82 */     ownGraphIds.add(Integer.valueOf(MournConsts.getInstance().questionGraphId));
/*  83 */     for (Iterator i$ = MournManager.getAllMournGraphIds().iterator(); i$.hasNext();) { int graphId = ((Integer)i$.next()).intValue();
/*     */       
/*  85 */       if (TaskInterface.isHaveGraphId(roleId, graphId))
/*     */       {
/*     */ 
/*     */ 
/*  89 */         if (!ownGraphIds.contains(Integer.valueOf(graphId)))
/*     */         {
/*  91 */           GameServer.logger().error(String.format("[mourn]POnRoleLogin.checkBTask@ not own this graph!|roleId=%d|graphId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId) }));
/*     */           
/*     */ 
/*  94 */           TaskInterface.closeActivityGraphWithoutEvent(roleId, graphId);
/*     */         }
/*  96 */         TaskData taskData = TaskInterface.getRoleGraphTask(roleId, graphId);
/*  97 */         if ((taskData != null) && 
/*     */         
/*     */ 
/*     */ 
/* 101 */           (taskData.getState() == 1))
/*     */         {
/*     */ 
/*     */ 
/* 105 */           GameServer.logger().error(String.format("[mourn]POnRoleLogin.checkBTask@ has can accept task!|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(taskData.getTaskId()) }));
/*     */           
/*     */ 
/* 108 */           Procedure.execute(new AccpetTaskProcedure(((Long)this.arg).longValue(), graphId, taskData.getTaskId()));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mourn\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */