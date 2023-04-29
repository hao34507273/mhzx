/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.fabao.event.FabaoDisplayArg;
/*    */ import mzm.gsp.fabao.event.FabaoDisplayProcedure;
/*    */ import mzm.gsp.map.main.message.MMH_OnRoleAppearanceChanged;
/*    */ 
/*    */ public class POnFabaoDisplay extends FabaoDisplayProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     Map<Integer, Object> changeProps = new java.util.HashMap();
/* 13 */     if (((FabaoDisplayArg)this.arg).fabaoid > 0) {
/* 14 */       changeProps.put(Integer.valueOf(5), Integer.valueOf(((FabaoDisplayArg)this.arg).fabaoid));
/*    */     }
/* 16 */     new MMH_OnRoleAppearanceChanged(((FabaoDisplayArg)this.arg).roleid, 5, changeProps).execute();
/*    */     
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnFabaoDisplay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */