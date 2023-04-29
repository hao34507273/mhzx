/*    */ package mzm.gsp.drawcarnival;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.drawcarnival.confbean.SDrawCarnivalConsts;
/*    */ import mzm.gsp.drawcarnival.main.DrawCarnivalOneByOneManager;
/*    */ import mzm.gsp.item.main.POfferLotteryResult;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CDrawAwardFinishReq
/*    */   extends __CDrawAwardFinishReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12630021;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId <= 0L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     DrawCarnivalOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(SDrawCarnivalConsts.getInstance().ACTIVITY_ID), new POfferLotteryResult(roleId, 15));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 34 */     return 12630021;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean _validator_()
/*    */   {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     if (!_validator_()) {
/* 51 */       throw new VerifyError("validator failed");
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof CDrawAwardFinishReq)) {
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 65 */     int _h_ = 0;
/* 66 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 70 */     StringBuilder _sb_ = new StringBuilder();
/* 71 */     _sb_.append("(");
/* 72 */     _sb_.append(")");
/* 73 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CDrawAwardFinishReq _o_) {
/* 77 */     if (_o_ == this) return 0;
/* 78 */     int _c_ = 0;
/* 79 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\CDrawAwardFinishReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */