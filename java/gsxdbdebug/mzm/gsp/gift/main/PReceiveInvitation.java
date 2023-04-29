/*     */ package mzm.gsp.gift.main;
/*     */ 
/*     */ import java.util.Set;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.ReceiveInvitation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PReceiveInvitation
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long invitationid;
/*     */   
/*     */   public PReceiveInvitation(long roleid, long invitationid)
/*     */   {
/* 110 */     this.roleid = roleid;
/* 111 */     this.invitationid = invitationid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/* 116 */     ReceiveInvitation xReceiveInvitation = InvitationManager.getXReceiveInvitationCreateIfNotExist(this.roleid);
/* 117 */     xReceiveInvitation.getInvitations().add(Long.valueOf(this.invitationid));
/* 118 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gift\main\PReceiveInvitation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */