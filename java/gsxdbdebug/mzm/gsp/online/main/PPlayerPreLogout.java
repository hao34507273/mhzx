/*     */ package mzm.gsp.online.main;
/*     */ 
/*     */ import gnet.link.Onlines;
/*     */ import gnet.link.Role;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.SRoleOffline;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.online.event.PlayerEnterProtect;
/*     */ import mzm.gsp.online.event.PlayerOffline;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.LoginStatus;
/*     */ import xbean.OnlineUserInfo;
/*     */ import xbean.Properties;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Loginstatus;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PPlayerPreLogout extends LogicProcedure
/*     */ {
/*     */   long roleid;
/*     */   int reason;
/*     */   
/*     */   public PPlayerPreLogout(long roleid, int reason)
/*     */   {
/*  37 */     this.roleid = 0L;
/*  38 */     this.reason = 0;
/*  39 */     this.roleid = roleid;
/*  40 */     this.reason = reason;
/*     */   }
/*     */   
/*     */   void announceModuleOffline(String userid, long roleid) {
/*  44 */     PlayerOffline po = new PlayerOffline();
/*  45 */     po.setSequential(true);
/*  46 */     if (GameServer.logger().isDebugEnabled()) {
/*  47 */       GameServer.logger().debug(String.format("PPlayerPreLogout@通告module玩家%d下线!", new Object[] { Long.valueOf(roleid) }));
/*     */     }
/*  49 */     TriggerEventsManger.getInstance().triggerEvent(po, Long.valueOf(roleid), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleid)));
/*  50 */     Properties xProperties = xtable.Role2properties.get(Long.valueOf(roleid));
/*  51 */     xProperties.setLastlogofftime(DateTimeUtils.getCurrTimeInMillis());
/*  52 */     long totalCash = QingfuInterface.getTotalCash(userid, true);
/*  53 */     long gangId = GangInterface.getGangId(roleid);
/*  54 */     long playTime = (DateTimeUtils.getCurrTimeInMillis() - RoleInterface.getLastLoginTime(roleid)) / 1000L;
/*  55 */     int fightValue = RoleInterface.getFightValue(roleid);
/*  56 */     int platform = RoleInterface.getPlatform(roleid);
/*  57 */     String channel = RoleInterface.getChannel(roleid);
/*  58 */     String mac = RoleInterface.getMac(roleid);
/*  59 */     int roleLevel = xProperties.getLevel();
/*  60 */     String ipStr = RoleInterface.getIpStr(roleid);
/*  61 */     LogManager.getInstance().addLog("rolelogout", String.format("%d|%s|%s|%s|%d|%d|%d|%d|%d|%d|%d|%s", new Object[] { Integer.valueOf(platform), channel, mac, userid, Long.valueOf(roleid), Integer.valueOf(roleLevel), Long.valueOf(totalCash), Integer.valueOf(0), Long.valueOf(playTime), Integer.valueOf(fightValue), Long.valueOf(gangId), ipStr }));
/*  62 */     LogManager.getInstance().addLog("userlogout", String.format("%d|%s|%d|%s|%s|%s|%s|%d", new Object[] { Integer.valueOf(platform), channel, Integer.valueOf(0), mac, userid, Long.valueOf(playTime), ipStr, Integer.valueOf(this.reason) }));
/*  63 */     logoutTLog();
/*  64 */     OnlineManager.getInstance().removeRole(roleid);
/*  65 */     LoginManager.getInstance().remUserTask(userid);
/*  66 */     Loginstatus.remove(Long.valueOf(roleid));
/*  67 */     OnlineInfo onlineInfo = OnlineManager.getInstance().remOnlineInfo(roleid);
/*  68 */     if (onlineInfo != null) {
/*  69 */       long sessionid = onlineInfo.getOfflineProtectSessionid();
/*  70 */       if (sessionid > 0L) {
/*  71 */         Session.removeSession(sessionid);
/*     */       }
/*     */     }
/*  74 */     GameServer.logger().info("PPlayerRealLogout@玩家离线！roleid=" + roleid);
/*     */   }
/*     */   
/*     */   private void logoutTLog() {
/*  78 */     String userId = RoleInterface.getUserId(this.roleid);
/*  79 */     OnlineUserInfo onlineUserInfo = Onlines.getInstance().findUserInfo(userId);
/*  80 */     if (onlineUserInfo == null) {
/*  81 */       GameServer.logger().info(String.format("[online]PPlayerPreLogout.logoutTLog@user login arg is null|user_id=%s", new Object[] { userId }));
/*  82 */       return;
/*     */     }
/*  84 */     int onlineSec = (int)((DateTimeUtils.getCurrTimeInMillis() - RoleInterface.getLastLoginTime(this.roleid)) / 1000L);
/*  85 */     int level = RoleInterface.getLevel(this.roleid);
/*  86 */     int friendsNum = FriendInterface.getFriendNum(this.roleid);
/*  87 */     String clientVersion = Onlines.getInstance().findEnumFromLoginArg(0, onlineUserInfo);
/*  88 */     String systemSoftWard = Onlines.getInstance().findEnumFromLoginArg(1, onlineUserInfo);
/*  89 */     String systemHardware = Onlines.getInstance().findEnumFromLoginArg(7, onlineUserInfo);
/*  90 */     int telecomOper = 1;
/*  91 */     if (onlineUserInfo != null) {
/*  92 */       telecomOper = onlineUserInfo.getTelecomoper();
/*     */     }
/*  94 */     String netWork = Onlines.getInstance().findEnumFromLoginArg(3, onlineUserInfo);
/*  95 */     String screenWidth = Onlines.getInstance().findEnumFromLoginArg(4, onlineUserInfo);
/*  96 */     int width = 0;
/*  97 */     if ((screenWidth != null) && (!screenWidth.isEmpty())) {
/*     */       try {
/*  99 */         width = Integer.valueOf(screenWidth).intValue();
/*     */       }
/*     */       catch (Exception e) {}
/*     */     }
/* 103 */     String screenHight = Onlines.getInstance().findEnumFromLoginArg(5, onlineUserInfo);
/* 104 */     int hight = 0;
/* 105 */     if ((screenHight != null) && (!screenHight.isEmpty())) {
/*     */       try {
/* 107 */         hight = Integer.valueOf(screenHight).intValue();
/*     */       }
/*     */       catch (Exception e2) {}
/*     */     }
/* 111 */     String densityStr = Onlines.getInstance().findEnumFromLoginArg(6, onlineUserInfo);
/* 112 */     float density = 0.0F;
/* 113 */     if ((densityStr != null) && (!densityStr.isEmpty())) {
/*     */       try {
/* 115 */         density = Float.valueOf(densityStr).floatValue();
/*     */       }
/*     */       catch (Exception e3) {}
/*     */     }
/* 119 */     String channel = Onlines.getInstance().findMSDKChannel(userId);
/* 120 */     String cpuHardward = Onlines.getInstance().findEnumFromLoginArg(7, onlineUserInfo);
/* 121 */     int memory = 0;
/* 122 */     String memeoryStr = Onlines.getInstance().findEnumFromLoginArg(8, onlineUserInfo);
/* 123 */     if ((densityStr != null) && (!densityStr.isEmpty())) {
/*     */       try {
/* 125 */         memory = Integer.valueOf(memeoryStr).intValue();
/*     */       }
/*     */       catch (Exception e4) {}
/*     */     }
/* 129 */     String glRender = Onlines.getInstance().findEnumFromLoginArg(9, onlineUserInfo);
/* 130 */     String glVersion = Onlines.getInstance().findEnumFromLoginArg(10, onlineUserInfo);
/* 131 */     String deviceid = Onlines.getInstance().findEnumFromLoginArg(11, onlineUserInfo);
/* 132 */     int mfValue = RoleInterface.getRoleMFValue(this.roleid);
/* 133 */     int yaoli1 = 0;
/* 134 */     int yaoli2 = 0;
/* 135 */     int yaoli3 = 0;
/* 136 */     for (Integer num : PetInterface.getPetYaoliMap(this.roleid).values()) {
/* 137 */       int yaoli = num.intValue();
/* 138 */       if (yaoli > yaoli1) {
/* 139 */         yaoli3 = yaoli2;
/* 140 */         yaoli2 = yaoli1;
/* 141 */         yaoli1 = yaoli;
/* 142 */       } else if (yaoli > yaoli2) {
/* 143 */         yaoli3 = yaoli2;
/* 144 */         yaoli2 = yaoli;
/* 145 */       } else if (yaoli > yaoli3) {
/* 146 */         yaoli3 = yaoli;
/*     */       }
/*     */     }
/* 149 */     boolean fakePlat = Onlines.getInstance().findFakePlat(userId);
/* 150 */     Object[] objArr = new Object[24];
/* 151 */     objArr[0] = Integer.valueOf(onlineSec);
/* 152 */     objArr[1] = Integer.valueOf(level);
/* 153 */     objArr[2] = Integer.valueOf(friendsNum);
/* 154 */     objArr[3] = clientVersion;
/* 155 */     objArr[4] = systemSoftWard;
/* 156 */     objArr[5] = systemHardware;
/* 157 */     objArr[6] = Integer.valueOf(telecomOper);
/* 158 */     objArr[7] = netWork;
/* 159 */     objArr[8] = Integer.valueOf(width);
/* 160 */     objArr[9] = Integer.valueOf(hight);
/* 161 */     objArr[10] = Float.valueOf(density);
/* 162 */     objArr[11] = channel;
/* 163 */     objArr[12] = cpuHardward;
/* 164 */     objArr[13] = Integer.valueOf(memory);
/* 165 */     objArr[14] = glRender;
/* 166 */     objArr[15] = glVersion;
/* 167 */     objArr[16] = deviceid;
/* 168 */     objArr[17] = Long.valueOf(this.roleid);
/* 169 */     objArr[18] = Integer.valueOf(RoleInterface.getFightValue(this.roleid));
/* 170 */     objArr[19] = Integer.valueOf(mfValue);
/* 171 */     objArr[20] = Integer.valueOf(yaoli1);
/* 172 */     objArr[21] = Integer.valueOf(yaoli2);
/* 173 */     objArr[22] = Integer.valueOf(yaoli3);
/* 174 */     objArr[23] = Integer.valueOf(fakePlat ? 1 : 0);
/* 175 */     TLogManager.getInstance().addLog(this.roleid, "PlayerLogout", String.format("%d|%d|%d|%s|%s|%s|%d|%s|%d|%d|%f|%s|%s|%d|%s|%s|%s|%d|%d|%d|%d|%d|%d|%d", objArr));
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/* 180 */     String userid = RoleInterface.getUserId(this.roleid);
/* 181 */     if (userid == null) {
/* 182 */       return false;
/*     */     }
/* 184 */     lock(Lockeys.get(User.getTable(), userid));
/* 185 */     LoginStatus xLoginStatus = Loginstatus.get(Long.valueOf(this.roleid));
/* 186 */     OnlineInfo onlineInfo = OnlineManager.getInstance().getOnlineInfo(this.roleid);
/* 187 */     switch (this.reason) {
/*     */     case 2: 
/* 189 */       if (xLoginStatus != null)
/* 190 */         xLoginStatus.setStatus(4);
/* 191 */       break;
/*     */     
/*     */ 
/*     */     case 3: 
/* 195 */       if (xLoginStatus != null)
/* 196 */         xLoginStatus.setStatus(4);
/* 197 */       break;
/*     */     
/*     */ 
/*     */     case 5: 
/* 201 */       if (xLoginStatus != null) {
/* 202 */         xLoginStatus.setStatus(4);
/*     */       }
/*     */       break;
/*     */     }
/*     */     
/* 207 */     if (xLoginStatus != null) {
/* 208 */       switch (xLoginStatus.getStatus()) {
/*     */       case 2: 
/* 210 */         xLoginStatus.setStatus(4);
/* 211 */         if (onlineInfo != null) {
/* 212 */           onlineInfo.setOnlineStatus(4);
/*     */         } else {
/* 214 */           GameServer.logger().error(String.format("PPlayerPreLogout.processImp@存在xdb玩家数据状态但是内存确没有该状态|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */         }
/* 216 */         OnlineManager.getInstance().removeRole(this.roleid);
/* 217 */         Loginstatus.remove(Long.valueOf(this.roleid));
/* 218 */         OnlineManager.getInstance().remOnlineInfo(this.roleid);
/* 219 */         break;
/*     */       case 3: 
/* 221 */         if (GameServer.logger().isDebugEnabled()) {
/* 222 */           GameServer.logger().debug("PPlayerPreLogout@角色下线，roleid=" + this.roleid);
/*     */         }
/* 224 */         xLoginStatus.setStatus(8);
/* 225 */         if (onlineInfo == null) {
/* 226 */           onlineInfo = new OnlineInfo(8);
/* 227 */           OnlineManager.getInstance().addOnlineInfo(this.roleid, onlineInfo);
/* 228 */           GameServer.logger().error(String.format("PPlayerPreLogout.processImp@存在xdb玩家数据状态但是内存确没有该状态|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */         }
/* 230 */         onlineInfo.setOnlineStatus(8);
/* 231 */         if (onlineInfo.isUseOfflineItem()) {
/* 232 */           onlineInfo.setOfflineProtectSessionid(new OfflineProtectSession(this.roleid, onlineInfo.getTime()).getSessionId());
/* 233 */           onlineInfo.setUseOfflineItem(false);
/*     */         }
/*     */         else {
/* 236 */           onlineInfo.setOfflineProtectSessionid(new OfflineProtectSession(this.roleid, OnlineManager.getInstance().getOfflineProtectTime()).getSessionId());
/*     */         }
/* 238 */         if (GameServer.logger().isDebugEnabled()) {
/* 239 */           GameServer.logger().debug("PPlayerPreLogout@警告:玩家准备进入保护状态 roleid=" + this.roleid);
/*     */         }
/* 241 */         PlayerEnterProtect pep = new PlayerEnterProtect();
/* 242 */         pep.setSequential(true);
/* 243 */         TriggerEventsManger.getInstance().triggerEvent(pep, Long.valueOf(this.roleid), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/* 244 */         break;
/*     */       case 4: 
/* 246 */         announceModuleOffline(userid, this.roleid);
/* 247 */         break;
/*     */       case 8: 
/* 249 */         GameServer.logger().warn("PPlayerPreLogout@警告:玩家已经下线保护了,roleid=" + this.roleid);
/* 250 */         break;
/*     */       case 10: 
/* 252 */         xLoginStatus.setStatus(8);
/* 253 */         boolean needProtectSession = true;
/* 254 */         if (onlineInfo != null) {
/* 255 */           onlineInfo.setOnlineStatus(8);
/* 256 */           Session session = Session.getSession(onlineInfo.getOfflineProtectSessionid());
/* 257 */           if ((session != null) && (!session.needToStop())) {
/* 258 */             needProtectSession = false;
/*     */           }
/*     */         } else {
/* 261 */           GameServer.logger().error(String.format("PPlayerPreLogout.processImp@存在xdb玩家数据状态但是内存确没有该状态|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */         }
/* 263 */         if (needProtectSession) {
/* 264 */           if (onlineInfo == null) {
/* 265 */             onlineInfo = new OnlineInfo(8);
/* 266 */             OnlineManager.getInstance().addOnlineInfo(this.roleid, onlineInfo);
/*     */           }
/* 268 */           if (onlineInfo.isUseOfflineItem()) {
/* 269 */             onlineInfo.setOfflineProtectSessionid(new OfflineProtectSession(this.roleid, onlineInfo.getTime()).getSessionId());
/* 270 */             onlineInfo.setUseOfflineItem(false);
/*     */           }
/*     */           else
/*     */           {
/* 274 */             onlineInfo.setOfflineProtectSessionid(new OfflineProtectSession(this.roleid, OnlineManager.getInstance().getOfflineProtectTime()).getSessionId());
/*     */           }
/*     */         }
/*     */         
/*     */         break;
/*     */       }
/*     */       
/* 281 */       if ((xLoginStatus.getStatus() == 8) || (this.reason == 3)) {
/* 282 */         LoginAssistManager.getInstance().addProtectUser(userid);
/*     */       }
/* 284 */     } else if ((this.reason != 1) && (this.reason != 5)) {
/* 285 */       GameServer.logger().info("PPlayerPreLogout@INFO：玩家已经下线！！roleid=" + this.roleid);
/*     */     }
/* 287 */     Role linkRole = Onlines.getInstance().remove(Long.valueOf(this.roleid));
/* 288 */     if ((xLoginStatus != null) && (xLoginStatus.getStatus() == 4) && (linkRole != null)) {
/* 289 */       LoginManager.getInstance().addOffLineNum();
/*     */     }
/* 291 */     if ((this.reason != 3) || (linkRole == null)) {
/* 292 */       return true;
/*     */     }
/* 294 */     linkRole.send(new SRoleOffline());
/* 295 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PPlayerPreLogout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */