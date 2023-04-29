/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import grc.GrcReceiveGiftArg;
/*    */ import grc.GrcReceiveGiftRes;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnReceiveGiftReponse
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final GrcReceiveGiftArg arg;
/*    */   private final GrcReceiveGiftRes res;
/*    */   
/*    */   public POnReceiveGiftReponse(GrcReceiveGiftArg arg, GrcReceiveGiftRes res)
/*    */   {
/* 15 */     this.arg = arg;
/* 16 */     this.res = res;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     return GrcManager.onReceiveGiftResponse(this.arg, this.res);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnReceiveGiftReponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */