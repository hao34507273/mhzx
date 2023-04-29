/*    */ package mzm.gsp.task.condition;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.task.confbean.STask;
/*    */ import mzm.gsp.task.confbean.STaskCongraphFinishCount;
/*    */ import mzm.gsp.task.main.GraphManager;
/*    */ import xbean.ConBean;
/*    */ import xbean.GraphFinishBean;
/*    */ import xtable.Role2graphfinish;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Con_GraphFinishCount_13
/*    */   extends AbsCondition
/*    */ {
/*    */   public Con_GraphFinishCount_13(int conId, int conType, int sTaskId)
/*    */   {
/* 23 */     super(conId, conType, sTaskId);
/*    */   }
/*    */   
/*    */   STaskCongraphFinishCount getSCongraphFinishCount()
/*    */   {
/* 28 */     return STaskCongraphFinishCount.get(getConId());
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isComplete(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params, int graphId)
/*    */   {
/* 34 */     STaskCongraphFinishCount conGraphFinishCount = getSCongraphFinishCount();
/* 35 */     GraphFinishBean graphFinishBean = Role2graphfinish.get(Long.valueOf(roleId));
/* 36 */     if (graphFinishBean == null)
/*    */     {
/* 38 */       return false;
/*    */     }
/* 40 */     if (!graphFinishBean.getGraphidtofinish().containsKey(Integer.valueOf(conGraphFinishCount.graphId)))
/*    */     {
/* 42 */       return false;
/*    */     }
/* 44 */     int finishCount = ((Integer)graphFinishBean.getGraphidtofinish().get(Integer.valueOf(conGraphFinishCount.graphId))).intValue();
/* 45 */     if (finishCount >= conGraphFinishCount.finishCount)
/*    */     {
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getType()
/*    */   {
/* 55 */     return 13;
/*    */   }
/*    */   
/*    */ 
/*    */   public void checkCfg()
/*    */   {
/* 61 */     if (GraphManager.getGraphById(getSCongraphFinishCount().graphId) == null)
/*    */     {
/* 63 */       throw new RuntimeException("任务图完成次数条件配置的图id不存在,taskId" + getSTask().id);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\condition\Con_GraphFinishCount_13.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */