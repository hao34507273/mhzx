/*     */ package mzm.gsp.groupshopping.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.util.Pair;
/*     */ import xbean.BigGroupShoppingItemInfo;
/*     */ import xbean.ShoppingGroupInfo;
/*     */ import xbean.SmallGroupShoppingItemInfo;
/*     */ 
/*     */ public class GroupShoppingMergeModule implements mzm.gsp.MergeModule
/*     */ {
/*  14 */   private final long mainZoneId = mzm.gsp.MergeMain.getMainZoneid();
/*  15 */   private final long viceZoneId = mzm.gsp.MergeMain.getViceZoneid();
/*     */   
/*     */ 
/*     */   public List<xdb.Table> getHandleTables()
/*     */   {
/*  20 */     List<xdb.Table> tables = new java.util.ArrayList();
/*  21 */     tables.add(xtable.Shopping_group_info.getTable());
/*  22 */     tables.add(xtable.Group_shopping_info.getTable());
/*  23 */     tables.add(xtable.Role2group_shopping_records.getTable());
/*  24 */     tables.add(xtable.Group_shopping_ban_info.getTable());
/*  25 */     return tables;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  31 */     mergeGroupShoppingInfo();
/*  32 */     mergeGroupShoppingBanInfo();
/*  33 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void mergeGroupShoppingInfo()
/*     */   {
/*  42 */     for (java.util.Iterator i$ = mzm.gsp.groupshopping.confbean.GroupShoppingActivityCfg.getAll().keySet().iterator(); i$.hasNext();) { activityId = (Integer)i$.next();
/*     */       
/*     */ 
/*  45 */       final List<Pair<Long, Long>> groupsToMerge = new java.util.ArrayList();
/*  46 */       new mzm.gsp.util.LogicProcedure()
/*     */       {
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/*  51 */           long mainKey = mzm.gsp.GameServerInfoManager.toGlobalId(activityId.intValue(), GroupShoppingMergeModule.this.mainZoneId);
/*  52 */           long viceKey = mzm.gsp.GameServerInfoManager.toGlobalId(activityId.intValue(), GroupShoppingMergeModule.this.viceZoneId);
/*  53 */           lock(xtable.Group_shopping_info.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */           
/*  55 */           xbean.GroupShoppingInfo xMainInfo = xtable.Group_shopping_info.get(Long.valueOf(mainKey));
/*  56 */           xbean.GroupShoppingInfo xViceInfo = xtable.Group_shopping_info.get(Long.valueOf(viceKey));
/*  57 */           if (xViceInfo == null)
/*  58 */             return false;
/*  59 */           if (xMainInfo == null)
/*     */           {
/*  61 */             xtable.Group_shopping_info.add(Long.valueOf(mainKey), xViceInfo.copy());
/*     */           }
/*     */           else
/*     */           {
/*  65 */             GroupShoppingMergeModule.this.mergeSmallGroupInfo(xMainInfo.getSmall_group_infos(), xViceInfo.getSmall_group_infos());
/*  66 */             GroupShoppingMergeModule.this.mergeIncompletedSmallGroups(xMainInfo.getIncompleted_small_groups(), xViceInfo.getIncompleted_small_groups());
/*     */             
/*  68 */             GroupShoppingMergeModule.this.mergeBigGroupInfo(xMainInfo.getBig_group_infos(), xViceInfo.getBig_group_infos(), groupsToMerge);
/*     */           }
/*     */           
/*  71 */           xtable.Group_shopping_info.remove(Long.valueOf(viceKey));
/*  72 */           return true;
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*  78 */       }.call();
/*  79 */       final Map<Pair<Long, Long>, Set<Long>> rolesToModify = new java.util.HashMap();
/*  80 */       for (final Pair<Long, Long> groupIds : groupsToMerge) {
/*  81 */         new mzm.gsp.util.LogicProcedure()
/*     */         {
/*     */           protected boolean processImp()
/*     */             throws Exception
/*     */           {
/*  86 */             ShoppingGroupInfo xMainGroup = xtable.Shopping_group_info.get((Long)groupIds.first);
/*  87 */             if (xMainGroup == null)
/*  88 */               return false;
/*  89 */             ShoppingGroupInfo xViceGroup = xtable.Shopping_group_info.get((Long)groupIds.second);
/*  90 */             if (xViceGroup == null) {
/*  91 */               return false;
/*     */             }
/*  93 */             xMainGroup.getMembers().addAll(xViceGroup.getMembers());
/*  94 */             rolesToModify.put(groupIds, xViceGroup.getMembers());
/*  95 */             xtable.Shopping_group_info.remove((Long)groupIds.second);
/*  96 */             return true;
/*     */           }
/*     */         }.call();
/*     */       }
/*     */       
/*     */ 
/* 102 */       for (final Map.Entry<Pair<Long, Long>, Set<Long>> entry : rolesToModify.entrySet()) {
/* 103 */         new mzm.gsp.util.LogicProcedure()
/*     */         {
/*     */           protected boolean processImp()
/*     */             throws Exception
/*     */           {
/* 108 */             long newGroupId = ((Long)((Pair)entry.getKey()).first).longValue();
/* 109 */             long oldGroupId = ((Long)((Pair)entry.getKey()).second).longValue();
/* 110 */             lock(xtable.Role2group_shopping_records.getTable(), (java.util.Collection)entry.getValue());
/*     */             
/* 112 */             for (Long roleId : (Set)entry.getValue())
/*     */             {
/* 114 */               xbean.RoleGroupShoppingRecords xRoleRecords = xtable.Role2group_shopping_records.get(roleId);
/* 115 */               if (xRoleRecords != null)
/*     */               {
/* 117 */                 xbean.RoleGroupShoppingRecord xRoleRecord = (xbean.RoleGroupShoppingRecord)xRoleRecords.getRecords().get(activityId);
/* 118 */                 if (xRoleRecord != null)
/*     */                 {
/* 120 */                   int index = xRoleRecord.getParticipating_groups().indexOf(Long.valueOf(oldGroupId));
/* 121 */                   if (index != -1)
/* 122 */                     xRoleRecord.getParticipating_groups().set(index, Long.valueOf(newGroupId));
/*     */                 } } }
/* 124 */             return true;
/*     */           }
/*     */         }.call();
/*     */       }
/*     */     }
/*     */     
/*     */     final Integer activityId;
/*     */   }
/*     */   
/*     */   private void mergeIncompletedSmallGroups(Set<Long> xMainSet, Set<Long> xViceSet)
/*     */   {
/* 135 */     xMainSet.addAll(xViceSet);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void mergeSmallGroupInfo(Map<Integer, SmallGroupShoppingItemInfo> xMainMap, Map<Integer, SmallGroupShoppingItemInfo> xViceMap)
/*     */   {
/* 144 */     for (Map.Entry<Integer, SmallGroupShoppingItemInfo> entry : xViceMap.entrySet())
/*     */     {
/* 146 */       SmallGroupShoppingItemInfo xMainItemInfo = (SmallGroupShoppingItemInfo)xMainMap.get(entry.getKey());
/* 147 */       SmallGroupShoppingItemInfo xViceItemInfo = (SmallGroupShoppingItemInfo)entry.getValue();
/* 148 */       if (xMainItemInfo == null)
/*     */       {
/* 150 */         xMainMap.put(entry.getKey(), xViceItemInfo.copy());
/*     */       }
/*     */       else
/*     */       {
/* 154 */         xMainItemInfo.setRemaining_num(xMainItemInfo.getRemaining_num() + xViceItemInfo.getRemaining_num());
/*     */       }
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
/*     */   private void mergeBigGroupInfo(Map<Integer, BigGroupShoppingItemInfo> xMainMap, Map<Integer, BigGroupShoppingItemInfo> xViceMap, List<Pair<Long, Long>> groupsToMerge)
/*     */   {
/* 171 */     for (Map.Entry<Integer, BigGroupShoppingItemInfo> entry : xViceMap.entrySet())
/*     */     {
/* 173 */       BigGroupShoppingItemInfo xMainItemInfo = (BigGroupShoppingItemInfo)xMainMap.get(entry.getKey());
/* 174 */       BigGroupShoppingItemInfo xViceItemInfo = (BigGroupShoppingItemInfo)entry.getValue();
/* 175 */       if (xMainItemInfo == null)
/*     */       {
/* 177 */         xMainMap.put(entry.getKey(), xViceItemInfo.copy());
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 182 */         ShoppingGroupInfo xMainGroup = xMainItemInfo.getGroup_id() == 0L ? null : xtable.Shopping_group_info.select(Long.valueOf(xMainItemInfo.getGroup_id()));
/*     */         
/* 184 */         ShoppingGroupInfo xViceGroup = xViceItemInfo.getGroup_id() == 0L ? null : xtable.Shopping_group_info.select(Long.valueOf(xViceItemInfo.getGroup_id()));
/*     */         
/*     */         int mainStatus;
/*     */         
/*     */         int mainStatus;
/* 189 */         if (xMainGroup == null) {
/* 190 */           mainStatus = 0; } else { int mainStatus;
/* 191 */           if (xMainGroup.getStatus() == 0) {
/* 192 */             mainStatus = 1;
/*     */           } else
/* 194 */             mainStatus = 2; }
/*     */         int viceStatus;
/* 196 */         int viceStatus; if (xViceGroup == null) {
/* 197 */           viceStatus = 0; } else { int viceStatus;
/* 198 */           if (xViceGroup.getStatus() == 0) {
/* 199 */             viceStatus = 1;
/*     */           } else {
/* 201 */             viceStatus = 2;
/*     */           }
/*     */         }
/* 204 */         if (((mainStatus == 0) && (viceStatus != 0)) || ((mainStatus != 1) && (viceStatus == 1)))
/*     */         {
/* 206 */           xMainItemInfo.setRemaining_num(xViceItemInfo.getRemaining_num());
/* 207 */           xMainItemInfo.setGroup_id(xViceItemInfo.getGroup_id());
/*     */ 
/*     */         }
/* 210 */         else if ((mainStatus == 1) && (viceStatus == 1))
/*     */         {
/* 212 */           xMainItemInfo.setRemaining_num(xMainItemInfo.getRemaining_num() + xViceItemInfo.getRemaining_num());
/* 213 */           groupsToMerge.add(new Pair(Long.valueOf(xMainItemInfo.getGroup_id()), Long.valueOf(xViceItemInfo.getGroup_id())));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void mergeGroupShoppingBanInfo()
/*     */   {
/* 224 */     for (final Integer activityId : mzm.gsp.groupshopping.confbean.GroupShoppingActivityCfg.getAll().keySet())
/*     */     {
/* 226 */       new mzm.gsp.util.LogicProcedure()
/*     */       {
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/* 231 */           long mainKey = mzm.gsp.GameServerInfoManager.toGlobalId(activityId.intValue(), GroupShoppingMergeModule.this.mainZoneId);
/* 232 */           long viceKey = mzm.gsp.GameServerInfoManager.toGlobalId(activityId.intValue(), GroupShoppingMergeModule.this.viceZoneId);
/* 233 */           lock(xtable.Group_shopping_ban_info.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */           
/* 235 */           xbean.GroupShoppingBanInfo xMainBanInfo = xtable.Group_shopping_ban_info.get(Long.valueOf(mainKey));
/* 236 */           xbean.GroupShoppingBanInfo xViceBanInfo = xtable.Group_shopping_ban_info.get(Long.valueOf(viceKey));
/* 237 */           if (xViceBanInfo == null)
/* 238 */             return false;
/* 239 */           if (xMainBanInfo == null)
/*     */           {
/* 241 */             xMainBanInfo = xbean.Pod.newGroupShoppingBanInfo();
/* 242 */             xtable.Group_shopping_ban_info.add(Long.valueOf(mainKey), xMainBanInfo);
/*     */           }
/* 244 */           xMainBanInfo.getBanned_group_shopping_items().addAll(xViceBanInfo.getBanned_group_shopping_items());
/* 245 */           xtable.Group_shopping_ban_info.remove(Long.valueOf(viceKey));
/* 246 */           return true;
/*     */         }
/*     */       }.call();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\main\GroupShoppingMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */