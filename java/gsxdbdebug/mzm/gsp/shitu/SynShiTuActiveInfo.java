/*    */ package mzm.gsp.shitu;
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
/*    */ 
/*    */ public class SynShiTuActiveInfo
/*    */   extends __SynShiTuActiveInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601652;
/*    */   public ShiTuActiveInfo shitu_active_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12601652;
/*    */   }
/*    */   
/*    */ 
/*    */   public SynShiTuActiveInfo()
/*    */   {
/* 33 */     this.shitu_active_info = new ShiTuActiveInfo();
/*    */   }
/*    */   
/*    */   public SynShiTuActiveInfo(ShiTuActiveInfo _shitu_active_info_) {
/* 37 */     this.shitu_active_info = _shitu_active_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.shitu_active_info._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.shitu_active_info);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.shitu_active_info.unmarshal(_os_);
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SynShiTuActiveInfo)) {
/* 61 */       SynShiTuActiveInfo _o_ = (SynShiTuActiveInfo)_o1_;
/* 62 */       if (!this.shitu_active_info.equals(_o_.shitu_active_info)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.shitu_active_info.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.shitu_active_info).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\SynShiTuActiveInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */