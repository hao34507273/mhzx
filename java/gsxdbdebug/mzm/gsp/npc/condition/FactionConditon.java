/*    */ package mzm.gsp.npc.condition;
/*    */ 
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ 
/*    */ public class FactionConditon implements Condition
/*    */ {
/*    */   private int state;
/*    */   
/*    */   public FactionConditon(int state)
/*    */   {
/* 11 */     this.state = state;
/*    */   }
/*    */   
/*    */   public boolean isTrue(long roleId)
/*    */   {
/* 16 */     switch (this.state) {
/*    */     case 1: 
/* 18 */       return true;
/*    */     case 3: 
/* 20 */       return !GangInterface.hasGang(roleId);
/*    */     case 2: 
/* 22 */       return GangInterface.hasGang(roleId);
/*    */     }
/*    */     
/*    */     
/* 26 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\condition\FactionConditon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */