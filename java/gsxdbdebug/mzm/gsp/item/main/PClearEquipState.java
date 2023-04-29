/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import xbean.Equipstate;
/*    */ 
/*    */ public class PClearEquipState extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int state;
/*    */   
/*    */   public PClearEquipState(long roleid, int state) {
/* 11 */     this.roleid = roleid;
/* 12 */     this.state = (state & 0xF);
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     Equipstate equipstate = xtable.Role2equipstate.get(Long.valueOf(this.roleid));
/* 18 */     if ((equipstate == null) || (equipstate.getState() == 0))
/*    */     {
/* 20 */       return false;
/*    */     }
/* 22 */     equipstate.setState(equipstate.getState() & this.state);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PClearEquipState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */