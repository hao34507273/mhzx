/*    */ package mzm.gsp.npc.condition;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class SexConditon implements Condition {
/*    */   private int sex;
/*    */   
/*    */   public SexConditon(int sex) {
/*  9 */     this.sex = sex;
/*    */   }
/*    */   
/*    */   public boolean isTrue(long roleId)
/*    */   {
/* 14 */     return this.sex == RoleInterface.getGender(roleId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\condition\SexConditon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */