/*    */ package mzm.gsp.petarena;
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
/*    */ public class SRefreshOpponentSuccess
/*    */   extends __SRefreshOpponentSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12628234;
/*    */   public int rank;
/*    */   public int refresh_time;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12628234;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SRefreshOpponentSuccess() {}
/*    */   
/*    */ 
/*    */   public SRefreshOpponentSuccess(int _rank_, int _refresh_time_)
/*    */   {
/* 37 */     this.rank = _rank_;
/* 38 */     this.refresh_time = _refresh_time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.rank);
/* 47 */     _os_.marshal(this.refresh_time);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.rank = _os_.unmarshal_int();
/* 53 */     this.refresh_time = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SRefreshOpponentSuccess)) {
/* 63 */       SRefreshOpponentSuccess _o_ = (SRefreshOpponentSuccess)_o1_;
/* 64 */       if (this.rank != _o_.rank) return false;
/* 65 */       if (this.refresh_time != _o_.refresh_time) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.rank;
/* 74 */     _h_ += this.refresh_time;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.rank).append(",");
/* 82 */     _sb_.append(this.refresh_time).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SRefreshOpponentSuccess _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.rank - _o_.rank;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.refresh_time - _o_.refresh_time;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\SRefreshOpponentSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */