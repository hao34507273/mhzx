/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.avatar.event.SetAvatarArg;
/*    */ import mzm.gsp.avatar.event.SetAvatarProcedure;
/*    */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*    */ import mzm.gsp.avatar.main.AvatarInterface;
/*    */ import mzm.gsp.gang.cache.GangCacheManager;
/*    */ import mzm.gsp.role.main.Role;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class POnSetAvatar extends SetAvatarProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     long roleid = ((SetAvatarArg)this.arg).roleId;
/*    */     
/* 19 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(roleid));
/* 20 */     if (xGangMember == null) {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     long gangId = xGangMember.getGangid();
/*    */     
/* 26 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/* 27 */     if ((xGang == null) || (!GangManager.isInGang(xGang, roleid))) {
/* 28 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 32 */     Role role = RoleInterface.getRole(roleid, true);
/* 33 */     int avatarid = AvatarInterface.getCurrentAvatar(roleid, true);
/* 34 */     int avatarFrame = AvatarFrameInterface.getCurrentAvatarFrameId(roleid, true);
/* 35 */     int fightValue = RoleInterface.getRoleMFValue(roleid);
/*    */     
/*    */ 
/* 38 */     GangManager.syncGangMemberInfoChange(role, avatarid, avatarFrame, fightValue, xGangMember, xGang);
/*    */     
/*    */ 
/* 41 */     GangCacheManager.changeMemberAvatar(gangId, roleid, avatarid);
/*    */     
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\POnSetAvatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */