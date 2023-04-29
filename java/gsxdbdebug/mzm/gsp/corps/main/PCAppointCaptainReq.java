/*     */ package mzm.gsp.corps.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.corps.SAppointCaptainBro;
/*     */ import mzm.gsp.corps.confbean.CorpsConsts;
/*     */ import mzm.gsp.corps.event.CorpsCaptainChange;
/*     */ import mzm.gsp.corps.event.CorpsCaptainChangeEventArg;
/*     */ import mzm.gsp.corps.event.CorpsCaptainChangeEventArg.ChangeLeaderReason;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CorpsMember;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2corps;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCAppointCaptainReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long newCaptain;
/*     */   private AppointCaptainRes res;
/*     */   
/*     */   public PCAppointCaptainReq(long roleId, long newCaptain)
/*     */   {
/*  41 */     this.roleId = roleId;
/*  42 */     this.newCaptain = newCaptain;
/*  43 */     this.res = new AppointCaptainRes();
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  49 */     if (this.roleId == this.newCaptain)
/*     */     {
/*  51 */       this.res.setErrReason(AppointCaptainRes.AppointCaptianErrReason.AlreadyCaptain);
/*  52 */       GameServer.logger().error(String.format("[corps]PCAppointCaptainReq.processImp@ same guy!|roleId=%d|newCaptain=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.newCaptain) }));
/*     */       
/*     */ 
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     Lockeys.lock(User.getTable(), Arrays.asList(new String[] { RoleInterface.getUserId(this.roleId), RoleInterface.getUserId(this.newCaptain) }));
/*     */     
/*     */ 
/*  61 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(this.newCaptain) }));
/*  62 */     CorpsMember xCorpsLeader = Role2corps.get(Long.valueOf(this.roleId));
/*  63 */     if (xCorpsLeader == null)
/*     */     {
/*  65 */       this.res.setErrReason(AppointCaptainRes.AppointCaptianErrReason.Other);
/*  66 */       GameServer.logger().error(String.format("[corps]PCAppointCaptainReq.processImp@ leader not own corps!|roleId=%d|newCaptain=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.newCaptain) }));
/*     */       
/*     */ 
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     long corpsId = xCorpsLeader.getCorpsid();
/*  73 */     xbean.Corps xCorps = xtable.Corps.get(Long.valueOf(corpsId));
/*  74 */     if (xCorps == null)
/*     */     {
/*  76 */       this.res.setErrReason(AppointCaptainRes.AppointCaptianErrReason.Other);
/*  77 */       GameServer.logger().error(String.format("[corps]PCAppointCaptainReq.processImp@ IMPOSSIBLE! not have this corps!|roleId=%d|corpsId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(corpsId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  82 */       return false;
/*     */     }
/*  84 */     if (!canAppointCaptain(this.roleId, xCorpsLeader))
/*     */     {
/*     */ 
/*  87 */       return false;
/*     */     }
/*  89 */     CorpsMember xCorpsMember = Role2corps.get(Long.valueOf(this.newCaptain));
/*  90 */     if (!canBeCaptain(corpsId, xCorpsMember))
/*     */     {
/*     */ 
/*  93 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  97 */     CorpsManager.changeDuty(this.roleId, xCorps, xCorpsLeader, 2, false);
/*     */     
/*  99 */     CorpsManager.changeDuty(this.newCaptain, xCorps, xCorpsMember, 1, false);
/*     */     
/*     */ 
/* 102 */     CorpsManager.corpsBrocast(xCorps, true, new SAppointCaptainBro(this.newCaptain));
/*     */     
/*     */ 
/* 105 */     CorpsLogManager.logChangeCorpsCaptain(RoleInterface.getUserId(this.roleId), this.roleId, corpsId, this.newCaptain, CorpsManager.getCorpsDutyInfo(xCorps));
/*     */     
/*     */ 
/*     */ 
/* 109 */     TriggerEventsManger.getInstance().triggerEvent(new CorpsCaptainChange(), new CorpsCaptainChangeEventArg(corpsId, this.roleId, this.newCaptain, CorpsCaptainChangeEventArg.ChangeLeaderReason.ACTIVE_CHANGE));
/*     */     
/*     */ 
/*     */ 
/* 113 */     sendChangeCaptainMail(xCorps);
/*     */     
/* 115 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean canBeCaptain(long corpsId, CorpsMember xCorpsMember)
/*     */   {
/* 122 */     if (xCorpsMember == null)
/*     */     {
/* 124 */       this.res.setErrReason(AppointCaptainRes.AppointCaptianErrReason.NotInCorps);
/* 125 */       GameServer.logger().error(String.format("[corps]PCAppointCaptainReq.processImp@ new captain not in corps!|roleId=%d|newCaptain=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.newCaptain) }));
/*     */       
/*     */ 
/* 128 */       return false;
/*     */     }
/* 130 */     if (xCorpsMember.getCorpsid() != corpsId)
/*     */     {
/* 132 */       this.res.setErrReason(AppointCaptainRes.AppointCaptianErrReason.NotInCorps);
/* 133 */       GameServer.logger().error(String.format("[corps]PCAppointCaptainReq.processImp@ not in same corps!|roleId=%d|newCaptain=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.newCaptain) }));
/*     */       
/*     */ 
/* 136 */       return false;
/*     */     }
/* 138 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean canAppointCaptain(long orgCaptian, CorpsMember xCorpsLeader)
/*     */   {
/* 144 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1226, true))
/*     */     {
/* 146 */       this.res.setErrReason(AppointCaptainRes.AppointCaptianErrReason.StateForbidAppoint);
/* 147 */       return false;
/*     */     }
/*     */     
/* 150 */     if (!CorpsManager.canChangeCorpsCaptain())
/*     */     {
/* 152 */       this.res.setErrReason(AppointCaptainRes.AppointCaptianErrReason.NotOpen);
/* 153 */       return false;
/*     */     }
/*     */     
/* 156 */     if (xCorpsLeader.getDuty() != 1)
/*     */     {
/* 158 */       this.res.setErrReason(AppointCaptainRes.AppointCaptianErrReason.Other);
/* 159 */       GameServer.logger().error(String.format("[corps]PCAppointCaptainReq.processImp@ not leader!|orgCaptian=%d", new Object[] { Long.valueOf(orgCaptian) }));
/*     */       
/* 161 */       return false;
/*     */     }
/* 163 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void sendChangeCaptainMail(xbean.Corps xCorps)
/*     */   {
/* 169 */     List<String> contextArg2Members = new ArrayList();
/* 170 */     contextArg2Members.add(RoleInterface.getName(this.roleId));
/* 171 */     contextArg2Members.add(xCorps.getCorpsname());
/* 172 */     contextArg2Members.add(RoleInterface.getName(this.newCaptain));
/* 173 */     Set<Long> members = CorpsManager.getCorpsMemberSet(xCorps);
/* 174 */     members.remove(Long.valueOf(this.newCaptain));
/* 175 */     for (Iterator i$ = members.iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*     */       
/* 177 */       MailInterface.asynBuildAndSendMail(member, CorpsConsts.getInstance().CHANGE_LEADER_TO_MEMBER_MAIL_ID, null, contextArg2Members, new TLogArg(LogReason.COPRS_CAPTAIN_CHANGE_MAIL_TO_MEMBER));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 182 */     List<String> contextArg2new = new ArrayList();
/* 183 */     contextArg2new.add(RoleInterface.getName(this.roleId));
/* 184 */     contextArg2new.add(xCorps.getCorpsname());
/* 185 */     MailInterface.asynBuildAndSendMail(this.newCaptain, CorpsConsts.getInstance().CHANGE_LEADER_TO_NEW_LEADER_MAIL_ID, null, contextArg2new, new TLogArg(LogReason.COPRS_CAPTAIN_CHANGE_MAIL_TO_NEW_CAPTIAN));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AppointCaptainRes getRes()
/*     */   {
/* 196 */     return this.res;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PCAppointCaptainReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */