/*     */ package mzm.gsp.role.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.fabao.main.FabaoInterface;
/*     */ import mzm.gsp.fabaolingqi.main.FabaoArtifactInterface;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemStoreEnum;
/*     */ import mzm.gsp.item.main.RoleEquipBag;
/*     */ import mzm.gsp.mounts.main.MountsInterface;
/*     */ import mzm.gsp.superequipment.wushi.main.WuShiInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.wing.main2.WingInterface;
/*     */ import mzm.gsp.xiulian.main.XiuLianSkillInterface;
/*     */ import xbean.RoleFabaoSysInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoleTLogManager
/*     */ {
/*     */   private static final String T_LOG_ROLE_PROPERTY_DATA = "RolePropertyDataLog";
/*     */   
/*     */   public static void tLogRolePropertyData(long roleId)
/*     */   {
/*  29 */     Role role = RoleInterface.getRole(roleId, true);
/*  30 */     if (role == null)
/*     */     {
/*  32 */       return;
/*     */     }
/*     */     
/*  35 */     List<Object> logColumns = new ArrayList();
/*     */     
/*  37 */     logColumns.add(GameServerInfoManager.getHostIP());
/*  38 */     logColumns.add(role.getUserId());
/*  39 */     logColumns.add(Long.valueOf(role.getId()));
/*  40 */     logColumns.add(Integer.valueOf(role.getLevel()));
/*     */     
/*  42 */     logColumns.add(Integer.valueOf(role.getGender()));
/*  43 */     logColumns.add(Integer.valueOf(role.getOccupationId()));
/*  44 */     logColumns.add(Integer.valueOf(role.getExp()));
/*     */     
/*  46 */     RoleEquipBag equipBag = ItemInterface.getRoleEquipBag(roleId);
/*  47 */     RoleFabaoSysInfo xRoleFaBaoSysInfo = FabaoInterface.getEquipFaBaoSysInfo(roleId, true);
/*     */     
/*  49 */     tLogQiLingLevel(equipBag, logColumns);
/*  50 */     tLogEquipSkillId(equipBag, logColumns);
/*  51 */     tLogSuperEquipmentLevel(equipBag, logColumns);
/*  52 */     tLogEquipBlessLevel(equipBag, logColumns);
/*  53 */     tLogEquipJewelList(equipBag, logColumns);
/*  54 */     tLogWuShiList(roleId, logColumns);
/*     */     
/*  56 */     tLogFaBaoLevel(xRoleFaBaoSysInfo, logColumns);
/*  57 */     tLogLongJingList(xRoleFaBaoSysInfo, logColumns);
/*  58 */     tLogFaBaoLingQiLevel(roleId, logColumns);
/*     */     
/*  60 */     tLogWingSkillList(roleId, logColumns);
/*  61 */     tLogWingLevel(roleId, logColumns);
/*  62 */     tLogWingSpecOutLookList(roleId, logColumns);
/*     */     
/*  64 */     tLogMountRankList(roleId, logColumns);
/*     */     
/*  66 */     tLogXiuLianLevelList(roleId, logColumns);
/*     */     
/*  68 */     TLogManager.getInstance().addLog(role.getUserId(), "RolePropertyDataLog", logColumns.toArray());
/*     */   }
/*     */   
/*     */   private static String getTLogString(Object object)
/*     */   {
/*  73 */     if (object == null)
/*     */     {
/*  75 */       return "0";
/*     */     }
/*  77 */     if ((object instanceof Map))
/*     */     {
/*  79 */       return getMapTLogString((Map)object);
/*     */     }
/*  81 */     if ((object instanceof Collection))
/*     */     {
/*  83 */       return getCollectionTLogString((Collection)object);
/*     */     }
/*  85 */     return object.toString();
/*     */   }
/*     */   
/*     */   private static <K, V> String getMapTLogString(Map<K, V> map)
/*     */   {
/*  90 */     StringBuilder stringBuilder = new StringBuilder();
/*  91 */     boolean isFirst = true;
/*  92 */     for (Map.Entry<K, V> entry : map.entrySet())
/*     */     {
/*  94 */       if (!isFirst)
/*     */       {
/*  96 */         stringBuilder.append("#");
/*     */       }
/*  98 */       stringBuilder.append(getTLogString(entry.getKey())).append("#").append(getTLogString(entry.getValue()));
/*  99 */       isFirst = false;
/*     */     }
/* 101 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private static <V> String getCollectionTLogString(Collection<V> collection)
/*     */   {
/* 106 */     StringBuilder stringBuilder = new StringBuilder();
/* 107 */     boolean isFirst = true;
/* 108 */     for (V value : collection)
/*     */     {
/* 110 */       if (!isFirst)
/*     */       {
/* 112 */         stringBuilder.append("#");
/*     */       }
/* 114 */       stringBuilder.append(getTLogString(value));
/* 115 */       isFirst = false;
/*     */     }
/* 117 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   private static <V> void tLogWearPosExtraInfo(Map<Integer, V> wearPos2extraInfoValue, List<Object> logColumns)
/*     */   {
/* 123 */     for (int i = 0; i <= 5; i++)
/*     */     {
/* 125 */       V value = wearPos2extraInfoValue.get(Integer.valueOf(i));
/* 126 */       logColumns.add(getTLogString(value));
/*     */     }
/*     */   }
/*     */   
/*     */   private static void tLogQiLingLevel(RoleEquipBag equipBag, List<Object> logColumns)
/*     */   {
/* 132 */     Map<Integer, Integer> wearPos2extraInfoValue = ItemInterface.getWearPos2extraInfoValue(equipBag, ItemStoreEnum.STRENGTH_LEVEL);
/*     */     
/* 134 */     tLogWearPosExtraInfo(wearPos2extraInfoValue, logColumns);
/*     */   }
/*     */   
/*     */   private static void tLogEquipSkillId(RoleEquipBag equipBag, List<Object> logColumns)
/*     */   {
/* 139 */     Map<Integer, Integer> wearPos2extraInfoValue = ItemInterface.getWearPos2extraInfoValue(equipBag, ItemStoreEnum.EQUIP_SKILL);
/*     */     
/* 141 */     tLogWearPosExtraInfo(wearPos2extraInfoValue, logColumns);
/*     */   }
/*     */   
/*     */   private static void tLogSuperEquipmentLevel(RoleEquipBag equipBag, List<Object> logColumns)
/*     */   {
/* 146 */     Map<Integer, Integer> wearPos2extraInfoValue = ItemInterface.getWearPos2extraInfoValue(equipBag, ItemStoreEnum.SUPER_EQUIPMENT_LEVEL);
/*     */     
/* 148 */     tLogWearPosExtraInfo(wearPos2extraInfoValue, logColumns);
/*     */   }
/*     */   
/*     */   private static void tLogEquipBlessLevel(RoleEquipBag equipBag, List<Object> logColumns)
/*     */   {
/* 153 */     Map<Integer, Integer> wearPos2extraInfoValue = ItemInterface.getWearPos2extraInfoValue(equipBag, ItemStoreEnum.EQUIPMENT_BLESS_LEVEL);
/*     */     
/* 155 */     tLogWearPosExtraInfo(wearPos2extraInfoValue, logColumns);
/*     */   }
/*     */   
/*     */   private static void tLogEquipJewelList(RoleEquipBag equipBag, List<Object> logColumns)
/*     */   {
/* 160 */     Map<Integer, List<Integer>> wearPos2jewelCfgIdList = ItemInterface.getWearPos2jewelCfgIdList(equipBag);
/* 161 */     tLogWearPosExtraInfo(wearPos2jewelCfgIdList, logColumns);
/*     */   }
/*     */   
/*     */   private static void tLogWuShiList(long roleId, List<Object> logColumns)
/*     */   {
/* 166 */     logColumns.add(getTLogString(WuShiInterface.getRoleActivatedWuShiCfgIds(roleId, true)));
/*     */   }
/*     */   
/*     */ 
/*     */   private static <V> void tLogFaBaoTypeInfo(Map<Integer, V> faBaoType2info, List<Object> logColumns)
/*     */   {
/* 172 */     for (int i = 1; i <= 6; i++)
/*     */     {
/* 174 */       V value = faBaoType2info.get(Integer.valueOf(i));
/* 175 */       logColumns.add(getTLogString(value));
/*     */     }
/*     */   }
/*     */   
/*     */   private static void tLogFaBaoLevel(RoleFabaoSysInfo xRoleFaBaoSysInfo, List<Object> logColumns)
/*     */   {
/* 181 */     tLogFaBaoTypeInfo(FabaoInterface.getFaBaoLevelInfo(xRoleFaBaoSysInfo), logColumns);
/*     */   }
/*     */   
/*     */   private static void tLogLongJingList(RoleFabaoSysInfo xRoleFaBaoSysInfo, List<Object> logColumns)
/*     */   {
/* 186 */     tLogFaBaoTypeInfo(FabaoInterface.getEquipLongJingInfo(xRoleFaBaoSysInfo), logColumns);
/*     */   }
/*     */   
/*     */   private static void tLogFaBaoLingQiLevel(long roleId, List<Object> logColumns)
/*     */   {
/* 191 */     logColumns.add(getTLogString(FabaoArtifactInterface.getArtifactTypeId2level(roleId, true)));
/*     */   }
/*     */   
/*     */   private static void tLogWingSkillList(long roleId, List<Object> logColumns)
/*     */   {
/* 196 */     logColumns.add(getTLogString(WingInterface.getCurWingPlanSkills(roleId, true).keySet()));
/*     */   }
/*     */   
/*     */   private static void tLogWingLevel(long roleId, List<Object> logColumns)
/*     */   {
/* 201 */     logColumns.add(getTLogString(Integer.valueOf(WingInterface.getRoleWingLevel(roleId, true))));
/*     */   }
/*     */   
/*     */   private static void tLogWingSpecOutLookList(long roleId, List<Object> logColumns)
/*     */   {
/* 206 */     logColumns.add(getTLogString(WingInterface.getRoleWingInfoCfgIdsByOutLook(roleId, true, 2)));
/*     */   }
/*     */   
/*     */   private static void tLogMountRankList(long roleId, List<Object> logColumns)
/*     */   {
/* 211 */     logColumns.add(getTLogString(MountsInterface.getMountCfgId2maxRank(roleId, true)));
/*     */   }
/*     */   
/*     */   private static void tLogXiuLianLevelList(long roleId, List<Object> logColumns)
/*     */   {
/* 216 */     logColumns.add(getTLogString(XiuLianSkillInterface.getXiuLianSkill(roleId)));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */