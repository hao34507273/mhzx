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
/*    */ public class SMapGroupLeaveView
/*    */   extends __SMapGroupLeaveView__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590940;
/*    */   public int group_type;
/*    */   public long groupid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590940;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SMapGroupLeaveView()
/*    */   {
/* 34 */     this.group_type = 2;
/*    */   }
/*    */   
/*    */   public SMapGroupLeaveView(int _group_type_, long _groupid_) {
/* 38 */     this.group_type = _group_type_;
/* 39 */     this.groupid = _groupid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.group_type);
/* 48 */     _os_.marshal(this.groupid);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.group_type = _os_.unmarshal_int();
/* 54 */     this.groupid = _os_.unmarshal_long();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SMapGroupLeaveView)) {
/* 64 */       SMapGroupLeaveView _o_ = (SMapGroupLeaveView)_o1_;
/* 65 */       if (this.group_type != _o_.group_type) return false;
/* 66 */       if (this.groupid != _o_.groupid) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.group_type;
/* 75 */     _h_ += (int)this.groupid;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.group_type).append(",");
/* 83 */     _sb_.append(this.groupid).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SMapGroupLeaveView _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = this.group_type - _o_.group_type;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = Long.signum(this.groupid - _o_.groupid);
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SMapGroupLeaveView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */