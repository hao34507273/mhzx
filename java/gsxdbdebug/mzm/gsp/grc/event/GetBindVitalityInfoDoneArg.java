/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.grc.main.GetBindVitalityInfoResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GetBindVitalityInfoDoneArg
/*    */ {
/*    */   public final int retcode;
/*    */   public final String openid;
/*    */   public final Octets context;
/*    */   public final GetBindVitalityInfoResponse response;
/*    */   
/*    */   public GetBindVitalityInfoDoneArg(int retcode, String openid, Octets context, GetBindVitalityInfoResponse response)
/*    */   {
/* 17 */     this.retcode = retcode;
/* 18 */     this.openid = openid;
/* 19 */     this.context = context;
/* 20 */     this.response = response;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\GetBindVitalityInfoDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */