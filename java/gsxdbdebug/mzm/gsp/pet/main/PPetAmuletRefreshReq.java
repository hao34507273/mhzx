/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.item.confbean.SPetXilianItem;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.PetEquipmentItem;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SPetNormalResult;
/*     */ import mzm.gsp.petequip.confbean.MonsterSkill2Prop;
/*     */ import mzm.gsp.petequip.confbean.SPetEquipItem;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xbean.PetEquipBag;
/*     */ import xdb.Xdb;
/*     */ import xtable.Role2petbag;
/*     */ 
/*     */ 
/*     */ public class PPetAmuletRefreshReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int itemKey;
/*     */   private final int costtype;
/*     */   private final int costyuanbao;
/*     */   private final long yuanbaonum;
/*     */   private final long petid;
/*     */   
/*     */   public PPetAmuletRefreshReq(long roleId, int itemKey, int costtype, int costyuanbao, long yuanbaonum, long petid)
/*     */   {
/*  50 */     this.roleId = roleId;
/*  51 */     this.itemKey = itemKey;
/*  52 */     this.costtype = costtype;
/*  53 */     this.costyuanbao = costyuanbao;
/*  54 */     this.yuanbaonum = yuanbaonum;
/*  55 */     this.petid = petid;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  62 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId))
/*     */     {
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  68 */     String userid = RoleInterface.getUserId(this.roleId);
/*     */     
/*     */ 
/*  71 */     long serverYuanBaoNum = QingfuInterface.getBalance(userid, true);
/*  72 */     if (this.yuanbaonum != serverYuanBaoNum)
/*     */     {
/*  74 */       StringBuilder sb = new StringBuilder();
/*  75 */       sb.append("[pet]PPetAmuletRefreshReq.processImp@cyuanbao not match syuanbao");
/*  76 */       sb.append("|roleid=").append(this.roleId);
/*  77 */       sb.append("|yuan_bao_num=").append(this.yuanbaonum);
/*  78 */       sb.append("|serverYuanBaoNum=").append(serverYuanBaoNum);
/*     */       
/*  80 */       GameServer.logger().error(sb.toString());
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     PetBag xPetBag = null;
/*  85 */     Pet xPet = null;
/*     */     
/*     */ 
/*  88 */     Item amuletItem = null;
/*     */     
/*  90 */     BasicItem basicItem = ItemInterface.getItem(this.roleId, this.itemKey);
/*  91 */     PetEquipmentItem petEquipmentItem = null;
/*  92 */     if (basicItem == null)
/*     */     {
/*     */ 
/*  95 */       xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/*  96 */       if (xPetBag == null)
/*     */       {
/*  98 */         return false;
/*     */       }
/* 100 */       xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petid));
/* 101 */       if (xPet == null)
/*     */       {
/* 103 */         return false;
/*     */       }
/* 105 */       PetEquipBag xEquipBag = xPet.getEquipbag();
/* 106 */       if (xEquipBag == null)
/*     */       {
/* 108 */         return false;
/*     */       }
/* 110 */       amuletItem = (Item)xEquipBag.getEquip2item().get(Integer.valueOf(2));
/* 111 */       if (amuletItem == null)
/*     */       {
/* 113 */         return false;
/*     */       }
/* 115 */       petEquipmentItem = new PetEquipmentItem(amuletItem);
/*     */     }
/*     */     else
/*     */     {
/* 119 */       SPetEquipItem sPetEquipItem = SPetEquipItem.get(basicItem.getCfgId());
/* 120 */       if ((sPetEquipItem == null) || (sPetEquipItem.equipType != 2))
/*     */       {
/* 122 */         PetManager.logInfo("PPetAmuletRefreshReq.processImp@item not amulet|roleid=%d|itemKey=%d|equip_type=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey), Integer.valueOf(sPetEquipItem == null ? -1 : sPetEquipItem.equipType) });
/*     */         
/* 124 */         return false;
/*     */       }
/* 126 */       petEquipmentItem = (PetEquipmentItem)basicItem;
/*     */     }
/*     */     
/* 129 */     SPetEquipItem itemCfg = SPetEquipItem.get(petEquipmentItem.getCfgId());
/*     */     
/* 131 */     List<SPetXilianItem> xiLianIdList = new ArrayList();
/* 132 */     for (SPetXilianItem sPetXilianItem : SPetXilianItem.getAllSelf().values())
/*     */     {
/* 134 */       if (sPetXilianItem.xilianItemLevel >= itemCfg.equipLevel)
/*     */       {
/* 136 */         xiLianIdList.add(sPetXilianItem);
/*     */       }
/*     */     }
/*     */     
/* 140 */     Collections.sort(xiLianIdList, new PetXiLianItemComparator());
/*     */     
/* 142 */     boolean remove = false;
/* 143 */     for (SPetXilianItem sPetXilianItem : xiLianIdList)
/*     */     {
/* 145 */       int itemId = sPetXilianItem.id;
/*     */       
/* 147 */       if (ItemInterface.removeItemById(this.roleId, 340600000, itemId, 1, new TLogArg(LogReason.PET_AMULET_REFRESH_REM)))
/*     */       {
/* 149 */         remove = true;
/* 150 */         break;
/*     */       }
/*     */     }
/*     */     
/* 154 */     if (!remove)
/*     */     {
/* 156 */       if (this.costtype == 1)
/*     */       {
/* 158 */         int totalCost = 0;
/* 159 */         SPetXilianItem sPetXilianItem = (SPetXilianItem)xiLianIdList.get(0);
/* 160 */         if (sPetXilianItem == null)
/*     */         {
/* 162 */           return false;
/*     */         }
/*     */         
/* 165 */         int itemId = sPetXilianItem.id;
/*     */         
/* 167 */         totalCost = ItemInterface.getItemYuanBaoPrice(itemId);
/* 168 */         if (totalCost <= 0)
/*     */         {
/* 170 */           return false;
/*     */         }
/*     */         
/* 173 */         if (totalCost != this.costyuanbao)
/*     */         {
/* 175 */           SPetNormalResult result = new SPetNormalResult();
/* 176 */           result.result = 28;
/* 177 */           OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/* 178 */           return false;
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 183 */         if (QingfuInterface.costYuanbao(userid, this.roleId, totalCost, CostType.COST_BIND_FIRST_PET_REFRESH_AMULET, new TLogArg(LogReason.PET_AMULET_REFRESH_REM)) != CostResult.Success)
/*     */         {
/*     */ 
/* 186 */           SPetNormalResult result = new SPetNormalResult();
/* 187 */           result.result = 29;
/* 188 */           OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/* 189 */           return false;
/*     */         }
/*     */         
/*     */       }
/*     */       else
/*     */       {
/* 195 */         return false;
/*     */       }
/*     */     }
/* 198 */     if (itemCfg.equipType != 2)
/*     */     {
/* 200 */       return false;
/*     */     }
/* 202 */     int skillNum = petEquipmentItem.getSkills().size();
/*     */     
/* 204 */     List<Integer> skillIdList = new ArrayList();
/*     */     Set<Integer> skillSet;
/* 206 */     int prop; int baseProp; Set<Integer> skillSet; int prop; int baseProp; if (skillNum > 1)
/*     */     {
/*     */ 
/* 209 */       skillIdList.addAll(SkillInterface.getMonsterRandomSkill(itemCfg.monsterSkillId, 1));
/*     */       
/* 211 */       skillSet = new HashSet(skillIdList);
/* 212 */       int sumWight = 0;
/* 213 */       for (MonsterSkill2Prop m2p : itemCfg.monsterSkillPropList)
/*     */       {
/* 215 */         sumWight += m2p.monster2SkillProb;
/*     */       }
/* 217 */       if (sumWight == 0)
/*     */       {
/* 219 */         petEquipmentItem.setSkills(skillIdList);
/* 220 */         SPetNormalResult result = new SPetNormalResult();
/* 221 */         result.result = 11;
/* 222 */         OnlineManager.getInstance().send(this.roleId, result);
/* 223 */         return true;
/*     */       }
/*     */       
/* 226 */       prop = Xdb.random().nextInt(sumWight);
/* 227 */       baseProp = 0;
/* 228 */       for (MonsterSkill2Prop m2p : itemCfg.monsterSkillPropList)
/*     */       {
/* 230 */         baseProp += m2p.monster2SkillProb;
/* 231 */         if (prop <= baseProp)
/*     */         {
/* 233 */           if (itemCfg.monsterSkillId == m2p.monster2SkillId)
/*     */           {
/* 235 */             skillIdList.clear();
/* 236 */             skillIdList.addAll(SkillInterface.getMonsterRandomSkill(m2p.monster2SkillId, skillSet, 2)); break;
/*     */           }
/*     */           
/*     */ 
/* 240 */           skillIdList.addAll(SkillInterface.getMonsterRandomSkill(m2p.monster2SkillId, skillSet, 1));
/*     */           
/* 242 */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 248 */       skillSet = new HashSet(skillIdList);
/* 249 */       int sumWight = 0;
/* 250 */       for (MonsterSkill2Prop m2p : itemCfg.monsterSkillPropList)
/*     */       {
/* 252 */         sumWight += m2p.monsterSkillProb;
/*     */       }
/* 254 */       prop = Xdb.random().nextInt(sumWight);
/* 255 */       baseProp = 0;
/* 256 */       for (MonsterSkill2Prop m2p : itemCfg.monsterSkillPropList)
/*     */       {
/* 258 */         baseProp += m2p.monsterSkillProb;
/* 259 */         if (prop <= baseProp)
/*     */         {
/* 261 */           skillIdList.addAll(SkillInterface.getMonsterRandomSkill(m2p.monsterSkillId, skillSet, 1));
/* 262 */           break;
/*     */         }
/*     */       }
/*     */     }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 281 */     petEquipmentItem.setSkills(skillIdList);
/*     */     
/* 283 */     SPetNormalResult result = new SPetNormalResult();
/* 284 */     result.result = 11;
/* 285 */     OnlineManager.getInstance().send(this.roleId, result);
/*     */     
/* 287 */     long petId = 0L;
/* 288 */     int petCfgId = 0;
/*     */     
/* 290 */     if (amuletItem != null)
/*     */     {
/* 292 */       PetOutFightObj pet = new PetOutFightObj(this.roleId, xPet);
/* 293 */       pet.updatePassiveSkill();
/* 294 */       pet.syncPetInfo();
/* 295 */       petId = xPet.getId();
/* 296 */       petCfgId = xPet.getTemplateid();
/*     */     }
/*     */     
/* 299 */     int skill1 = ((Integer)skillIdList.get(0)).intValue();
/* 300 */     int skill2 = 0;
/* 301 */     if (skillIdList.size() > 1)
/*     */     {
/* 303 */       skill2 = ((Integer)skillIdList.get(1)).intValue();
/*     */     }
/*     */     
/* 306 */     StringBuilder sb = new StringBuilder();
/* 307 */     sb.append("[pet]PPetAmuletRefreshReq.processImp@amulet refresh pet equip success");
/* 308 */     sb.append("|role_id=").append(this.roleId);
/* 309 */     sb.append("|item_cfg_id=").append(itemCfg.id);
/* 310 */     sb.append("|init_skill_id_1=").append(itemCfg.initSkillID1);
/* 311 */     sb.append("|init_skill_id_2=").append(itemCfg.initSkillID2);
/* 312 */     sb.append("|pet_equipment_item_cfg_id=").append(petEquipmentItem.getCfgId());
/* 313 */     sb.append("|pet_equipment_item_first_uuid=").append(petEquipmentItem.getFirstUuid());
/* 314 */     sb.append("|skill_1=").append(skill1);
/* 315 */     sb.append("|skill_2=").append(skill2);
/*     */     
/* 317 */     GameServer.logger().info(sb.toString());
/*     */     
/* 319 */     TLogManager.getInstance().addLog(this.roleId, "PetAmuleRefreshTLog", PetManager.createTLog(new Object[] { GameServerInfoManager.getHostIP(), userid, Long.valueOf(this.roleId), petEquipmentItem.getFirstUuid(), Integer.valueOf(petEquipmentItem.getCfgId()), Integer.valueOf(skill1), Integer.valueOf(skill2), Long.valueOf(petId), Integer.valueOf(petCfgId) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 325 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PPetAmuletRefreshReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */