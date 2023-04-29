/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.avatar.event.SetAvatarArg;
/*    */ import mzm.gsp.avatar.event.SetAvatarProcedure;
/*    */ import mzm.gsp.avatar.main.AvatarInterface;
/*    */ import mzm.gsp.team.SMemberAvatarChangedBrd;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnSetAvatar
/*    */   extends SetAvatarProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     Long teamid = Role2team.select(Long.valueOf(((SetAvatarArg)this.arg).roleId));
/* 19 */     if (teamid == null)
/*    */     {
/* 21 */       return false;
/*    */     }
/* 23 */     xbean.Team xTeam = xtable.Team.select(teamid);
/* 24 */     if (xTeam == null)
/*    */     {
/* 26 */       return false;
/*    */     }
/* 28 */     brocastInTeamSBAvartarChange(xTeam, ((SetAvatarArg)this.arg).roleId);
/* 29 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void brocastInTeamSBAvartarChange(xbean.Team xTeam, long roleId)
/*    */   {
/* 40 */     SMemberAvatarChangedBrd brd = new SMemberAvatarChangedBrd();
/* 41 */     brd.roleid = roleId;
/* 42 */     brd.avatarid = AvatarInterface.getCurrentAvatar(roleId, false);
/* 43 */     TeamManager.broadcast(xTeam, brd);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnSetAvatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */