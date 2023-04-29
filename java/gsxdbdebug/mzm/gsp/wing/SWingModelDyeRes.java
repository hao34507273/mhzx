/*    */ package mzm.gsp.wing;
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
/*    */ public class SWingModelDyeRes
/*    */   extends __SWingModelDyeRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596509;
/*    */   public ModelId2DyeId modelid2dyeid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12596509;
/*    */   }
/*    */   
/*    */ 
/*    */   public SWingModelDyeRes()
/*    */   {
/* 31 */     this.modelid2dyeid = new ModelId2DyeId();
/*    */   }
/*    */   
/*    */   public SWingModelDyeRes(ModelId2DyeId _modelid2dyeid_) {
/* 35 */     this.modelid2dyeid = _modelid2dyeid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 39 */     if (!this.modelid2dyeid._validator_()) return false;
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.modelid2dyeid);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.modelid2dyeid.unmarshal(_os_);
/* 50 */     if (!_validator_()) {
/* 51 */       throw new VerifyError("validator failed");
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof SWingModelDyeRes)) {
/* 59 */       SWingModelDyeRes _o_ = (SWingModelDyeRes)_o1_;
/* 60 */       if (!this.modelid2dyeid.equals(_o_.modelid2dyeid)) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += this.modelid2dyeid.hashCode();
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.modelid2dyeid).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SWingModelDyeRes _o_) {
/* 81 */     if (_o_ == this) return 0;
/* 82 */     int _c_ = 0;
/* 83 */     _c_ = this.modelid2dyeid.compareTo(_o_.modelid2dyeid);
/* 84 */     if (0 != _c_) return _c_;
/* 85 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\SWingModelDyeRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */