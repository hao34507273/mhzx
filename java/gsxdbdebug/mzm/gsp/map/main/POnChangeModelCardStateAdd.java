/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.changemodelcard.event.ChangeModelCardStateAddProcedure;
/*    */ import mzm.gsp.changemodelcard.event.ChangeModelCardStateArg;
/*    */ import mzm.gsp.map.main.message.MMH_OnRoleAppearanceChanged;
/*    */ 
/*    */ public class POnChangeModelCardStateAdd extends ChangeModelCardStateAddProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     long roleid = ((ChangeModelCardStateArg)this.arg).roleId;
/* 14 */     Map<Integer, Object> changeProps = new HashMap();
/* 15 */     changeProps.put(Integer.valueOf(20), Integer.valueOf(((ChangeModelCardStateArg)this.arg).cardCfgId));
/* 16 */     changeProps.put(Integer.valueOf(21), Integer.valueOf(((ChangeModelCardStateArg)this.arg).cardLevel));
/* 17 */     changeProps.put(Integer.valueOf(22), Integer.valueOf(((ChangeModelCardStateArg)this.arg).visible ? 0 : 1));
/* 18 */     new MMH_OnRoleAppearanceChanged(roleid, 18, changeProps).execute();
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnChangeModelCardStateAdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */