/*     */ package mzm.gsp.corps.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.Arrays;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.corps.SInviteCorpsTrs;
/*     */ import mzm.gsp.corps.confbean.CorpsConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CorpsCacheBean;
/*     */ import xbean.CorpsMember;
/*     */ import xbean.Pod;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Corpscache;
/*     */ import xtable.Role2corps;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCInviteCorpsReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long invitee;
/*     */   
/*     */   public PCInviteCorpsReq(long roleId, long invitee)
/*     */   {
/*  32 */     this.roleId = roleId;
/*  33 */     this.invitee = invitee;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (this.roleId == this.invitee)
/*     */     {
/*  41 */       GameServer.logger().error(String.format("[corps]PCInviteCorpsReq.processImp@ same guy!|roleId=%d|invitee=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.invitee) }));
/*     */       
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     Lockeys.lock(User.getTable(), Arrays.asList(new String[] { RoleInterface.getUserId(this.roleId), RoleInterface.getUserId(this.invitee) }));
/*     */     
/*  48 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(this.invitee) }));
/*  49 */     CorpsMember xCorpsMember = Role2corps.get(Long.valueOf(this.roleId));
/*  50 */     if (xCorpsMember == null)
/*     */     {
/*  52 */       GameServer.logger().error(String.format("[corps]PCInviteCorpsReq.processImp@ inviter not own corps!|roleId=%d|invitee=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.invitee) }));
/*     */       
/*     */ 
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     long corpsId = xCorpsMember.getCorpsid();
/*  59 */     xbean.Corps xCorps = xtable.Corps.get(Long.valueOf(corpsId));
/*  60 */     if (xCorps == null)
/*     */     {
/*  62 */       GameServer.logger().error(String.format("[corps]PCInviteCorpsReq.processImp@ IMPOSSIBLE! not have this corps!|roleId=%d|corpsId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(corpsId) }));
/*     */       
/*     */ 
/*     */ 
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     if (!canInvite(this.roleId, xCorps))
/*     */     {
/*     */ 
/*  72 */       return false;
/*     */     }
/*  74 */     if (!canBeInvited(this.invitee, xCorps.getCorpsid()))
/*     */     {
/*     */ 
/*  77 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  81 */     CorpsCacheBean xCorCacheBean = Corpscache.get(Long.valueOf(corpsId));
/*  82 */     if (xCorCacheBean == null)
/*     */     {
/*  84 */       Corpscache.insert(Long.valueOf(corpsId), xCorCacheBean = Pod.newCorpsCacheBean());
/*     */     }
/*  86 */     xCorCacheBean.getInvitedroleinfo().add(Long.valueOf(this.invitee));
/*     */     
/*     */ 
/*  89 */     Session session = new InviteCorpsSession(this.roleId, this.invitee, corpsId);
/*     */     
/*     */ 
/*  92 */     SInviteCorpsTrs p = new SInviteCorpsTrs();
/*  93 */     p.inviter = this.roleId;
/*  94 */     p.sessionid = session.getSessionId();
/*     */     try
/*     */     {
/*  97 */       p.corpsname.setString(xCorps.getCorpsname(), "UTF-8");
/*  98 */       p.name.setString(RoleInterface.getName(this.roleId), "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 105 */     OnlineManager.getInstance().send(this.invitee, p);
/*     */     
/* 107 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean canInvite(long roleId, xbean.Corps xCorps)
/*     */   {
/* 113 */     if (!RoleStatusInterface.checkCanSetStatus(this.invitee, 1222, true))
/*     */     {
/* 115 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 119 */     Set<Long> members = CorpsManager.getCorpsMemberSet(xCorps);
/* 120 */     if (members.size() >= CorpsConsts.getInstance().CAPACITY)
/*     */     {
/* 122 */       GameServer.logger().error(String.format("[corps]PCInviteCorpsReq.canInvite@ corps full!|roleId=%d|invitee=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(this.invitee) }));
/*     */       
/* 124 */       CorpsManager.sendCorpsNotice(roleId, false, 22, new String[0]);
/* 125 */       return false;
/*     */     }
/* 127 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean canBeInvited(long invitee, long corpsId)
/*     */   {
/* 139 */     CorpsCacheBean xCorCacheBean = Corpscache.get(Long.valueOf(corpsId));
/* 140 */     if ((xCorCacheBean != null) && (xCorCacheBean.getInvitedroleinfo().contains(Long.valueOf(invitee))))
/*     */     {
/* 142 */       CorpsManager.sendCorpsNotice(this.roleId, false, 23, new String[0]);
/* 143 */       return false;
/*     */     }
/*     */     
/* 146 */     if (Role2corps.get(Long.valueOf(invitee)) != null)
/*     */     {
/* 148 */       GameServer.logger().error(String.format("[corps]PCInviteCorpsReq.canBeInvited@ invitee own corps!|roleId=%d|invitee=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(invitee) }));
/*     */       
/*     */ 
/* 151 */       CorpsManager.sendCorpsNotice(this.roleId, false, 20, new String[0]);
/* 152 */       return false;
/*     */     }
/* 154 */     if (RoleInterface.getLevel(invitee) < CorpsConsts.getInstance().MIN_LEVEL)
/*     */     {
/* 156 */       GameServer.logger().error(String.format("[corps]PCInviteCorpsReq.canBeInvited@ invitee level illegal!|roleId=%d|invitee=%d|level=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(invitee), Long.valueOf(invitee) }));
/*     */       
/*     */ 
/* 159 */       CorpsManager.sendCorpsNotice(this.roleId, false, 21, new String[0]);
/*     */       
/* 161 */       return false;
/*     */     }
/* 163 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PCInviteCorpsReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */