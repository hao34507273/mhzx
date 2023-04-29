/*     */ package mzm.gsp.gift.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.gift.confbean.SGiftTypeCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.InvitedRole;
/*     */ import xbean.ReceiveInvitation;
/*     */ import xbean.SendInvitation;
/*     */ 
/*     */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  17 */     long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  18 */     Set<Long> remInvationIds = new java.util.HashSet();
/*     */     
/*  20 */     SendInvitation xSendInvitation = InvitationManager.getXSendInvitation(((Long)this.arg).longValue(), true);
/*     */     
/*  22 */     if (xSendInvitation != null) {
/*  23 */       Iterator<Long> iterator = xSendInvitation.getInvitations().iterator();
/*  24 */       while (iterator.hasNext()) {
/*  25 */         long invitationid = ((Long)iterator.next()).longValue();
/*     */         
/*  27 */         xbean.Invitation xInvitation = InvitationManager.getXInvitation(invitationid, false);
/*  28 */         if (xInvitation == null) {
/*  29 */           iterator.remove();
/*     */         }
/*     */         else {
/*  32 */           for (Map.Entry<Long, InvitedRole> entry : xInvitation.getInvitedmap().entrySet()) {
/*  33 */             long invitedRoleid = ((Long)entry.getKey()).longValue();
/*  34 */             InvitedRole xInviteRole = (InvitedRole)entry.getValue();
/*  35 */             if ((xInviteRole.getSendgift()) && (!xInviteRole.getSendgiftnotified())) {
/*  36 */               InvitationManager.asynNotifySendGift(((Long)entry.getKey()).longValue(), xInvitation.getRoleid(), invitationid, xInviteRole.getGiftcfgid(), xInviteRole.getSendgifttimemil());
/*     */             }
/*     */             
/*  39 */             if (!xInvitation.getKnowninvitedroles().contains(Long.valueOf(invitedRoleid))) {
/*  40 */               InvitationManager.asynkonwnNotifyInvitedRoles(((Long)this.arg).longValue(), invitedRoleid, invitationid, xInvitation.getGifttype(), xInvitation.getMsgargs(), xInvitation.getInvitationtime());
/*     */             }
/*     */           }
/*     */           
/*  44 */           int giftType = xInvitation.getGifttype();
/*  45 */           SGiftTypeCfg giftTypeCfg = SGiftTypeCfg.get(giftType);
/*  46 */           if (giftTypeCfg == null) {
/*  47 */             GameServer.logger().info(String.format("[Gift]POnRoleLogin.processImp@gift type is not exist|gifttype=%d|invitationid=%d|roleid=%d", new Object[] { Integer.valueOf(giftType), Long.valueOf(invitationid), this.arg }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           }
/*  54 */           else if (!InvitationManager.isAvailable(curTime, xInvitation, giftTypeCfg)) {
/*  55 */             iterator.remove();
/*  56 */             remInvationIds.add(Long.valueOf(invitationid));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  62 */     ReceiveInvitation xReceiveInvitation = InvitationManager.getXReceiveInvitation(((Long)this.arg).longValue(), true);
/*  63 */     if (xReceiveInvitation != null) {
/*  64 */       Iterator<Long> iterator = xReceiveInvitation.getInvitations().iterator();
/*  65 */       while (iterator.hasNext()) {
/*  66 */         long invitationid = ((Long)iterator.next()).longValue();
/*     */         
/*  68 */         xbean.Invitation xInvitation = InvitationManager.getXInvitation(invitationid, false);
/*  69 */         if (xInvitation == null) {
/*  70 */           iterator.remove();
/*     */         }
/*     */         else {
/*  73 */           InvitedRole xInviteRole = (InvitedRole)xInvitation.getInvitedmap().get(this.arg);
/*  74 */           if (xInviteRole == null) {
/*  75 */             GameServer.logger().error(String.format("[Gift]POnRoleLogin.processImp@do not invite but has inviteData|invitationid=%d|roleid=%d|myself=%d", new Object[] { Long.valueOf(invitationid), Long.valueOf(xInvitation.getRoleid()), this.arg }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           }
/*  81 */           else if (!xInviteRole.getNotified()) {
/*  82 */             InvitationManager.asynNotifyInvitaion(xInvitation.getRoleid(), ((Long)this.arg).longValue(), invitationid, xInvitation.getGifttype(), xInvitation.getMsgargs(), xInvitation.getInvitationtime());
/*     */           }
/*     */           
/*     */ 
/*  86 */           int giftType = xInvitation.getGifttype();
/*  87 */           SGiftTypeCfg giftTypeCfg = SGiftTypeCfg.get(giftType);
/*  88 */           if (giftTypeCfg == null) {
/*  89 */             GameServer.logger().info(String.format("[Gift]POnRoleLogin.processImp@gift type is not exist|gifttype=%d|invitationid=%d|roleid=%d", new Object[] { Integer.valueOf(giftType), Long.valueOf(invitationid), this.arg }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           }
/*  96 */           else if (curTime >= xInvitation.getInvitationtime() + giftTypeCfg.outOfDateHour * 3600000L)
/*     */           {
/*  98 */             iterator.remove();
/*  99 */             remInvationIds.add(Long.valueOf(invitationid));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     Iterator i$;
/* 105 */     if (remInvationIds.size() > 0) {
/* 106 */       lock(xtable.Invitation.getTable(), remInvationIds);
/* 107 */       for (i$ = remInvationIds.iterator(); i$.hasNext();) { long invationid = ((Long)i$.next()).longValue();
/* 108 */         xtable.Invitation.remove(Long.valueOf(invationid));
/*     */       }
/*     */     }
/*     */     
/* 112 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gift\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */