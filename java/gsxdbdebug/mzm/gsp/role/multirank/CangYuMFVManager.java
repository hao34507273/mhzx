/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CangYuMFVManager
/*    */   extends AbsOMFVRankManager
/*    */ {
/*    */   private static CangYuMFVManager instance;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static CangYuMFVManager getInstance()
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
/* 28 */     instance = new CangYuMFVManager(26);
/*    */   }
/*    */   
/*    */   public CangYuMFVManager(int chartType)
/*    */   {
/* 33 */     super(chartType);
/*    */   }
/*    */   
/*    */ 
/*    */   int getOccChartType()
/*    */   {
/* 39 */     return 26;
/*    */   }
/*    */   
/*    */ 
/*    */   int getOccId()
/*    */   {
/* 45 */     return 7;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\CangYuMFVManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */