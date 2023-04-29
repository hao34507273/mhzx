/*     */ package mzm.gsp.corps.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.corps.SCreateCorpsSucBro;
/*     */ import mzm.gsp.corps.SCreateCorpsSucRep;
/*     */ import mzm.gsp.corps.SCreateErrAlreadyHaveCorps;
/*     */ import mzm.gsp.corps.confbean.CorpsConsts;
/*     */ import mzm.gsp.corps.confbean.SCorpsBadgeCfg;
/*     */ import mzm.gsp.corps.event.CorpsCreate;
/*     */ import mzm.gsp.corps.event.CorpsCreateEventArg;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Corps;
/*     */ import xbean.CorpsGlobal;
/*     */ import xbean.Pod;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Corpsglobal;
/*     */ import xtable.Role2corps;
/*     */ import xtable.Team;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCreateCorps
/*     */   extends LogicProcedure
/*     */ {
/*     */   protected final long roleId;
/*     */   protected final int badgeId;
/*     */   protected final Octets nameOctets;
/*     */   protected final Octets declarationOctets;
/*     */   protected String corpsName;
/*     */   protected String declaration;
/*     */   
/*     */   public PCreateCorps(long roleId, Octets corpsNameOctets, Octets declarationOctets, int badgeId)
/*     */   {
/*  60 */     this.roleId = roleId;
/*  61 */     this.nameOctets = corpsNameOctets;
/*  62 */     this.declarationOctets = declarationOctets;
/*  63 */     this.badgeId = badgeId;
/*     */     
/*  65 */     String tmpName = null;
/*  66 */     String tmpdeclaration = null;
/*     */     try
/*     */     {
/*  69 */       tmpName = corpsNameOctets.getString("UTF-8");
/*  70 */       tmpdeclaration = declarationOctets.getString("UTF-8");
/*     */     }
/*     */     catch (Exception e) {}
/*     */     
/*     */ 
/*     */ 
/*  76 */     this.corpsName = tmpName;
/*  77 */     this.declaration = tmpdeclaration;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  83 */   protected final Set<Long> lockRoleIds = new HashSet();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  88 */   protected final Map<Long, String> roleidToUserid = new HashMap();
/*     */   
/*     */ 
/*     */   private long teamId;
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  98 */     if (!isParameterValid())
/*     */     {
/*     */ 
/* 101 */       return false;
/*     */     }
/* 103 */     if (!MapInterface.isNearByNPC(this.roleId, CorpsConsts.getInstance().NPC_ID))
/*     */     {
/* 105 */       GameServer.logger().error(String.format("[corps]PCreateCorps.processImp@ not near by npc!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     Lockeys.lock(User.getTable(), this.roleidToUserid.values());
/*     */     
/* 111 */     lock(Basic.getTable(), this.lockRoleIds);
/*     */     
/* 113 */     lock(Team.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.teamId) }));
/*     */     
/* 115 */     if (!checkAfterGetLock())
/*     */     {
/*     */ 
/* 118 */       return false;
/*     */     }
/* 120 */     if (!CorpsManager.checkString(this.roleId, this.corpsName, this.declaration))
/*     */     {
/*     */ 
/* 123 */       GameServer.logger().error(String.format("[corps]PCreateCorps.processImp@ check string err!|roleId=%d|cropsName=%s|declaration=%s|badge=%d", new Object[] { Long.valueOf(this.roleId), this.corpsName, this.declaration, Integer.valueOf(this.badgeId) }));
/*     */       
/*     */ 
/*     */ 
/* 127 */       return false;
/*     */     }
/*     */     
/* 130 */     return doAction();
/*     */   }
/*     */   
/*     */   boolean doAction()
/*     */   {
/* 135 */     return createCorps();
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean createCorps()
/*     */   {
/* 141 */     if (!payPrice())
/*     */     {
/* 143 */       GameServer.logger().error(String.format("[corps]PCreateCorps.createCorps@ pay price err!|roleId=%d|cropsName=%s|declaration=%s|badge=%d", new Object[] { Long.valueOf(this.roleId), this.corpsName, this.declaration, Integer.valueOf(this.badgeId) }));
/*     */       
/*     */ 
/*     */ 
/* 147 */       return false;
/*     */     }
/*     */     
/* 150 */     Corps xCorps = CorpsManager.createCorps(this.roleId, this.corpsName, this.declaration, this.badgeId);
/* 151 */     if (xCorps == null)
/*     */     {
/* 153 */       GameServer.logger().error(String.format("[corps]PCreateCorps.createCorps@ create crops err!|roleId=%d|cropsName=%s|declaration=%s|badge=%d", new Object[] { Long.valueOf(this.roleId), this.corpsName, this.declaration, Integer.valueOf(this.badgeId) }));
/*     */       
/*     */ 
/*     */ 
/* 157 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 161 */     for (Iterator i$ = this.lockRoleIds.iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*     */       
/* 163 */       CorpsManager.joinCorps(member, xCorps, member == this.roleId ? 1 : 2, xCorps.getCreatetime());
/*     */       
/*     */ 
/* 166 */       if (this.roleId != member)
/*     */       {
/*     */ 
/*     */ 
/* 170 */         List<String> params = new ArrayList();
/* 171 */         params.add(RoleInterface.getName(member));
/* 172 */         CorpsManager.addCorpsHistory(xCorps, 6, params);
/*     */       }
/*     */     }
/* 175 */     addGlobalData(xCorps);
/*     */     
/* 177 */     afterCreateCorps(xCorps);
/* 178 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addGlobalData(Corps xCorps)
/*     */   {
/* 190 */     CorpsGlobal xGlobal = Corpsglobal.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 191 */     if (xGlobal == null)
/*     */     {
/* 193 */       Corpsglobal.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xGlobal = Pod.newCorpsGlobal());
/*     */     }
/* 195 */     xGlobal.getAllcorpsids().add(Long.valueOf(xCorps.getCorpsid()));
/*     */   }
/*     */   
/*     */   private boolean payPrice()
/*     */   {
/* 200 */     return RoleInterface.cutGold(this.roleId, CorpsConsts.getInstance().CREATE_CORPS_COST_GOLD_NUM, new TLogArg(LogReason.CREATE_CORPS_COST));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void afterCreateCorps(Corps xCorps)
/*     */   {
/* 207 */     SCreateCorpsSucRep rep = new SCreateCorpsSucRep();
/* 208 */     CorpsManager.fillCorpsSynInfo(xCorps, rep.corpsinfo);
/* 209 */     CorpsManager.corpsBrocast(xCorps, true, rep);
/*     */     
/* 211 */     broAllCropsCreate(xCorps);
/*     */     
/* 213 */     sendCreateMail(xCorps);
/*     */     
/* 215 */     CorpsLogManager.logCreateCorps((String)this.roleidToUserid.get(Long.valueOf(this.roleId)), this.roleId, xCorps.getCorpsid(), CorpsManager.getCorpsDutyInfo(xCorps));
/*     */     
/*     */ 
/* 218 */     TriggerEventsManger.getInstance().triggerEvent(new CorpsCreate(), new CorpsCreateEventArg(xCorps.getCorpsid()));
/*     */   }
/*     */   
/*     */   private void sendCreateMail(Corps xCorps)
/*     */   {
/* 223 */     List<String> contextArg = new ArrayList();
/* 224 */     contextArg.add(RoleInterface.getName(this.roleId));
/* 225 */     contextArg.add(xCorps.getCorpsname());
/* 226 */     for (Iterator i$ = CorpsManager.getCorpsMemberSet(xCorps).iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*     */       
/* 228 */       MailInterface.asynBuildAndSendMail(member, CorpsConsts.getInstance().CREATE_MAIL_ID, null, contextArg, new TLogArg(LogReason.CRETE_CORPS_MAIL));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void broAllCropsCreate(Corps xCorps)
/*     */   {
/* 240 */     SCreateCorpsSucBro bro = new SCreateCorpsSucBro();
/*     */     try
/*     */     {
/* 243 */       bro.captainname.setString(RoleInterface.getName(this.roleId), "UTF-8");
/* 244 */       bro.corpsname.setString(xCorps.getCorpsname(), "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 251 */     OnlineManager.getInstance().sendAll(bro);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkAfterGetLock()
/*     */   {
/* 262 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1221, true))
/*     */     {
/* 264 */       return false;
/*     */     }
/* 266 */     if (Role2corps.get(Long.valueOf(this.roleId)) != null)
/*     */     {
/* 268 */       GameServer.logger().error(String.format("[crops]PCreateCorps.checkAfterGetLock@ already have crops!|roleId=%d|cropsName=%s|declaration=%s|badge=%d", new Object[] { Long.valueOf(this.roleId), this.corpsName, this.declaration, Integer.valueOf(this.badgeId) }));
/*     */       
/*     */ 
/*     */ 
/* 272 */       return false;
/*     */     }
/*     */     
/* 275 */     if (!isTeamConditionOkAFGetLock())
/*     */     {
/*     */ 
/* 278 */       return false;
/*     */     }
/* 280 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isParameterValid()
/*     */   {
/* 290 */     if (!isTeamConditionOkBfGetLock())
/*     */     {
/*     */ 
/* 293 */       return false;
/*     */     }
/* 295 */     if (!isBadgeOk(this.badgeId))
/*     */     {
/*     */ 
/* 298 */       return false;
/*     */     }
/* 300 */     if (!CorpsManager.canCreateCorps())
/*     */     {
/* 302 */       GameServer.logger().error(String.format("[crops]PCreateCorps.isParameterValid@ create crops shut down!|roleId=%d|cropsName=%s|declaration=%s|badge=%d", new Object[] { Long.valueOf(this.roleId), this.corpsName, this.declaration, Integer.valueOf(this.badgeId) }));
/*     */       
/*     */ 
/*     */ 
/* 306 */       return false;
/*     */     }
/* 308 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isBadgeOk(int badgeId)
/*     */   {
/* 320 */     return SCorpsBadgeCfg.get(badgeId) != null;
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
/*     */   private boolean isTeamConditionOkBfGetLock()
/*     */   {
/* 333 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/* 334 */     if (teamInfo == null)
/*     */     {
/* 336 */       GameServer.logger().error(String.format("[crops]PCCreateCrops.isTeamConditionOkBfGetLock@ no team!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/* 338 */       return false;
/*     */     }
/* 340 */     if (!teamInfo.isLeader(this.roleId))
/*     */     {
/* 342 */       GameServer.logger().error(String.format("[crops]PCCreateCrops.isTeamConditionOkBfGetLock@ not leader!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/* 344 */       return false;
/*     */     }
/* 346 */     List<Long> normalMembers = teamInfo.getTeamNormalList();
/* 347 */     if ((normalMembers.size() < CorpsManager.getCreateCorpsMinGuysNum()) || (normalMembers.size() > CorpsConsts.getInstance().CAPACITY))
/*     */     {
/*     */ 
/* 350 */       GameServer.logger().error(String.format("[crops]PCCreateCrops.isTeamConditionOkBfGetLock@ normal member's num illegal!|roleId=%d|num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(normalMembers.size()) }));
/*     */       
/*     */ 
/*     */ 
/* 354 */       return false;
/*     */     }
/* 356 */     if (!isAllMemberOk(normalMembers))
/*     */     {
/* 358 */       GameServer.logger().error(String.format("[crops]PCCreateCrops.isTeamConditionOkBfGetLock@ contains member illegal!|roleId=%d|normalMembers=%s", new Object[] { Long.valueOf(this.roleId), normalMembers }));
/*     */       
/*     */ 
/*     */ 
/* 362 */       return false;
/*     */     }
/*     */     
/* 365 */     for (Iterator i$ = normalMembers.iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*     */       
/*     */ 
/* 368 */       this.roleidToUserid.put(Long.valueOf(member), RoleInterface.getUserId(member));
/*     */     }
/* 370 */     this.lockRoleIds.addAll(normalMembers);
/* 371 */     this.teamId = teamInfo.getTeamId();
/*     */     
/* 373 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isTeamConditionOkAFGetLock()
/*     */   {
/* 383 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(this.teamId, true);
/* 384 */     if (teamInfo == null)
/*     */     {
/* 386 */       GameServer.logger().error(String.format("[crops]PCCreateCrops.isTeamConditionOkAFGetLock@ no team!|roleId=%d|teamId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.teamId) }));
/*     */       
/*     */ 
/* 389 */       return false;
/*     */     }
/* 391 */     if (!teamInfo.isLeader(this.roleId))
/*     */     {
/* 393 */       GameServer.logger().error(String.format("[crops]PCCreateCrops.isTeamConditionOkAFGetLock@ not leader!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/* 395 */       return false;
/*     */     }
/* 397 */     List<Long> normalMembers = teamInfo.getTeamNormalList();
/* 398 */     if ((this.lockRoleIds.size() != normalMembers.size()) || (!this.lockRoleIds.containsAll(normalMembers)))
/*     */     {
/* 400 */       GameServer.logger().error(String.format("[crops]PCCreateCrops.isTeamConditionOkAFGetLock@ team member changed!|roleId=%d|lockRoleIds=%s|normalMembers=%s", new Object[] { Long.valueOf(this.roleId), this.lockRoleIds, normalMembers }));
/*     */       
/*     */ 
/*     */ 
/* 404 */       return false;
/*     */     }
/* 406 */     if (!isAllMemberOk(normalMembers))
/*     */     {
/* 408 */       GameServer.logger().error(String.format("[crops]PCCreateCrops.isTeamConditionOkAFGetLock@ contains member illegal!|roleId=%d|normalMembers=%s", new Object[] { Long.valueOf(this.roleId), normalMembers }));
/*     */       
/*     */ 
/*     */ 
/* 412 */       return false;
/*     */     }
/*     */     
/* 415 */     return true;
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
/*     */   private boolean isAllMemberOk(Collection<Long> members)
/*     */   {
/* 429 */     HashMap<Long, Octets> roleIdsWithCrops = new HashMap();
/* 430 */     for (Iterator i$ = members.iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*     */       
/* 432 */       if (Role2corps.select(Long.valueOf(member)) != null)
/*     */       {
/* 434 */         Octets octets = new Octets();
/*     */         try
/*     */         {
/* 437 */           octets.setString(RoleInterface.getName(member), "UTF-8");
/*     */         }
/*     */         catch (UnsupportedEncodingException e) {}
/*     */         
/*     */ 
/*     */ 
/* 443 */         roleIdsWithCrops.put(Long.valueOf(member), octets);
/*     */ 
/*     */       }
/* 446 */       else if (RoleInterface.getLevel(member) < CorpsConsts.getInstance().MIN_LEVEL)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 451 */         GameServer.logger().error(String.format("[crops]PCreateCorps.isAllMemberOk@ cotains member with corps!|roleId=%d|roleIdsWithCorps=%s", new Object[] { Long.valueOf(this.roleId), roleIdsWithCrops }));
/*     */         
/*     */ 
/*     */ 
/* 455 */         return false;
/*     */       } }
/* 457 */     if (roleIdsWithCrops.size() > 0)
/*     */     {
/*     */ 
/* 460 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SCreateErrAlreadyHaveCorps(roleIdsWithCrops));
/* 461 */       GameServer.logger().error(String.format("[crops]PCreateCorps.isAllMemberOk@ cotains member with corps!|roleId=%d|roleIdsWithCorps=%s", new Object[] { Long.valueOf(this.roleId), roleIdsWithCrops }));
/*     */       
/*     */ 
/*     */ 
/* 465 */       return false;
/*     */     }
/* 467 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PCreateCorps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */