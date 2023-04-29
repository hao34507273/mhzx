/*    */ package apollo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class ReportSpeakerMicStatusRes
/*    */   implements Marshal, Comparable<ReportSpeakerMicStatusRes>
/*    */ {
/*    */   public int retcode;
/*    */   public int reserved1;
/*    */   public int reserved2;
/*    */   
/*    */   public ReportSpeakerMicStatusRes()
/*    */   {
/* 16 */     this.retcode = 9;
/* 17 */     this.reserved1 = 0;
/* 18 */     this.reserved2 = 0;
/*    */   }
/*    */   
/*    */   public ReportSpeakerMicStatusRes(int _retcode_, int _reserved1_, int _reserved2_) {
/* 22 */     this.retcode = _retcode_;
/* 23 */     this.reserved1 = _reserved1_;
/* 24 */     this.reserved2 = _reserved2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.retcode);
/* 33 */     _os_.marshal(this.reserved1);
/* 34 */     _os_.marshal(this.reserved2);
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 39 */     this.retcode = _os_.unmarshal_int();
/* 40 */     this.reserved1 = _os_.unmarshal_int();
/* 41 */     this.reserved2 = _os_.unmarshal_int();
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 46 */     if (_o1_ == this) return true;
/* 47 */     if ((_o1_ instanceof ReportSpeakerMicStatusRes)) {
/* 48 */       ReportSpeakerMicStatusRes _o_ = (ReportSpeakerMicStatusRes)_o1_;
/* 49 */       if (this.retcode != _o_.retcode) return false;
/* 50 */       if (this.reserved1 != _o_.reserved1) return false;
/* 51 */       if (this.reserved2 != _o_.reserved2) return false;
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     _h_ += this.retcode;
/* 60 */     _h_ += this.reserved1;
/* 61 */     _h_ += this.reserved2;
/* 62 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 66 */     StringBuilder _sb_ = new StringBuilder();
/* 67 */     _sb_.append("(");
/* 68 */     _sb_.append(this.retcode).append(",");
/* 69 */     _sb_.append(this.reserved1).append(",");
/* 70 */     _sb_.append(this.reserved2).append(",");
/* 71 */     _sb_.append(")");
/* 72 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ReportSpeakerMicStatusRes _o_) {
/* 76 */     if (_o_ == this) return 0;
/* 77 */     int _c_ = 0;
/* 78 */     _c_ = this.retcode - _o_.retcode;
/* 79 */     if (0 != _c_) return _c_;
/* 80 */     _c_ = this.reserved1 - _o_.reserved1;
/* 81 */     if (0 != _c_) return _c_;
/* 82 */     _c_ = this.reserved2 - _o_.reserved2;
/* 83 */     if (0 != _c_) return _c_;
/* 84 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\ReportSpeakerMicStatusRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */