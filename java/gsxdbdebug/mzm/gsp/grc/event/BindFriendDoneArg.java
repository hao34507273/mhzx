/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.grc.main.BindFriendResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BindFriendDoneArg
/*    */ {
/*    */   public final int retcode;
/*    */   public final String openid;
/*    */   public final String friendOpenid;
/*    */   public final long serialNo;
/*    */   public final Octets context;
/*    */   public final BindFriendResponse rsp;
/*    */   
/*    */   public BindFriendDoneArg(int retcode, String openid, String friendOpenid, long serialNo, Octets context, BindFriendResponse rsp)
/*    */   {
/* 19 */     this.retcode = retcode;
/* 20 */     this.openid = openid;
/* 21 */     this.friendOpenid = friendOpenid;
/* 22 */     this.serialNo = serialNo;
/* 23 */     this.context = context;
/* 24 */     this.rsp = rsp;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\BindFriendDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */