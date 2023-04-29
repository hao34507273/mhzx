/*     */ package mzm.gsp.wing.event;
/*     */ 
/*     */ import mzm.gsp.wing.main2.WingChangeReasonEnum;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WingModelChangedArg
/*     */ {
/*     */   public final long roleId;
/*     */   public final int oldWingId;
/*     */   public final int newWingId;
/*     */   public final int oldColorId;
/*     */   public final int newColorId;
/*     */   public final WingChangeReasonEnum changeReasonEnum;
/*     */   
/*     */   public WingModelChangedArg(long roleId, int oldWingId, int oldColorId, int newWingId, int newColorId)
/*     */   {
/*  23 */     this.roleId = roleId;
/*  24 */     this.oldWingId = oldWingId;
/*  25 */     this.oldColorId = oldColorId;
/*  26 */     this.newWingId = newWingId;
/*  27 */     this.newColorId = newColorId;
/*  28 */     this.changeReasonEnum = WingChangeReasonEnum.NORMAL;
/*     */   }
/*     */   
/*     */ 
/*     */   public WingModelChangedArg(long roleId, int oldWingId, int oldColorId, int newWingId, int newColorId, WingChangeReasonEnum changeReasonEnum)
/*     */   {
/*  34 */     this.roleId = roleId;
/*  35 */     this.oldWingId = oldWingId;
/*  36 */     this.oldColorId = oldColorId;
/*  37 */     this.newWingId = newWingId;
/*  38 */     this.newColorId = newColorId;
/*  39 */     this.changeReasonEnum = changeReasonEnum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isWingChange()
/*     */   {
/*  49 */     return this.oldWingId != this.newWingId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isPutOnWing()
/*     */   {
/*  59 */     if (this.newWingId == 0)
/*     */     {
/*  61 */       return false;
/*     */     }
/*  63 */     if (this.oldWingId > 0)
/*     */     {
/*  65 */       return false;
/*     */     }
/*  67 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isPutOffWing()
/*     */   {
/*  77 */     return this.newWingId == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isOnlyColorChange()
/*     */   {
/*  87 */     if (this.oldWingId != this.newWingId)
/*     */     {
/*  89 */       return false;
/*     */     }
/*  91 */     return this.newColorId != this.oldColorId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getRoleId()
/*     */   {
/* 101 */     return this.roleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getOldWingId()
/*     */   {
/* 111 */     return this.oldWingId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getNewWingId()
/*     */   {
/* 121 */     return this.newWingId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getOldColorId()
/*     */   {
/* 131 */     return this.oldColorId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getNewColorId()
/*     */   {
/* 141 */     return this.newColorId;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\event\WingModelChangedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */