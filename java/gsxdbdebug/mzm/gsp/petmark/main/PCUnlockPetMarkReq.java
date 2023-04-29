/*     */ package mzm.gsp.petmark.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.petmark.SUnlockPetMarkFail;
/*     */ import mzm.gsp.petmark.SUnlockPetMarkSuccess;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkCfg;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkConstants;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkItemCfg;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PetMarkInfo;
/*     */ import xbean.Role2PetMarkInfo;
/*     */ 
/*     */ public class PCUnlockPetMarkReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long itemUuid;
/*     */   
/*     */   public PCUnlockPetMarkReq(long roleId, long itemUuid)
/*     */   {
/*  28 */     this.roleId = roleId;
/*  29 */     this.itemUuid = itemUuid;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (!PetMarkManager.isPetMarkOpen(this.roleId))
/*     */     {
/*  38 */       String logstr = String.format("[petmark]PCUnlockPetMarkReq.processImp@function not open|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  40 */       GameServer.logger().info(logstr);
/*  41 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  45 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 2131, true))
/*     */     {
/*  47 */       String logstr = String.format("[petmark]PCUnlockPetMarkReq.processImp@status error|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*  48 */       GameServer.logger().info(logstr);
/*  49 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  53 */     if (!PetMarkManager.checkRoleLevel(this.roleId))
/*     */     {
/*  55 */       onFail(-1);
/*  56 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  60 */     BasicItem basicItem = ItemInterface.getItemByUuid(this.roleId, 340600009, this.itemUuid);
/*  61 */     if (null == basicItem)
/*     */     {
/*  63 */       onFail(-2);
/*  64 */       return false;
/*     */     }
/*  66 */     int itemCfgId = basicItem.getCfgId();
/*  67 */     SPetMarkItemCfg sPetMarkItemCfg = SPetMarkItemCfg.get(itemCfgId);
/*  68 */     if (null == sPetMarkItemCfg)
/*     */     {
/*  70 */       onFail(-3);
/*  71 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  75 */     int petMarkCfgId = sPetMarkItemCfg.petMarkCfgId;
/*  76 */     SPetMarkCfg sPetMarkCfg = SPetMarkCfg.get(petMarkCfgId);
/*  77 */     if (sPetMarkCfg.type == 2)
/*     */     {
/*  79 */       onFail(-5);
/*  80 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  84 */     TLogArg tLogArg = new TLogArg(LogReason.PET_MARK_UNLOCK_COST);
/*  85 */     if (!ItemInterface.removeItemByUuid(this.roleId, 340600009, this.itemUuid, 1, tLogArg))
/*     */     {
/*  87 */       onFail(-4);
/*  88 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  92 */     Role2PetMarkInfo xRole2PetMarkInfo = PetMarkManager.getRolePetMarkInfo(this.roleId);
/*  93 */     if (xRole2PetMarkInfo.getPetmarkid2info().size() >= SPetMarkConstants.getInstance().PET_MARK_MAX_CARRY_NUM)
/*     */     {
/*  95 */       onFail(-6);
/*  96 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 100 */     int petMarkLevel = sPetMarkItemCfg.level;
/* 101 */     long petMarkId = PetMarkManager.addPetMark(this.roleId, xRole2PetMarkInfo, petMarkCfgId, petMarkLevel, PetMarkManager.AddPetMarkReason.UNLOCK);
/*     */     
/*     */ 
/*     */ 
/* 105 */     PetMarkInfo xPetMarkInfo = (PetMarkInfo)xRole2PetMarkInfo.getPetmarkid2info().get(Long.valueOf(petMarkId));
/* 106 */     onSuccess(petMarkId, xPetMarkInfo, itemCfgId);
/*     */     
/* 108 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onSuccess(long petMarkId, PetMarkInfo xPetMarkInfo, int itemCfgId)
/*     */   {
/* 114 */     SUnlockPetMarkSuccess proto = new SUnlockPetMarkSuccess();
/* 115 */     proto.pet_mark_id = petMarkId;
/* 116 */     proto.pet_mark_info.pet_mark_cfg_id = xPetMarkInfo.getPet_mark_cfg_id();
/* 117 */     proto.pet_mark_info.level = xPetMarkInfo.getLevel();
/* 118 */     proto.pet_mark_info.exp = xPetMarkInfo.getExp();
/* 119 */     proto.pet_mark_info.pet_id = xPetMarkInfo.getPet_id();
/* 120 */     OnlineManager.getInstance().send(this.roleId, proto);
/*     */     
/*     */ 
/* 123 */     String logstr = String.format("[petmark]PCUnlockPetMarkReq.onSuccess@PCUnlockPetMarkReq success|roleId=%d,petMarkId=%d,cfgId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(petMarkId), Integer.valueOf(xPetMarkInfo.getPet_mark_cfg_id()) });
/*     */     
/*     */ 
/* 126 */     GameServer.logger().info(logstr);
/*     */     
/*     */ 
/* 129 */     PetMarkTLogManager.addPetMarkUnlockTLog(this.roleId, petMarkId, this.itemUuid, itemCfgId);
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFail(int errorCode)
/*     */   {
/* 135 */     SUnlockPetMarkFail proto = new SUnlockPetMarkFail();
/* 136 */     proto.error_code = errorCode;
/* 137 */     OnlineManager.getInstance().sendAtOnce(this.roleId, proto);
/*     */     
/*     */ 
/* 140 */     String logstr = String.format("[petmark]PCUnlockPetMarkReq.onFail@PCUnlockPetMarkReq failed|roleId=%d,uuid=%d,reason=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.itemUuid), Integer.valueOf(errorCode) });
/*     */     
/*     */ 
/* 143 */     GameServer.logger().info(logstr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\main\PCUnlockPetMarkReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */