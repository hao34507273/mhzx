/*    */ package mzm.gsp.fashiondress;
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
/*    */ public class SExtendFashionDressTimeSuccess
/*    */   extends __SExtendFashionDressTimeSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12603142;
/*    */   public int fashiondresscfgid;
/*    */   public long lefttime;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12603142;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SExtendFashionDressTimeSuccess() {}
/*    */   
/*    */ 
/*    */   public SExtendFashionDressTimeSuccess(int _fashiondresscfgid_, long _lefttime_)
/*    */   {
/* 37 */     this.fashiondresscfgid = _fashiondresscfgid_;
/* 38 */     this.lefttime = _lefttime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.fashiondresscfgid);
/* 47 */     _os_.marshal(this.lefttime);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.fashiondresscfgid = _os_.unmarshal_int();
/* 53 */     this.lefttime = _os_.unmarshal_long();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SExtendFashionDressTimeSuccess)) {
/* 63 */       SExtendFashionDressTimeSuccess _o_ = (SExtendFashionDressTimeSuccess)_o1_;
/* 64 */       if (this.fashiondresscfgid != _o_.fashiondresscfgid) return false;
/* 65 */       if (this.lefttime != _o_.lefttime) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.fashiondresscfgid;
/* 74 */     _h_ += (int)this.lefttime;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.fashiondresscfgid).append(",");
/* 82 */     _sb_.append(this.lefttime).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SExtendFashionDressTimeSuccess _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.fashiondresscfgid - _o_.fashiondresscfgid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = Long.signum(this.lefttime - _o_.lefttime);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\SExtendFashionDressTimeSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */