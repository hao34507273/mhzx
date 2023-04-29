/*    */ package mzm.gsp.bulletin;
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
/*    */ public class SSystemInfo
/*    */   extends __SSystemInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12586498;
/*    */   public String info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12586498;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSystemInfo()
/*    */   {
/* 31 */     this.info = "";
/*    */   }
/*    */   
/*    */   public SSystemInfo(String _info_) {
/* 35 */     this.info = _info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 43 */     _os_.marshal(this.info, "UTF-16LE");
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 48 */     this.info = _os_.unmarshal_String("UTF-16LE");
/* 49 */     if (!_validator_()) {
/* 50 */       throw new VerifyError("validator failed");
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 56 */     if (_o1_ == this) return true;
/* 57 */     if ((_o1_ instanceof SSystemInfo)) {
/* 58 */       SSystemInfo _o_ = (SSystemInfo)_o1_;
/* 59 */       if (!this.info.equals(_o_.info)) return false;
/* 60 */       return true;
/*    */     }
/* 62 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 66 */     int _h_ = 0;
/* 67 */     _h_ += this.info.hashCode();
/* 68 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 72 */     StringBuilder _sb_ = new StringBuilder();
/* 73 */     _sb_.append("(");
/* 74 */     _sb_.append("T").append(this.info.length()).append(",");
/* 75 */     _sb_.append(")");
/* 76 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bulletin\SSystemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */