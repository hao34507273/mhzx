/*     */ package mzm.gsp.task.ban;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BanTaskRes
/*     */ {
/*     */   private boolean suc;
/*     */   private BanTaskErr reason;
/*     */   private Set<Integer> illegalGraphIds;
/*     */   private Set<Integer> illegalTaskIds;
/*     */   
/*     */   public BanTaskRes()
/*     */   {
/*  18 */     this.illegalGraphIds = new HashSet();
/*  19 */     this.illegalTaskIds = new HashSet();
/*     */   }
/*     */   
/*     */   public boolean isSuc()
/*     */   {
/*  24 */     return this.suc;
/*     */   }
/*     */   
/*     */   void setSuc(boolean suc)
/*     */   {
/*  29 */     this.suc = suc;
/*     */   }
/*     */   
/*     */   void setReason(BanTaskErr reason)
/*     */   {
/*  34 */     this.reason = reason;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getReasonValue()
/*     */   {
/*  44 */     return this.reason.ordinal();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isBanTypeErr()
/*     */   {
/*  54 */     return this.reason == BanTaskErr.IllegalBanType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isGraphIdsIllegal()
/*     */   {
/*  64 */     return this.reason == BanTaskErr.IllegalGraphIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Integer> getIllegalGraphIds()
/*     */   {
/*  74 */     return new HashSet(this.illegalGraphIds);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void addIllegalGraphIds(Set<Integer> graphIds)
/*     */   {
/*  85 */     if ((graphIds == null) || (graphIds.size() == 0))
/*     */     {
/*  87 */       return;
/*     */     }
/*  89 */     this.illegalGraphIds.addAll(graphIds);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isTaskIdsIllegal()
/*     */   {
/*  99 */     return this.reason == BanTaskErr.IllegalTaskIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isGraphTypeIllegal()
/*     */   {
/* 109 */     return this.reason == BanTaskErr.TeamGraph;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Integer> getIllegalTaskIds()
/*     */   {
/* 119 */     return new HashSet(this.illegalTaskIds);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void addIllegalTaskIds(Set<Integer> taskIds)
/*     */   {
/* 130 */     if ((taskIds == null) || (taskIds.size() == 0))
/*     */     {
/* 132 */       return;
/*     */     }
/* 134 */     this.illegalGraphIds.addAll(taskIds);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static enum BanTaskErr
/*     */   {
/* 145 */     IllegalGraphIds, 
/* 146 */     IllegalTaskIds, 
/* 147 */     IllegalBanType, 
/* 148 */     TeamGraph;
/*     */     
/*     */     private BanTaskErr() {}
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\ban\BanTaskRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */