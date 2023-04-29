/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.map.main.message.MMH_OnRoleAppearanceChanged;
/*    */ import mzm.gsp.pk.event.MoralValueChangeArg;
/*    */ import mzm.gsp.pk.event.MoralValueChangedProcedure;
/*    */ 
/*    */ public class POnMoralValueChanged extends MoralValueChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     long roleid = ((MoralValueChangeArg)this.arg).roleId;
/* 14 */     Map<Integer, Object> changeProps = new HashMap();
/* 15 */     changeProps.put(Integer.valueOf(19), Integer.valueOf(((MoralValueChangeArg)this.arg).newValue));
/* 16 */     new MMH_OnRoleAppearanceChanged(roleid, 17, changeProps).execute();
/*    */     
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnMoralValueChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */