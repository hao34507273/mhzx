/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.PGM_BanTrade;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_bantrade
/*    */   extends CmdBase
/*    */ {
/*    */   private int itemIdOrPetCfgId;
/*    */   private int tradetype;
/*    */   private int state;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 20 */     if (this.m_arguments == null) {
/* 21 */       return false;
/*    */     }
/* 23 */     int index = 0;
/*    */     
/* 25 */     if (index >= this.m_arguments.size()) {
/* 26 */       return false;
/*    */     }
/* 28 */     Integer I_itemIdOrPetCfgId = parseInt((String)this.m_arguments.get(index++));
/* 29 */     if (I_itemIdOrPetCfgId == null) {
/* 30 */       return false;
/*    */     }
/* 32 */     this.itemIdOrPetCfgId = I_itemIdOrPetCfgId.intValue();
/*    */     
/* 34 */     if (index >= this.m_arguments.size()) {
/* 35 */       return false;
/*    */     }
/* 37 */     Integer I_tradetype = parseInt((String)this.m_arguments.get(index++));
/* 38 */     if (I_tradetype == null) {
/* 39 */       return false;
/*    */     }
/* 41 */     this.tradetype = I_tradetype.intValue();
/*    */     
/* 43 */     if (index >= this.m_arguments.size()) {
/* 44 */       return false;
/*    */     }
/* 46 */     Integer I_state = parseInt((String)this.m_arguments.get(index++));
/* 47 */     if (I_state == null) {
/* 48 */       return false;
/*    */     }
/* 50 */     this.state = I_state.intValue();
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
/*    */ 
/*    */   protected void run()
/*    */   {
/* 71 */     new PGM_BanTrade(this.m_gmRole.getRoleid(), this.itemIdOrPetCfgId, this.tradetype, this.state).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_bantrade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */