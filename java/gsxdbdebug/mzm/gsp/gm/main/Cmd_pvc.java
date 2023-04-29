/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_pvc extends CmdBase {
/*    */   private int pvcCfgid;
/*  7 */   private ArrayList<String> name = new ArrayList();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean parse()
/*    */   {
/* 17 */     if (this.m_arguments == null) {
/* 18 */       return false;
/*    */     }
/* 20 */     int index = 0;
/*    */     
/* 22 */     if (index >= this.m_arguments.size()) {
/* 23 */       return false;
/*    */     }
/* 25 */     Integer I_pvcCfgid = parseInt((String)this.m_arguments.get(index++));
/* 26 */     if (I_pvcCfgid == null) {
/* 27 */       return false;
/*    */     }
/* 29 */     this.pvcCfgid = I_pvcCfgid.intValue();
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 34 */     while (index < this.m_arguments.size())
/*    */     {
/*    */ 
/* 37 */       if (index >= this.m_arguments.size()) {
/* 38 */         return false;
/*    */       }
/* 40 */       this.name.add(this.m_arguments.get(index++));
/*    */     }
/* 42 */     if (index != this.m_arguments.size()) {
/* 43 */       return false;
/*    */     }
/* 45 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 53 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 59 */     if (this.name.size() <= 0) {
/* 60 */       return;
/*    */     }
/* 62 */     Long targetId = null;
/* 63 */     targetId = xtable.Name2roleid.select((String)this.name.get(0));
/*    */     
/* 65 */     if (targetId != null) {
/* 66 */       if (this.name.size() > 1) {
/* 67 */         Long targetId2 = null;
/* 68 */         targetId2 = xtable.Name2roleid.select((String)this.name.get(1));
/* 69 */         if (targetId2 != null) {
/* 70 */           mzm.gsp.Role.addRoleProcedure(targetId.longValue(), new mzm.gsp.fight.main.PGM_PVCFight(targetId.longValue(), targetId2.longValue(), this.pvcCfgid));
/*    */         }
/*    */       }
/*    */       else {
/* 74 */         mzm.gsp.Role.addRoleProcedure(this.m_gmRole.getRoleid(), new mzm.gsp.fight.main.PGM_PVCFight(this.m_gmRole.getRoleid(), targetId.longValue(), this.pvcCfgid));
/*    */       }
/*    */     }
/*    */     else {
/* 78 */       mzm.gsp.Role.addRoleProcedure(this.m_gmRole.getRoleid(), new mzm.gsp.fight.main.PGM_PVCFight(this.m_gmRole.getRoleid(), 0L, this.pvcCfgid));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_pvc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */