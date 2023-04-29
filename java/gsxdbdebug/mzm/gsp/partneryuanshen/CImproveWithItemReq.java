/*    */ package mzm.gsp.partneryuanshen;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.partneryuanshen.main.PImproveYuanshen;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CImproveWithItemReq
/*    */   extends __CImproveWithItemReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12621060;
/*    */   public int position;
/*    */   public int property_num;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleId, new PImproveYuanshen(roleId, this.position, this.property_num));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12621060;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CImproveWithItemReq() {}
/*    */   
/*    */ 
/*    */   public CImproveWithItemReq(int _position_, int _property_num_)
/*    */   {
/* 39 */     this.position = _position_;
/* 40 */     this.property_num = _property_num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.position);
/* 49 */     _os_.marshal(this.property_num);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.position = _os_.unmarshal_int();
/* 55 */     this.property_num = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CImproveWithItemReq)) {
/* 65 */       CImproveWithItemReq _o_ = (CImproveWithItemReq)_o1_;
/* 66 */       if (this.position != _o_.position) return false;
/* 67 */       if (this.property_num != _o_.property_num) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.position;
/* 76 */     _h_ += this.property_num;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.position).append(",");
/* 84 */     _sb_.append(this.property_num).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CImproveWithItemReq _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.position - _o_.position;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.property_num - _o_.property_num;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partneryuanshen\CImproveWithItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */