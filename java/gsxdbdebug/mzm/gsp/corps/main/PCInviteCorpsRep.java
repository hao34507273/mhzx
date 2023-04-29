/*     */ package mzm.gsp.corps.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.corps.SRefuseJoinCorps;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CorpsMember;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Corps;
/*     */ import xtable.Role2corps;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class PCInviteCorpsRep
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long invitee;
/*     */   private final long inviter;
/*     */   private final long sessionid;
/*     */   private final int reply;
/*     */   
/*     */   public PCInviteCorpsRep(long invitee, long inviter, long sessionId, int reply)
/*     */   {
/*  31 */     this.invitee = invitee;
/*  32 */     this.inviter = inviter;
/*  33 */     this.sessionid = sessionId;
/*  34 */     this.reply = reply;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     Session session = Session.getSession(this.sessionid);
/*  42 */     if ((session == null) || (!(session instanceof InviteCorpsSession)))
/*     */     {
/*  44 */       CorpsManager.sendCorpsNotice(this.invitee, false, 40, new String[0]);
/*  45 */       return false;
/*     */     }
/*  47 */     InviteCorpsSession inviteSession = (InviteCorpsSession)session;
/*  48 */     if ((inviteSession.getInviter() != this.inviter) || (inviteSession.getInvitee() != this.invitee))
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     long corpsId = inviteSession.getCorpsId();
/*     */     
/*     */ 
/*  56 */     if (this.reply == 2)
/*     */     {
/*  58 */       Octets octets = new Octets();
/*     */       try
/*     */       {
/*  61 */         octets.setString(RoleInterface.getName(this.invitee), "UTF-8");
/*     */       }
/*     */       catch (UnsupportedEncodingException e) {}
/*     */       
/*     */ 
/*     */ 
/*  67 */       OnlineManager.getInstance().sendAtOnce(this.inviter, new SRefuseJoinCorps(this.invitee, octets));
/*     */       
/*  69 */       asynRemoveInviteRecord(corpsId);
/*  70 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  74 */     if (!CorpsManager.canJoinCorps())
/*     */     {
/*     */ 
/*  77 */       GameServer.logger().error(String.format("[corps]PCInviteCorpsRep.processImp@ join corps shut down!|roleId=%d|invitee=%d", new Object[] { Long.valueOf(this.inviter), Long.valueOf(this.invitee) }));
/*     */       
/*     */ 
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     Lockeys.lock(User.getTable(), Arrays.asList(new String[] { RoleInterface.getUserId(this.inviter), RoleInterface.getUserId(this.invitee) }));
/*     */     
/*  85 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.inviter), Long.valueOf(this.invitee) }));
/*  86 */     CorpsMember xCorpsMember = Role2corps.get(Long.valueOf(this.inviter));
/*  87 */     if (xCorpsMember == null)
/*     */     {
/*  89 */       GameServer.logger().error(String.format("[corps]PCInviteCorpsRep.processImp@ inviter not own corps!|roleId=%d|invitee=%d", new Object[] { Long.valueOf(this.inviter), Long.valueOf(this.invitee) }));
/*     */       
/*     */ 
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     if (xCorpsMember.getCorpsid() != corpsId)
/*     */     {
/*     */ 
/*  98 */       CorpsManager.sendCorpsNotice(this.invitee, false, 40, new String[0]);
/*  99 */       return false;
/*     */     }
/* 101 */     if (!new PJoinCorps(this.invitee, Corps.get(Long.valueOf(corpsId)), this.inviter).joinCorps())
/*     */     {
/* 103 */       GameServer.logger().error(String.format("[corps]PCInviteCorpsRep.processImp@ join corps err!|roleId=%d|invitee=%d|corpsId=%d", new Object[] { Long.valueOf(this.inviter), Long.valueOf(this.invitee), Long.valueOf(corpsId) }));
/*     */       
/*     */ 
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void asynRemoveInviteRecord(final long corpsId)
/*     */   {
/* 119 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 125 */         CorpsManager.rmInvitedRecord(corpsId, PCInviteCorpsRep.this.invitee);
/* 126 */         return true;
/*     */       }
/*     */     }.execute();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PCInviteCorpsRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */