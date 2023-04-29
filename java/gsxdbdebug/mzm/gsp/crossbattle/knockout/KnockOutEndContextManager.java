/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class KnockOutEndContextManager
/*    */   extends CrossBattleKnockOutContextManager<String, KnockOutEndContext>
/*    */ {
/*  8 */   private static final KnockOutEndContextManager instance = new KnockOutEndContextManager();
/*    */   
/*    */   public static KnockOutEndContextManager getInstance()
/*    */   {
/* 12 */     return instance;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\KnockOutEndContextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */