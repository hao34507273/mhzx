/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.gm.main.GmManager;
/*     */ import mzm.gsp.item.confbean.SPetSkillBookCfg;
/*     */ import mzm.gsp.pet.confbean.PetConstants;
/*     */ import mzm.gsp.pet.confbean.SPetCfg;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xbean.PetSkill;
/*     */ 
/*     */ public class PGM_AddSkillNumPet extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int petCfgId;
/*     */   private final int skillNum;
/*     */   
/*     */   public PGM_AddSkillNumPet(long roleId, int petCfgId, int skillNum)
/*     */   {
/*  25 */     this.roleId = roleId;
/*  26 */     this.petCfgId = petCfgId;
/*  27 */     this.skillNum = skillNum;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  34 */     lock(xdb.Lockeys.get(xtable.User.getTable(), userId));
/*     */     
/*  36 */     PetBag xPetBag = PetManager.getInstance().createPetBag(this.roleId);
/*  37 */     if (xPetBag.getPetmap().size() == xPetBag.getBagsize())
/*     */     {
/*  39 */       GmManager.getInstance().sendResultToGM(this.roleId, "宠物包裹中宠物满了");
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     if ((this.skillNum < 0) || (this.skillNum > PetConstants.getInstance().PET_SHELF_SKILL_NUM_LIMIT))
/*     */     {
/*  45 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("技能数不能小于0或者大于最大技能数%d", new Object[] { Integer.valueOf(PetConstants.getInstance().PET_SHELF_SKILL_NUM_LIMIT) }));
/*     */       
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     SPetCfg sPetCfg = SPetCfg.get(this.petCfgId);
/*  51 */     if (sPetCfg == null)
/*     */     {
/*  53 */       GmManager.getInstance().sendResultToGM(this.roleId, "宠物配置不存在");
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     long petId = PetInterface.addPetAndRandomPoint(this.roleId, this.petCfgId, sPetCfg.catchLevel, true);
/*  58 */     if (petId < 0L)
/*     */     {
/*  60 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("创建宠物失败,错误码%d", new Object[] { Long.valueOf(petId) }));
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(petId));
/*  65 */     if (xPet == null)
/*     */     {
/*  67 */       GmManager.getInstance().sendResultToGM(this.roleId, "查询创建的宠物失败");
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     List<PetSkill> xPetSkillList = xPet.getSkilllist();
/*  72 */     if (xPetSkillList.size() == this.skillNum)
/*     */     {
/*  74 */       GmManager.getInstance().sendResultToGM(this.roleId, "增加宠物成功");
/*  75 */       return true;
/*     */     }
/*     */     
/*  78 */     int bornSize = xPetSkillList.size();
/*  79 */     if (xPetSkillList.size() > this.skillNum)
/*     */     {
/*  81 */       for (int i = 0; i < bornSize - this.skillNum; i++)
/*     */       {
/*  83 */         PetSkill xPetSkill = (PetSkill)xPetSkillList.remove(0);
/*  84 */         if (xPetSkill.getSkillid() == xPet.getRememberskillid())
/*     */         {
/*  86 */           xPet.setRememberskillid(-1);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*  91 */       PetOutFightObj petOutFightObj = new PetOutFightObj(this.roleId, xPet);
/*  92 */       petOutFightObj.updateOutFightProperty();
/*  93 */       petOutFightObj.syncPetInfo();
/*  94 */       GmManager.getInstance().sendResultToGM(this.roleId, "增加宠物成功");
/*  95 */       return true;
/*     */     }
/*     */     
/*  98 */     if (xPetSkillList.size() < this.skillNum)
/*     */     {
/* 100 */       xPetSkillList.clear();
/* 101 */       xPet.setRememberskillid(-1);
/* 102 */       int needSkillNum = this.skillNum - xPetSkillList.size();
/* 103 */       List<Integer> prepareSkillList = new ArrayList();
/* 104 */       for (SPetSkillBookCfg sPetSkillBookCfg : SPetSkillBookCfg.getAllSelf().values())
/*     */       {
/* 106 */         for (PetSkill xPetSkill : xPetSkillList)
/*     */         {
/* 108 */           if (xPetSkill.getSkillid() == sPetSkillBookCfg.skillId) {}
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 113 */         prepareSkillList.add(Integer.valueOf(sPetSkillBookCfg.skillId));
/*     */       }
/*     */       
/* 116 */       List<Integer> skillList = randomList(prepareSkillList, needSkillNum);
/*     */       
/* 118 */       for (Iterator i$ = skillList.iterator(); i$.hasNext();) { int skillId = ((Integer)i$.next()).intValue();
/*     */         
/* 120 */         PetSkill xPetSkill = xbean.Pod.newPetSkill();
/* 121 */         xPetSkill.setSkillid(skillId);
/* 122 */         xPetSkill.setSkillfrom(0);
/* 123 */         xPetSkillList.add(xPetSkill);
/*     */       }
/* 125 */       GmManager.getInstance().sendResultToGM(this.roleId, "增加宠物成功");
/*     */       
/* 127 */       PetOutFightObj petOutFightObj = new PetOutFightObj(this.roleId, xPet);
/* 128 */       petOutFightObj.updateOutFightProperty();
/* 129 */       petOutFightObj.syncPetInfo();
/*     */     }
/*     */     
/* 132 */     return true;
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
/*     */   private List<Integer> randomList(List<Integer> sourceList, int count)
/*     */   {
/* 147 */     int size = sourceList.size();
/* 148 */     if ((count > size) || (size == 0) || (count == 0))
/*     */     {
/* 150 */       return Collections.emptyList();
/*     */     }
/*     */     
/* 153 */     if (size == count)
/*     */     {
/* 155 */       return new ArrayList(sourceList);
/*     */     }
/*     */     
/* 158 */     Random random = xdb.Xdb.random();
/* 159 */     int i = size; for (int j = 0; j < count; j++)
/*     */     {
/* 161 */       Collections.swap(sourceList, i - 1, random.nextInt(i));i--;
/*     */     }
/*     */     
/* 164 */     return new ArrayList(sourceList.subList(size - count, size));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PGM_AddSkillNumPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */