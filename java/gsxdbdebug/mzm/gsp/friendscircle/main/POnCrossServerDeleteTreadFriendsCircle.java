/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossServerFriendsCircleTread;
/*     */ import xbean.Role2FriendsCircleInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnCrossServerDeleteTreadFriendsCircle extends LogicProcedure
/*     */ {
/*     */   private final long activeTreadRoleId;
/*     */   private final long beTrodRoleId;
/*     */   private final long treadSerialId;
/*     */   private int result;
/*     */   
/*     */   public int getResult()
/*     */   {
/*  23 */     return this.result;
/*     */   }
/*     */   
/*     */ 
/*     */   public POnCrossServerDeleteTreadFriendsCircle(long activeTreadRoleId, long beTrodRoleId, long treadSerialId)
/*     */   {
/*  29 */     this.activeTreadRoleId = activeTreadRoleId;
/*  30 */     this.beTrodRoleId = beTrodRoleId;
/*  31 */     this.treadSerialId = treadSerialId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     String userId = RoleInterface.getUserId(this.activeTreadRoleId);
/*  38 */     if (userId == null)
/*     */     {
/*  40 */       this.result = 3;
/*  41 */       onCrossServerDeleteTreadFriendsCircleFail(6);
/*  42 */       return false;
/*     */     }
/*  44 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  46 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.activeTreadRoleId);
/*     */     
/*  48 */     CrossServerFriendsCircleTread xCrossServerFriendsCircleTread = (CrossServerFriendsCircleTread)xRole2FriendsCircleInfo.getCross_server_tread().get(Long.valueOf(this.treadSerialId));
/*     */     
/*  50 */     if (xCrossServerFriendsCircleTread == null)
/*     */     {
/*  52 */       this.result = 1;
/*  53 */       return false;
/*     */     }
/*  55 */     if (xCrossServerFriendsCircleTread.getBe_trod_role_id() != this.beTrodRoleId)
/*     */     {
/*  57 */       this.result = 4;
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     if (!xCrossServerFriendsCircleTread.getIs_server_replied())
/*     */     {
/*  63 */       this.result = 2;
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     this.result = 0;
/*     */     
/*  69 */     xRole2FriendsCircleInfo.getCross_server_tread().remove(Long.valueOf(this.treadSerialId));
/*     */     
/*  71 */     StringBuilder sbLog = new StringBuilder();
/*  72 */     sbLog.append("[friendscircle]POnCrossServerDeleteTreadFriendsCircle.processImp@handle cross server delete thread friends circle gift rsp success");
/*  73 */     sbLog.append("|active_tread_role_id=").append(this.activeTreadRoleId);
/*  74 */     sbLog.append("|be_trod_role_id=").append(this.beTrodRoleId);
/*  75 */     sbLog.append("|tread_serial_id=").append(this.treadSerialId);
/*  76 */     sbLog.append("|corss_server_tread=").append(xCrossServerFriendsCircleTread);
/*     */     
/*  78 */     GameServer.logger().info(sbLog.toString());
/*  79 */     return true;
/*     */   }
/*     */   
/*     */   private void onCrossServerDeleteTreadFriendsCircleFail(int ret)
/*     */   {
/*  84 */     onCrossServerDeleteTreadFriendsCircleFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onCrossServerDeleteTreadFriendsCircleFail(int ret, Map<String, Object> extraMap)
/*     */   {
/*  89 */     StringBuilder sbLog = new StringBuilder();
/*  90 */     sbLog.append("[friendscircle]POnCrossServerDeleteTreadFriendsCircle.processImp@handle cross server delete thread friends circle gift rsp failed");
/*  91 */     sbLog.append("|ret=").append(ret);
/*  92 */     sbLog.append("|active_tread_role_id=").append(this.activeTreadRoleId);
/*  93 */     sbLog.append("|be_trod_role_id=").append(this.beTrodRoleId);
/*  94 */     sbLog.append("|tread_serial_id=").append(this.treadSerialId);
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnCrossServerDeleteTreadFriendsCircle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */