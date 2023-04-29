/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QingYunMFVManager
/*    */   extends AbsOMFVRankManager
/*    */ {
/*    */   private static QingYunMFVManager instance;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static QingYunMFVManager getInstance()
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
/* 28 */     instance = new QingYunMFVManager(17);
/*    */   }
/*    */   
/*    */   public QingYunMFVManager(int chartType)
/*    */   {
/* 33 */     super(chartType);
/*    */   }
/*    */   
/*    */ 
/*    */   int getOccChartType()
/*    */   {
/* 39 */     return 17;
/*    */   }
/*    */   
/*    */ 
/*    */   int getOccId()
/*    */   {
/* 45 */     return 2;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\QingYunMFVManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */