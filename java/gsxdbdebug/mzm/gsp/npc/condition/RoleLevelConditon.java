/*    */ package mzm.gsp.npc.condition;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class RoleLevelConditon implements Condition {
/*    */   private int levelMin;
/*    */   private int levelMax;
/*    */   
/*    */   public RoleLevelConditon(int levelMin, int levelMax) {
/* 10 */     this.levelMin = levelMin;
/* 11 */     this.levelMax = levelMax;
/*    */   }
/*    */   
/*    */   public boolean isTrue(long roleId)
/*    */   {
/* 16 */     int level = RoleInterface.getLevel(roleId);
/* 17 */     if ((this.levelMin > 0) && (level < this.levelMin)) {
/* 18 */       return false;
/*    */     }
/* 20 */     if ((this.levelMax > 0) && (level > this.levelMax)) {
/* 21 */       return false;
/*    */     }
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\condition\RoleLevelConditon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */