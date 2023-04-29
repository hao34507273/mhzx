/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossServerFriendsCircleGift;
/*     */ import xbean.Role2FriendsCircleInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnCrossServerDelteGiveFriendsCricleGift extends LogicProcedure
/*     */ {
/*     */   private final long activeGiveGiftRoleId;
/*     */   private final long receiveGiftRoleId;
/*     */   private final long giftSerialId;
/*     */   private int result;
/*     */   
/*     */   public int getResult()
/*     */   {
/*  23 */     return this.result;
/*     */   }
/*     */   
/*     */ 
/*     */   public POnCrossServerDelteGiveFriendsCricleGift(long activeTreadRoleId, long beTrodRoleId, long treadSerialId)
/*     */   {
/*  29 */     this.activeGiveGiftRoleId = activeTreadRoleId;
/*  30 */     this.receiveGiftRoleId = beTrodRoleId;
/*  31 */     this.giftSerialId = treadSerialId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     String userId = RoleInterface.getUserId(this.activeGiveGiftRoleId);
/*  38 */     if (userId == null)
/*     */     {
/*  40 */       this.result = 3;
/*  41 */       OnCrossServerDelteGiveFriendsCricleGiftFail(6);
/*  42 */       return false;
/*     */     }
/*  44 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  46 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.activeGiveGiftRoleId);
/*     */     
/*  48 */     CrossServerFriendsCircleGift xCrossServerFriendsCircleGift = (CrossServerFriendsCircleGift)xRole2FriendsCircleInfo.getCross_server_send_gift().get(Long.valueOf(this.giftSerialId));
/*     */     
/*  50 */     if (xCrossServerFriendsCircleGift == null)
/*     */     {
/*  52 */       this.result = 1;
/*  53 */       return false;
/*     */     }
/*  55 */     if (xCrossServerFriendsCircleGift.getReceive_gift_role_id() != this.receiveGiftRoleId)
/*     */     {
/*  57 */       this.result = 4;
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     if (!xCrossServerFriendsCircleGift.getIs_server_replied())
/*     */     {
/*  63 */       this.result = 2;
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     this.result = 0;
/*     */     
/*  69 */     xRole2FriendsCircleInfo.getCross_server_tread().remove(Long.valueOf(this.giftSerialId));
/*     */     
/*  71 */     StringBuilder sbLog = new StringBuilder();
/*  72 */     sbLog.append("[friendscircle]POnCrossServerDelteGiveFriendsCricleGift.processImp@handle cross server delete thread friends circle gift rsp success");
/*  73 */     sbLog.append("|active_give_gift_role_id=").append(this.activeGiveGiftRoleId);
/*  74 */     sbLog.append("|receive_gift_role_id=").append(this.receiveGiftRoleId);
/*  75 */     sbLog.append("|gift_serial_id=").append(this.giftSerialId);
/*  76 */     sbLog.append("|corss_server_gift=").append(xCrossServerFriendsCircleGift);
/*     */     
/*  78 */     GameServer.logger().info(sbLog.toString());
/*  79 */     return true;
/*     */   }
/*     */   
/*     */   private void OnCrossServerDelteGiveFriendsCricleGiftFail(int ret)
/*     */   {
/*  84 */     onCrossServerDeleteTreadFriendsCircleFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onCrossServerDeleteTreadFriendsCircleFail(int ret, Map<String, Object> extraMap)
/*     */   {
/*  89 */     StringBuilder sbLog = new StringBuilder();
/*  90 */     sbLog.append("[friendscircle]POnCrossServerDeleteTreadFriendsCircle.processImp@handle cross server delete friends circle gift rsp failed");
/*  91 */     sbLog.append("|ret=").append(ret);
/*  92 */     sbLog.append("|active_give_gift_role_id=").append(this.activeGiveGiftRoleId);
/*  93 */     sbLog.append("|receive_gift_role_id=").append(this.receiveGiftRoleId);
/*  94 */     sbLog.append("|gift_serial_id=").append(this.giftSerialId);
/*     */     
/*  96 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/*  98 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 100 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 103 */     GameServer.logger().error(sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnCrossServerDelteGiveFriendsCricleGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */