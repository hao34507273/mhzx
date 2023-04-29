/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SDeletePetModelFailed;
/*     */ import mzm.gsp.pet.SDeletePetModelSuccess;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xtable.Role2petbag;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCDeletePetModel
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long petId;
/*     */   private final int itemCfgId;
/*     */   
/*     */   public PCDeletePetModel(long roleId, long petId, int itemCfgId)
/*     */   {
/*  30 */     this.roleId = roleId;
/*  31 */     this.petId = petId;
/*  32 */     this.itemCfgId = itemCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId))
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  48 */     if (!PetManager.isPetChangeModelOpenForRole(this.roleId))
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  56 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 2262, true, true))
/*     */     {
/*  58 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  63 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/*  64 */     if (xPetBag == null)
/*     */     {
/*  66 */       Map<String, Object> extras = new HashMap();
/*  67 */       extras.put("xPetBag", "null");
/*  68 */       onFailed(-4, extras);
/*  69 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  74 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/*  75 */     if (xPet == null)
/*     */     {
/*  77 */       Map<String, Object> extras = new HashMap();
/*  78 */       extras.put("xPet", "null");
/*  79 */       onFailed(-4, extras);
/*  80 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  85 */     int index = xPet.getOwnextramodelcfgids().indexOf(Integer.valueOf(this.itemCfgId));
/*  86 */     if (index < 0)
/*     */     {
/*  88 */       onFailed(-6);
/*  89 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  94 */     int oldUsedModelcfgid = xPet.getExtramodelcfgid();
/*  95 */     if (this.itemCfgId == oldUsedModelcfgid)
/*     */     {
/*  97 */       onFailed(-5);
/*  98 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 103 */     xPet.getOwnextramodelcfgids().remove(index);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 108 */     PetTLogManager.tlogPetModelChanged(this.roleId, this.petId, oldUsedModelcfgid, this.itemCfgId, PetTLogManager.PetModelChangedType.DELETE_MODEL);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 114 */     SDeletePetModelSuccess sDeletePetModelSuccess = new SDeletePetModelSuccess();
/* 115 */     sDeletePetModelSuccess.pet_id = this.petId;
/* 116 */     sDeletePetModelSuccess.item_cfg_id = this.itemCfgId;
/* 117 */     OnlineManager.getInstance().send(this.roleId, sDeletePetModelSuccess);
/*     */     
/* 119 */     GameServer.logger().info(String.format("[pet]PCDeletePetModel.processImp@delete pet model success|roleId=%d|petId=%d|itemCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(this.itemCfgId) }));
/*     */     
/*     */ 
/*     */ 
/* 123 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 128 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 139 */     SDeletePetModelFailed rsp = new SDeletePetModelFailed();
/* 140 */     rsp.pet_id = this.petId;
/* 141 */     rsp.item_cfg_id = this.itemCfgId;
/* 142 */     rsp.retcode = retcode;
/* 143 */     OnlineManager.getInstance().sendAtOnce(this.roleId, rsp);
/*     */     
/* 145 */     StringBuffer logBuilder = new StringBuffer();
/* 146 */     logBuilder.append("[pet]PCDeletePetModel.onFailed@delete pet model failed");
/* 147 */     logBuilder.append('|').append("roleId=").append(this.roleId);
/* 148 */     logBuilder.append('|').append("petId=").append(this.petId);
/* 149 */     logBuilder.append('|').append("itemCfgId=").append(this.itemCfgId);
/* 150 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 152 */     if (extraParams != null)
/*     */     {
/* 154 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 156 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 160 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PCDeletePetModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */