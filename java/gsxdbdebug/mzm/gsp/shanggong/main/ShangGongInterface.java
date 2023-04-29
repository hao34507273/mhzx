/*    */ package mzm.gsp.shanggong.main;
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
/*    */ public class ShangGongInterface
/*    */ {
/*    */   public static boolean startShangGongSyn(long roleid, int shanggongid)
/*    */   {
/* 20 */     return new PStartShangGong(roleid, shanggongid).call();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void startShangGongAsyn(long roleid, int shanggongid)
/*    */   {
/* 31 */     new PStartShangGong(roleid, shanggongid).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanggong\main\ShangGongInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */