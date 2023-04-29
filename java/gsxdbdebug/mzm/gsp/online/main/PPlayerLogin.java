/*     */ package mzm.gsp.online.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import gnet.link.Dispatch;
/*     */ import gnet.link.Onlines;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.SLoginRole;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogManager;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import mzm.gsp.util.TaskOneByOne;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.DeleteState;
/*     */ import xbean.ForbidInfo;
/*     */ import xbean.LoginStatus;
/*     */ import xbean.OnlineUserInfo;
/*     */ import xbean.Properties;
/*     */ import xio.Protocol;
/*     */ import xtable.Loginstatus;
/*     */ import xtable.Roleforbid;
/*     */ import xtable.Userforbid;
/*     */ 
/*     */ public class PPlayerLogin extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final Protocol protocol;
/*     */   
/*     */   public PPlayerLogin(long roleId, Protocol protocol)
/*     */   {
/*  39 */     this.protocol = protocol;
/*  40 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   private boolean sendPlayerLoginRe(int result) {
/*  44 */     SLoginRole proSLoginRole = new SLoginRole();
/*  45 */     proSLoginRole.result = result;
/*  46 */     proSLoginRole.roleid = this.roleId;
/*  47 */     return Onlines.getInstance().send(Long.valueOf(this.roleId), proSLoginRole);
/*     */   }
/*     */   
/*     */   private boolean sendPlayerLoginReByProtocol(int result) {
/*  51 */     SLoginRole proSLoginRole = new SLoginRole();
/*  52 */     proSLoginRole.result = result;
/*  53 */     proSLoginRole.roleid = this.roleId;
/*  54 */     return Onlines.getInstance().sendResponse(this.protocol, proSLoginRole);
/*     */   }
/*     */   
/*     */   private boolean sendPlayerLoginReByProtocol(int result, long expireTime, String reason)
/*     */   {
/*  59 */     SLoginRole rsp = new SLoginRole();
/*  60 */     rsp.result = result;
/*  61 */     rsp.expire_time = expireTime;
/*     */     try
/*     */     {
/*  64 */       rsp.reason.setString(reason, "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*  69 */     rsp.roleid = this.roleId;
/*  70 */     return Onlines.getInstance().sendResponse(this.protocol, rsp);
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  76 */     Dispatch ctx = (Dispatch)this.protocol.getContext();
/*  77 */     String userid = ctx.userid.getString("UTF-8");
/*  78 */     xbean.User xUser = xtable.User.get(userid);
/*  79 */     if ((xUser == null) || (!xUser.getRoleids().contains(Long.valueOf(this.roleId)))) {
/*  80 */       GameServer.logger().error("userid:" + userid + " and roleid:" + this.roleId + " not match");
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     if (GameServerInfoManager.isRoamServer()) {
/*  85 */       Octets octets = LoginManager.getRoamToken(userid);
/*  86 */       if (octets == null) {
/*  87 */         GameServer.logger().error(String.format("[Login]PPlayerLogin.processImp@login roam server,but do not have token|userid=%s", new Object[] { userid }));
/*     */         
/*     */ 
/*     */ 
/*  91 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  95 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  96 */     ForbidInfo userForbid = Userforbid.get(userid);
/*  97 */     if ((userForbid != null) && (userForbid.getExpiretime() <= now)) {
/*  98 */       Userforbid.remove(userid);
/*  99 */       userForbid = null;
/*     */     }
/*     */     
/* 102 */     if (userForbid != null)
/*     */     {
/* 104 */       long expireTime = TimeUnit.MILLISECONDS.toSeconds(userForbid.getExpiretime());
/* 105 */       sendPlayerLoginReByProtocol(4, expireTime, userForbid.getReason());
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     if (!xUser.getRoleids().isEmpty())
/* 110 */       lock(xtable.Basic.getTable(), xUser.getRoleids());
/* 111 */     LoginManager.getInstance().checkInCrossServer(userid, this.roleId, this);
/* 112 */     return true;
/*     */   }
/*     */   
/*     */   boolean innerLogin(String userid, xbean.User xUser) {
/* 116 */     xbean.Basic basic = xtable.Basic.get(Long.valueOf(this.roleId));
/* 117 */     DeleteState xDeleteState = xtable.Role2delete.get(Long.valueOf(this.roleId));
/* 118 */     if ((basic == null) || ((xDeleteState != null) && (xDeleteState.getDeletestate() != 3))) {
/* 119 */       GameServer.logger().debug("PPlayerLogin@角色不存在.roleid=" + this.roleId);
/* 120 */       sendPlayerLoginReByProtocol(1);
/* 121 */       return false;
/*     */     }
/*     */     
/* 124 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 125 */     ForbidInfo forbidInfo = Roleforbid.get(Long.valueOf(this.roleId));
/* 126 */     if ((forbidInfo != null) && (forbidInfo.getExpiretime() <= now))
/*     */     {
/*     */ 
/* 129 */       Roleforbid.remove(Long.valueOf(this.roleId));
/* 130 */       forbidInfo = null;
/*     */     }
/*     */     
/* 133 */     if (forbidInfo != null) {
/* 134 */       long expireTime = TimeUnit.MILLISECONDS.toSeconds(forbidInfo.getExpiretime());
/* 135 */       sendPlayerLoginReByProtocol(3, expireTime, forbidInfo.getReason());
/* 136 */       return false; }
/* 137 */     if (!RoleInterface.isRoleExist(this.roleId, true)) {
/* 138 */       GameServer.logger().debug("PPlayerLogin@角色删除.roleid=" + this.roleId);
/* 139 */       return false;
/*     */     }
/*     */     
/* 142 */     Onlines onlines = Onlines.getInstance();
/*     */     
/* 144 */     gnet.link.Role gRole = onlines.insert(this.protocol, this.roleId);
/* 145 */     if (gRole == null) {
/* 146 */       GameServer.logger().debug("[online]PPlayerLogin : grole is null");
/* 147 */       sendPlayerLoginReByProtocol(1);
/* 148 */       return false;
/*     */     }
/*     */     
/* 151 */     GameServer.logger().info("role login, roleid=" + this.roleId);
/*     */     
/* 153 */     if (GameServerInfoManager.isRoamServer()) {
/* 154 */       mzm.gsp.crossserver.main.CrossServerInterface.setRoleRoamServerStatus(userid, this.roleId);
/*     */     }
/* 156 */     LoginStatus loginStatus = Loginstatus.get(Long.valueOf(this.roleId));
/* 157 */     Iterator i$; if (loginStatus != null) {
/* 158 */       OnlineInfo onlineInfo = OnlineManager.getInstance().getOnlineInfo(this.roleId);
/* 159 */       if (loginStatus.getStatus() == 8) {
/* 160 */         if (onlineInfo == null) {
/* 161 */           onlineInfo = new OnlineInfo(10);
/* 162 */           OnlineManager.getInstance().addOnlineInfo(this.roleId, onlineInfo);
/*     */         }
/* 164 */         mzm.gsp.timer.main.Session.removeSession(onlineInfo.getOfflineProtectSessionid(), this.roleId);
/* 165 */         loginStatus.setStatus(10);
/* 166 */         onlineInfo.setOnlineStatus(10);
/* 167 */         if (GameServer.logger().isDebugEnabled()) {
/* 168 */           GameServer.logger().debug("PPlayerLogin@玩家由离线保护状态转为登陆状态。roleid=" + this.roleId);
/*     */         }
/*     */         
/* 171 */         TaskOneByOne taskOneByOne = LoginManager.getInstance().remUserTask(userid);
/* 172 */         OnlineManager.getInstance().addRole(new mzm.gsp.Role(gRole, taskOneByOne));
/*     */         
/* 174 */         boolean r = sendPlayerLoginRe(0);
/* 175 */         if (r) {
/* 176 */           if (GameServer.logger().isDebugEnabled()) {
/* 177 */             GameServer.logger().debug("PPlayerLogin@SLoginRole SUCCESS,roleid=" + this.roleId);
/*     */           }
/* 179 */         } else if (GameServer.logger().isDebugEnabled()) {
/* 180 */           GameServer.logger().debug("PPlayerLogin@SLoginRole FAIL,roleid=" + this.roleId);
/*     */         }
/*     */       }
/*     */       else {
/* 184 */         GameServer.logger().error("PPlayerLogin@ 错误：玩家已经登陆过了,roleid=" + this.roleId + ",status=" + loginStatus.getStatus());
/*     */         
/* 186 */         new PPlayerPreLogout(this.roleId, 4).call();
/*     */         
/* 188 */         sendPlayerLoginReByProtocol(2);
/* 189 */         return true;
/*     */       }
/*     */     } else {
/* 192 */       loginStatus = xbean.Pod.newLoginStatus();
/* 193 */       loginStatus.setStatus(2);
/* 194 */       Loginstatus.insert(Long.valueOf(this.roleId), loginStatus);
/*     */       
/* 196 */       OnlineInfo onlineInfo = new OnlineInfo(2);
/* 197 */       OnlineManager.getInstance().addOnlineInfo(this.roleId, onlineInfo);
/* 198 */       TaskOneByOne taskOneByOne = LoginManager.getInstance().remUserTask(userid);
/* 199 */       OnlineManager.getInstance().addRole(new mzm.gsp.Role(gRole, taskOneByOne));
/* 200 */       boolean r = sendPlayerLoginRe(0);
/*     */       
/* 202 */       if (r) {
/* 203 */         if (GameServer.logger().isDebugEnabled()) {
/* 204 */           GameServer.logger().debug("PPlayerLogin@发送PlayerLogin_Re SUCCESS,roleid=" + this.roleId);
/*     */         }
/* 206 */       } else if (GameServer.logger().isDebugEnabled()) {
/* 207 */         GameServer.logger().debug("PPlayerLogin@发送PlayerLogin_Re FAIL,roleid=" + this.roleId);
/*     */       }
/*     */       
/*     */ 
/* 211 */       long lastLogoffTime = RoleInterface.setLastLogoffTimeWhenLogIn(this.roleId);
/* 212 */       Properties xProperties = xtable.Role2properties.get(Long.valueOf(this.roleId));
/* 213 */       xProperties.setAccumulateleveluptime(xProperties.getAccumulateleveluptime() + (lastLogoffTime - xProperties.getLeveluptime()));
/*     */       
/* 215 */       xProperties.setLastlogintime(now);
/* 216 */       xProperties.setLeveluptime(now);
/* 217 */       xProperties.setKeeponlinetime(now);
/*     */       
/* 219 */       if (xProperties.getLevelupcurtime() <= 0L) {
/* 220 */         xProperties.setLevelupcurtime(now);
/*     */       }
/*     */       
/* 223 */       xUser.setLastlogintime(now);
/* 224 */       xUser.setLast_login_roleid(this.roleId);
/*     */       
/* 226 */       String ipStr = RoleInterface.getIpStr(this.roleId);
/* 227 */       int platform = OnlineManager.getInstance().getPlatform(userid);
/* 228 */       String channel = RoleInterface.getChannel(this.roleId);
/* 229 */       String mac = OnlineManager.getInstance().getMac(userid);
/*     */       
/* 231 */       String loginUser = String.format("%d|%s|%d|%s|%s|%s", new Object[] { Integer.valueOf(platform), channel, Integer.valueOf(0), mac, userid, ipStr });
/* 232 */       LogManager.getInstance().addLog("userlogin", loginUser);
/*     */       
/* 234 */       String totalCache = String.valueOf(mzm.gsp.qingfu.main.QingfuInterface.getTotalCash(userid, true));
/* 235 */       String vipLevel = "0";
/* 236 */       String gangId = mzm.gsp.gang.main.GangInterface.getGangId(this.roleId) + "";
/*     */       
/* 238 */       LogManager.getInstance().addLog("rolelogin", new Object[] { Integer.valueOf(platform), channel, mac, userid, this.roleId + "", RoleInterface.getLevel(this.roleId) + "", totalCache, vipLevel, gangId + "", ipStr });
/*     */       
/*     */ 
/*     */ 
/* 242 */       playerLoginTLog(userid);
/*     */       
/*     */ 
/* 245 */       Set<Long> roleidSet = new java.util.HashSet();
/* 246 */       roleidSet.addAll(xUser.getRoleids());
/* 247 */       roleidSet.remove(Long.valueOf(this.roleId));
/* 248 */       for (i$ = roleidSet.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 249 */         if (OnlineManager.getInstance().getRoleById(roleid) != null) {
/* 250 */           NoneRealTimeTaskManager.getInstance().addTask(new PPlayerPreLogout(roleid, 2));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 255 */     return true;
/*     */   }
/*     */   
/*     */   Protocol getProtocol() {
/* 259 */     return this.protocol;
/*     */   }
/*     */   
/*     */   private void playerLoginTLog(String userId) {
/* 263 */     OnlineUserInfo onlineUserInfo = Onlines.getInstance().findUserInfo(userId);
/* 264 */     if (onlineUserInfo == null) {
/* 265 */       GameServer.logger().info(String.format("[online]PPlayerLogin.playerLoginTLog@user login arg is null|user_id=%s", new Object[] { userId }));
/*     */       
/* 267 */       return;
/*     */     }
/*     */     
/* 270 */     int level = RoleInterface.getLevel(this.roleId);
/* 271 */     int friendsNum = mzm.gsp.friend.main.FriendInterface.getFriendNum(this.roleId);
/* 272 */     String clientVersion = Onlines.getInstance().findEnumFromLoginArg(0, onlineUserInfo);
/* 273 */     String systemSoftWard = Onlines.getInstance().findEnumFromLoginArg(1, onlineUserInfo);
/*     */     
/* 275 */     String systemHardware = Onlines.getInstance().findEnumFromLoginArg(7, onlineUserInfo);
/* 276 */     int telecomOper = 1;
/* 277 */     if (onlineUserInfo != null) {
/* 278 */       telecomOper = onlineUserInfo.getTelecomoper();
/*     */     }
/*     */     
/* 281 */     String netWork = Onlines.getInstance().findEnumFromLoginArg(3, onlineUserInfo);
/*     */     
/* 283 */     String screenWidth = Onlines.getInstance().findEnumFromLoginArg(4, onlineUserInfo);
/* 284 */     int width = 0;
/* 285 */     if ((screenWidth != null) && (!screenWidth.isEmpty())) {
/*     */       try {
/* 287 */         width = Integer.valueOf(screenWidth).intValue();
/*     */       }
/*     */       catch (Exception e) {}
/*     */     }
/* 291 */     String screenHight = Onlines.getInstance().findEnumFromLoginArg(5, onlineUserInfo);
/* 292 */     int hight = 0;
/* 293 */     if ((screenHight != null) && (!screenHight.isEmpty())) {
/*     */       try {
/* 295 */         hight = Integer.valueOf(screenHight).intValue();
/*     */       }
/*     */       catch (Exception e) {}
/*     */     }
/* 299 */     String densityStr = Onlines.getInstance().findEnumFromLoginArg(6, onlineUserInfo);
/* 300 */     float density = 0.0F;
/* 301 */     if ((densityStr != null) && (!densityStr.isEmpty())) {
/*     */       try {
/* 303 */         density = Float.valueOf(densityStr).floatValue();
/*     */       }
/*     */       catch (Exception e) {}
/*     */     }
/* 307 */     String channel = Onlines.getInstance().findMSDKChannel(userId);
/* 308 */     String cpuHardward = Onlines.getInstance().findEnumFromLoginArg(7, onlineUserInfo);
/* 309 */     int memory = 0;
/* 310 */     String memeoryStr = Onlines.getInstance().findEnumFromLoginArg(8, onlineUserInfo);
/* 311 */     if ((densityStr != null) && (!densityStr.isEmpty())) {
/*     */       try {
/* 313 */         memory = Integer.valueOf(memeoryStr).intValue();
/*     */       }
/*     */       catch (Exception e) {}
/*     */     }
/* 317 */     String glRender = Onlines.getInstance().findEnumFromLoginArg(9, onlineUserInfo);
/* 318 */     String glVersion = Onlines.getInstance().findEnumFromLoginArg(10, onlineUserInfo);
/* 319 */     String deviceid = Onlines.getInstance().findEnumFromLoginArg(11, onlineUserInfo);
/* 320 */     int mfValue = RoleInterface.getRoleMFValue(this.roleId);
/* 321 */     Map<Long, Integer> petIdToYaoLiMap = mzm.gsp.pet.main.PetInterface.getPetYaoliMap(this.roleId);
/* 322 */     int yaoli1 = 0;
/* 323 */     int yaoli2 = 0;
/* 324 */     int yaoli3 = 0;
/* 325 */     for (Iterator i$ = petIdToYaoLiMap.values().iterator(); i$.hasNext();) { int yaoli = ((Integer)i$.next()).intValue();
/* 326 */       if (yaoli > yaoli1) {
/* 327 */         yaoli3 = yaoli2;
/* 328 */         yaoli2 = yaoli1;
/* 329 */         yaoli1 = yaoli;
/* 330 */       } else if (yaoli > yaoli2) {
/* 331 */         yaoli3 = yaoli2;
/* 332 */         yaoli2 = yaoli;
/* 333 */       } else if (yaoli > yaoli3) {
/* 334 */         yaoli3 = yaoli;
/*     */       }
/*     */     }
/* 337 */     boolean fakePlat = Onlines.getInstance().findFakePlat(userId);
/*     */     
/*     */ 
/* 340 */     String playerLogin = String.format("%d|%d|%s|%s|%s|%d|%s|%d|%d|%f|%s|%d|%s|%s|%d|%s|%s|%s|%d|%d|%d|%d|%d|%d|%d", new Object[] { Integer.valueOf(level), Integer.valueOf(friendsNum), clientVersion, systemSoftWard, systemHardware, Integer.valueOf(telecomOper), netWork, Integer.valueOf(width), Integer.valueOf(hight), Float.valueOf(density), channel, Long.valueOf(this.roleId), RoleInterface.getName(this.roleId), cpuHardward, Integer.valueOf(memory), glRender, glVersion, deviceid, Long.valueOf(this.roleId), Integer.valueOf(RoleInterface.getFightValue(this.roleId)), Integer.valueOf(mfValue), Integer.valueOf(yaoli1), Integer.valueOf(yaoli2), Integer.valueOf(yaoli3), Integer.valueOf(fakePlat ? 1 : 0) });
/*     */     
/*     */ 
/*     */ 
/* 344 */     TLogManager.getInstance().addLog(this.roleId, "PlayerLogin", playerLogin);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PPlayerLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */