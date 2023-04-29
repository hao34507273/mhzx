/*     */ package mzm.gsp.petarena.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.petarena.SStartFightSuccess;
/*     */ import mzm.gsp.petarena.confbean.SPetArenaConst;
/*     */ import mzm.gsp.petarena.event.PetArenaRankChangedArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PetArenaFightRecordInfo;
/*     */ import xbean.PetArenaInfo;
/*     */ import xbean.PetArenaRankInfo;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class POnPetArenaRankChanged extends mzm.gsp.petarena.event.PetArenaRankChangedProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  19 */     long roleid = ((PetArenaRankChangedArg)this.arg).roleid;
/*  20 */     long opponentRoleid = ((PetArenaRankChangedArg)this.arg).opponentRoleid;
/*  21 */     int oldRank = ((PetArenaRankChangedArg)this.arg).oldRank;
/*  22 */     int newRank = ((PetArenaRankChangedArg)this.arg).newRank;
/*  23 */     boolean win = ((PetArenaRankChangedArg)this.arg).win;
/*  24 */     boolean changed = ((PetArenaRankChangedArg)this.arg).changed;
/*  25 */     PetArenaFightResultContext resultContext = ((PetArenaRankChangedArg)this.arg).resultContext;
/*  26 */     int fightType = ((PetArenaRankChangedArg)this.arg).type;
/*     */     
/*     */ 
/*  29 */     if (opponentRoleid > 0L)
/*     */     {
/*  31 */       lock(xdb.Lockeys.get(Basic.getTable(), new Object[] { Long.valueOf(roleid), Long.valueOf(opponentRoleid) }));
/*     */     }
/*     */     else
/*     */     {
/*  35 */       lock(xdb.Lockeys.get(Basic.getTable(), Long.valueOf(roleid)));
/*     */     }
/*     */     
/*  38 */     PetArenaInfo xPetArenaInfo = xtable.Role2petarenainfo.get(Long.valueOf(roleid));
/*  39 */     if (xPetArenaInfo == null)
/*     */     {
/*  41 */       GameServer.logger().error(String.format("[petarena]POnPetArenaRankChanged.processImp@system error|roleid=%d|opponent_roleid=%d|old_rank=%d|new_rank=%d|type=%d|win=%b|changed=%b", new Object[] { Long.valueOf(roleid), Long.valueOf(opponentRoleid), Integer.valueOf(oldRank), Integer.valueOf(newRank), Integer.valueOf(fightType), Boolean.valueOf(win), Boolean.valueOf(changed) }));
/*     */       
/*     */ 
/*     */ 
/*  45 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  49 */     int maxRecordSize = SPetArenaConst.getInstance().MAX_RECORD_NUM;
/*  50 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  51 */     PetArenaFightRecordInfo xFightRecordInfo = PetArenaManager.buildFightRecordInfo(resultContext.recordid, ((PetArenaRankChangedArg)this.arg).type, win, oldRank, changed ? newRank : oldRank, opponentRoleid, now, ((PetArenaRankChangedArg)this.arg).activeInfos, ((PetArenaRankChangedArg)this.arg).passiveInfos, resultContext.damages);
/*     */     
/*     */ 
/*  54 */     List<PetArenaFightRecordInfo> xRecords = xPetArenaInfo.getRecords();
/*  55 */     xRecords.add(0, xFightRecordInfo);
/*  56 */     if (xRecords.size() > maxRecordSize)
/*     */     {
/*  58 */       xRecords.remove(xRecords.size() - 1);
/*     */     }
/*     */     
/*     */ 
/*  62 */     List<Integer> ranks = null;
/*  63 */     boolean refresh = false;
/*  64 */     if (changed)
/*     */     {
/*  66 */       int randomRank = newRank;
/*  67 */       if (randomRank <= 0)
/*     */       {
/*  69 */         randomRank = SPetArenaConst.getInstance().ROBOT_NUM + 1;
/*     */       }
/*  71 */       putInChart(randomRank, roleid, xPetArenaInfo);
/*     */       
/*  73 */       for (PetArenaRankInfo xPetArenaRankInfo : xPetArenaInfo.getOpponent_ranks())
/*     */       {
/*  75 */         if (xPetArenaRankInfo.getRank() == newRank)
/*     */         {
/*  77 */           refresh = true;
/*  78 */           break;
/*     */         }
/*     */       }
/*  81 */       ranks = PetArenaManager.getOpponentRanks(randomRank);
/*     */     }
/*     */     else
/*     */     {
/*  85 */       putInChart(oldRank, roleid, xPetArenaInfo);
/*  86 */       ranks = new java.util.ArrayList();
/*  87 */       for (PetArenaRankInfo xPetArenaRankInfo : xPetArenaInfo.getOpponent_ranks())
/*     */       {
/*  89 */         ranks.add(Integer.valueOf(xPetArenaRankInfo.getRank()));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  94 */     boolean send = ((PetArenaRankChangedArg)this.arg).send;
/*  95 */     if ((send) || (refresh))
/*     */     {
/*  97 */       List<RankInfo> rankInfos = PetArenaRankManager.getInstance().getRankInfos(ranks);
/*  98 */       List<PetArenaRankInfo> xPetArenaRankInfos = xPetArenaInfo.getOpponent_ranks();
/*  99 */       xPetArenaRankInfos.clear();
/* 100 */       for (RankInfo rankInfo : rankInfos)
/*     */       {
/* 102 */         PetArenaRankInfo xPetArenaRankInfo = xbean.Pod.newPetArenaRankInfo();
/* 103 */         xPetArenaRankInfo.setRank(rankInfo.rank);
/* 104 */         xPetArenaRankInfo.setRoleid(rankInfo.roleid);
/* 105 */         xPetArenaRankInfos.add(xPetArenaRankInfo);
/*     */       }
/* 107 */       int newOpponentSerial = xPetArenaInfo.getOpponent_serial() + 1;
/* 108 */       xPetArenaInfo.setOpponent_serial(newOpponentSerial);
/*     */       
/* 110 */       if (send)
/*     */       {
/* 112 */         PetArenaManager.sendOpponentsInfos(roleid, rankInfos, newOpponentSerial);
/*     */         
/* 114 */         SStartFightSuccess msg = new SStartFightSuccess();
/* 115 */         PetArenaManager.fillPetArenaInfo(msg.pet_arena_info, roleid, changed ? newRank : oldRank, xPetArenaInfo);
/* 116 */         OnlineManager.getInstance().send(roleid, msg);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 121 */     PetArenaManager.addTLog(roleid, "PetArenaFightRecordForServer", new Object[] { Integer.valueOf(changed ? newRank : oldRank), Integer.valueOf(oldRank), Integer.valueOf(fightType), Integer.valueOf(win ? 1 : 0), Long.valueOf(opponentRoleid), Integer.valueOf(xPetArenaInfo.getChallenge_count()), Integer.valueOf(resultContext.addPoint) });
/*     */     
/*     */ 
/* 124 */     GameServer.logger().info(String.format("[petarena]POnPetArenaRankChanged.processImp@handle success|roleid=%d|opponent_roleid=%d|old_rank=%d|new_rank=%d|type=%d|win=%b|changed=%b", new Object[] { Long.valueOf(roleid), Long.valueOf(opponentRoleid), Integer.valueOf(oldRank), Integer.valueOf(newRank), Integer.valueOf(fightType), Boolean.valueOf(win), Boolean.valueOf(changed) }));
/*     */     
/*     */ 
/*     */ 
/* 128 */     return true;
/*     */   }
/*     */   
/*     */   private void putInChart(int rank, long roleid, PetArenaInfo xPetArenaInfo)
/*     */   {
/* 133 */     int capacity = PetArenaChartManager.capacity();
/* 134 */     if (rank < capacity)
/*     */     {
/* 136 */       String name = mzm.gsp.role.main.RoleInterface.getName(roleid);
/* 137 */       PetArenaChartObj chartObj = new PetArenaChartObj(rank, roleid, name, xPetArenaInfo.getWin_num(), xPetArenaInfo.getLose_num(), xPetArenaInfo.getDefend_win_num(), xPetArenaInfo.getDefend_lose_num());
/*     */       
/*     */ 
/*     */ 
/* 141 */       PetArenaChartManager.rank(chartObj);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\POnPetArenaRankChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */