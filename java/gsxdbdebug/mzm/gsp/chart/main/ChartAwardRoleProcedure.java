/*    */ package mzm.gsp.chart.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.award.main.AwardModel;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.mail.main.MailAttachment;
/*    */ import mzm.gsp.mail.main.MailInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Role2properties;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChartAwardRoleProcedure
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int chartType;
/*    */   private final int rank;
/*    */   private final long roleid;
/*    */   private final int awardid;
/*    */   private final int awardHonorid;
/*    */   private final int rankMail;
/*    */   
/*    */   public ChartAwardRoleProcedure(int chartType, int rank, long roleid, int awardid, int awardHonorid, int rankMail)
/*    */   {
/* 34 */     this.chartType = chartType;
/* 35 */     this.rank = rank;
/* 36 */     this.roleid = roleid;
/* 37 */     this.awardid = awardid;
/* 38 */     this.awardHonorid = awardHonorid;
/* 39 */     this.rankMail = rankMail;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 44 */     String userid = RoleInterface.getUserId(this.roleid);
/*    */     
/* 46 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 48 */     lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 49 */     GameServer.logger().info(String.format("[Chart]ChartAwardRoleProcedure.processImp@award role|roleid=%d|chartType=%d|rank=%d|awardid=%d|awardHonorid=%d|mailid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.chartType), Integer.valueOf(this.rank), Integer.valueOf(this.awardid), Integer.valueOf(this.awardHonorid), Integer.valueOf(this.rankMail) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 56 */     AwardModel awardModel = AwardInterface.getRoleFixAwardModel(this.awardid, this.roleid, new AwardReason(LogReason.CHART_AWARD));
/*    */     
/* 58 */     if (awardModel == null) {
/* 59 */       GameServer.logger().info(String.format("[Chart]ChartAwardRoleProcedure.processImp@awardModel null|roleid=%d|chartType=%d|rank=%d|awardid=%d|mailid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.chartType), Integer.valueOf(this.rank), Integer.valueOf(this.awardid), Integer.valueOf(this.rankMail) }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 68 */     if (this.awardHonorid > 0) {
/* 69 */       AwardInterface.awardFixAward(this.awardHonorid, userid, this.roleid, false, false, new AwardReason(LogReason.CHART_AWARD, this.awardHonorid));
/*    */     }
/*    */     
/* 72 */     MailAttachment mailAttachment = null;
/* 73 */     if (awardModel != null) {
/* 74 */       mailAttachment = AwardInterface.getMailAttachmentBy(awardModel);
/*    */     } else {
/* 76 */       mailAttachment = new MailAttachment();
/*    */     }
/* 78 */     List<String> titleStrings = null;
/* 79 */     List<String> contentStrings = new ArrayList();
/* 80 */     contentStrings.add(String.valueOf(this.rank));
/* 81 */     MailInterface.synBuildAndSendMail(this.roleid, this.rankMail, titleStrings, contentStrings, mailAttachment, new TLogArg(LogReason.CHART_AWARD, this.awardid));
/*    */     
/* 83 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\ChartAwardRoleProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */