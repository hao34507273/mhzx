/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SendBindMailDoneArg
/*    */ {
/*    */   public final int retcode;
/*    */   public final String openid;
/*    */   public final String friendOpenid;
/*    */   public final long serialNo;
/*    */   public final Octets context;
/*    */   public final String friendName;
/*    */   
/*    */   public SendBindMailDoneArg(int retcode, String openid, String friendOpenid, long serialNo, Octets context, String friendName)
/*    */   {
/* 18 */     this.retcode = retcode;
/* 19 */     this.openid = openid;
/* 20 */     this.friendOpenid = friendOpenid;
/* 21 */     this.serialNo = serialNo;
/* 22 */     this.context = context;
/* 23 */     this.friendName = friendName;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\SendBindMailDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */