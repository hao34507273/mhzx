/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import grc.GrcUserBackInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BackDoneArg
/*    */ {
/*    */   public final int retcode;
/*    */   public final String openid;
/*    */   public final int activityCfgid;
/*    */   public final long serialNo;
/*    */   public final Octets context;
/*    */   public final GrcUserBackInfo userBackInfo;
/*    */   
/*    */   public BackDoneArg(int retcode, String openid, int activityCfgid, long serialNo, Octets context, GrcUserBackInfo userBackInfo)
/*    */   {
/* 19 */     this.retcode = retcode;
/* 20 */     this.openid = openid;
/* 21 */     this.activityCfgid = activityCfgid;
/* 22 */     this.serialNo = serialNo;
/* 23 */     this.context = context;
/* 24 */     this.userBackInfo = userBackInfo;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\BackDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */