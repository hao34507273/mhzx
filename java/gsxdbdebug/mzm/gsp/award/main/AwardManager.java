/*     */ package mzm.gsp.award.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.confbean.SAward;
/*     */ import mzm.gsp.award.confbean.SAwardExp;
/*     */ import mzm.gsp.award.confbean.SAwardItem;
/*     */ import mzm.gsp.award.confbean.SAwardMoney;
/*     */ import mzm.gsp.award.confbean.SAwardSerLvCfgs;
/*     */ import mzm.gsp.award.confbean.SFixAwardTable;
/*     */ import mzm.gsp.award.confbean.SServerLvMappingTable;
/*     */ import mzm.gsp.award.confbean.STAward;
/*     */ import mzm.gsp.award.confbean.STAwardMoneyCfg;
/*     */ import mzm.gsp.award.confbean.STAwardSerLvTable;
/*     */ import mzm.gsp.award.confbean.STAwardTeam;
/*     */ import mzm.gsp.award.confbean.STExpAward;
/*     */ import mzm.gsp.award.confbean.STFixAward;
/*     */ import mzm.gsp.award.confbean.STGen2FixAwardIds;
/*     */ import mzm.gsp.award.confbean.STItemAward;
/*     */ import mzm.gsp.award.confbean.STMoneyAward;
/*     */ import mzm.gsp.award.confbean.STMoneyOwnCfg;
/*     */ import mzm.gsp.award.confbean.STTokenOwnCfg;
/*     */ import mzm.gsp.award.confbean.ServerLevelModify;
/*     */ import mzm.gsp.multixml.main.MultiXMLInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
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
/*     */ public class AwardManager
/*     */ {
/*     */   static void init() {}
/*     */   
/*     */   static int getMoneyNumByType(int stAwardMoneyId, int moneyType)
/*     */   {
/*  52 */     STAwardMoneyCfg moneyCfg = STAwardMoneyCfg.get(stAwardMoneyId);
/*  53 */     if (moneyCfg == null)
/*     */     {
/*  55 */       return 0;
/*     */     }
/*  57 */     Integer num = (Integer)moneyCfg.moneyType2num.get(Integer.valueOf(moneyType));
/*  58 */     return num == null ? 0 : num.intValue();
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
/*     */   static int getTokenNumByType(int stAwardMoneyId, int tokenType)
/*     */   {
/*  72 */     STAwardMoneyCfg moneyCfg = STAwardMoneyCfg.get(stAwardMoneyId);
/*  73 */     if (moneyCfg == null)
/*     */     {
/*  75 */       return 0;
/*     */     }
/*  77 */     Integer num = (Integer)moneyCfg.tokenType2num.get(Integer.valueOf(tokenType));
/*  78 */     return num == null ? 0 : num.intValue();
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
/*     */   public static ServerLevelModify getAwardServerLevel(int roleLevel, int serverlevel)
/*     */   {
/*  93 */     int levelDiff = 0;
/*  94 */     levelDiff = serverlevel - roleLevel;
/*  95 */     List<ServerLevelModify> modCfgs = getNowSlvModCfgs(serverlevel);
/*  96 */     if (modCfgs == null)
/*     */     {
/*  98 */       GameServer.logger().error(String.format("[Award]AwardManager.getAwardServerLevel@do not exist server level config|serverlevel=%d|roleLv=%d|modType=%d", new Object[] { Integer.valueOf(serverlevel), Integer.valueOf(roleLevel), Integer.valueOf(MultiXMLInterface.getXMLDateType()) }));
/*     */       
/*     */ 
/*     */ 
/* 102 */       return null;
/*     */     }
/* 104 */     for (ServerLevelModify serverLevelModify : modCfgs)
/*     */     {
/* 106 */       if ((levelDiff >= serverLevelModify.levelMin) && (levelDiff <= serverLevelModify.levelMax))
/*     */       {
/* 108 */         return serverLevelModify;
/*     */       }
/*     */     }
/* 111 */     GameServer.logger().error(String.format("[Award]AwardManager.getAwardServerLevel@no ServerLevelModify|serverlevel=%d|roleLv=%d|modType=%d", new Object[] { Integer.valueOf(serverlevel), Integer.valueOf(roleLevel), Integer.valueOf(MultiXMLInterface.getXMLDateType()) }));
/*     */     
/*     */ 
/*     */ 
/* 115 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<ServerLevelModify> getNowSlvModCfgs(int serverlevel)
/*     */   {
/* 127 */     int serModType = 0;
/* 128 */     int type = MultiXMLInterface.getXMLDateType();
/*     */     
/* 130 */     SServerLvMappingTable serModCfg = SServerLvMappingTable.get(type);
/* 131 */     if (serModCfg != null)
/*     */     {
/* 133 */       serModType = serModCfg.cfgName;
/*     */     }
/* 135 */     if (GameServer.logger().isDebugEnabled())
/*     */     {
/* 137 */       GameServer.logger().debug(String.format("[award]AwardManager.getNowSlvModCfgs@ ser mod type!|mainType=%d|awardSerType=%d|serverLv=%d", new Object[] { Integer.valueOf(type), Integer.valueOf(serModType), Integer.valueOf(serverlevel) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 142 */     return getTypeMods(serModType, serverlevel);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<ServerLevelModify> getTypeMods(int serModType, int serverLv)
/*     */   {
/* 154 */     STAwardSerLvTable cfg = getSerLvCfg(serModType);
/* 155 */     if (cfg == null)
/*     */     {
/* 157 */       GameServer.logger().error(String.format("[award]AwardManager.getTypeMods@cfg is null!|type=%d|serLv=%d", new Object[] { Integer.valueOf(serModType), Integer.valueOf(serverLv) }));
/*     */       
/* 159 */       return null;
/*     */     }
/* 161 */     return getTypeMods(serverLv, cfg);
/*     */   }
/*     */   
/*     */   private static STAwardSerLvTable getSerLvCfg(int serModType)
/*     */   {
/* 166 */     STAwardSerLvTable cfg = STAwardSerLvTable.get(serModType);
/* 167 */     if (cfg == null)
/*     */     {
/* 169 */       return STAwardSerLvTable.get(0);
/*     */     }
/* 171 */     return cfg;
/*     */   }
/*     */   
/*     */   private static List<ServerLevelModify> getTypeMods(int serverLv, STAwardSerLvTable cfg)
/*     */   {
/* 176 */     if (cfg == null)
/*     */     {
/* 178 */       GameServer.logger().error(String.format("[award]AwardManager.getTypeMods@ cfg is null!|serLv=%d", new Object[] { Integer.valueOf(serverLv) }));
/* 179 */       return null;
/*     */     }
/* 181 */     SAwardSerLvCfgs lvCfg = (SAwardSerLvCfgs)cfg.effLv2cfgs.get(Integer.valueOf(serverLv));
/* 182 */     if (lvCfg == null)
/*     */     {
/* 184 */       GameServer.logger().error(String.format("[award]AwardManager.getTypeMods@ lvCfg is null!|serLv=%d", new Object[] { Integer.valueOf(serverLv) }));
/* 185 */       return null;
/*     */     }
/* 187 */     return lvCfg.awardServerLevels;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SAward getAwardCfg(int awardId)
/*     */   {
/* 199 */     STAward cfg = STAward.get(awardId);
/* 200 */     if (cfg == null)
/*     */     {
/* 202 */       return null;
/*     */     }
/* 204 */     return SAward.get(cfg.sAwardId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<SAwardExp> getExpAwardCfgs(int awardExpId)
/*     */   {
/* 216 */     List<SAwardExp> awardExpCfgs = new ArrayList();
/* 217 */     STExpAward cfg = STExpAward.get(awardExpId);
/* 218 */     if (cfg == null)
/*     */     {
/* 220 */       if (awardExpId > 0)
/*     */       {
/* 222 */         GameServer.logger().error(String.format("[award]AwardManager.getExpAwardCfgs@ no STExpAward cfg!|awardExpId=%d", new Object[] { Integer.valueOf(awardExpId) }));
/*     */       }
/*     */       
/* 225 */       return awardExpCfgs;
/*     */     }
/* 227 */     for (Iterator i$ = cfg.sAwardExpIds.iterator(); i$.hasNext();) { int expAwardCfgId = ((Integer)i$.next()).intValue();
/*     */       
/* 229 */       SAwardExp awardExp = SAwardExp.get(expAwardCfgId);
/* 230 */       if (awardExp == null)
/*     */       {
/* 232 */         GameServer.logger().error(String.format("[award]AwardManager.getExpAwardCfgs@ no SAwardExp cfg!|awardExpId=%d|expAwardCfgId=%d", new Object[] { Integer.valueOf(awardExpId), Integer.valueOf(expAwardCfgId) }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 237 */         awardExpCfgs.add(awardExp); }
/*     */     }
/* 239 */     return awardExpCfgs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<SAwardMoney> getMoneyAwardCfgs(int awardMoneyId)
/*     */   {
/* 251 */     List<SAwardMoney> awardMoneyCfgs = new ArrayList();
/* 252 */     STMoneyAward cfg = STMoneyAward.get(awardMoneyId);
/* 253 */     if (cfg == null)
/*     */     {
/* 255 */       if (awardMoneyId > 0)
/*     */       {
/* 257 */         GameServer.logger().error(String.format("[award]AwardManager.getExpAwardCfgs@ no STMoneyAward cfg!|awardMoneyId=%d", new Object[] { Integer.valueOf(awardMoneyId) }));
/*     */       }
/*     */       
/* 260 */       return awardMoneyCfgs;
/*     */     }
/* 262 */     for (Iterator i$ = cfg.sAwardMoneyIds.iterator(); i$.hasNext();) { int moneyAwardCfgId = ((Integer)i$.next()).intValue();
/*     */       
/* 264 */       SAwardMoney awardMoney = SAwardMoney.get(moneyAwardCfgId);
/* 265 */       if (awardMoney == null)
/*     */       {
/* 267 */         GameServer.logger().error(String.format("[award]AwardManager.getExpAwardCfgs@ no SAwardMoney cfg!|awardMoneyId=%d|moneyAwardCfgId=%d", new Object[] { Integer.valueOf(awardMoneyId), Integer.valueOf(moneyAwardCfgId) }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 273 */         awardMoneyCfgs.add(awardMoney); }
/*     */     }
/* 275 */     return awardMoneyCfgs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<SAwardItem> getItemAwardCfgs(int awardItemId)
/*     */   {
/* 287 */     List<SAwardItem> awardItemCfgs = new ArrayList();
/* 288 */     STItemAward cfg = STItemAward.get(awardItemId);
/* 289 */     if (cfg == null)
/*     */     {
/* 291 */       if (awardItemId > 0)
/*     */       {
/* 293 */         GameServer.logger().error(String.format("[award]AwardManager.getExpAwardCfgs@ no STItemAward cfg!|awardItemId=%d", new Object[] { Integer.valueOf(awardItemId) }));
/*     */       }
/*     */       
/* 296 */       return awardItemCfgs;
/*     */     }
/* 298 */     for (Iterator i$ = cfg.sAwardItemIds.iterator(); i$.hasNext();) { int itemAwardCfgId = ((Integer)i$.next()).intValue();
/*     */       
/* 300 */       SAwardItem awardItem = SAwardItem.get(itemAwardCfgId);
/* 301 */       if (awardItem == null)
/*     */       {
/* 303 */         GameServer.logger().error(String.format("[award]AwardManager.getExpAwardCfgs@ no SAwardItem cfg!|awardItemId=%d|itemAwardCfgId=%d", new Object[] { Integer.valueOf(awardItemId), Integer.valueOf(itemAwardCfgId) }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 309 */         awardItemCfgs.add(awardItem); }
/*     */     }
/* 311 */     return awardItemCfgs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static STAwardTeam getSTAwardTeam(int teamMemberCount)
/*     */   {
/* 323 */     return STAwardTeam.get(teamMemberCount);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean hasFixAward(int fixAwardId)
/*     */   {
/* 335 */     return STFixAward.get(fixAwardId) != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean hasNormalAward(int awardId)
/*     */   {
/* 347 */     return STAward.get(awardId) != null;
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
/*     */   public static SFixAwardTable getFixAwardCfg(int fixAwardId, int occupation, int gender)
/*     */   {
/* 363 */     STFixAward stFixAward = STFixAward.get(fixAwardId);
/* 364 */     if (stFixAward == null)
/*     */     {
/* 366 */       GameServer.logger().error(String.format("[award]AwardCfgManager.getFixAwardCfg@ no fixAward cfg! fixAwardId=%d", new Object[] { Integer.valueOf(fixAwardId) }));
/*     */       
/* 368 */       return null;
/*     */     }
/* 370 */     int fixAwardCfgId = selectFixId(occupation, gender, stFixAward);
/* 371 */     if (fixAwardCfgId < 0)
/*     */     {
/* 373 */       return null;
/*     */     }
/* 375 */     return SFixAwardTable.get(fixAwardCfgId);
/*     */   }
/*     */   
/*     */   private static int selectFixId(int occupation, int gender, STFixAward stFixAward)
/*     */   {
/* 380 */     STGen2FixAwardIds gen2FixAwardIds = (STGen2FixAwardIds)stFixAward.occ2awardIds.get(Integer.valueOf(0));
/* 381 */     if (gen2FixAwardIds != null)
/*     */     {
/* 383 */       int fixId = selectFixIdByGender(gender, gen2FixAwardIds);
/* 384 */       if (fixId > 0)
/*     */       {
/* 386 */         return fixId;
/*     */       }
/*     */     }
/* 389 */     gen2FixAwardIds = (STGen2FixAwardIds)stFixAward.occ2awardIds.get(Integer.valueOf(occupation));
/* 390 */     if (gen2FixAwardIds != null)
/*     */     {
/* 392 */       int fixId = selectFixIdByGender(gender, gen2FixAwardIds);
/* 393 */       if (fixId > 0)
/*     */       {
/* 395 */         return fixId;
/*     */       }
/*     */     }
/* 398 */     return -1;
/*     */   }
/*     */   
/*     */   private static int selectFixIdByGender(int gender, STGen2FixAwardIds gen2FixAwardIds)
/*     */   {
/* 403 */     Integer fixAwardCfgId = (Integer)gen2FixAwardIds.gender2FixAwardCfgId.get(Integer.valueOf(0));
/* 404 */     if (fixAwardCfgId != null)
/*     */     {
/* 406 */       return fixAwardCfgId.intValue();
/*     */     }
/* 408 */     fixAwardCfgId = (Integer)gen2FixAwardIds.gender2FixAwardCfgId.get(Integer.valueOf(gender));
/* 409 */     if (fixAwardCfgId != null)
/*     */     {
/* 411 */       return fixAwardCfgId.intValue();
/*     */     }
/* 413 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getTokenOwnMax(int tokenType)
/*     */   {
/* 425 */     STTokenOwnCfg cfg = STTokenOwnCfg.get(tokenType);
/* 426 */     if (cfg == null)
/*     */     {
/* 428 */       return -1;
/*     */     }
/* 430 */     return cfg.ownMax;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getMoneyOwnMax(int moneyType)
/*     */   {
/* 442 */     STMoneyOwnCfg cfg = STMoneyOwnCfg.get(moneyType);
/* 443 */     if (cfg == null)
/*     */     {
/* 445 */       return -1;
/*     */     }
/* 447 */     return cfg.ownMax;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static String getTokenNameBy(int tokenType)
/*     */   {
/* 458 */     STTokenOwnCfg cfg = STTokenOwnCfg.get(tokenType);
/* 459 */     if (cfg == null)
/*     */     {
/* 461 */       return "";
/*     */     }
/* 463 */     return cfg.tokenName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static String getMoneyNameBy(int moneyType)
/*     */   {
/* 474 */     STMoneyOwnCfg cfg = STMoneyOwnCfg.get(moneyType);
/* 475 */     if (cfg == null)
/*     */     {
/* 477 */       return "";
/*     */     }
/* 479 */     return cfg.moneyName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<Long> randomRoles(List<Long> roles, int count)
/*     */   {
/* 491 */     int size = roles.size();
/* 492 */     if ((count > size) || (size == 0) || (count == 0))
/*     */     {
/* 494 */       return Collections.emptyList();
/*     */     }
/*     */     
/* 497 */     if (size == count)
/*     */     {
/* 499 */       return new ArrayList(roles);
/*     */     }
/*     */     
/* 502 */     Random random = Xdb.random();
/* 503 */     int i = size; for (int j = 0; j < count; j++)
/*     */     {
/* 505 */       Collections.swap(roles, i - 1, random.nextInt(i));i--;
/*     */     }
/*     */     
/* 508 */     return new ArrayList(roles.subList(size - count, size));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\AwardManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */