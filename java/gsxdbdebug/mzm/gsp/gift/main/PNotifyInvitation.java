/*     */ package mzm.gsp.gift.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.gift.SSynGiftInvitationToRoleMsg;
/*     */ import mzm.gsp.gift.confbean.SGiftTypeCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Invitation;
/*     */ import xbean.InvitedRole;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PNotifyInvitation
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long invitedRoleid;
/*     */   private final long invitationid;
/*     */   private final int gifyType;
/* 188 */   private final List<String> contentArgs = new ArrayList();
/*     */   private final long inviteMils;
/*     */   
/*     */   public PNotifyInvitation(long roleid, long invitedRoleid, long invitationid, int gifyType, List<String> contentArgs, long inviteMils)
/*     */   {
/* 193 */     this.roleid = roleid;
/* 194 */     this.invitedRoleid = invitedRoleid;
/* 195 */     this.invitationid = invitationid;
/* 196 */     this.gifyType = gifyType;
/* 197 */     this.contentArgs.addAll(contentArgs);
/* 198 */     this.inviteMils = inviteMils;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/* 203 */     if (SGiftTypeCfg.get(this.gifyType) == null) {
/* 204 */       return false;
/*     */     }
/* 206 */     SSynGiftInvitationToRoleMsg synGiftInvitationToRoleMsg = new SSynGiftInvitationToRoleMsg();
/* 207 */     synGiftInvitationToRoleMsg.gifttype = this.gifyType;
/* 208 */     synGiftInvitationToRoleMsg.invitationuuid = this.invitationid;
/* 209 */     synGiftInvitationToRoleMsg.invitesecs = ((int)(this.inviteMils / 1000L));
/* 210 */     synGiftInvitationToRoleMsg.msgargs.addAll(this.contentArgs);
/* 211 */     InvitationManager.fillRoleInfo(this.roleid, synGiftInvitationToRoleMsg.roleinfo);
/* 212 */     boolean ret = OnlineManager.getInstance().send(this.invitedRoleid, synGiftInvitationToRoleMsg);
/* 213 */     if (!ret) {
/* 214 */       return false;
/*     */     }
/* 216 */     Invitation xInvitation = InvitationManager.getXInvitation(this.invitationid, true);
/* 217 */     if (xInvitation != null) {
/* 218 */       InvitedRole xInvitedRole = (InvitedRole)xInvitation.getInvitedmap().get(Long.valueOf(this.invitedRoleid));
/* 219 */       if (xInvitedRole == null) {
/* 220 */         GameServer.logger().error(String.format("[Gift]PNotifySendGift.processImp@invited role is null|roleid=%d|invitedRoleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.invitedRoleid) }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 225 */         xInvitedRole.setNotified(true);
/*     */       }
/*     */     }
/* 228 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gift\main\PNotifyInvitation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */