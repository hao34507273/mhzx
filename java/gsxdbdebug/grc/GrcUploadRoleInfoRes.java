/*    */ package grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class GrcUploadRoleInfoRes
/*    */   implements Marshal, Comparable<GrcUploadRoleInfoRes>
/*    */ {
/*    */   public int retcode;
/*    */   public int reserved1;
/*    */   public int reserved2;
/*    */   
/*    */   public GrcUploadRoleInfoRes()
/*    */   {
/* 16 */     this.reserved1 = 0;
/* 17 */     this.reserved2 = 0;
/*    */   }
/*    */   
/*    */   public GrcUploadRoleInfoRes(int _retcode_, int _reserved1_, int _reserved2_) {
/* 21 */     this.retcode = _retcode_;
/* 22 */     this.reserved1 = _reserved1_;
/* 23 */     this.reserved2 = _reserved2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.retcode);
/* 32 */     _os_.marshal(this.reserved1);
/* 33 */     _os_.marshal(this.reserved2);
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 38 */     this.retcode = _os_.unmarshal_int();
/* 39 */     this.reserved1 = _os_.unmarshal_int();
/* 40 */     this.reserved2 = _os_.unmarshal_int();
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 45 */     if (_o1_ == this) return true;
/* 46 */     if ((_o1_ instanceof GrcUploadRoleInfoRes)) {
/* 47 */       GrcUploadRoleInfoRes _o_ = (GrcUploadRoleInfoRes)_o1_;
/* 48 */       if (this.retcode != _o_.retcode) return false;
/* 49 */       if (this.reserved1 != _o_.reserved1) return false;
/* 50 */       if (this.reserved2 != _o_.reserved2) return false;
/* 51 */       return true;
/*    */     }
/* 53 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 57 */     int _h_ = 0;
/* 58 */     _h_ += this.retcode;
/* 59 */     _h_ += this.reserved1;
/* 60 */     _h_ += this.reserved2;
/* 61 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 65 */     StringBuilder _sb_ = new StringBuilder();
/* 66 */     _sb_.append("(");
/* 67 */     _sb_.append(this.retcode).append(",");
/* 68 */     _sb_.append(this.reserved1).append(",");
/* 69 */     _sb_.append(this.reserved2).append(",");
/* 70 */     _sb_.append(")");
/* 71 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(GrcUploadRoleInfoRes _o_) {
/* 75 */     if (_o_ == this) return 0;
/* 76 */     int _c_ = 0;
/* 77 */     _c_ = this.retcode - _o_.retcode;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     _c_ = this.reserved1 - _o_.reserved1;
/* 80 */     if (0 != _c_) return _c_;
/* 81 */     _c_ = this.reserved2 - _o_.reserved2;
/* 82 */     if (0 != _c_) return _c_;
/* 83 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcUploadRoleInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */