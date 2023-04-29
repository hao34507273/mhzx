/*    */ package mzm.gsp.factionpve;
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
/*    */ public class SFactionPVETimesBrd
/*    */   extends __SFactionPVETimesBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12613637;
/*    */   public int activate_times;
/*    */   public int set_times;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12613637;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SFactionPVETimesBrd() {}
/*    */   
/*    */ 
/*    */   public SFactionPVETimesBrd(int _activate_times_, int _set_times_)
/*    */   {
/* 37 */     this.activate_times = _activate_times_;
/* 38 */     this.set_times = _set_times_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.activate_times);
/* 47 */     _os_.marshal(this.set_times);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.activate_times = _os_.unmarshal_int();
/* 53 */     this.set_times = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SFactionPVETimesBrd)) {
/* 63 */       SFactionPVETimesBrd _o_ = (SFactionPVETimesBrd)_o1_;
/* 64 */       if (this.activate_times != _o_.activate_times) return false;
/* 65 */       if (this.set_times != _o_.set_times) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.activate_times;
/* 74 */     _h_ += this.set_times;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.activate_times).append(",");
/* 82 */     _sb_.append(this.set_times).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SFactionPVETimesBrd _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.activate_times - _o_.activate_times;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.set_times - _o_.set_times;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\SFactionPVETimesBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */