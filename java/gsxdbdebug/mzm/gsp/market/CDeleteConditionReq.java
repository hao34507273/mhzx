/*    */ package mzm.gsp.market;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.market.search.PDeleteConditionReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CDeleteConditionReq
/*    */   extends __CDeleteConditionReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601405;
/*    */   public int subid;
/*    */   public int index;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PDeleteConditionReq(roleId, this.index, this.subid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12601405;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CDeleteConditionReq() {}
/*    */   
/*    */ 
/*    */   public CDeleteConditionReq(int _subid_, int _index_)
/*    */   {
/* 42 */     this.subid = _subid_;
/* 43 */     this.index = _index_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.subid);
/* 52 */     _os_.marshal(this.index);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.subid = _os_.unmarshal_int();
/* 58 */     this.index = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CDeleteConditionReq)) {
/* 68 */       CDeleteConditionReq _o_ = (CDeleteConditionReq)_o1_;
/* 69 */       if (this.subid != _o_.subid) return false;
/* 70 */       if (this.index != _o_.index) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.subid;
/* 79 */     _h_ += this.index;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.subid).append(",");
/* 87 */     _sb_.append(this.index).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CDeleteConditionReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.subid - _o_.subid;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.index - _o_.index;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\CDeleteConditionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */