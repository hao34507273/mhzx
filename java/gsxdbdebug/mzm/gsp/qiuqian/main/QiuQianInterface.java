/*    */ package mzm.gsp.qiuqian.main;
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
/*    */ public class QiuQianInterface
/*    */ {
/*    */   public static boolean startQiuQianSyn(long roleid, int qiuqianid)
/*    */   {
/* 20 */     return new PStartQiuQian(roleid, qiuqianid).call();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void startQiuQianAsyn(long roleid, int qiuqianid)
/*    */   {
/* 31 */     new PStartQiuQian(roleid, qiuqianid).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qiuqian\main\QiuQianInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */