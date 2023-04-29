/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.item.confbean.EquipItemCfgConsts;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import xbean.Equipstate;
/*    */ 
/*    */ public class POnRoleLevelUpEquiptip extends mzm.gsp.role.event.RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     int state = 0;
/* 12 */     if (((RoleLevelUpArg)this.arg).newLevel == EquipItemCfgConsts.getInstance().EQUIP_MAKE_OPEN_LEVEL)
/*    */     {
/* 14 */       Equipstate equipstate = getEquipstate();
/* 15 */       equipstate.setState(equipstate.getState() | 0x1);
/* 16 */       state |= equipstate.getState();
/*    */     }
/*    */     
/* 19 */     if (((RoleLevelUpArg)this.arg).newLevel == EquipItemCfgConsts.getInstance().EQUIP_QILIN_OPEN_LEVEL)
/*    */     {
/* 21 */       Equipstate equipstate = getEquipstate();
/* 22 */       equipstate.setState(equipstate.getState() | 0x2);
/* 23 */       state |= equipstate.getState();
/*    */     }
/*    */     
/* 26 */     if (((RoleLevelUpArg)this.arg).newLevel == EquipItemCfgConsts.getInstance().EQUIP_XIHUN_OPEN_LEVEL)
/*    */     {
/* 28 */       Equipstate equipstate = getEquipstate();
/* 29 */       equipstate.setState(equipstate.getState() | 0x4);
/* 30 */       state |= equipstate.getState();
/*    */     }
/* 32 */     if (((RoleLevelUpArg)this.arg).newLevel == EquipItemCfgConsts.getInstance().EQUIP_FUHUN_OPEN_LEVEL)
/*    */     {
/* 34 */       Equipstate equipstate = getEquipstate();
/* 35 */       equipstate.setState(equipstate.getState() | 0x8);
/* 36 */       state |= equipstate.getState();
/*    */     }
/* 38 */     if (state != 0)
/*    */     {
/* 40 */       mzm.gsp.item.SSynEquiptipRes re = new mzm.gsp.item.SSynEquiptipRes();
/* 41 */       re.state = state;
/* 42 */       mzm.gsp.online.main.OnlineManager.getInstance().send(((RoleLevelUpArg)this.arg).roleId, re);
/*    */     }
/*    */     
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   private Equipstate getEquipstate() {
/* 49 */     Equipstate equipstate = xtable.Role2equipstate.get(Long.valueOf(((RoleLevelUpArg)this.arg).roleId));
/* 50 */     if (equipstate == null)
/*    */     {
/* 52 */       equipstate = xbean.Pod.newEquipstate();
/* 53 */       equipstate.setState(0);
/* 54 */       xtable.Role2equipstate.insert(Long.valueOf(((RoleLevelUpArg)this.arg).roleId), equipstate);
/*    */     }
/* 56 */     return equipstate;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\POnRoleLevelUpEquiptip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */