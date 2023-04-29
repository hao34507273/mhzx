/*     */ package mzm.gsp.corps.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.corps.CorpsMemberSynInfo;
/*     */ import mzm.gsp.corps.SNewMemberJoinCorpsBro;
/*     */ import mzm.gsp.corps.confbean.CorpsConsts;
/*     */ import mzm.gsp.corps.event.JoinCorps;
/*     */ import mzm.gsp.corps.event.JoinCorpsEventArg;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Corps;
/*     */ import xtable.Role2corps;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PJoinCorps
/*     */ {
/*     */   private final long roleId;
/*     */   private final long inviter;
/*     */   protected final Corps xCorps;
/*     */   private JoinCorpsErrReason errReason;
/*  33 */   private boolean joinSuc = true;
/*     */   
/*     */   PJoinCorps(long roleId, Corps xCorps, long inviter)
/*     */   {
/*  37 */     this.roleId = roleId;
/*  38 */     this.xCorps = xCorps;
/*  39 */     this.inviter = inviter;
/*     */     
/*  41 */     this.joinSuc = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean joinCorps()
/*     */   {
/*  49 */     if (this.xCorps == null)
/*     */     {
/*  51 */       setErrReason(JoinCorpsErrReason.CorpsNotExist);
/*  52 */       GameServer.logger().error(String.format("[corps]PJoinCorps.joinCorps@ IMPOSSIBLE! corps is null!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     long corpsId = this.xCorps.getCorpsid();
/*     */     
/*  59 */     if (!canJoinCorps(this.roleId, this.xCorps))
/*     */     {
/*     */ 
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     CorpsManager.joinCorps(this.roleId, this.xCorps, 2, DateTimeUtils.getCurrTimeInMillis());
/*     */     
/*  67 */     addJoinHistory();
/*     */     
/*  69 */     CorpsManager.rmInvitedRecord(corpsId, this.roleId);
/*     */     
/*     */ 
/*  72 */     CorpsMemberSynInfo pCorpsMember = new CorpsMemberSynInfo();
/*  73 */     CorpsManager.fillCorpsMemberSynInfo(this.xCorps, this.roleId, pCorpsMember);
/*  74 */     CorpsManager.corpsBrocast(this.xCorps, true, new SNewMemberJoinCorpsBro(pCorpsMember));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  79 */     CorpsLogManager.logJoinCorps(RoleInterface.getUserId(this.roleId), this.roleId, corpsId, CorpsManager.getCaptain(this.xCorps), 2, CorpsManager.getCorpsDutyInfo(this.xCorps));
/*     */     
/*     */ 
/*     */ 
/*  83 */     TriggerEventsManger.getInstance().triggerEvent(new JoinCorps(), new JoinCorpsEventArg(this.roleId, corpsId, getJoinCorpsReason()));
/*     */     
/*     */ 
/*     */ 
/*  87 */     sendNewJoinMail(this.xCorps);
/*     */     
/*  89 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void sendNewJoinMail(Corps xCorps)
/*     */   {
/*  95 */     List<String> contextArg2OrgMembers = new ArrayList();
/*  96 */     contextArg2OrgMembers.add(RoleInterface.getName(this.inviter));
/*  97 */     contextArg2OrgMembers.add(RoleInterface.getName(this.roleId));
/*  98 */     Set<Long> orgMembers = CorpsManager.getCorpsMemberSet(xCorps);
/*  99 */     orgMembers.remove(Long.valueOf(this.roleId));
/* 100 */     for (Iterator i$ = orgMembers.iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*     */       
/* 102 */       MailInterface.asynBuildAndSendMail(member, CorpsConsts.getInstance().NEW_JOIN_TO_ORG_MEMBER_MAIL_ID, null, contextArg2OrgMembers, new TLogArg(LogReason.JOIN_CORPS_MAIL_TO_ORG_MEMBER));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 107 */     List<String> contextArg2new = new ArrayList();
/* 108 */     contextArg2new.add(xCorps.getCorpsname());
/* 109 */     MailInterface.asynBuildAndSendMail(this.roleId, CorpsConsts.getInstance().NEW_JOIN_TO_NEW_MEMBER_MAIL_ID, null, contextArg2new, new TLogArg(LogReason.JOIN_CORPS_MAIL_TO_NEW_MEMBER));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean canJoinCorps(long invitee, Corps xCorps)
/*     */   {
/* 116 */     if (!RoleStatusInterface.checkCanSetStatus(invitee, 1223, true))
/*     */     {
/* 118 */       setErrReason(JoinCorpsErrReason.RoleStateForbid);
/* 119 */       return false;
/*     */     }
/* 121 */     if (Role2corps.get(Long.valueOf(invitee)) != null)
/*     */     {
/* 123 */       setErrReason(JoinCorpsErrReason.AlreadyInCorps);
/*     */       
/* 125 */       GameServer.logger().error(String.format("[corps]PJoinCorps.canJoinCorps@ invitee own corps!|roleId=%d|invitee=%d", new Object[] { Long.valueOf(this.inviter), Long.valueOf(invitee) }));
/*     */       
/* 127 */       return false;
/*     */     }
/* 129 */     if (isCorpsFull())
/*     */     {
/* 131 */       setErrReason(JoinCorpsErrReason.CorpsFull);
/* 132 */       CorpsManager.sendCorpsNotice(invitee, false, 41, new String[0]);
/* 133 */       GameServer.logger().error(String.format("[corps]PJoinCorps.canJoinCorps@ corps full!|roleId=%d|invitee=%d", new Object[] { Long.valueOf(this.inviter), Long.valueOf(invitee) }));
/*     */       
/* 135 */       return false;
/*     */     }
/* 137 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void addJoinHistory()
/*     */   {
/* 145 */     if (this.inviter <= 0L)
/*     */     {
/* 147 */       return;
/*     */     }
/*     */     
/* 150 */     List<String> params = new ArrayList();
/* 151 */     params.add(RoleInterface.getName(this.inviter));
/* 152 */     params.add(RoleInterface.getName(this.roleId));
/* 153 */     CorpsManager.addCorpsHistory(this.xCorps, 2, params);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isCorpsFull()
/*     */   {
/* 163 */     return CorpsManager.getCorpsMemberSet(this.xCorps).size() >= CorpsConsts.getInstance().CAPACITY;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   JoinCorpsReason getJoinCorpsReason()
/*     */   {
/* 173 */     return JoinCorpsReason.INVITE;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static enum JoinCorpsErrReason
/*     */   {
/* 184 */     CorpsNotExist, 
/* 185 */     RoleStateForbid, 
/* 186 */     AlreadyInCorps, 
/* 187 */     CorpsFull, 
/* 188 */     Other;
/*     */     
/*     */     private JoinCorpsErrReason() {}
/*     */   }
/*     */   
/*     */   public static enum JoinCorpsReason {
/* 194 */     INVITE, 
/* 195 */     IDIP;
/*     */     
/*     */     private JoinCorpsReason() {}
/*     */   }
/*     */   
/*     */   void setErrReason(JoinCorpsErrReason errReason) {
/* 201 */     this.joinSuc = false;
/* 202 */     this.errReason = errReason;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public JoinCorpsErrReason getErrReason()
/*     */   {
/* 212 */     return this.errReason;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isJoinSuc()
/*     */   {
/* 222 */     return this.joinSuc;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PJoinCorps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */