/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ 
/*    */ public class TaskStateObManager
/*    */ {
/*  9 */   private static List<TaskFinishHandler> taskFinishObList = Collections.synchronizedList(new ArrayList());
/*    */   
/*    */   public static List<TaskFinishHandler> getTaskFinishObList()
/*    */   {
/* 13 */     return taskFinishObList;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean registerTaskFinishImpl(TaskFinishHandler taskFinishOber)
/*    */     throws Exception
/*    */   {
/* 25 */     if (taskFinishObList.contains(taskFinishOber))
/*    */     {
/* 27 */       throw new Exception("注册监听任务完成类已经被注册了" + taskFinishOber.getClass().getName());
/*    */     }
/* 29 */     return taskFinishObList.add(taskFinishOber);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean unRegisterTaskFinishImpl(TaskFinishHandler taskFinishOber)
/*    */     throws Exception
/*    */   {
/* 40 */     if (!taskFinishObList.contains(taskFinishOber))
/*    */     {
/* 42 */       throw new Exception("监听任务完成类没有被注册了" + taskFinishOber.getClass().getName());
/*    */     }
/* 44 */     return taskFinishObList.remove(taskFinishOber);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\TaskStateObManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */