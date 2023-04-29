/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.genderconvert.event.ActivateGenderConvertArg;
/*    */ import mzm.gsp.genderconvert.event.ActivateGenderConvertProcedure;
/*    */ import mzm.gsp.map.main.message.MMH_PlayerSwitchOccupation;
/*    */ import mzm.gsp.map.main.scene.object.MapRoleInitInfo;
/*    */ 
/*    */ public class POnRoleActivateGenderConvert
/*    */   extends ActivateGenderConvertProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 14 */     long l = ((ActivateGenderConvertArg)this.arg).roleid;
/*    */     
/* 16 */     MapRoleInitInfo localMapRoleInitInfo = new MapRoleInitInfo(l);
/*    */     
/* 18 */     new MMH_PlayerSwitchOccupation(l, localMapRoleInitInfo).execute();
/*    */     
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnRoleActivateGenderConvert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */