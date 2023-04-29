/*    */ package mzm.gsp.pk;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.pk.main.PBuyMoralValue;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CBuyMoralValueReq
/*    */   extends __CBuyMoralValueReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12619784;
/*    */   public int quantity;
/*    */   public long money_num;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleId, new PBuyMoralValue(roleId, this.quantity, this.money_num));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12619784;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CBuyMoralValueReq() {}
/*    */   
/*    */ 
/*    */   public CBuyMoralValueReq(int _quantity_, long _money_num_)
/*    */   {
/* 38 */     this.quantity = _quantity_;
/* 39 */     this.money_num = _money_num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.quantity);
/* 48 */     _os_.marshal(this.money_num);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.quantity = _os_.unmarshal_int();
/* 54 */     this.money_num = _os_.unmarshal_long();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CBuyMoralValueReq)) {
/* 64 */       CBuyMoralValueReq _o_ = (CBuyMoralValueReq)_o1_;
/* 65 */       if (this.quantity != _o_.quantity) return false;
/* 66 */       if (this.money_num != _o_.money_num) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.quantity;
/* 75 */     _h_ += (int)this.money_num;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.quantity).append(",");
/* 83 */     _sb_.append(this.money_num).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CBuyMoralValueReq _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = this.quantity - _o_.quantity;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = Long.signum(this.money_num - _o_.money_num);
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\CBuyMoralValueReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */