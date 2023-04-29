/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.RankManagerNew;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.PetArenaRankInfo;
/*    */ 
/*    */ public class PetArenaChart extends RankManagerNew<Integer, PetArenaChartObj>
/*    */ {
/*    */   public PetArenaChart(int capacity, int extraSize)
/*    */   {
/* 11 */     super(capacity, extraSize);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void saveToDB() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public void rankDataFromDB()
/*    */   {
/* 23 */     for (int i = 0; i < this.capacity; i++)
/*    */     {
/* 25 */       rank(new PetArenaChartObj(i + 1));
/*    */     }
/*    */     
/* 28 */     long key = mzm.gsp.GameServerInfoManager.getLocalId();
/* 29 */     xbean.PetArenaRank xPetArenaRank = xtable.Petarenarank.get(Long.valueOf(key));
/* 30 */     if (xPetArenaRank == null)
/*    */     {
/* 32 */       return;
/*    */     }
/*    */     
/* 35 */     for (PetArenaRankInfo xPetArenaRankInfo : xPetArenaRank.getRanks())
/*    */     {
/* 37 */       int rank = xPetArenaRankInfo.getRank();
/* 38 */       if (rank > this.capacity) {
/*    */         break;
/*    */       }
/*    */       
/* 42 */       long roleid = xPetArenaRankInfo.getRoleid();
/* 43 */       if (roleid > 0L)
/*    */       {
/* 45 */         NoneRealTimeTaskManager.getInstance().addTask(new PRankPetArenaChart(roleid, rank));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PetArenaChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */