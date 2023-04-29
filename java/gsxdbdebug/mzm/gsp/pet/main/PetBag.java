/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SSyncPetStateChange;
/*     */ import mzm.gsp.pet.event.PetEventArg;
/*     */ import mzm.gsp.pet.event.PlayerDeletePet;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PetBag
/*     */ {
/*     */   private final long roleId;
/*     */   private final xbean.PetBag xPetBag;
/*  24 */   private static final Logger logger = Logger.getLogger(PetBag.class);
/*     */   
/*     */   public PetBag(long roleId, xbean.PetBag xPetBag)
/*     */   {
/*  28 */     this.roleId = roleId;
/*  29 */     this.xPetBag = xPetBag;
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
/*     */   public boolean removePetByCfg(int cfgId, int num)
/*     */   {
/*  42 */     Map<Long, xbean.Pet> xPetMap = this.xPetBag.getPetmap();
/*     */     
/*  44 */     Iterator<xbean.Pet> it = xPetMap.values().iterator();
/*  45 */     int rmSize = 0;
/*  46 */     while (it.hasNext())
/*     */     {
/*  48 */       xbean.Pet xPet = (xbean.Pet)it.next();
/*  49 */       if ((xPet.getTemplateid() == cfgId) && (xPet.getIsbinded() != 1) && (this.xPetBag.getShowpet() != xPet.getId()))
/*     */       {
/*  51 */         it.remove();
/*  52 */         rmSize++;
/*  53 */         long petId = xPet.getId();
/*     */         
/*  55 */         SSyncPetStateChange petStateChangeProtocol = new SSyncPetStateChange();
/*  56 */         petStateChangeProtocol.petid = petId;
/*  57 */         petStateChangeProtocol.state = 2;
/*  58 */         OnlineManager.getInstance().send(this.roleId, petStateChangeProtocol);
/*     */         
/*  60 */         if (rmSize == num) {
/*     */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  67 */     if (rmSize < num)
/*     */     {
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isFightPet(int pos)
/*     */   {
/*  77 */     return this.xPetBag.getFightpet() == pos;
/*     */   }
/*     */   
/*     */   public boolean isShowPet(int pos)
/*     */   {
/*  82 */     return this.xPetBag.getShowpet() == pos;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int countPetByCfgId(int cfgId)
/*     */   {
/*  94 */     int count = 0;
/*  95 */     for (xbean.Pet xPet : this.xPetBag.getPetmap().values())
/*     */     {
/*  97 */       if (xPet.getTemplateid() == cfgId)
/*     */       {
/*  99 */         count++;
/*     */       }
/*     */     }
/* 102 */     return count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public PetOutFightObj getPetOutFightObjById(long petId)
/*     */   {
/* 114 */     xbean.Pet xPet = (xbean.Pet)this.xPetBag.getPetmap().get(Long.valueOf(petId));
/* 115 */     if (xPet == null)
/*     */     {
/* 117 */       return null;
/*     */     }
/* 119 */     return new PetOutFightObj(this.roleId, xPet);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Pet getFightPet()
/*     */   {
/* 129 */     xbean.Pet xPet = (xbean.Pet)this.xPetBag.getPetmap().get(Long.valueOf(this.xPetBag.getFightpet()));
/* 130 */     if (xPet == null)
/*     */     {
/* 132 */       return null;
/*     */     }
/* 134 */     return new Pet(this.roleId, xPet);
/*     */   }
/*     */   
/*     */   public long getFightPetId()
/*     */   {
/* 139 */     return this.xPetBag.getFightpet();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Pet getShowPet()
/*     */   {
/* 149 */     xbean.Pet xPet = (xbean.Pet)this.xPetBag.getPetmap().get(Long.valueOf(this.xPetBag.getShowpet()));
/* 150 */     if (xPet == null)
/*     */     {
/* 152 */       return null;
/*     */     }
/* 154 */     return new Pet(this.roleId, xPet);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Pet getPetById(long petId)
/*     */   {
/* 165 */     xbean.Pet xPet = (xbean.Pet)this.xPetBag.getPetmap().get(Long.valueOf(petId));
/* 166 */     if (xPet == null)
/*     */     {
/* 168 */       return null;
/*     */     }
/* 170 */     return new Pet(this.roleId, xPet);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getBagSize()
/*     */   {
/* 180 */     return this.xPetBag.getBagsize();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getPetSize()
/*     */   {
/* 190 */     return this.xPetBag.getPetmap().size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public xbean.Pet removePet(long petId)
/*     */   {
/* 201 */     xbean.Pet removePet = (xbean.Pet)this.xPetBag.getPetmap().remove(Long.valueOf(petId));
/* 202 */     if (removePet != null)
/*     */     {
/* 204 */       SSyncPetStateChange petStateChangeProtocol = new SSyncPetStateChange();
/* 205 */       petStateChangeProtocol.petid = petId;
/* 206 */       petStateChangeProtocol.state = 2;
/* 207 */       OnlineManager.getInstance().send(this.roleId, petStateChangeProtocol);
/*     */     }
/* 209 */     return removePet;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public xbean.Pet removePet(long petId, PetDeleteTLogEnum deleteTLogEnum)
/*     */   {
/* 221 */     xbean.Pet removePet = (xbean.Pet)this.xPetBag.getPetmap().remove(Long.valueOf(petId));
/* 222 */     if (removePet != null)
/*     */     {
/* 224 */       SSyncPetStateChange petStateChangeProtocol = new SSyncPetStateChange();
/* 225 */       petStateChangeProtocol.petid = petId;
/* 226 */       petStateChangeProtocol.state = 2;
/* 227 */       OnlineManager.getInstance().send(this.roleId, petStateChangeProtocol);
/*     */     }
/*     */     
/* 230 */     PlayerDeletePet playerDeletePet = new PlayerDeletePet();
/* 231 */     PetEventArg arg = new PetEventArg();
/* 232 */     arg.roleId = this.roleId;
/* 233 */     arg.petId = petId;
/* 234 */     arg.enventType = deleteTLogEnum.value;
/* 235 */     TriggerEventsManger.getInstance().triggerEvent(playerDeletePet, arg);
/*     */     
/*     */ 
/* 238 */     PetManager.addPetDeleteTlog(this.roleId, petId, removePet.getTemplateid(), deleteTLogEnum);
/* 239 */     return removePet;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.Pet> getAllPets()
/*     */   {
/* 249 */     return this.xPetBag.getPetmap();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean addXPet(xbean.Pet xPet)
/*     */   {
/* 260 */     if (getBagSize() <= getPetSize())
/*     */     {
/* 262 */       return false;
/*     */     }
/* 264 */     xbean.Pet xpet = (xbean.Pet)this.xPetBag.getPetmap().put(Long.valueOf(xPet.getId()), xPet);
/* 265 */     if (xpet != null)
/*     */     {
/* 267 */       logger.info("替换掉老的宠物数据！");
/*     */     }
/* 269 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */