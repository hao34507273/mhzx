/*     */ package mzm.gsp.corps.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.corps.SActiveLeaveCorpsBro;
/*     */ import mzm.gsp.corps.confbean.CorpsConsts;
/*     */ import mzm.gsp.corps.event.LeaveCorps;
/*     */ import mzm.gsp.corps.event.LeaveCorpsEventArg;
/*     */ import mzm.gsp.corps.event.LeaveCorpsEventArg.LeaveCorpsReason;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
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
/*     */ public class PCActiveLeaveCorpsReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCActiveLeaveCorpsReq(long roleId)
/*     */   {
/*  39 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     Lockeys.lock(User.getTable(), Arrays.asList(new String[] { RoleInterface.getUserId(this.roleId) }));
/*     */     
/*  48 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  49 */     CorpsMember xCorpsMember = Role2corps.get(Long.valueOf(this.roleId));
/*  50 */     if (xCorpsMember == null)
/*     */     {
/*  52 */       GameServer.logger().error(String.format("[corps]PCActiveLeaveCorpsReq.processImp@ not own corps!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     long corpsId = xCorpsMember.getCorpsid();
/*  58 */     xbean.Corps xCorps = xtable.Corps.get(Long.valueOf(corpsId));
/*  59 */     if (xCorps == null)
/*     */     {
/*  61 */       GameServer.logger().error(String.format("[corps]PCActiveLeaveCorpsReq.processImp@ IMPOSSIBLE! not have this corps!|roleId=%d|corpsId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(corpsId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  66 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  70 */     if (!canActiveLeaveCorps(xCorpsMember))
/*     */     {
/*     */ 
/*  73 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  77 */     if (!CorpsManager.removeMemberFromeDB(this.roleId, xCorps, xCorpsMember))
/*     */     {
/*  79 */       GameServer.logger().error(String.format("[corps]PCActiveLeaveCorpsReq.removeMember@ rm from db err!|roleId=%d|corpsId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(corpsId) }));
/*     */       
/*     */ 
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     List<String> params = new ArrayList();
/*  86 */     params.add(RoleInterface.getName(this.roleId));
/*  87 */     CorpsManager.addCorpsHistory(xCorps, 3, params);
/*     */     
/*     */ 
/*  90 */     Set<Long> members = CorpsManager.getCorpsMemberSet(xCorps);
/*  91 */     members.add(Long.valueOf(this.roleId));
/*  92 */     OnlineManager.getInstance().sendMulti(new SActiveLeaveCorpsBro(this.roleId), members);
/*     */     
/*  94 */     TriggerEventsManger.getInstance().triggerEvent(new LeaveCorps(), new LeaveCorpsEventArg(this.roleId, corpsId, LeaveCorpsEventArg.LeaveCorpsReason.ACTIVE_LEAVE));
/*     */     
/*     */ 
/*     */ 
/*  98 */     CorpsLogManager.logLeaveCorps(RoleInterface.getUserId(this.roleId), this.roleId, corpsId, CorpsManager.getCaptain(xCorps), xCorpsMember.getDuty(), LeaveCorpsEventArg.LeaveCorpsReason.ACTIVE_LEAVE, CorpsManager.getCorpsDutyInfo(xCorps));
/*     */     
/*     */ 
/*     */ 
/* 102 */     sendActiveLeaveMail(xCorps);
/*     */     
/* 104 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void sendActiveLeaveMail(xbean.Corps xCorps)
/*     */   {
/* 110 */     List<String> contextArg2Members = new ArrayList();
/* 111 */     contextArg2Members.add(RoleInterface.getName(this.roleId));
/* 112 */     for (Iterator i$ = CorpsManager.getCorpsMemberSet(xCorps).iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*     */       
/* 114 */       MailInterface.asynBuildAndSendMail(member, CorpsConsts.getInstance().ACTIVE_LEAVE_TO_MEMBERS_MAIL_ID, null, contextArg2Members, new TLogArg(LogReason.ACTIVE_LEAVE_MAIL_TO_MEMBERS));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean canActiveLeaveCorps(CorpsMember xCorpsMember)
/*     */   {
/* 122 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1224, true))
/*     */     {
/* 124 */       return false;
/*     */     }
/*     */     
/* 127 */     if (!CorpsManager.canLeaveCorps())
/*     */     {
/* 129 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 133 */     if (xCorpsMember.getDuty() == 1)
/*     */     {
/* 135 */       GameServer.logger().error(String.format("[corps]PCActiveLeaveCorpsReq.canActiveLeaveCorps@ captain can not leave corps!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/* 138 */       return false;
/*     */     }
/* 140 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PCActiveLeaveCorpsReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */