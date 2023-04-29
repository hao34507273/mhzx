/*     */ package mzm.gsp.util;
/*     */ 
/*     */ import java.io.PrintStream;
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
/*     */ public class ELO
/*     */ {
/*     */   public static enum MatchResult
/*     */   {
/*  18 */     Win(1.0D), 
/*  19 */     Draw(0.5D), 
/*  20 */     Lose(0.0D);
/*     */     
/*     */     private final double score;
/*     */     
/*     */     private MatchResult(double score) {
/*  25 */       this.score = score;
/*     */     }
/*     */     
/*     */     public double getScore() {
/*  29 */       return this.score;
/*     */     }
/*     */     
/*     */     public MatchResult getOppositeResult() {
/*  33 */       switch (ELO.1.$SwitchMap$mzm$gsp$util$ELO$MatchResult[ordinal()]) {
/*     */       case 1: 
/*  35 */         return Lose;
/*     */       case 2: 
/*  37 */         return Draw;
/*     */       case 3: 
/*  39 */         return Win;
/*     */       }
/*  41 */       throw new RuntimeException("[ELO] getOppositeResult Error :" + this);
/*     */     }
/*     */     
/*     */     public double getOppositeScore()
/*     */     {
/*  46 */       return getOppositeResult().score;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static class RankResult
/*     */   {
/*     */     private int rankA;
/*     */     
/*     */ 
/*     */ 
/*     */     private int rankB;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public int getRankA()
/*     */     {
/*  67 */       return this.rankA;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public int getRankB()
/*     */     {
/*  75 */       return this.rankB;
/*     */     }
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
/*     */   public static double winRateA(int rankA, int rankB)
/*     */   {
/*  92 */     int rankDiff = rankA - rankB;
/*     */     
/*  94 */     if (rankDiff >= 0) {
/*  95 */       return winRate(rankDiff);
/*     */     }
/*     */     
/*  98 */     return 1.0D - winRate(-rankDiff);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static double winRate(int rankDiff)
/*     */   {
/* 110 */     return 1.0D / (1.0D + Math.pow(10.0D, -rankDiff / 400.0D));
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
/*     */ 
/*     */   public static RankResult getELORankResult(int rankA, int rankB, int k, MatchResult matchResult)
/*     */   {
/* 131 */     RankResult result = new RankResult();
/* 132 */     double pA = winRateA(rankA, rankB);
/* 133 */     double pB = 1.0D - pA;
/*     */     
/* 135 */     result.rankA = (rankA + (int)(k * (matchResult.getScore() - pA)));
/* 136 */     result.rankB = (rankB + (int)(k * (matchResult.getOppositeScore() - pB)));
/*     */     
/* 138 */     return result;
/*     */   }
/*     */   
/*     */   public static RankResult getELORankIncResult(int rankA, int rankB, int k, MatchResult matchResult)
/*     */   {
/* 143 */     RankResult result = new RankResult();
/* 144 */     double pA = winRateA(rankA, rankB);
/* 145 */     double pB = 1.0D - pA;
/*     */     
/* 147 */     result.rankA = ((int)(k * (matchResult.getScore() - pA)));
/* 148 */     result.rankB = ((int)(k * (matchResult.getOppositeScore() - pB)));
/*     */     
/* 150 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 156 */     for (int i = 0; i < 1000; i += 5) {
/* 157 */       System.out.println(i + " : " + winRate(i));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\ELO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */