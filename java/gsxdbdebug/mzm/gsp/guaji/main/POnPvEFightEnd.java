/*     */ package mzm.gsp.guaji.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.SDigongGuaYeConst;
/*     */ import mzm.gsp.activity.confbean.SMonsterLevelAwardCfg;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.fight.event.PVEFightEndArg;
/*     */ import mzm.gsp.fight.event.PVEFightEndProcedure;
/*     */ import mzm.gsp.map.main.MapDarkMonsterFightContext;
/*     */ import mzm.gsp.map.main.MapFightContext.EXTRADATA_TYPE;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnPvEFightEnd extends PVEFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  28 */     if ((((PVEFightEndArg)this.arg).context == null) || (!(((PVEFightEndArg)this.arg).context instanceof MapDarkMonsterFightContext)))
/*     */     {
/*  30 */       return false;
/*     */     }
/*     */     
/*  33 */     MapDarkMonsterFightContext monsterFightContext = (MapDarkMonsterFightContext)((PVEFightEndArg)this.arg).context;
/*  34 */     SMonsterLevelAwardCfg awardCfg = DiGongGuaJIManager.getAward(monsterFightContext.mapId);
/*  35 */     int award_ID1 = SDigongGuaYeConst.getInstance().AWARD_ID1;
/*  36 */     int award_ID2 = SDigongGuaYeConst.getInstance().AWARD_ID2;
/*  37 */     if (awardCfg != null)
/*     */     {
/*  39 */       award_ID1 = awardCfg.awardTypeId1;
/*  40 */       award_ID2 = awardCfg.awardTypeId2;
/*     */     }
/*     */     
/*  43 */     int awardId_1 = -1;
/*  44 */     int awardId_2 = -1;
/*  45 */     if (DiGongGuaJIManager.checkMonster1(((PVEFightEndArg)this.arg).diedMonsters))
/*     */     {
/*  47 */       awardId_1 = award_ID1;
/*     */     }
/*  49 */     if (DiGongGuaJIManager.checkMonster2(((PVEFightEndArg)this.arg).diedMonsters))
/*     */     {
/*  51 */       awardId_2 = award_ID2;
/*     */     }
/*  53 */     if ((awardId_1 < 0) && (awardId_2 < 0))
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     int maxLv = 0;
/*  59 */     Map<Long, Integer> roleId2Lv = new HashMap();
/*  60 */     for (Iterator i$ = ((PVEFightEndArg)this.arg).roleList.iterator(); i$.hasNext();) { long eachRoleId = ((Long)i$.next()).longValue();
/*     */       
/*  62 */       int lv = RoleInterface.getLevel(eachRoleId);
/*  63 */       roleId2Lv.put(Long.valueOf(eachRoleId), Integer.valueOf(lv));
/*  64 */       maxLv = Math.max(maxLv, lv);
/*     */     }
/*  66 */     int averageLv = getAvgLevel(maxLv, roleId2Lv);
/*     */     
/*  68 */     Map<Long, String> allUsers = getAllUserLock();
/*     */     
/*  70 */     List<Long> fightRoleList = getFightRoleIds();
/*  71 */     if (!((PVEFightEndArg)this.arg).isPlayerWin)
/*     */     {
/*  73 */       GuajiTlogManager.tlogAfterLose(fightRoleList, monsterFightContext.mapId);
/*  74 */       return true;
/*     */     }
/*     */     
/*  77 */     boolean isGetDouble = (monsterFightContext.getExtra(MapFightContext.EXTRADATA_TYPE.USE_DOUBLEPOINT) != null) && (monsterFightContext.getExtra(MapFightContext.EXTRADATA_TYPE.USE_DOUBLEPOINT).intValue() == 1);
/*     */     
/*  79 */     long usePointRoleId = -1L;
/*  80 */     if (isGetDouble)
/*     */     {
/*  82 */       usePointRoleId = monsterFightContext.getExtra(MapFightContext.EXTRADATA_TYPE.USE_DOUBPLEPOINT_ROLEID_HIGH).intValue() << 32 | monsterFightContext.getExtra(MapFightContext.EXTRADATA_TYPE.USE_DOUBPLEPOINT_ROLEID_LOW).intValue();
/*     */     }
/*     */     
/*  85 */     TLogArg logArg = new TLogArg(LogReason.HUNDUNSHIKONG_ACTIVITY_ADD);
/*  86 */     for (Iterator i$ = fightRoleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  88 */       boolean getDouble = isGetDouble;
/*  89 */       if (usePointRoleId != roleId)
/*     */       {
/*  91 */         getDouble = GuajiInterface.costDoublePoint(roleId, SwitchType.GuaJi, SDigongGuaYeConst.getInstance().EVERYFIGHT_COST_DOUBLEPOINT, logArg);
/*     */       }
/*     */       
/*  94 */       Integer roleLevel = (Integer)roleId2Lv.get(Long.valueOf(roleId));
/*  95 */       if (roleLevel == null)
/*     */       {
/*  97 */         GameServer.logger().error(String.format("[guaji]POnPvEFightEnd.processImp@ not contain role level!|roleId=%d|roleIds=%s|fightRoleIds=%s", new Object[] { Long.valueOf(roleId), ((PVEFightEndArg)this.arg).roleList.toString(), fightRoleList.toString() }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 103 */         int modifyTableIdId = DiGongGuaJIManager.getModifyTableIdId(roleLevel.intValue() - averageLv, getDouble);
/* 104 */         if (awardId_1 > 0)
/*     */         {
/* 106 */           AwardInterface.award(awardId_1, (String)allUsers.get(Long.valueOf(roleId)), roleId, modifyTableIdId, fightRoleList, ((PVEFightEndArg)this.arg).roleList, false, true, new AwardReason(LogReason.HUNDUNSHIKONG_ACTIVITY_ADD));
/*     */         }
/*     */         
/* 109 */         if (awardId_2 > 0)
/*     */         {
/* 111 */           AwardInterface.award(awardId_2, (String)allUsers.get(Long.valueOf(roleId)), roleId, modifyTableIdId, fightRoleList, ((PVEFightEndArg)this.arg).roleList, false, true, new AwardReason(LogReason.HUNDUNSHIKONG_ACTIVITY_ADD));
/*     */         }
/*     */         
/* 114 */         GuajiTlogManager.tlogGuaji(roleId, true, monsterFightContext.mapId, getDouble);
/*     */       }
/*     */     }
/* 117 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.guaji.event.FinishOneGuajiEvent(), new FinishOneGuajiEventArg(fightRoleList));
/* 118 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private List<Long> getFightRoleIds()
/*     */   {
/* 128 */     List<Long> fightRoleList = new ArrayList();
/* 129 */     fightRoleList.addAll(((PVEFightEndArg)this.arg).roleList);
/* 130 */     fightRoleList.removeAll(((PVEFightEndArg)this.arg).escapedRoles);
/* 131 */     return fightRoleList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Map<Long, String> getAllUserLock()
/*     */   {
/* 141 */     Map<Long, String> allUsers = new HashMap();
/* 142 */     for (Long roleid : ((PVEFightEndArg)this.arg).roleList)
/*     */     {
/* 144 */       String userid = RoleInterface.getUserId(roleid.longValue());
/* 145 */       allUsers.put(roleid, userid);
/*     */     }
/* 147 */     lock(User.getTable(), allUsers.values());
/* 148 */     lock(xtable.Role2properties.getTable(), ((PVEFightEndArg)this.arg).roleList);
/* 149 */     return allUsers;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getAvgLevel(int maxLv, Map<Long, Integer> roleId2Lv)
/*     */   {
/* 161 */     List<Long> avaliableRoleIdList = new ArrayList();
/* 162 */     int totalLv = 0;
/* 163 */     for (Map.Entry<Long, Integer> entry : roleId2Lv.entrySet())
/*     */     {
/* 165 */       if (maxLv - ((Integer)entry.getValue()).intValue() <= SDigongGuaYeConst.getInstance().TEAM_MAX_DIF_LEVEL)
/*     */       {
/*     */ 
/*     */ 
/* 169 */         totalLv += ((Integer)entry.getValue()).intValue();
/* 170 */         avaliableRoleIdList.add(entry.getKey());
/*     */       } }
/* 172 */     int averageLv = totalLv / avaliableRoleIdList.size();
/* 173 */     return averageLv;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\main\POnPvEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */