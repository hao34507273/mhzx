/*     */ package mzm.gsp.confirm.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.confirm.SConfirmReq;
/*     */ import mzm.gsp.function.confbean.SCommonTeamConfirmCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.SystemSetting;
/*     */ import xbean.TeamConfirmBean;
/*     */ import xio.Protocol;
/*     */ import xtable.Role2teamconf;
/*     */ 
/*     */ public class ConfirmManager
/*     */ {
/*     */   static void startTeamConfirm(long teamId, int confirmType, TeamConfirmContext context)
/*     */   {
/*  31 */     TeamInfo teamInfo = mzm.gsp.team.main.TeamInterface.getTeamInfo(teamId, true);
/*  32 */     if (teamInfo == null)
/*     */     {
/*  34 */       GameServer.logger().error(String.format("[confirm]ConfirmManager.startTeamConfirm@ handler is null!|teamId=%d|confirmType=%d", new Object[] { Long.valueOf(teamId), Integer.valueOf(confirmType) }));
/*     */       
/*     */ 
/*  37 */       return;
/*     */     }
/*  39 */     List<Long> normalMembers = teamInfo.getTeamNormalList();
/*  40 */     if (normalMembers.size() == 0)
/*     */     {
/*  42 */       GameServer.logger().error(String.format("[confirm]ConfirmManager.startTeamConfirm@ normalMembers is null!|teamId=%d|confirmType=%d", new Object[] { Long.valueOf(teamId), Integer.valueOf(confirmType) }));
/*     */       
/*     */ 
/*  45 */       return;
/*     */     }
/*  47 */     if (normalMembers.size() == 1)
/*     */     {
/*     */ 
/*  50 */       GameServer.logger().info(String.format("[confirm]ConfirmManager.startTeamConfirm@ only leader!|teamId=%d|confirmType=%d", new Object[] { Long.valueOf(teamId), Integer.valueOf(confirmType) }));
/*     */       
/*     */ 
/*  53 */       asynDoAcceptedAction(teamId, confirmType, context);
/*  54 */       return;
/*     */     }
/*     */     
/*  57 */     SCommonTeamConfirmCfg cfg = SCommonTeamConfirmCfg.get(confirmType);
/*  58 */     if (cfg == null)
/*     */     {
/*     */ 
/*  61 */       GameServer.logger().error(String.format("[confirm]ConfirmManager.startTeamConfirm@ SCommonTeamConformCfg is null!|teamId=%d|confirmType=%d", new Object[] { Long.valueOf(teamId), Integer.valueOf(confirmType) }));
/*     */       
/*     */ 
/*     */ 
/*  65 */       return;
/*     */     }
/*     */     
/*  68 */     long leaderId = teamInfo.getLeaderId();
/*  69 */     TeamConfirmHandler handler = getTeamConfirmHandler(confirmType);
/*  70 */     if (handler == null)
/*     */     {
/*  72 */       GameServer.logger().error(String.format("[confirm]ConfirmManager.startTeamConfirm@ handler is null!|teamId=%d|leaderId=%d|confirmType=%d", new Object[] { Long.valueOf(teamId), Long.valueOf(leaderId), Integer.valueOf(confirmType) }));
/*     */       
/*     */ 
/*     */ 
/*  76 */       return;
/*     */     }
/*     */     
/*  79 */     if (Role2teamconf.get(Long.valueOf(leaderId)) != null)
/*     */     {
/*  81 */       GameServer.logger().error(String.format("[confirm]ConfirmManager.startTeamConfirm@ leaderId is confirming!|teamId=%d|leaderId=%d|confirmType=%d", new Object[] { Long.valueOf(teamId), Long.valueOf(leaderId), Integer.valueOf(confirmType) }));
/*     */       
/*     */ 
/*     */ 
/*  85 */       return;
/*     */     }
/*     */     
/*  88 */     TeamConfirmSession session = new TeamConfirmSession(cfg.timeLimit, leaderId);
/*     */     
/*  90 */     TeamConfirmBean xTeamConfirmBean = initConfData(leaderId, session.getSessionId(), normalMembers, context, confirmType, cfg.timeLimit);
/*     */     
/*     */ 
/*     */ 
/*  94 */     asynConfirmInfo(teamId, confirmType, context, normalMembers, getConfirmBaseInfo(xTeamConfirmBean));
/*     */   }
/*     */   
/*     */ 
/*     */   static void asynConfirmInfo(final long teamId, final int confirmType, TeamConfirmContext context, List<Long> roleIds, final SConfirmReq req)
/*     */   {
/* 100 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*     */ 
/* 107 */         Set<Long> defaultAgreeRoleIds = ConfirmManager.getConfirmDefaultAgreeRoleIds(this.val$roleIds, confirmType);
/* 108 */         TeamConfirmHandler handler = ConfirmManager.getTeamConfirmHandler(confirmType);
/* 109 */         if (handler == null)
/*     */         {
/* 111 */           return false;
/*     */         }
/* 113 */         Protocol p = handler.getConfirmProtocol(teamId, confirmType, req);
/* 114 */         if (p != null)
/*     */         {
/* 116 */           Octets pdata = new OctetsStream().marshal(p);
/* 117 */           this.val$req.extroinfo = pdata;
/*     */         }
/* 119 */         this.val$req.defaultagreeroleids.addAll(defaultAgreeRoleIds);
/* 120 */         OnlineManager.getInstance().sendMulti(this.val$req, this.val$roleIds);
/* 121 */         return true;
/*     */       }
/*     */     }.execute();
/*     */   }
/*     */   
/*     */   static SConfirmReq fillSConfirmPro(TeamConfirmBean xTeamConfirmBean, Protocol p)
/*     */   {
/* 128 */     SConfirmReq req = getConfirmBaseInfo(xTeamConfirmBean);
/* 129 */     if (p != null)
/*     */     {
/* 131 */       Octets pdata = new OctetsStream().marshal(p);
/* 132 */       req.extroinfo = pdata;
/*     */     }
/* 134 */     return req;
/*     */   }
/*     */   
/*     */   static SConfirmReq getConfirmBaseInfo(TeamConfirmBean xTeamConfirmBean)
/*     */   {
/* 139 */     SConfirmReq req = new SConfirmReq();
/* 140 */     fillConfirmBaseInfo(xTeamConfirmBean, req);
/* 141 */     return req;
/*     */   }
/*     */   
/*     */   static void fillConfirmBaseInfo(TeamConfirmBean xTeamConfirmBean, SConfirmReq req)
/*     */   {
/* 146 */     req.confirmtype = xTeamConfirmBean.getConfirmtype();
/* 147 */     req.sessionid = xTeamConfirmBean.getSessionid();
/* 148 */     req.acceptedmembers.addAll(xTeamConfirmBean.getAcceptroles());
/* 149 */     req.endtime = ((int)xTeamConfirmBean.getEndtime());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static TeamConfirmBean initConfData(long roleId, long sessionId, List<Long> allMembers, TeamConfirmContext context, int confirmType, int timeLimit)
/*     */   {
/* 160 */     TeamConfirmBean xConfBean = Role2teamconf.get(Long.valueOf(roleId));
/* 161 */     if (xConfBean == null)
/*     */     {
/* 163 */       Role2teamconf.insert(Long.valueOf(roleId), xConfBean = xbean.Pod.newTeamConfirmBean());
/*     */     }
/* 165 */     xConfBean.getAllroles().clear();
/* 166 */     xConfBean.getAcceptroles().clear();
/* 167 */     xConfBean.setSessionid(sessionId);
/* 168 */     xConfBean.getAllroles().addAll(allMembers);
/* 169 */     xConfBean.setContext(context);
/* 170 */     xConfBean.setConfirmtype(confirmType);
/*     */     
/* 172 */     xConfBean.getAcceptroles().add(Long.valueOf(roleId));
/*     */     
/* 174 */     xConfBean.setEndtime((int)(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() / 1000L) + timeLimit);
/*     */     
/* 176 */     return xConfBean;
/*     */   }
/*     */   
/* 179 */   private static Map<Integer, TeamConfirmHandler> confirmType2Handler = new java.util.concurrent.ConcurrentHashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void registerConfirmHandler(int confirmType, TeamConfirmHandler handler)
/*     */   {
/* 189 */     if (handler == null)
/*     */     {
/*     */ 
/* 192 */       return;
/*     */     }
/* 194 */     if (confirmType2Handler.containsKey(Integer.valueOf(confirmType)))
/*     */     {
/*     */ 
/* 197 */       return;
/*     */     }
/* 199 */     confirmType2Handler.put(Integer.valueOf(confirmType), handler);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static TeamConfirmHandler getTeamConfirmHandler(int confirmType)
/*     */   {
/* 210 */     return (TeamConfirmHandler)confirmType2Handler.get(Integer.valueOf(confirmType));
/*     */   }
/*     */   
/*     */   static void check()
/*     */   {
/*     */     try
/*     */     {
/* 217 */       Field[] fields = mzm.gsp.function.confbean.ConfirmType.class.getFields();
/* 218 */       for (Field field : fields)
/*     */       {
/* 220 */         int confirmType = field.getInt(null);
/* 221 */         if (!confirmType2Handler.containsKey(Integer.valueOf(confirmType)))
/*     */         {
/*     */ 
/*     */ 
/* 225 */           throw new RuntimeException(String.format("[confirm]ConfirmManager.check@not register confirm handler of the type(%s)|confirm_type=%d", new Object[] { field.getName(), Integer.valueOf(confirmType) }));
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 232 */       throw new RuntimeException(e);
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
/*     */   static void afterTeamChange(long leaderId)
/*     */   {
/* 246 */     TeamConfirmBean xConfBean = Role2teamconf.get(Long.valueOf(leaderId));
/* 247 */     if (xConfBean == null)
/*     */     {
/* 249 */       return;
/*     */     }
/*     */     
/* 252 */     Session.removeSession(xConfBean.getSessionid());
/*     */     
/* 254 */     OnlineManager.getInstance().sendMulti(new mzm.gsp.confirm.SConfirmErrBro(), xConfBean.getAllroles());
/*     */     
/* 256 */     Role2teamconf.remove(Long.valueOf(leaderId));
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
/*     */   static void asynDoAcceptedAction(final long teamId, int confirmType, TeamConfirmContext context)
/*     */   {
/* 269 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*     */ 
/* 276 */         TeamConfirmHandler handler = ConfirmManager.getTeamConfirmHandler(this.val$confirmType);
/* 277 */         if (handler == null)
/*     */         {
/*     */ 
/* 280 */           return false;
/*     */         }
/* 282 */         return handler.afterAllAccepted(teamId, this.val$confirmType, this.val$context);
/*     */       }
/*     */     }.execute();
/*     */   }
/*     */   
/*     */   static Map<Integer, Integer> getConformInfos(SystemSetting xSystemSetting)
/*     */   {
/* 289 */     Map<Integer, Integer> settings = new HashMap();
/* 290 */     for (SCommonTeamConfirmCfg cfg : SCommonTeamConfirmCfg.getAll().values())
/*     */     {
/* 292 */       if (cfg.canSet)
/*     */       {
/*     */ 
/*     */ 
/* 296 */         settings.put(Integer.valueOf(cfg.confirmType), Integer.valueOf(getOptionRes(xSystemSetting, cfg))); }
/*     */     }
/* 298 */     return settings;
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
/*     */   static Set<Long> getConfirmDefaultAgreeRoleIds(Collection<Long> roleIds, int confirmType)
/*     */   {
/* 312 */     SCommonTeamConfirmCfg cfg = SCommonTeamConfirmCfg.get(confirmType);
/* 313 */     if (cfg == null)
/*     */     {
/* 315 */       return Collections.emptySet();
/*     */     }
/* 317 */     if (!cfg.canSet)
/*     */     {
/*     */ 
/* 320 */       if (cfg.defaultRefuse)
/*     */       {
/* 322 */         return Collections.emptySet();
/*     */       }
/* 324 */       return new HashSet(roleIds);
/*     */     }
/* 326 */     Set<Long> agreeRoleIds = new HashSet();
/* 327 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 329 */       SystemSetting xSystemSetting = xtable.Role2systemsetting.select(Long.valueOf(roleId));
/* 330 */       if (xSystemSetting != null)
/*     */       {
/*     */ 
/*     */ 
/* 334 */         if (getOptionRes(xSystemSetting, cfg) > 0)
/*     */         {
/* 336 */           agreeRoleIds.add(Long.valueOf(roleId)); }
/*     */       }
/*     */     }
/* 339 */     return agreeRoleIds;
/*     */   }
/*     */   
/*     */   private static int getOptionRes(SystemSetting xSystemSetting, SCommonTeamConfirmCfg cfg)
/*     */   {
/* 344 */     Integer res = (Integer)xSystemSetting.getConformsettings().get(Integer.valueOf(cfg.confirmType));
/* 345 */     return res == null ? 1 : cfg.defaultRefuse ? 0 : res.intValue();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\confirm\main\ConfirmManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */