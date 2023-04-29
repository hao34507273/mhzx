/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.buff.main.BuffInterface;
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
/*    */ public class UseDrugManager
/*    */ {
/*    */   public static int checkCollisionBuff(long roleId, int itemId)
/*    */   {
/* 23 */     Integer buffId = getBuffId(itemId);
/* 24 */     if (buffId == null)
/*    */     {
/* 26 */       return -1;
/*    */     }
/* 28 */     return BuffInterface.getCollisionBuff(roleId, buffId.intValue());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static Integer getBuffId(int itemId)
/*    */   {
/* 39 */     return Integer.valueOf(0);
/*    */   }
/*    */   
/*    */   public static int getItemBuff(int itemId)
/*    */   {
/* 44 */     return getBuffId(itemId).intValue();
/*    */   }
/*    */   
/*    */   public static boolean useDrag(long roleId, int itemId, int bagKey)
/*    */   {
/* 49 */     Integer buffId = getBuffId(itemId);
/* 50 */     if (buffId == null)
/*    */     {
/* 52 */       return false;
/*    */     }
/* 54 */     BuffInterface.installBuff(roleId, buffId.intValue());
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\UseDrugManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */