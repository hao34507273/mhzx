/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SAddChild;
/*     */ import mzm.gsp.children.SChildNormalFail;
/*     */ import mzm.gsp.children.SUseAdulthoodChildrenCompensateSuccess;
/*     */ import mzm.gsp.children.confbean.EquipPosBean;
/*     */ import mzm.gsp.children.confbean.OccupationSkillBean;
/*     */ import mzm.gsp.children.confbean.SAdulthoodChildrenCompensateCfg;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.children.event.AddChildIntoHome;
/*     */ import mzm.gsp.children.event.ChildAddHomeReason;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.common.confbean.STimePointCommonCfg;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.item.confbean.SAdulthoodChildrenCompensateItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemStoreEnum;
/*     */ import mzm.gsp.item.main.PetEquipmentItem;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.petequip.confbean.SPetEquipItem;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AdulthoodInfo;
/*     */ import xbean.ChildGrowthDiaryInfo;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.Item;
/*     */ import xbean.Role2ChildrenInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCUseAdulthoodChildrenCompensate extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long uuid;
/*     */   private int itemCfgId;
/*     */   
/*     */   public PCUseAdulthoodChildrenCompensate(long roleId, long uuid)
/*     */   {
/*  52 */     this.roleId = roleId;
/*  53 */     this.uuid = uuid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  59 */     String userId = RoleInterface.getUserId(this.roleId);
/*  60 */     if (userId == null)
/*     */     {
/*  62 */       onFail(55);
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     long marriedId = MarriageInterface.getMarriedId(this.roleId, false);
/*     */     
/*  68 */     long marriedRoleId = MarriageInterface.getMarriedRoleid(this.roleId, false);
/*  69 */     if (marriedRoleId > 0L)
/*     */     {
/*  71 */       String marriedUserId = RoleInterface.getUserId(marriedRoleId);
/*  72 */       lock(User.getTable(), Arrays.asList(new String[] { userId, marriedUserId }));
/*  73 */       lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(marriedRoleId) }));
/*     */     }
/*     */     else
/*     */     {
/*  77 */       lock(Lockeys.get(User.getTable(), userId));
/*  78 */       lock(Lockeys.get(Role2properties.getTable(), Long.valueOf(this.roleId)));
/*     */     }
/*     */     
/*  81 */     if (marriedId > 0L)
/*     */     {
/*  83 */       lock(Lockeys.get(xtable.Marriage.getTable(), Long.valueOf(marriedId)));
/*     */     }
/*     */     
/*  86 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 847, true, true))
/*     */     {
/*  88 */       onFail(71);
/*  89 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  93 */     BasicItem basicItem = ItemInterface.getItemByUuid(this.roleId, this.uuid);
/*  94 */     if (basicItem == null)
/*     */     {
/*  96 */       onFail(56);
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     this.itemCfgId = basicItem.getCfgId();
/* 101 */     SAdulthoodChildrenCompensateItemCfg itemCfg = SAdulthoodChildrenCompensateItemCfg.get(this.itemCfgId);
/* 102 */     if (itemCfg == null)
/*     */     {
/* 104 */       onFail(57);
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     int compensateCfgId = itemCfg.compensate_cfg_id;
/* 109 */     SAdulthoodChildrenCompensateCfg compensateCfg = SAdulthoodChildrenCompensateCfg.get(compensateCfgId);
/* 110 */     if (compensateCfg == null)
/*     */     {
/* 112 */       onFail(58);
/* 113 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 117 */     int ownChildSize = ChildrenManager.getOwnChildSize(this.roleId, true);
/*     */     
/*     */ 
/* 120 */     int realCheckChildSize = ownChildSize;
/* 121 */     BreedInfo breedInfo = ChildrenManager.getBreedInfo(this.roleId, true);
/* 122 */     if ((breedInfo != null) && (breedInfo.belongRoleId == this.roleId))
/*     */     {
/* 124 */       realCheckChildSize++;
/*     */     }
/*     */     
/* 127 */     if (realCheckChildSize >= SChildrenConsts.getInstance().max_children_can_carrey)
/*     */     {
/* 129 */       Map<String, Object> extraMap = new HashMap();
/* 130 */       extraMap.put("own_child_size", Integer.valueOf(ownChildSize));
/* 131 */       extraMap.put("real_check_child_size", Integer.valueOf(realCheckChildSize));
/* 132 */       extraMap.put("max_carry_size", Integer.valueOf(SChildrenConsts.getInstance().max_children_can_carrey));
/*     */       
/* 134 */       onFail(59, extraMap);
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     boolean isOwnHome = HomelandInterface.hasHome(this.roleId);
/* 139 */     if (!isOwnHome)
/*     */     {
/* 141 */       onFail(10);
/* 142 */       return false;
/*     */     }
/*     */     
/* 145 */     boolean removeResult = ItemInterface.removeItemByUuid(this.roleId, this.uuid, 1, new mzm.gsp.tlog.TLogArg(LogReason.CHILD_CONPENSATE_REMOVE, this.itemCfgId));
/*     */     
/* 147 */     if (!removeResult)
/*     */     {
/* 149 */       onFail(70);
/* 150 */       return false;
/*     */     }
/*     */     
/* 153 */     Role2ChildrenInfo xRole2ChildrenInfo = ChildrenManager.initAndGetChildrenInfo(this.roleId);
/*     */     
/* 155 */     STimePointCommonCfg giveBirthTimePointCommonCfg = STimePointCommonCfg.get(compensateCfg.give_birth_time_point_cfg_id);
/* 156 */     if (giveBirthTimePointCommonCfg == null)
/*     */     {
/* 158 */       onFail(60);
/* 159 */       return false;
/*     */     }
/*     */     
/* 162 */     long giveBirthTime = TimeCommonUtil.getTimePoint(giveBirthTimePointCommonCfg);
/* 163 */     ChildInfo xChildInfo = ChildrenManager.generatorChild(this.roleId, giveBirthTime);
/* 164 */     long childId = xtable.Children.insert(xChildInfo).longValue();
/*     */     
/* 166 */     ChildGrowthDiaryInfo xChildGrowthDiaryInfo = ChildrenManager.generatorChildGrowthDiary(giveBirthTime, childId);
/*     */     
/*     */ 
/*     */ 
/* 170 */     xChildInfo.setOwn_role_id(this.roleId);
/*     */     
/* 172 */     xChildInfo.setChild_gender(compensateCfg.gender);
/*     */     
/* 174 */     xChildInfo.setChild_name(compensateCfg.name);
/*     */     
/* 176 */     xChildInfo.setChild_period(2);
/* 177 */     if (marriedRoleId > 0L)
/*     */     {
/* 179 */       xChildInfo.setAnother_parent_role_id(marriedRoleId);
/*     */     }
/*     */     
/*     */ 
/* 183 */     int begInIndex = compensateCfg.another_give_birth_parent_role_id.indexOf('[');
/* 184 */     int endIndex = compensateCfg.another_give_birth_parent_role_id.indexOf(']');
/* 185 */     if ((begInIndex == -1) || (endIndex == -1))
/*     */     {
/* 187 */       onFail(67);
/* 188 */       return false;
/*     */     }
/* 190 */     String anotherParentRoleId = compensateCfg.another_give_birth_parent_role_id.substring(begInIndex + 1, endIndex);
/*     */     
/* 192 */     xChildGrowthDiaryInfo.setAnother_give_birth_parent_role_id(Long.valueOf(anotherParentRoleId).longValue());
/*     */     
/*     */ 
/* 195 */     STimePointCommonCfg stepInChildhoodTimePointCommonCfg = STimePointCommonCfg.get(compensateCfg.step_in_childhood_time_point_cfg_id);
/* 196 */     if (stepInChildhoodTimePointCommonCfg == null)
/*     */     {
/* 198 */       onFail(65);
/* 199 */       return false;
/*     */     }
/* 201 */     xChildGrowthDiaryInfo.setChildhood_begin_time(TimeCommonUtil.getTimePoint(stepInChildhoodTimePointCommonCfg));
/*     */     
/*     */ 
/* 204 */     STimePointCommonCfg stepInAdulthoodTimePointCommonCfg = STimePointCommonCfg.get(compensateCfg.step_in_adulthood_time_point_cfg_id);
/* 205 */     if (stepInAdulthoodTimePointCommonCfg == null)
/*     */     {
/* 207 */       onFail(66);
/* 208 */       return false;
/*     */     }
/*     */     
/* 211 */     xChildGrowthDiaryInfo.setAdult_begin_time(TimeCommonUtil.getTimePoint(stepInAdulthoodTimePointCommonCfg));
/*     */     
/* 213 */     int childrenModelCfgid = compensateCfg.model_cfg_id;
/* 214 */     Map<Integer, Integer> aptMap = new HashMap();
/* 215 */     aptMap.put(Integer.valueOf(1), Integer.valueOf(compensateCfg.hp_apt));
/* 216 */     aptMap.put(Integer.valueOf(3), Integer.valueOf(compensateCfg.magatk_apt));
/* 217 */     aptMap.put(Integer.valueOf(5), Integer.valueOf(compensateCfg.magdef_apt));
/* 218 */     aptMap.put(Integer.valueOf(2), Integer.valueOf(compensateCfg.phyatk_apt));
/* 219 */     aptMap.put(Integer.valueOf(4), Integer.valueOf(compensateCfg.phydef_apt));
/* 220 */     aptMap.put(Integer.valueOf(6), Integer.valueOf(compensateCfg.speed_apt));
/* 221 */     ChildrenManager.stepInAdulthood(childrenModelCfgid, xChildInfo, aptMap);
/*     */     
/*     */ 
/* 224 */     ChildrenManager.checkBabyModelCfgId(xChildInfo);
/*     */     
/*     */ 
/* 227 */     mzm.gsp.children.childhood.ChildhoodManager.checkModelCfgid(childId, xChildInfo);
/*     */     
/* 229 */     xRole2ChildrenInfo.getChild_id_list().add(Long.valueOf(childId));
/*     */     
/*     */ 
/* 232 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(xChildInfo);
/* 233 */     xAdulthoodInfo.setCharacter(compensateCfg.character);
/* 234 */     xAdulthoodInfo.setGrow((float)compensateCfg.grow);
/* 235 */     xAdulthoodInfo.setOccupation(compensateCfg.occupation);
/* 236 */     xAdulthoodInfo.setUnlockskillposnum(compensateCfg.unlock_skill_pos_num);
/* 237 */     if (compensateCfg.special_skill > 0)
/*     */     {
/* 239 */       xAdulthoodInfo.setSpecialskillid(compensateCfg.special_skill);
/*     */     }
/*     */     
/*     */ 
/* 243 */     for (Map.Entry<Integer, Item> entry : xAdulthoodInfo.getEquipitem().entrySet())
/*     */     {
/* 245 */       int wearPos = ((Integer)entry.getKey()).intValue();
/* 246 */       Item xItem = (Item)entry.getValue();
/*     */       
/* 248 */       EquipPosBean equipPosBean = (EquipPosBean)compensateCfg.equip_pos_list.get(wearPos - 1);
/*     */       
/* 250 */       Map<Integer, Integer> xExtraMap = xItem.getExtra();
/* 251 */       xExtraMap.put(Integer.valueOf(ItemStoreEnum.CHILDREN_EQUIP_EXP.getStoreType()), Integer.valueOf(equipPosBean.equip_pos_exp));
/* 252 */       xExtraMap.put(Integer.valueOf(ItemStoreEnum.CHILDREN_EQUIP_LEVEL.getStoreType()), Integer.valueOf(equipPosBean.equip_pos_level));
/* 253 */       xExtraMap.put(Integer.valueOf(ItemStoreEnum.CHILDREN_EQUIP_STAGE.getStoreType()), Integer.valueOf(equipPosBean.equip_pos_stage));
/* 254 */       xExtraMap.put(Integer.valueOf(ItemStoreEnum.CHILDREN_EQUIP_PROP_A.getStoreType()), Integer.valueOf(equipPosBean.equip_pos_pro));
/*     */     }
/*     */     
/*     */ 
/* 258 */     for (OccupationSkillBean occupationSkillBean : compensateCfg.occupation_skill_list)
/*     */     {
/* 260 */       xAdulthoodInfo.getOccupationskill2value().put(Integer.valueOf(occupationSkillBean.occupation_skill), Integer.valueOf(occupationSkillBean.occupation_skill_level));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 265 */     for (Integer studySkillId : compensateCfg.study_skill_list)
/*     */     {
/* 267 */       xAdulthoodInfo.getSkillbookskills().add(studySkillId);
/*     */     }
/*     */     
/* 270 */     SPetEquipItem petEquipItemCfg = SPetEquipItem.get(compensateCfg.equip_pos_4_amulet_item_cfg_id);
/* 271 */     if (petEquipItemCfg != null)
/*     */     {
/* 273 */       if (petEquipItemCfg.equipType != 2)
/*     */       {
/* 275 */         onFail(69);
/* 276 */         return false;
/*     */       }
/*     */       
/* 279 */       List<Item> xItemList = ItemInterface.createXItem(compensateCfg.equip_pos_4_amulet_item_cfg_id, 1);
/*     */       
/* 281 */       Item xItem = (Item)xItemList.get(0);
/*     */       
/* 283 */       xAdulthoodInfo.getEquippetitem().put(Integer.valueOf(petEquipItemCfg.equipType), xItem);
/* 284 */       PetEquipmentItem petEquipmentItem = new PetEquipmentItem(xItem);
/* 285 */       petEquipmentItem.setSkills(compensateCfg.amulet_skill_list);
/*     */     }
/*     */     
/* 288 */     Map<Integer, Integer> xBasePropMap = xAdulthoodInfo.getBasepropset();
/*     */     
/* 290 */     xBasePropMap.put(Integer.valueOf(25), Integer.valueOf(compensateCfg.str_point));
/* 291 */     xBasePropMap.put(Integer.valueOf(26), Integer.valueOf(compensateCfg.dex_point));
/* 292 */     xBasePropMap.put(Integer.valueOf(27), Integer.valueOf(compensateCfg.spr_point));
/* 293 */     xBasePropMap.put(Integer.valueOf(28), Integer.valueOf(compensateCfg.con_point));
/* 294 */     xBasePropMap.put(Integer.valueOf(29), Integer.valueOf(compensateCfg.sta_point));
/*     */     
/* 296 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/* 298 */     xAdulthoodInfo.setPotentialpoint(SChildrenConsts.getInstance().child_level_up_add_potential_num * roleLevel);
/*     */     
/*     */ 
/* 301 */     ChildrenOutFightObj childrenOutFightObj = ChildrenManager.getChildrenOutFightObj(this.roleId, childId, xChildInfo);
/* 302 */     childrenOutFightObj.autoSetPotentialPoint();
/*     */     
/* 304 */     childrenOutFightObj.updateOutFightProperty();
/*     */     
/* 306 */     ChildrenManager.trigChildrenEvent(new AddChildIntoHome(), new mzm.gsp.children.event.AddChildIntoHomeArg(this.roleId, childId, HomelandInterface.getCurrentHomeMapId(this.roleId), ChildAddHomeReason.GIVE_BIRTH));
/*     */     
/*     */ 
/*     */ 
/* 310 */     SUseAdulthoodChildrenCompensateSuccess success = new SUseAdulthoodChildrenCompensateSuccess();
/* 311 */     OnlineManager.getInstance().send(this.roleId, success);
/*     */     
/* 313 */     SAddChild sAddChild = new SAddChild();
/* 314 */     sAddChild.child_id = childId;
/*     */     
/* 316 */     ChildrenManager.fillChildBean(this.roleId, childId, xChildInfo, sAddChild.child_info, true);
/*     */     
/* 318 */     OnlineManager.getInstance().send(this.roleId, sAddChild);
/* 319 */     if (marriedId > 0L)
/*     */     {
/* 321 */       OnlineManager.getInstance().send(marriedRoleId, sAddChild);
/*     */     }
/*     */     
/* 324 */     tlogUseAdulthoodChildrenCompensate(userId, marriedRoleId, childId, roleLevel);
/*     */     
/*     */ 
/* 327 */     ChildrenManager.triggerChildRatingChange(this.roleId, childId, false);
/*     */     
/* 329 */     StringBuilder sbLog = new StringBuilder();
/* 330 */     sbLog.append("[children]PCUseAdulthoodChildrenCompensate.processImp@compensate child success");
/* 331 */     sbLog.append("|role_id=").append(this.roleId);
/* 332 */     sbLog.append("|uuid=").append(this.uuid);
/* 333 */     sbLog.append("|item_cfg_id=").append(this.itemCfgId);
/* 334 */     sbLog.append("|child_id=").append(childId);
/*     */     
/* 336 */     GameServer.logger().info(sbLog.toString());
/*     */     
/* 338 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int ret)
/*     */   {
/* 343 */     onFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 348 */     StringBuilder sbLog = new StringBuilder();
/* 349 */     sbLog.append("[children]PCUseAdulthoodChildrenCompensate.processImp@compensate child failed");
/* 350 */     sbLog.append("|ret=").append(ret);
/* 351 */     sbLog.append("|role_id=").append(this.roleId);
/* 352 */     sbLog.append("|uuid=").append(this.uuid);
/* 353 */     sbLog.append("|item_cfg_id=").append(this.itemCfgId);
/*     */     
/* 355 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 357 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 359 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 362 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 364 */     SChildNormalFail sChildNormalFail = new SChildNormalFail();
/* 365 */     sChildNormalFail.result = ret;
/*     */     
/* 367 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sChildNormalFail);
/*     */   }
/*     */   
/*     */ 
/*     */   private void tlogUseAdulthoodChildrenCompensate(String userId, long partnerRoleId, long childId, int roleLevel)
/*     */   {
/* 373 */     StringBuilder sbLog = new StringBuilder();
/* 374 */     sbLog.append(mzm.gsp.GameServerInfoManager.getHostIP()).append('|');
/* 375 */     sbLog.append(userId).append('|');
/* 376 */     sbLog.append(this.roleId).append('|');
/* 377 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 379 */     sbLog.append(partnerRoleId).append('|');
/* 380 */     sbLog.append(this.itemCfgId).append('|');
/* 381 */     sbLog.append(childId);
/*     */     
/* 383 */     TLogManager.getInstance().addLog(this.roleId, "AdultChildCompensateStatis", sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCUseAdulthoodChildrenCompensate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */