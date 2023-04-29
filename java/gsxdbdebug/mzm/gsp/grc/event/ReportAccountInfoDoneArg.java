/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ public class ReportAccountInfoDoneArg
/*    */ {
/*    */   public final int retcode;
/*    */   public final String openid;
/*    */   public final long loginTime;
/*    */   public final int maxLevel;
/*    */   public final Octets context;
/*    */   
/*    */   public ReportAccountInfoDoneArg(int retcode, String openid, long loginTime, int maxLevel, Octets context)
/*    */   {
/* 16 */     this.retcode = retcode;
/* 17 */     this.openid = openid;
/* 18 */     this.loginTime = loginTime;
/* 19 */     this.maxLevel = maxLevel;
/* 20 */     this.context = context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\ReportAccountInfoDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */