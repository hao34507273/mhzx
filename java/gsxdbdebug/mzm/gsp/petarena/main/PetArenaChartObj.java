/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.ChartObj;
/*    */ import mzm.gsp.chart.main.ObjWithKey;
/*    */ 
/*    */ public class PetArenaChartObj
/*    */   extends ChartObj<Integer, PetArenaChartObj> implements ObjWithKey<Integer>
/*    */ {
/*    */   private final int rank;
/*    */   private final long roleid;
/*    */   private final String name;
/*    */   private final int winNum;
/*    */   private final int loseNum;
/*    */   private final int defendWinNum;
/*    */   private final int defendLoseNum;
/*    */   
/*    */   public PetArenaChartObj(int rank)
/*    */   {
/* 19 */     this(rank, 0L, "", 0, 0, 0, 0);
/*    */   }
/*    */   
/*    */ 
/*    */   public PetArenaChartObj(int rank, long roleid, String name, int winNum, int loseNum, int defendWinNum, int defendLoseNum)
/*    */   {
/* 25 */     this.rank = rank;
/*    */     
/* 27 */     this.roleid = roleid;
/* 28 */     this.name = name;
/* 29 */     this.winNum = winNum;
/* 30 */     this.loseNum = loseNum;
/* 31 */     this.defendWinNum = defendWinNum;
/* 32 */     this.defendLoseNum = defendLoseNum;
/*    */   }
/*    */   
/*    */   public long getRoleid()
/*    */   {
/* 37 */     return this.roleid;
/*    */   }
/*    */   
/*    */   public int getRank()
/*    */   {
/* 42 */     return this.rank;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 47 */     return this.name;
/*    */   }
/*    */   
/*    */   public int getWinNum()
/*    */   {
/* 52 */     return this.winNum;
/*    */   }
/*    */   
/*    */   public int getLoseNum()
/*    */   {
/* 57 */     return this.loseNum;
/*    */   }
/*    */   
/*    */   public int getDefendWinNum()
/*    */   {
/* 62 */     return this.defendWinNum;
/*    */   }
/*    */   
/*    */   public int getDefendLoseNum()
/*    */   {
/* 67 */     return this.defendLoseNum;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isAvailable()
/*    */   {
/* 73 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isTopThan(PetArenaChartObj rankObj)
/*    */   {
/* 79 */     return this.rank < rankObj.rank;
/*    */   }
/*    */   
/*    */ 
/*    */   public Integer getKey()
/*    */   {
/* 85 */     return Integer.valueOf(this.rank);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PetArenaChartObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */