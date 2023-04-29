/*    */ package mzm.gsp.team;
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
/*    */ public class SMemberAvatarChangedBrd
/*    */   extends __SMemberAvatarChangedBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588347;
/*    */   public long roleid;
/*    */   public int avatarid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12588347;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SMemberAvatarChangedBrd() {}
/*    */   
/*    */ 
/*    */   public SMemberAvatarChangedBrd(long _roleid_, int _avatarid_)
/*    */   {
/* 37 */     this.roleid = _roleid_;
/* 38 */     this.avatarid = _avatarid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.roleid);
/* 47 */     _os_.marshal(this.avatarid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.roleid = _os_.unmarshal_long();
/* 53 */     this.avatarid = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SMemberAvatarChangedBrd)) {
/* 63 */       SMemberAvatarChangedBrd _o_ = (SMemberAvatarChangedBrd)_o1_;
/* 64 */       if (this.roleid != _o_.roleid) return false;
/* 65 */       if (this.avatarid != _o_.avatarid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.roleid;
/* 74 */     _h_ += this.avatarid;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.roleid).append(",");
/* 82 */     _sb_.append(this.avatarid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SMemberAvatarChangedBrd _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.avatarid - _o_.avatarid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\SMemberAvatarChangedBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */