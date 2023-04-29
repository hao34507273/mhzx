/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShiTuInterface
/*    */ {
/*    */   public static boolean isExistShiTuRelation(long roleIdA, long roleIdB)
/*    */   {
/* 14 */     return ShiTuManager.isExistShiTuRelation(roleIdA, roleIdB);
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
/*    */   public static boolean isExistShiTuRelation(long roleId, boolean isRemainRoleLock)
/*    */   {
/* 28 */     return ShiTuManager.isExistShiTuRelation(roleId, isRemainRoleLock);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\ShiTuInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */