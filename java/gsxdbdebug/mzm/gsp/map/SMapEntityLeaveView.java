/*    */ package mzm.gsp.map;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SMapEntityLeaveView
/*    */   extends __SMapEntityLeaveView__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590949;
/*    */   public int entity_type;
/*    */   public long instanceid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590949;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SMapEntityLeaveView()
/*    */   {
/* 34 */     this.entity_type = 0;
/*    */   }
/*    */   
/*    */   public SMapEntityLeaveView(int _entity_type_, long _instanceid_) {
/* 38 */     this.entity_type = _entity_type_;
/* 39 */     this.instanceid = _instanceid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.entity_type);
/* 48 */     _os_.marshal(this.instanceid);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.entity_type = _os_.unmarshal_int();
/* 54 */     this.instanceid = _os_.unmarshal_long();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SMapEntityLeaveView)) {
/* 64 */       SMapEntityLeaveView _o_ = (SMapEntityLeaveView)_o1_;
/* 65 */       if (this.entity_type != _o_.entity_type) return false;
/* 66 */       if (this.instanceid != _o_.instanceid) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.entity_type;
/* 75 */     _h_ += (int)this.instanceid;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.entity_type).append(",");
/* 83 */     _sb_.append(this.instanceid).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SMapEntityLeaveView _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = this.entity_type - _o_.entity_type;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = Long.signum(this.instanceid - _o_.instanceid);
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SMapEntityLeaveView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */