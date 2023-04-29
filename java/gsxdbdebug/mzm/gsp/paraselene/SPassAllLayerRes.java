/*    */ package mzm.gsp.paraselene;
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
/*    */ public class SPassAllLayerRes
/*    */   extends __SPassAllLayerRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12598297;
/*    */   public int isfanpai;
/*    */   public int seconds;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12598297;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SPassAllLayerRes() {}
/*    */   
/*    */ 
/*    */   public SPassAllLayerRes(int _isfanpai_, int _seconds_)
/*    */   {
/* 37 */     this.isfanpai = _isfanpai_;
/* 38 */     this.seconds = _seconds_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.isfanpai);
/* 47 */     _os_.marshal(this.seconds);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.isfanpai = _os_.unmarshal_int();
/* 53 */     this.seconds = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SPassAllLayerRes)) {
/* 63 */       SPassAllLayerRes _o_ = (SPassAllLayerRes)_o1_;
/* 64 */       if (this.isfanpai != _o_.isfanpai) return false;
/* 65 */       if (this.seconds != _o_.seconds) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.isfanpai;
/* 74 */     _h_ += this.seconds;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.isfanpai).append(",");
/* 82 */     _sb_.append(this.seconds).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SPassAllLayerRes _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.isfanpai - _o_.isfanpai;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.seconds - _o_.seconds;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\SPassAllLayerRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */