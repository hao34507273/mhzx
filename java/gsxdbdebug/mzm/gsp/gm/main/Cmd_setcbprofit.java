/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.crossbattle.bet.PGM_SetCrossBattleBetProfit;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_setcbprofit
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int activity_cfg_id;
/*    */   private long profit;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 20 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 22 */     if (this.m_arguments == null) {
/* 23 */       return false;
/*    */     }
/* 25 */     int index = 0;
/*    */     
/* 27 */     if (index >= this.m_arguments.size()) {
/* 28 */       return false;
/*    */     }
/* 30 */     Long targetId = null;
/* 31 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 33 */     if (targetId != null)
/*    */     {
/* 35 */       this.roleId = targetId.longValue();
/* 36 */       index++;
/*    */     }
/*    */     
/* 39 */     if (index >= this.m_arguments.size()) {
/* 40 */       return false;
/*    */     }
/* 42 */     Integer I_activity_cfg_id = parseInt((String)this.m_arguments.get(index++));
/* 43 */     if (I_activity_cfg_id == null) {
/* 44 */       return false;
/*    */     }
/* 46 */     this.activity_cfg_id = I_activity_cfg_id.intValue();
/*    */     
/* 48 */     if (index >= this.m_arguments.size()) {
/* 49 */       return false;
/*    */     }
/* 51 */     Long L_profit = parseLong((String)this.m_arguments.get(index++));
/* 52 */     if (L_profit == null)
/* 53 */       return false;
/* 54 */     this.profit = L_profit.longValue();
/*    */     
/* 56 */     if (index != this.m_arguments.size()) {
/* 57 */       return false;
/*    */     }
/* 59 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 67 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 73 */     new PGM_SetCrossBattleBetProfit(this.m_gmRole.getRoleid(), this.roleId, this.activity_cfg_id, this.profit).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_setcbprofit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */