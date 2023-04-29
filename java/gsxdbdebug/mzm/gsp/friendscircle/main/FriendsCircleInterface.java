/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.CrossServerFriendsCircleGift;
/*     */ import xbean.CrossServerFriendsCircleTread;
/*     */ import xbean.Role2FriendsCircleInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FriendsCircleInterface
/*     */ {
/*     */   public static boolean isGiveGiftNotServerReplied(long roleId, long serialId)
/*     */   {
/*  17 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(roleId);
/*     */     
/*  19 */     CrossServerFriendsCircleGift xCrossServerFriendsCircleGift = (CrossServerFriendsCircleGift)xRole2FriendsCircleInfo.getCross_server_send_gift().get(Long.valueOf(serialId));
/*     */     
/*  21 */     if (xCrossServerFriendsCircleGift == null)
/*     */     {
/*  23 */       return true;
/*     */     }
/*     */     
/*  26 */     if (xCrossServerFriendsCircleGift.getIs_server_replied())
/*     */     {
/*  28 */       return true;
/*     */     }
/*     */     
/*  31 */     return false;
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
/*     */   public static boolean isTreadCircleNotServerReplied(long roleId, long serialId)
/*     */   {
/*  44 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(roleId);
/*     */     
/*  46 */     CrossServerFriendsCircleTread xCrossServerFriendsCircleTread = (CrossServerFriendsCircleTread)xRole2FriendsCircleInfo.getCross_server_tread().get(Long.valueOf(serialId));
/*     */     
/*  48 */     if (xCrossServerFriendsCircleTread == null)
/*     */     {
/*  50 */       return true;
/*     */     }
/*     */     
/*  53 */     if (xCrossServerFriendsCircleTread.getIs_server_replied())
/*     */     {
/*  55 */       return true;
/*     */     }
/*     */     
/*  58 */     return false;
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
/*     */   public static int getRoleTotalPopularity(long roleId, boolean isRemainRolelock)
/*     */   {
/*  72 */     return FriendsCircleManager.getRoleTotalPopularity(roleId, isRemainRolelock);
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
/*     */   public static int getRoleReceiveGift(long roleId, boolean isRemainRolelock)
/*     */   {
/*  86 */     return FriendsCircleManager.getRoleReceiveGift(roleId, isRemainRolelock);
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
/*     */   public static int getRoleWeekPopularity(long roleId, boolean isRemainRolelock)
/*     */   {
/* 100 */     return FriendsCircleManager.getWeekPopularityValue(roleId, isRemainRolelock);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static class RoleFriendsCircleValueObj
/*     */   {
/*     */     public final int treasureBoxNum;
/*     */     
/*     */ 
/*     */ 
/*     */     public final int weekPopularityValue;
/*     */     
/*     */ 
/*     */ 
/*     */     public final int totalPopularityValue;
/*     */     
/*     */ 
/*     */ 
/*     */     public final int receiveGiftNum;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public RoleFriendsCircleValueObj(int treasureBoxNum, int weekPopularityValue, int totalPopularityValue, int receiveGiftNum)
/*     */     {
/* 128 */       this.treasureBoxNum = treasureBoxNum;
/* 129 */       this.weekPopularityValue = weekPopularityValue;
/* 130 */       this.totalPopularityValue = totalPopularityValue;
/* 131 */       this.receiveGiftNum = receiveGiftNum;
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
/*     */   public static RoleFriendsCircleValueObj getRoleFriendsCircleValueObj(long roleId, boolean isRemainRolelock)
/*     */   {
/* 147 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getFriendsCircleInfo(roleId, isRemainRolelock);
/*     */     
/* 149 */     if (xRole2FriendsCircleInfo == null)
/*     */     {
/* 151 */       return null;
/*     */     }
/*     */     
/* 154 */     int treasureBoxNum = xRole2FriendsCircleInfo.getTreasure_box_num();
/*     */     
/* 156 */     int weekPopularityValue = FriendsCircleManager.getWeekPopularity(roleId, xRole2FriendsCircleInfo).intValue();
/*     */     
/* 158 */     int totalPopularityValue = xRole2FriendsCircleInfo.getTotal_popularity_value();
/*     */     
/* 160 */     int receiveGiftNum = xRole2FriendsCircleInfo.getReceive_gift_num();
/*     */     
/* 162 */     return new RoleFriendsCircleValueObj(treasureBoxNum, weekPopularityValue, totalPopularityValue, receiveGiftNum);
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
/*     */   public static int setSSPRoleFriendsCircleValue(long roleId, int treasureBoxNum, int weekPopularityValue, int totalPopularityValue, int receiveGiftNum)
/*     */   {
/* 183 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getFriendsCircleInfo(roleId, true);
/* 184 */     if (xRole2FriendsCircleInfo == null)
/*     */     {
/* 186 */       return 64126;
/*     */     }
/*     */     
/* 189 */     int localTreasureBoxNum = xRole2FriendsCircleInfo.getTreasure_box_num();
/*     */     
/* 191 */     int localWeekPopularityValue = FriendsCircleManager.getWeekPopularity(roleId, xRole2FriendsCircleInfo).intValue();
/*     */     
/* 193 */     int localTotalPopularityValue = xRole2FriendsCircleInfo.getTotal_popularity_value();
/*     */     
/* 195 */     int localReceiveGiftNum = xRole2FriendsCircleInfo.getReceive_gift_num();
/* 196 */     if ((localReceiveGiftNum != receiveGiftNum) || (localTotalPopularityValue != totalPopularityValue) || (localWeekPopularityValue != weekPopularityValue) || (treasureBoxNum != localTreasureBoxNum))
/*     */     {
/*     */ 
/* 199 */       return 64125;
/*     */     }
/*     */     
/*     */ 
/* 203 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\FriendsCircleInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */