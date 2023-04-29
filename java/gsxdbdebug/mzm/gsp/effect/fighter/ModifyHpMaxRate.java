/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ 
/*    */ public class ModifyHpMaxRate
/*    */   extends FighterEffect
/*    */ {
/*    */   private int modifyHpMaxRate;
/*    */   private int limit;
/*    */   private int changeValue;
/*    */   
/*    */   public ModifyHpMaxRate(int modifyHpMaxRate, int limit)
/*    */   {
/* 16 */     this.modifyHpMaxRate = modifyHpMaxRate;
/* 17 */     this.limit = limit;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 22 */     int maxHpRate = fighter.getMaxHpRate();
/* 23 */     int retMaxHpRate = maxHpRate + this.modifyHpMaxRate;
/*    */     
/* 25 */     if (this.modifyHpMaxRate > 0) {
/* 26 */       if (retMaxHpRate > this.limit) {
/* 27 */         if (maxHpRate >= this.limit)
/*    */         {
/* 29 */           this.changeValue = 0;
/*    */         } else {
/* 31 */           retMaxHpRate = this.limit;
/* 32 */           this.changeValue = (this.limit - maxHpRate);
/*    */         }
/*    */       } else {
/* 35 */         this.changeValue = this.modifyHpMaxRate;
/*    */       }
/*    */     }
/*    */     
/* 39 */     if (this.modifyHpMaxRate < 0) {
/* 40 */       if (retMaxHpRate < this.limit) {
/* 41 */         if (maxHpRate < this.limit)
/*    */         {
/* 43 */           this.changeValue = 0;
/*    */         } else {
/* 45 */           retMaxHpRate = this.limit;
/* 46 */           this.changeValue = (this.limit - maxHpRate);
/*    */         }
/*    */       } else {
/* 49 */         this.changeValue = this.modifyHpMaxRate;
/*    */       }
/*    */     }
/*    */     
/* 53 */     if (this.changeValue != 0) {
/* 54 */       fighter.addMaxHpRate(this.changeValue);
/*    */     }
/* 56 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 61 */     fighter.addMaxHpRate(-this.changeValue);
/* 62 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyHpMaxRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */