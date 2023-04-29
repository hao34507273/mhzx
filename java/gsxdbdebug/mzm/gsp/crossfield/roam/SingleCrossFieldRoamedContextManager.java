/*    */ package mzm.gsp.crossfield.roam;
/*    */ 
/*    */ import mzm.gsp.crossserver.main.SingleCrossFieldRoamedContext;
/*    */ import mzm.gsp.ladder.main.LadderContextManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SingleCrossFieldRoamedContextManager
/*    */   extends LadderContextManager<Long, SingleCrossFieldRoamedContext>
/*    */ {
/* 12 */   private static final SingleCrossFieldRoamedContextManager instance = new SingleCrossFieldRoamedContextManager();
/*    */   
/*    */   static SingleCrossFieldRoamedContextManager getInstance()
/*    */   {
/* 16 */     return instance;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\roam\SingleCrossFieldRoamedContextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */