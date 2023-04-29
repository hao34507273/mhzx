/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.List;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ class PSaveRoamRoleData extends LogicProcedure
/*    */ {
/*    */   private final String userid;
/*    */   private final long roleid;
/*    */   private final List<Octets> xtables;
/*    */   
/*    */   PSaveRoamRoleData(String userid, long roleid, List<Octets> xtables)
/*    */   {
/* 18 */     this.userid = userid;
/* 19 */     this.roleid = roleid;
/* 20 */     this.xtables = xtables;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     lock(Lockeys.get(User.getTable(), this.userid));
/* 27 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*    */     
/* 29 */     CrossServerManager.unboxRoleXtableData(this.userid, this.roleid, this.xtables);
/*    */     
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\PSaveRoamRoleData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */