/*    */ package mzm.gsp.pet.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PetFanShengEventArg
/*    */ {
/*    */   public final long roleId;
/*    */   public final long oldPetId;
/*    */   public final long newPetId;
/* 25 */   public final List<Integer> newPetSkillIdList = new ArrayList();
/*    */   
/*    */   public PetFanShengEventArg(long roleId, long oldPetId, long newPetId)
/*    */   {
/* 29 */     this.roleId = roleId;
/* 30 */     this.oldPetId = oldPetId;
/* 31 */     this.newPetId = newPetId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\event\PetFanShengEventArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */