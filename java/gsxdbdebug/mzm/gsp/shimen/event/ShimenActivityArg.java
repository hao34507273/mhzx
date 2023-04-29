/*    */ package mzm.gsp.shimen.event;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.task.main.TaskEventArg.TaskItemConditionInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShimenActivityArg
/*    */ {
/*    */   private long roleid;
/*    */   private int activityId;
/*    */   private int oldcount;
/*    */   private int newcount;
/*    */   private final Set<TaskEventArg.TaskItemConditionInfo> handUpItemInfos;
/*    */   
/*    */   public ShimenActivityArg(long roleid, int activityid, int oldcount, int newcount, Set<TaskEventArg.TaskItemConditionInfo> handUpItemInfos)
/*    */   {
/* 20 */     this.roleid = roleid;
/* 21 */     this.activityId = activityid;
/* 22 */     this.oldcount = oldcount;
/* 23 */     this.newcount = newcount;
/* 24 */     this.handUpItemInfos = handUpItemInfos;
/*    */   }
/*    */   
/*    */   public int getActivityId()
/*    */   {
/* 29 */     return this.activityId;
/*    */   }
/*    */   
/*    */   public int getOldcount()
/*    */   {
/* 34 */     return this.oldcount;
/*    */   }
/*    */   
/*    */   public int getNewcount()
/*    */   {
/* 39 */     return this.newcount;
/*    */   }
/*    */   
/*    */   public long getRoleid()
/*    */   {
/* 44 */     return this.roleid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Set<TaskEventArg.TaskItemConditionInfo> getHandUpItemInfos()
/*    */   {
/* 54 */     Set<TaskEventArg.TaskItemConditionInfo> infos = new HashSet();
/* 55 */     infos.addAll(this.handUpItemInfos);
/* 56 */     return infos;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shimen\event\ShimenActivityArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */