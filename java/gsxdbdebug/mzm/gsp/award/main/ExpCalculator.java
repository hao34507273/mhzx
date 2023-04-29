/*     */ package mzm.gsp.award.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.confbean.AddModifyConsts;
/*     */ import mzm.gsp.award.confbean.AwardCfgConsts;
/*     */ import mzm.gsp.award.confbean.SAddModEffect;
/*     */ import mzm.gsp.award.confbean.SAward;
/*     */ import mzm.gsp.award.confbean.SAwardExp;
/*     */ import mzm.gsp.award.confbean.SModifyValueTable;
/*     */ import mzm.gsp.award.confbean.STAwardTeam;
/*     */ import mzm.gsp.award.confbean.ServerLevelModify;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ExpCalculator
/*     */ {
/*  26 */   private static final Logger logger = Logger.getLogger(ExpCalculator.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final int EXP_ROLE = 1;
/*     */   
/*     */ 
/*     */ 
/*     */   public static final int EXP_PET = 2;
/*     */   
/*     */ 
/*     */ 
/*     */   public static final int EXP_ROLE_XIULIAN = 3;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static double calExp(double baseExp, double expAddtionParam, double expModifile)
/*     */   {
/*  46 */     double ret = 0.0D;
/*  47 */     ret = baseExp * (1.0D + expAddtionParam) * expModifile;
/*  48 */     return ret;
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
/*     */ 
/*     */ 
/*     */   private static double calAddExp(double baseExp, double expAddtionParam, double expModifile)
/*     */   {
/*  65 */     double ret = 0.0D;
/*  66 */     ret = baseExp * expAddtionParam * expModifile;
/*  67 */     return ret;
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
/*     */   private static double calModExp(double baseExp, double expAddtionParam, double allModParam, double expModifile)
/*     */   {
/*  82 */     double ret = 0.0D;
/*  83 */     ret = baseExp * (1.0D + expAddtionParam) * (allModParam / expModifile) * (expModifile - 1.0D);
/*  84 */     return ret;
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
/*     */ 
/*     */ 
/*     */   static double calRoleExp(SAward sAward, SAwardExp awardExp, List<Long> roleList, Collection<Long> allRoleList, long roleId, int modifileId, AwardModel awardModel)
/*     */   {
/* 101 */     double roleBaseExp = awardExp.roleBaseExp;
/* 102 */     AwardAddParam addParam = getExpAddtionParam(roleList, allRoleList, roleId, sAward.addModifyCnfId);
/* 103 */     AwardModParam modParam = getRoleExpModifileParam(sAward, awardExp, roleList, roleId, modifileId, sAward.addModifyCnfId);
/* 104 */     if (!PBuffEffect.calBuffAdd(sAward.addModifyCnfId, roleId, addParam, 1, 1))
/*     */     {
/*     */ 
/* 107 */       awardModel.setZeroState(true);
/* 108 */       return 0.0D;
/*     */     }
/*     */     
/* 111 */     for (Map.Entry<Integer, Double> entry : addParam.getAddType2Num().entrySet())
/*     */     {
/* 113 */       double addValue = calAddExp(roleBaseExp, ((Double)entry.getValue()).doubleValue(), modParam.getAllModParam());
/* 114 */       if (addValue >= 1.0D)
/*     */       {
/* 116 */         awardModel.addAwardAddNum(1, ((Integer)entry.getKey()).intValue(), addValue);
/*     */       }
/*     */     }
/*     */     
/* 120 */     for (Map.Entry<Integer, Double> entry : modParam.getModType2Num().entrySet())
/*     */     {
/* 122 */       if (((Double)entry.getValue()).doubleValue() > 1.0D)
/*     */       {
/*     */ 
/*     */ 
/* 126 */         double modValue = calModExp(roleBaseExp, addParam.getAllAddParam(), modParam.getAllModParam(), ((Double)entry.getValue()).doubleValue());
/* 127 */         if (modValue >= 1.0D)
/*     */         {
/* 129 */           awardModel.addAwardAddNum(1, ((Integer)entry.getKey()).intValue(), modValue); }
/*     */       }
/*     */     }
/* 132 */     return calExp(roleBaseExp, addParam.getAllAddParam(), modParam.getAllModParam());
/*     */   }
/*     */   
/*     */ 
/*     */   private static AwardModParam getRoleExpModifileParam(SAward sAward, SAwardExp awardExp, List<Long> roleList, long roleId, int modifileId, int addModifyCnfId)
/*     */   {
/* 138 */     AwardModParam modParam = new AwardModParam();
/* 139 */     double ret = calServerLevelModToRole(roleId, addModifyCnfId);
/* 140 */     modParam.getModType2Num().put(Integer.valueOf(20), Double.valueOf(ret));
/*     */     
/* 142 */     if (logger.isDebugEnabled())
/*     */     {
/* 144 */       logger.debug("[" + RoleInterface.getName(roleId) + "] 奖励类id= " + sAward.awardId + "; 经验子表id= " + sAward.awardExpId + "; 人物经验= " + awardExp.roleBaseExp + "; 经验修 正id= " + modifileId + "; 服务器修正值= " + ret);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 149 */     SModifyValueTable sModifyValueTable = SModifyValueTable.get(modifileId);
/* 150 */     if (sModifyValueTable != null)
/*     */     {
/* 152 */       ret *= sModifyValueTable.roleExpMod;
/*     */     }
/* 154 */     modParam.setAllModParam(ret);
/* 155 */     return modParam;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static double calServerLevelModToRole(long roleId, int addModifyCnfId)
/*     */   {
/* 165 */     if (RoleInterface.isReachMaxLevel(roleId, true))
/*     */     {
/* 167 */       double tmpRet = RoleInterface.getReachMaxLevelExpModRet(RoleInterface.getLevel(roleId));
/* 168 */       if (tmpRet > 0.0D)
/*     */       {
/* 170 */         if (logger.isDebugEnabled())
/*     */         {
/* 172 */           logger.debug(String.format("[award]ExpCalculator.calServerLevelModToRole@ reach max level!|roleId=%d|ret=%f", new Object[] { Long.valueOf(roleId), Double.valueOf(tmpRet) }));
/*     */         }
/*     */         
/* 175 */         return tmpRet;
/*     */       }
/*     */     }
/* 178 */     double ret = 1.0D;
/* 179 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 180 */     SAddModEffect sAddModEffect = SAddModEffect.get(addModifyCnfId);
/* 181 */     if (sAddModEffect == null)
/*     */     {
/* 183 */       logger.error(String.format("[award]ExpCalculator.calServerLevelModToRole@ no SAddModEffect!|roleId=%d|addModifyCnfId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(addModifyCnfId) }));
/*     */       
/*     */ 
/* 186 */       return ret;
/*     */     }
/*     */     
/* 189 */     ret = getServerGapMod(ret, roleLevel, sAddModEffect, 1);
/*     */     
/* 191 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static double getServerModValue(SAddModEffect sAddModEffect, ServerLevelModify serverLevelModify, int expType)
/*     */   {
/* 203 */     double expMod = 0.0D;
/* 204 */     switch (expType)
/*     */     {
/*     */     case 1: 
/* 207 */       expMod = serverLevelModify.roleExpMod;
/* 208 */       break;
/*     */     case 2: 
/* 210 */       expMod = serverLevelModify.petExpMod;
/* 211 */       break;
/*     */     case 3: 
/* 213 */       expMod = serverLevelModify.practiceMod;
/*     */     }
/*     */     
/*     */     
/*     */ 
/* 218 */     return checkExpMod(sAddModEffect, expMod);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static double checkExpMod(SAddModEffect sAddModEffect, double expMod)
/*     */   {
/* 228 */     if (expMod > 1.0D)
/*     */     {
/* 230 */       if (!sAddModEffect.isServerLevelExpAddEffect)
/*     */       {
/* 232 */         expMod = 1.0D;
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 237 */     else if (!sAddModEffect.isServerLevelExpCutEffect)
/*     */     {
/* 239 */       expMod = 1.0D;
/*     */     }
/*     */     
/* 242 */     return expMod;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static double calServerLevelModToRoleXiulian(long roleId, int addModifyCnfId)
/*     */   {
/* 252 */     double ret = 1.0D;
/* 253 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 254 */     SAddModEffect sAddModEffect = SAddModEffect.get(addModifyCnfId);
/* 255 */     if (sAddModEffect == null)
/*     */     {
/* 257 */       logger.error("没有符合玩家的修正加成生效配置addModifyCnfId=" + addModifyCnfId);
/* 258 */       return ret;
/*     */     }
/* 260 */     ret = getServerGapMod(ret, roleLevel, sAddModEffect, 1);
/* 261 */     return ret;
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
/*     */   static double getServerGapMod(double ret, int level, SAddModEffect sAddModEffect, int expType)
/*     */   {
/* 276 */     if (RoleAwardManager.getServerLevel() > 0)
/*     */     {
/* 278 */       ServerLevelModify serverLevelModify = AwardManager.getAwardServerLevel(level, RoleAwardManager.getServerLevel());
/* 279 */       if (serverLevelModify == null)
/*     */       {
/* 281 */         GameServer.logger().error(String.format("[award]ExpCalculator.getServerGapMod@ no server modcfg!|roleLv=%d|serverLv=%d", new Object[] { Integer.valueOf(level), Integer.valueOf(RoleAwardManager.getServerLevel()) }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 287 */         double expMod = getServerModValue(sAddModEffect, serverLevelModify, expType);
/* 288 */         ret *= expMod;
/* 289 */         if (GameServer.logger().isDebugEnabled())
/*     */         {
/* 291 */           GameServer.logger().debug(String.format("[award]ExpCalculator.getServerGapMod@ ser mod ret!|lv=%d|expType=%d|ret=%f", new Object[] { Integer.valueOf(level), Integer.valueOf(expType), Double.valueOf(expMod) }));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 297 */     return ret;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static AwardAddParam getExpAddtionParam(List<Long> roleList, Collection<Long> allRoleList, long roleId, int addModifyCnfId)
/*     */   {
/* 317 */     String roleName = RoleInterface.getName(roleId);
/* 318 */     AwardAddParam addParam = new AwardAddParam();
/* 319 */     double ret = 0.0D;
/* 320 */     SAddModEffect sAddModEffect = SAddModEffect.get(addModifyCnfId);
/* 321 */     if (sAddModEffect == null)
/*     */     {
/* 323 */       logger.error("没有符合玩家的修正加成生效配置addModifyCnfId=" + addModifyCnfId);
/* 324 */       return addParam;
/*     */     }
/*     */     
/* 327 */     int teamNum = allRoleList.size();
/*     */     
/* 329 */     if (sAddModEffect.isTeamExpAddEffect)
/*     */     {
/* 331 */       STAwardTeam stAwardTeam = AwardManager.getSTAwardTeam(teamNum);
/* 332 */       if (stAwardTeam != null)
/*     */       {
/* 334 */         double teamAddRet = stAwardTeam.roleExpAdd / AwardCfgConsts.getInstance().AWARD_ADD_BASE;
/* 335 */         ret += teamAddRet;
/* 336 */         addParam.addAddType2Num(2, teamAddRet);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 341 */     if (sAddModEffect.isLeaderExpAddEffect)
/*     */     {
/* 343 */       if (teamNum > 1)
/*     */       {
/* 345 */         if (((Long)roleList.get(0)).longValue() == roleId)
/*     */         {
/* 347 */           double leaderAddRet = AddModifyConsts.getInstance().TEAMLEADER_EXP_ADD / AwardCfgConsts.getInstance().AWARD_ADD_BASE;
/*     */           
/* 349 */           ret += leaderAddRet;
/* 350 */           addParam.addAddType2Num(1, leaderAddRet);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 355 */     addParam.setAllAddParam(ret);
/* 356 */     return addParam;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isRelationExpAddEffect(SAddModEffect sAddModEffect)
/*     */   {
/* 367 */     return sAddModEffect.isRelationExpAddEffect;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isNewMarriageExpAddEffect(SAddModEffect sAddModEffect)
/*     */   {
/* 378 */     return sAddModEffect.isNewMarriageExpAddEffect;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int newMarriageBuffExpAddValue()
/*     */   {
/* 388 */     return AddModifyConsts.getInstance().NEW_MARRIAGE_EXP_ADD;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isNewMarriageTeamExpAddEffect(SAddModEffect sAddModEffect)
/*     */   {
/* 399 */     return sAddModEffect.isNewMarriageTeamExpAddEffect;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int newMarriageTeamBuffExpAddValue()
/*     */   {
/* 409 */     return AddModifyConsts.getInstance().NEW_MARRIAGE_TEAM_EXP_ADD;
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
/*     */ 
/*     */ 
/*     */   static double calPetExp(SAward sAward, SAwardExp awardExp, List<Long> roleList, Collection<Long> allRoleList, long roleId, int modifileId, AwardModel awardModel)
/*     */   {
/* 426 */     double petBaseExp = awardExp.petBaseExp;
/* 427 */     AwardAddParam addParam = new AwardAddParam();
/* 428 */     if (!PBuffEffect.calBuffAdd(sAward.addModifyCnfId, roleId, addParam, 2, 2))
/*     */     {
/*     */ 
/* 431 */       awardModel.setZeroState(true);
/* 432 */       return 0.0D;
/*     */     }
/* 434 */     double expModifile = getPetExpModifileParam(roleList, roleId, modifileId, sAward.addModifyCnfId);
/* 435 */     return calExp(petBaseExp, addParam.getAllAddParam(), expModifile);
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
/*     */ 
/*     */   static double calXiulianExp(SAward sAward, SAwardExp awardExp, List<Long> roleList, Collection<Long> allRoleList, long roleId, int modifileId, AwardModel awardModel)
/*     */   {
/* 451 */     double baseExp = awardExp.practiceExp;
/* 452 */     if (baseExp <= 0.0D)
/*     */     {
/* 454 */       return 0.0D;
/*     */     }
/* 456 */     AwardAddParam addParam = new AwardAddParam();
/* 457 */     if (!PBuffEffect.calBuffAdd(sAward.addModifyCnfId, roleId, addParam, 3, 4))
/*     */     {
/*     */ 
/* 460 */       awardModel.setZeroState(true);
/* 461 */       return 0.0D;
/*     */     }
/* 463 */     double expModifile = getXiulianModParam(roleList, roleId, modifileId, sAward.addModifyCnfId);
/* 464 */     return calExp(baseExp, addParam.getAllAddParam(), expModifile);
/*     */   }
/*     */   
/*     */   private static double getXiulianModParam(List<Long> roleList, long roleId, int modifileId, int addModifyCnfId)
/*     */   {
/* 469 */     double ret = calServerLevelModToRoleXiulian(roleId, addModifyCnfId);
/*     */     
/*     */ 
/* 472 */     SModifyValueTable sModifyValueTable = SModifyValueTable.get(modifileId);
/* 473 */     if (sModifyValueTable != null)
/*     */     {
/* 475 */       ret *= sModifyValueTable.practiceMod;
/*     */     }
/* 477 */     return ret;
/*     */   }
/*     */   
/*     */   private static double getPetExpModifileParam(List<Long> roleList, long roleId, int modifileId, int addModifyCnfId)
/*     */   {
/* 482 */     double ret = 1.0D;
/* 483 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 484 */     SAddModEffect sAddModEffect = SAddModEffect.get(addModifyCnfId);
/* 485 */     if (sAddModEffect == null)
/*     */     {
/* 487 */       logger.error("没有符合玩家的修正加成生效配置addModifyCnfId=" + addModifyCnfId);
/* 488 */       return ret;
/*     */     }
/*     */     
/* 491 */     ret = getServerGapMod(ret, roleLevel, sAddModEffect, 2);
/*     */     
/*     */ 
/* 494 */     SModifyValueTable sModifyValueTable = SModifyValueTable.get(modifileId);
/* 495 */     if (sModifyValueTable != null)
/*     */     {
/* 497 */       ret *= sModifyValueTable.petExpMod;
/*     */     }
/*     */     
/* 500 */     return ret;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\ExpCalculator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */