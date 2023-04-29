/*     */ package mzm.gsp.friend.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import xbean.FriendInfo;
/*     */ import xbean.FriendTotalInfo;
/*     */ import xtable.Role2friend;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class RoleFriend
/*     */ {
/*     */   private final long roleId;
/*     */   private FriendTotalInfo xFriendTotalInfo;
/*     */   
/*     */   RoleFriend(long roleId, boolean retainLock)
/*     */   {
/*  26 */     this.roleId = roleId;
/*  27 */     if (retainLock) {
/*  28 */       this.xFriendTotalInfo = Role2friend.get(Long.valueOf(roleId));
/*     */     } else {
/*  30 */       this.xFriendTotalInfo = Role2friend.select(Long.valueOf(roleId));
/*     */     }
/*     */   }
/*     */   
/*     */   public int getRelationValue(long roleid) {
/*  35 */     if (this.xFriendTotalInfo == null) {
/*  36 */       return 0;
/*     */     }
/*  38 */     FriendInfo xFriendInfo = (FriendInfo)this.xFriendTotalInfo.getFriendinfomap().get(Long.valueOf(roleid));
/*  39 */     if (xFriendInfo == null) {
/*  40 */       return 0;
/*     */     }
/*  42 */     return xFriendInfo.getRelationvalue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Map<Long, Integer> getAllFriendValue()
/*     */   {
/*  53 */     if (this.xFriendTotalInfo == null)
/*     */     {
/*  55 */       return Collections.emptyMap();
/*     */     }
/*  57 */     Map<Long, Integer> role2friendValue = new HashMap();
/*  58 */     for (Map.Entry<Long, FriendInfo> xEntry : this.xFriendTotalInfo.getFriendinfomap().entrySet())
/*     */     {
/*  60 */       role2friendValue.put(xEntry.getKey(), Integer.valueOf(((FriendInfo)xEntry.getValue()).getRelationvalue()));
/*     */     }
/*  62 */     return role2friendValue;
/*     */   }
/*     */   
/*     */   public long getBeFriendTime(long roleid) {
/*  66 */     if (this.xFriendTotalInfo == null) {
/*  67 */       return 0L;
/*     */     }
/*  69 */     FriendInfo xFriendInfo = (FriendInfo)this.xFriendTotalInfo.getFriendinfomap().get(Long.valueOf(roleid));
/*  70 */     if (xFriendInfo == null) {
/*  71 */       return 0L;
/*     */     }
/*  73 */     return xFriendInfo.getBefriendtime();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int friendSize()
/*     */   {
/*  82 */     if (this.xFriendTotalInfo == null) {
/*  83 */       return 0;
/*     */     }
/*  85 */     return this.xFriendTotalInfo.getFriendinfomap().size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean containsRole(long roleId)
/*     */   {
/*  95 */     if (this.xFriendTotalInfo == null) {
/*  96 */       return false;
/*     */     }
/*  98 */     return this.xFriendTotalInfo.getFriendinfomap().containsKey(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */   FriendTotalInfo getFriendTotalInfo()
/*     */   {
/* 103 */     return this.xFriendTotalInfo;
/*     */   }
/*     */   
/*     */   void setFriendTotalInfo(FriendTotalInfo friendTotalInfo) {
/* 107 */     this.xFriendTotalInfo = friendTotalInfo;
/*     */   }
/*     */   
/*     */   long getRoleId() {
/* 111 */     return this.roleId;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\RoleFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */