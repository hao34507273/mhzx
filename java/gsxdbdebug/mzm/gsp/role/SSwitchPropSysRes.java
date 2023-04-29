/*    */ package mzm.gsp.role;
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
/*    */ public class SSwitchPropSysRes
/*    */   extends __SSwitchPropSysRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12586011;
/*    */   public static final int PROP_SYS_1 = 0;
/*    */   public static final int PROP_SYS_2 = 1;
/*    */   public static final int PROP_SYS_3 = 2;
/*    */   public int propsys;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12586011;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSwitchPropSysRes() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSwitchPropSysRes(int _propsys_)
/*    */   {
/* 40 */     this.propsys = _propsys_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.propsys);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.propsys = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSwitchPropSysRes)) {
/* 63 */       SSwitchPropSysRes _o_ = (SSwitchPropSysRes)_o1_;
/* 64 */       if (this.propsys != _o_.propsys) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += this.propsys;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.propsys).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSwitchPropSysRes _o_) {
/* 85 */     if (_o_ == this) return 0;
/* 86 */     int _c_ = 0;
/* 87 */     _c_ = this.propsys - _o_.propsys;
/* 88 */     if (0 != _c_) return _c_;
/* 89 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\SSwitchPropSysRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */