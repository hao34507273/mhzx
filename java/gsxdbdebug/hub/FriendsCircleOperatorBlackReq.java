/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class FriendsCircleOperatorBlackReq
/*    */   implements Marshal, Comparable<FriendsCircleOperatorBlackReq>
/*    */ {
/*    */   public long active_role_id;
/*    */   public long blacked_role_id;
/*    */   public int operator;
/*    */   
/*    */   public FriendsCircleOperatorBlackReq() {}
/*    */   
/*    */   public FriendsCircleOperatorBlackReq(long _active_role_id_, long _blacked_role_id_, int _operator_)
/*    */   {
/* 19 */     this.active_role_id = _active_role_id_;
/* 20 */     this.blacked_role_id = _blacked_role_id_;
/* 21 */     this.operator = _operator_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.active_role_id);
/* 30 */     _os_.marshal(this.blacked_role_id);
/* 31 */     _os_.marshal(this.operator);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     this.active_role_id = _os_.unmarshal_long();
/* 37 */     this.blacked_role_id = _os_.unmarshal_long();
/* 38 */     this.operator = _os_.unmarshal_int();
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof FriendsCircleOperatorBlackReq)) {
/* 45 */       FriendsCircleOperatorBlackReq _o_ = (FriendsCircleOperatorBlackReq)_o1_;
/* 46 */       if (this.active_role_id != _o_.active_role_id) return false;
/* 47 */       if (this.blacked_role_id != _o_.blacked_role_id) return false;
/* 48 */       if (this.operator != _o_.operator) return false;
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     _h_ += (int)this.active_role_id;
/* 57 */     _h_ += (int)this.blacked_role_id;
/* 58 */     _h_ += this.operator;
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.active_role_id).append(",");
/* 66 */     _sb_.append(this.blacked_role_id).append(",");
/* 67 */     _sb_.append(this.operator).append(",");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(FriendsCircleOperatorBlackReq _o_) {
/* 73 */     if (_o_ == this) return 0;
/* 74 */     int _c_ = 0;
/* 75 */     _c_ = Long.signum(this.active_role_id - _o_.active_role_id);
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = Long.signum(this.blacked_role_id - _o_.blacked_role_id);
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     _c_ = this.operator - _o_.operator;
/* 80 */     if (0 != _c_) return _c_;
/* 81 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\FriendsCircleOperatorBlackReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */