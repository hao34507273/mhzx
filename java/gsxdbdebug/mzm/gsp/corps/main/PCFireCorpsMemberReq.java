/*     */ package mzm.gsp.corps.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.corps.SFireCorpsMemberBro;
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
/*     */ public class PCFireCorpsMemberReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long memberId;
/*     */   
/*     */   public PCFireCorpsMemberReq(long roleId, long memberId)
/*     */   {
/*  40 */     this.roleId = roleId;
/*  41 */     this.memberId = memberId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     if (this.roleId == this.memberId)
/*     */     {
/*  49 */       GameServer.logger().error(String.format("[corps]PCFireCorpsMemberReq.processImp@ same guy!|roleId=%d|memberId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.memberId) }));
/*     */       
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     Lockeys.lock(User.getTable(), Arrays.asList(new String[] { RoleInterface.getUserId(this.roleId), RoleInterface.getUserId(this.memberId) }));
/*     */     
/*  56 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(this.memberId) }));
/*  57 */     CorpsMember xCorpsLeader = Role2corps.get(Long.valueOf(this.roleId));
/*  58 */     if (xCorpsLeader == null)
/*     */     {
/*  60 */       GameServer.logger().error(String.format("[corps]PCFireCorpsMemberReq.processImp@ leader not own corps!|roleId=%d|member=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.memberId) }));
/*     */       
/*     */ 
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     long corpsId = xCorpsLeader.getCorpsid();
/*  67 */     xbean.Corps xCorps = xtable.Corps.get(Long.valueOf(corpsId));
/*  68 */     if (xCorps == null)
/*     */     {
/*  70 */       GameServer.logger().error(String.format("[corps]PCFireCorpsMemberReq.processImp@ IMPOSSIBLE! not have this corps!|roleId=%d|corpsId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(corpsId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  75 */       return false;
/*     */     }
/*  77 */     if (!canFireMember(xCorpsLeader))
/*     */     {
/*     */ 
/*  80 */       return false;
/*     */     }
/*  82 */     CorpsMember xCorpsMember = Role2corps.get(Long.valueOf(this.memberId));
/*  83 */     if (!canBeFired(corpsId, xCorpsMember))
/*     */     {
/*     */ 
/*  86 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  90 */     if (!CorpsManager.removeMemberFromeDB(this.memberId, xCorps, xCorpsMember))
/*     */     {
/*  92 */       GameServer.logger().error(String.format("[corps]PCFireCorpsMemberReq.removeMember@ rm from db err!|roleId=%d|memberId|corpsId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.memberId), Long.valueOf(corpsId) }));
/*     */       
/*     */ 
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     List<String> params = new ArrayList();
/*  99 */     params.add(RoleInterface.getName(this.roleId));
/* 100 */     params.add(RoleInterface.getName(this.memberId));
/* 101 */     CorpsManager.addCorpsHistory(xCorps, 4, params);
/*     */     
/*     */ 
/* 104 */     Set<Long> members = CorpsManager.getCorpsMemberSet(xCorps);
/* 105 */     members.add(Long.valueOf(this.memberId));
/* 106 */     OnlineManager.getInstance().sendMulti(new SFireCorpsMemberBro(this.memberId), members);
/*     */     
/*     */ 
/* 109 */     TriggerEventsManger.getInstance().triggerEvent(new LeaveCorps(), new LeaveCorpsEventArg(this.memberId, corpsId, LeaveCorpsEventArg.LeaveCorpsReason.FIRED));
/*     */     
/*     */ 
/*     */ 
/* 113 */     CorpsLogManager.logLeaveCorps(RoleInterface.getUserId(this.memberId), this.memberId, corpsId, this.roleId, 2, LeaveCorpsEventArg.LeaveCorpsReason.FIRED, CorpsManager.getCorpsDutyInfo(xCorps));
/*     */     
/*     */ 
/*     */ 
/* 117 */     sendFireMemberMail(xCorps);
/*     */     
/* 119 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean canFireMember(CorpsMember xCorpsLeader)
/*     */   {
/* 131 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1225, true))
/*     */     {
/* 133 */       return false;
/*     */     }
/*     */     
/* 136 */     if (!CorpsManager.canLeaveCorps())
/*     */     {
/* 138 */       return false;
/*     */     }
/*     */     
/* 141 */     if (xCorpsLeader.getDuty() != 1)
/*     */     {
/* 143 */       GameServer.logger().error(String.format("[corps]PCFireCorpsMemberReq.canFireMember@ not captain!|roleId=%d|member=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.memberId) }));
/*     */       
/*     */ 
/* 146 */       return false;
/*     */     }
/* 148 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean canBeFired(long corpsId, CorpsMember xCorpsMember)
/*     */   {
/* 163 */     if (xCorpsMember == null)
/*     */     {
/* 165 */       GameServer.logger().error(String.format("[corps]PCFireCorpsMemberReq.canBeFired@ member not own corps!|roleId=%d|memberId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.memberId) }));
/*     */       
/*     */ 
/* 168 */       return false;
/*     */     }
/*     */     
/* 171 */     long memberCorpsId = xCorpsMember.getCorpsid();
/* 172 */     if (memberCorpsId != corpsId)
/*     */     {
/* 174 */       GameServer.logger().error(String.format("[corps]PCFireCorpsMemberReq.canBeFired@ member not in corps!|roleId=%d|memberId=%d|corpsId1=%d|corpsId2=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.memberId), Long.valueOf(corpsId), Long.valueOf(memberCorpsId) }));
/*     */       
/*     */ 
/*     */ 
/* 178 */       return false;
/*     */     }
/* 180 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void sendFireMemberMail(xbean.Corps xCorps)
/*     */   {
/* 186 */     List<String> contextArg2Members = new ArrayList();
/* 187 */     contextArg2Members.add(RoleInterface.getName(this.roleId));
/* 188 */     contextArg2Members.add(xCorps.getCorpsname());
/* 189 */     contextArg2Members.add(RoleInterface.getName(this.memberId));
/* 190 */     for (Iterator i$ = CorpsManager.getCorpsMemberSet(xCorps).iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*     */       
/* 192 */       MailInterface.asynBuildAndSendMail(member, CorpsConsts.getInstance().FIRE_TO_MEMBER_MAIL_ID, null, contextArg2Members, new TLogArg(LogReason.FIRE_CORPS_MEMBER_MAIL_TO_MEMBER));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 197 */     List<String> contextArg2Fired = new ArrayList();
/* 198 */     contextArg2Fired.add(RoleInterface.getName(this.roleId));
/* 199 */     contextArg2Fired.add(xCorps.getCorpsname());
/* 200 */     MailInterface.asynBuildAndSendMail(this.memberId, CorpsConsts.getInstance().FIRE_TO_ACCUSED_MAIL_ID, null, contextArg2Fired, new TLogArg(LogReason.FIRE_CORPS_MEMBER_MAIL_TO_FIRED_MEMBER));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PCFireCorpsMemberReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */