/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.grc.event.ReportAccountInfoDoneArg;
/*    */ import mzm.gsp.grc.event.ReportAccountInfoDoneProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnReportAccountInfoDone extends ReportAccountInfoDoneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     int retcode = ((ReportAccountInfoDoneArg)this.arg).retcode;
/* 14 */     if (retcode == 0)
/*    */     {
/* 16 */       GameServer.logger().info(String.format("[recall]POnReportAccountInfoDone.processImp@success|openid=%s|login_time=%d|max_level=%d", new Object[] { ((ReportAccountInfoDoneArg)this.arg).openid, Long.valueOf(((ReportAccountInfoDoneArg)this.arg).loginTime), Integer.valueOf(((ReportAccountInfoDoneArg)this.arg).maxLevel) }));
/*    */       
/*    */ 
/* 19 */       return true;
/*    */     }
/*    */     
/* 22 */     OctetsStream os = new OctetsStream(((ReportAccountInfoDoneArg)this.arg).context);
/* 23 */     ReportRoleBasicInfoContext context = new ReportRoleBasicInfoContext();
/* 24 */     context.unmarshal(os);
/*    */     
/* 26 */     long roleid = context.roleid;
/* 27 */     int count = context.count;
/* 28 */     GameServer.logger().error(String.format("[recall]POnReportAccountInfoDone.processImp@failed|retcode=%d|openid=%s|login_time=%d|max_level=%d|roleid=%d|count=%d", new Object[] { Integer.valueOf(retcode), ((ReportAccountInfoDoneArg)this.arg).openid, Long.valueOf(((ReportAccountInfoDoneArg)this.arg).loginTime), Integer.valueOf(((ReportAccountInfoDoneArg)this.arg).maxLevel), Long.valueOf(roleid), Integer.valueOf(count) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 33 */     if (count >= 3)
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     context.count += 1;
/* 39 */     OctetsStream osContext = new OctetsStream();
/* 40 */     context.marshal(osContext);
/*    */     
/* 42 */     if (!GrcManager.reportRoleBasicInfo(((ReportAccountInfoDoneArg)this.arg).openid, ((ReportAccountInfoDoneArg)this.arg).loginTime, ((ReportAccountInfoDoneArg)this.arg).maxLevel, osContext))
/*    */     {
/* 44 */       GameServer.logger().error(String.format("[recall]POnReportAccountInfoDone.processImp@send failed|retcode=%d|openid=%s|login_time=%d|max_level=%d|roleid=%d|count=%d", new Object[] { Integer.valueOf(retcode), ((ReportAccountInfoDoneArg)this.arg).openid, Long.valueOf(((ReportAccountInfoDoneArg)this.arg).loginTime), Integer.valueOf(((ReportAccountInfoDoneArg)this.arg).maxLevel), Long.valueOf(roleid), Integer.valueOf(count) }));
/*    */       
/*    */ 
/*    */ 
/* 48 */       return false;
/*    */     }
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnReportAccountInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */