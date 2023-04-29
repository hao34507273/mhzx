/*    */ package mzm.gsp.marriage;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.map.Location;
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
/*    */ public class SMarraigeParadePostion
/*    */   extends __SMarraigeParadePostion__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12599844;
/*    */   public Location location;
/*    */   public int paradecfgid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12599844;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SMarraigeParadePostion()
/*    */   {
/* 34 */     this.location = new Location();
/*    */   }
/*    */   
/*    */   public SMarraigeParadePostion(Location _location_, int _paradecfgid_) {
/* 38 */     this.location = _location_;
/* 39 */     this.paradecfgid = _paradecfgid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.location._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.location);
/* 49 */     _os_.marshal(this.paradecfgid);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.location.unmarshal(_os_);
/* 55 */     this.paradecfgid = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SMarraigeParadePostion)) {
/* 65 */       SMarraigeParadePostion _o_ = (SMarraigeParadePostion)_o1_;
/* 66 */       if (!this.location.equals(_o_.location)) return false;
/* 67 */       if (this.paradecfgid != _o_.paradecfgid) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.location.hashCode();
/* 76 */     _h_ += this.paradecfgid;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.location).append(",");
/* 84 */     _sb_.append(this.paradecfgid).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SMarraigeParadePostion _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.location.compareTo(_o_.location);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.paradecfgid - _o_.paradecfgid;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\SMarraigeParadePostion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */