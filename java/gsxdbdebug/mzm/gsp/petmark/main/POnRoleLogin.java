/*    */ package mzm.gsp.petmark.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.petmark.SSynPetMarkInfo;
/*    */ import xbean.Role2PetMarkInfo;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/*    */ 
/* 17 */     Role2PetMarkInfo xRole2PetMarkInfo = PetMarkManager.getRolePetMarkInfo(roleId);
/*    */     
/* 19 */     SSynPetMarkInfo sSynPetMarkInfo = new SSynPetMarkInfo();
/* 20 */     for (Map.Entry<Long, xbean.PetMarkInfo> entry : xRole2PetMarkInfo.getPetmarkid2info().entrySet())
/*    */     {
/* 22 */       xbean.PetMarkInfo xPetMarkInfo = (xbean.PetMarkInfo)entry.getValue();
/* 23 */       mzm.gsp.petmark.PetMarkInfo petMarkInfo = new mzm.gsp.petmark.PetMarkInfo();
/* 24 */       petMarkInfo.pet_mark_cfg_id = xPetMarkInfo.getPet_mark_cfg_id();
/* 25 */       petMarkInfo.level = xPetMarkInfo.getLevel();
/* 26 */       petMarkInfo.exp = xPetMarkInfo.getExp();
/* 27 */       petMarkInfo.pet_id = xPetMarkInfo.getPet_id();
/* 28 */       sSynPetMarkInfo.pet_mark_info_map.put(entry.getKey(), petMarkInfo);
/* 29 */       if (xPetMarkInfo.getPet_id() > 0L)
/*    */       {
/* 31 */         sSynPetMarkInfo.pet_mark_equip_map.put(Long.valueOf(xPetMarkInfo.getPet_id()), entry.getKey());
/*    */       }
/*    */     }
/*    */     
/* 35 */     OnlineManager.getInstance().send(roleId, sSynPetMarkInfo);
/*    */     
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */