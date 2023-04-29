/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class ReportCorpsPointRaceDoneArg
/*    */ {
/*    */   private final int retcode;
/*    */   private final Octets context;
/*    */   
/*    */   public ReportCorpsPointRaceDoneArg(int retcode, Octets context)
/*    */   {
/* 12 */     this.retcode = retcode;
/* 13 */     this.context = context;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean isSucceed()
/*    */   {
/* 23 */     return this.retcode == 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean isTimeout()
/*    */   {
/* 33 */     return this.retcode == 8;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getRetcode()
/*    */   {
/* 43 */     return this.retcode;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Octets getContext()
/*    */   {
/* 53 */     return this.context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\ReportCorpsPointRaceDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */