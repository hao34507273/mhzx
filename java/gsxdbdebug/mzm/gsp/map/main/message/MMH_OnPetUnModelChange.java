/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.map.MapModelInfo;
/*    */ import mzm.gsp.map.SSyncRoleModelChange;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_OnPetUnModelChange extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/*    */   private final long petid;
/*    */   
/*    */   public MMH_OnPetUnModelChange(long roleid, long petid)
/*    */   {
/* 15 */     this.roleid = roleid;
/* 16 */     this.petid = petid;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 22 */     MapRole role = mzm.gsp.map.main.MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 23 */     if (role == null)
/*    */     {
/* 25 */       return;
/*    */     }
/*    */     
/* 28 */     MapModelInfo petModelInfo = role.getPetModel();
/* 29 */     if (petModelInfo == null)
/*    */     {
/* 31 */       return;
/*    */     }
/*    */     
/* 34 */     if (petModelInfo.id != this.petid)
/*    */     {
/* 36 */       return;
/*    */     }
/*    */     
/* 39 */     petModelInfo.model.extramap.remove(Integer.valueOf(22));
/* 40 */     petModelInfo.model.extramap.remove(Integer.valueOf(23));
/* 41 */     petModelInfo.model.extramap.remove(Integer.valueOf(11));
/*    */     
/* 43 */     role.updatePetModelCache();
/*    */     
/*    */ 
/* 46 */     if (role.isInTeam())
/*    */     {
/* 48 */       return;
/*    */     }
/*    */     
/* 51 */     SSyncRoleModelChange syncRoleModelChange = new SSyncRoleModelChange();
/* 52 */     syncRoleModelChange.roleid = this.roleid;
/* 53 */     syncRoleModelChange.intpropmap.put(Integer.valueOf(28), Integer.valueOf(0));
/* 54 */     syncRoleModelChange.intpropmap.put(Integer.valueOf(29), Integer.valueOf(0));
/* 55 */     syncRoleModelChange.intpropmap.put(Integer.valueOf(43), Integer.valueOf(0));
/* 56 */     role.broadcastProtocolIncludeSelf(syncRoleModelChange);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_OnPetUnModelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */