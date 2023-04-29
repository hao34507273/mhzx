/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ public class RecallRechargeRebateDoneArg
/*    */ {
/*    */   public final int retcode;
/*    */   public final String openid;
/*    */   public final int rebate;
/*    */   public final long serialNo;
/*    */   public final Octets context;
/*    */   
/*    */   public RecallRechargeRebateDoneArg(int retcode, String openid, int rebate, long serialNo, Octets context)
/*    */   {
/* 16 */     this.retcode = retcode;
/* 17 */     this.openid = openid;
/* 18 */     this.rebate = rebate;
/* 19 */     this.serialNo = serialNo;
/* 20 */     this.context = context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\RecallRechargeRebateDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */