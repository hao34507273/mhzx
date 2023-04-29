/*    */ package mzm.gsp.zhenfa;
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
/*    */ public class SResZhenfaInfo
/*    */   extends __SResZhenfaInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12593156;
/*    */   public ZhenfaBean zhenfabean;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12593156;
/*    */   }
/*    */   
/*    */ 
/*    */   public SResZhenfaInfo()
/*    */   {
/* 33 */     this.zhenfabean = new ZhenfaBean();
/*    */   }
/*    */   
/*    */   public SResZhenfaInfo(ZhenfaBean _zhenfabean_) {
/* 37 */     this.zhenfabean = _zhenfabean_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.zhenfabean._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.zhenfabean);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.zhenfabean.unmarshal(_os_);
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SResZhenfaInfo)) {
/* 61 */       SResZhenfaInfo _o_ = (SResZhenfaInfo)_o1_;
/* 62 */       if (!this.zhenfabean.equals(_o_.zhenfabean)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.zhenfabean.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.zhenfabean).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SResZhenfaInfo _o_) {
/* 83 */     if (_o_ == this) return 0;
/* 84 */     int _c_ = 0;
/* 85 */     _c_ = this.zhenfabean.compareTo(_o_.zhenfabean);
/* 86 */     if (0 != _c_) return _c_;
/* 87 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenfa\SResZhenfaInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */