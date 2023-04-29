/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.task.confbean.STaskSet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TaskSetManager
/*    */ {
/* 21 */   private static TaskSetManager instance = new TaskSetManager();
/*    */   
/* 23 */   private Map<Integer, TaskSet> idToTaskSetMap = new HashMap();
/*    */   
/*    */   static TaskSetManager getInstance()
/*    */   {
/* 27 */     return instance;
/*    */   }
/*    */   
/*    */   void init() throws Exception
/*    */   {
/* 32 */     for (STaskSet staskSet : STaskSet.getAll().values())
/*    */     {
/* 34 */       TaskSet taskSet = new TaskSet();
/* 35 */       taskSet.setTaskSetId(staskSet.id);
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 43 */       this.idToTaskSetMap.put(Integer.valueOf(staskSet.id), taskSet);
/*    */     }
/*    */   }
/*    */   
/*    */   static boolean isHasTaskSet(int taskSetId)
/*    */   {
/* 49 */     return instance.idToTaskSetMap.containsKey(Integer.valueOf(taskSetId));
/*    */   }
/*    */   
/*    */   static TaskSet getTaskSetById(int taskSetId)
/*    */   {
/* 54 */     return (TaskSet)instance.idToTaskSetMap.get(Integer.valueOf(taskSetId));
/*    */   }
/*    */   
/*    */   public void checkCfg() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\TaskSetManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */