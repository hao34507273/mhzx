/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import grc.GrcReceiveAllGiftArg;
/*    */ import grc.GrcReceiveAllGiftRes;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnReceiveAllGiftResponse extends LogicProcedure
/*    */ {
/*    */   private final GrcReceiveAllGiftArg arg;
/*    */   private final GrcReceiveAllGiftRes res;
/*    */   
/*    */   public POnReceiveAllGiftResponse(GrcReceiveAllGiftArg arg, GrcReceiveAllGiftRes res)
/*    */   {
/* 14 */     this.arg = arg;
/* 15 */     this.res = res;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     return GrcManager.onReceiveAllGiftResponse(this.arg, this.res);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnReceiveAllGiftResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */