/*    */ package mzm.gsp.gift.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.gift.SSynGiftInvitationToRoleMsg;
/*    */ import mzm.gsp.gift.confbean.SGiftTypeCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.InvitedRole;
/*    */ import xbean.Pod;
/*    */ import xbean.SendInvitation;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InvitationInterface
/*    */ {
/*    */   public static boolean sendInvitationToRoles(long roleid, Collection<Long> roleids, int giftType, List<String> msgArgs)
/*    */   {
/* 31 */     if (SGiftTypeCfg.get(giftType) == null) {
/* 32 */       return false;
/*    */     }
/* 34 */     if (!OpenInterface.getOpenStatus(217)) {
/* 35 */       GameServer.logger().info(String.format("[Gift]InvitationInterface.sendInvitationToRoles@switch is not open|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*    */       
/*    */ 
/* 38 */       return false;
/*    */     }
/* 40 */     if (OpenInterface.isBanPlay(roleid, 217)) {
/* 41 */       OpenInterface.sendBanPlayMsg(roleid, 217);
/* 42 */       return false;
/*    */     }
/* 44 */     if (roleids.size() <= 0) {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     SendInvitation xSendInvitation = InvitationManager.getXSendInvitationCreateIfNotExist(roleid);
/* 49 */     xbean.Invitation xInvitation = Pod.newInvitation();
/* 50 */     Long invitationid = xtable.Invitation.insert(xInvitation);
/* 51 */     if (invitationid == null) {
/* 52 */       return false;
/*    */     }
/* 54 */     xSendInvitation.getInvitations().add(invitationid);
/* 55 */     xInvitation.setGifttype(giftType);
/* 56 */     xInvitation.setInvitationtime(DateTimeUtils.getCurrTimeInMillis());
/* 57 */     xInvitation.setRoleid(roleid);
/* 58 */     xInvitation.getMsgargs().addAll(msgArgs);
/*    */     
/* 60 */     SSynGiftInvitationToRoleMsg synGiftInvitationToRoleMsg = new SSynGiftInvitationToRoleMsg();
/* 61 */     synGiftInvitationToRoleMsg.gifttype = giftType;
/* 62 */     synGiftInvitationToRoleMsg.invitationuuid = invitationid.longValue();
/* 63 */     synGiftInvitationToRoleMsg.invitesecs = ((int)(xInvitation.getInvitationtime() / 1000L));
/* 64 */     synGiftInvitationToRoleMsg.msgargs.addAll(msgArgs);
/* 65 */     InvitationManager.fillRoleInfo(roleid, synGiftInvitationToRoleMsg.roleinfo);
/*    */     
/* 67 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long receiveRoleid = ((Long)i$.next()).longValue();
/* 68 */       InvitedRole xInviteRole = Pod.newInvitedRole();
/* 69 */       xInviteRole.setNotified(OnlineManager.getInstance().send(receiveRoleid, synGiftInvitationToRoleMsg));
/* 70 */       xInvitation.getInvitedmap().put(Long.valueOf(receiveRoleid), xInviteRole);
/* 71 */       Procedure.execute(new PReceiveInvitation(receiveRoleid, invitationid.longValue()));
/* 72 */       InvitationManager.asynkonwnNotifyInvitedRoles(roleid, receiveRoleid, invitationid.longValue(), giftType, msgArgs, xInvitation.getInvitationtime());
/*    */     }
/*    */     
/* 75 */     GameServer.logger().info(String.format("[Gift]InvitationInterface.sendInvitationToRoles@invatation infos|infos=%s|invitationid=%d", new Object[] { xInvitation.toString(), invitationid }));
/*    */     
/*    */ 
/*    */ 
/* 79 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gift\main\InvitationInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */