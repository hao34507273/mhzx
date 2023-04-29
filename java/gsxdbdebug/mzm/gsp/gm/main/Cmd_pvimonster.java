/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.fight.confbean.SFightCfg;
/*    */ import mzm.gsp.fight.main.PGM_PVIMonster;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ public class Cmd_pvimonster
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int fightcfg;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 21 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 23 */     if (this.m_arguments == null) {
/* 24 */       return false;
/*    */     }
/* 26 */     int index = 0;
/*    */     
/* 28 */     if (index >= this.m_arguments.size()) {
/* 29 */       return false;
/*    */     }
/* 31 */     Long targetId = null;
/* 32 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 34 */     if (targetId != null)
/*    */     {
/* 36 */       this.roleId = targetId.longValue();
/* 37 */       index++;
/*    */     }
/*    */     
/* 40 */     if (index >= this.m_arguments.size()) {
/* 41 */       return false;
/*    */     }
/* 43 */     Integer I_fightcfg = parseInt((String)this.m_arguments.get(index++));
/* 44 */     if (I_fightcfg == null) {
/* 45 */       return false;
/*    */     }
/* 47 */     this.fightcfg = I_fightcfg.intValue();
/*    */     
/* 49 */     if (index != this.m_arguments.size()) {
/* 50 */       return false;
/*    */     }
/* 52 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 61 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 68 */     int fightcfg = 120400000;
/* 69 */     Iterator i$ = SFightCfg.getAll().values().iterator(); if (i$.hasNext()) { SFightCfg sFightCfg = (SFightCfg)i$.next();
/* 70 */       fightcfg = sFightCfg.id;
/*    */     }
/*    */     
/* 73 */     fightcfg = fightcfg - fightcfg % 100000 + this.fightcfg;
/* 74 */     Role.addRoleProcedure(this.roleId, new PGM_PVIMonster(fightcfg, this.roleId));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_pvimonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */