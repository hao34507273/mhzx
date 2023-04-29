/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.item.event.GainItemeArg;
/*    */ import mzm.gsp.item.main.ItemOperateResult;
/*    */ import mzm.gsp.item.main.PetEquipmentItem;
/*    */ import mzm.gsp.petequip.confbean.SPetEquipItem;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ 
/*    */ public class POnAddPetEquipItemEvent extends mzm.gsp.item.event.GainItemEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     Map<Integer, Set<Long>> changeItemUuids = ((GainItemeArg)this.arg).itemOperateResult.getChangedItemId2Uuids();
/*    */     
/* 21 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 22 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(((GainItemeArg)this.arg).roleId);
/*    */     
/* 24 */     for (Map.Entry<Integer, Integer> entry : ((GainItemeArg)this.arg).itemOperateResult.getItemChangeMap().entrySet()) {
/* 25 */       int itemCfgid = ((Integer)entry.getKey()).intValue();
/* 26 */       SPetEquipItem sPetEquipItem = SPetEquipItem.get(itemCfgid);
/* 27 */       if (sPetEquipItem != null) {
/* 28 */         Set<Long> uuids = (Set)changeItemUuids.get(Integer.valueOf(itemCfgid));
/* 29 */         for (i$ = uuids.iterator(); i$.hasNext();) { long uuid = ((Long)i$.next()).longValue();
/* 30 */           PetEquipmentItem petEquipmentItem = (PetEquipmentItem)mzm.gsp.item.main.ItemInterface.getItemByUuid(((GainItemeArg)this.arg).roleId, uuid);
/* 31 */           if (petEquipmentItem != null) {
/* 32 */             int skillid1 = 0;
/* 33 */             int skillid2 = 0;
/* 34 */             int proptype1 = petEquipmentItem.getStoreAttriAType();
/* 35 */             int prop1Num = petEquipmentItem.getStoreAttriAValue();
/* 36 */             int proptype2 = petEquipmentItem.getStoreAttriBType();
/* 37 */             int prop2Num = petEquipmentItem.getStoreAttriBValue();
/* 38 */             if (petEquipmentItem.getSkills().size() > 0) {
/* 39 */               skillid1 = ((Integer)petEquipmentItem.getSkills().get(0)).intValue();
/*    */             }
/* 41 */             if (petEquipmentItem.getSkills().size() > 1) {
/* 42 */               skillid2 = ((Integer)petEquipmentItem.getSkills().get(1)).intValue();
/*    */             }
/* 44 */             TLogManager.getInstance().addLog(((GainItemeArg)this.arg).roleId, "PetGetEquipTLog", PetManager.createTLog(new Object[] { vGameIP, userid, Long.valueOf(((GainItemeArg)this.arg).roleId), petEquipmentItem.getFirstUuid(), Integer.valueOf(petEquipmentItem.getCfgId()), Integer.valueOf(skillid1), Integer.valueOf(skillid2), Integer.valueOf(proptype1), Integer.valueOf(prop1Num), Integer.valueOf(proptype2), Integer.valueOf(prop2Num) }));
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     Iterator i$;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 62 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\POnAddPetEquipItemEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */