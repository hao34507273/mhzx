/*    */ package mzm.gsp.npc.condition;
/*    */ 
/*    */ import mzm.gsp.marriage.main.MarriageInterface;
/*    */ 
/*    */ public class MarryConditon implements Condition
/*    */ {
/*    */   private int state;
/*    */   
/*    */   public MarryConditon(int state) {
/* 10 */     this.state = state;
/*    */   }
/*    */   
/*    */   public boolean isTrue(long roleId)
/*    */   {
/* 15 */     switch (this.state) {
/*    */     case 1: 
/* 17 */       return true;
/*    */     case 3: 
/* 19 */       return !MarriageInterface.isMarried(roleId);
/*    */     case 2: 
/* 21 */       return MarriageInterface.isMarried(roleId);
/*    */     }
/*    */     
/*    */     
/* 25 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\condition\MarryConditon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */