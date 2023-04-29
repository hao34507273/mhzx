/*    */ package mzm.gsp.gift.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*    */ import mzm.gsp.avatar.main.AvatarInterface;
/*    */ import mzm.gsp.gift.RoleInfo;
/*    */ import mzm.gsp.gift.confbean.SGiftTypeCfg;
/*    */ import mzm.gsp.role.main.Role;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.Pod;
/*    */ import xbean.ReceiveInvitation;
/*    */ import xbean.SendInvitation;
/*    */ import xdb.Procedure;
/*    */ import xtable.Role2receiveinvitation;
/*    */ import xtable.Role2sendinvitation;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class InvitationManager
/*    */ {
/*    */   static SendInvitation getXSendInvitationCreateIfNotExist(long roleid)
/*    */   {
/* 24 */     SendInvitation xSendInvitation = Role2sendinvitation.get(Long.valueOf(roleid));
/* 25 */     if (xSendInvitation == null) {
/* 26 */       xSendInvitation = Pod.newSendInvitation();
/* 27 */       Role2sendinvitation.insert(Long.valueOf(roleid), xSendInvitation);
/*    */     }
/* 29 */     return xSendInvitation;
/*    */   }
/*    */   
/*    */   static SendInvitation getXSendInvitation(long roleid, boolean retainLock) {
/* 33 */     if (retainLock) {
/* 34 */       return Role2sendinvitation.get(Long.valueOf(roleid));
/*    */     }
/* 36 */     return Role2sendinvitation.select(Long.valueOf(roleid));
/*    */   }
/*    */   
/*    */   static ReceiveInvitation getXReceiveInvitationCreateIfNotExist(long roleid)
/*    */   {
/* 41 */     ReceiveInvitation xReceiveInvitation = Role2receiveinvitation.get(Long.valueOf(roleid));
/* 42 */     if (xReceiveInvitation == null) {
/* 43 */       xReceiveInvitation = Pod.newReceiveInvitation();
/* 44 */       Role2receiveinvitation.insert(Long.valueOf(roleid), xReceiveInvitation);
/*    */     }
/* 46 */     return xReceiveInvitation;
/*    */   }
/*    */   
/*    */   static ReceiveInvitation getXReceiveInvitation(long roleid, boolean reatainLock) {
/* 50 */     if (reatainLock) {
/* 51 */       return Role2receiveinvitation.get(Long.valueOf(roleid));
/*    */     }
/* 53 */     return Role2receiveinvitation.select(Long.valueOf(roleid));
/*    */   }
/*    */   
/*    */   static xbean.Invitation getXInvitation(long invitationid, boolean retainLock)
/*    */   {
/* 58 */     if (retainLock) {
/* 59 */       return xtable.Invitation.get(Long.valueOf(invitationid));
/*    */     }
/* 61 */     return xtable.Invitation.select(Long.valueOf(invitationid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static final void fillRoleInfo(long roleid, RoleInfo roleInfo)
/*    */   {
/* 72 */     Role role = RoleInterface.getRole(roleid, false);
/* 73 */     roleInfo.roleid = roleid;
/* 74 */     roleInfo.rolename = role.getName();
/* 75 */     roleInfo.gender = role.getGender();
/* 76 */     roleInfo.occupationid = role.getOccupationId();
/* 77 */     roleInfo.avatarid = AvatarInterface.getCurrentAvatar(roleid, false);
/* 78 */     roleInfo.avatar_frame_id = AvatarFrameInterface.getCurrentAvatarFrameId(roleid, false);
/* 79 */     roleInfo.level = role.getLevel();
/*    */   }
/*    */   
/*    */   static void asynNotifySendGift(long roleid, long giveRoleid, long invitationid, int giftCfgid, long sendGiftTime) {
/* 83 */     Procedure.execute(new PNotifySendGift(roleid, giveRoleid, invitationid, giftCfgid, sendGiftTime));
/*    */   }
/*    */   
/*    */   static void asynNotifyInvitaion(long roleid, long invitedRoleid, long invitationid, int gifyType, List<String> contentArgs, long inviteMils)
/*    */   {
/* 88 */     Procedure.execute(new PNotifyInvitation(roleid, invitedRoleid, invitationid, gifyType, contentArgs, inviteMils));
/*    */   }
/*    */   
/*    */ 
/*    */   static void asynkonwnNotifyInvitedRoles(long selfRoleid, long invitedRoleid, long invitationid, int gifyType, List<String> contentArgs, long inviteMils)
/*    */   {
/* 94 */     Procedure.execute(new PNotifyInvitationToSelf(selfRoleid, invitedRoleid, invitationid, gifyType, contentArgs, inviteMils));
/*    */   }
/*    */   
/*    */   static boolean isAvailable(long curTime, xbean.Invitation xInvitation, SGiftTypeCfg giftTypeCfg)
/*    */   {
/* 99 */     return curTime < xInvitation.getInvitationtime() + giftTypeCfg.outOfDateHour * 3600000L;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gift\main\InvitationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */