/*    */ package mzm.gsp.mounts.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MountsPetPassiveSkillChangeArg
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */ 
/*    */   private final long petId;
/*    */   
/*    */ 
/*    */ 
/*    */   public MountsPetPassiveSkillChangeArg(long roleId, long petId)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.petId = petId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getRoleId()
/*    */   {
/* 26 */     return this.roleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getPetId()
/*    */   {
/* 34 */     return this.petId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\event\MountsPetPassiveSkillChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */