/*     */ package mzm.gsp.crossserver.event;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ 
/*     */ public class ReportLadderRankInfoDoneArg
/*     */ {
/*     */   private final int retcode;
/*     */   private final long rankid;
/*     */   private final long roleid;
/*     */   private final int occupation;
/*     */   private final String roleName;
/*     */   private final int displayRanking;
/*     */   private final int ranking;
/*     */   private final Octets context;
/*     */   
/*     */   public ReportLadderRankInfoDoneArg(int retcode, long rankid, long roleid, int occupation, String roleName, int displayRanking, int ranking, Octets context)
/*     */   {
/*  19 */     this.retcode = retcode;
/*  20 */     this.rankid = rankid;
/*  21 */     this.roleid = roleid;
/*  22 */     this.occupation = occupation;
/*  23 */     this.roleName = roleName;
/*  24 */     this.displayRanking = displayRanking;
/*  25 */     this.ranking = ranking;
/*  26 */     this.context = context;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean isSucceed()
/*     */   {
/*  36 */     return this.retcode == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final boolean isTimeout()
/*     */   {
/*  46 */     return this.retcode == 8;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final int getRetCode()
/*     */   {
/*  56 */     return this.retcode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getRankid()
/*     */   {
/*  66 */     return this.rankid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getRoleid()
/*     */   {
/*  76 */     return this.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getOccupation()
/*     */   {
/*  86 */     return this.occupation;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRoleName()
/*     */   {
/*  96 */     return this.roleName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getDisplayRanking()
/*     */   {
/* 106 */     return this.displayRanking;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRanking()
/*     */   {
/* 116 */     return this.ranking;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Octets getContext()
/*     */   {
/* 126 */     return this.context;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\ReportLadderRankInfoDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */