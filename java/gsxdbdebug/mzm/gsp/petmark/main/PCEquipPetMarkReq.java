/*     */ package mzm.gsp.petmark.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.petmark.SEquipPetMarkFail;
/*     */ import mzm.gsp.petmark.SEquipPetMarkSuccess;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PetMarkInfo;
/*     */ import xbean.Role2PetMarkInfo;
/*     */ 
/*     */ public class PCEquipPetMarkReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long petMarkId;
/*     */   private final long petId;
/*     */   
/*     */   public PCEquipPetMarkReq(long roleId, long petMarkId, long petId)
/*     */   {
/*  21 */     this.roleId = roleId;
/*  22 */     this.petMarkId = petMarkId;
/*  23 */     this.petId = petId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     if (!PetMarkManager.isPetMarkOpen(this.roleId))
/*     */     {
/*  32 */       String logstr = String.format("[petmark]PCEquipPetMarkReq.processImp@function not open|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  34 */       GameServer.logger().info(logstr);
/*  35 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  39 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 2132, true))
/*     */     {
/*  41 */       String logstr = String.format("[petmark]PCEquipPetMarkReq.processImp@status error|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  43 */       GameServer.logger().info(logstr);
/*  44 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  48 */     if (!PetMarkManager.checkRoleLevel(this.roleId))
/*     */     {
/*  50 */       onFail(-1);
/*  51 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  55 */     Role2PetMarkInfo xRole2PetMarkInfo = PetMarkManager.getRolePetMarkInfo(this.roleId);
/*  56 */     PetMarkInfo xPetMarkInfo = (PetMarkInfo)xRole2PetMarkInfo.getPetmarkid2info().get(Long.valueOf(this.petMarkId));
/*  57 */     if (null == xPetMarkInfo)
/*     */     {
/*  59 */       onFail(-2);
/*  60 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  64 */     xbean.Pet xPet = PetInterface.getXPetById(this.roleId, this.petId, true);
/*  65 */     if (null == PetInterface.getXPetById(this.roleId, this.petId, true))
/*     */     {
/*  67 */       onFail(-3);
/*  68 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  72 */     if (xPetMarkInfo.getPet_id() == this.petId)
/*     */     {
/*  74 */       onFail(-4);
/*  75 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  79 */     xPet.setIsbinded(1);
/*     */     
/*     */ 
/*  82 */     Long TargetPetEquipedMarkId = (Long)xRole2PetMarkInfo.getPetid2petmarkid().get(Long.valueOf(this.petId));
/*  83 */     if (null != TargetPetEquipedMarkId)
/*     */     {
/*  85 */       PetMarkManager.unequipPetMark(this.roleId, TargetPetEquipedMarkId.longValue(), xRole2PetMarkInfo, PetMarkManager.UnequipPetMarkReason.REPLACE);
/*     */     }
/*     */     
/*     */ 
/*  89 */     if (xPetMarkInfo.getPet_id() > 0L)
/*     */     {
/*  91 */       PetMarkManager.unequipPetMark(this.roleId, this.petMarkId, xRole2PetMarkInfo, PetMarkManager.UnequipPetMarkReason.OTHER_EQUIP);
/*     */     }
/*     */     
/*     */ 
/*  95 */     if (!PetMarkManager.equipPetMark(this.roleId, this.petMarkId, this.petId, xRole2PetMarkInfo))
/*     */     {
/*  97 */       onFail(-5);
/*  98 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 102 */     onSuccess();
/*     */     
/* 104 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onSuccess()
/*     */   {
/* 110 */     SEquipPetMarkSuccess proto = new SEquipPetMarkSuccess();
/* 111 */     proto.pet_mark_id = this.petMarkId;
/* 112 */     proto.pet_id = this.petId;
/* 113 */     OnlineManager.getInstance().send(this.roleId, proto);
/*     */     
/*     */ 
/* 116 */     String logstr = String.format("[petmark]PCEquipPetMarkReq.onSuccess@PCEquipPetMarkReq success|roleId=%d,petMarkId=%d,petId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petMarkId), Long.valueOf(this.petId) });
/*     */     
/*     */ 
/* 119 */     GameServer.logger().info(logstr);
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFail(int errorCode)
/*     */   {
/* 125 */     SEquipPetMarkFail proto = new SEquipPetMarkFail();
/* 126 */     proto.error_code = errorCode;
/* 127 */     OnlineManager.getInstance().sendAtOnce(this.roleId, proto);
/*     */     
/*     */ 
/* 130 */     String logstr = String.format("[petmark]PCEquipPetMarkReq.onFail@PCEquipPetMarkReq failed|roleId=%d,petMarkId=%d,petId=%d,reason=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petMarkId), Long.valueOf(this.petId), Integer.valueOf(errorCode) });
/*     */     
/*     */ 
/* 133 */     GameServer.logger().info(logstr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\main\PCEquipPetMarkReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */