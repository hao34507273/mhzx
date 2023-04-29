/*    */ package mzm.gsp.feisheng.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.server.main.ServerInterface;
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
/*    */ 
/*    */ 
/*    */ public class FeiShengInterface
/*    */ {
/*    */   public static boolean isFeiShengActivityComplete(long roleid, int level, boolean isRetainLock)
/*    */   {
/* 24 */     return FeiShengManager.isFeiShengActivityComplete(roleid, level, isRetainLock);
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
/*    */ 
/*    */   public static boolean checkRoleCanFeiSheng(long roleid, int level, boolean isRetainLock)
/*    */   {
/* 39 */     if (!FeiShengManager.isFeiShengActivityComplete(roleid, level, isRetainLock))
/*    */     {
/* 41 */       return false;
/*    */     }
/* 43 */     return ServerInterface.getCurrentServerLevel() > RoleInterface.getLevel(roleid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\main\FeiShengInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */