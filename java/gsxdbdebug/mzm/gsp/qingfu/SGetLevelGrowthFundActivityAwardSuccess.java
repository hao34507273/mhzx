/*    */ package mzm.gsp.qingfu;
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
/*    */ public class SGetLevelGrowthFundActivityAwardSuccess
/*    */   extends __SGetLevelGrowthFundActivityAwardSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588816;
/*    */   public int activity_id;
/*    */   public int sortid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12588816;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SGetLevelGrowthFundActivityAwardSuccess() {}
/*    */   
/*    */ 
/*    */   public SGetLevelGrowthFundActivityAwardSuccess(int _activity_id_, int _sortid_)
/*    */   {
/* 37 */     this.activity_id = _activity_id_;
/* 38 */     this.sortid = _sortid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.activity_id);
/* 47 */     _os_.marshal(this.sortid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.activity_id = _os_.unmarshal_int();
/* 53 */     this.sortid = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SGetLevelGrowthFundActivityAwardSuccess)) {
/* 63 */       SGetLevelGrowthFundActivityAwardSuccess _o_ = (SGetLevelGrowthFundActivityAwardSuccess)_o1_;
/* 64 */       if (this.activity_id != _o_.activity_id) return false;
/* 65 */       if (this.sortid != _o_.sortid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.activity_id;
/* 74 */     _h_ += this.sortid;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.activity_id).append(",");
/* 82 */     _sb_.append(this.sortid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGetLevelGrowthFundActivityAwardSuccess _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.activity_id - _o_.activity_id;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.sortid - _o_.sortid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\SGetLevelGrowthFundActivityAwardSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */