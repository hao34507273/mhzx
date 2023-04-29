/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.Pgm_Wabao;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_wabao
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int awardpoolid;
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
/* 43 */     Integer I_awardpoolid = parseInt((String)this.m_arguments.get(index++));
/* 44 */     if (I_awardpoolid == null) {
/* 45 */       return false;
/*    */     }
/* 47 */     this.awardpoolid = I_awardpoolid.intValue();
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
/* 68 */     new Pgm_Wabao(this.awardpoolid, this.roleId).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_wabao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */