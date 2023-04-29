/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.gang.SInviteGangTeamTrs;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Gang;
/*    */ import xbean.GangTeamInvitations;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PInviteGangTeamReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long invitee;
/*    */   
/*    */   public PInviteGangTeamReq(long roleid, long invitee)
/*    */   {
/* 23 */     this.roleid = roleid;
/* 24 */     this.invitee = invitee;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 29 */     if (!OpenInterface.getOpenStatus(513)) {
/* 30 */       GangManager.logError("PInviteGangTeamReq.processImp@not open|roleid=%d|invitee=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.invitee) });
/*    */       
/* 32 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 36 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(this.invitee) }));
/*    */     
/*    */ 
/* 39 */     Long gangid = Long.valueOf(GangInterface.getGangId(this.roleid));
/* 40 */     if (gangid == null) {
/* 41 */       GangManager.sendNormalResult(this.roleid, 251, new Object[0]);
/* 42 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 46 */     Gang xGang = GangManager.getXGang(gangid.longValue(), true);
/* 47 */     if ((xGang == null) || (!GangManager.isInGang(xGang, this.roleid))) {
/* 48 */       GangManager.sendNormalResult(this.roleid, 251, new Object[0]);
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     long gangTeamid = GangManager.getGangTeamid(xGang, this.roleid);
/* 53 */     if (gangTeamid <= 0L) {
/* 54 */       GangManager.sendNormalResult(this.roleid, 252, new Object[0]);
/* 55 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 59 */     if (!GangManager.isInGang(xGang, this.invitee)) {
/* 60 */       GangManager.sendNormalResult(this.roleid, 254, new Object[0]);
/* 61 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 65 */     long inviteeGangTeamid = GangManager.getGangTeamid(xGang, this.invitee);
/* 66 */     if (inviteeGangTeamid > 0L) {
/* 67 */       GangManager.sendNormalResult(this.roleid, 255, new Object[0]);
/* 68 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 72 */     if (!OnlineManager.getInstance().isOnline(this.invitee)) {
/* 73 */       GangManager.sendNormalResult(this.roleid, 256, new Object[0]);
/* 74 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 78 */     GangTeamInvitations xInvitations = GangManager.getAndCreateXTeamInvitations(this.invitee);
/* 79 */     boolean ret = GangManager.addGangTeamInvitation(xInvitations, this.roleid, gangTeamid);
/* 80 */     if (!ret) {
/* 81 */       GangManager.sendNormalResult(this.roleid, 258, new Object[0]);
/* 82 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 86 */     SInviteGangTeamTrs trs = new SInviteGangTeamTrs();
/* 87 */     trs.inviter_id = this.roleid;
/* 88 */     trs.gang_teamid = gangTeamid;
/* 89 */     OnlineManager.getInstance().send(this.invitee, trs);
/*    */     
/*    */ 
/* 92 */     GangManager.sendNormalResult(this.roleid, 257, new Object[0]);
/*    */     
/* 94 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PInviteGangTeamReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */