/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.chivalry.main.ChivalryInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_addchivalry
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int gainType;
/*    */   private int addValue;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 25 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 27 */     if (this.m_arguments == null) {
/* 28 */       return false;
/*    */     }
/* 30 */     int index = 0;
/*    */     
/* 32 */     if (index >= this.m_arguments.size()) {
/* 33 */       return false;
/*    */     }
/* 35 */     Long targetId = null;
/* 36 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 38 */     if (targetId != null)
/*    */     {
/* 40 */       this.roleId = targetId.longValue();
/* 41 */       index++;
/*    */     }
/*    */     
/* 44 */     if (index >= this.m_arguments.size()) {
/* 45 */       return false;
/*    */     }
/* 47 */     Integer I_gainType = parseInt((String)this.m_arguments.get(index++));
/* 48 */     if (I_gainType == null) {
/* 49 */       return false;
/*    */     }
/* 51 */     this.gainType = I_gainType.intValue();
/*    */     
/* 53 */     if (index >= this.m_arguments.size()) {
/* 54 */       return false;
/*    */     }
/* 56 */     Integer I_addValue = parseInt((String)this.m_arguments.get(index++));
/* 57 */     if (I_addValue == null) {
/* 58 */       return false;
/*    */     }
/* 60 */     this.addValue = I_addValue.intValue();
/*    */     
/* 62 */     if (index != this.m_arguments.size()) {
/* 63 */       return false;
/*    */     }
/* 65 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 74 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 80 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 86 */         int num = ChivalryInterface.addRoleChivalry(Cmd_addchivalry.this.roleId, Cmd_addchivalry.this.addValue, Cmd_addchivalry.this.gainType, new TLogArg(LogReason.GM_ADD), true);
/* 87 */         GmManager.getInstance().sendResultToGM(Cmd_addchivalry.this.roleId, String.format("GM增加侠义值%d点", new Object[] { Integer.valueOf(num) }));
/* 88 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_addchivalry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */