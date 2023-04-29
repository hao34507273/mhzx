/*    */ package mzm.gsp.gang;
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
/*    */ 
/*    */ public class SSyncKickOutMember
/*    */   extends __SSyncKickOutMember__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589825;
/*    */   public long roleid;
/*    */   public long managerid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 28 */     return 12589825;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncKickOutMember() {}
/*    */   
/*    */ 
/*    */   public SSyncKickOutMember(long _roleid_, long _managerid_)
/*    */   {
/* 38 */     this.roleid = _roleid_;
/* 39 */     this.managerid = _managerid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.roleid);
/* 48 */     _os_.marshal(this.managerid);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.roleid = _os_.unmarshal_long();
/* 54 */     this.managerid = _os_.unmarshal_long();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SSyncKickOutMember)) {
/* 64 */       SSyncKickOutMember _o_ = (SSyncKickOutMember)_o1_;
/* 65 */       if (this.roleid != _o_.roleid) return false;
/* 66 */       if (this.managerid != _o_.managerid) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.roleid;
/* 75 */     _h_ += (int)this.managerid;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.roleid).append(",");
/* 83 */     _sb_.append(this.managerid).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSyncKickOutMember _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = Long.signum(this.managerid - _o_.managerid);
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SSyncKickOutMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */