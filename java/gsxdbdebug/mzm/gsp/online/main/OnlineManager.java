/*     */ package mzm.gsp.online.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import gnet.link.Onlines;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.SBrocastServerOpenTime;
/*     */ import org.apache.log4j.Logger;
/*     */ import xio.Protocol;
/*     */ import xio.Protocol.Coder;
/*     */ 
/*     */ public class OnlineManager
/*     */ {
/*  21 */   private static OnlineManager instance = new OnlineManager();
/*     */   
/*     */   public static OnlineManager getInstance() {
/*  24 */     return instance;
/*     */   }
/*     */   
/*  27 */   private Map<Long, mzm.gsp.Role> rolesInWorld = new OnlineRoleSizeExtendMap();
/*     */   
/*  29 */   private Map<Long, OnlineInfo> roleOnlineInfoMap = new java.util.concurrent.ConcurrentHashMap();
/*     */   
/*     */   private abstract class MyProtocol
/*     */   {
/*     */     static final int TYPE_ROLE_SET = 1;
/*     */     static final int TYPE_ALL = 2;
/*     */     static final int TYPE_TO_DELIVER = 3;
/*     */     final Set<Long> receivers;
/*     */     final int sendType;
/*     */     
/*     */     public MyProtocol(int receivers) {
/*  40 */       this.receivers = receivers;
/*  41 */       this.sendType = sendType;
/*     */     }
/*     */   }
/*     */   
/*     */   private class OctetsProtocol extends OnlineManager.MyProtocol
/*     */   {
/*     */     final int pType;
/*     */     final Octets octetsStream;
/*     */     
/*     */     public OctetsProtocol(Octets pType, Set<Long> octetsStream, int receivers)
/*     */     {
/*  52 */       super(receivers, sendType);
/*  53 */       this.pType = pType;
/*  54 */       this.octetsStream = octetsStream;
/*     */     }
/*     */   }
/*     */   
/*     */   private class NormalProtocol extends OnlineManager.MyProtocol
/*     */   {
/*     */     final Protocol protocol;
/*     */     
/*     */     public NormalProtocol(Set<Long> protocol, int receivers)
/*     */     {
/*  64 */       super(receivers, sendType);
/*  65 */       this.protocol = protocol;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*  70 */   private static final ThreadLocal<LinkedList<MyProtocol>> localProtocols = new ThreadLocal();
/*     */   
/*  72 */   private int offlineProtectTime = 300;
/*     */   
/*  74 */   private int userMaxRoleNum = 3;
/*     */   
/*  76 */   private int maxTaskPerRole = 100;
/*     */   
/*     */   private OnlineManager() {
/*  79 */     gnet.link.LinkBrokenHandle handle = new gnet.link.LinkBrokenHandle();
/*  80 */     Onlines onlinesIns = Onlines.getInstance();
/*  81 */     if (onlinesIns != null) {
/*  82 */       onlinesIns.setHandle(handle);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setOfflineProtectTime(String timeStr) {
/*  87 */     if (timeStr != null)
/*  88 */       this.offlineProtectTime = Integer.valueOf(timeStr).intValue();
/*     */   }
/*     */   
/*     */   public int getOfflineProtectTime() {
/*  92 */     return this.offlineProtectTime;
/*     */   }
/*     */   
/*     */   public void addOnlineInfo(long roleid, OnlineInfo onlineInfo) {
/*  96 */     this.roleOnlineInfoMap.put(Long.valueOf(roleid), onlineInfo);
/*     */   }
/*     */   
/*     */   public OnlineInfo getOnlineInfo(long roleid) {
/* 100 */     return (OnlineInfo)this.roleOnlineInfoMap.get(Long.valueOf(roleid));
/*     */   }
/*     */   
/*     */   public OnlineInfo remOnlineInfo(long roleid) {
/* 104 */     return (OnlineInfo)this.roleOnlineInfoMap.remove(Long.valueOf(roleid));
/*     */   }
/*     */   
/*     */   public int getOnlineStatus(long roleId) {
/* 108 */     OnlineInfo onlineRoleInfo = (OnlineInfo)this.roleOnlineInfoMap.get(Long.valueOf(roleId));
/* 109 */     if (onlineRoleInfo != null)
/* 110 */       return onlineRoleInfo.getOnlineStatus();
/* 111 */     return -1;
/*     */   }
/*     */   
/*     */   public boolean isOnline(long roleId)
/*     */   {
/* 116 */     return getOnlineStatus(roleId) == 3;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public boolean isOnlineOrInProtect(long roleid)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 5	mzm/gsp/online/main/OnlineManager:rolesInWorld	Ljava/util/Map;
/*     */     //   4: dup
/*     */     //   5: astore_3
/*     */     //   6: monitorenter
/*     */     //   7: aload_0
/*     */     //   8: getfield 5	mzm/gsp/online/main/OnlineManager:rolesInWorld	Ljava/util/Map;
/*     */     //   11: lload_1
/*     */     //   12: invokestatic 18	java/lang/Long:valueOf	(J)Ljava/lang/Long;
/*     */     //   15: invokeinterface 25 2 0
/*     */     //   20: aload_3
/*     */     //   21: monitorexit
/*     */     //   22: ireturn
/*     */     //   23: astore 4
/*     */     //   25: aload_3
/*     */     //   26: monitorexit
/*     */     //   27: aload 4
/*     */     //   29: athrow
/*     */     // Line number table:
/*     */     //   Java source line #120	-> byte code offset #0
/*     */     //   Java source line #121	-> byte code offset #7
/*     */     //   Java source line #122	-> byte code offset #23
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	30	0	this	OnlineManager
/*     */     //   0	30	1	roleid	long
/*     */     //   5	21	3	Ljava/lang/Object;	Object
/*     */     //   23	5	4	localObject1	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   7	22	23	finally
/*     */     //   23	27	23	finally
/*     */   }
/*     */   
/*     */   public boolean isOnline(String userid)
/*     */   {
/* 126 */     Long roleid = Onlines.getInstance().getRoleid(userid);
/* 127 */     if (roleid == null) {
/* 128 */       return false;
/*     */     }
/*     */     
/* 131 */     return isOnline(roleid.longValue());
/*     */   }
/*     */   
/*     */   public boolean isOfflineAfterProtect(long roleid) {
/* 135 */     return this.roleOnlineInfoMap.get(Long.valueOf(roleid)) == null;
/*     */   }
/*     */   
/*     */   public boolean addRole(mzm.gsp.Role role) {
/* 139 */     if (role == null) {
/* 140 */       return false;
/*     */     }
/* 142 */     synchronized (this.rolesInWorld) {
/* 143 */       return this.rolesInWorld.put(Long.valueOf(role.getRoleid()), role) == null;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean removeRole(long roleId) {
/* 148 */     synchronized (this.rolesInWorld)
/*     */     {
/* 150 */       return this.rolesInWorld.remove(Long.valueOf(roleId)) != null;
/*     */     }
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public mzm.gsp.Role getRoleById(long roleId)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 5	mzm/gsp/online/main/OnlineManager:rolesInWorld	Ljava/util/Map;
/*     */     //   4: dup
/*     */     //   5: astore_3
/*     */     //   6: monitorenter
/*     */     //   7: aload_0
/*     */     //   8: getfield 5	mzm/gsp/online/main/OnlineManager:rolesInWorld	Ljava/util/Map;
/*     */     //   11: lload_1
/*     */     //   12: invokestatic 18	java/lang/Long:valueOf	(J)Ljava/lang/Long;
/*     */     //   15: invokeinterface 20 2 0
/*     */     //   20: checkcast 30	mzm/gsp/Role
/*     */     //   23: aload_3
/*     */     //   24: monitorexit
/*     */     //   25: areturn
/*     */     //   26: astore 4
/*     */     //   28: aload_3
/*     */     //   29: monitorexit
/*     */     //   30: aload 4
/*     */     //   32: athrow
/*     */     // Line number table:
/*     */     //   Java source line #155	-> byte code offset #0
/*     */     //   Java source line #156	-> byte code offset #7
/*     */     //   Java source line #157	-> byte code offset #26
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	33	0	this	OnlineManager
/*     */     //   0	33	1	roleId	long
/*     */     //   5	24	3	Ljava/lang/Object;	Object
/*     */     //   26	5	4	localObject1	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   7	25	26	finally
/*     */     //   26	30	26	finally
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public LinkedList<Long> getAllRolesInWorld()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 5	mzm/gsp/online/main/OnlineManager:rolesInWorld	Ljava/util/Map;
/*     */     //   4: dup
/*     */     //   5: astore_1
/*     */     //   6: monitorenter
/*     */     //   7: new 31	java/util/LinkedList
/*     */     //   10: dup
/*     */     //   11: aload_0
/*     */     //   12: getfield 5	mzm/gsp/online/main/OnlineManager:rolesInWorld	Ljava/util/Map;
/*     */     //   15: invokeinterface 32 1 0
/*     */     //   20: invokespecial 33	java/util/LinkedList:<init>	(Ljava/util/Collection;)V
/*     */     //   23: aload_1
/*     */     //   24: monitorexit
/*     */     //   25: areturn
/*     */     //   26: astore_2
/*     */     //   27: aload_1
/*     */     //   28: monitorexit
/*     */     //   29: aload_2
/*     */     //   30: athrow
/*     */     // Line number table:
/*     */     //   Java source line #161	-> byte code offset #0
/*     */     //   Java source line #162	-> byte code offset #7
/*     */     //   Java source line #163	-> byte code offset #26
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	31	0	this	OnlineManager
/*     */     //   5	23	1	Ljava/lang/Object;	Object
/*     */     //   26	4	2	localObject1	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   7	25	26	finally
/*     */     //   26	29	26	finally
/*     */   }
/*     */   
/*     */   public Set<Long> getOnlineRoleidSet(int from, int to)
/*     */   {
/* 173 */     Set<Long> roleids = new HashSet();
/* 174 */     getOnlineRoleids(roleids, from, to);
/* 175 */     return roleids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Long> getOnlineRoleidList(int from, int to)
/*     */   {
/* 186 */     List<Long> roleids = new ArrayList();
/* 187 */     getOnlineRoleids(roleids, from, to);
/* 188 */     return roleids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void getOnlineRoleids(Collection<Long> roleids, int from, int to)
/*     */   {
/* 199 */     OnlineRoleLevelManage.getInstance().getRoles(from, to, roleids);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void sendToOnlineRoles(int levelfrom, int levelto, Protocol protocol)
/*     */   {
/* 210 */     OnlineRoleLevelManage.getInstance().sendOnlineRoles(levelfrom, levelto, protocol);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void sendToOnlineRoles(int levelfrom, int levelto, int ptype, Octets octets)
/*     */   {
/* 221 */     OnlineRoleLevelManage.getInstance().sendOnlineRoles(levelfrom, levelto, ptype, octets);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Long> getOnlineHigherRoleidList(int level)
/*     */   {
/* 231 */     List<Long> roleids = new ArrayList();
/* 232 */     getOnlineHigherRoleids(roleids, level);
/* 233 */     return roleids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Long> getOnlineHigherRoleidSet(int level)
/*     */   {
/* 243 */     Set<Long> roleids = new HashSet();
/* 244 */     getOnlineHigherRoleids(roleids, level);
/* 245 */     return roleids;
/*     */   }
/*     */   
/*     */   private void getOnlineHigherRoleids(Collection<Long> roleids, int level) {
/* 249 */     OnlineRoleLevelManage.getInstance().getRoleHigherThan(level, roleids);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Long> getOnlineLowererRoleidList(int level)
/*     */   {
/* 259 */     List<Long> roleids = new ArrayList();
/* 260 */     getOnlineLowerRoleids(roleids, level);
/* 261 */     return roleids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Long> getOnlineLowerRoleidSet(int level)
/*     */   {
/* 271 */     Set<Long> roleids = new HashSet();
/* 272 */     getOnlineLowerRoleids(roleids, level);
/* 273 */     return roleids;
/*     */   }
/*     */   
/*     */   private void getOnlineLowerRoleids(Collection<Long> roleids, int level) {
/* 277 */     OnlineRoleLevelManage.getInstance().getRoleLowerThan(level, roleids);
/*     */   }
/*     */   
/*     */   public void OnClientLinkBroken(long roleid, int reason) {
/* 281 */     GameServer.logger().info("[online]客户端连接断开 roleid： " + roleid);
/*     */     
/*     */ 
/*     */ 
/* 285 */     new PPlayerPreLogout(roleid, reason).call();
/*     */   }
/*     */   
/*     */   public void OnGsLinkBroken(Collection<gnet.link.Role> roles) {
/* 289 */     GameServer.logger().error("[online]gs与link断开，此link上用户数目 " + roles.size());
/*     */     
/* 291 */     xdb.Procedure.execute(new PDisconnectLink(roles));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int sendBeforeTransaction()
/*     */   {
/* 300 */     LinkedList<MyProtocol> currProtocols = (LinkedList)localProtocols.get();
/* 301 */     if (currProtocols == null) {
/* 302 */       localProtocols.set(currProtocols = new LinkedList());
/*     */     }
/* 304 */     return currProtocols.size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean sendAfterTransaction(boolean bSuccess, int savePoint, int nestCount)
/*     */   {
/* 316 */     LinkedList<MyProtocol> currProtocols = (LinkedList)localProtocols.get();
/* 317 */     if (currProtocols != null) {
/* 318 */       if (nestCount == 0) {
/*     */         try {
/* 320 */           if (bSuccess) {
/* 321 */             for (MyProtocol myProtocol : currProtocols) {
/* 322 */               if (myProtocol.sendType == 2) {
/* 323 */                 if ((myProtocol instanceof OctetsProtocol)) {
/* 324 */                   OctetsProtocol octetsProtocol = (OctetsProtocol)myProtocol;
/* 325 */                   sendAllAtOnce(octetsProtocol.pType, octetsProtocol.octetsStream, 0);
/* 326 */                 } else if ((myProtocol instanceof NormalProtocol)) {
/* 327 */                   NormalProtocol normalProtocol = (NormalProtocol)myProtocol;
/* 328 */                   sendAllAtOnce(normalProtocol.protocol);
/*     */                 } else {
/* 330 */                   GameServer.logger().error(String.format("[Online]OnlineManager.sendAfterTransaction@没有发送的协议,是新实现的协议类|myprotocal=%s", new Object[] { myProtocol.getClass().getName() }));
/*     */ 
/*     */ 
/*     */                 }
/*     */                 
/*     */ 
/*     */ 
/*     */               }
/* 338 */               else if (myProtocol.sendType == 1) {
/* 339 */                 if ((myProtocol instanceof OctetsProtocol)) {
/* 340 */                   OctetsProtocol octetsProtocol = (OctetsProtocol)myProtocol;
/* 341 */                   sendMultiAtOnce(octetsProtocol.pType, octetsProtocol.octetsStream, octetsProtocol.receivers);
/*     */                 }
/* 343 */                 else if ((myProtocol instanceof NormalProtocol)) {
/* 344 */                   NormalProtocol normalProtocol = (NormalProtocol)myProtocol;
/* 345 */                   sendMultiAtOnce(normalProtocol.protocol, normalProtocol.receivers);
/*     */                 } else {
/* 347 */                   GameServer.logger().error(String.format("[Online]OnlineManager.sendAfterTransaction@没有发送的协议,是新实现的协议类|myprotocal=%s", new Object[] { myProtocol.getClass().getName() }));
/*     */ 
/*     */ 
/*     */                 }
/*     */                 
/*     */ 
/*     */ 
/*     */               }
/* 355 */               else if (myProtocol.sendType == 3) {
/* 356 */                 if ((myProtocol instanceof OctetsProtocol))
/*     */                 {
/* 358 */                   GameServer.logger().error(String.format("[Online]OnlineManager.sendAfterTransaction@没有发送的协议,deliver不支持直接发送二进制数据|myprotocal=%s", new Object[] { myProtocol.getClass().getName() }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 }
/* 365 */                 else if ((myProtocol instanceof NormalProtocol)) {
/* 366 */                   NormalProtocol normalProtocol = (NormalProtocol)myProtocol;
/* 367 */                   send2Deliver(normalProtocol.protocol, false);
/*     */                 } else {
/* 369 */                   GameServer.logger().error(String.format("[Online]OnlineManager.sendAfterTransaction@没有发送的协议,是新实现的协议类|myprotocal=%s", new Object[] { myProtocol.getClass().getName() }));
/*     */ 
/*     */                 }
/*     */                 
/*     */ 
/*     */ 
/*     */               }
/*     */               else
/*     */               {
/* 378 */                 GameServer.logger().error(String.format("[Online]OnlineManager.sendAfterTransaction@没有发送的协议,myprotocol中sendType出错|sendtype=%d", new Object[] { Integer.valueOf(myProtocol.sendType) }));
/*     */               }
/*     */               
/*     */             }
/*     */             
/*     */           }
/*     */           
/*     */ 
/*     */         }
/*     */         finally
/*     */         {
/* 389 */           localProtocols.set(null);
/* 390 */           currProtocols.clear();
/*     */         }
/*     */         
/* 393 */       } else if ((!bSuccess) && (savePoint >= 0)) {
/* 394 */         for (int i = currProtocols.size() - 1; i >= savePoint; i--)
/* 395 */           currProtocols.remove(i);
/*     */       }
/*     */     }
/* 398 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean send(long roleid, Protocol protocol)
/*     */   {
/* 410 */     gnet.link.Role role = Onlines.getInstance().find(Long.valueOf(roleid));
/*     */     
/* 412 */     return (role != null) && (send(role, protocol, true));
/*     */   }
/*     */   
/*     */   public boolean send(String userid, Protocol protocol) {
/* 416 */     gnet.link.Role role = Onlines.getInstance().find(userid);
/* 417 */     return send(role, protocol);
/*     */   }
/*     */   
/*     */   public boolean send(gnet.link.Role role, Protocol protocol) {
/* 421 */     return (role != null) && (send(role, protocol, true));
/*     */   }
/*     */   
/*     */   public boolean send(long roleid, int pType, Octets pOctets) {
/* 425 */     gnet.link.Role role = Onlines.getInstance().find(Long.valueOf(roleid));
/* 426 */     return (role != null) && (send(role, pType, pOctets));
/*     */   }
/*     */   
/*     */   public boolean send(String userid, int pType, Octets pOctets) {
/* 430 */     gnet.link.Role role = Onlines.getInstance().find(userid);
/* 431 */     return (role != null) && (send(role, pType, pOctets));
/*     */   }
/*     */   
/*     */   public boolean send(gnet.link.Role role, int pType, Octets pOctets)
/*     */   {
/* 436 */     int onlineStatus = getInstance().getOnlineStatus(role.getRoleid());
/*     */     
/* 438 */     if (onlineStatus != 3) {
/* 439 */       GameServer.logger().debug("send@玩家不在线或没有进入世界，不发送数据 roleid=" + role.getRoleid() + ",pType=" + pType);
/* 440 */       return false;
/*     */     }
/*     */     
/* 443 */     LinkedList<MyProtocol> currProtocols = (LinkedList)localProtocols.get();
/* 444 */     if (currProtocols != null) {
/* 445 */       Set<Long> roleidSet = new HashSet(1);
/* 446 */       roleidSet.add(Long.valueOf(role.getRoleid()));
/* 447 */       currProtocols.add(new OctetsProtocol(pType, pOctets, roleidSet, 1));
/* 448 */       return true;
/*     */     }
/*     */     
/* 451 */     boolean ret = role.send(pType, pOctets);
/* 452 */     if (GameServer.logger().isDebugEnabled()) {
/* 453 */       StringBuilder sb = new StringBuilder();
/* 454 */       sb.append("send ");
/* 455 */       if (ret) {
/* 456 */         sb.append("成功 ");
/*     */       } else {
/* 458 */         sb.append("失败 ");
/*     */       }
/* 460 */       String name = getProtocolsName(pType);
/* 461 */       sb.append("[名字：").append(name).append(", 编号：").append(pType);
/* 462 */       sb.append("] 到roleid: ").append(role.getRoleid());
/*     */       
/* 464 */       GameServer.logger().debug(sb.toString());
/*     */     }
/*     */     
/* 467 */     return ret;
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
/*     */   public boolean sendAtOnce(long roleid, Protocol protocol)
/*     */   {
/* 480 */     gnet.link.Role role = Onlines.getInstance().find(Long.valueOf(roleid));
/*     */     
/* 482 */     return (role != null) && (send(role, protocol, false));
/*     */   }
/*     */   
/*     */   public boolean sendAtOnce(String userid, Protocol protocol) {
/* 486 */     gnet.link.Role role = Onlines.getInstance().find(userid);
/* 487 */     return (role != null) && (send(role, protocol, false));
/*     */   }
/*     */   
/*     */   public boolean sendAtOnce(long roleid, int pType, Octets pOctets) {
/* 491 */     if (!isOnline(roleid)) {
/* 492 */       return false;
/*     */     }
/*     */     
/* 495 */     if (GameServer.logger().isDebugEnabled()) {
/* 496 */       String name = getProtocolsName(pType);
/* 497 */       StringBuilder sb = new StringBuilder();
/* 498 */       sb.append("sendMuti@多播datacore [名字: " + name + ",编号：" + pType + "] 发送到： \n");
/* 499 */       sb.append("                                          roleid : ");
/* 500 */       sb.append(roleid + ", ");
/* 501 */       GameServer.logger().debug(sb.toString());
/*     */     }
/* 503 */     return Onlines.getInstance().send(roleid, pType, pOctets);
/*     */   }
/*     */   
/*     */   public boolean sendAtOnce(gnet.link.Role role, Protocol protocol) {
/* 507 */     return (role != null) && (send(role, protocol, false));
/*     */   }
/*     */   
/*     */   public boolean sendAtOnce(gnet.link.Role role, int pType, Octets pOctets) {
/* 511 */     return (role != null) && (Onlines.getInstance().send(role, pType, pOctets));
/*     */   }
/*     */   
/*     */   public boolean sendAtOnce(String userid, int pType, Octets pOctets) {
/* 515 */     gnet.link.Role role = Onlines.getInstance().find(userid);
/* 516 */     return (role != null) && (Onlines.getInstance().send(role, pType, pOctets));
/*     */   }
/*     */   
/*     */   private boolean send(gnet.link.Role role, Protocol protocol, boolean bDelay) {
/* 520 */     int onlineStatus = getInstance().getOnlineStatus(role.getRoleid());
/*     */     
/* 522 */     if (onlineStatus != 3) {
/* 523 */       GameServer.logger().debug("send@玩家不在线或没有进入世界，不发送数据 roleid=" + role.getRoleid());
/* 524 */       return false;
/*     */     }
/*     */     
/* 527 */     if (bDelay) {
/* 528 */       LinkedList<MyProtocol> currProtocols = (LinkedList)localProtocols.get();
/* 529 */       if (currProtocols != null) {
/* 530 */         Set<Long> roleidSet = new HashSet(1);
/* 531 */         roleidSet.add(Long.valueOf(role.getRoleid()));
/* 532 */         currProtocols.add(new NormalProtocol(protocol, roleidSet, 1));
/*     */         
/* 534 */         return true;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 544 */     boolean ret = role.send(protocol);
/* 545 */     if (GameServer.logger().isDebugEnabled()) {
/* 546 */       StringBuilder sb = new StringBuilder();
/* 547 */       sb.append("send ");
/* 548 */       if (ret) {
/* 549 */         sb.append("成功 ");
/*     */       } else {
/* 551 */         sb.append("失败 ");
/*     */       }
/* 553 */       sb.append("[名字：").append(protocol.getClass().getName()).append(", 编号：").append(protocol.getType());
/* 554 */       sb.append("] 到roleid: ").append(role.getRoleid()).append(protocol);
/*     */       
/* 556 */       GameServer.logger().debug(sb.toString());
/*     */     }
/*     */     
/* 559 */     return ret;
/*     */   }
/*     */   
/*     */   public boolean sendMulti(Protocol protocol, Collection<Long> receiverSet) {
/* 563 */     Set<Long> onlineSet = new HashSet(receiverSet.size());
/* 564 */     for (Iterator i$ = receiverSet.iterator(); i$.hasNext();) { long receiverid = ((Long)i$.next()).longValue();
/* 565 */       if (isOnline(receiverid))
/* 566 */         onlineSet.add(Long.valueOf(receiverid));
/*     */     }
/* 568 */     if (onlineSet.size() == 0) {
/* 569 */       return true;
/*     */     }
/* 571 */     LinkedList<MyProtocol> currProtocols = (LinkedList)localProtocols.get();
/* 572 */     if (currProtocols != null) {
/* 573 */       currProtocols.add(new NormalProtocol(protocol, onlineSet, 1));
/* 574 */       return true;
/*     */     }
/*     */     
/* 577 */     if (GameServer.logger().isDebugEnabled()) {
/* 578 */       StringBuilder sb = new StringBuilder();
/* 579 */       sb.append("sendMuti@多播datacore [名字：" + protocol.getClass().getName() + ", 编号：" + protocol.getType() + "] 发送到： \n");
/*     */       
/* 581 */       sb.append("                                               roles : ");
/*     */       
/* 583 */       sb.append(onlineSet);
/* 584 */       sb.append(", pro=").append(protocol);
/*     */       
/* 586 */       GameServer.logger().debug(sb.toString());
/*     */     }
/*     */     
/* 589 */     return Onlines.getInstance().send(onlineSet, protocol);
/*     */   }
/*     */   
/*     */   public boolean sendMultiToUsers(Protocol protocol, Collection<String> receiverUseridSet) {
/* 593 */     Set<Long> onlineSet = new HashSet();
/* 594 */     for (String userid : receiverUseridSet) {
/* 595 */       long roleid = Onlines.getInstance().getRoleid(userid).longValue();
/* 596 */       onlineSet.add(Long.valueOf(roleid));
/*     */     }
/* 598 */     return sendMulti(protocol, onlineSet);
/*     */   }
/*     */   
/*     */   public boolean sendMultiAtOnce(Protocol protocol, Collection<Long> receiverSet) {
/* 602 */     Set<Long> onlineSet = new HashSet(receiverSet.size());
/* 603 */     for (Iterator i$ = receiverSet.iterator(); i$.hasNext();) { long receiverid = ((Long)i$.next()).longValue();
/* 604 */       if (isOnline(receiverid))
/* 605 */         onlineSet.add(Long.valueOf(receiverid));
/*     */     }
/* 607 */     if (onlineSet.size() == 0) {
/* 608 */       return true;
/*     */     }
/* 610 */     if (GameServer.logger().isDebugEnabled()) {
/* 611 */       StringBuilder sb = new StringBuilder();
/* 612 */       sb.append("sendMuti@多播datacore [名字：" + protocol.getClass().getName() + ",编号：" + protocol.getType() + "] 发送到： \n");
/*     */       
/* 614 */       sb.append("roleid : ");
/*     */       
/* 616 */       for (Iterator i$ = onlineSet.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 617 */         sb.append(roleid + ", ");
/*     */       }
/* 619 */       sb.append("pro=").append(protocol);
/* 620 */       GameServer.logger().debug(sb.toString());
/*     */     }
/*     */     
/* 623 */     return Onlines.getInstance().send(onlineSet, protocol);
/*     */   }
/*     */   
/*     */   public boolean sendMultiAtOnceToUsers(Protocol protocol, Collection<String> receiverSet) {
/* 627 */     Set<Long> onlineSet = new HashSet();
/* 628 */     for (String userid : receiverSet) {
/* 629 */       long roleid = Onlines.getInstance().getRoleid(userid).longValue();
/* 630 */       onlineSet.add(Long.valueOf(roleid));
/*     */     }
/* 632 */     return sendMultiAtOnce(protocol, onlineSet);
/*     */   }
/*     */   
/*     */   public boolean sendMulti(int pType, Octets pOctets, Collection<Long> receiverSet)
/*     */   {
/* 637 */     Set<Long> onlineSet = new HashSet(receiverSet.size());
/* 638 */     for (Iterator i$ = receiverSet.iterator(); i$.hasNext();) { long receiverid = ((Long)i$.next()).longValue();
/* 639 */       if (isOnline(receiverid))
/* 640 */         onlineSet.add(Long.valueOf(receiverid));
/*     */     }
/* 642 */     if (onlineSet.size() == 0) {
/* 643 */       return true;
/*     */     }
/* 645 */     LinkedList<MyProtocol> currProtocols = (LinkedList)localProtocols.get();
/* 646 */     if (currProtocols != null) {
/* 647 */       currProtocols.add(new OctetsProtocol(pType, pOctets, onlineSet, 1));
/* 648 */       return true;
/*     */     }
/*     */     
/* 651 */     if (GameServer.logger().isDebugEnabled()) {
/* 652 */       String name = getProtocolsName(pType);
/* 653 */       StringBuilder sb = new StringBuilder();
/* 654 */       sb.append("sendMuti@多播datacore [名字：" + name + ", 编号：" + pType + "] 发送到： \n");
/* 655 */       sb.append(" roles : ");
/*     */       
/* 657 */       sb.append(onlineSet);
/*     */       
/* 659 */       GameServer.logger().debug(sb.toString());
/*     */     }
/*     */     
/* 662 */     return Onlines.getInstance().send(onlineSet, pType, pOctets);
/*     */   }
/*     */   
/*     */   public boolean sendMultiToUsers(int pType, Octets pOctets, Collection<String> receiverUseridSet)
/*     */   {
/* 667 */     Set<Long> onlineSet = new HashSet();
/* 668 */     for (String userid : receiverUseridSet) {
/* 669 */       long roleid = Onlines.getInstance().getRoleid(userid).longValue();
/* 670 */       onlineSet.add(Long.valueOf(roleid));
/*     */     }
/* 672 */     return sendMulti(pType, pOctets, onlineSet);
/*     */   }
/*     */   
/*     */   public boolean sendMultiAtOnce(int pType, Octets pOctets, Collection<Long> receiverSet) {
/* 676 */     Set<Long> onlineSet = new HashSet(receiverSet.size());
/* 677 */     for (Iterator i$ = receiverSet.iterator(); i$.hasNext();) { long receiverid = ((Long)i$.next()).longValue();
/* 678 */       if (isOnline(receiverid))
/* 679 */         onlineSet.add(Long.valueOf(receiverid));
/*     */     }
/* 681 */     if (onlineSet.size() == 0) {
/* 682 */       return true;
/*     */     }
/* 684 */     if (GameServer.logger().isDebugEnabled()) {
/* 685 */       String name = getProtocolsName(pType);
/* 686 */       StringBuilder sb = new StringBuilder();
/* 687 */       sb.append("sendMuti@多播datacore [名字：" + name + ",编号：" + pType + "] 发送到： \n");
/* 688 */       sb.append("                                          roleid : ");
/*     */       
/* 690 */       for (Iterator i$ = onlineSet.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 691 */         sb.append(roleid + ", ");
/*     */       }
/* 693 */       GameServer.logger().debug(sb.toString());
/*     */     }
/*     */     
/* 696 */     return Onlines.getInstance().send(onlineSet, pType, pOctets);
/*     */   }
/*     */   
/*     */   public boolean sendMultiAtOnceToUsers(int pType, Octets pOctets, Collection<String> receiverSet) {
/* 700 */     Set<Long> onlineSet = new HashSet();
/* 701 */     for (String userid : receiverSet) {
/* 702 */       long roleid = Onlines.getInstance().getRoleid(userid).longValue();
/* 703 */       onlineSet.add(Long.valueOf(roleid));
/*     */     }
/* 705 */     return sendMultiAtOnce(pType, pOctets, onlineSet);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean sendAllAtOnce(Protocol protocol, int timems)
/*     */   {
/* 716 */     if (GameServer.logger().isDebugEnabled()) {
/* 717 */       GameServer.logger().debug("send@发送datacore [名字：" + protocol.getClass().getName() + ", 编号：" + protocol.getType() + "] 到所有人,pro=" + protocol.toString());
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 722 */     Onlines.getInstance().broadcast(protocol, timems);
/*     */     
/* 724 */     return true;
/*     */   }
/*     */   
/*     */   public boolean sendAllAtOnce(Protocol protocol) {
/* 728 */     return sendAllAtOnce(protocol, 0);
/*     */   }
/*     */   
/*     */   private boolean sendAllAtOnce(int pType, Octets octetsStream, int timems)
/*     */   {
/* 733 */     if (GameServer.logger().isDebugEnabled()) {
/* 734 */       String name = getProtocolsName(pType);
/* 735 */       GameServer.logger().debug("send@发送datacore [名字：" + name + ", 编号：" + pType + "] 到所有人");
/*     */     }
/*     */     
/* 738 */     Onlines.getInstance().broadcast(pType, octetsStream, timems);
/*     */     
/* 740 */     return true;
/*     */   }
/*     */   
/*     */   public boolean sendAll(Protocol protocol) {
/* 744 */     return sendAll(protocol, 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean sendAll(Protocol protocol, int timems)
/*     */   {
/* 755 */     LinkedList<MyProtocol> currProtocols = (LinkedList)localProtocols.get();
/* 756 */     if (currProtocols != null) {
/* 757 */       currProtocols.add(new NormalProtocol(protocol, new HashSet(), 2));
/* 758 */       return true;
/*     */     }
/*     */     
/* 761 */     if (GameServer.logger().isDebugEnabled()) {
/* 762 */       GameServer.logger().debug("send@发送datacore [名字：" + protocol.getClass().getName() + ", 编号：" + protocol.getType() + "] 到所有人");
/*     */     }
/*     */     
/* 765 */     Onlines.getInstance().broadcast(protocol, timems);
/*     */     
/* 767 */     return true;
/*     */   }
/*     */   
/*     */   private String getProtocolsName(int pType) {
/* 771 */     String name = "UNKNOW";
/* 772 */     xio.Manager.Coder coder = Onlines.getInstance().getCoder();
/* 773 */     if ((coder instanceof Protocol.Coder)) {
/* 774 */       Protocol.Coder coder2 = (Protocol.Coder)coder;
/* 775 */       name = coder2.getStub(pType).getCls().getName();
/*     */     }
/* 777 */     return name;
/*     */   }
/*     */   
/*     */   public boolean send2Deliver(Protocol protocol) {
/* 781 */     return send2Deliver(protocol, true);
/*     */   }
/*     */   
/*     */   private boolean send2Deliver(Protocol protocol, boolean bDelay) {
/* 785 */     if (bDelay) {
/* 786 */       LinkedList<MyProtocol> currProtocols = (LinkedList)localProtocols.get();
/* 787 */       if (currProtocols != null) {
/* 788 */         currProtocols.add(new NormalProtocol(protocol, null, 3));
/* 789 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 793 */     if (GameServer.logger().isDebugEnabled()) {
/* 794 */       GameServer.logger().debug("send@发送datacore [名字：" + protocol.getClass().getName() + ", 编号：" + protocol.getType() + "] 到deliver");
/*     */     }
/*     */     
/*     */ 
/* 798 */     return gnet.GDeliveryManager.getInstance().send(protocol);
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public int getOnlineRoleNumber()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 5	mzm/gsp/online/main/OnlineManager:rolesInWorld	Ljava/util/Map;
/*     */     //   4: dup
/*     */     //   5: astore_1
/*     */     //   6: monitorenter
/*     */     //   7: aload_0
/*     */     //   8: getfield 5	mzm/gsp/online/main/OnlineManager:rolesInWorld	Ljava/util/Map;
/*     */     //   11: invokeinterface 162 1 0
/*     */     //   16: aload_1
/*     */     //   17: monitorexit
/*     */     //   18: ireturn
/*     */     //   19: astore_2
/*     */     //   20: aload_1
/*     */     //   21: monitorexit
/*     */     //   22: aload_2
/*     */     //   23: athrow
/*     */     // Line number table:
/*     */     //   Java source line #802	-> byte code offset #0
/*     */     //   Java source line #803	-> byte code offset #7
/*     */     //   Java source line #804	-> byte code offset #19
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	24	0	this	OnlineManager
/*     */     //   5	16	1	Ljava/lang/Object;	Object
/*     */     //   19	4	2	localObject1	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   7	18	19	finally
/*     */     //   19	22	19	finally
/*     */   }
/*     */   
/*     */   public int getUserMaxRoleNum()
/*     */   {
/* 808 */     return this.userMaxRoleNum;
/*     */   }
/*     */   
/*     */   public int getMaxTaskPerRole() {
/* 812 */     return this.maxTaskPerRole;
/*     */   }
/*     */   
/*     */   public int getPlatform(String userId) {
/* 816 */     return Onlines.getInstance().findPlatid(userId);
/*     */   }
/*     */   
/*     */   public String getChannel(String userId) {
/* 820 */     return Onlines.getInstance().findChannel(userId);
/*     */   }
/*     */   
/*     */   public String getDeviceIdentifier(String userId) {
/* 824 */     return Onlines.getInstance().findDeviceIdentifier(userId);
/*     */   }
/*     */   
/*     */   public String getMac(String userId) {
/* 828 */     return Onlines.getInstance().findMac(userId);
/*     */   }
/*     */   
/*     */   public void setUserMaxRoleNum(String userMaxRoleNum) {
/* 832 */     this.userMaxRoleNum = Integer.parseInt(userMaxRoleNum);
/*     */   }
/*     */   
/*     */   public void setMaxTaskPerRole(int maxTaskPerRole) {
/* 836 */     this.maxTaskPerRole = maxTaskPerRole;
/* 837 */     GameServer.logger().info("now param maxTaskPerRole=" + this.maxTaskPerRole);
/*     */   }
/*     */   
/*     */   public int getIp(String userId) {
/* 841 */     return Onlines.getInstance().findip(userId);
/*     */   }
/*     */   
/*     */   public void onlineRoleInfoMsg() {
/* 845 */     StringBuilder stringBuilder = new StringBuilder();
/* 846 */     stringBuilder.append("now online role info|");
/* 847 */     synchronized (this.rolesInWorld) {
/* 848 */       for (mzm.gsp.Role role : this.rolesInWorld.values()) {
/* 849 */         stringBuilder.append(role.getUserId()).append(",").append(role.getRoleid()).append("|");
/*     */       }
/*     */     }
/* 852 */     GameServer.logger().info(stringBuilder.toString());
/*     */   }
/*     */   
/*     */   public void brocastAllServerOpenTime(long millTime) {
/* 856 */     SBrocastServerOpenTime brocastServerOpenTime = new SBrocastServerOpenTime();
/* 857 */     brocastServerOpenTime.serveropentime = (millTime / 1000L);
/* 858 */     sendAll(brocastServerOpenTime);
/*     */   }
/*     */   
/*     */   public boolean forceReconnect(long roleid) {
/* 862 */     return Onlines.getInstance().kick(Long.valueOf(roleid), 2059);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\OnlineManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */