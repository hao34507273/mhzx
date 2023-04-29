/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_pvp extends CmdBase {
/*  6 */   private ArrayList<String> name = new ArrayList();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean parse()
/*    */   {
/* 16 */     if (this.m_arguments == null) {
/* 17 */       return false;
/*    */     }
/* 19 */     int index = 0;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 24 */     while (index < this.m_arguments.size())
/*    */     {
/*    */ 
/* 27 */       if (index >= this.m_arguments.size()) {
/* 28 */         return false;
/*    */       }
/* 30 */       this.name.add(this.m_arguments.get(index++));
/*    */     }
/* 32 */     if (index != this.m_arguments.size()) {
/* 33 */       return false;
/*    */     }
/* 35 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 49 */     if (this.name.size() <= 0) {
/* 50 */       return;
/*    */     }
/* 52 */     Long targetId = null;
/* 53 */     targetId = xtable.Name2roleid.select((String)this.name.get(0));
/*    */     
/* 55 */     if (targetId != null) {
/* 56 */       if (this.name.size() > 1) {
/* 57 */         Long targetId2 = null;
/* 58 */         targetId2 = xtable.Name2roleid.select((String)this.name.get(1));
/* 59 */         if (targetId2 != null) {
/* 60 */           mzm.gsp.Role.addRoleProcedure(targetId.longValue(), new mzm.gsp.fight.main.PGM_PVPFight(targetId.longValue(), targetId2.longValue()));
/*    */         }
/*    */       } else {
/* 63 */         mzm.gsp.Role.addRoleProcedure(this.m_gmRole.getRoleid(), new mzm.gsp.fight.main.PGM_PVPFight(this.m_gmRole.getRoleid(), targetId.longValue()));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_pvp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */