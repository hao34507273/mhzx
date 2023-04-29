/*    */ package mzm.gsp.multioccupation.main;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import mzm.gsp.avatar.frame.AvatarFrameMultiOccupationHandler;
/*    */ import mzm.gsp.avatar.main.AvatarSwitchOccupationHandler;
/*    */ import mzm.gsp.fabao.main.LongjingOcpSwitchHandler;
/*    */ import mzm.gsp.fashiondress.main.OcpFashionDressSwitchHandler;
/*    */ import mzm.gsp.fight.main.FightMultiOccupHandler;
/*    */ import mzm.gsp.ocpequip.main.OcpEquipSwitchHandler;
/*    */ import mzm.gsp.role.main.OcpAddPointSwitchHandler;
/*    */ import mzm.gsp.role.multirank.OcpRankHandler;
/*    */ import mzm.gsp.roledye.main.OcpRoleDyeSwitchHandler;
/*    */ import mzm.gsp.shimen.main.ShimeOcpSwitchHandler;
/*    */ import mzm.gsp.skill.main.OcpMenPaiSkillSwitchHandler;
/*    */ import mzm.gsp.superequipment.jewel.main.JewelOcpSwitchHandler;
/*    */ import mzm.gsp.title.main.OcpTitleSwitchHandler;
/*    */ import mzm.gsp.wing.main2.OcpWingSwitchHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class MultiOccupHandlerManager
/*    */ {
/* 26 */   private static LinkedList<MultiOccupHandler> handlers = new LinkedList();
/*    */   
/*    */   private static synchronized void addHandler(MultiOccupHandler handler) {
/* 29 */     handlers.add(handler);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   static void initHandlers()
/*    */   {
/* 36 */     addHandler(new OcpEquipSwitchHandler());
/* 37 */     addHandler(new OcpAddPointSwitchHandler());
/* 38 */     addHandler(new OcpWingSwitchHandler());
/* 39 */     addHandler(new OcpTitleSwitchHandler());
/* 40 */     addHandler(new OcpFashionDressSwitchHandler());
/* 41 */     addHandler(new OcpRoleDyeSwitchHandler());
/* 42 */     addHandler(new OcpMenPaiSkillSwitchHandler());
/* 43 */     addHandler(new OcpRankHandler());
/* 44 */     addHandler(new LongjingOcpSwitchHandler());
/* 45 */     addHandler(new FightMultiOccupHandler());
/* 46 */     addHandler(new ShimeOcpSwitchHandler());
/* 47 */     addHandler(new AvatarSwitchOccupationHandler());
/* 48 */     addHandler(new JewelOcpSwitchHandler());
/* 49 */     addHandler(new AvatarFrameMultiOccupationHandler());
/*    */   }
/*    */   
/*    */   static synchronized LinkedList<MultiOccupHandler> getHandlers() {
/* 53 */     return new LinkedList(handlers);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\multioccupation\main\MultiOccupHandlerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */