/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.util.TaskOneByOne;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TeamEventOneByOne
/*    */ {
/* 12 */   private TaskOneByOne oneByOne = new TaskOneByOne();
/*    */   
/* 14 */   private static final TeamEventOneByOne instance = new TeamEventOneByOne();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static TeamEventOneByOne getInstance()
/*    */   {
/* 22 */     return instance;
/*    */   }
/*    */   
/*    */   public TaskOneByOne getOneByOne()
/*    */   {
/* 27 */     return this.oneByOne;
/*    */   }
/*    */   
/*    */   public int taskSize() {
/* 31 */     return this.oneByOne.size();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\TeamEventOneByOne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */