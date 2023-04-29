/*    */ package mzm.gsp.mounts.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.mounts.SMountsReplaceProtectPetSuccess;
/*    */ import mzm.gsp.mounts.event.MountsPetPassiveSkillChangeArg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.event.PetFanShengEventArg;
/*    */ import mzm.gsp.pet.event.PetFanShengProcedure;
/*    */ import xbean.MountsInfo;
/*    */ import xbean.Role2MountsInfo;
/*    */ import xtable.Role2mounts;
/*    */ 
/*    */ public class POnPetFanSheng extends PetFanShengProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     long roleId = ((PetFanShengEventArg)this.arg).roleId;
/* 21 */     long oldPetId = ((PetFanShengEventArg)this.arg).oldPetId;
/* 22 */     long newPetId = ((PetFanShengEventArg)this.arg).newPetId;
/*    */     
/* 24 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(roleId);
/* 25 */     lock(xdb.Lockeys.get(xtable.User.getTable(), userId));
/*    */     
/* 27 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(roleId));
/* 28 */     if (xRole2MountsInfo == null)
/*    */     {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     Map.Entry<Integer, xbean.BattleMountsInfo> xBattleMountsInfoEntry = MountsManager.getProtectePetMounts(roleId, oldPetId, xRole2MountsInfo);
/*    */     
/* 35 */     if (xBattleMountsInfoEntry == null)
/*    */     {
/* 37 */       return false;
/*    */     }
/* 39 */     xbean.BattleMountsInfo xBattleMountsInfo = (xbean.BattleMountsInfo)xBattleMountsInfoEntry.getValue();
/* 40 */     long mountsId = xBattleMountsInfo.getMounts_id();
/*    */     
/* 42 */     MountsInfo xMountsInfo = (MountsInfo)xRole2MountsInfo.getMounts_info_map().get(Long.valueOf(mountsId));
/* 43 */     if (xMountsInfo == null)
/*    */     {
/* 45 */       return false;
/*    */     }
/* 47 */     List<Long> xBattleMountsProtectPetList = xBattleMountsInfo.getProtect_pet_id_list();
/* 48 */     int protectIndex = xBattleMountsProtectPetList.indexOf(Long.valueOf(oldPetId));
/* 49 */     if (protectIndex >= 0)
/*    */     {
/* 51 */       xBattleMountsProtectPetList.set(protectIndex, Long.valueOf(newPetId));
/*    */     }
/*    */     
/* 54 */     SMountsReplaceProtectPetSuccess sMountsReplaceProtectPetSuccess = new SMountsReplaceProtectPetSuccess();
/* 55 */     sMountsReplaceProtectPetSuccess.cell_id = ((Integer)xBattleMountsInfoEntry.getKey()).intValue();
/* 56 */     mzm.gsp.mounts.BattleMountsInfo battleMountsInfo = sMountsReplaceProtectPetSuccess.battle_mounts_info;
/* 57 */     battleMountsInfo.mounts_id = xBattleMountsInfo.getMounts_id();
/* 58 */     battleMountsInfo.is_chief_battle_mounts = (xRole2MountsInfo.getCurrent_chief_battle_mounts() == ((Integer)xBattleMountsInfoEntry.getKey()).intValue() ? 1 : 0);
/*    */     
/* 60 */     battleMountsInfo.protect_pet_id_list.addAll(xBattleMountsProtectPetList);
/*    */     
/* 62 */     OnlineManager.getInstance().send(roleId, sMountsReplaceProtectPetSuccess);
/*    */     
/* 64 */     MountsManager.triggerMountsPetPassiveSkillChangeEvent(new MountsPetPassiveSkillChangeArg(roleId, newPetId));
/*    */     
/*    */ 
/* 67 */     MountsManager.tlogMountsProtectPet(userId, roleId, mountsId, xMountsInfo.getMounts_cfg_id(), xMountsInfo.getMounts_rank(), oldPetId, 0, protectIndex);
/*    */     
/*    */ 
/* 70 */     MountsManager.tlogMountsProtectPet(userId, roleId, mountsId, xMountsInfo.getMounts_cfg_id(), xMountsInfo.getMounts_rank(), newPetId, 1, protectIndex);
/*    */     
/*    */ 
/* 73 */     GameServer.logger().info(String.format("[mounts]POnPetFanSheng.processImp@replace mounts protect pet success|role_id=%d|old_pet_id=%d|new_pet_id=%d|now_protect_pet_list=%s", new Object[] { Long.valueOf(roleId), Long.valueOf(oldPetId), Long.valueOf(newPetId), xBattleMountsProtectPetList.toString() }));
/*    */     
/*    */ 
/*    */ 
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\POnPetFanSheng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */