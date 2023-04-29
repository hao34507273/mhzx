/*    */ package mzm.gsp.children;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SChildrenEquipLevelUpErrorRes
/*    */   extends __SChildrenEquipLevelUpErrorRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609421;
/*    */   public static final int ERROR_ITEM_NOT_ENOUGH = 1;
/*    */   public static final int ERROR_ITEM_NOT_SUIT = 2;
/*    */   public static final int ERROR_POS_DO_NOT_HAS_EQUIP = 3;
/*    */   public static final int ERROR_TO_MAX_LEVEL = 4;
/*    */   public static final int ERROR_STAGE_NOT_ENOUGH = 5;
/*    */   public static final int ERROR_NOT_OVER_CHILDREN_LEVEL = 6;
/*    */   public int ret;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12609421;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SChildrenEquipLevelUpErrorRes() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SChildrenEquipLevelUpErrorRes(int _ret_)
/*    */   {
/* 43 */     this.ret = _ret_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.ret);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.ret = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof SChildrenEquipLevelUpErrorRes)) {
/* 66 */       SChildrenEquipLevelUpErrorRes _o_ = (SChildrenEquipLevelUpErrorRes)_o1_;
/* 67 */       if (this.ret != _o_.ret) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.ret;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.ret).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SChildrenEquipLevelUpErrorRes _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.ret - _o_.ret;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SChildrenEquipLevelUpErrorRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */