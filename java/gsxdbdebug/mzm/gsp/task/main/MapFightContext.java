/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ 
/*    */ public class MapFightContext
/*    */   implements FightContext
/*    */ {
/*    */   private int mapId;
/*    */   private int graphId;
/*    */   private int taskId;
/*    */   private int taskState;
/*    */   private List<Long> roleList;
/*    */   private List<Long> roleListHaveSameTask;
/*    */   
/*    */   public boolean isRecordEnable()
/*    */   {
/* 19 */     return false;
/*    */   }
/*    */   
/*    */   public int getMapId()
/*    */   {
/* 24 */     return this.mapId;
/*    */   }
/*    */   
/*    */   public void setMapId(int mapId)
/*    */   {
/* 29 */     this.mapId = mapId;
/*    */   }
/*    */   
/*    */   public int getGraphId()
/*    */   {
/* 34 */     return this.graphId;
/*    */   }
/*    */   
/*    */   public void setGraphId(int graphId)
/*    */   {
/* 39 */     this.graphId = graphId;
/*    */   }
/*    */   
/*    */   public int getTaskId()
/*    */   {
/* 44 */     return this.taskId;
/*    */   }
/*    */   
/*    */   public void setTaskId(int taskId)
/*    */   {
/* 49 */     this.taskId = taskId;
/*    */   }
/*    */   
/*    */   public int getTaskState()
/*    */   {
/* 54 */     return this.taskState;
/*    */   }
/*    */   
/*    */   public void setTaskState(int taskState)
/*    */   {
/* 59 */     this.taskState = taskState;
/*    */   }
/*    */   
/*    */   public List<Long> getRoleList()
/*    */   {
/* 64 */     return this.roleList;
/*    */   }
/*    */   
/*    */   public void setRoleList(List<Long> roleList)
/*    */   {
/* 69 */     this.roleList = roleList;
/*    */   }
/*    */   
/*    */   public List<Long> getRoleListHaveSameTask()
/*    */   {
/* 74 */     return this.roleListHaveSameTask;
/*    */   }
/*    */   
/*    */   public void setRoleListHaveSameTask(List<Long> roleListHaveSameTask)
/*    */   {
/* 79 */     this.roleListHaveSameTask = roleListHaveSameTask;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\MapFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */