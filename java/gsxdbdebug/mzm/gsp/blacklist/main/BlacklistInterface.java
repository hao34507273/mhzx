/*    */ package mzm.gsp.blacklist.main;
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
/*    */ public class BlacklistInterface
/*    */ {
/*    */   public static boolean isInBlacklist(long roleid, long targetRole)
/*    */   {
/* 19 */     return BlacklistManager.isInBlacklist(roleid, targetRole);
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
/*    */   public static boolean delBlackRole(long roleid, long targetRole)
/*    */   {
/* 32 */     return BlacklistManager.delBlackRole(roleid, targetRole);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\blacklist\main\BlacklistInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */