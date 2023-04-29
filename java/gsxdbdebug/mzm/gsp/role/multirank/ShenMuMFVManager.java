/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ 
/*    */ public class ShenMuMFVManager
/*    */   extends AbsOMFVRankManager
/*    */ {
/*    */   private static ShenMuMFVManager instance;
/*    */   
/*    */ 
/*    */   static ShenMuMFVManager getInstance()
/*    */   {
/* 12 */     return instance;
/*    */   }
/*    */   
/*    */   public static void init() {
/* 16 */     if (instance == null) {
/* 17 */       instance = new ShenMuMFVManager(125);
/*    */     }
/*    */   }
/*    */   
/*    */   public ShenMuMFVManager(int var1) {
/* 22 */     super(var1);
/*    */   }
/*    */   
/*    */   int getOccChartType() {
/* 26 */     return 134;
/*    */   }
/*    */   
/*    */   int getOccId() {
/* 30 */     return 14;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\ShenMuMFVManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */