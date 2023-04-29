/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import xbean.Gang;
/*    */ 
/*    */ public abstract class GangProcedure<T extends xio.Protocol> extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   protected T protocol;
/*    */   protected long roleId;
/*    */   
/*    */   public GangProcedure(T protocol)
/*    */   {
/* 12 */     this.protocol = protocol;
/* 13 */     this.roleId = mzm.gsp.Role.getRoleId(protocol);
/* 14 */     if (this.roleId < 0L) {
/* 15 */       return;
/*    */     }
/* 17 */     mzm.gsp.Role.addRoleProcedure(this.roleId, this);
/*    */   }
/*    */   
/*    */   protected final boolean processImp() throws Exception
/*    */   {
/* 22 */     return doProcess(this.roleId, this.protocol);
/*    */   }
/*    */   
/*    */   protected abstract boolean doProcess(long paramLong, T paramT);
/*    */   
/*    */   protected boolean isInGang(Gang xGang, long roleId) {
/* 28 */     return (xGang != null) && (GangManager.isInGang(xGang, roleId));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\GangProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */