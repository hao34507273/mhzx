/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.map.MapModelInfo;
/*    */ import mzm.gsp.map.SSyncRoleModelChange;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ import mzm.gsp.pubdata.ModelInfo;
/*    */ 
/*    */ public class MMH_OnPetModelChange extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/*    */   private final long petid;
/*    */   private final int exteriorId;
/*    */   private final int exteriorColorId;
/*    */   private final int outlookId;
/*    */   
/*    */   public MMH_OnPetModelChange(long roleid, long petid, int exteriorId, int exteriorColorId, int outlookId)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.petid = petid;
/* 21 */     this.exteriorId = exteriorId;
/* 22 */     this.exteriorColorId = exteriorColorId;
/* 23 */     this.outlookId = outlookId;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 29 */     MapRole role = mzm.gsp.map.main.MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 30 */     if (role == null)
/*    */     {
/* 32 */       return;
/*    */     }
/*    */     
/* 35 */     MapModelInfo petModelInfo = role.getPetModel();
/* 36 */     if (petModelInfo == null)
/*    */     {
/* 38 */       return;
/*    */     }
/*    */     
/* 41 */     if (petModelInfo.id != this.petid)
/*    */     {
/* 43 */       return;
/*    */     }
/*    */     
/* 46 */     petModelInfo.model.extramap.put(Integer.valueOf(22), Integer.valueOf(this.exteriorId));
/* 47 */     petModelInfo.model.extramap.put(Integer.valueOf(23), Integer.valueOf(this.exteriorColorId));
/* 48 */     petModelInfo.model.extramap.put(Integer.valueOf(11), Integer.valueOf(this.outlookId));
/*    */     
/* 50 */     role.updatePetModelCache();
/*    */     
/*    */ 
/* 53 */     if (role.isInTeam())
/*    */     {
/* 55 */       return;
/*    */     }
/*    */     
/* 58 */     SSyncRoleModelChange syncRoleModelChange = new SSyncRoleModelChange();
/* 59 */     syncRoleModelChange.roleid = this.roleid;
/* 60 */     syncRoleModelChange.intpropmap.put(Integer.valueOf(28), Integer.valueOf(this.exteriorId));
/* 61 */     syncRoleModelChange.intpropmap.put(Integer.valueOf(29), Integer.valueOf(this.exteriorColorId));
/* 62 */     syncRoleModelChange.intpropmap.put(Integer.valueOf(43), Integer.valueOf(this.outlookId));
/* 63 */     role.broadcastProtocolIncludeSelf(syncRoleModelChange);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_OnPetModelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */