/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.marriage.SSynMarrageParadeAttackRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.MarriageParade;
/*    */ import xbean.MarriageParades;
/*    */ 
/*    */ public class PMarriageParadeAttack extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int marriageRoleType;
/*    */   
/*    */   public PMarriageParadeAttack(long roleid, int marriageRoleType)
/*    */   {
/* 16 */     this.roleid = roleid;
/* 17 */     this.marriageRoleType = marriageRoleType;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 22 */     MarriageParades xMarriageParades = xtable.Marriageparade.get(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 23 */     if ((xMarriageParades == null) || (xMarriageParades.getMarriageparades().size() <= 0)) {
/* 24 */       MarriageManager.sendAttackParadeError(this.roleid, 102, new String[0]);
/* 25 */       return false;
/*    */     }
/* 27 */     SSynMarrageParadeAttackRes marrageParadeAttackRes = new SSynMarrageParadeAttackRes();
/* 28 */     marrageParadeAttackRes.paraderoletype = this.marriageRoleType;
/* 29 */     MarriageParade xMarriageParade = (MarriageParade)xMarriageParades.getMarriageparades().get(0);
/* 30 */     boolean isAttacked = false;
/* 31 */     if (this.marriageRoleType == 0) {
/* 32 */       isAttacked = xMarriageParade.getBridefightstatus() > 0;
/*    */     } else {
/* 34 */       isAttacked = xMarriageParade.getGroomfightstatus() > 0;
/*    */     }
/* 36 */     if (isAttacked) {
/* 37 */       marrageParadeAttackRes.attackedstate = 1;
/*    */     } else {
/* 39 */       marrageParadeAttackRes.attackedstate = 0;
/*    */     }
/* 41 */     OnlineManager.getInstance().send(this.roleid, marrageParadeAttackRes);
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\PMarriageParadeAttack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */