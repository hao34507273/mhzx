/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2FriendsCircleInfo;
/*     */ 
/*     */ public class POnCrossServerOperatorBlacklist extends LogicProcedure
/*     */ {
/*     */   private final long activeRoleId;
/*     */   private final int activeServerId;
/*     */   private final long beBlackedRoleId;
/*     */   private final int operatorType;
/*     */   private int result;
/*     */   
/*     */   public int getResult()
/*     */   {
/*  22 */     return this.result;
/*     */   }
/*     */   
/*     */ 
/*     */   public POnCrossServerOperatorBlacklist(long activeRoleId, int activeServerId, long beBlackedRoleId, int operatorType)
/*     */   {
/*  28 */     this.activeRoleId = activeRoleId;
/*  29 */     this.activeServerId = activeServerId;
/*  30 */     this.beBlackedRoleId = beBlackedRoleId;
/*  31 */     this.operatorType = operatorType;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     String beBlackedUserId = RoleInterface.getUserId(this.beBlackedRoleId);
/*  38 */     if (beBlackedUserId == null)
/*     */     {
/*  40 */       this.result = 1;
/*     */       
/*  42 */       onCrossServerAddBlacklistFail(this.result);
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.beBlackedRoleId);
/*  47 */     if (this.operatorType == 1)
/*     */     {
/*  49 */       if (!xRole2FriendsCircleInfo.getCross_server_black_in_role_set().add(Long.valueOf(this.activeRoleId)))
/*     */       {
/*  51 */         this.result = 2;
/*     */         
/*  53 */         onCrossServerAddBlacklistFail(this.result);
/*  54 */         return false;
/*     */       }
/*     */     }
/*  57 */     else if (this.operatorType == 2)
/*     */     {
/*  59 */       if (!xRole2FriendsCircleInfo.getCross_server_black_in_role_set().remove(Long.valueOf(this.activeRoleId)))
/*     */       {
/*  61 */         this.result = 2;
/*     */         
/*  63 */         onCrossServerAddBlacklistFail(this.result);
/*  64 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  68 */     StringBuilder sBuilder = new StringBuilder();
/*  69 */     sBuilder.append("[friendscircle]POnCrossServerOperatorBlacklist.processImp@handle cross server operator black list success");
/*  70 */     sBuilder.append("|active_role_id=").append(this.activeRoleId);
/*  71 */     sBuilder.append("|active_server_id=").append(this.activeServerId);
/*  72 */     sBuilder.append("|be_black_role_id=").append(this.beBlackedRoleId);
/*     */     
/*  74 */     GameServer.logger().info(sBuilder.toString());
/*     */     
/*  76 */     return true;
/*     */   }
/*     */   
/*     */   private void onCrossServerAddBlacklistFail(int ret)
/*     */   {
/*  81 */     onCrossServerAddBlacklistFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onCrossServerAddBlacklistFail(int ret, Map<String, Object> extraMap)
/*     */   {
/*  86 */     StringBuilder sbLog = new StringBuilder();
/*  87 */     sbLog.append("[friendscircle]POnCrossServerOperatorBlacklist.processImp@add cross server black list failed");
/*  88 */     sbLog.append("|ret=").append(ret);
/*  89 */     sbLog.append("|active_role_id=").append(this.activeRoleId);
/*  90 */     sbLog.append("|active_server_id=").append(this.activeServerId);
/*  91 */     sbLog.append("|be_black_role_id=").append(this.beBlackedRoleId);
/*     */     
/*  93 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/*  95 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/*  97 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 100 */     GameServer.logger().error(sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnCrossServerOperatorBlacklist.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */