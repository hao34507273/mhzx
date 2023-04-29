/*    */ package mzm.gsp.gratefuldelivery;
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
/*    */ public class SFetchRewardSuccess
/*    */   extends __SFetchRewardSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615683;
/*    */   public int stage;
/*    */   public int activity_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12615683;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SFetchRewardSuccess() {}
/*    */   
/*    */ 
/*    */   public SFetchRewardSuccess(int _stage_, int _activity_id_)
/*    */   {
/* 37 */     this.stage = _stage_;
/* 38 */     this.activity_id = _activity_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.stage);
/* 47 */     _os_.marshal(this.activity_id);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.stage = _os_.unmarshal_int();
/* 53 */     this.activity_id = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SFetchRewardSuccess)) {
/* 63 */       SFetchRewardSuccess _o_ = (SFetchRewardSuccess)_o1_;
/* 64 */       if (this.stage != _o_.stage) return false;
/* 65 */       if (this.activity_id != _o_.activity_id) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.stage;
/* 74 */     _h_ += this.activity_id;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.stage).append(",");
/* 82 */     _sb_.append(this.activity_id).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SFetchRewardSuccess _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.stage - _o_.stage;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.activity_id - _o_.activity_id;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\SFetchRewardSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */