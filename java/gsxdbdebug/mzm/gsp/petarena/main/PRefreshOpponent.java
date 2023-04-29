/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.petarena.confbean.SPetArenaConst;
/*    */ import xbean.PetArenaInfo;
/*    */ import xbean.PetArenaRankInfo;
/*    */ 
/*    */ public class PRefreshOpponent extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PRefreshOpponent(long roleid)
/*    */   {
/* 15 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     PetArenaInfo xPetArenaInfo = xtable.Role2petarenainfo.get(Long.valueOf(this.roleid));
/* 22 */     if (xPetArenaInfo == null)
/*    */     {
/* 24 */       return false;
/*    */     }
/*    */     
/* 27 */     int rank = PetArenaRankManager.getInstance().getRank(this.roleid);
/* 28 */     int randomRank = rank;
/* 29 */     if (randomRank <= 0)
/*    */     {
/* 31 */       randomRank = SPetArenaConst.getInstance().ROBOT_NUM + 1;
/*    */     }
/*    */     
/* 34 */     List<Integer> ranks = PetArenaManager.getOpponentRanks(randomRank);
/* 35 */     List<RankInfo> rankInfos = PetArenaRankManager.getInstance().getRankInfos(ranks);
/* 36 */     List<PetArenaRankInfo> xPetArenaRankInfos = xPetArenaInfo.getOpponent_ranks();
/* 37 */     xPetArenaRankInfos.clear();
/* 38 */     for (RankInfo rankInfo : rankInfos)
/*    */     {
/* 40 */       PetArenaRankInfo xPetArenaRankInfo = xbean.Pod.newPetArenaRankInfo();
/* 41 */       xPetArenaRankInfo.setRank(rankInfo.rank);
/* 42 */       xPetArenaRankInfo.setRoleid(rankInfo.roleid);
/* 43 */       xPetArenaRankInfos.add(xPetArenaRankInfo);
/*    */     }
/* 45 */     xPetArenaInfo.setOpponent_serial(xPetArenaInfo.getOpponent_serial() + 1);
/*    */     
/* 47 */     GameServer.logger().info(String.format("[petarena]PRefreshOpponent.processImp@refresh opponent|roleid=%d|rank=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(rank) }));
/*    */     
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PRefreshOpponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */