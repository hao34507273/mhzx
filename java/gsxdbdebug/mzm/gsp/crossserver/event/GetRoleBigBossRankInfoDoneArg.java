/*     */ package mzm.gsp.crossserver.event;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GetRoleBigBossRankInfoDoneArg
/*     */ {
/*     */   private final int retcode;
/*     */   private final long rankid;
/*     */   private final long roleid;
/*     */   private final int rank;
/*     */   private final Octets context;
/*     */   
/*     */   public GetRoleBigBossRankInfoDoneArg(int retcode, long rankid, long roleid, int rank, Octets context)
/*     */   {
/*  20 */     this.retcode = retcode;
/*  21 */     this.rankid = rankid;
/*  22 */     this.roleid = roleid;
/*  23 */     this.rank = rank;
/*  24 */     this.context = context;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSucceed()
/*     */   {
/*  34 */     return this.retcode == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isTimeout()
/*     */   {
/*  44 */     return this.retcode == 8;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isNotInRank()
/*     */   {
/*  54 */     return this.retcode == 600;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRetCode()
/*     */   {
/*  64 */     return this.retcode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getRankid()
/*     */   {
/*  74 */     return this.rankid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getRoleid()
/*     */   {
/*  84 */     return this.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRank()
/*     */   {
/*  94 */     return this.rank;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Octets getContext()
/*     */   {
/* 104 */     return this.context;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\GetRoleBigBossRankInfoDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */