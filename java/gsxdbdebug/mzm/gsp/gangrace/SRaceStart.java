/*    */ package mzm.gsp.gangrace;
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
/*    */ public class SRaceStart
/*    */   extends __SRaceStart__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12602125;
/*    */   public int curcount;
/*    */   public int maxcount;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12602125;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SRaceStart() {}
/*    */   
/*    */ 
/*    */   public SRaceStart(int _curcount_, int _maxcount_)
/*    */   {
/* 37 */     this.curcount = _curcount_;
/* 38 */     this.maxcount = _maxcount_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.curcount);
/* 47 */     _os_.marshal(this.maxcount);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.curcount = _os_.unmarshal_int();
/* 53 */     this.maxcount = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SRaceStart)) {
/* 63 */       SRaceStart _o_ = (SRaceStart)_o1_;
/* 64 */       if (this.curcount != _o_.curcount) return false;
/* 65 */       if (this.maxcount != _o_.maxcount) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.curcount;
/* 74 */     _h_ += this.maxcount;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.curcount).append(",");
/* 82 */     _sb_.append(this.maxcount).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SRaceStart _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.curcount - _o_.curcount;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.maxcount - _o_.maxcount;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\SRaceStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */