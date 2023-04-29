/*    */ package mzm.gsp.gang;
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
/*    */ public class SYaoDianInfoRes
/*    */   extends __SYaoDianInfoRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589915;
/*    */   public YaoDianInfo yaodianinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12589915;
/*    */   }
/*    */   
/*    */ 
/*    */   public SYaoDianInfoRes()
/*    */   {
/* 33 */     this.yaodianinfo = new YaoDianInfo();
/*    */   }
/*    */   
/*    */   public SYaoDianInfoRes(YaoDianInfo _yaodianinfo_) {
/* 37 */     this.yaodianinfo = _yaodianinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.yaodianinfo._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.yaodianinfo);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.yaodianinfo.unmarshal(_os_);
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SYaoDianInfoRes)) {
/* 61 */       SYaoDianInfoRes _o_ = (SYaoDianInfoRes)_o1_;
/* 62 */       if (!this.yaodianinfo.equals(_o_.yaodianinfo)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.yaodianinfo.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.yaodianinfo).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SYaoDianInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */