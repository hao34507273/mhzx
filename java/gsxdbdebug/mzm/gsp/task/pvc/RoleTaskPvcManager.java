/*     */ package mzm.gsp.task.pvc;
/*     */ 
/*     */ import mzm.gsp.task.confbean.STaskPvcCfg;
/*     */ import mzm.gsp.task.main.RoleTask;
/*     */ import mzm.gsp.task.main.RoleTaskManager;
/*     */ import xbean.TaskBean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoleTaskPvcManager
/*     */ {
/*     */   public static boolean doPvcFight(long roleId, int graphId, int taskId, int pvcId, int conId)
/*     */   {
/*  21 */     AbsPvcFight pvcFigh = getAbsPvcFight(roleId, graphId, taskId, pvcId, conId);
/*  22 */     if (pvcFigh == null)
/*     */     {
/*  24 */       return false;
/*     */     }
/*  26 */     RoleTask roleTask = RoleTaskManager.getRoleTask(roleId, false);
/*  27 */     TaskBean xTaskBean = roleTask.getTaskBean(graphId, taskId);
/*  28 */     if (xTaskBean == null)
/*     */     {
/*  30 */       return false;
/*     */     }
/*  32 */     return pvcFigh.onStartPvcFight(xTaskBean);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean onAcceptPvcTask(long roleId, int graphId, int taskId, int pvcId, int conId)
/*     */   {
/*  44 */     AbsPvcFight pvcFigh = getAbsPvcFight(roleId, graphId, taskId, pvcId, conId);
/*  45 */     if (pvcFigh == null)
/*     */     {
/*  47 */       return false;
/*     */     }
/*  49 */     RoleTask roleTask = RoleTaskManager.getRoleTask(roleId, true);
/*  50 */     TaskBean xTaskBean = roleTask.getTaskBean(graphId, taskId);
/*  51 */     if (xTaskBean == null)
/*     */     {
/*  53 */       return false;
/*     */     }
/*  55 */     pvcFigh.onAcceptPvcTask(xTaskBean);
/*  56 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static AbsPvcFight getAbsPvcFight(long roleId, int graphId, int taskId, int pvcId, int conId)
/*     */   {
/*  66 */     STaskPvcCfg sCfg = STaskPvcCfg.get(pvcId);
/*  67 */     if (sCfg == null)
/*     */     {
/*  69 */       return null;
/*     */     }
/*  71 */     int type = sCfg.pvcType;
/*  72 */     IPvcFactory factory = null;
/*  73 */     switch (type)
/*     */     {
/*     */     case 1: 
/*  76 */       factory = new FPvcSelf(roleId, graphId, taskId, pvcId, conId);
/*  77 */       break;
/*     */     case 3: 
/*  79 */       factory = new FPvcFactionLeader(roleId, graphId, taskId, pvcId, conId);
/*  80 */       break;
/*     */     case 2: 
/*  82 */       factory = new FPvcFriend(roleId, graphId, taskId, pvcId, conId);
/*  83 */       break;
/*     */     case 4: 
/*  85 */       factory = new FPvcOwnTeam(roleId, graphId, taskId, pvcId, conId);
/*  86 */       break;
/*     */     case 10: 
/*  88 */       factory = new FPvcFightValueChart(roleId, graphId, taskId, pvcId, conId);
/*  89 */       break;
/*     */     case 11: 
/*  91 */       factory = new FPvcRoleLevelChart(roleId, graphId, taskId, pvcId, conId);
/*  92 */       break;
/*     */     }
/*     */     
/*     */     
/*     */ 
/*  97 */     if (factory == null)
/*     */     {
/*  99 */       return null;
/*     */     }
/* 101 */     AbsPvcFight pvcFigh = factory.creatPvcFight();
/* 102 */     return pvcFigh;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\pvc\RoleTaskPvcManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */