/*     */ package mzm.gsp.petarena.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.petarena.SRefreshOpponentFailed;
/*     */ import mzm.gsp.petarena.SRefreshOpponentSuccess;
/*     */ import mzm.gsp.petarena.confbean.SPetArenaConst;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PetArenaInfo;
/*     */ import xbean.PetArenaRankInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class PCRefreshOpponent extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PCRefreshOpponent(long roleid)
/*     */   {
/*  25 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     if (!PetArenaManager.canDoAction(this.roleid, 2112))
/*     */     {
/*  33 */       return false;
/*     */     }
/*     */     
/*  36 */     if (!PetArenaManager.isFunOpen(this.roleid))
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     int level = RoleInterface.getLevel(this.roleid);
/*  42 */     if (level < SPetArenaConst.getInstance().OPEN_LEVEL)
/*     */     {
/*  44 */       onFailed(-1);
/*  45 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  49 */     String userid = RoleInterface.getUserId(this.roleid);
/*  50 */     lock(Lockeys.get(xtable.User.getTable(), userid));
/*  51 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     
/*  53 */     PetArenaInfo xPetArenaInfo = xtable.Role2petarenainfo.get(Long.valueOf(this.roleid));
/*  54 */     if (xPetArenaInfo == null)
/*     */     {
/*  56 */       onFailed(1);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  61 */     long cd = TimeUnit.SECONDS.toMillis(SPetArenaConst.getInstance().REFRESH_CD);
/*  62 */     if (xPetArenaInfo.getRefresh_time() + cd > now)
/*     */     {
/*  64 */       onFailed(-3);
/*  65 */       return false;
/*     */     }
/*  67 */     xPetArenaInfo.setRefresh_time(now);
/*     */     
/*  69 */     int rank = PetArenaRankManager.getInstance().getRank(this.roleid);
/*  70 */     int randomRank = rank;
/*  71 */     if (randomRank <= 0)
/*     */     {
/*  73 */       randomRank = SPetArenaConst.getInstance().ROBOT_NUM + 1;
/*     */     }
/*     */     
/*  76 */     List<Integer> ranks = PetArenaManager.getOpponentRanks(randomRank);
/*  77 */     List<RankInfo> rankInfos = PetArenaRankManager.getInstance().getRankInfos(ranks);
/*  78 */     List<PetArenaRankInfo> xPetArenaRankInfos = xPetArenaInfo.getOpponent_ranks();
/*  79 */     xPetArenaRankInfos.clear();
/*  80 */     for (RankInfo rankInfo : rankInfos)
/*     */     {
/*  82 */       PetArenaRankInfo xPetArenaRankInfo = xbean.Pod.newPetArenaRankInfo();
/*  83 */       xPetArenaRankInfo.setRank(rankInfo.rank);
/*  84 */       xPetArenaRankInfo.setRoleid(rankInfo.roleid);
/*  85 */       xPetArenaRankInfos.add(xPetArenaRankInfo);
/*     */     }
/*  87 */     int newOpponentSerial = xPetArenaInfo.getOpponent_serial() + 1;
/*  88 */     xPetArenaInfo.setOpponent_serial(newOpponentSerial);
/*     */     
/*  90 */     PetArenaManager.sendOpponentsInfos(this.roleid, rankInfos, newOpponentSerial);
/*     */     
/*  92 */     SRefreshOpponentSuccess rsp = new SRefreshOpponentSuccess();
/*  93 */     rsp.rank = rank;
/*  94 */     rsp.refresh_time = ((int)TimeUnit.MILLISECONDS.toSeconds(now));
/*  95 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*     */     
/*  97 */     GameServer.logger().info(String.format("[petarena]PCRefreshOpponent.processImp@refresh success|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*  98 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 103 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 108 */     SRefreshOpponentFailed rsp = new SRefreshOpponentFailed();
/* 109 */     rsp.retcode = retcode;
/* 110 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*     */     
/* 112 */     StringBuilder logBuilder = new StringBuilder();
/* 113 */     logBuilder.append("[petarena]PCRefreshOpponent.onFailed@refresh opponent failed");
/* 114 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 115 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 117 */     if (extraParams != null)
/*     */     {
/* 119 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 121 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 125 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PCRefreshOpponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */