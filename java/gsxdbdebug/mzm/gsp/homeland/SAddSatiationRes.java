/*    */ package mzm.gsp.homeland;
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
/*    */ public class SAddSatiationRes
/*    */   extends __SAddSatiationRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605446;
/*    */   public int addsatiationnum;
/*    */   public int dayrestoresatiationcount;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12605446;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SAddSatiationRes() {}
/*    */   
/*    */ 
/*    */   public SAddSatiationRes(int _addsatiationnum_, int _dayrestoresatiationcount_)
/*    */   {
/* 35 */     this.addsatiationnum = _addsatiationnum_;
/* 36 */     this.dayrestoresatiationcount = _dayrestoresatiationcount_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.addsatiationnum);
/* 45 */     _os_.marshal(this.dayrestoresatiationcount);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.addsatiationnum = _os_.unmarshal_int();
/* 51 */     this.dayrestoresatiationcount = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SAddSatiationRes)) {
/* 61 */       SAddSatiationRes _o_ = (SAddSatiationRes)_o1_;
/* 62 */       if (this.addsatiationnum != _o_.addsatiationnum) return false;
/* 63 */       if (this.dayrestoresatiationcount != _o_.dayrestoresatiationcount) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.addsatiationnum;
/* 72 */     _h_ += this.dayrestoresatiationcount;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.addsatiationnum).append(",");
/* 80 */     _sb_.append(this.dayrestoresatiationcount).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SAddSatiationRes _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.addsatiationnum - _o_.addsatiationnum;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.dayrestoresatiationcount - _o_.dayrestoresatiationcount;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\SAddSatiationRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */