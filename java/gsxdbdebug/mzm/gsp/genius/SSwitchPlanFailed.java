/*    */ package mzm.gsp.genius;
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
/*    */ public class SSwitchPlanFailed
/*    */   extends __SSwitchPlanFailed__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12613892;
/*    */   public static final int ERROR_GOLD_NOT_ENOUGH = -1;
/*    */   public int genius_series_id;
/*    */   public int retcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12613892;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSwitchPlanFailed() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public SSwitchPlanFailed(int _genius_series_id_, int _retcode_)
/*    */   {
/* 39 */     this.genius_series_id = _genius_series_id_;
/* 40 */     this.retcode = _retcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.genius_series_id);
/* 49 */     _os_.marshal(this.retcode);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.genius_series_id = _os_.unmarshal_int();
/* 55 */     this.retcode = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SSwitchPlanFailed)) {
/* 65 */       SSwitchPlanFailed _o_ = (SSwitchPlanFailed)_o1_;
/* 66 */       if (this.genius_series_id != _o_.genius_series_id) return false;
/* 67 */       if (this.retcode != _o_.retcode) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.genius_series_id;
/* 76 */     _h_ += this.retcode;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.genius_series_id).append(",");
/* 84 */     _sb_.append(this.retcode).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSwitchPlanFailed _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.genius_series_id - _o_.genius_series_id;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.retcode - _o_.retcode;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genius\SSwitchPlanFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */