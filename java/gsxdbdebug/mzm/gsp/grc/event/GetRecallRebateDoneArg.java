/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.grc.main.GetRecallRebateResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GetRecallRebateDoneArg
/*    */ {
/*    */   public final int retcode;
/*    */   public final String openid;
/*    */   public final int num;
/*    */   public final long serialNo;
/*    */   public final Octets context;
/*    */   public final GetRecallRebateResponse response;
/*    */   
/*    */   public GetRecallRebateDoneArg(int retcode, String openid, int num, long serialNo, Octets context, GetRecallRebateResponse response)
/*    */   {
/* 19 */     this.retcode = retcode;
/* 20 */     this.openid = openid;
/* 21 */     this.num = num;
/* 22 */     this.serialNo = serialNo;
/* 23 */     this.context = context;
/* 24 */     this.response = response;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\GetRecallRebateDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */