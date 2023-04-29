/*    */ package mzm.gsp.fabao;
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
/*    */ public class SEquipFabaoErrorRes
/*    */   extends __SEquipFabaoErrorRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596019;
/*    */   public static final int ERROR_FA_BAO_NON_EXSIT = 0;
/*    */   public static final int ERROR_ROLE_LEVEL_NOT_ENOUGH = 1;
/*    */   public static final int ERROR_ITEM_IS_NOT_FA_BAO = 2;
/*    */   public static final int ERROR_IN_CROSS = 3;
/*    */   public int errorcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12596019;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SEquipFabaoErrorRes() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SEquipFabaoErrorRes(int _errorcode_)
/*    */   {
/* 41 */     this.errorcode = _errorcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.errorcode);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.errorcode = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SEquipFabaoErrorRes)) {
/* 64 */       SEquipFabaoErrorRes _o_ = (SEquipFabaoErrorRes)_o1_;
/* 65 */       if (this.errorcode != _o_.errorcode) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.errorcode;
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.errorcode).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SEquipFabaoErrorRes _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.errorcode - _o_.errorcode;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\SEquipFabaoErrorRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */