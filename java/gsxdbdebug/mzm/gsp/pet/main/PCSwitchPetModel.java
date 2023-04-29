/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.item.confbean.SItemPetChangeItemCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SSWitchPetModelFailed;
/*     */ import mzm.gsp.pet.SSWitchPetModelSuccess;
/*     */ import mzm.gsp.pet.event.PetChangeModelEvent;
/*     */ import mzm.gsp.pet.event.PetChangeModelEventArg;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xbean.Role2PetBean;
/*     */ import xtable.Role2petbag;
/*     */ import xtable.Role2petoutfightbean;
/*     */ 
/*     */ 
/*     */ public class PCSwitchPetModel
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long petId;
/*     */   private final int itemCfgId;
/*     */   
/*     */   public PCSwitchPetModel(long roleId, long petId, int itemCfgId)
/*     */   {
/*  36 */     this.roleId = roleId;
/*  37 */     this.petId = petId;
/*  38 */     this.itemCfgId = itemCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId))
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  54 */     if (!PetManager.isPetChangeModelOpenForRole(this.roleId))
/*     */     {
/*  56 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  62 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 2261, true, true))
/*     */     {
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  69 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/*  70 */     if (xPetBag == null)
/*     */     {
/*  72 */       Map<String, Object> extras = new HashMap();
/*  73 */       extras.put("xPetBag", "null");
/*  74 */       onFailed(-4, extras);
/*  75 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  80 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/*  81 */     if (xPet == null)
/*     */     {
/*  83 */       Map<String, Object> extras = new HashMap();
/*  84 */       extras.put("xPet", "null");
/*  85 */       onFailed(-4, extras);
/*  86 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  91 */     if (!xPet.getOwnextramodelcfgids().contains(Integer.valueOf(this.itemCfgId)))
/*     */     {
/*  93 */       onFailed(-6);
/*  94 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  99 */     int oldUsedModelcfgid = xPet.getExtramodelcfgid();
/* 100 */     if (this.itemCfgId == oldUsedModelcfgid)
/*     */     {
/* 102 */       onFailed(-7);
/* 103 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 108 */     SItemPetChangeItemCfg sItemPetChangeItemCfg = SItemPetChangeItemCfg.get(this.itemCfgId);
/* 109 */     if (sItemPetChangeItemCfg == null)
/*     */     {
/* 111 */       onFailed(-3);
/* 112 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 117 */     if (FightInterface.isInFight(this.roleId))
/*     */     {
/*     */ 
/* 120 */       Role2PetBean role2PetBean = Role2petoutfightbean.get(Long.valueOf(this.roleId));
/* 121 */       role2PetBean.setAction(this);
/* 122 */       onFailed(-5);
/* 123 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 128 */     xPet.setExtramodelcfgid(this.itemCfgId);
/*     */     
/*     */ 
/*     */ 
/* 132 */     PetChangeModelEventArg arg = new PetChangeModelEventArg();
/* 133 */     arg.roleId = this.roleId;
/* 134 */     arg.petId = this.petId;
/* 135 */     arg.changeModelId = sItemPetChangeItemCfg.modelId;
/* 136 */     arg.colorId = sItemPetChangeItemCfg.colorId;
/* 137 */     arg.outlookId = sItemPetChangeItemCfg.modelFigureCfgId;
/*     */     
/* 139 */     TriggerEventsManger.getInstance().triggerEvent(new PetChangeModelEvent(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 146 */     PetTLogManager.tlogPetModelChanged(this.roleId, this.petId, oldUsedModelcfgid, this.itemCfgId, PetTLogManager.PetModelChangedType.SWITCH_MODEL);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 152 */     SSWitchPetModelSuccess sSWitchPetModelSuccess = new SSWitchPetModelSuccess();
/* 153 */     sSWitchPetModelSuccess.pet_id = this.petId;
/* 154 */     sSWitchPetModelSuccess.item_cfg_id = this.itemCfgId;
/* 155 */     OnlineManager.getInstance().send(this.roleId, sSWitchPetModelSuccess);
/*     */     
/* 157 */     GameServer.logger().info(String.format("[pet]PCSwitchPetModel.processImp@switch pet model success|roleId=%d|petId=%d|itemCfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(this.itemCfgId) }));
/*     */     
/*     */ 
/*     */ 
/* 161 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 166 */     onFailed(retcode, null);
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
/* 177 */     SSWitchPetModelFailed rsp = new SSWitchPetModelFailed();
/* 178 */     rsp.pet_id = this.petId;
/* 179 */     rsp.item_cfg_id = this.itemCfgId;
/* 180 */     rsp.retcode = retcode;
/* 181 */     OnlineManager.getInstance().sendAtOnce(this.roleId, rsp);
/*     */     
/* 183 */     StringBuffer logBuilder = new StringBuffer();
/* 184 */     logBuilder.append("[pet]PCSwitchPetModel.onFailed@switch pet model failed");
/* 185 */     logBuilder.append('|').append("roleId=").append(this.roleId);
/* 186 */     logBuilder.append('|').append("petId=").append(this.petId);
/* 187 */     logBuilder.append('|').append("itemCfgId=").append(this.itemCfgId);
/* 188 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 190 */     if (extraParams != null)
/*     */     {
/* 192 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 194 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 198 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PCSwitchPetModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */