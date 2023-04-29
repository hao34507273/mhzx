/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import mzm.gsp.crossserver.main.RoamType;
/*    */ import mzm.gsp.online.main.LoginManager;
/*    */ import xbean.UserRoamedInfo;
/*    */ import xdb.Lockeys;
/*    */ 
/*    */ public class PPointRaceReturnSourceServer extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long worldid;
/*    */   private final String userid;
/*    */   private final long roleid;
/*    */   
/*    */   PPointRaceReturnSourceServer(long worldid, String userid, long roleid)
/*    */   {
/* 16 */     this.worldid = worldid;
/* 17 */     this.userid = userid;
/* 18 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     lock(Lockeys.get(xtable.User.getTable(), this.userid));
/* 25 */     lock(Lockeys.get(xtable.Basic.getTable(), Long.valueOf(this.roleid)));
/*    */     
/* 27 */     UserRoamedInfo xUserRoamedInfo = xtable.User2roamedinfo.get(this.userid);
/* 28 */     if ((xUserRoamedInfo == null) || (xUserRoamedInfo.getRoam_type() != RoamType.CROSS_BATTLE_POINT.ordinal()) || (xUserRoamedInfo.getInstanceid() != this.worldid))
/*    */     {
/*    */ 
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     xtable.User2roamedinfo.remove(this.userid);
/*    */     
/* 36 */     LoginManager.getInstance().onReturnOrigianServer(this.userid, this.roleid);
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PPointRaceReturnSourceServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */