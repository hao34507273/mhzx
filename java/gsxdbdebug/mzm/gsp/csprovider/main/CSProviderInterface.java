/*    */ package mzm.gsp.csprovider.main;
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
/*    */ public class CSProviderInterface
/*    */ {
/*    */   public static void setRequireActivateUser(boolean value)
/*    */   {
/* 18 */     CSProviderManager.setRequireActivateUser(value);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean getRequireActivateUser()
/*    */   {
/* 28 */     return CSProviderManager.getRequireActivateUser();
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
/*    */ 
/*    */ 
/*    */   public static boolean useActivateCard(String userId, String cardNumber, int loginip)
/*    */   {
/* 45 */     return CSProviderManager.useActivateCard(userId, cardNumber, loginip);
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean useGiftCard(long roleId, String userId, String cardNumber, int loginip)
/*    */   {
/* 64 */     return CSProviderManager.useGiftCard(roleId, userId, cardNumber, loginip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\main\CSProviderInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */