/*    */ package mzm.gsp.jingji.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.confbean.JingjiActivityCfgConsts;
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.mail.main.MailAttachment;
/*    */ import mzm.gsp.mail.main.MailInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.JingJiDailyRank;
/*    */ import xtable.Jingjidailytrankbackup;
/*    */ 
/*    */ public class PRoleDailyAward extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int rewardid;
/*    */   private final int rank;
/*    */   
/*    */   public PRoleDailyAward(long roleid, int rewardid, int rank)
/*    */   {
/* 26 */     this.roleid = roleid;
/* 27 */     this.rewardid = rewardid;
/* 28 */     this.rank = rank;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 35 */     long key = GameServerInfoManager.getLocalId();
/* 36 */     JingJiDailyRank xJingJiDailyRank = Jingjidailytrankbackup.get(Long.valueOf(key));
/* 37 */     if (xJingJiDailyRank == null)
/*    */     {
/* 39 */       GameServer.logger().info(String.format("[jingji]PRoleDailyAward.processImp@xbean is null|roleid=%d|reward=%d|rank=%d", new Object[] { Integer.valueOf(this.rank), Integer.valueOf(this.rewardid), Integer.valueOf(this.rank) }));
/*    */       
/*    */ 
/* 42 */       return false;
/*    */     }
/* 44 */     xJingJiDailyRank.getRole_ranks().remove(Long.valueOf(this.roleid));
/*    */     
/*    */ 
/* 47 */     mzm.gsp.award.main.AwardModel model = AwardInterface.getRoleFixAwardModel(this.rewardid, this.roleid, new mzm.gsp.award.main.AwardReason(LogReason.JINGJI_DAY_JIFEN_AWARD, this.rewardid));
/*    */     
/* 49 */     if (model != null)
/*    */     {
/* 51 */       MailAttachment attachment = AwardInterface.getMailAttachmentBy(model);
/* 52 */       List<String> contentArgs = new ArrayList();
/* 53 */       contentArgs.add(String.valueOf(this.rank));
/* 54 */       TLogArg logArg = new TLogArg(LogReason.JINGJI_DAY_JIFEN_AWARD, this.rewardid);
/* 55 */       MailInterface.synBuildAndSendMail(this.roleid, JingjiActivityCfgConsts.getInstance().DAY_AWARD_MAIL_ID, new ArrayList(), contentArgs, attachment, logArg);
/*    */       
/*    */ 
/* 58 */       JingjiManager.logger.info(String.format("[jingji]PRoleDailyAward.processImp@offer day award to role success|roleid=%d|reward=%d|rank=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.rewardid), Integer.valueOf(this.rank) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 63 */       JingjiManager.addTLog(this.roleid, "JingjiDayAwardForServer", new Object[] { Integer.valueOf(this.rank), Integer.valueOf(this.rewardid) });
/*    */     }
/*    */     else
/*    */     {
/* 67 */       JingjiManager.logger.error(String.format("[jingji]PRoleDailyAward.processImp@award model is null|roleid=%d|reward=%d|rank=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.rewardid), Integer.valueOf(this.rank) }));
/*    */     }
/*    */     
/*    */ 
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\PRoleDailyAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */