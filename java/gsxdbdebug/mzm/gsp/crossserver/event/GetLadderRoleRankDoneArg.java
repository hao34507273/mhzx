/*     */ package mzm.gsp.crossserver.event;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ 
/*     */ public class GetLadderRoleRankDoneArg
/*     */ {
/*     */   private final int retcode;
/*     */   private final long rankid;
/*     */   private final long roleid;
/*     */   private final Octets context;
/*     */   private final int rank;
/*     */   
/*     */   public GetLadderRoleRankDoneArg(int retcode, long rankid, long roleid, Octets context, int rank)
/*     */   {
/*  16 */     this.retcode = retcode;
/*  17 */     this.rankid = rankid;
/*  18 */     this.roleid = roleid;
/*  19 */     this.context = context;
/*  20 */     this.rank = rank;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean isSucceed()
/*     */   {
/*  30 */     return this.retcode == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean isTimeout()
/*     */   {
/*  40 */     return this.retcode == 8;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean isNotInRank()
/*     */   {
/*  50 */     return this.retcode == 600;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getRetCode()
/*     */   {
/*  60 */     return this.retcode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final long getRankid()
/*     */   {
/*  70 */     return this.rankid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final long getRoleid()
/*     */   {
/*  80 */     return this.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final Octets getContext()
/*     */   {
/*  90 */     return this.context;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int rank()
/*     */   {
/* 101 */     return this.rank;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\GetLadderRoleRankDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */