/*     */ package mzm.gsp.birthdaypray.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.nationalholiday.confbean.SBirthdayPrayRewardCfg;
/*     */ import mzm.gsp.nationalholiday.confbean.SBirthdayPrayRewardInfo;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import xbean.WorldCounterInfo;
/*     */ import xbean.WorldCounterRewardInfo;
/*     */ import xbean.WorldCounterRewardStages;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PSendRewardMail extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityCfgId;
/*     */   private final WorldCounterInfo xWorldCounterInfo;
/*     */   private WorldCounterRewardInfo xWorldCounterRewardInfo;
/*     */   
/*     */   public PSendRewardMail(long roleid, int activityCfgid, WorldCounterInfo xWorldCounterInfo)
/*     */   {
/*  36 */     this.roleId = roleid;
/*  37 */     this.activityCfgId = activityCfgid;
/*  38 */     this.xWorldCounterInfo = xWorldCounterInfo;
/*     */   }
/*     */   
/*     */ 
/*     */   public PSendRewardMail(long roleid, int activityCfgid, WorldCounterInfo xWorldCounterInfo, WorldCounterRewardInfo xWorldCounterRewardInfo)
/*     */   {
/*  44 */     this(roleid, activityCfgid, xWorldCounterInfo);
/*  45 */     this.xWorldCounterRewardInfo = xWorldCounterRewardInfo;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  51 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*     */     
/*  53 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  55 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*  57 */     if (this.xWorldCounterRewardInfo == null)
/*     */     {
/*  59 */       this.xWorldCounterRewardInfo = BirthdayPrayManager.getWorldCounterRewardInfo(this.roleId, this.activityCfgId);
/*     */     }
/*     */     
/*  62 */     this.xWorldCounterRewardInfo.setSended_reward_mail(true);
/*     */     
/*  64 */     if (!ActivityInterface.isInActivityLevel(userId, this.roleId, this.activityCfgId))
/*     */     {
/*  66 */       return true;
/*     */     }
/*     */     
/*  69 */     SBirthdayPrayRewardCfg sBirthdayPrayRewardCfg = SBirthdayPrayRewardCfg.get(this.activityCfgId);
/*  70 */     if (sBirthdayPrayRewardCfg == null)
/*     */     {
/*  72 */       return true;
/*     */     }
/*     */     
/*     */ 
/*  76 */     for (Map.Entry<Integer, SBirthdayPrayRewardInfo> rewardEntry : sBirthdayPrayRewardCfg.taskActivityId2RewardInfo.entrySet())
/*     */     {
/*  78 */       Long times = (Long)this.xWorldCounterInfo.getIndex2times().get(rewardEntry.getKey());
/*  79 */       if (times != null)
/*     */       {
/*     */ 
/*     */ 
/*  83 */         int supportTimes = times.longValue() >= 2147483647L ? Integer.MAX_VALUE : times.intValue();
/*  84 */         WorldCounterRewardStages xWorldCounterRewardStages = (WorldCounterRewardStages)this.xWorldCounterRewardInfo.getIndex2reward_stages().get(rewardEntry.getKey());
/*  85 */         if (xWorldCounterRewardStages == null)
/*     */         {
/*  87 */           xWorldCounterRewardStages = xbean.Pod.newWorldCounterRewardStages();
/*  88 */           this.xWorldCounterRewardInfo.getIndex2reward_stages().put(rewardEntry.getKey(), xWorldCounterRewardStages);
/*     */         }
/*     */         
/*  91 */         Map<Integer, Integer> allRewardIds = new HashMap(((SBirthdayPrayRewardInfo)rewardEntry.getValue()).stage2RewardId.subMap(Integer.valueOf(0), true, Integer.valueOf(supportTimes), true));
/*     */         
/*     */ 
/*     */ 
/*  95 */         if (xWorldCounterRewardStages.getRewarded_stages().size() < allRewardIds.size())
/*     */         {
/*     */ 
/*     */ 
/*  99 */           for (Integer rewardedId : xWorldCounterRewardStages.getRewarded_stages())
/*     */           {
/* 101 */             allRewardIds.remove(rewardedId);
/*     */           }
/*     */           
/* 104 */           xWorldCounterRewardStages.getRewarded_stages().addAll(allRewardIds.keySet());
/* 105 */           List<AwardModel> awardModelList = null;
/*     */           AwardReason stageAwardReason;
/* 107 */           if (allRewardIds.size() > 0)
/*     */           {
/* 109 */             stageAwardReason = new AwardReason(LogReason.BIRTHDAY_PRAY_REWARD_MAIL);
/* 110 */             stageAwardReason.setJustQuery(true);
/* 111 */             for (Map.Entry<Integer, Integer> entry : allRewardIds.entrySet())
/*     */             {
/* 113 */               if (((Integer)entry.getValue()).intValue() > 0)
/*     */               {
/*     */ 
/*     */ 
/* 117 */                 AwardModel awardModel = AwardInterface.getRoleFixAwardModel(((Integer)entry.getValue()).intValue(), this.roleId, stageAwardReason);
/* 118 */                 if (awardModel != null)
/*     */                 {
/*     */ 
/*     */ 
/* 122 */                   if (awardModelList == null)
/*     */                   {
/* 124 */                     awardModelList = new ArrayList();
/*     */                   }
/* 126 */                   awardModelList.add(awardModel);
/*     */                 }
/*     */               } }
/*     */           }
/* 130 */           if ((awardModelList != null) && (awardModelList.size() > 0))
/*     */           {
/* 132 */             MailAttachment mailAttachment = new MailAttachment();
/* 133 */             AwardInterface.fillMailAttachMentBy(awardModelList, mailAttachment);
/* 134 */             MailInterface.synBuildAndSendMail(this.roleId, ((SBirthdayPrayRewardInfo)rewardEntry.getValue()).mailId, new ArrayList(), new ArrayList(), mailAttachment, new TLogArg(LogReason.BIRTHDAY_PRAY_MODEL_MAIl_AWARD));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 139 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\birthdaypray\main\PSendRewardMail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */