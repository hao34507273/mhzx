/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.magicmark.event.MagicMarkModelChangeEventProcedure;
/*    */ import mzm.gsp.magicmark.main.MagicMarkInterface;
/*    */ import mzm.gsp.map.main.message.MMH_OnRoleAppearanceChanged;
/*    */ 
/*    */ public class POnRoleMagicMarkModelChangeEvent
/*    */   extends MagicMarkModelChangeEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     long roleid = ((Long)this.arg).longValue();
/* 15 */     Map<Integer, Object> changeProps = new HashMap();
/* 16 */     int magicMarkType = MagicMarkInterface.getEquipMagicMarkType(roleid, true);
/* 17 */     if (magicMarkType > 0)
/*    */     {
/* 19 */       changeProps.put(Integer.valueOf(16), Integer.valueOf(magicMarkType));
/*    */     }
/* 21 */     new MMH_OnRoleAppearanceChanged(roleid, 14, changeProps).execute();
/*    */     
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnRoleMagicMarkModelChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */