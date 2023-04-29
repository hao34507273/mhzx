/*    */ package mzm.gsp.interaction.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InteractionPlayedArg
/*    */ {
/*    */   public final int interactionId;
/*    */   
/*    */ 
/*    */ 
/*    */   public final long activeRoleId;
/*    */   
/*    */ 
/*    */ 
/*    */   public final long passiveRoleId;
/*    */   
/*    */ 
/*    */ 
/*    */   public InteractionPlayedArg(int interactionId, long activeRoleId, long passiveRoleId)
/*    */   {
/* 22 */     this.interactionId = interactionId;
/* 23 */     this.activeRoleId = activeRoleId;
/* 24 */     this.passiveRoleId = passiveRoleId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interaction\event\InteractionPlayedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */