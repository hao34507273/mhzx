/*    */ package mzm.gsp.skill;
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
/*    */ public class SSyncSkillCommonTip
/*    */   extends __SSyncSkillCommonTip__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12591619;
/*    */   public static final int NEED_MORE_SILVER = 0;
/*    */   public static final int BAG_FULL = 1;
/*    */   public static final int NEED_MORE_VIGOR = 2;
/*    */   public int res;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12591619;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSyncSkillCommonTip() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSyncSkillCommonTip(int _res_)
/*    */   {
/* 40 */     this.res = _res_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.res);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.res = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSyncSkillCommonTip)) {
/* 63 */       SSyncSkillCommonTip _o_ = (SSyncSkillCommonTip)_o1_;
/* 64 */       if (this.res != _o_.res) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += this.res;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.res).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSyncSkillCommonTip _o_) {
/* 85 */     if (_o_ == this) return 0;
/* 86 */     int _c_ = 0;
/* 87 */     _c_ = this.res - _o_.res;
/* 88 */     if (0 != _c_) return _c_;
/* 89 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\SSyncSkillCommonTip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */