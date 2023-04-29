/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.award.main.AwardModel;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.mail.main.MailAttachment;
/*    */ import mzm.gsp.mail.main.MailInterface;
/*    */ import mzm.gsp.shitu.confbean.SShiTuTaskCfg;
/*    */ import mzm.gsp.shitu.confbean.SShiTuTaskConsts;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PSendShiTuTaskReward
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long masterRoleId;
/*    */   private final Set<Integer> rewardTaskIdSet;
/*    */   
/*    */   public PSendShiTuTaskReward(long masterRoleId, Set<Integer> rewardTaskIdSet)
/*    */   {
/* 26 */     this.masterRoleId = masterRoleId;
/* 27 */     this.rewardTaskIdSet = rewardTaskIdSet;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     if (!ShiTuManager.isShiTuTaskOpen(this.masterRoleId))
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     List<AwardModel> awardModelList = null;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 43 */     AwardReason taskAwardReason = new AwardReason(LogReason.SHI_TU_TASK_MASTER_MAIL_AWARD);
/* 44 */     taskAwardReason.setJustQuery(true);
/*    */     
/* 46 */     for (Iterator i$ = this.rewardTaskIdSet.iterator(); i$.hasNext();) { int taskId = ((Integer)i$.next()).intValue();
/*    */       
/*    */ 
/* 49 */       SShiTuTaskCfg sShiTuTaskCfg = SShiTuTaskCfg.get(taskId);
/* 50 */       if ((sShiTuTaskCfg != null) && (sShiTuTaskCfg.master_reward_id > 0))
/*    */       {
/*    */         AwardModel awardModel;
/*    */         
/*    */         AwardModel awardModel;
/* 55 */         if (sShiTuTaskCfg.master_reward_type == 2)
/*    */         {
/* 57 */           awardModel = AwardInterface.getRoleFixAwardModel(sShiTuTaskCfg.master_reward_id, this.masterRoleId, taskAwardReason);
/*    */ 
/*    */         }
/*    */         else
/*    */         {
/* 62 */           awardModel = AwardInterface.getRoleAwardModel(sShiTuTaskCfg.master_reward_id, this.masterRoleId, -1, taskAwardReason);
/*    */         }
/*    */         
/* 65 */         if (awardModel != null)
/*    */         {
/*    */ 
/*    */ 
/* 69 */           if (awardModelList == null)
/*    */           {
/* 71 */             awardModelList = new ArrayList();
/*    */           }
/* 73 */           awardModelList.add(awardModel);
/*    */         }
/*    */       } }
/* 76 */     if ((awardModelList != null) && (awardModelList.size() > 0))
/*    */     {
/* 78 */       MailAttachment mailAttachment = new MailAttachment();
/* 79 */       AwardInterface.fillMailAttachMentBy(awardModelList, mailAttachment);
/* 80 */       MailInterface.synBuildAndSendMail(this.masterRoleId, SShiTuTaskConsts.getInstance().APPRENTICE_AWARD_MAIL_ID, new ArrayList(), new ArrayList(), mailAttachment, new TLogArg(LogReason.SHI_TU_TASK_AWARD_MODEL_MAIl_AWARD));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 85 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PSendShiTuTaskReward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */