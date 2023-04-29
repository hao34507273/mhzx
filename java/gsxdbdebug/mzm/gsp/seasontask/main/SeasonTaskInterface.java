/*    */ package mzm.gsp.seasontask.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SeasonTaskInterface
/*    */ {
/*    */   public static int getSeasonSingleActivityId()
/*    */   {
/* 12 */     return SummerTaskManager.getSingleActivityId();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getAllSingleStorageExp(long roleId)
/*    */   {
/* 23 */     return SummerTaskManager.getSingleCircleCanGetStorageExp(roleId);
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
/*    */ 
/*    */   public static int getSingleCountStorageExp(long roleId, int ring)
/*    */   {
/* 37 */     return SummerTaskManager.getSingleActivityXRingStorageExp(roleId, ring);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\seasontask\main\SeasonTaskInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */