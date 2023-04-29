/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.item.event.OpenNewStorageArg;
/*    */ import mzm.gsp.item.event.OpenNewStorageProcedure;
/*    */ 
/*    */ public class POnOpenNewStorage
/*    */   extends OpenNewStorageProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((OpenNewStorageArg)this.arg).roleId, 4802, null, "POnOpenNewStorage.processImp@handle STORAGE_GRID_COUNT success");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnOpenNewStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */