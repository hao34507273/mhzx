/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.fabaolingqi.event.EquipArtifactArg;
/*    */ import mzm.gsp.fabaolingqi.event.EquipArtifactEventProcedure;
/*    */ import mzm.gsp.fabaolingqi.main.FabaoArtifactInterface;
/*    */ import mzm.gsp.map.main.message.MMH_OnRoleAppearanceChanged;
/*    */ 
/*    */ public class POnEquipFabaoLingqi extends EquipArtifactEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     Map<Integer, Object> changeProps = new HashMap();
/* 15 */     if (((EquipArtifactArg)this.arg).isEquipping)
/*    */     {
/* 17 */       int equipFabaoLingqiCfgid = FabaoArtifactInterface.getEquippedArtifactCfgId(((EquipArtifactArg)this.arg).roleId, true);
/* 18 */       if (equipFabaoLingqiCfgid > 0)
/*    */       {
/* 20 */         changeProps.put(Integer.valueOf(17), Integer.valueOf(equipFabaoLingqiCfgid));
/*    */       }
/*    */     }
/* 23 */     new MMH_OnRoleAppearanceChanged(((EquipArtifactArg)this.arg).roleId, 15, changeProps).execute();
/*    */     
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnEquipFabaoLingqi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */