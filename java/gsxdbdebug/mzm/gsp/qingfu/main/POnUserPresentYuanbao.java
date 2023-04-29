/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import mzm.gsp.qingfu.event.PresentYuanbaoArg;
/*    */ 
/*    */ public class POnUserPresentYuanbao extends mzm.gsp.qingfu.event.PresentYuanbaoProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception {
/*  8 */     if (!QingfuManager.isMidasMode)
/*    */     {
/* 10 */       return true;
/*    */     }
/*    */     
/* 13 */     xbean.QingfuInfo xQingfuInfo = xtable.Qingfu.get(((PresentYuanbaoArg)this.arg).userid);
/* 14 */     if (xQingfuInfo == null)
/*    */     {
/* 16 */       return false;
/*    */     }
/*    */     
/* 19 */     xbean.UserAuAnyCheckOrders xUserAuAnyCheckOrders = xtable.User2auanycheckorders.get(((PresentYuanbaoArg)this.arg).userid);
/* 20 */     if (xUserAuAnyCheckOrders == null)
/*    */     {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     xbean.CheckOrderInfo xCheckOrderInfo = xtable.Checkorders.get(((PresentYuanbaoArg)this.arg).billno);
/* 26 */     if ((xCheckOrderInfo == null) || (xCheckOrderInfo.getStatus() != 1))
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     return QingfuManager.sendTryCheckNextOrderReq(((PresentYuanbaoArg)this.arg).userid, ((PresentYuanbaoArg)this.arg).billno, xUserAuAnyCheckOrders, xCheckOrderInfo);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\POnUserPresentYuanbao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */