/*     */ package mzm.gsp.friend.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*     */ import mzm.gsp.avatar.main.AvatarInterface;
/*     */ import mzm.gsp.blacklist.main.BlacklistInterface;
/*     */ import mzm.gsp.friend.RecomandFriendInfo;
/*     */ import mzm.gsp.friend.SRecomandFriend;
/*     */ import mzm.gsp.friend.confbean.SFriendConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.RoleGrcFriendInfo;
/*     */ import xbean.UserGrcFriendInfo;
/*     */ import xdb.Xdb;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class PRecommendFriend extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PRecommendFriend(long roleId)
/*     */   {
/*  35 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 185, true)) {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     Set<GrcFriendInfo> potentialGrcFriends = filterGrcFriend();
/*     */     
/*     */ 
/*  48 */     lock(xtable.User.getTable(), Collections.singleton(Long.valueOf(this.roleId)));
/*  49 */     lock(Basic.getTable(), Collections.singleton(Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*  52 */     final List<GrcFriendInfo> friendResults = new ArrayList();
/*  53 */     Set<Long> recommendedGrcFriends = new HashSet();
/*  54 */     for (GrcFriendInfo friend : potentialGrcFriends)
/*     */     {
/*  56 */       if (friendResults.size() >= SFriendConsts.getInstance().recommandNum)
/*     */         break;
/*  58 */       if (canRecommend(friend.roleId))
/*     */       {
/*  60 */         friendResults.add(friend);
/*  61 */         recommendedGrcFriends.add(Long.valueOf(friend.roleId));
/*     */       }
/*     */     }
/*  64 */     Collections.sort(friendResults, new Comparator()
/*     */     {
/*     */ 
/*     */       public int compare(PRecommendFriend.GrcFriendInfo o1, PRecommendFriend.GrcFriendInfo o2)
/*     */       {
/*     */ 
/*  70 */         if ((o1.roleOnline) && (!o2.roleOnline))
/*  71 */           return -1;
/*  72 */         if ((o2.roleOnline) && (!o1.roleOnline)) {
/*  73 */           return 1;
/*     */         }
/*  75 */         if (o1.roleLevel > o2.roleLevel)
/*  76 */           return -1;
/*  77 */         if (o1.roleLevel < o2.roleLevel)
/*  78 */           return 1;
/*  79 */         return 0;
/*     */       }
/*     */       
/*     */ 
/*  83 */     });
/*  84 */     final Set<Long> onlineResults = new HashSet();
/*  85 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*  86 */     int levelFrom = roleLevel - SFriendConsts.getInstance().recomandLevel;
/*  87 */     int levelTo = roleLevel + SFriendConsts.getInstance().recomandLevel;
/*  88 */     List<Long> onlineRoles = OnlineManager.getInstance().getOnlineRoleidList(levelFrom, levelTo);
/*     */     
/*  90 */     while ((onlineRoles.size() > 0) && (onlineResults.size() < SFriendConsts.getInstance().recomandLevelNum - recommendedGrcFriends.size()))
/*     */     {
/*  92 */       int i = Xdb.random().nextInt(onlineRoles.size());
/*  93 */       long roleId = ((Long)onlineRoles.remove(i)).longValue();
/*  94 */       if ((!recommendedGrcFriends.contains(Long.valueOf(roleId))) && (canRecommend(roleId))) {
/*  95 */         onlineResults.add(Long.valueOf(roleId));
/*     */       }
/*     */     }
/*     */     
/*  99 */     if (onlineResults.size() < SFriendConsts.getInstance().recommandNum - friendResults.size())
/*     */     {
/*     */ 
/* 102 */       List<Long> higherLevelRoles = OnlineManager.getInstance().getOnlineHigherRoleidList(levelTo);
/* 103 */       fillRecommendRoleIds(onlineResults, higherLevelRoles, recommendedGrcFriends);
/*     */       
/* 105 */       if (onlineResults.size() < SFriendConsts.getInstance().recommandNum - friendResults.size())
/*     */       {
/*     */ 
/* 108 */         List<Long> lowerLevelRoles = OnlineManager.getInstance().getOnlineLowererRoleidList(levelFrom);
/* 109 */         fillRecommendRoleIds(onlineResults, lowerLevelRoles, recommendedGrcFriends);
/*     */         
/*     */ 
/* 112 */         if (onlineResults.size() < SFriendConsts.getInstance().recommandNum - friendResults.size())
/*     */         {
/* 114 */           fillRecommendRoleIds(onlineResults, onlineRoles, recommendedGrcFriends);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 120 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 125 */         SRecomandFriend sRecomandFriend = new SRecomandFriend();
/* 126 */         for (PRecommendFriend.GrcFriendInfo friendRoleInfo : friendResults)
/*     */         {
/* 128 */           RecomandFriendInfo recomandFriendInfo = new RecomandFriendInfo();
/* 129 */           PRecommendFriend.this.fillRecommendInfo(recomandFriendInfo, friendRoleInfo.roleId, true, friendRoleInfo.roleOnline);
/* 130 */           sRecomandFriend.recomandfriends.add(recomandFriendInfo);
/*     */         }
/* 132 */         for (Iterator i$ = onlineResults.iterator(); i$.hasNext();) { long onlineRoleId = ((Long)i$.next()).longValue();
/*     */           
/* 134 */           RecomandFriendInfo recomandFriendInfo = new RecomandFriendInfo();
/* 135 */           PRecommendFriend.this.fillRecommendInfo(recomandFriendInfo, onlineRoleId, false, true);
/* 136 */           sRecomandFriend.recomandfriends.add(recomandFriendInfo);
/*     */         }
/* 138 */         OnlineManager.getInstance().send(PRecommendFriend.this.roleId, sRecomandFriend);
/* 139 */         return true;
/*     */       }
/* 141 */     });
/* 142 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Set<GrcFriendInfo> filterGrcFriend()
/*     */   {
/* 151 */     Set<GrcFriendInfo> potentialGrcFriends = new HashSet();
/* 152 */     if (!OpenInterface.getOpenStatus(497))
/* 153 */       return potentialGrcFriends;
/* 154 */     String userId = RoleInterface.getUserId(this.roleId);
/* 155 */     if (userId == null) {
/* 156 */       return potentialGrcFriends;
/*     */     }
/*     */     
/* 159 */     UserGrcFriendInfo xUserGrcFriendInfo = xtable.User2grc_friend.select(userId);
/* 160 */     if (xUserGrcFriendInfo == null)
/* 161 */       return potentialGrcFriends;
/* 162 */     int zoneId = GameServerInfoManager.getZoneId();
/* 163 */     RoleGrcFriendInfo xRoleGrcFriendInfo = (RoleGrcFriendInfo)xUserGrcFriendInfo.getZone2ids().get(Integer.valueOf(zoneId));
/* 164 */     if (xRoleGrcFriendInfo == null) {
/* 165 */       return potentialGrcFriends;
/*     */     }
/*     */     
/* 168 */     long loginTimeThreshold = DateTimeUtils.getCurrTimeInMillis() - SFriendConsts.getInstance().ignoreGrcFriendLoginTimeThreshold * 3600000L;
/*     */     
/* 170 */     for (Long roleId : xRoleGrcFriendInfo.getIds())
/*     */     {
/* 172 */       String uid = RoleInterface.getUserId(roleId.longValue());
/* 173 */       if (uid != null)
/*     */       {
/* 175 */         xbean.User xUser = xtable.User.select(uid);
/* 176 */         if (xUser != null)
/*     */         {
/* 178 */           if ((xUser.getLast_login_roleid() == roleId.longValue()) && (xUser.getLastlogintime() >= loginTimeThreshold))
/* 179 */             potentialGrcFriends.add(new GrcFriendInfo(roleId.longValue(), RoleInterface.getLevel(roleId.longValue()), OnlineManager.getInstance().isOnline(roleId.longValue()), null)); }
/*     */       }
/*     */     }
/* 182 */     return potentialGrcFriends;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void fillRecommendRoleIds(Set<Long> results, List<Long> roleIdList, Set<Long> recommendedGrcFriends)
/*     */   {
/* 191 */     for (int i = 0; 
/* 192 */         (i < roleIdList.size()) && (results.size() < SFriendConsts.getInstance().recommandNum - recommendedGrcFriends.size()); i++)
/*     */     {
/* 194 */       int randomIndex = Xdb.random().nextInt(roleIdList.size());
/* 195 */       long roleId = ((Long)roleIdList.remove(randomIndex)).longValue();
/* 196 */       if ((!recommendedGrcFriends.contains(Long.valueOf(roleId))) && (canRecommend(roleId))) {
/* 197 */         results.add(Long.valueOf(roleId));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean canRecommend(long recommendRoleId)
/*     */   {
/* 206 */     if (this.roleId == recommendRoleId)
/* 207 */       return false;
/* 208 */     if (FriendInterface.isFriend(this.roleId, recommendRoleId, true))
/* 209 */       return false;
/* 210 */     if (BlacklistInterface.isInBlacklist(this.roleId, recommendRoleId))
/* 211 */       return false;
/* 212 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void fillRecommendInfo(RecomandFriendInfo recommendFriendInfo, long roleId, boolean isGrcFriend, boolean isOnline)
/*     */   {
/* 221 */     recommendFriendInfo.occupationid = RoleInterface.getOccupationId(roleId);
/* 222 */     recommendFriendInfo.roleid = roleId;
/* 223 */     recommendFriendInfo.rolelevel = RoleInterface.getLevel(roleId);
/* 224 */     recommendFriendInfo.rolename = RoleInterface.getName(roleId);
/* 225 */     recommendFriendInfo.isgrcfriend = (isGrcFriend ? 1 : 0);
/* 226 */     recommendFriendInfo.isonline = (isOnline ? 1 : 0);
/* 227 */     recommendFriendInfo.sex = RoleInterface.getGender(roleId);
/* 228 */     recommendFriendInfo.friendset = mzm.gsp.systemsetting.main.SystemSettingInterface.getSetting(roleId, 2).intValue();
/* 229 */     recommendFriendInfo.avatarid = AvatarInterface.getCurrentAvatar(roleId, false);
/* 230 */     recommendFriendInfo.avatarframeid = AvatarFrameInterface.getCurrentAvatarFrameId(roleId, false);
/*     */   }
/*     */   
/*     */   private class GrcFriendInfo
/*     */   {
/*     */     final long roleId;
/*     */     final int roleLevel;
/*     */     final boolean roleOnline;
/*     */     
/*     */     private GrcFriendInfo(long roleId, int roleLevel, boolean roleOnline)
/*     */     {
/* 241 */       this.roleId = roleId;
/* 242 */       this.roleLevel = roleLevel;
/* 243 */       this.roleOnline = roleOnline;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\PRecommendFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */