/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ public class HuangJinMFVManager
/*    */   extends AbsOMFVRankManager
/*    */ {
/*    */   private static HuangJinMFVManager instance;
/*    */   
/*    */   static HuangJinMFVManager getInstance()
/*    */   {
/* 10 */     return instance;
/*    */   }
/*    */   
/*    */   public static void init()
/*    */   {
/* 15 */     if (instance != null) {
/* 16 */       return;
/*    */     }
/* 18 */     instance = new HuangJinMFVManager(125);
/*    */   }
/*    */   
/*    */   public HuangJinMFVManager(int paramInt)
/*    */   {
/* 23 */     super(paramInt);
/*    */   }
/*    */   
/*    */   int getOccChartType()
/*    */   {
/* 28 */     return 125;
/*    */   }
/*    */   
/*    */   int getOccId()
/*    */   {
/* 33 */     return 13;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\HuangJinMFVManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */