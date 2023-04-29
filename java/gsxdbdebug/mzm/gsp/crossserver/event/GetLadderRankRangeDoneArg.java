/*     */ package mzm.gsp.crossserver.event;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import mzm.gsp.ladder.LadderRankRoleData;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GetLadderRankRangeDoneArg
/*     */ {
/*     */   private final int retcode;
/*     */   private final long rankid;
/*     */   private final int from;
/*     */   private final int to;
/*     */   private final int rankSize;
/*     */   private final Octets context;
/*     */   private final ArrayList<LadderRankRoleData> rankRange;
/*     */   
/*     */   public GetLadderRankRangeDoneArg(int retcode, long rankid, int from, int to, Octets context, int rankSize, ArrayList<LadderRankRoleData> rankRange)
/*     */   {
/*  23 */     this.retcode = retcode;
/*  24 */     this.rankid = rankid;
/*  25 */     this.from = from;
/*  26 */     this.to = to;
/*  27 */     this.context = context;
/*  28 */     this.rankSize = rankSize;
/*  29 */     this.rankRange = rankRange;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean isSucceed()
/*     */   {
/*  39 */     return this.retcode == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean isTimeout()
/*     */   {
/*  49 */     return this.retcode == 8;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean isNoRankData()
/*     */   {
/*  59 */     return this.retcode == 601;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getRetCode()
/*     */   {
/*  69 */     return this.retcode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final long getRankid()
/*     */   {
/*  79 */     return this.rankid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getFrom()
/*     */   {
/*  89 */     return this.from;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getTo()
/*     */   {
/*  99 */     return this.to;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final Octets getContext()
/*     */   {
/* 109 */     return this.context;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getRankSize()
/*     */   {
/* 119 */     return this.rankSize;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final ArrayList<LadderRankRoleData> rankRange()
/*     */   {
/* 130 */     return this.rankRange;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\GetLadderRankRangeDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */