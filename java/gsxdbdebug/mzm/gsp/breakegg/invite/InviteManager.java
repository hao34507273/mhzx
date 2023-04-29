/*     */ package mzm.gsp.breakegg.invite;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*     */ import mzm.gsp.avatar.main.AvatarInterface;
/*     */ import mzm.gsp.breakegg.RoleInfo;
/*     */ import mzm.gsp.breakegg.SSynInviteInfo;
/*     */ import mzm.gsp.breakegg.SSynInviteJoinInfo;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.nationalholiday.confbean.InviteConfirmType;
/*     */ import mzm.gsp.nationalholiday.confbean.SInviteConfirmCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.InviteConfirmBean;
/*     */ import xdb.Lockeys;
/*     */ import xio.Protocol;
/*     */ import xtable.Inviteconfirm_info;
/*     */ import xtable.Role2inviteconfirm_info;
/*     */ 
/*     */ public class InviteManager
/*     */ {
/*  36 */   private static final Map<Integer, InviteConfirmHandler> inviteType2Handler = new ConcurrentHashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendInviteConfirm(long roleId, int inviteType, InviteConfirmContext context)
/*     */   {
/*  49 */     SInviteConfirmCfg cfg = SInviteConfirmCfg.get(inviteType);
/*  50 */     if (cfg == null)
/*     */     {
/*  52 */       GameServer.logger().error(String.format("[invite]InviteManager.startInviteConfirm@ SInviteConfirmCfg is null!|inviteType=%d", new Object[] { Integer.valueOf(inviteType) }));
/*     */       
/*     */ 
/*  55 */       return;
/*     */     }
/*     */     
/*  58 */     InviteConfirmHandler handler = getInviteConfirmHandler(inviteType);
/*  59 */     if (handler == null)
/*     */     {
/*  61 */       GameServer.logger().error(String.format("[invite]InviteManager.startInviteConfirm@ handler is null!|inviteType=%d", new Object[] { Integer.valueOf(inviteType) }));
/*     */       
/*  63 */       return;
/*     */     }
/*     */     
/*  66 */     if (isInInviteConfirm(roleId))
/*     */     {
/*  68 */       return;
/*     */     }
/*     */     
/*  71 */     InviteConfirmSession session = new InviteConfirmSession(cfg.countdownTime, roleId);
/*     */     
/*  73 */     long inviteConfirmId = createInviteConfirm(roleId, session.getSessionId(), context, inviteType);
/*     */     
/*  75 */     Role2inviteconfirm_info.insert(Long.valueOf(roleId), Long.valueOf(inviteConfirmId));
/*     */     
/*  77 */     RoleStatusInterface.setStatus(roleId, 1861, false);
/*     */     
/*  79 */     sendInvite(cfg, session, context);
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
/*     */   private static long createInviteConfirm(long roleId, long sessionId, InviteConfirmContext context, int inviteType)
/*     */   {
/*  94 */     InviteConfirmBean xInviteConfirmBean = xbean.Pod.newInviteConfirmBean();
/*  95 */     xInviteConfirmBean.setInvitetype(inviteType);
/*  96 */     xInviteConfirmBean.setSessionid(sessionId);
/*  97 */     xInviteConfirmBean.getAllroles().add(Long.valueOf(roleId));
/*  98 */     xInviteConfirmBean.setContext(context);
/*  99 */     return Inviteconfirm_info.insert(xInviteConfirmBean).longValue();
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
/*     */   private static void sendInvite(final SInviteConfirmCfg cfg, InviteConfirmSession session, final InviteConfirmContext context)
/*     */   {
/* 114 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 120 */         SSynInviteInfo syn = new SSynInviteInfo();
/* 121 */         syn.inviter_info = InviteManager.getRoleInfo(this.val$session.getOwerId());
/* 122 */         syn.invite_type = cfg.inviteType;
/* 123 */         syn.session_id = this.val$session.getSessionId();
/* 124 */         syn.end_time = TimeUnit.MILLISECONDS.toSeconds(this.val$session.getTimeoutTimestamp());
/*     */         
/* 126 */         InviteConfirmHandler handler = InviteManager.getInviteConfirmHandler(cfg.inviteType);
/* 127 */         if (handler == null)
/*     */         {
/* 129 */           return false;
/*     */         }
/* 131 */         Protocol p = handler.getExtroInfoProtocol(context);
/* 132 */         if (p != null)
/*     */         {
/* 134 */           Octets pdata = new OctetsStream().marshal(p);
/* 135 */           syn.extro_info = pdata;
/*     */         }
/*     */         
/* 138 */         return InviteManager.broadCast(this.val$session.getOwerId(), cfg.channelType, syn);
/*     */       }
/*     */     }.execute();
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
/*     */ 
/*     */   private static boolean broadCast(long roleId, int channelType, Protocol syn)
/*     */   {
/* 156 */     switch (channelType)
/*     */     {
/*     */ 
/*     */     case 2: 
/* 160 */       long gangId = GangInterface.getGangId(roleId);
/* 161 */       if (gangId == 0L)
/*     */       {
/* 163 */         GameServer.logger().error(String.format("[invite]InviteManager.broadCast@ gangId is zero!|roleId=%d|channelType=%d|gangId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(channelType), Long.valueOf(gangId) }));
/*     */         
/*     */ 
/*     */ 
/* 167 */         return false;
/*     */       }
/* 169 */       GangInterface.brocastInGang(syn, gangId);
/* 170 */       break;
/*     */     
/*     */     case 5: 
/* 173 */       OnlineManager.getInstance().sendAll(syn);
/* 174 */       break;
/*     */     
/*     */     default: 
/* 177 */       GameServer.logger().error(String.format("[invite]InviteManager.broadCast@ channelType is undefined!|roleId=%d|channelType=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(channelType) }));
/*     */       
/*     */ 
/* 180 */       return false; }
/*     */     
/* 182 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void registerConfirmHandler(int inviteType, InviteConfirmHandler handler)
/*     */   {
/* 193 */     if (handler == null)
/*     */     {
/*     */ 
/* 196 */       return;
/*     */     }
/* 198 */     if (inviteType2Handler.containsKey(Integer.valueOf(inviteType)))
/*     */     {
/*     */ 
/* 201 */       return;
/*     */     }
/* 203 */     inviteType2Handler.put(Integer.valueOf(inviteType), handler);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static InviteConfirmHandler getInviteConfirmHandler(int inviteType)
/*     */   {
/* 214 */     return (InviteConfirmHandler)inviteType2Handler.get(Integer.valueOf(inviteType));
/*     */   }
/*     */   
/*     */   public static void check()
/*     */   {
/*     */     try
/*     */     {
/* 221 */       Field[] fields = InviteConfirmType.class.getFields();
/* 222 */       for (Field field : fields)
/*     */       {
/* 224 */         int inviteType = field.getInt(null);
/* 225 */         if (!inviteType2Handler.containsKey(Integer.valueOf(inviteType)))
/*     */         {
/*     */ 
/*     */ 
/* 229 */           throw new RuntimeException(String.format("[invite]InviteManager.check@not register invite handler of the type(%s)|invite_type=%d", new Object[] { field.getName(), Integer.valueOf(inviteType) }));
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 236 */       throw new RuntimeException(e);
/*     */     }
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
/*     */   private static RoleInfo getRoleInfo(long roleId)
/*     */   {
/* 250 */     RoleInfo roleInfo = new RoleInfo();
/* 251 */     roleInfo.gender = RoleInterface.getGender(roleId);
/* 252 */     roleInfo.roleid = roleId;
/* 253 */     roleInfo.occupationid = RoleInterface.getOccupationId(roleId);
/* 254 */     roleInfo.rolename = RoleInterface.getName(roleId);
/* 255 */     roleInfo.avatarid = AvatarInterface.getCurrentAvatar(roleId, false);
/* 256 */     roleInfo.avatarframeid = AvatarFrameInterface.getCurrentAvatarFrameId(roleId, false);
/* 257 */     roleInfo.rolelevel = RoleInterface.getLevel(roleId);
/* 258 */     return roleInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sSynInviteJoinInfo(final List<Long> receiveRoleIds, InviteConfirmBean xInviteConfirmBean)
/*     */   {
/* 269 */     final SSynInviteJoinInfo syn = new SSynInviteJoinInfo();
/* 270 */     syn.inviter_id = ((Long)xInviteConfirmBean.getAllroles().get(0)).longValue();
/* 271 */     syn.invite_type = xInviteConfirmBean.getInvitetype();
/* 272 */     syn.session_id = xInviteConfirmBean.getSessionid();
/* 273 */     Session session = Session.getSession(xInviteConfirmBean.getSessionid());
/* 274 */     if (session != null)
/*     */     {
/* 276 */       syn.end_time = TimeUnit.MILLISECONDS.toSeconds(session.getTimeoutTimestamp());
/*     */     }
/*     */     else
/*     */     {
/* 280 */       syn.end_time = TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis());
/*     */     }
/* 282 */     List<Long> allRoles = new ArrayList(xInviteConfirmBean.getAllroles());
/* 283 */     new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 288 */         for (Iterator i$ = this.val$allRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */           
/* 290 */           syn.role_info_list.add(InviteManager.getRoleInfo(roleId));
/*     */         }
/* 292 */         OnlineManager.getInstance().sendMulti(syn, receiveRoleIds);
/* 293 */         return true;
/*     */       }
/*     */     }.execute();
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
/*     */   static boolean isInInviteConfirm(long roleId)
/*     */   {
/* 308 */     return Role2inviteconfirm_info.select(Long.valueOf(roleId)) != null;
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
/*     */   static InviteConfirmBean destroyInviteInfo(long roleId)
/*     */   {
/* 321 */     Long inviteConfirmId = Role2inviteconfirm_info.get(Long.valueOf(roleId));
/* 322 */     if (inviteConfirmId == null)
/*     */     {
/* 324 */       return null;
/*     */     }
/*     */     
/* 327 */     InviteConfirmBean xInviteConfirmBean = Inviteconfirm_info.get(inviteConfirmId);
/*     */     
/* 329 */     if (xInviteConfirmBean == null)
/*     */     {
/* 331 */       Role2inviteconfirm_info.remove(Long.valueOf(roleId));
/* 332 */       return null;
/*     */     }
/*     */     
/* 335 */     Inviteconfirm_info.remove(inviteConfirmId);
/* 336 */     List<Long> allRoles = new ArrayList(xInviteConfirmBean.getAllroles());
/*     */     
/* 338 */     new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 343 */         Lockeys.lock(Role2inviteconfirm_info.getTable(), this.val$allRoles);
/* 344 */         for (Iterator i$ = this.val$allRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */           
/* 346 */           Role2inviteconfirm_info.remove(Long.valueOf(roleId));
/*     */           
/* 348 */           RoleStatusInterface.unsetStatus(roleId, 1861);
/*     */         }
/* 350 */         return true;
/*     */       }
/* 352 */     }.execute();
/* 353 */     return xInviteConfirmBean;
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
/*     */   static void synDoSuccessAction(InviteConfirmBean xInviteConfirmBean)
/*     */   {
/* 366 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*     */ 
/* 373 */         InviteConfirmHandler handler = InviteManager.getInviteConfirmHandler(this.val$xInviteConfirmBean.getInvitetype());
/* 374 */         if (handler == null)
/*     */         {
/*     */ 
/* 377 */           return false;
/*     */         }
/* 379 */         return handler.afterInviteSuccess(this.val$xInviteConfirmBean.getAllroles(), this.val$xInviteConfirmBean.getContext());
/*     */       }
/*     */     }.execute();
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
/*     */   static void synDoFailAction(InviteConfirmBean xInviteConfirmBean)
/*     */   {
/* 394 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*     */ 
/* 401 */         InviteConfirmHandler handler = InviteManager.getInviteConfirmHandler(this.val$xInviteConfirmBean.getInvitetype());
/* 402 */         if (handler == null)
/*     */         {
/*     */ 
/* 405 */           return false;
/*     */         }
/* 407 */         return handler.afterInviteFail(this.val$xInviteConfirmBean.getAllroles(), this.val$xInviteConfirmBean.getContext());
/*     */       }
/*     */     }.execute();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\invite\InviteManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */