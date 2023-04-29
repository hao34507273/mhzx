/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.grc.main.GetVitalityRewardResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GetVitalityRewardDoneArg
/*    */ {
/*    */   public final int retcode;
/*    */   public final String openid;
/*    */   public final String friendOpenid;
/*    */   public final int bindType;
/*    */   public final long serialNo;
/*    */   public final Octets context;
/*    */   public final GetVitalityRewardResponse rsp;
/*    */   
/*    */   public GetVitalityRewardDoneArg(int retcode, String openid, String friendOpenid, int bindType, long serialNo, Octets context, GetVitalityRewardResponse rsp)
/*    */   {
/* 20 */     this.retcode = retcode;
/* 21 */     this.openid = openid;
/* 22 */     this.friendOpenid = friendOpenid;
/* 23 */     this.bindType = bindType;
/* 24 */     this.serialNo = serialNo;
/* 25 */     this.context = context;
/* 26 */     this.rsp = rsp;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\GetVitalityRewardDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */