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
/*    */ public class SSyncUnForbiddenTalk
/*    */   extends __SSyncUnForbiddenTalk__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589845;
/*    */   public long managerid;
/*    */   public long roleid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12589845;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncUnForbiddenTalk() {}
/*    */   
/*    */ 
/*    */   public SSyncUnForbiddenTalk(long _managerid_, long _roleid_)
/*    */   {
/* 37 */     this.managerid = _managerid_;
/* 38 */     this.roleid = _roleid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.managerid);
/* 47 */     _os_.marshal(this.roleid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.managerid = _os_.unmarshal_long();
/* 53 */     this.roleid = _os_.unmarshal_long();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSyncUnForbiddenTalk)) {
/* 63 */       SSyncUnForbiddenTalk _o_ = (SSyncUnForbiddenTalk)_o1_;
/* 64 */       if (this.managerid != _o_.managerid) return false;
/* 65 */       if (this.roleid != _o_.roleid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.managerid;
/* 74 */     _h_ += (int)this.roleid;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.managerid).append(",");
/* 82 */     _sb_.append(this.roleid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSyncUnForbiddenTalk _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.managerid - _o_.managerid);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SSyncUnForbiddenTalk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */