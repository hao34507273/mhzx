/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.avatar.event.AvatarFrameChangedArg;
/*    */ import mzm.gsp.avatar.event.AvatarFrameChangedProcedure;
/*    */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*    */ import mzm.gsp.team.SMemberAvatarFrameChangedBrd;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnAvatarFrameChanged
/*    */   extends AvatarFrameChangedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     Long teamid = Role2team.select(Long.valueOf(((AvatarFrameChangedArg)this.arg).roleId));
/* 19 */     if (teamid == null)
/*    */     {
/* 21 */       return false;
/*    */     }
/* 23 */     xbean.Team xTeam = xtable.Team.select(teamid);
/* 24 */     if (xTeam == null)
/*    */     {
/* 26 */       return false;
/*    */     }
/* 28 */     brocastInTeamSBAvartarFrameChange(xTeam, ((AvatarFrameChangedArg)this.arg).roleId);
/* 29 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void brocastInTeamSBAvartarFrameChange(xbean.Team xTeam, long roleId)
/*    */   {
/* 40 */     SMemberAvatarFrameChangedBrd brd = new SMemberAvatarFrameChangedBrd();
/* 41 */     brd.roleid = roleId;
/* 42 */     brd.avatarframeid = AvatarFrameInterface.getCurrentAvatarFrameId(roleId, false);
/* 43 */     TeamManager.broadcast(xTeam, brd);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnAvatarFrameChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */