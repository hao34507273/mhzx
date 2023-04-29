/*     */ package mzm.gsp.petmark.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.petmark.SUnequipPetMarkFail;
/*     */ import mzm.gsp.petmark.SUnequipPetMarkSuccess;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PetMarkInfo;
/*     */ import xbean.Role2PetMarkInfo;
/*     */ 
/*     */ public class PCUnequipPetMarkReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long petMarkId;
/*     */   
/*     */   public PCUnequipPetMarkReq(long roleId, long petMarkId)
/*     */   {
/*  19 */     this.roleId = roleId;
/*  20 */     this.petMarkId = petMarkId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  27 */     if (!PetMarkManager.isPetMarkOpen(this.roleId))
/*     */     {
/*  29 */       String logstr = String.format("[petmark]PCUnequipPetMarkReq.processImp@function not open|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  31 */       GameServer.logger().info(logstr);
/*  32 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  36 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 2133, true))
/*     */     {
/*  38 */       String logstr = String.format("[petmark]PCUnequipPetMarkReq.processImp@status error|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  40 */       GameServer.logger().info(logstr);
/*  41 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  45 */     if (!PetMarkManager.checkRoleLevel(this.roleId))
/*     */     {
/*  47 */       onFail(-1);
/*  48 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  52 */     Role2PetMarkInfo xRole2PetMarkInfo = PetMarkManager.getRolePetMarkInfo(this.roleId);
/*  53 */     PetMarkInfo xPetMarkInfo = (PetMarkInfo)xRole2PetMarkInfo.getPetmarkid2info().get(Long.valueOf(this.petMarkId));
/*  54 */     if (null == xPetMarkInfo)
/*     */     {
/*  56 */       onFail(-2);
/*  57 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  61 */     long petId = xPetMarkInfo.getPet_id();
/*  62 */     if (petId <= 0L)
/*     */     {
/*  64 */       onFail(-3);
/*  65 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  69 */     if (!PetMarkManager.unequipPetMark(this.roleId, this.petMarkId, xRole2PetMarkInfo, PetMarkManager.UnequipPetMarkReason.ACTIVE))
/*     */     {
/*  71 */       onFail(-4);
/*  72 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  76 */     onSuccess(petId);
/*     */     
/*  78 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onSuccess(long petId)
/*     */   {
/*  84 */     SUnequipPetMarkSuccess proto = new SUnequipPetMarkSuccess();
/*  85 */     proto.pet_mark_id = this.petMarkId;
/*  86 */     proto.pet_id = petId;
/*  87 */     OnlineManager.getInstance().send(this.roleId, proto);
/*     */     
/*     */ 
/*  90 */     String logstr = String.format("[petmark]PCUnequipPetMarkReq.onSuccess@PCUnequipPetMarkReq success|roleId=%d,petMarkId=%d,petId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petMarkId), Long.valueOf(petId) });
/*     */     
/*     */ 
/*  93 */     GameServer.logger().info(logstr);
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFail(int errorCode)
/*     */   {
/*  99 */     SUnequipPetMarkFail proto = new SUnequipPetMarkFail();
/* 100 */     proto.error_code = errorCode;
/* 101 */     OnlineManager.getInstance().sendAtOnce(this.roleId, proto);
/*     */     
/*     */ 
/* 104 */     String logstr = String.format("[petmark]PCUnequipPetMarkReq.onFail@PCUnequipPetMarkReq failed|roleId=%d,petMarkId=%d,reason=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petMarkId), Integer.valueOf(errorCode) });
/*     */     
/*     */ 
/* 107 */     GameServer.logger().info(logstr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\main\PCUnequipPetMarkReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */