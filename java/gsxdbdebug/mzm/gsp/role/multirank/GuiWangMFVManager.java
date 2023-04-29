/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuiWangMFVManager
/*    */   extends AbsOMFVRankManager
/*    */ {
/*    */   private static GuiWangMFVManager instance;
/*    */   
/*    */ 
/*    */   static GuiWangMFVManager getInstance()
/*    */   {
/* 13 */     return instance;
/*    */   }
/*    */   
/*    */   public static void init()
/*    */   {
/* 18 */     if (instance != null)
/*    */     {
/* 20 */       return;
/*    */     }
/* 22 */     instance = new GuiWangMFVManager(16);
/*    */   }
/*    */   
/*    */   public GuiWangMFVManager(int chartType)
/*    */   {
/* 27 */     super(chartType);
/*    */   }
/*    */   
/*    */ 
/*    */   int getOccChartType()
/*    */   {
/* 33 */     return 16;
/*    */   }
/*    */   
/*    */ 
/*    */   int getOccId()
/*    */   {
/* 39 */     return 1;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\GuiWangMFVManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */