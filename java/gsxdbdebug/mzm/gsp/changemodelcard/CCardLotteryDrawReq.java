/*    */ package mzm.gsp.changemodelcard;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.changemodelcard.main.PCCardLotteryDrawReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CCardLotteryDrawReq
/*    */   extends __CCardLotteryDrawReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12624392;
/*    */   public static final int ONE_LOTTERY = 1;
/*    */   public static final int TEN_LOTTERY = 10;
/*    */   public int lottery_type;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId <= 0L)
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     Role.addRoleProcedure(roleId, new PCCardLotteryDrawReq(roleId, this.lottery_type));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 33 */     return 12624392;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CCardLotteryDrawReq() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public CCardLotteryDrawReq(int _lottery_type_)
/*    */   {
/* 45 */     this.lottery_type = _lottery_type_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 49 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 53 */     _os_.marshal(this.lottery_type);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.lottery_type = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CCardLotteryDrawReq)) {
/* 68 */       CCardLotteryDrawReq _o_ = (CCardLotteryDrawReq)_o1_;
/* 69 */       if (this.lottery_type != _o_.lottery_type) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.lottery_type;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.lottery_type).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CCardLotteryDrawReq _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.lottery_type - _o_.lottery_type;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\CCardLotteryDrawReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */