/*    */ package mzm.gsp.npc.condition;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class MenPaiConditon implements Condition {
/*    */   private int menpai;
/*    */   
/*    */   public MenPaiConditon(int meipai) {
/*  9 */     this.menpai = meipai;
/*    */   }
/*    */   
/*    */   public boolean isTrue(long roleId)
/*    */   {
/* 14 */     return RoleInterface.getOccupationId(roleId) == this.menpai;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\condition\MenPaiConditon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */