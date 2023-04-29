/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShengWuMFVManager
/*    */   extends AbsOMFVRankManager
/*    */ {
/*    */   private static ShengWuMFVManager instance;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static ShengWuMFVManager getInstance()
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
/* 28 */     instance = new ShengWuMFVManager(21);
/*    */   }
/*    */   
/*    */   public ShengWuMFVManager(int chartType)
/*    */   {
/* 33 */     super(chartType);
/*    */   }
/*    */   
/*    */ 
/*    */   int getOccChartType()
/*    */   {
/* 39 */     return 21;
/*    */   }
/*    */   
/*    */ 
/*    */   int getOccId()
/*    */   {
/* 45 */     return 6;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\ShengWuMFVManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */