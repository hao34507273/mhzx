/*     */ package mzm.gsp.friend.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.friend.SSynRoleAddFriendRes;
/*     */ import mzm.gsp.friend.confbean.SFriendConsts;
/*     */ import mzm.gsp.friend.confbean.SFriendValueLimitCfg;
/*     */ import mzm.gsp.friend.event.FriendPointChange;
/*     */ import mzm.gsp.friend.event.FriendPointChangeArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import xbean.FriendInfo;
/*     */ import xbean.FriendTotalInfo;
/*     */ import xio.Protocol;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FriendInterface
/*     */ {
/*     */   public static int getRelationValue(long roleId, long friendId, boolean retainLock)
/*     */   {
/*  31 */     RoleFriend roleFriend = RoleFriendManager.getRoleFriend(roleId, retainLock);
/*  32 */     if (roleFriend.containsRole(friendId)) {
/*  33 */       return ((FriendInfo)roleFriend.getFriendTotalInfo().getFriendinfomap().get(Long.valueOf(friendId))).getRelationvalue();
/*     */     }
/*  35 */     return 0;
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
/*     */   public static Map<Long, Integer> getAllFriendValue(long roleId, boolean retainLock)
/*     */   {
/*  53 */     RoleFriend roleFriend = RoleFriendManager.getRoleFriend(roleId, retainLock);
/*  54 */     return roleFriend.getAllFriendValue();
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
/*     */   public static boolean isFriend(long roleId0, long roleId1, boolean retainLock)
/*     */   {
/*  69 */     RoleFriend roleFriend = RoleFriendManager.getRoleFriend(roleId0, retainLock);
/*  70 */     return roleFriend.containsRole(roleId1);
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
/*     */   public static List<Long> getAllFriends(long roleId, boolean retainLock)
/*     */   {
/*  84 */     List<Long> friendsList = new ArrayList();
/*  85 */     RoleFriend roleFriend = RoleFriendManager.getRoleFriend(roleId, retainLock);
/*  86 */     if (roleFriend.friendSize() > 0)
/*  87 */       friendsList.addAll(roleFriend.getFriendTotalInfo().getFriendinfomap().keySet());
/*  88 */     return friendsList;
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
/*     */   public static int addFriendValue(long roleId0, long roleId1, int friendValue, int limitType)
/*     */   {
/* 106 */     if (roleId0 == roleId1) {
/* 107 */       return 0;
/*     */     }
/* 109 */     RoleFriend roleFriend0 = RoleFriendManager.getRoleFriend(roleId0, true);
/* 110 */     int addAValue = RoleFriendManager.addFriendValue(roleFriend0, roleId1, friendValue, limitType);
/* 111 */     RoleFriend roleFriend1 = RoleFriendManager.getRoleFriend(roleId1, true);
/* 112 */     int addBValue = RoleFriendManager.addFriendValue(roleFriend1, roleId0, friendValue, limitType);
/*     */     
/* 114 */     int changeVaule = Math.min(addAValue, addBValue);
/* 115 */     if (changeVaule > 0) {
/* 116 */       FriendPointChangeArg friendPointChangeArg = new FriendPointChangeArg(roleId0, roleId1, roleFriend0.getRelationValue(roleId1), changeVaule);
/*     */       
/* 118 */       TriggerEventsManger.getInstance().triggerEvent(new FriendPointChange(), friendPointChangeArg);
/*     */     }
/* 120 */     return changeVaule;
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
/*     */   public static int cutFriendValue(long roleId0, long roleId1, int friendValue)
/*     */   {
/* 137 */     if (roleId0 == roleId1) {
/* 138 */       return 0;
/*     */     }
/* 140 */     RoleFriend roleFriend0 = RoleFriendManager.getRoleFriend(roleId0, true);
/* 141 */     int cutAValue = RoleFriendManager.cutFriendValue(roleFriend0, roleId1, friendValue);
/* 142 */     RoleFriend roleFriend1 = RoleFriendManager.getRoleFriend(roleId1, true);
/* 143 */     int cutBValue = RoleFriendManager.cutFriendValue(roleFriend1, roleId0, friendValue);
/* 144 */     return Math.min(cutAValue, cutBValue);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getBlackListMax()
/*     */   {
/* 153 */     return SFriendConsts.getInstance().blackMax;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SFriendValueLimitCfg getFriendValueLimitCfg(int limitType)
/*     */   {
/* 164 */     return FriendCfgManager.getFriendValueLimitCfg(limitType);
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
/*     */   public static int getFriendValueDay(long roleid1, long roleid2, int limitType)
/*     */   {
/* 179 */     RoleFriend roleFriend = RoleFriendManager.getRoleFriend(roleid1, false);
/* 180 */     if (roleFriend.containsRole(roleid2)) {
/* 181 */       FriendInfo friendInfo = (FriendInfo)roleFriend.getFriendTotalInfo().getFriendinfomap().get(Long.valueOf(roleid2));
/* 182 */       Integer value = (Integer)friendInfo.getValuelimitmap().get(Integer.valueOf(limitType));
/* 183 */       if (value != null) {
/* 184 */         return value.intValue();
/*     */       }
/*     */     }
/* 187 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static int getFriendNum(long roleid)
/*     */   {
/* 194 */     RoleFriend roleFriend = RoleFriendManager.getRoleFriend(roleid, false);
/* 195 */     return roleFriend.friendSize();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getFriendNumByMinFriendPoint(long roleId, int minFriendPoint)
/*     */   {
/* 203 */     RoleFriend roleFriend = RoleFriendManager.getRoleFriend(roleId, false);
/* 204 */     FriendTotalInfo xFriendTotalInfo = roleFriend.getFriendTotalInfo();
/* 205 */     if (xFriendTotalInfo == null)
/* 206 */       return 0;
/* 207 */     int i = 0;
/* 208 */     for (FriendInfo xFriendInfo : xFriendTotalInfo.getFriendinfomap().values())
/*     */     {
/* 210 */       if (xFriendInfo.getRelationvalue() >= minFriendPoint)
/*     */       {
/* 212 */         i++;
/*     */       }
/*     */     }
/* 215 */     return i;
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
/*     */ 
/*     */   public static boolean isToLimit(long roleid1, long roleid2, int limitType)
/*     */   {
/* 256 */     SFriendValueLimitCfg friendValueLimitCfg = FriendCfgManager.getFriendValueLimitCfg(limitType);
/* 257 */     boolean ret = false;
/* 258 */     if (friendValueLimitCfg.dayLimit > 0) {
/* 259 */       ret = getFriendValueDay(roleid1, roleid2, limitType) >= friendValueLimitCfg.dayLimit;
/* 260 */       if (ret) {
/* 261 */         return ret;
/*     */       }
/*     */     }
/* 264 */     if (friendValueLimitCfg.totalLimit > 0) {
/* 265 */       ret = getRelationValue(roleid1, roleid2, false) >= friendValueLimitCfg.totalLimit;
/* 266 */       if (ret) {
/* 267 */         return ret;
/*     */       }
/*     */     }
/* 270 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getApplyOthersCountToday(long roleid, boolean retainLock)
/*     */   {
/* 282 */     RoleApply roleApply = RoleFriendManager.getRoleApply(roleid, retainLock);
/* 283 */     return roleApply.getApplyOthersCountToday();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getApplyOtherRefuseCountToday(long roleid, boolean retainLock)
/*     */   {
/* 295 */     RoleApply roleApply = RoleFriendManager.getRoleApply(roleid, true);
/* 296 */     return roleApply.getApplyOtherRefuseCountToday();
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
/*     */   public static void sendSpecialAddFriend(long roleidA, long roleidB, int triggerType, Map<Integer, Integer> extraInfo)
/*     */   {
/* 311 */     SSynRoleAddFriendRes synRoleAddFriendResA = new SSynRoleAddFriendRes();
/* 312 */     SSynRoleAddFriendRes synRoleAddFriendResB = new SSynRoleAddFriendRes();
/* 313 */     if (extraInfo != null) {
/* 314 */       synRoleAddFriendResA.extrainfo.putAll(extraInfo);
/* 315 */       synRoleAddFriendResB.extrainfo.putAll(extraInfo);
/*     */     }
/* 317 */     synRoleAddFriendResA.triggertype = triggerType;
/* 318 */     synRoleAddFriendResB.triggertype = triggerType;
/* 319 */     synRoleAddFriendResA.roleid = roleidB;
/* 320 */     synRoleAddFriendResB.roleid = roleidA;
/* 321 */     synRoleAddFriendResA.name = RoleInterface.getName(roleidB);
/* 322 */     synRoleAddFriendResB.name = RoleInterface.getName(roleidA);
/* 323 */     OnlineManager.getInstance().send(roleidA, synRoleAddFriendResA);
/* 324 */     OnlineManager.getInstance().send(roleidB, synRoleAddFriendResB);
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
/*     */   public static long beFriendTime(long roleid1, long roleid2, boolean retainLock)
/*     */   {
/* 339 */     RoleFriend roleFriend = new RoleFriend(roleid1, retainLock);
/* 340 */     return roleFriend.getBeFriendTime(roleid2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void broadCastMsgToFriend(Protocol protocol, long roleid)
/*     */   {
/* 350 */     RoleFriend roleFriend = new RoleFriend(roleid, false);
/* 351 */     RoleFriendManager.broadCastMsgToFriend(protocol, roleFriend);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void broadCastMsgToFriendExceptRole(Protocol protocol, long roleid, long exceptRoleid)
/*     */   {
/* 362 */     RoleFriend roleFriend = new RoleFriend(roleid, false);
/* 363 */     RoleFriendManager.broadCastMsgToFriendExcept(protocol, roleFriend, exceptRoleid);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\FriendInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */