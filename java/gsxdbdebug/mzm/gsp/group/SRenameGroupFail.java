/*    */ package mzm.gsp.group;
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
/*    */ public class SRenameGroupFail
/*    */   extends __SRenameGroupFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605203;
/*    */   public static final int GROUP_NOT_EXIST = 1;
/*    */   public static final int ROLE_NOT_MASTER = 2;
/*    */   public static final int GROUP_NAME_ILLEGAL = 3;
/*    */   public static final int SAME_GROUP_NAME = 4;
/*    */   public int res;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12605203;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SRenameGroupFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SRenameGroupFail(int _res_)
/*    */   {
/* 41 */     this.res = _res_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.res);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.res = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SRenameGroupFail)) {
/* 64 */       SRenameGroupFail _o_ = (SRenameGroupFail)_o1_;
/* 65 */       if (this.res != _o_.res) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.res;
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.res).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SRenameGroupFail _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.res - _o_.res;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\SRenameGroupFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */