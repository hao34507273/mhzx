/*    */ package mzm.gsp.grow.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.award.main.AwardModel;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.grow.confbean.SEveryDayTargetCfg;
/*    */ import mzm.gsp.grow.confbean.TargetConsts;
/*    */ import mzm.gsp.mail.main.MailAttachment;
/*    */ import mzm.gsp.mail.main.MailInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.DayTargetInfo;
/*    */ import xbean.TargetInfo;
/*    */ import xtable.Role2daytargetinfo;
/*    */ 
/*    */ public class PGM_FlushTarget
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int isNeedMail;
/*    */   
/*    */   public PGM_FlushTarget(long roleId, int isNeedMail)
/*    */   {
/* 27 */     this.roleId = roleId;
/* 28 */     this.isNeedMail = isNeedMail;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 33 */     DayTargetInfo xDayTargetInfo = Role2daytargetinfo.get(Long.valueOf(this.roleId));
/* 34 */     if (xDayTargetInfo == null) {
/* 35 */       return false;
/*    */     }
/* 37 */     for (TargetInfo xTargetInfo : xDayTargetInfo.getTargets().values()) {
/* 38 */       if (xTargetInfo.getTargetstate() == 2)
/*    */       {
/*    */ 
/* 41 */         if (this.isNeedMail == 1) {
/* 42 */           SEveryDayTargetCfg sCfg = (SEveryDayTargetCfg)TargetManager.getTarget2cfg().get(Integer.valueOf(xTargetInfo.getTargettype()));
/* 43 */           if (sCfg == null) {
/* 44 */             return false;
/*    */           }
/* 46 */           AwardReason reason = new AwardReason(LogReason.EVERY_DAY_TARGET_CHECK_AWARD);
/* 47 */           AwardModel awardModel = AwardInterface.getRoleAwardModel(sCfg.awardId, this.roleId, -1, reason);
/* 48 */           MailAttachment attachment = new MailAttachment();
/* 49 */           if (!TargetManager.fillAttach(awardModel, attachment)) {
/* 50 */             return false;
/*    */           }
/*    */           
/* 53 */           MailInterface.asynBuildAndSendMail(this.roleId, TargetConsts.getInstance().REISSUE_MAIL_ID, new ArrayList(), new ArrayList(), attachment, new TLogArg(LogReason.EVERY_DAY_TARGET_AWARD));
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 59 */     TargetManager.flushNewTarget(this.roleId, xDayTargetInfo);
/*    */     
/* 61 */     TargetManager.synTargetInfo(this.roleId, xDayTargetInfo);
/*    */     
/* 63 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\main\PGM_FlushTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */