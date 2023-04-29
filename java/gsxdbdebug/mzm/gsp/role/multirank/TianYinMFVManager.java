/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TianYinMFVManager
/*    */   extends AbsOMFVRankManager
/*    */ {
/*    */   private static TianYinMFVManager instance;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static TianYinMFVManager getInstance()
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
/* 28 */     instance = new TianYinMFVManager(18);
/*    */   }
/*    */   
/*    */   public TianYinMFVManager(int chartType)
/*    */   {
/* 33 */     super(chartType);
/*    */   }
/*    */   
/*    */ 
/*    */   int getOccChartType()
/*    */   {
/* 39 */     return 18;
/*    */   }
/*    */   
/*    */ 
/*    */   int getOccId()
/*    */   {
/* 45 */     return 3;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\TianYinMFVManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */