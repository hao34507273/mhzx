/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HeHuanMFVManager
/*    */   extends AbsOMFVRankManager
/*    */ {
/*    */   private static HeHuanMFVManager instance;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static HeHuanMFVManager getInstance()
/*    */   {
/* 19 */     return instance;
/*    */   }
/*    */   
/*    */   public static void init()
/*    */   {
/* 24 */     if (instance != null)
/*    */     {
/* 26 */       return;
/*    */     }
/* 28 */     instance = new HeHuanMFVManager(20);
/*    */   }
/*    */   
/*    */   public HeHuanMFVManager(int chartType)
/*    */   {
/* 33 */     super(chartType);
/*    */   }
/*    */   
/*    */ 
/*    */   int getOccChartType()
/*    */   {
/* 39 */     return 20;
/*    */   }
/*    */   
/*    */ 
/*    */   int getOccId()
/*    */   {
/* 45 */     return 5;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\HeHuanMFVManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */