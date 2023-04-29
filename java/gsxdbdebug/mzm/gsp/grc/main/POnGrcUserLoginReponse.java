/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import grc.GrcUserLoginArg;
/*    */ import grc.GrcUserLoginRes;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnGrcUserLoginReponse extends LogicProcedure
/*    */ {
/*    */   private final GrcUserLoginArg arg;
/*    */   private final GrcUserLoginRes res;
/*    */   
/*    */   public POnGrcUserLoginReponse(GrcUserLoginArg arg, GrcUserLoginRes res)
/*    */   {
/* 14 */     this.arg = arg;
/* 15 */     this.res = res;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     return GrcManager.onGrcUserLoginResponse(this.arg, this.res);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnGrcUserLoginReponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */