/*     */ package mzm.gsp.corps.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*     */ import mzm.gsp.avatar.main.AvatarInterface;
/*     */ import mzm.gsp.corps.CorpsBriefInfo;
/*     */ import mzm.gsp.corps.CorpsInfo;
/*     */ import mzm.gsp.corps.CorpsMemberExtroInfo;
/*     */ import mzm.gsp.corps.CorpsMemberOtherInfo;
/*     */ import mzm.gsp.corps.CorpsMemberSynInfo;
/*     */ import mzm.gsp.corps.CorpsSynInfo;
/*     */ import mzm.gsp.corps.SCorpsNormalInfo;
/*     */ import mzm.gsp.corps.SCreateCorpsConfirmErrBro;
/*     */ import mzm.gsp.corps.SSynMemberInfo;
/*     */ import mzm.gsp.corps.SSynMemberModelChange;
/*     */ import mzm.gsp.corps.SSyncCorpsInfo;
/*     */ import mzm.gsp.corps.confbean.CorpsConsts;
/*     */ import mzm.gsp.corps.confbean.SCorpsBadgeCfg;
/*     */ import mzm.gsp.corps.confbean.SCorpsDutyCfg;
/*     */ import mzm.gsp.corps.confbean.SCorpsHistoryCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.sensitive.main.SensitiveInterface;
/*     */ import mzm.gsp.server.main.AvailableStringArgs;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CorpsCacheBean;
/*     */ import xbean.CorpsDutyMembers;
/*     */ import xbean.CorpsHistory;
/*     */ import xbean.CreateCorpsConfBean;
/*     */ import xbean.Pod;
/*     */ import xdb.util.UniqName;
/*     */ import xio.Protocol;
/*     */ import xtable.Role2corps;
/*     */ import xtable.Role2createcorpsconf;
/*     */ 
/*     */ public class CorpsManager
/*     */ {
/*     */   static final String ENCODING = "UTF-8";
/*     */   
/*     */   static int getCreateCorpsMinGuysNum()
/*     */   {
/*  58 */     return GMDataManager.getInstance().getCreateMinPeopleNum();
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
/*     */   static void fillCorpsInfo(xbean.Corps xCorps, CorpsInfo corpsinfo)
/*     */   {
/*  71 */     fillCorpsBriefInfo(xCorps, corpsinfo.corpsbriefinfo);
/*     */     
/*  73 */     for (Map.Entry<Integer, CorpsDutyMembers> entry : xCorps.getDuty2members().entrySet())
/*     */     {
/*  75 */       for (i$ = ((CorpsDutyMembers)entry.getValue()).getMembers().iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*     */         
/*  77 */         mzm.gsp.corps.CorpsMember pCorpsMember = new mzm.gsp.corps.CorpsMember();
/*  78 */         fillPCorpsMember(xCorps, member, pCorpsMember);
/*  79 */         corpsinfo.members.put(Long.valueOf(member), pCorpsMember);
/*     */       }
/*     */     }
/*     */     Iterator i$;
/*     */   }
/*     */   
/*     */   static void fillCorpsSynInfo(xbean.Corps xCorps, CorpsSynInfo corpsSynInfo) {
/*  86 */     fillCorpsBriefInfo(xCorps, corpsSynInfo.corpsbriefinfo);
/*  87 */     for (Map.Entry<Integer, CorpsDutyMembers> entry : xCorps.getDuty2members().entrySet())
/*     */     {
/*  89 */       for (i$ = ((CorpsDutyMembers)entry.getValue()).getMembers().iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*     */         
/*  91 */         CorpsMemberSynInfo memberInfo = new CorpsMemberSynInfo();
/*  92 */         fillCorpsMemberSynInfo(xCorps, member, memberInfo);
/*  93 */         corpsSynInfo.members.put(Long.valueOf(member), memberInfo);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     Iterator i$;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void fillCorpsMemberSynInfo(xbean.Corps xCorps, long member, CorpsMemberSynInfo memberInfo)
/*     */   {
/* 107 */     fillPCorpsMember(xCorps, member, memberInfo.baseinfo);
/* 108 */     fillCorpsMemberExtroInfo(member, memberInfo.extroinfo);
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
/*     */   static void fillCorpsMemberExtroInfo(long roleId, CorpsMemberExtroInfo extroinfo)
/*     */   {
/* 121 */     RoleInterface.fillModelInfo(roleId, extroinfo.model);
/* 122 */     extroinfo.multifightvalue = RoleInterface.getRoleMFValue(roleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void fillCorpsBriefInfo(xbean.Corps xCorps, CorpsBriefInfo corpsbriefinfo)
/*     */   {
/*     */     try
/*     */     {
/* 135 */       corpsbriefinfo.name.setString(xCorps.getCorpsname(), "UTF-8");
/* 136 */       corpsbriefinfo.declaration.setString(xCorps.getCorpsdeclaration(), "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/* 142 */     corpsbriefinfo.corpsid = xCorps.getCorpsid();
/* 143 */     corpsbriefinfo.createtime = ((int)(xCorps.getCreatetime() / 1000L));
/* 144 */     corpsbriefinfo.corpsbadgeid = xCorps.getCorpsbadge();
/* 145 */     corpsbriefinfo.createtime = ((int)(xCorps.getCreatetime() / 1000L));
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
/*     */   static void fillPCorpsMember(xbean.Corps xCorps, long member, mzm.gsp.corps.CorpsMember pCorpsMember)
/*     */   {
/* 159 */     xbean.CorpsMember xCorpsMember = Role2corps.select(Long.valueOf(member));
/* 160 */     if (xCorpsMember == null)
/*     */     {
/*     */ 
/* 163 */       GameServer.logger().error(String.format("[crops]CorpsManager.fillPCorpsMember@ IMPOSSIBLE! member is null!|cropsId=%d|corpsName=%s|roleId=%d", new Object[] { Long.valueOf(xCorps.getCorpsid()), xCorps.getCorpsname(), Long.valueOf(member) }));
/*     */       
/*     */ 
/*     */ 
/* 167 */       return;
/*     */     }
/* 169 */     pCorpsMember.duty = xCorpsMember.getDuty();
/* 170 */     pCorpsMember.jointime = ((int)(xCorpsMember.getJointime() / 1000L));
/*     */     
/* 172 */     Role role = RoleInterface.getRole(member, false);
/* 173 */     pCorpsMember.roleid = member;
/* 174 */     pCorpsMember.level = role.getLevel();
/* 175 */     pCorpsMember.occupationid = role.getOccupationId();
/* 176 */     pCorpsMember.avatarid = AvatarInterface.getCurrentAvatar(member, false);
/* 177 */     pCorpsMember.avatarframeid = AvatarFrameInterface.getCurrentAvatarFrameId(member, false);
/* 178 */     pCorpsMember.gender = role.getGender();
/*     */     
/*     */     try
/*     */     {
/* 182 */       pCorpsMember.name.setString(role.getName(), "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 190 */     if (!OnlineManager.getInstance().isOnlineOrInProtect(member))
/*     */     {
/* 192 */       pCorpsMember.offlinetime = ((int)(role.getLastLogoffTime() / 1000L));
/*     */     }
/*     */     else
/*     */     {
/* 196 */       pCorpsMember.offlinetime = 0;
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
/*     */   static void fillPCorpsMemberOtherInfo(long roleId, CorpsMemberOtherInfo otherinfo)
/*     */   {
/* 210 */     otherinfo.multifightvalue = RoleInterface.getRoleMFValue(roleId);
/* 211 */     otherinfo.mfvrank = RoleInterface.getRoleOccupatinMFVRank(roleId);
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
/*     */   static xbean.Corps createCorps(long roleId, String corpsName, String declaration, int badgeId)
/*     */   {
/* 224 */     if (!checkString(roleId, corpsName, declaration))
/*     */     {
/* 226 */       return null;
/*     */     }
/*     */     
/* 229 */     if (!UniqName.allocate("corps", corpsName))
/*     */     {
/*     */ 
/* 232 */       GameServer.logger().error(String.format("[crops]CorpsManager.createCrops@ crops' name is duplicated!|cropsName=%s|declaration=%s", new Object[] { corpsName, declaration }));
/*     */       
/*     */ 
/* 235 */       sendCorpsNotice(roleId, false, 2, new String[0]);
/* 236 */       return null;
/*     */     }
/*     */     
/* 239 */     xbean.Corps xCorps = Pod.newCorps();
/* 240 */     long cropsId = xtable.Corps.insert(xCorps).longValue();
/*     */     
/* 242 */     xCorps.setCorpsid(cropsId);
/* 243 */     xCorps.setCorpsname(corpsName);
/* 244 */     xCorps.setCorpsbadge(badgeId);
/* 245 */     xCorps.setCorpsdeclaration(declaration);
/* 246 */     xCorps.setCreatetime(DateTimeUtils.getCurrTimeInMillis());
/* 247 */     xCorps.setNexthistoryid(1);
/*     */     
/*     */ 
/* 250 */     List<String> params = new ArrayList();
/* 251 */     params.add(RoleInterface.getName(roleId));
/* 252 */     params.add(corpsName);
/* 253 */     addCorpsHistory(xCorps, 1, params);
/*     */     
/* 255 */     return xCorps;
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
/*     */   static boolean checkString(long roleId, String corpsName, String declaration)
/*     */   {
/* 268 */     int checkContentRes = checkCorpsString(corpsName, declaration);
/* 269 */     if (checkContentRes != 0)
/*     */     {
/* 271 */       GameServer.logger().error(String.format("[crops]CorpsManager.createCorps@ corps' string is illegal!|corpsName=%s|declaration=%s|errRes=%d", new Object[] { corpsName, declaration, Integer.valueOf(checkContentRes) }));
/*     */       
/*     */ 
/*     */ 
/* 275 */       sendCorpsNotice(roleId, false, checkContentRes, new String[0]);
/* 276 */       return false;
/*     */     }
/*     */     
/* 279 */     int res = UniqName.exist("corps", corpsName);
/* 280 */     if ((res == 12345) || (res == 4))
/*     */     {
/*     */ 
/* 283 */       GameServer.logger().error(String.format("[crops]CorpsManager.createCrops@ crops' name is duplicated!|cropsName=%s|declaration=%s", new Object[] { corpsName, declaration }));
/*     */       
/*     */ 
/* 286 */       sendCorpsNotice(roleId, false, 2, new String[0]);
/* 287 */       return false;
/*     */     }
/* 289 */     return true;
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
/*     */   static void joinCorps(long roleId, xbean.Corps xCorps, int duty, long joinTime)
/*     */   {
/* 303 */     xbean.CorpsMember xCropsMember = Pod.newCorpsMember();
/* 304 */     xCropsMember.setCorpsid(xCorps.getCorpsid());
/* 305 */     xCropsMember.setJointime(joinTime);
/* 306 */     changeDuty(roleId, xCorps, xCropsMember, duty, true);
/* 307 */     Role2corps.insert(Long.valueOf(roleId), xCropsMember);
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
/*     */   static void changeDuty(long roleId, xbean.Corps xCorps, xbean.CorpsMember xCorpsMember, int newDuty, boolean isNewGuy)
/*     */   {
/* 322 */     rmoldDuty(roleId, xCorps, xCorpsMember.getDuty(), newDuty, isNewGuy);
/*     */     
/* 324 */     getXDutyMembers(xCorps, newDuty).add(Long.valueOf(roleId));
/*     */     
/* 326 */     xCorpsMember.setDuty(newDuty);
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
/*     */   static boolean removeMemberFromeDB(long roleId, xbean.Corps xCorps, xbean.CorpsMember xCorpsMember)
/*     */   {
/* 339 */     int duty = xCorpsMember.getDuty();
/*     */     
/* 341 */     CorpsDutyMembers xCorpsDutyMembers = (CorpsDutyMembers)xCorps.getDuty2members().get(Integer.valueOf(duty));
/* 342 */     if (xCorpsDutyMembers == null)
/*     */     {
/* 344 */       GameServer.logger().error(String.format("[corps]CorpsManager.removeMemberFromeDB@ IMPOSSIBLE! can not find duty!|roleId=%d|duty=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(duty) }));
/*     */       
/*     */ 
/*     */ 
/* 348 */       return false;
/*     */     }
/* 350 */     xCorpsDutyMembers.getMembers().remove(Long.valueOf(roleId));
/*     */     
/* 352 */     Role2corps.remove(Long.valueOf(roleId));
/* 353 */     return true;
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
/*     */   static void HandCorpsAppellationNoneRealTime(long roleId, HandCorpsAppellation.AppellationHandType handType)
/*     */   {
/* 366 */     NoneRealTimeTaskManager.getInstance().addTask(new HandCorpsAppellation(roleId, handType));
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
/*     */   static List<String> getCorpsAppellationArgs(int duty, long corpsId, String corpsName)
/*     */   {
/* 379 */     String dutyName = getDutyName(duty).trim();
/* 380 */     if (dutyName.equalsIgnoreCase(""))
/*     */     {
/* 382 */       GameServer.logger().error(String.format("[corps]CorpsManager.getCorpsAppellationArgs@ IMPOSSIBLE! not have this duty name!|corpsId=%d|duty=%d", new Object[] { Long.valueOf(corpsId), Integer.valueOf(duty) }));
/*     */       
/*     */ 
/*     */ 
/* 386 */       return null;
/*     */     }
/* 388 */     List<String> args = new ArrayList();
/* 389 */     args.add(corpsName);
/* 390 */     args.add(dutyName);
/* 391 */     return args;
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
/*     */   static void synCorpsMemberBaseChange(long roleId)
/*     */   {
/* 404 */     xbean.CorpsMember xCorpsMember = Role2corps.select(Long.valueOf(roleId));
/* 405 */     if (xCorpsMember == null)
/*     */     {
/* 407 */       return;
/*     */     }
/*     */     
/* 410 */     long corpsId = xCorpsMember.getCorpsid();
/* 411 */     xbean.Corps xCorps = xtable.Corps.select(Long.valueOf(corpsId));
/* 412 */     if (xCorps == null)
/*     */     {
/* 414 */       GameServer.logger().error(String.format("[corps]POnRoleLogin.processImp@ IMPOSSIBLE! not have this corps!|roleId=%d|corpsId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(corpsId) }));
/*     */       
/*     */ 
/*     */ 
/* 418 */       return;
/*     */     }
/* 420 */     SSynMemberInfo syn = new SSynMemberInfo();
/* 421 */     fillPCorpsMember(xCorps, roleId, syn.memberinfo);
/* 422 */     corpsBrocast(xCorps, true, syn);
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
/*     */   static void synCorpsMemberModelChange(long roleId)
/*     */   {
/* 435 */     xbean.CorpsMember xCorpsMember = Role2corps.select(Long.valueOf(roleId));
/* 436 */     if (xCorpsMember == null)
/*     */     {
/* 438 */       return;
/*     */     }
/*     */     
/* 441 */     long corpsId = xCorpsMember.getCorpsid();
/* 442 */     xbean.Corps xCorps = xtable.Corps.select(Long.valueOf(corpsId));
/* 443 */     if (xCorps == null)
/*     */     {
/* 445 */       GameServer.logger().error(String.format("[corps]POnRoleLogin.processImp@ IMPOSSIBLE! not have this corps!|roleId=%d|corpsId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(corpsId) }));
/*     */       
/*     */ 
/*     */ 
/* 449 */       return;
/*     */     }
/* 451 */     SSynMemberModelChange syn = new SSynMemberModelChange();
/* 452 */     syn.roleid = roleId;
/* 453 */     RoleInterface.fillModelInfo(roleId, syn.model);
/*     */     
/* 455 */     corpsBrocast(xCorps, true, syn);
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
/*     */   static void sendCorpsNotice(long roleid, boolean afterSuc, int result, String... args)
/*     */   {
/* 468 */     SCorpsNormalInfo pro = new SCorpsNormalInfo();
/* 469 */     pro.result = result;
/* 470 */     for (String arg : args)
/*     */     {
/* 472 */       Octets octets = new Octets();
/*     */       try
/*     */       {
/* 475 */         octets.setString(arg, "UTF-8");
/*     */       }
/*     */       catch (UnsupportedEncodingException e) {}
/*     */       
/*     */ 
/*     */ 
/* 481 */       pro.args.add(octets);
/*     */     }
/* 483 */     if (afterSuc)
/*     */     {
/* 485 */       OnlineManager.getInstance().send(roleid, pro);
/*     */     }
/*     */     else
/*     */     {
/* 489 */       OnlineManager.getInstance().sendAtOnce(roleid, pro);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, Set<Long>> getCorpsDutyInfo(xbean.Corps xCorps)
/*     */   {
/* 501 */     Map<Integer, Set<Long>> duty2Members = new HashMap();
/*     */     
/* 503 */     for (Map.Entry<Integer, CorpsDutyMembers> entry : xCorps.getDuty2members().entrySet())
/*     */     {
/* 505 */       Set<Long> members = (Set)duty2Members.get(entry.getKey());
/* 506 */       if (members == null)
/*     */       {
/* 508 */         members = new HashSet();
/* 509 */         duty2Members.put(entry.getKey(), members);
/*     */       }
/* 511 */       members.addAll(((CorpsDutyMembers)entry.getValue()).getMembers());
/*     */     }
/*     */     
/* 514 */     return duty2Members;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getCaptain(xbean.Corps xCorps)
/*     */   {
/* 525 */     long leaderId = -1L;
/* 526 */     CorpsDutyMembers xCorpsDutyMembers = (CorpsDutyMembers)xCorps.getDuty2members().get(Integer.valueOf(1));
/* 527 */     if (xCorpsDutyMembers == null)
/*     */     {
/* 529 */       return leaderId;
/*     */     }
/* 531 */     Iterator i$ = xCorpsDutyMembers.getMembers().iterator(); if (i$.hasNext()) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 533 */       leaderId = roleId;
/*     */     }
/*     */     
/* 536 */     return leaderId;
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
/* 549 */     CreateCorpsConfBean xConfBean = Role2createcorpsconf.get(Long.valueOf(leaderId));
/* 550 */     if (xConfBean == null)
/*     */     {
/* 552 */       return;
/*     */     }
/* 554 */     Session session = Session.getSession(xConfBean.getSessionid());
/* 555 */     if ((session == null) || (!(session instanceof CreateCorpsConfirmSession)))
/*     */     {
/*     */ 
/* 558 */       Role2createcorpsconf.remove(Long.valueOf(leaderId));
/* 559 */       GameServer.logger().error(String.format("[corps]POnJoinTeam.processImp@ session is null but db not null!|leaderId=%d", new Object[] { Long.valueOf(leaderId) }));
/*     */       
/* 561 */       return;
/*     */     }
/*     */     
/* 564 */     Session.removeSession(xConfBean.getSessionid());
/*     */     
/* 566 */     OnlineManager.getInstance().sendMulti(new SCreateCorpsConfirmErrBro(), xConfBean.getAllroles());
/*     */     
/* 568 */     Role2createcorpsconf.remove(Long.valueOf(leaderId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static String getDutyName(int duty)
/*     */   {
/* 579 */     SCorpsDutyCfg cfg = SCorpsDutyCfg.get(duty);
/* 580 */     if (cfg == null)
/*     */     {
/* 582 */       return "";
/*     */     }
/* 584 */     return cfg.dutyName;
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
/*     */   static void corpsBrocast(xbean.Corps xCorps, boolean afterSuc, Protocol p)
/*     */   {
/* 597 */     if (p == null)
/*     */     {
/* 599 */       return;
/*     */     }
/* 601 */     Set<Long> members = getCorpsMemberSet(xCorps);
/* 602 */     if ((members == null) || (members.size() == 0))
/*     */     {
/* 604 */       return;
/*     */     }
/* 606 */     if (afterSuc)
/*     */     {
/* 608 */       OnlineManager.getInstance().sendMulti(p, members);
/*     */     }
/*     */     else
/*     */     {
/* 612 */       OnlineManager.getInstance().sendMultiAtOnce(p, members);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Long> getCorpsMemberSet(xbean.Corps xCorps)
/*     */   {
/* 624 */     Set<Long> members = new HashSet();
/* 625 */     if (xCorps == null)
/*     */     {
/* 627 */       return members;
/*     */     }
/* 629 */     for (CorpsDutyMembers xCorpsDutyMembers : xCorps.getDuty2members().values())
/*     */     {
/* 631 */       members.addAll(xCorpsDutyMembers.getMembers());
/*     */     }
/* 633 */     return members;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addCorpsHistory(xbean.Corps xCorps, int type, List<String> params)
/*     */   {
/* 645 */     if (xCorps == null)
/*     */     {
/* 647 */       return;
/*     */     }
/* 649 */     checkAndSetHistoryId(xCorps);
/* 650 */     checkAndremoveOldHistory(xCorps);
/* 651 */     addNewHistory(xCorps, type, params);
/*     */   }
/*     */   
/*     */   private static void addNewHistory(xbean.Corps xCorps, int type, List<String> params)
/*     */   {
/* 656 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 657 */     CorpsHistory xCorpsHistory = Pod.newCorpsHistory();
/* 658 */     xCorpsHistory.setHistorytype(type);
/* 659 */     xCorpsHistory.setRecordtime((int)(curTime / 1000L));
/* 660 */     xCorpsHistory.getParameters().addAll(params);
/* 661 */     int historyId = xCorps.getNexthistoryid();
/* 662 */     xCorpsHistory.setHistoryid(historyId);
/* 663 */     xCorps.getHistorylist().add(xCorpsHistory);
/*     */     
/* 665 */     xCorps.setNexthistoryid(historyId + 1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void checkAndremoveOldHistory(xbean.Corps xCorps)
/*     */   {
/* 675 */     if (xCorps.getHistorylist().size() < CorpsConsts.getInstance().HISTORY_MAX)
/*     */     {
/* 677 */       return;
/*     */     }
/* 679 */     boolean find = false;
/* 680 */     Iterator<CorpsHistory> it = xCorps.getHistorylist().iterator();
/* 681 */     while (it.hasNext())
/*     */     {
/* 683 */       CorpsHistory each = (CorpsHistory)it.next();
/* 684 */       SCorpsHistoryCfg cfg = SCorpsHistoryCfg.get(each.getHistorytype());
/* 685 */       if (cfg == null)
/*     */       {
/* 687 */         it.remove();
/*     */ 
/*     */       }
/* 690 */       else if (cfg.canDel)
/*     */       {
/* 692 */         it.remove();
/* 693 */         find = true;
/* 694 */         break;
/*     */       }
/*     */     }
/* 697 */     if (!find)
/*     */     {
/* 699 */       xCorps.getHistorylist().remove(0);
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
/*     */ 
/*     */   static void checkAndSetHistoryId(xbean.Corps xCorps)
/*     */   {
/* 714 */     int nextHistoryId = xCorps.getNexthistoryid();
/* 715 */     if (nextHistoryId > 0)
/*     */     {
/* 717 */       return;
/*     */     }
/* 719 */     nextHistoryId = 1;
/* 720 */     for (CorpsHistory xCorpsHistory : xCorps.getHistorylist())
/*     */     {
/* 722 */       xCorpsHistory.setHistoryid(nextHistoryId);
/* 723 */       nextHistoryId++;
/*     */     }
/* 725 */     xCorps.setNexthistoryid(nextHistoryId);
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
/*     */   static void synSingleCorpsInfo(long roleId)
/*     */   {
/* 738 */     xbean.CorpsMember xCorpsMember = Role2corps.select(Long.valueOf(roleId));
/* 739 */     if (xCorpsMember == null)
/*     */     {
/* 741 */       return;
/*     */     }
/*     */     
/* 744 */     long corpsId = xCorpsMember.getCorpsid();
/* 745 */     xbean.Corps xCorps = xtable.Corps.select(Long.valueOf(corpsId));
/* 746 */     if (xCorps == null)
/*     */     {
/* 748 */       GameServer.logger().error(String.format("[corps]POnRoleLogin.processImp@ IMPOSSIBLE! not have this corps!|roleId=%d|corpsId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(corpsId) }));
/*     */       
/*     */ 
/*     */ 
/* 752 */       return;
/*     */     }
/*     */     
/* 755 */     SSyncCorpsInfo sync = new SSyncCorpsInfo();
/* 756 */     fillCorpsSynInfo(xCorps, sync.corpsinfo);
/* 757 */     OnlineManager.getInstance().send(roleId, sync);
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
/*     */   static SCorpsBadgeCfg getCorpsBadgeCfg(int badgeId)
/*     */   {
/* 770 */     return SCorpsBadgeCfg.get(badgeId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean canCreateCorps()
/*     */   {
/* 780 */     return OpenInterface.getOpenStatus(348);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean canJoinCorps()
/*     */   {
/* 790 */     return OpenInterface.getOpenStatus(348);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean canLeaveCorps()
/*     */   {
/* 800 */     return OpenInterface.getOpenStatus(348);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean canChangeCorpsCaptain()
/*     */   {
/* 810 */     return OpenInterface.getOpenStatus(348);
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
/*     */   static void rmInvitedRecord(long corpsId, long invitee)
/*     */   {
/* 823 */     CorpsCacheBean xCorCacheBean = xtable.Corpscache.get(Long.valueOf(corpsId));
/* 824 */     if (xCorCacheBean == null)
/*     */     {
/* 826 */       return;
/*     */     }
/*     */     
/* 829 */     xCorCacheBean.getInvitedroleinfo().remove(Long.valueOf(invitee));
/*     */   }
/*     */   
/*     */   private static void rmoldDuty(long roleId, xbean.Corps xCorps, int oldDuty, int newDuty, boolean isNewGuy)
/*     */   {
/* 834 */     if (isNewGuy)
/*     */     {
/*     */ 
/* 837 */       return;
/*     */     }
/* 839 */     if (newDuty == oldDuty)
/*     */     {
/* 841 */       return;
/*     */     }
/* 843 */     getXDutyMembers(xCorps, oldDuty).remove(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Set<Long> getXDutyMembers(xbean.Corps xCorps, int duty)
/*     */   {
/* 855 */     return getXCorpsDutyMembersIfAbsent(xCorps, duty).getMembers();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static CorpsDutyMembers getXCorpsDutyMembersIfAbsent(xbean.Corps xCorps, int duty)
/*     */   {
/* 867 */     CorpsDutyMembers xCorpsDutyMembers = (CorpsDutyMembers)xCorps.getDuty2members().get(Integer.valueOf(duty));
/* 868 */     if (xCorpsDutyMembers == null)
/*     */     {
/* 870 */       xCorpsDutyMembers = Pod.newCorpsDutyMembers();
/* 871 */       xCorps.getDuty2members().put(Integer.valueOf(duty), xCorpsDutyMembers);
/*     */     }
/* 873 */     return xCorpsDutyMembers;
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
/*     */   private static int checkCorpsString(String corpsName, String declaration)
/*     */   {
/* 887 */     corpsName = corpsName.trim();
/* 888 */     if ((corpsName.isEmpty()) || (Math.ceil(CommonUtils.getUTF16Length(corpsName) / 2.0D) > CorpsConsts.getInstance().CORPS_NAME_MAX_LENGTH) || (Math.ceil(CommonUtils.getUTF16Length(corpsName) / 2.0D) < CorpsConsts.getInstance().CORPS_NAME_MIN_LENGTH) || (!AvailableStringArgs.getInstance().isStringUsable(corpsName)))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 893 */       return 1;
/*     */     }
/* 895 */     if (SensitiveInterface.isNameSensitive(corpsName))
/*     */     {
/* 897 */       return 1;
/*     */     }
/* 899 */     if (SensitiveInterface.isContentSensitive(declaration))
/*     */     {
/* 901 */       return 3;
/*     */     }
/*     */     
/* 904 */     if ((Math.ceil(CommonUtils.getUTF16Length(declaration) / 2.0D) > CorpsConsts.getInstance().CORPS_DECLARATION_MAX_LENGTH) || (Math.ceil(CommonUtils.getUTF16Length(declaration) / 2.0D) < CorpsConsts.getInstance().CORPS_DECLARATION_MIN_LENGTH))
/*     */     {
/*     */ 
/* 907 */       return 3;
/*     */     }
/* 909 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\CorpsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */