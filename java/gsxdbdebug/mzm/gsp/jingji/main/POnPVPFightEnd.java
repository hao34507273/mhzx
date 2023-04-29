/*     */ package mzm.gsp.jingji.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.activity.confbean.JingjiActivityCfgConsts;
/*     */ import mzm.gsp.activity.confbean.SJingjiModifyCfg;
/*     */ import mzm.gsp.activity.confbean.SJingjiPhaseCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.fight.event.PVCFightEndArg;
/*     */ import mzm.gsp.fight.event.PVCFightEndProcedure;
/*     */ import mzm.gsp.fight.main.FightContext;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.idip.main.IdipManager;
/*     */ import mzm.gsp.jingji.event.JingjiActivityArg;
/*     */ import mzm.gsp.jingji.event.JingjiActivityFinished;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.storageexp.main.StorageExpInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Xdb;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnPVPFightEnd
/*     */   extends PVCFightEndProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     FightContext fightContext = ((PVCFightEndArg)this.arg).context;
/*  44 */     if ((fightContext == null) || (!(fightContext instanceof PVPFightContex)))
/*     */     {
/*  46 */       return false;
/*     */     }
/*  48 */     PVPFightContex pvpFightContex = (PVPFightContex)fightContext;
/*  49 */     if ((pvpFightContex.getFightReson().value != FightReason.JINGJI_ROBOT_FIGHT.value) && (pvpFightContex.getFightReson().value != FightReason.JINGJI_ROLE_FIGHT.value))
/*     */     {
/*     */ 
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     long roleid = ((Long)((PVCFightEndArg)this.arg).activeRoleList.get(0)).longValue();
/*     */     
/*  57 */     int winPoint = computeWinPoint();
/*     */     
/*  59 */     String userid = RoleInterface.getUserId(roleid);
/*  60 */     lock(Lockeys.get(User.getTable(), userid));
/*  61 */     int activitycount = ActivityInterface.getActivityCount(userid, roleid, JingjiActivityCfgConsts.getInstance().ACTIVITYID, true);
/*     */     
/*  63 */     SJingjiModifyCfg modifyCfg = SJingjiModifyCfg.get(activitycount + 1);
/*     */     
/*  65 */     int oldPoint = JingjiManager.getWinpoint(roleid, true);
/*  66 */     if (!IdipManager.isBanRank(roleid, 3))
/*     */     {
/*  68 */       JingjiManager.setWinpoint(roleid, winPoint);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  73 */       String logstr = String.format("[jingji]POnPVPFightEnd.processImp@role is is ban rank state|roleid=%d|oldwinpoint=%d|normalwinpoint=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(oldPoint), Integer.valueOf(winPoint) });
/*     */       
/*     */ 
/*     */ 
/*  77 */       JingjiManager.logger.info(logstr);
/*     */       
/*  79 */       winPoint = oldPoint;
/*     */     }
/*     */     
/*  82 */     if (((PVCFightEndArg)this.arg).isActiveWin)
/*     */     {
/*  84 */       JingjiManager.addVictorycount(roleid, 1);
/*  85 */       int vicount = JingjiManager.getVictorycount(roleid);
/*  86 */       if (vicount >= JingjiActivityCfgConsts.getInstance().MIN_VICTORY_NUM_FOR_BULLETIN)
/*     */       {
/*     */ 
/*  89 */         SBulletinInfo bulletinInfo = new SBulletinInfo();
/*  90 */         bulletinInfo.bulletintype = 15;
/*  91 */         bulletinInfo.params.put(Integer.valueOf(1), RoleInterface.getName(roleid));
/*  92 */         bulletinInfo.params.put(Integer.valueOf(13), vicount + "");
/*  93 */         BulletinInterface.sendBulletin(bulletinInfo);
/*     */       }
/*     */       
/*  96 */       if (modifyCfg != null)
/*     */       {
/*  98 */         AwardReason awardReason = new AwardReason(LogReason.JINGJI_ACTIVITY_FIGHT_REWARD_ADD, JingjiActivityCfgConsts.getInstance().SUCCESS_REWARDID);
/*     */         
/*     */ 
/* 101 */         AwardModel awardModel = AwardInterface.getRoleAwardModel(JingjiActivityCfgConsts.getInstance().SUCCESS_REWARDID, roleid, modifyCfg.modifyId, awardReason);
/*     */         
/* 103 */         if (awardModel != null)
/*     */         {
/* 105 */           StorageExpInterface.award(userid, roleid, awardModel, awardReason);
/*     */         }
/*     */         
/*     */ 
/* 109 */         int jinjiJifen = awardModel.getTokenMap().get(Integer.valueOf(2)) == null ? 0 : awardModel == null ? 0 : ((Integer)awardModel.getTokenMap().get(Integer.valueOf(2))).intValue();
/*     */         
/* 111 */         JingjiManager.addJifen(roleid, jinjiJifen);
/*     */       }
/*     */       else
/*     */       {
/* 115 */         JingjiManager.sendNoAwardRes(roleid);
/*     */       }
/*     */       
/* 118 */       int phase = JingjiManager.getPhaseByWingPoint(winPoint);
/* 119 */       if ((phase == 5) && (!JingjiManager.isSendbulletin(roleid)))
/*     */       {
/* 121 */         SBulletinInfo bulletinInfo = new SBulletinInfo();
/* 122 */         bulletinInfo.bulletintype = 16;
/* 123 */         bulletinInfo.params.put(Integer.valueOf(1), RoleInterface.getName(roleid));
/*     */         
/* 125 */         BulletinInterface.sendBulletin(bulletinInfo);
/* 126 */         JingjiManager.setIsSendbulletin(roleid, true);
/*     */       }
/* 128 */       if (JingjiManager.getFirstvictoryrewardid(roleid) == -1)
/*     */       {
/* 130 */         SJingjiPhaseCfg jingjip = JingjiManager.getJingjiPhaseCfgByWingPoint(winPoint);
/* 131 */         JingjiManager.setFirstvictoryrewardid(roleid, jingjip.firstWinRewardId);
/*     */       }
/* 133 */       JingjiManager.asynRefreshMatchOpponent(roleid, RoleInterface.getLevel(roleid), RoleInterface.getRoleMFValue(roleid), winPoint, DateTimeUtils.getCurrTimeInMillis(), -1L);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 138 */       JingjiManager.setVictorycount(roleid, 0);
/*     */       
/* 140 */       if (modifyCfg != null)
/*     */       {
/* 142 */         AwardReason awardReason = new AwardReason(LogReason.JINGJI_ACTIVITY_FIGHT_REWARD_ADD, JingjiActivityCfgConsts.getInstance().FAIL_REWARDID);
/*     */         
/* 144 */         AwardModel awardModel = AwardInterface.getRoleAwardModel(JingjiActivityCfgConsts.getInstance().FAIL_REWARDID, roleid, modifyCfg.modifyId, awardReason);
/*     */         
/* 146 */         if (awardModel != null)
/*     */         {
/* 148 */           StorageExpInterface.award(userid, roleid, awardModel, awardReason);
/*     */         }
/*     */         
/* 151 */         int jinjiJifen = awardModel.getTokenMap().get(Integer.valueOf(2)) == null ? 0 : awardModel == null ? 0 : ((Integer)awardModel.getTokenMap().get(Integer.valueOf(2))).intValue();
/*     */         
/* 153 */         JingjiManager.addJifen(roleid, jinjiJifen);
/*     */       }
/*     */       else
/*     */       {
/* 157 */         JingjiManager.sendNoAwardRes(roleid);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 162 */     JingjiManager.addFightcount(roleid, 1);
/* 163 */     if (JingjiManager.getFightcount(roleid) == 5)
/*     */     {
/* 165 */       SJingjiPhaseCfg jingjip = JingjiManager.getJingjiPhaseCfgByWingPoint(winPoint);
/* 166 */       JingjiManager.setFivefightrewardid(roleid, jingjip.fiveFightRewardId);
/*     */     }
/* 168 */     JingjiManager.decChallengeCount(roleid, 1);
/* 169 */     JingjiManager.synRewardChanged(roleid);
/*     */     
/* 171 */     RoleJingjiChartInterface.rank(roleid, winPoint);
/*     */     
/* 173 */     JingjiManager.synJingjiDataChanged(roleid, winPoint - oldPoint, ((PVCFightEndArg)this.arg).isActiveWin);
/*     */     
/* 175 */     ActivityInterface.addActivityCount(userid, roleid, JingjiActivityCfgConsts.getInstance().ACTIVITYID);
/* 176 */     ActivityInterface.logActivity(roleid, JingjiActivityCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.FINISH);
/* 177 */     ActivityInterface.tlogActivity(roleid, JingjiActivityCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.FINISH);
/*     */     
/* 179 */     TriggerEventsManger.getInstance().triggerEvent(new JingjiActivityFinished(), new JingjiActivityArg(roleid, JingjiActivityCfgConsts.getInstance().ACTIVITYID, ((PVCFightEndArg)this.arg).isActiveWin, JingjiManager.getFightcount(roleid)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 184 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int computeWinPoint()
/*     */   {
/* 195 */     int floatPointdelta = 50;
/* 196 */     int ten = 10;
/* 197 */     int base = 400;
/*     */     
/* 199 */     long roleid = ((Long)((PVCFightEndArg)this.arg).activeRoleList.get(0)).longValue();
/* 200 */     boolean iswin = ((PVCFightEndArg)this.arg).isActiveWin;
/*     */     
/* 202 */     int beforewinPointB = 0;
/* 203 */     if (((PVCFightEndArg)this.arg).passiveRoleList.size() != 0)
/*     */     {
/* 205 */       beforewinPointB = JingjiManager.getWinpoint(((Long)((PVCFightEndArg)this.arg).passiveRoleList.get(0)).longValue(), false);
/*     */     }
/*     */     
/*     */ 
/* 209 */     int beforeWinPointA = JingjiManager.getWinpoint(roleid, false);
/* 210 */     if (beforewinPointB == 0)
/*     */     {
/* 212 */       beforewinPointB = beforeWinPointA - 50 + Xdb.random().nextInt(100);
/*     */     }
/* 214 */     int k = JingjiManager.getKValueByWingPoint(beforeWinPointA);
/* 215 */     int y = 0;
/* 216 */     if (iswin)
/*     */     {
/* 218 */       y = 1;
/*     */     }
/* 220 */     double x = 1.0D / (1.0D + Math.pow(10.0D, (beforewinPointB - beforeWinPointA) / 400));
/* 221 */     int afterwinPointA = (int)(beforeWinPointA + k * (y - x));
/*     */     
/* 223 */     afterwinPointA = afterwinPointA - JingjiActivityCfgConsts.getInstance().RANDOM_WINPOINT + Xdb.random().nextInt(JingjiActivityCfgConsts.getInstance().RANDOM_WINPOINT * 2);
/*     */     
/*     */ 
/* 226 */     String logstr = String.format("[jingji]POnPVPFightEnd.computeWinPoint@compute role win point|roleid=%d|beforeWinPointA=%d|beforewinPointB=%d|afterwinPointA=%d|x=%f|y=%d|iswin=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(beforeWinPointA), Integer.valueOf(beforewinPointB), Integer.valueOf(afterwinPointA), Double.valueOf(x), Integer.valueOf(y), Integer.valueOf(iswin ? 1 : 0) });
/*     */     
/*     */ 
/*     */ 
/* 230 */     JingjiManager.logger.info(logstr);
/*     */     
/* 232 */     if ((iswin) && (afterwinPointA <= beforeWinPointA))
/*     */     {
/* 234 */       afterwinPointA = beforeWinPointA + 1;
/*     */     }
/* 236 */     if (afterwinPointA < JingjiActivityCfgConsts.getInstance().MIN_WING_POINT)
/*     */     {
/* 238 */       afterwinPointA = JingjiActivityCfgConsts.getInstance().MIN_WING_POINT;
/*     */     }
/* 240 */     if (afterwinPointA > JingjiManager.getMaxWingPoint())
/*     */     {
/* 242 */       afterwinPointA = JingjiManager.getMaxWingPoint();
/*     */     }
/*     */     
/* 245 */     logstr = String.format("[jingji]POnPVPFightEnd.computeWinPoint@compute role win point success|roleid=%d|beforeWinPointA=%d|beforewinPointB=%d|afterwinPointA=%d|x=%f|y=%d|iswin=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(beforeWinPointA), Integer.valueOf(beforewinPointB), Integer.valueOf(afterwinPointA), Double.valueOf(x), Integer.valueOf(y), Integer.valueOf(iswin ? 1 : 0) });
/*     */     
/*     */ 
/*     */ 
/* 249 */     JingjiManager.logger.info(logstr);
/* 250 */     return afterwinPointA;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\POnPVPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */