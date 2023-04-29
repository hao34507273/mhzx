/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.fight.event.PVPFightEndArg;
/*    */ import mzm.gsp.leitai.event.LeiTaiFightEndEventProcedure;
/*    */ import mzm.gsp.task.conParamObj.LeitaiParamObj;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.GraphBean;
/*    */ import xbean.NodeBean;
/*    */ import xbean.TaskBean;
/*    */ import xbean.TaskDataBean;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnLeiTaiFightEndEvent
/*    */   extends LeiTaiFightEndEventProcedure
/*    */ {
/* 27 */   private static final Logger logger = Logger.getLogger(POnLeiTaiFightEndEvent.class);
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     PVPFightEndArg pvpArg = (PVPFightEndArg)this.arg;
/*    */     
/* 34 */     LeitaiParamObj obj = new LeitaiParamObj();
/* 35 */     obj.setWinCount(1);
/*    */     
/* 37 */     Map<Integer, Object> params = new HashMap();
/* 38 */     params.put(Integer.valueOf(16), obj);
/*    */     
/* 40 */     List<Long> winRoles = new ArrayList(pvpArg.getWinnerNotEscapeList());
/* 41 */     if (winRoles.size() == 0)
/*    */     {
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     lock(Basic.getTable(), winRoles);
/*    */     
/* 48 */     for (Iterator i$ = winRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 50 */       RoleTask roleTask = RoleTaskManager.getRoleTask(roleId, true);
/* 51 */       if (roleTask.getTaskDataBean() != null)
/*    */       {
/*    */ 
/*    */ 
/* 55 */         List<GraphBean> graphBeans = new ArrayList(roleTask.getTaskDataBean().getGraphbeans().values());
/* 56 */         GraphBean graphBean; for (int i = 0; i < graphBeans.size(); i++)
/*    */         {
/* 58 */           graphBean = (GraphBean)graphBeans.get(i);
/* 59 */           for (TaskBean taskBean : graphBean.getNodebean().getTaskbeans().values())
/*    */           {
/* 61 */             if (taskBean.getTaskstate() != 3)
/*    */             {
/*    */ 
/*    */ 
/* 65 */               Task task = TaskManager.getTaskById(taskBean.getTaskid());
/* 66 */               if (task == null)
/*    */               {
/* 68 */                 logger.error("任务不存在了:" + taskBean.getTaskid());
/*    */               }
/*    */               else
/*    */               {
/* 72 */                 RoleTaskManager.updateTaskCon(roleId, params, graphBean, taskBean, null); }
/*    */             } }
/*    */         }
/*    */       }
/*    */     }
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\POnLeiTaiFightEndEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */