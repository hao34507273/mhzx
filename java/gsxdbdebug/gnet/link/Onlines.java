/*     */ package gnet.link;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import gnet.UserInfoRep;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.UserLoginArg;
/*     */ import mzm.gsp.online.main.LoginAssistManager;
/*     */ import mzm.gsp.online.main.OnlineInfoArgs;
/*     */ import mzm.gsp.online.main.OnlineRoleSizeExtendMap;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.json.JSONObject;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import xbean.OnlineUserInfo;
/*     */ import xdb.Trace;
/*     */ import xio.Engine;
/*     */ import xio.Manager;
/*     */ import xio.Protocol;
/*     */ import xio.Xio;
/*     */ import xtable.Onlineuserinfo;
/*     */ 
/*     */ public class Onlines extends Manager implements xdb.Procedure.IOnlines
/*     */ {
/*  38 */   private static Onlines instance = null;
/*     */   
/*     */   public Onlines() {
/*  41 */     instance = this;
/*     */   }
/*     */   
/*     */   public static Onlines getInstance() {
/*  45 */     return instance;
/*     */   }
/*     */   
/*  48 */   private final Set<Integer> binds = new HashSet();
/*     */   
/*     */   protected void parse(Element self) throws Exception
/*     */   {
/*  52 */     super.parse(self);
/*  53 */     for (String s : self.getAttribute("bind").split(",")) {
/*  54 */       this.binds.add(Integer.valueOf(s));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void loadConf(String conf)
/*     */     throws Exception
/*     */   {
/*  63 */     Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(conf);
/*  64 */     Engine.getInstance().register(new xio.XioConf(doc.getDocumentElement()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  71 */   private final Map<Long, Role> roles = new OnlineRoleSizeExtendMap();
/*  72 */   private final Map<String, Role> userToRoles = new OnlineRoleSizeExtendMap();
/*     */   
/*     */ 
/*  75 */   private final Map<String, Role.LinkSessons> usersSessions = new OnlineRoleSizeExtendMap();
/*     */   
/*  77 */   private final ReadWriteLock sessionRoleLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*     */   
/*  79 */   private final Map<String, JSONObject> userLoginStateInfoSynMap = java.util.Collections.synchronizedMap(new OnlineRoleSizeExtendMap());
/*     */   public static final int TRUNK_SEND_COUNT = 300;
/*     */   
/*     */   public void addUserLoginStateInfoMap(String userid, UserLoginArg loginArg) {
/*  83 */     this.userLoginStateInfoSynMap.put(userid, loginArg.getLoginStateInfo());
/*     */   }
/*     */   
/*     */   public final String findOpenKey(String userid) {
/*  87 */     JSONObject jsonLoginStateInfo = (JSONObject)this.userLoginStateInfoSynMap.get(userid);
/*  88 */     if ((jsonLoginStateInfo != null) && (jsonLoginStateInfo.has("openkey"))) {
/*  89 */       return jsonLoginStateInfo.getString("openkey");
/*     */     }
/*  91 */     return "";
/*     */   }
/*     */   
/*     */   public final String findPayToken(String userid) {
/*  95 */     JSONObject jsonLoginStateInfo = (JSONObject)this.userLoginStateInfoSynMap.get(userid);
/*  96 */     if ((jsonLoginStateInfo != null) && (jsonLoginStateInfo.has("paytoken"))) {
/*  97 */       return jsonLoginStateInfo.getString("paytoken");
/*     */     }
/*  99 */     return "";
/*     */   }
/*     */   
/*     */   public final String findPF(String userid) {
/* 103 */     JSONObject jsonLoginStateInfo = (JSONObject)this.userLoginStateInfoSynMap.get(userid);
/* 104 */     if ((jsonLoginStateInfo != null) && (jsonLoginStateInfo.has("pf"))) {
/* 105 */       return jsonLoginStateInfo.getString("pf");
/*     */     }
/* 107 */     return "";
/*     */   }
/*     */   
/*     */   public final String findPFKey(String userid) {
/* 111 */     JSONObject jsonLoginStateInfo = (JSONObject)this.userLoginStateInfoSynMap.get(userid);
/* 112 */     if ((jsonLoginStateInfo != null) && (jsonLoginStateInfo.has("pfkey"))) {
/* 113 */       return jsonLoginStateInfo.getString("pfkey");
/*     */     }
/* 115 */     return "";
/*     */   }
/*     */   
/*     */   public int getRoleNum() {
/* 119 */     this.sessionRoleLock.readLock().lock();
/*     */     try {
/* 121 */       return this.roles.size();
/*     */     } finally {
/* 123 */       this.sessionRoleLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void addUserSession(String userid, Link link, int linksid) {
/* 128 */     this.sessionRoleLock.writeLock().lock();
/*     */     try {
/* 130 */       Role.LinkSessons linkSessons = (Role.LinkSessons)this.usersSessions.get(userid);
/* 131 */       if (linkSessons == null) {
/* 132 */         linkSessons = new Role.LinkSessons();
/* 133 */         this.usersSessions.put(userid, linkSessons);
/*     */       }
/* 135 */       linkSessons.addSession(link.newSession(linksid));
/*     */     } finally {
/* 137 */       this.sessionRoleLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void remUserSession(String userid, Link link, int linksid) {
/* 142 */     this.sessionRoleLock.writeLock().lock();
/*     */     try {
/* 144 */       Role.LinkSessons linkSessons = (Role.LinkSessons)this.usersSessions.get(userid);
/* 145 */       if (linkSessons == null) {
/*     */         return;
/*     */       }
/* 148 */       linkSessons.remove(link, linksid);
/* 149 */       if (linkSessons.size() == 0) {
/* 150 */         this.usersSessions.remove(userid);
/*     */       }
/*     */     } finally {
/* 153 */       this.sessionRoleLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public Role find(Long roleid) {
/* 158 */     this.sessionRoleLock.readLock().lock();
/*     */     try {
/* 160 */       return (Role)this.roles.get(roleid);
/*     */     } finally {
/* 162 */       this.sessionRoleLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public String getUserid(Long roleid) {
/* 167 */     this.sessionRoleLock.readLock().lock();
/*     */     try {
/* 169 */       Role role = (Role)this.roles.get(roleid);
/* 170 */       if (role != null) {
/* 171 */         return role.getUserid();
/*     */       }
/*     */     } finally {
/* 174 */       this.sessionRoleLock.readLock().unlock();
/*     */     }
/* 176 */     return null;
/*     */   }
/*     */   
/*     */   public Role find(String userid) {
/* 180 */     this.sessionRoleLock.readLock().lock();
/*     */     try {
/* 182 */       return (Role)this.userToRoles.get(userid);
/*     */     } finally {
/* 184 */       this.sessionRoleLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRoleid(String userid) {
/* 189 */     this.sessionRoleLock.readLock().lock();
/*     */     try {
/* 191 */       Role role = (Role)this.userToRoles.get(userid);
/* 192 */       if (role != null) {
/* 193 */         return Long.valueOf(role.getRoleid());
/*     */       }
/*     */     } finally {
/* 196 */       this.sessionRoleLock.readLock().unlock();
/*     */     }
/* 198 */     return null;
/*     */   }
/*     */   
/*     */   public Role remove(Long roleid) {
/* 202 */     Role role = null;
/* 203 */     this.sessionRoleLock.writeLock().lock();
/*     */     try {
/* 205 */       role = (Role)this.roles.remove(roleid);
/* 206 */       if (role != null) {
/* 207 */         this.userToRoles.remove(role.getUserid());
/*     */       }
/*     */     } finally {
/* 210 */       this.sessionRoleLock.writeLock().unlock();
/*     */     }
/* 212 */     if (null != role)
/* 213 */       role.setLogin(0);
/* 214 */     return role;
/*     */   }
/*     */   
/*     */   public Role find(Xio io, int linksid) {
/* 218 */     Link link = find(io);
/* 219 */     if (null != link)
/* 220 */       return link.find(Integer.valueOf(linksid));
/* 221 */     return null;
/*     */   }
/*     */   
/*     */   public int findAlgorithm(String userid) {
/* 225 */     Integer ret = userid == null ? null : Onlineuserinfo.selectAlgorithm(userid);
/* 226 */     if (ret == null) {
/* 227 */       return 0;
/*     */     }
/* 229 */     return ret.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */   public int findip(String userid)
/*     */   {
/* 235 */     Integer peer = userid == null ? null : Onlineuserinfo.selectPeer(userid);
/* 236 */     if (peer == null) {
/* 237 */       return 0;
/*     */     }
/* 239 */     return peer.intValue();
/*     */   }
/*     */   
/*     */   public int findfuc(String userid)
/*     */   {
/* 244 */     Integer func = userid == null ? null : Onlineuserinfo.selectFunc(userid);
/* 245 */     if (func == null) {
/* 246 */       return 0;
/*     */     }
/* 248 */     return func.intValue();
/*     */   }
/*     */   
/*     */   public int findfuncparm(String userid) {
/* 252 */     Integer funcParam = userid == null ? null : Onlineuserinfo.selectFuncparm(userid);
/* 253 */     if (funcParam == null) {
/* 254 */       return 0;
/*     */     }
/* 256 */     return funcParam.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String findChannel(String userid)
/*     */   {
/* 268 */     String channel = userid == null ? null : Onlineuserinfo.selectChannel(userid);
/* 269 */     if (channel == null) {
/* 270 */       return "0";
/*     */     }
/* 272 */     return channel;
/*     */   }
/*     */   
/*     */   public String findMSDKChannel(String userid)
/*     */   {
/* 277 */     return findChannel(userid);
/*     */   }
/*     */   
/*     */   public String findMSDKRegisterChannel(String userid) {
/* 281 */     String registerChannel = userid == null ? null : Onlineuserinfo.selectRegisterchannel(userid);
/* 282 */     if (registerChannel == null) {
/* 283 */       return "0";
/*     */     }
/* 285 */     return registerChannel;
/*     */   }
/*     */   
/*     */   public void insertUserInfo(final String userid, final UserInfoRep userInfoRep)
/*     */   {
/* 290 */     final UserLoginArg loginArg = new UserLoginArg(userInfoRep.device_info, userInfoRep.extinfo);
/* 291 */     addUserLoginStateInfoMap(userid, loginArg);
/*     */     
/* 293 */     new mzm.gsp.util.LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/* 297 */         OnlineUserInfo onlineUserInfo = Onlineuserinfo.get(userid);
/* 298 */         if (onlineUserInfo == null) {
/* 299 */           onlineUserInfo = xbean.Pod.newOnlineUserInfo();
/* 300 */           Onlineuserinfo.insert(userid, onlineUserInfo);
/*     */         }
/* 302 */         onlineUserInfo.setAlgorithm(userInfoRep.algorithm);
/* 303 */         onlineUserInfo.setChannel(loginArg.channelid);
/* 304 */         onlineUserInfo.setRegisterchannel(loginArg.registerChannelid);
/* 305 */         onlineUserInfo.setFunc(userInfoRep.func);
/* 306 */         onlineUserInfo.setFuncparm(userInfoRep.funcparm);
/* 307 */         onlineUserInfo.setPeer(userInfoRep.loginip);
/* 308 */         onlineUserInfo.setGameappid(loginArg.gameAppid);
/* 309 */         onlineUserInfo.setPlatid(loginArg.platid);
/* 310 */         onlineUserInfo.setFake_plat(loginArg.fakePlat);
/* 311 */         onlineUserInfo.setTelecomoper(loginArg.telecomOper);
/*     */         try {
/* 313 */           Iterator<String> iterator = loginArg.jsonParams.keys();
/* 314 */           while (iterator.hasNext()) {
/* 315 */             String key = (String)iterator.next();
/* 316 */             String value = loginArg.jsonParams.getString(key);
/* 317 */             onlineUserInfo.getJsonparams().put(key, value);
/*     */           }
/*     */         } catch (Exception e) {
/* 320 */           String josString = "";
/* 321 */           if (loginArg.jsonParams != null) {
/* 322 */             josString = loginArg.jsonParams.toString();
/*     */           }
/* 324 */           GameServer.logger().error(String.format("[Online]Onlines.insertUserInfo@解析jsonParam出错|userid=%s|jsonParam=%s", new Object[] { userid, josString }), e);
/*     */         }
/*     */         
/*     */ 
/* 328 */         return true;
/*     */       }
/*     */     }.call();
/*     */   }
/*     */   
/*     */   public boolean hasUserInfo(String userid) {
/* 334 */     return userid != null;
/*     */   }
/*     */   
/*     */   public OnlineUserInfo findUserInfo(String userid) {
/* 338 */     return userid == null ? null : Onlineuserinfo.select(userid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int findPlatid(String userid)
/*     */   {
/* 348 */     Integer platid = userid == null ? null : Onlineuserinfo.selectPlatid(userid);
/* 349 */     if (platid == null) {
/* 350 */       return -1;
/*     */     }
/* 352 */     return platid.intValue();
/*     */   }
/*     */   
/*     */   public boolean findFakePlat(String userid)
/*     */   {
/* 357 */     Boolean fakePlat = userid == null ? null : Onlineuserinfo.selectFake_plat(userid);
/* 358 */     if (fakePlat == null) {
/* 359 */       return false;
/*     */     }
/* 361 */     return fakePlat.booleanValue();
/*     */   }
/*     */   
/*     */   public String findEnumFromLoginArg(int key, OnlineUserInfo onlineUserInfo)
/*     */   {
/* 366 */     if (onlineUserInfo == null) {
/* 367 */       return "";
/*     */     }
/* 369 */     String strKey = String.valueOf(key);
/* 370 */     String value = (String)onlineUserInfo.getJsonparams().get(strKey);
/* 371 */     if (value == null) {
/* 372 */       return "";
/*     */     }
/* 374 */     return value;
/*     */   }
/*     */   
/*     */ 
/*     */   public String findDeviceIdentifier(String userid)
/*     */   {
/* 380 */     return findEnumFromLoginArg(11, findUserInfo(userid));
/*     */   }
/*     */   
/*     */   public String findMac(String userid) {
/* 384 */     return findEnumFromLoginArg(11, findUserInfo(userid));
/*     */   }
/*     */   
/*     */   public String findOpenid(String userid) {
/*     */     try {
/* 389 */       return CommonUtils.getOpenId(userid);
/*     */     } catch (Exception e) {
/* 391 */       if (userid != null) {
/* 392 */         GameServer.logger().error("获取openid出错" + userid);
/*     */       } else {
/* 394 */         GameServer.logger().error("获取openid出错,userid为null");
/*     */       }
/*     */     }
/*     */     
/* 398 */     return "";
/*     */   }
/*     */   
/*     */   public String findGameAppid(String userid) {
/* 402 */     String gameAppid = userid == null ? null : Onlineuserinfo.selectGameappid(userid);
/* 403 */     if ((gameAppid == null) || (gameAppid.isEmpty())) {
/* 404 */       String platName = CommonUtils.getPlatName(userid);
/* 405 */       if ("shadow".equals(platName))
/* 406 */         return "1";
/* 407 */       if ("qq".equals(platName)) {
/* 408 */         if (mzm.gsp.GameServerInfoManager.getGuestServerid().equals(Integer.valueOf(CommonUtils.getZoneId(userid)))) {
/* 409 */           return OnlineInfoArgs.getInstance().getQQGuestAppid();
/*     */         }
/* 411 */         return OnlineInfoArgs.getInstance().getQQAppid();
/*     */       }
/* 413 */       if ("wechat".equals(platName)) {
/* 414 */         if (mzm.gsp.GameServerInfoManager.getGuestServerid().equals(Integer.valueOf(CommonUtils.getZoneId(userid)))) {
/* 415 */           return OnlineInfoArgs.getInstance().getWechatGuestAppid();
/*     */         }
/* 417 */         return OnlineInfoArgs.getInstance().getWechatAppid();
/*     */       }
/*     */       
/* 420 */       return "";
/*     */     }
/* 422 */     return gameAppid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Role find(Protocol p2)
/*     */   {
/* 433 */     if (null != p2.getContext()) {
/* 434 */       Role ret = find(p2.getConnection(), ((Dispatch)p2.getContext()).linksid);
/* 435 */       if (ret == null) {
/* 436 */         GameServer.logger().error("role find null" + p2.getConnection().getPeer().toString() + ", linksid=" + ((Dispatch)p2.getContext()).linksid);
/*     */       }
/*     */       
/* 439 */       return ret;
/*     */     }
/* 441 */     return null;
/*     */   }
/*     */   
/*     */   protected Role newRole(String userid, long roleid)
/*     */   {
/* 446 */     return new Role(userid, roleid);
/*     */   }
/*     */   
/*     */   private Role insert(Link link, int linksid, String userid, long roleid) {
/* 450 */     if (null != link) {
/* 451 */       this.sessionRoleLock.writeLock().lock();
/*     */       try {
/* 453 */         Role.LinkSessons linkSessons = (Role.LinkSessons)this.usersSessions.get(userid);
/* 454 */         if (linkSessons == null) {
/* 455 */           return null;
/*     */         }
/* 457 */         boolean hasSession = linkSessons.contains(link, linksid);
/* 458 */         if (!hasSession)
/*     */         {
/* 460 */           return null;
/*     */         }
/*     */         
/* 463 */         Role old = (Role)this.roles.get(Long.valueOf(roleid));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 468 */         if ((null != old) && (old.getUserid().equals(userid))) {
/* 469 */           old.linkAttach(link, linksid);
/* 470 */           remUserSession(userid, link, linksid);
/* 471 */           return old;
/*     */         }
/* 473 */         Role newRole = new Role(userid, roleid);
/* 474 */         newRole.linkAttach(link, linksid);
/* 475 */         this.roles.put(Long.valueOf(roleid), newRole);
/* 476 */         this.userToRoles.put(userid, newRole);
/* 477 */         remUserSession(userid, link, linksid);
/* 478 */         return newRole;
/*     */       }
/*     */       finally
/*     */       {
/* 482 */         this.sessionRoleLock.writeLock().unlock();
/*     */       }
/*     */     }
/* 485 */     Trace.info("Link not found");
/* 486 */     return null;
/*     */   }
/*     */   
/*     */   public Role insert(int ip, int port, int linksid, String userid, long roleid) {
/* 490 */     Link link = find(ip, port);
/* 491 */     Role role = insert(link, linksid, userid, roleid);
/* 492 */     if (role != null) {
/* 493 */       LoginAssistManager.getInstance().remProtectUserOnLoginSuc(userid);
/* 494 */       LoginAssistManager.getInstance().removeFormLoginExcuteQueue(userid, linksid, link.getLinkid());
/*     */     }
/* 496 */     return role;
/*     */   }
/*     */   
/*     */   public Role insert(Protocol p2, long roleid) {
/* 500 */     Dispatch ctx = (Dispatch)p2.getContext();
/* 501 */     String userid = ctx.userid.getString("UTF-8");
/* 502 */     Link link = find(p2.getConnection());
/* 503 */     Role role = insert(link, ctx.linksid, userid, roleid);
/* 504 */     if (role != null) {
/* 505 */       LoginAssistManager.getInstance().remProtectUserOnLoginSuc(userid);
/* 506 */       LoginAssistManager.getInstance().removeFormLoginExcuteQueue(userid, ctx.linksid, link.getLinkid());
/*     */     }
/* 508 */     return role;
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
/*     */   public boolean sendResponse(Protocol THIS, Protocol p2)
/*     */   {
/* 521 */     Dispatch ctx = (Dispatch)THIS.getContext();
/* 522 */     Send msg = new Send();
/* 523 */     msg.linksids.add(Integer.valueOf(ctx.linksid));
/* 524 */     msg.ptype = p2.getType();
/* 525 */     msg.pdata = new OctetsStream().marshal(p2);
/* 526 */     return msg.send(ctx.getConnection());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean send(Long roleid, Protocol p2)
/*     */   {
/* 533 */     Role role = find(roleid);
/* 534 */     if (null != role)
/* 535 */       return role.send(p2);
/* 536 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean send(Set<Long> roleids, Protocol p2)
/*     */   {
/* 547 */     return send(roleids, p2.getType(), new OctetsStream().marshal(p2));
/*     */   }
/*     */   
/*     */   public boolean send(long roleid, int pType, Octets pOctets) {
/* 551 */     Set<Long> roleSet = new HashSet(1);
/* 552 */     roleSet.add(Long.valueOf(roleid));
/* 553 */     return send(roleSet, pType, pOctets);
/*     */   }
/*     */   
/*     */   public boolean send(Role role, int pType, Octets pOctets) {
/* 557 */     if (null == role) {
/* 558 */       return false;
/*     */     }
/* 560 */     List<Link.Session> sessions = role.getLinkSessions();
/* 561 */     if (sessions.size() == 0) {
/* 562 */       Trace.warn("send2 role has broken, roleid=" + role.getRoleid());
/* 563 */       return false;
/*     */     }
/* 565 */     Map<Link, HashSet<Integer>> group = new HashMap();
/* 566 */     for (Link.Session session : sessions) {
/* 567 */       HashSet<Integer> si = (HashSet)group.get(session.getLink());
/* 568 */       if (null == si)
/* 569 */         group.put(session.getLink(), si = new HashSet());
/* 570 */       si.add(Integer.valueOf(session.getSid()));
/*     */     }
/* 572 */     Send msg = new Send();
/* 573 */     msg.ptype = pType;
/* 574 */     msg.pdata = pOctets;
/*     */     
/* 576 */     boolean rc = false;
/* 577 */     for (Map.Entry<Link, HashSet<Integer>> e : group.entrySet()) {
/* 578 */       if (send((Link)e.getKey(), (HashSet)e.getValue(), msg)) {
/* 579 */         rc = true;
/*     */       } else {
/* 581 */         Trace.warn("send2 error, p2=" + Integer.toHexString(pType) + "link=" + e.getKey());
/*     */       }
/*     */     }
/* 584 */     return rc;
/*     */   }
/*     */   
/*     */   public boolean send(Set<Long> roleids, int pType, Octets pOctets) {
/* 588 */     Map<Link, HashSet<Integer>> group = new HashMap();
/*     */     
/* 590 */     boolean rc = true;
/* 591 */     for (Long roleid : roleids) {
/* 592 */       Role role = find(roleid);
/* 593 */       if (null == role) {
/* 594 */         Trace.warn("send2 role not found , roleid=" + roleid);
/* 595 */         rc = false;
/*     */       }
/*     */       else {
/* 598 */         List<Link.Session> sessions = role.getLinkSessions();
/* 599 */         if (sessions.size() == 0) {
/* 600 */           rc = false;
/* 601 */           Trace.warn("send2 role has broken, roleid=" + roleid);
/*     */         }
/*     */         else {
/* 604 */           for (Link.Session session : sessions) {
/* 605 */             HashSet<Integer> si = (HashSet)group.get(session.getLink());
/* 606 */             if (null == si)
/* 607 */               group.put(session.getLink(), si = new HashSet());
/* 608 */             si.add(Integer.valueOf(session.getSid()));
/*     */           }
/*     */         }
/*     */       } }
/* 612 */     Send msg = new Send();
/* 613 */     msg.ptype = pType;
/* 614 */     msg.pdata = pOctets;
/*     */     
/* 616 */     for (Map.Entry<Link, HashSet<Integer>> e : group.entrySet())
/* 617 */       if (!send((Link)e.getKey(), (HashSet)e.getValue(), msg))
/*     */       {
/* 619 */         rc = false;
/* 620 */         Trace.warn("send2 error, p2=" + Integer.toHexString(pType) + "link=" + e.getKey());
/*     */       }
/* 622 */     return rc;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean send(Link link, HashSet<Integer> linksids, Send msg)
/*     */   {
/* 641 */     if (linksids.size() <= 300) {
/* 642 */       msg.linksids = linksids;
/* 643 */       return msg.send(link.getXio());
/*     */     }
/*     */     
/* 646 */     boolean rc = true;
/* 647 */     for (Integer linksid : linksids) {
/* 648 */       if (msg.linksids.size() >= 300) {
/* 649 */         rc = (rc) && (msg.send(link.getXio()));
/* 650 */         msg.linksids.clear();
/*     */       }
/* 652 */       msg.linksids.add(linksid);
/*     */     }
/* 654 */     if (false == msg.linksids.isEmpty())
/* 655 */       rc = (rc) && (msg.send(link.getXio()));
/* 656 */     return rc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean send(Link link, HashSet<Integer> linksids, Protocol p2)
/*     */   {
/* 664 */     Send msg = new Send();
/* 665 */     msg.ptype = p2.getType();
/* 666 */     msg.pdata = new OctetsStream().marshal(p2);
/* 667 */     return send(link, linksids, msg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void broadcast(Protocol p2)
/*     */   {
/* 674 */     broadcast(p2, 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void broadcast(Protocol p2, int timems)
/*     */   {
/* 685 */     Broadcast bc = new Broadcast();
/* 686 */     bc.ptype = p2.getType();
/* 687 */     bc.pdata = new OctetsStream().marshal(p2);
/* 688 */     bc.time = timems;
/* 689 */     for (Link link : links()) {
/* 690 */       if (!bc.send(link.getXio()))
/*     */       {
/* 692 */         Trace.warn("broadcast error, p2=" + Integer.toHexString(p2.getType()) + " link=" + link); }
/*     */     }
/*     */   }
/*     */   
/*     */   public void broadcast(int ptype, Octets octetsStream) {
/* 697 */     broadcast(ptype, octetsStream, 0);
/*     */   }
/*     */   
/*     */   public void broadcast(int ptype, Octets octetsStream, int timems) {
/* 701 */     Broadcast bc = new Broadcast();
/* 702 */     bc.ptype = ptype;
/* 703 */     bc.pdata = octetsStream;
/* 704 */     bc.time = timems;
/* 705 */     for (Link link : links()) {
/* 706 */       if (!bc.send(link.getXio()))
/*     */       {
/* 708 */         Trace.warn("broadcast error, p2=" + Integer.toHexString(ptype) + " link=" + link);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean kick(Long roleid, int error)
/*     */   {
/* 715 */     Role role = find(roleid);
/* 716 */     if (null != role)
/* 717 */       return role.kick(error);
/* 718 */     return false;
/*     */   }
/*     */   
/*     */   public boolean gacdkick(Long roleid, int error) {
/* 722 */     Role role = find(roleid);
/* 723 */     if (null != role)
/* 724 */       return role.gacdkick(error);
/* 725 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean bind(Long roleid, int pvid)
/*     */   {
/* 731 */     Role role = find(roleid);
/* 732 */     if (null != role)
/* 733 */       return role.bind(pvid);
/* 734 */     return false;
/*     */   }
/*     */   
/*     */   public boolean unbind(Long roleid, int pvid) {
/* 738 */     Role role = find(roleid);
/* 739 */     if (null != role)
/* 740 */       return role.unbind(pvid);
/* 741 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/* 746 */   private Map<InetSocketAddress, Link> links = new HashMap();
/* 747 */   private final Object mutex = new Object();
/*     */   private volatile Handle handle;
/*     */   
/*     */   /* Error */
/*     */   public Link[] links()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 20	gnet/link/Onlines:mutex	Ljava/lang/Object;
/*     */     //   4: dup
/*     */     //   5: astore_1
/*     */     //   6: monitorenter
/*     */     //   7: aload_0
/*     */     //   8: getfield 17	gnet/link/Onlines:links	Ljava/util/Map;
/*     */     //   11: invokeinterface 206 1 0
/*     */     //   16: iconst_0
/*     */     //   17: anewarray 176	gnet/link/Link
/*     */     //   20: invokeinterface 207 2 0
/*     */     //   25: checkcast 208	[Lgnet/link/Link;
/*     */     //   28: aload_1
/*     */     //   29: monitorexit
/*     */     //   30: areturn
/*     */     //   31: astore_2
/*     */     //   32: aload_1
/*     */     //   33: monitorexit
/*     */     //   34: aload_2
/*     */     //   35: athrow
/*     */     // Line number table:
/*     */     //   Java source line #750	-> byte code offset #0
/*     */     //   Java source line #751	-> byte code offset #7
/*     */     //   Java source line #752	-> byte code offset #31
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	36	0	this	Onlines
/*     */     //   5	28	1	Ljava/lang/Object;	Object
/*     */     //   31	4	2	localObject1	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   7	30	31	finally
/*     */     //   31	34	31	finally
/*     */   }
/*     */   
/*     */   public Link find(int linkid)
/*     */   {
/* 756 */     synchronized (this.mutex) {
/* 757 */       for (Link link : this.links.values())
/* 758 */         if (link.getLinkid() == linkid)
/* 759 */           return link;
/* 760 */       return null;
/*     */     }
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public Link find(int peerip, int port)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 20	gnet/link/Onlines:mutex	Ljava/lang/Object;
/*     */     //   4: dup
/*     */     //   5: astore_3
/*     */     //   6: monitorenter
/*     */     //   7: aload_0
/*     */     //   8: getfield 17	gnet/link/Onlines:links	Ljava/util/Map;
/*     */     //   11: iload_1
/*     */     //   12: iload_2
/*     */     //   13: invokestatic 210	xio/Helper:inetSocketAddress	(II)Ljava/net/InetSocketAddress;
/*     */     //   16: invokeinterface 39 2 0
/*     */     //   21: checkcast 176	gnet/link/Link
/*     */     //   24: aload_3
/*     */     //   25: monitorexit
/*     */     //   26: areturn
/*     */     //   27: astore 4
/*     */     //   29: aload_3
/*     */     //   30: monitorexit
/*     */     //   31: aload 4
/*     */     //   33: athrow
/*     */     // Line number table:
/*     */     //   Java source line #765	-> byte code offset #0
/*     */     //   Java source line #766	-> byte code offset #7
/*     */     //   Java source line #767	-> byte code offset #27
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	34	0	this	Onlines
/*     */     //   0	34	1	peerip	int
/*     */     //   0	34	2	port	int
/*     */     //   5	25	3	Ljava/lang/Object;	Object
/*     */     //   27	5	4	localObject1	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   7	26	27	finally
/*     */     //   27	31	27	finally
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public Link find(Xio io)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 20	gnet/link/Onlines:mutex	Ljava/lang/Object;
/*     */     //   4: dup
/*     */     //   5: astore_2
/*     */     //   6: monitorenter
/*     */     //   7: aload_0
/*     */     //   8: getfield 17	gnet/link/Onlines:links	Ljava/util/Map;
/*     */     //   11: aload_1
/*     */     //   12: invokevirtual 126	xio/Xio:getPeer	()Ljava/net/InetSocketAddress;
/*     */     //   15: invokeinterface 39 2 0
/*     */     //   20: checkcast 176	gnet/link/Link
/*     */     //   23: aload_2
/*     */     //   24: monitorexit
/*     */     //   25: areturn
/*     */     //   26: astore_3
/*     */     //   27: aload_2
/*     */     //   28: monitorexit
/*     */     //   29: aload_3
/*     */     //   30: athrow
/*     */     // Line number table:
/*     */     //   Java source line #771	-> byte code offset #0
/*     */     //   Java source line #772	-> byte code offset #7
/*     */     //   Java source line #773	-> byte code offset #26
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	31	0	this	Onlines
/*     */     //   0	31	1	io	Xio
/*     */     //   5	23	2	Ljava/lang/Object;	Object
/*     */     //   26	4	3	localObject1	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   7	25	26	finally
/*     */     //   26	29	26	finally
/*     */   }
/*     */   
/*     */   public Xio get()
/*     */   {
/* 778 */     synchronized (this.mutex) {
/* 779 */       if (this.links.isEmpty())
/* 780 */         return null;
/* 781 */       return ((Link)this.links.values().iterator().next()).getXio();
/*     */     }
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public int size()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 20	gnet/link/Onlines:mutex	Ljava/lang/Object;
/*     */     //   4: dup
/*     */     //   5: astore_1
/*     */     //   6: monitorenter
/*     */     //   7: aload_0
/*     */     //   8: getfield 17	gnet/link/Onlines:links	Ljava/util/Map;
/*     */     //   11: invokeinterface 50 1 0
/*     */     //   16: aload_1
/*     */     //   17: monitorexit
/*     */     //   18: ireturn
/*     */     //   19: astore_2
/*     */     //   20: aload_1
/*     */     //   21: monitorexit
/*     */     //   22: aload_2
/*     */     //   23: athrow
/*     */     // Line number table:
/*     */     //   Java source line #787	-> byte code offset #0
/*     */     //   Java source line #788	-> byte code offset #7
/*     */     //   Java source line #789	-> byte code offset #19
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	24	0	this	Onlines
/*     */     //   5	16	1	Ljava/lang/Object;	Object
/*     */     //   19	4	2	localObject1	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   7	18	19	finally
/*     */     //   19	22	19	finally
/*     */   }
/*     */   
/*     */   protected void addXio(Xio io)
/*     */   {
/* 794 */     synchronized (this.mutex) {
/* 795 */       if (null != this.links.get(io.getPeer())) {
/* 796 */         Trace.error("duplicate connection " + io);
/* 797 */         io.close();
/* 798 */         return;
/*     */       }
/* 800 */       this.links.put(io.getPeer(), new Link(io));
/*     */       
/* 802 */       Trace.warn("[link] Onlines Manager AddXio " + io);
/*     */     }
/*     */     
/* 805 */     for (Integer pvid : this.binds) {
/* 806 */       Bind bind = new Bind();
/* 807 */       bind.pvid = pvid.intValue();
/* 808 */       bind.send(io);
/*     */     }
/*     */     
/*     */ 
/* 812 */     LinkServerControl linkcontrol = new LinkServerControl();
/* 813 */     linkcontrol.ptype = 0;
/* 814 */     linkcontrol.send(io);
/*     */   }
/*     */   
/*     */   protected void removeXio(Xio io, Throwable e)
/*     */   {
/*     */     Link link;
/* 820 */     synchronized (this.mutex) {
/* 821 */       link = (Link)this.links.remove(io.getPeer());
/*     */     }
/* 823 */     if (null != link) {
/* 824 */       Trace.warn("Onlines removeXio " + io, e);
/* 825 */       Collection<Role> roles = link.close();
/* 826 */       Handle volatileTemp = this.handle;
/* 827 */       if (null != volatileTemp) {
/*     */         try {
/* 829 */           volatileTemp.onManagerBroken(roles);
/*     */         } catch (Throwable ex) {
/* 831 */           Trace.error("onManagerBroken " + io, ex);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   protected void close()
/*     */   {
/* 839 */     super.close();
/*     */     Map<InetSocketAddress, Link> tmp;
/* 841 */     synchronized (this.mutex) {
/* 842 */       tmp = this.links;
/* 843 */       this.links = new HashMap();
/*     */     }
/* 845 */     for (Link l : tmp.values()) {
/* 846 */       l.close();
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
/*     */   public void setHandle(Handle handle)
/*     */   {
/* 859 */     this.handle = handle;
/*     */   }
/*     */   
/*     */   void process(AnnounceLinkId p) {
/* 863 */     Link link = find(p.getConnection());
/* 864 */     if (null == link) {
/* 865 */       Trace.error("link not found! linkid=" + p.linkid + p.getConnection());
/* 866 */       return;
/*     */     }
/*     */     
/* 869 */     synchronized (this.mutex) {
/* 870 */       if (null != find(p.linkid)) {
/* 871 */         Trace.error("duplicate linkid found! linkid=" + p.linkid + link.getXio());
/* 872 */         link.getXio().close();
/*     */       } else {
/* 874 */         link.setLinkid(p.linkid);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/* 879 */   void process(AnnounceWebLinkId p) { Link link = find(p.getConnection());
/* 880 */     if (null == link) {
/* 881 */       Trace.error("link not found! linkid=" + p.linkid + p.getConnection());
/* 882 */       return;
/*     */     }
/*     */     
/* 885 */     synchronized (this.mutex) {
/* 886 */       if (null != find(p.linkid)) {
/* 887 */         Trace.error("duplicate linkid found! linkid=" + p.linkid + link.getXio());
/* 888 */         link.getXio().close();
/*     */       } else {
/* 890 */         link.setLinkid(p.linkid);
/* 891 */         link.setIsWebLink(true);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   void process(LinkBroken p) {
/* 897 */     Link link = find(p.getConnection());
/* 898 */     if (null != link) {
/* 899 */       String userid = p.userid.getString("UTF-8");
/* 900 */       int linksid = p.linksid;
/* 901 */       Role role = link.find(Integer.valueOf(p.linksid));
/* 902 */       boolean notLogin = null == role;
/* 903 */       LoginAssistManager.getInstance().remProtectExcuteMap(userid, linksid, link.getLinkid());
/* 904 */       mzm.gsp.online.main.LoginManager.getInstance().leaveQueue(userid, link, linksid, notLogin);
/* 905 */       if (notLogin) {
/* 906 */         Trace.info("skip LinkBroken not owner");
/*     */       }
/*     */       else
/*     */       {
/* 910 */         Handle volatileTemp = this.handle;
/* 911 */         if (null != volatileTemp) {
/*     */           try {
/* 913 */             volatileTemp.onLinkBroken(role, p.reason);
/*     */           } catch (Throwable e) {
/* 915 */             Trace.error("onLinkBroken " + role, e);
/*     */           }
/*     */         }
/* 918 */         role.linkBroken(link, p.linksid);
/*     */       }
/*     */       
/* 921 */       this.sessionRoleLock.writeLock().lock();
/*     */       try {
/* 923 */         Role.LinkSessons linkSessons = (Role.LinkSessons)this.usersSessions.get(userid);
/* 924 */         if (linkSessons != null) {
/* 925 */           linkSessons.remove(link, linksid);
/* 926 */           if (linkSessons.size() == 0) {
/* 927 */             this.usersSessions.remove(userid);
/*     */           }
/*     */           
/*     */         }
/*     */         
/*     */ 
/*     */       }
/*     */       finally
/*     */       {
/* 936 */         this.sessionRoleLock.writeLock().unlock();
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isWebLink(Protocol p)
/*     */   {
/* 960 */     Link link = find(p.getConnection());
/* 961 */     if (link == null)
/* 962 */       return false;
/* 963 */     return link.isWebLink();
/*     */   }
/*     */   
/*     */   public long getOutputAllocation() {
/* 967 */     long allocation = 0L;
/* 968 */     for (Link link : links()) {
/* 969 */       allocation += link.getXio().getOutputBufferAllocation();
/*     */     }
/* 971 */     return allocation;
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {}
/*     */   
/*     */   static abstract interface Handle
/*     */   {
/*     */     public abstract void onManagerBroken(Collection<Role> paramCollection);
/*     */     
/*     */     public abstract void onLinkBroken(Role paramRole, int paramInt);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\link\Onlines.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */