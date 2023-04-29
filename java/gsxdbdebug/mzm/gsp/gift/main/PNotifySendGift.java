/*     */ package mzm.gsp.gift.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.gift.SSynRoleReceiveGiftRes;
/*     */ import mzm.gsp.gift.confbean.SGiftCfg;
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
/*     */ class PNotifySendGift
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long giveRoleid;
/*     */   private final long invitationid;
/*     */   private final int giftCfgid;
/*     */   private final long sendGiftTime;
/*     */   
/*     */   public PNotifySendGift(long roleid, long giveRoleid, long invitationid, int giftCfgid, long sendGiftTime)
/*     */   {
/* 147 */     this.roleid = roleid;
/* 148 */     this.giveRoleid = giveRoleid;
/* 149 */     this.invitationid = invitationid;
/* 150 */     this.giftCfgid = giftCfgid;
/* 151 */     this.sendGiftTime = sendGiftTime;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/* 156 */     if (SGiftCfg.get(this.giftCfgid) == null) {
/* 157 */       return false;
/*     */     }
/* 159 */     SSynRoleReceiveGiftRes synRoleReceiveGiftRes = new SSynRoleReceiveGiftRes();
/* 160 */     synRoleReceiveGiftRes.giftcfgid = this.giftCfgid;
/* 161 */     synRoleReceiveGiftRes.receivesecs = ((int)(this.sendGiftTime / 1000L));
/* 162 */     InvitationManager.fillRoleInfo(this.roleid, synRoleReceiveGiftRes.roleinfo);
/* 163 */     boolean ret = OnlineManager.getInstance().send(this.giveRoleid, synRoleReceiveGiftRes);
/* 164 */     if (!ret) {
/* 165 */       return false;
/*     */     }
/*     */     
/* 168 */     Invitation xInvitation = InvitationManager.getXInvitation(this.invitationid, true);
/* 169 */     if (xInvitation != null) {
/* 170 */       InvitedRole xInvitedRole = (InvitedRole)xInvitation.getInvitedmap().get(Long.valueOf(this.roleid));
/* 171 */       if (xInvitedRole == null) {
/* 172 */         GameServer.logger().error(String.format("[Gift]PNotifySendGift.processImp@invite role is null|roleid=%d|giveRoleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.giveRoleid) }));
/*     */       }
/*     */       else
/*     */       {
/* 176 */         xInvitedRole.setSendgiftnotified(true);
/*     */       }
/*     */     }
/* 179 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gift\main\PNotifySendGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */