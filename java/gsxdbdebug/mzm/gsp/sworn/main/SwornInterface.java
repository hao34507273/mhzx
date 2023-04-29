/*    */ package mzm.gsp.sworn.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SwornInterface
/*    */ {
/*    */   public static boolean isRoleSworn(long roleId)
/*    */   {
/*  9 */     return SwornManager.isRoleSworn(roleId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static boolean isSameSworn(long roleId0, long roleId1)
/*    */   {
/* 16 */     return SwornManager.isSameSworn(roleId0, roleId1);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\SwornInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */