/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.Random;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.task.confbean.SSubSet;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TaskSubSet
/*    */ {
/*    */   private SSubSet subSet;
/*    */   
/*    */   public SSubSet getSubSet()
/*    */   {
/* 25 */     return this.subSet;
/*    */   }
/*    */   
/*    */   public void setSubSet(SSubSet subSet)
/*    */   {
/* 30 */     this.subSet = subSet;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Set<Integer> randomCanTakeTaskId(long roleId, Set<Integer> hasTaskIds, int graphId, int oldTaskId)
/*    */   {
/* 43 */     Set<Integer> ret = new HashSet();
/* 44 */     if (this.subSet.taskIds.size() <= 0)
/*    */     {
/* 46 */       return ret;
/*    */     }
/* 48 */     Random random = Xdb.random();
/* 49 */     for (int i = 0; i < 100; i++)
/*    */     {
/* 51 */       int ran = random.nextInt(this.subSet.taskIds.size());
/* 52 */       int taskId = ((Integer)this.subSet.taskIds.get(ran)).intValue();
/* 53 */       if ((!hasTaskIds.contains(Integer.valueOf(taskId))) && (!ret.contains(Integer.valueOf(taskId))) && (taskId != oldTaskId))
/*    */       {
/*    */ 
/*    */ 
/* 57 */         Task task = TaskManager.getTaskById(taskId);
/*    */         
/* 59 */         AcceptTaskCheckResult acRet = task.iscanTake(roleId, new HashMap(), new HashMap(), graphId);
/*    */         
/* 61 */         if (acRet.isCanTake())
/*    */         {
/* 63 */           ret.add(Integer.valueOf(taskId));
/* 64 */           if (ret.size() >= 1) {
/*    */             break;
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     Iterator i$;
/* 71 */     if (ret.size() < 1)
/*    */     {
/* 73 */       for (i$ = this.subSet.taskIds.iterator(); i$.hasNext();) { int taskId = ((Integer)i$.next()).intValue();
/*    */         
/* 75 */         if ((!ret.contains(Integer.valueOf(taskId))) && (!hasTaskIds.contains(Integer.valueOf(taskId))))
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 81 */           Task task = TaskManager.getTaskById(taskId);
/* 82 */           AcceptTaskCheckResult acRet = task.iscanTake(roleId, new HashMap(), new HashMap(), graphId);
/*    */           
/* 84 */           if (acRet.isCanTake())
/*    */           {
/* 86 */             ret.add(Integer.valueOf(taskId));
/* 87 */             if (ret.size() >= 1) {
/*    */               break;
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/* 94 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\TaskSubSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */