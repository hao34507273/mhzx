/*    */ package mzm.gsp.addiction.main;
/*    */ 
/*    */ import mzm.gsp.addiction.handler.HandlerManager;
/*    */ import mzm.gsp.addiction.pro.ProManager;
/*    */ import mzm.gsp.addiction.pro.core.PkgHead;
/*    */ import mzm.gsp.grc.event.AntiAddictProxyDoneArg;
/*    */ 
/*    */ public class POnAntiAddictProxyDone extends mzm.gsp.grc.event.AntiAddictProxyDoneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     String queryInfo = ((AntiAddictProxyDoneArg)this.arg).getProxyReqInfo();
/* 13 */     PkgHead header = ProManager.getHeader(queryInfo);
/* 14 */     if (!((AntiAddictProxyDoneArg)this.arg).isSucceed())
/*    */     {
/* 16 */       HandlerManager.onFailed(header.msg_type, ((AntiAddictProxyDoneArg)this.arg).getRetCode(), queryInfo, ((AntiAddictProxyDoneArg)this.arg).getContext());
/* 17 */       return true;
/*    */     }
/*    */     
/* 20 */     HandlerManager.handle(header.msg_type, ((AntiAddictProxyDoneArg)this.arg).getProxyRspInfo());
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\main\POnAntiAddictProxyDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */