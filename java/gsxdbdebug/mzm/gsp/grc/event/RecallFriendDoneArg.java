/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.grc.main.RecallResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RecallFriendDoneArg
/*    */ {
/*    */   public final int retcode;
/*    */   public final String openid;
/*    */   public final String friendOpenid;
/*    */   public final long serialNo;
/*    */   public final Octets context;
/*    */   public final RecallResponse recallResponse;
/*    */   
/*    */   public RecallFriendDoneArg(int retcode, String openid, String friendOpenid, long serialNo, Octets context, RecallResponse recallResponse)
/*    */   {
/* 19 */     this.retcode = retcode;
/* 20 */     this.openid = openid;
/* 21 */     this.friendOpenid = friendOpenid;
/* 22 */     this.serialNo = serialNo;
/* 23 */     this.context = context;
/* 24 */     this.recallResponse = recallResponse;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\RecallFriendDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */