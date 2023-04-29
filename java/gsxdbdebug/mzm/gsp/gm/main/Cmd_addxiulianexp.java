/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.xiulian.main.XiuLianSkillInterface;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_addxiulianexp
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int addexp;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 24 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 26 */     if (this.m_arguments == null) {
/* 27 */       return false;
/*    */     }
/* 29 */     int index = 0;
/*    */     
/* 31 */     if (index >= this.m_arguments.size()) {
/* 32 */       return false;
/*    */     }
/* 34 */     Long targetId = null;
/* 35 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 37 */     if (targetId != null)
/*    */     {
/* 39 */       this.roleId = targetId.longValue();
/* 40 */       index++;
/*    */     }
/*    */     
/* 43 */     if (index >= this.m_arguments.size()) {
/* 44 */       return false;
/*    */     }
/* 46 */     Integer I_addexp = parseInt((String)this.m_arguments.get(index++));
/* 47 */     if (I_addexp == null) {
/* 48 */       return false;
/*    */     }
/* 50 */     this.addexp = I_addexp.intValue();
/*    */     
/* 52 */     if (index != this.m_arguments.size()) {
/* 53 */       return false;
/*    */     }
/* 55 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 64 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 70 */     new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception {
/* 73 */         XiuLianSkillInterface.addXiuLianExp(Cmd_addxiulianexp.this.roleId, Cmd_addxiulianexp.this.addexp, new TLogArg(LogReason.XIULIAN_SKILL_STUDY_GM_ADD, Cmd_addxiulianexp.this.addexp));
/* 74 */         return true;
/*    */       }
/*    */     }.execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_addxiulianexp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */