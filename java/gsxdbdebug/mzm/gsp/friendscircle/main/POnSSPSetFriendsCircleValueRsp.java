/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.ssp.SSPContext;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2FriendsCircleInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnSSPSetFriendsCircleValueRsp
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int modifyType;
/*     */   private final int modifyValue;
/*     */   private final SSPContext sspContext;
/*     */   
/*     */   public POnSSPSetFriendsCircleValueRsp(long roleId, int modifyType, int modifyValue, SSPContext sspContext)
/*     */   {
/*  25 */     this.roleId = roleId;
/*  26 */     this.modifyType = modifyType;
/*  27 */     this.modifyValue = modifyValue;
/*  28 */     this.sspContext = sspContext;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     String userId = RoleInterface.getUserId(this.roleId);
/*  35 */     if (userId == null)
/*     */     {
/*  37 */       onFail(-1);
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getFriendsCircleInfo(this.roleId, true);
/*     */     
/*     */ 
/*  44 */     if (xRole2FriendsCircleInfo == null)
/*     */     {
/*  46 */       onFail(-2);
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if ((this.modifyType != 1) && (this.modifyType != 2) && (this.modifyType != 3) && (this.modifyType != 4))
/*     */     {
/*  52 */       onFail(-3);
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     int repairTreadResult = xRole2FriendsCircleInfo.getRepair_tread();
/*  57 */     if (((this.modifyType == 1) && ((repairTreadResult & 0x1) != 0)) || ((this.modifyType == 2) && ((repairTreadResult & 0x2) != 0)) || ((this.modifyType == 3) && ((repairTreadResult & 0x4) != 0)) || ((this.modifyType == 4) && ((repairTreadResult & 0x8) != 0)))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*  62 */       onFail(-4);
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     if (this.modifyType == 1)
/*     */     {
/*  68 */       repairTreadResult |= 0x1;
/*     */     }
/*  70 */     else if (this.modifyType == 2)
/*     */     {
/*  72 */       repairTreadResult |= 0x2;
/*     */     }
/*  74 */     else if (this.modifyType == 3)
/*     */     {
/*  76 */       repairTreadResult |= 0x4;
/*     */     }
/*  78 */     else if (this.modifyType == 4)
/*     */     {
/*  80 */       repairTreadResult |= 0x8;
/*     */     }
/*     */     
/*  83 */     if (repairTreadResult == 15)
/*     */     {
/*  85 */       RoleStatusInterface.unsetStatus(this.roleId, 1830);
/*     */     }
/*     */     
/*  88 */     xRole2FriendsCircleInfo.setRepair_tread(repairTreadResult);
/*     */     
/*  90 */     int type = 0;
/*  91 */     if ((this.sspContext instanceof SSPUpdateImportantValueContext))
/*     */     {
/*  93 */       SSPUpdateImportantValueContext sspUpdateImportantValueContext = (SSPUpdateImportantValueContext)this.sspContext;
/*  94 */       type = sspUpdateImportantValueContext.updateReason;
/*     */     }
/*     */     
/*  97 */     FriendsCircleManager.tlogRepairFriendsCircleRoleData(this.roleId, userId, this.modifyType, this.modifyValue, type);
/*     */     
/*  99 */     onFail(0);
/* 100 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int ret)
/*     */   {
/* 105 */     onFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onFail(int ret, Map<String, Object> extraMap)
/*     */   {
/* 110 */     StringBuilder sbLog = new StringBuilder();
/* 111 */     sbLog.append("[friendscircle]POnSSPSetFriendsCircleValueRsp.processImp@handle ssp set friends circle value rsp");
/* 112 */     sbLog.append("|ret=").append(ret);
/* 113 */     sbLog.append("|role_id=").append(this.roleId);
/* 114 */     sbLog.append("|modify_type=").append(this.modifyType);
/* 115 */     sbLog.append("|modify_value=").append(this.modifyValue);
/*     */     
/* 117 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 119 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 121 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 124 */     GameServer.logger().error(sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnSSPSetFriendsCircleValueRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */