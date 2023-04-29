/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.changemodelcard.event.ChangeModelCardStateArg;
/*    */ import mzm.gsp.changemodelcard.event.ChangeModelCardStateRemoveProcedure;
/*    */ import mzm.gsp.map.main.message.MMH_OnRoleAppearanceChanged;
/*    */ 
/*    */ public class POnChangeModelCardStateRemove extends ChangeModelCardStateRemoveProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     long roleid = ((ChangeModelCardStateArg)this.arg).roleId;
/* 14 */     Map<Integer, Object> changeProps = new HashMap();
/* 15 */     new MMH_OnRoleAppearanceChanged(roleid, 18, changeProps).execute();
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnChangeModelCardStateRemove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */