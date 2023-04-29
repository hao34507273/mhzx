/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SChildNormalFail;
/*     */ import mzm.gsp.children.SGetChildLocationInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChildInfo;
/*     */ import xtable.Children;
/*     */ 
/*     */ public class PCGetChildLocation extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long childId;
/*     */   
/*     */   public PCGetChildLocation(long roleId, long childId)
/*     */   {
/*  25 */     this.roleId = roleId;
/*  26 */     this.childId = childId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     Set<Long> roleIdSet = new HashSet();
/*  33 */     Long xOwnerRoleId = Children.selectOwn_role_id(Long.valueOf(this.childId));
/*  34 */     if ((xOwnerRoleId != null) && (xOwnerRoleId.longValue() > 0L))
/*     */     {
/*  36 */       roleIdSet.add(xOwnerRoleId);
/*     */     }
/*     */     
/*  39 */     Long xAnotherRoleId = Children.selectAnother_parent_role_id(Long.valueOf(this.childId));
/*  40 */     if ((xAnotherRoleId != null) && (xAnotherRoleId.longValue() > 0L))
/*     */     {
/*  42 */       roleIdSet.add(xAnotherRoleId);
/*     */     }
/*     */     
/*  45 */     lock(xtable.Role2properties.getTable(), roleIdSet);
/*     */     
/*  47 */     ChildInfo xChildInfo = Children.get(Long.valueOf(this.childId));
/*  48 */     if (xChildInfo == null)
/*     */     {
/*  50 */       onGetChildLocationFailed(2);
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     if ((xChildInfo.getOwn_role_id() != this.roleId) && (xChildInfo.getAnother_parent_role_id() != this.roleId))
/*     */     {
/*  56 */       Map<String, Object> extraMap = new HashMap();
/*  57 */       extraMap.put("own_role_id", Long.valueOf(xChildInfo.getOwn_role_id()));
/*  58 */       extraMap.put("another_parent_role_id", Long.valueOf(xChildInfo.getAnother_parent_role_id()));
/*     */       
/*  60 */       onGetChildLocationFailed(1, extraMap);
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 846, true, true))
/*     */     {
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     SGetChildLocationInfo sGetChildLocationInfo = new SGetChildLocationInfo();
/*  70 */     sGetChildLocationInfo.child_id = this.childId;
/*  71 */     if (xChildInfo.getCarry_role_id() != -1L)
/*     */     {
/*  73 */       long xCarryRoleId = xChildInfo.getCarry_role_id();
/*  74 */       if ((xCarryRoleId != xChildInfo.getOwn_role_id()) && (xCarryRoleId != xChildInfo.getAnother_parent_role_id()))
/*     */       {
/*  76 */         Map<String, Object> extraMap = new HashMap();
/*  77 */         extraMap.put("own_role_id", Long.valueOf(xChildInfo.getOwn_role_id()));
/*  78 */         extraMap.put("another_parent_role_id", Long.valueOf(xChildInfo.getAnother_parent_role_id()));
/*  79 */         extraMap.put("x_carry_role_id", Long.valueOf(xChildInfo.getCarry_role_id()));
/*  80 */         extraMap.put("home_state", Integer.valueOf(xChildInfo.getHome_state()));
/*     */         
/*  82 */         onGetChildLocationFailed(52, extraMap);
/*  83 */         return false;
/*     */       }
/*     */       
/*  86 */       if (RoleInterface.getGender(xCarryRoleId) == 2)
/*     */       {
/*  88 */         sGetChildLocationInfo.location = 2;
/*     */       }
/*     */       else
/*     */       {
/*  92 */         sGetChildLocationInfo.location = 3;
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*  97 */     else if (xChildInfo.getHome_state() == 1)
/*     */     {
/*  99 */       sGetChildLocationInfo.location = 0;
/*     */     }
/* 101 */     else if (xChildInfo.getHome_state() == 2)
/*     */     {
/* 103 */       sGetChildLocationInfo.location = 1;
/*     */     }
/*     */     else
/*     */     {
/* 107 */       Map<String, Object> extraMap = new HashMap();
/* 108 */       extraMap.put("own_role_id", Long.valueOf(xChildInfo.getOwn_role_id()));
/* 109 */       extraMap.put("another_parent_role_id", Long.valueOf(xChildInfo.getAnother_parent_role_id()));
/* 110 */       extraMap.put("x_carry_role_id", Long.valueOf(xChildInfo.getCarry_role_id()));
/* 111 */       extraMap.put("home_state", Integer.valueOf(xChildInfo.getHome_state()));
/*     */       
/* 113 */       onGetChildLocationFailed(53, extraMap);
/* 114 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 118 */     OnlineManager.getInstance().send(this.roleId, sGetChildLocationInfo);
/* 119 */     return true;
/*     */   }
/*     */   
/*     */   private void onGetChildLocationFailed(int ret)
/*     */   {
/* 124 */     onGetChildLocationFailed(ret, null);
/*     */   }
/*     */   
/*     */   private void onGetChildLocationFailed(int ret, Map<String, Object> extraMap)
/*     */   {
/* 129 */     StringBuilder sbLog = new StringBuilder();
/* 130 */     sbLog.append("[children]PCGetChildLocation.processImp@get child location failed");
/* 131 */     sbLog.append("|ret=").append(ret);
/* 132 */     sbLog.append("|role_id=").append(this.roleId);
/* 133 */     sbLog.append("|child_id=").append(this.childId);
/* 134 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 136 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 138 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 141 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 143 */     SChildNormalFail sChildNormalFail = new SChildNormalFail();
/* 144 */     sChildNormalFail.result = ret;
/*     */     
/* 146 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sChildNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCGetChildLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */