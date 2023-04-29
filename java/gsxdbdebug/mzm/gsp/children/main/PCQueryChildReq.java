/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.children.SQueryChildInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import xbean.ChildGrowthDiaryInfo;
/*     */ import xbean.ChildInfo;
/*     */ import xtable.Children;
/*     */ import xtable.Childrengrowthdiary;
/*     */ 
/*     */ public class PCQueryChildReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long childId;
/*     */   
/*     */   public PCQueryChildReq(long roleId, long childId)
/*     */   {
/*  23 */     this.roleId = roleId;
/*  24 */     this.childId = childId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     if (!ChildrenManager.isFunOpen(this.roleId))
/*     */     {
/*  32 */       return false;
/*     */     }
/*     */     
/*  35 */     if (!ChildrenManager.canDoAction(this.roleId, 842))
/*     */     {
/*  37 */       return false;
/*     */     }
/*     */     
/*  40 */     Long xOwnRoleId = Children.selectOwn_role_id(Long.valueOf(this.childId));
/*  41 */     if (xOwnRoleId == null)
/*     */     {
/*  43 */       onQueryChildReqFail(2);
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     boolean isRoamServerAndNotOnline = false;
/*  48 */     if ((mzm.gsp.GameServerInfoManager.isRoamServer()) && (!OnlineManager.getInstance().isOnline(xOwnRoleId.longValue())))
/*     */     {
/*  50 */       isRoamServerAndNotOnline = true;
/*     */     }
/*     */     
/*  53 */     if (isRoamServerAndNotOnline)
/*     */     {
/*  55 */       onQueryChildReqFail(2);
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     Long xAnotherParentRoleId = Children.selectAnother_parent_role_id(Long.valueOf(this.childId));
/*  60 */     if (xAnotherParentRoleId == null)
/*     */     {
/*  62 */       onQueryChildReqFail(2);
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     Long xAnotherGiveBirthParentRoleId = Childrengrowthdiary.selectAnother_give_birth_parent_role_id(Long.valueOf(this.childId));
/*  67 */     if (xAnotherGiveBirthParentRoleId == null)
/*     */     {
/*  69 */       onQueryChildReqFail(35);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     Set<Long> roleIdSet = new java.util.HashSet();
/*  74 */     roleIdSet.add(xOwnRoleId);
/*  75 */     if (xAnotherParentRoleId.longValue() > 0L)
/*     */     {
/*  77 */       roleIdSet.add(xAnotherParentRoleId);
/*     */     }
/*     */     
/*  80 */     if (xAnotherGiveBirthParentRoleId.longValue() > 0L)
/*     */     {
/*  82 */       roleIdSet.add(xAnotherGiveBirthParentRoleId);
/*     */     }
/*     */     
/*  85 */     lock(xtable.Role2properties.getTable(), roleIdSet);
/*     */     
/*  87 */     ChildGrowthDiaryInfo xChildGrowthDiaryInfo = Childrengrowthdiary.get(Long.valueOf(this.childId));
/*  88 */     if (xChildGrowthDiaryInfo == null)
/*     */     {
/*  90 */       onQueryChildReqFail(35);
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     ChildInfo xChildInfo = Children.get(Long.valueOf(this.childId));
/*     */     
/*  96 */     SQueryChildInfo sQueryChildInfo = new SQueryChildInfo();
/*  97 */     sQueryChildInfo.child_id = this.childId;
/*  98 */     sQueryChildInfo.child_give_birth_time = ((int)(xChildGrowthDiaryInfo.getGive_birth_time() / 1000L));
/*     */     
/* 100 */     String ownParentName = RoleInterface.getName(xChildInfo.getOwn_role_id());
/* 101 */     Octets octets = new Octets();
/* 102 */     octets.setString(ownParentName, "UTF-8");
/* 103 */     sQueryChildInfo.parents_name_list.add(octets);
/*     */     
/* 105 */     if (xAnotherGiveBirthParentRoleId.longValue() > 0L)
/*     */     {
/* 107 */       String otherParentName = RoleInterface.getName(xAnotherGiveBirthParentRoleId.longValue());
/* 108 */       Octets otherOctets = new Octets();
/* 109 */       otherOctets.setString(otherParentName, "UTF-8");
/* 110 */       sQueryChildInfo.parents_name_list.add(otherOctets);
/*     */     }
/*     */     
/* 113 */     ChildrenManager.fillChildBean(xOwnRoleId.longValue(), this.childId, xChildInfo, sQueryChildInfo.child_bean, true);
/*     */     
/* 115 */     OnlineManager.getInstance().send(this.roleId, sQueryChildInfo);
/*     */     
/* 117 */     return true;
/*     */   }
/*     */   
/*     */   private void onQueryChildReqFail(int ret)
/*     */   {
/* 122 */     onQueryChildReqFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onQueryChildReqFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 127 */     StringBuilder sbLog = new StringBuilder();
/* 128 */     sbLog.append("[children]PCQueryChildReq.processImp@query child failed");
/* 129 */     sbLog.append("|ret=").append(ret);
/* 130 */     sbLog.append("|role_id=").append(this.roleId);
/* 131 */     sbLog.append("|child_id=").append(this.childId);
/* 132 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 134 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 136 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 139 */     mzm.gsp.GameServer.logger().error(sbLog.toString());
/*     */     
/* 141 */     mzm.gsp.children.SChildNormalFail sChildNormalFail = new mzm.gsp.children.SChildNormalFail();
/* 142 */     sChildNormalFail.result = ret;
/*     */     
/* 144 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sChildNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCQueryChildReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */