/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AntiAddictProxyDoneArg
/*    */ {
/*    */   private final int retcode;
/*    */   private final String proxyReqInfo;
/*    */   private final String proxyRspInfo;
/*    */   private final Octets context;
/*    */   
/*    */   public AntiAddictProxyDoneArg(int retcode, String proxyReqInfo, String proxyRspInfo, Octets context)
/*    */   {
/* 17 */     this.retcode = retcode;
/* 18 */     this.proxyReqInfo = proxyReqInfo;
/* 19 */     this.proxyRspInfo = proxyRspInfo;
/* 20 */     this.context = context;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean isSucceed()
/*    */   {
/* 30 */     return this.retcode == 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean isTimeout()
/*    */   {
/* 40 */     return this.retcode == 8;
/*    */   }
/*    */   
/*    */   public final int getRetCode()
/*    */   {
/* 45 */     return this.retcode;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final String getProxyReqInfo()
/*    */   {
/* 55 */     return this.proxyReqInfo;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final String getProxyRspInfo()
/*    */   {
/* 66 */     return this.proxyRspInfo;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final Octets getContext()
/*    */   {
/* 76 */     return this.context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\AntiAddictProxyDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */