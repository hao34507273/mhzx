/*    */ package mzm.gsp.genderconvert.main;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import mzm.gsp.avatar.frame.AvatarFrameGenderConvertHandler;
/*    */ import mzm.gsp.avatar.main.AvatarGenderConvertHandler;
/*    */ import mzm.gsp.fashiondress.main.GenderFashionDressSwitchHandler;
/*    */ import mzm.gsp.ocpequip.main.GenderEquipSwitchHandler;
/*    */ import mzm.gsp.roledye.main.GanderRoleDyeSwitchHandler;
/*    */ 
/*    */ class GenderConvertHandlerManager
/*    */ {
/* 12 */   private static LinkedList<GenderConvertHandler> handlers = new LinkedList();
/*    */   
/*    */   private static synchronized void addHandler(GenderConvertHandler paramGenderConvertHandler)
/*    */   {
/* 16 */     handlers.add(paramGenderConvertHandler);
/*    */   }
/*    */   
/*    */   static void initHandlers()
/*    */   {
/* 21 */     addHandler(new GenderEquipSwitchHandler());
/* 22 */     addHandler(new GenderFashionDressSwitchHandler());
/* 23 */     addHandler(new GanderRoleDyeSwitchHandler());
/* 24 */     addHandler(new AvatarGenderConvertHandler());
/* 25 */     addHandler(new AvatarFrameGenderConvertHandler());
/*    */   }
/*    */   
/*    */   static synchronized LinkedList<GenderConvertHandler> getHandlers()
/*    */   {
/* 30 */     return new LinkedList(handlers);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genderconvert\main\GenderConvertHandlerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */