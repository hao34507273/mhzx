/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ public class YinYangMFVManager
/*    */   extends AbsOMFVRankManager
/*    */ {
/*    */   private static YinYangMFVManager instance;
/*    */   
/*    */   static YinYangMFVManager getInstance()
/*    */   {
/* 10 */     return instance;
/*    */   }
/*    */   
/*    */   public static void init()
/*    */   {
/* 15 */     if (instance != null) {
/* 16 */       return;
/*    */     }
/* 18 */     instance = new YinYangMFVManager(120);
/*    */   }
/*    */   
/*    */   public YinYangMFVManager(int paramInt)
/*    */   {
/* 23 */     super(paramInt);
/*    */   }
/*    */   
/*    */   int getOccChartType()
/*    */   {
/* 28 */     return 120;
/*    */   }
/*    */   
/*    */   int getOccId()
/*    */   {
/* 33 */     return 12;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\YinYangMFVManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */