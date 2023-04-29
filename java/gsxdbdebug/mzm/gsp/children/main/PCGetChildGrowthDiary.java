/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.GrowthInfo;
/*     */ import mzm.gsp.children.SGetChildGrowthDiaryInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import xbean.ChildGrowthDiaryInfo;
/*     */ import xbean.ChildGrowthInfo;
/*     */ import xtable.Children;
/*     */ 
/*     */ public class PCGetChildGrowthDiary extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long childId;
/*     */   
/*     */   public PCGetChildGrowthDiary(long roleId, long childId)
/*     */   {
/*  23 */     this.roleId = roleId;
/*  24 */     this.childId = childId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleId))
/*     */     {
/*  32 */       onGetChildGrowthDiaryFail(21);
/*  33 */       return false;
/*     */     }
/*     */     
/*  36 */     if (!ChildrenManager.isFunOpen(this.roleId))
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     if (!ChildrenManager.canDoAction(this.roleId, 839))
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     Long xOwnRoleId = Children.selectOwn_role_id(Long.valueOf(this.childId));
/*  47 */     if (xOwnRoleId == null)
/*     */     {
/*  49 */       onGetChildGrowthDiaryFail(2);
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     Long xAnotherParentRoleId = Children.selectAnother_parent_role_id(Long.valueOf(this.childId));
/*  54 */     if (xAnotherParentRoleId == null)
/*     */     {
/*  56 */       onGetChildGrowthDiaryFail(2);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     Long xAnotherGiveBirthParentRoleId = xtable.Childrengrowthdiary.selectAnother_give_birth_parent_role_id(Long.valueOf(this.childId));
/*  61 */     if (xAnotherGiveBirthParentRoleId == null)
/*     */     {
/*  63 */       onGetChildGrowthDiaryFail(35);
/*  64 */       return false;
/*     */     }
/*  66 */     Set<Long> roleIdSet = new java.util.HashSet();
/*  67 */     roleIdSet.add(xOwnRoleId);
/*  68 */     if (xAnotherParentRoleId.longValue() > 0L)
/*     */     {
/*  70 */       roleIdSet.add(xAnotherParentRoleId);
/*     */     }
/*     */     
/*  73 */     if (xAnotherGiveBirthParentRoleId.longValue() > 0L)
/*     */     {
/*  75 */       roleIdSet.add(xAnotherGiveBirthParentRoleId);
/*     */     }
/*     */     
/*  78 */     lock(xtable.Role2properties.getTable(), roleIdSet);
/*     */     
/*     */ 
/*  81 */     xbean.ChildInfo xChildInfo = Children.get(Long.valueOf(this.childId));
/*  82 */     if (xChildInfo == null)
/*     */     {
/*  84 */       onGetChildGrowthDiaryFail(2);
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     if ((xOwnRoleId.longValue() != this.roleId) && (xAnotherParentRoleId.longValue() != this.roleId))
/*     */     {
/*  90 */       onGetChildGrowthDiaryFail(1);
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     ChildGrowthDiaryInfo xChildGrowthDiaryInfo = xtable.Childrengrowthdiary.get(Long.valueOf(this.childId));
/*  95 */     if (xChildGrowthDiaryInfo == null)
/*     */     {
/*  97 */       onGetChildGrowthDiaryFail(35);
/*  98 */       return false;
/*     */     }
/*     */     
/* 101 */     SGetChildGrowthDiaryInfo sGetChildGrowthDiaryInfo = new SGetChildGrowthDiaryInfo();
/* 102 */     sGetChildGrowthDiaryInfo.child_id = this.childId;
/* 103 */     sGetChildGrowthDiaryInfo.adult_begin_time = (xChildGrowthDiaryInfo.getAdult_begin_time() / 1000L);
/* 104 */     if (xAnotherGiveBirthParentRoleId.longValue() != -1L)
/*     */     {
/* 106 */       String anotherParentName = mzm.gsp.role.main.RoleInterface.getName(xAnotherGiveBirthParentRoleId.longValue());
/* 107 */       sGetChildGrowthDiaryInfo.another_parent_name.setString(anotherParentName, "UTF-8");
/*     */     }
/* 109 */     sGetChildGrowthDiaryInfo.child_hood_begin_time = (xChildGrowthDiaryInfo.getChildhood_begin_time() / 1000L);
/* 110 */     sGetChildGrowthDiaryInfo.give_birth_time = (xChildGrowthDiaryInfo.getGive_birth_time() / 1000L);
/* 111 */     String ownRoleName = mzm.gsp.role.main.RoleInterface.getName(xOwnRoleId.longValue());
/* 112 */     sGetChildGrowthDiaryInfo.own_role_name.setString(ownRoleName, "UTF-8");
/* 113 */     for (ChildGrowthInfo xChildGrowthInfo : xChildGrowthDiaryInfo.getGrowth_info_list())
/*     */     {
/* 115 */       GrowthInfo growthInfo = new GrowthInfo();
/* 116 */       growthInfo.grow_type = xChildGrowthInfo.getGrow_type();
/* 117 */       growthInfo.growth_time = (xChildGrowthInfo.getGrow_time() / 1000L);
/* 118 */       growthInfo.int_parameter_map.putAll(xChildGrowthInfo.getInt_parameter_map());
/* 119 */       for (Map.Entry<Integer, String> entry : xChildGrowthInfo.getString_parameter_map().entrySet())
/*     */       {
/* 121 */         Octets octets = new Octets();
/* 122 */         octets.setString((String)entry.getValue(), "UTF-8");
/* 123 */         growthInfo.string_parameter_map.put(entry.getKey(), octets);
/*     */       }
/* 125 */       sGetChildGrowthDiaryInfo.growth_diary.add(growthInfo);
/*     */     }
/*     */     
/* 128 */     OnlineManager.getInstance().send(this.roleId, sGetChildGrowthDiaryInfo);
/*     */     
/* 130 */     GameServer.logger().info(String.format("[children]PCGetChildGrowthDiary.processImp@get child grow diary success|role_id=%d|child_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.childId) }));
/*     */     
/*     */ 
/*     */ 
/* 134 */     return true;
/*     */   }
/*     */   
/*     */   private void onGetChildGrowthDiaryFail(int ret)
/*     */   {
/* 139 */     onGetChildGrowthDiaryFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onGetChildGrowthDiaryFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 144 */     StringBuilder sbLog = new StringBuilder();
/* 145 */     sbLog.append("[children]PCGetChildGrowthDiary.processImp@get child growth diary failed");
/* 146 */     sbLog.append("|ret=").append(ret);
/* 147 */     sbLog.append("|role_id=").append(this.roleId);
/* 148 */     sbLog.append("|child_id=").append(this.childId);
/* 149 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 151 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 153 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 156 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 158 */     mzm.gsp.children.SChildNormalFail sChildNormalFail = new mzm.gsp.children.SChildNormalFail();
/* 159 */     sChildNormalFail.result = ret;
/*     */     
/* 161 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sChildNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCGetChildGrowthDiary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */