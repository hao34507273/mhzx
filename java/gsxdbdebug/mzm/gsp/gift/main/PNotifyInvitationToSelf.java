/*     */ package mzm.gsp.gift.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.gift.SSynGiftInvitationToSelfMsg;
/*     */ import mzm.gsp.gift.confbean.SGiftTypeCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.Invitation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PNotifyInvitationToSelf
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long selfRoleid;
/*     */   private final long invitedRoleid;
/*     */   private final long invitationid;
/*     */   private final int gifyType;
/* 237 */   private final List<String> contentArgs = new ArrayList();
/*     */   private final long inviteMils;
/*     */   
/*     */   public PNotifyInvitationToSelf(long selfRoleid, long invitedRoleid, long invitationid, int gifyType, List<String> contentArgs, long inviteMils)
/*     */   {
/* 242 */     this.selfRoleid = selfRoleid;
/* 243 */     this.invitedRoleid = invitedRoleid;
/* 244 */     this.invitationid = invitationid;
/* 245 */     this.gifyType = gifyType;
/* 246 */     this.contentArgs.addAll(contentArgs);
/* 247 */     this.inviteMils = inviteMils;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/* 252 */     if (SGiftTypeCfg.get(this.gifyType) == null) {
/* 253 */       return false;
/*     */     }
/* 255 */     SSynGiftInvitationToSelfMsg synGiftInvitationToMyselfMsg = new SSynGiftInvitationToSelfMsg();
/* 256 */     synGiftInvitationToMyselfMsg.gifttype = this.gifyType;
/* 257 */     synGiftInvitationToMyselfMsg.invitationuuid = this.invitationid;
/* 258 */     synGiftInvitationToMyselfMsg.invitesecs = ((int)(this.inviteMils / 1000L));
/* 259 */     synGiftInvitationToMyselfMsg.msgargs.addAll(this.contentArgs);
/* 260 */     InvitationManager.fillRoleInfo(this.invitedRoleid, synGiftInvitationToMyselfMsg.roleinfo);
/* 261 */     boolean ret = OnlineManager.getInstance().send(this.selfRoleid, synGiftInvitationToMyselfMsg);
/* 262 */     if (!ret) {
/* 263 */       return false;
/*     */     }
/* 265 */     Invitation xInvitation = InvitationManager.getXInvitation(this.invitationid, true);
/* 266 */     if (xInvitation != null) {
/* 267 */       xInvitation.getKnowninvitedroles().add(Long.valueOf(this.invitedRoleid));
/*     */     }
/* 269 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gift\main\PNotifyInvitationToSelf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */