/*     */ package mzm.gsp.crossserver.event;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.List;
/*     */ import mzm.gsp.crossbattle.CrossBattleBetRankData;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GetCrossBattleBetLoseRankRangeDoneArg
/*     */ {
/*     */   private final int retcode;
/*     */   private final long rankid;
/*     */   private final int from;
/*     */   private final int to;
/*     */   private final int rankSize;
/*     */   private final List<CrossBattleBetRankData> rankRange;
/*     */   private final Octets context;
/*     */   
/*     */   public GetCrossBattleBetLoseRankRangeDoneArg(int retcode, long rankid, int from, int to, int rankSize, List<CrossBattleBetRankData> rankRange, Octets context)
/*     */   {
/*  26 */     this.retcode = retcode;
/*  27 */     this.rankid = rankid;
/*  28 */     this.from = from;
/*  29 */     this.to = to;
/*  30 */     this.rankSize = rankSize;
/*  31 */     this.rankRange = rankRange;
/*  32 */     this.context = context;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSucceed()
/*     */   {
/*  42 */     return this.retcode == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isTimeout()
/*     */   {
/*  52 */     return this.retcode == 8;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isNoRankData()
/*     */   {
/*  62 */     return this.retcode == 601;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRetCode()
/*     */   {
/*  72 */     return this.retcode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getRankid()
/*     */   {
/*  82 */     return this.rankid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getFrom()
/*     */   {
/*  92 */     return this.from;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getTo()
/*     */   {
/* 102 */     return this.to;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRankSize()
/*     */   {
/* 112 */     return this.rankSize;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final List<CrossBattleBetRankData> getRankRange()
/*     */   {
/* 122 */     return this.rankRange;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Octets getContext()
/*     */   {
/* 132 */     return this.context;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\GetCrossBattleBetLoseRankRangeDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */