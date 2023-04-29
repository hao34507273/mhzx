/*     */ package mzm.gsp.award.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import mzm.gsp.award.confbean.AddModifyConsts;
/*     */ import mzm.gsp.award.confbean.AwardCfgConsts;
/*     */ import mzm.gsp.award.confbean.SAddModEffect;
/*     */ import mzm.gsp.award.confbean.SModifyValueTable;
/*     */ import mzm.gsp.award.confbean.STAwardTeam;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class MoneyCalculator
/*     */ {
/*  18 */   private static final Logger logger = Logger.getLogger(MoneyCalculator.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static double calMoney(double baseMoney, double moneyrAddtionParam, double moneyModifileParam)
/*     */   {
/*  32 */     double ret = baseMoney * (1.0D + moneyrAddtionParam) * moneyModifileParam;
/*  33 */     return ret;
/*     */   }
/*     */   
/*     */   static AwardModRet getMoneyModifileParam(List<Long> roleList, Collection<Long> allRoleList, long roleId, int modifileId)
/*     */   {
/*  38 */     AwardModRet awardModRet = new AwardModRet();
/*     */     
/*  40 */     double yuanbaoRet = 1.0D;
/*  41 */     double goldRet = 1.0D;
/*  42 */     double silverRet = 1.0D;
/*  43 */     double vitalityRet = 1.0D;
/*  44 */     double gangRet = 1.0D;
/*  45 */     double xiayiRet = 1.0D;
/*  46 */     double shimenRet = 1.0D;
/*  47 */     double jifenRet = 1.0D;
/*  48 */     double ladderScoreRet = 1.0D;
/*  49 */     double cardEssenceRet = 1.0D;
/*  50 */     double cardScoreRet = 1.0D;
/*  51 */     double xiaoHuiKuaiPaoPointRet = 1.0D;
/*  52 */     double backGameActivityPointRet = 1.0D;
/*  53 */     double xhkpCompensatePointRet = 1.0D;
/*  54 */     double bandstandScoreRet = 1.0D;
/*  55 */     double petFightScoreRet = 1.0D;
/*  56 */     double petMarkScoreRet1 = 1.0D;
/*  57 */     double petMarkScoreRet2 = 1.0D;
/*  58 */     double drawCarnivalPointRet = 1.0D;
/*     */     
/*  60 */     SModifyValueTable sModifyValueTable = SModifyValueTable.get(modifileId);
/*  61 */     if (sModifyValueTable != null)
/*     */     {
/*  63 */       silverRet *= sModifyValueTable.silverMod;
/*  64 */       vitalityRet *= sModifyValueTable.vitalityMod;
/*  65 */       gangRet *= sModifyValueTable.gangConbMod;
/*  66 */       shimenRet *= sModifyValueTable.masterMod;
/*     */     }
/*     */     
/*  69 */     awardModRet.setYuanbaoRet(yuanbaoRet);
/*  70 */     awardModRet.setGoldRet(goldRet);
/*  71 */     awardModRet.setSilverRet(silverRet);
/*  72 */     awardModRet.setVitalityRet(vitalityRet);
/*  73 */     awardModRet.setGangRet(gangRet);
/*  74 */     awardModRet.setXiayiRet(xiayiRet);
/*  75 */     awardModRet.setShimenRet(shimenRet);
/*  76 */     awardModRet.setJifenRet(jifenRet);
/*  77 */     awardModRet.setLadderScoreRet(ladderScoreRet);
/*  78 */     awardModRet.setCardEssenceRet(cardEssenceRet);
/*  79 */     awardModRet.setCardScoreRet(cardScoreRet);
/*  80 */     awardModRet.setXhkpPointRet(xiaoHuiKuaiPaoPointRet);
/*  81 */     awardModRet.setBackGameActivityPointRet(backGameActivityPointRet);
/*  82 */     awardModRet.setXhkpCompensatePointRet(xhkpCompensatePointRet);
/*  83 */     awardModRet.setBandstandScoreRet(bandstandScoreRet);
/*  84 */     awardModRet.setPetFightScore(petFightScoreRet);
/*  85 */     awardModRet.setPetMarkScore1(petMarkScoreRet1);
/*  86 */     awardModRet.setPetMarkScore2(petMarkScoreRet2);
/*  87 */     awardModRet.setDrawCarnivalPointRet(drawCarnivalPointRet);
/*     */     
/*  89 */     return awardModRet;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static AwardAddRet getMoneyAddParam(List<Long> roleList, Collection<Long> allRoleList, long roleId, int addModifyCnfId)
/*     */   {
/* 104 */     String roleName = RoleInterface.getName(roleId);
/* 105 */     AwardAddRet awardAddRet = new AwardAddRet();
/*     */     
/* 107 */     double yuanbaoRet = 0.0D;
/* 108 */     double goldRet = 0.0D;
/* 109 */     double silverRet = 0.0D;
/* 110 */     double vitalityRet = 0.0D;
/* 111 */     double gangRet = 0.0D;
/* 112 */     double xiayiRet = 0.0D;
/* 113 */     double shimenRet = 0.0D;
/* 114 */     double jifenRet = 0.0D;
/* 115 */     double ladderScoreRet = 0.0D;
/* 116 */     double cardEssenceRet = 0.0D;
/* 117 */     double cardScoreRet = 0.0D;
/* 118 */     double xiaoHuiKuaiPaoPointRet = 0.0D;
/* 119 */     double backGameActivityPointRet = 0.0D;
/* 120 */     double singleBattlePointRet = 0.0D;
/* 121 */     double xhkpCompensatePointRet = 0.0D;
/* 122 */     double bandstandScoreRet = 0.0D;
/* 123 */     double petFightScoreRet = 0.0D;
/* 124 */     double petMarkScoreRet1 = 0.0D;
/* 125 */     double petMarkScoreRet2 = 0.0D;
/* 126 */     double drawCarnivalPointRet = 0.0D;
/*     */     
/* 128 */     SAddModEffect sAddModEffect = SAddModEffect.get(addModifyCnfId);
/* 129 */     if (sAddModEffect == null)
/*     */     {
/* 131 */       logger.error("没有符合玩家的修正加成生效配置addModifyCnfId=" + addModifyCnfId);
/* 132 */       return awardAddRet;
/*     */     }
/*     */     
/*     */ 
/* 136 */     int teamNum = allRoleList.size();
/* 137 */     STAwardTeam stAwardTeam = AwardManager.getSTAwardTeam(teamNum);
/* 138 */     if (stAwardTeam != null)
/*     */     {
/* 140 */       silverRet += stAwardTeam.silverAdd / AwardCfgConsts.getInstance().AWARD_ADD_BASE;
/* 141 */       vitalityRet += stAwardTeam.vitalityAdd / AwardCfgConsts.getInstance().AWARD_ADD_BASE;
/* 142 */       gangRet += stAwardTeam.gangConbAdd / AwardCfgConsts.getInstance().AWARD_ADD_BASE;
/* 143 */       xiayiRet += stAwardTeam.chivalryAdd / AwardCfgConsts.getInstance().AWARD_ADD_BASE;
/*     */     }
/*     */     
/*     */ 
/* 147 */     if (sAddModEffect.isLeadersilverAddEffect)
/*     */     {
/* 149 */       if (teamNum > 1)
/*     */       {
/* 151 */         if (((Long)roleList.get(0)).longValue() == roleId)
/*     */         {
/* 153 */           silverRet += AddModifyConsts.getInstance().TEAMLEADER_SILVER_ADD / AwardCfgConsts.getInstance().AWARD_ADD_BASE;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 159 */     awardAddRet.setYuanbaoRet(yuanbaoRet);
/* 160 */     awardAddRet.setGoldRet(goldRet);
/* 161 */     awardAddRet.setSilverRet(silverRet);
/* 162 */     awardAddRet.setVitalityRet(vitalityRet);
/* 163 */     awardAddRet.setGangRet(gangRet);
/* 164 */     awardAddRet.setXiayiRet(xiayiRet);
/* 165 */     awardAddRet.setShimenRet(shimenRet);
/* 166 */     awardAddRet.setJifenRet(jifenRet);
/* 167 */     awardAddRet.setLadderScoreRet(ladderScoreRet);
/* 168 */     awardAddRet.setCardEssenceRet(cardEssenceRet);
/* 169 */     awardAddRet.setCardScoreRet(cardScoreRet);
/*     */     
/* 171 */     awardAddRet.setXhkpPointRet(xiaoHuiKuaiPaoPointRet);
/* 172 */     awardAddRet.setBackGameActivityPointRet(backGameActivityPointRet);
/* 173 */     awardAddRet.setSingleBattlePointRet(singleBattlePointRet);
/* 174 */     awardAddRet.setXhkpCompensatePointRet(xhkpCompensatePointRet);
/* 175 */     awardAddRet.setBandstandScoreRet(bandstandScoreRet);
/* 176 */     awardAddRet.setPetFightScore(petFightScoreRet);
/* 177 */     awardAddRet.setPetMarkScore1(petMarkScoreRet1);
/* 178 */     awardAddRet.setPetMarkScore2(petMarkScoreRet2);
/* 179 */     awardAddRet.setDrawCarnivalPointRet(drawCarnivalPointRet);
/*     */     
/* 181 */     return awardAddRet;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isRelationSilverAddEffect(SAddModEffect sAddModEffect)
/*     */   {
/* 192 */     return sAddModEffect.isRelationsilverAddEffect;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isNewMarriageSilverAddEffect(SAddModEffect sAddModEffect)
/*     */   {
/* 203 */     return sAddModEffect.isNewMarriagesilverAddEffect;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int newMarriageBuffSilverAddValue()
/*     */   {
/* 213 */     return AddModifyConsts.getInstance().NEW_MARRIAGE_SILVER_ADD;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isNewMarriageTeamSilverAddEffect(SAddModEffect sAddModEffect)
/*     */   {
/* 224 */     return sAddModEffect.isNewMarriageTeamsilverAddEffect;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int newMarriageTeamBuffSilverAddValue()
/*     */   {
/* 234 */     return AddModifyConsts.getInstance().NEW_MARRIAGE_TEAM_SILVER_ADD;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\MoneyCalculator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */