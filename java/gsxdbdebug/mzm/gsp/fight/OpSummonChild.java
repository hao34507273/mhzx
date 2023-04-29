/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class OpSummonChild
/*    */   implements Marshal, Comparable<OpSummonChild>
/*    */ {
/*    */   public long child_uuid;
/*    */   
/*    */   public OpSummonChild() {}
/*    */   
/*    */   public OpSummonChild(long _child_uuid_)
/*    */   {
/* 17 */     this.child_uuid = _child_uuid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.child_uuid);
/* 26 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 30 */     this.child_uuid = _os_.unmarshal_long();
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 35 */     if (_o1_ == this) return true;
/* 36 */     if ((_o1_ instanceof OpSummonChild)) {
/* 37 */       OpSummonChild _o_ = (OpSummonChild)_o1_;
/* 38 */       if (this.child_uuid != _o_.child_uuid) return false;
/* 39 */       return true;
/*    */     }
/* 41 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 45 */     int _h_ = 0;
/* 46 */     _h_ += (int)this.child_uuid;
/* 47 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 51 */     StringBuilder _sb_ = new StringBuilder();
/* 52 */     _sb_.append("(");
/* 53 */     _sb_.append(this.child_uuid).append(",");
/* 54 */     _sb_.append(")");
/* 55 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(OpSummonChild _o_) {
/* 59 */     if (_o_ == this) return 0;
/* 60 */     int _c_ = 0;
/* 61 */     _c_ = Long.signum(this.child_uuid - _o_.child_uuid);
/* 62 */     if (0 != _c_) return _c_;
/* 63 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\OpSummonChild.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */