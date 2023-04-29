/*     */ package mzm.gsp.visiblemonsterfight.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.fight.event.PVEFightEndArg;
/*     */ import mzm.gsp.fight.event.PVEFightEndProcedure;
/*     */ import mzm.gsp.item.confbean.SVigorItem;
/*     */ import mzm.gsp.map.main.MapFightContext.EXTRADATA_TYPE;
/*     */ import mzm.gsp.map.main.MapVisibleMonsterFightContext;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnPvEFightEnd extends PVEFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  26 */     if ((((PVEFightEndArg)this.arg).context != null) && ((((PVEFightEndArg)this.arg).context instanceof MapVisibleMonsterFightContext))) {
/*  27 */       MapVisibleMonsterFightContext localMapVisibleMonsterFightContext = (MapVisibleMonsterFightContext)((PVEFightEndArg)this.arg).context;
/*  28 */       ArrayList localArrayList1 = new ArrayList();
/*  29 */       localArrayList1.addAll(((PVEFightEndArg)this.arg).diedMonsters);
/*  30 */       localArrayList1.addAll(((PVEFightEndArg)this.arg).alivedMonsters);
/*  31 */       localArrayList1.addAll(((PVEFightEndArg)this.arg).escapedMonsters);
/*  32 */       ArrayList localArrayList2 = new ArrayList();
/*  33 */       localArrayList2.addAll(((PVEFightEndArg)this.arg).roleList);
/*  34 */       HashMap localHashMap = new HashMap();
/*  35 */       Iterator<Long> iterator = localArrayList2.iterator();
/*     */       
/*  37 */       while (iterator.hasNext()) {
/*  38 */         Long localLong = (Long)iterator.next();
/*  39 */         String str = RoleInterface.getUserId(localLong.longValue());
/*  40 */         localHashMap.put(localLong, str);
/*     */       }
/*     */       
/*  43 */       lock(User.getTable(), localHashMap.values());
/*  44 */       lock(xtable.Role2properties.getTable(), localArrayList2);
/*  45 */       VisibleMonsterFightContext fightContext = new VisibleMonsterFightContext();
/*  46 */       fightContext.enterFightLowLevel = localMapVisibleMonsterFightContext.getExtra(MapFightContext.EXTRADATA_TYPE.ENTER_FIGHT_LOW_LEVEL_LIMIT).intValue();
/*  47 */       fightContext.starLevel = localMapVisibleMonsterFightContext.getExtra(MapFightContext.EXTRADATA_TYPE.MONSTER_STAR_LEVEL);
/*  48 */       fightContext.instanceId = localMapVisibleMonsterFightContext.instanceId;
/*  49 */       fightContext.monsterCfgId = localMapVisibleMonsterFightContext.monsterCfgId;
/*  50 */       fightContext.sceneId = localMapVisibleMonsterFightContext.mapId;
/*  51 */       fightContext.worldId = localMapVisibleMonsterFightContext.worldId;
/*  52 */       fightContext.monsterid2level = ((PVEFightEndArg)this.arg).monsteridToLevel;
/*  53 */       fightContext.monsterIdList = localArrayList1;
/*  54 */       fightContext.fightId = ((PVEFightEndArg)this.arg).fightCfgID;
/*  55 */       fightContext.roleList = ((PVEFightEndArg)this.arg).notEscapeRoles();
/*  56 */       fightContext.allRoles = ((PVEFightEndArg)this.arg).roleList;
/*  57 */       fightContext.allUsers = localHashMap;
/*     */       
/*  59 */       VisibleMonsterFightContext localObject = fightContext;
/*     */       
/*  61 */       if (((PVEFightEndArg)this.arg).isPlayerWin) {
/*  62 */         VisibleMonsterFightManager.getInstance().onMonsterDead(localObject);
/*     */       } else {
/*  64 */         VisibleMonsterFightManager.getInstance().onMonsterWin(localObject);
/*     */       }
/*     */       
/*     */ 
/*  68 */       if (((PVEFightEndArg)this.arg).isPlayerWin) {
/*  69 */         SVigorItem teamAward = gatteamAward();
/*  70 */         if ((teamAward != null) && (teamAward.isProprietary)) {
/*  71 */           long m1 = ((Long)((PVEFightEndArg)this.arg).roleList.get(0)).longValue();
/*  72 */           int teamMember = ((PVEFightEndArg)this.arg).roleList.size();
/*  73 */           if (teamMember >= 2) {
/*  74 */             long teamleader = TeamInterface.getTeamLeaderByRoleid(m1, false, false);
/*  75 */             int awardID = 0;
/*  76 */             switch (teamMember) {
/*     */             case 2: 
/*  78 */               awardID = teamAward.addVigorNum;
/*  79 */               break;
/*     */             case 3: 
/*  81 */               awardID = teamAward.icon;
/*  82 */               break;
/*     */             case 4: 
/*  84 */               awardID = teamAward.namecolor;
/*  85 */               break;
/*     */             case 5: 
/*  87 */               awardID = teamAward.pilemax;
/*     */             }
/*     */             
/*  90 */             if (awardID != 0) {
/*  91 */               int awardconut = RoleInterface.getDayCounter(teamleader, 5000);
/*  92 */               if (awardconut < 5000) {
/*  93 */                 String userid = RoleInterface.getUserId(teamleader);
/*  94 */                 AwardInterface.awardNoneRealTime(awardID, userid, teamleader, false, true, new AwardReason(LogReason.GM_ADD));
/*  95 */                 RoleInterface.addDayCounter(teamleader, 5000, 1);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 103 */     return true;
/*     */   }
/*     */   
/*     */   private SVigorItem gatteamAward() {
/* 107 */     Iterator i$ = SVigorItem.getAllSelf().entrySet().iterator();
/*     */     SVigorItem titem;
/*     */     do
/*     */     {
/* 111 */       if (!i$.hasNext()) {
/* 112 */         return null;
/*     */       }
/*     */       
/* 115 */       Map.Entry<Integer, SVigorItem> item = (Map.Entry)i$.next();
/* 116 */       titem = (SVigorItem)item.getValue();
/* 117 */     } while (titem.sellSilver != 999);
/*     */     
/* 119 */     return titem;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\POnPvEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */