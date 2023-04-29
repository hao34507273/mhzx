/*    */ package mzm.gsp.avatar.main;
/*    */ 
/*    */ import mzm.gsp.multioccupation.main.MultiOccupHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AvatarSwitchOccupationHandler
/*    */   implements MultiOccupHandler
/*    */ {
/*    */   public boolean onActivateNewOccupation(long roleid, int newOccup, int oldOccup)
/*    */   {
/* 12 */     return new PSyncAvatarInfoWhenSwitchFaction(roleid, newOccup).call();
/*    */   }
/*    */   
/*    */   public boolean onSwitchOccupation(long roleid, int newOccup, int oldOccup)
/*    */   {
/* 17 */     return new PSyncAvatarInfoWhenSwitchFaction(roleid, newOccup).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\main\AvatarSwitchOccupationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */