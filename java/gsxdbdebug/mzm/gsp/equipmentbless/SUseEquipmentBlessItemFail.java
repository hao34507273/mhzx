/*    */ package mzm.gsp.equipmentbless;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SUseEquipmentBlessItemFail
/*    */   extends __SUseEquipmentBlessItemFail__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12626435;
/*    */   public static final int UNKNOWN = -1;
/*    */   public static final int REACH_MAX_LEVEL = 1;
/*    */   public static final int REACH_MAX_LEVEL_OF_CURRENT_STAGE = 2;
/*    */   public static final int INVALID_EQUIPMENT = 3;
/*    */   public static final int NOT_OWN_BLESS_ITEM = 4;
/*    */   public static final int BLESS_ITEM_NOT_MATCH_EQUIPMENT = 5;
/*    */   public int reason;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12626435;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SUseEquipmentBlessItemFail() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SUseEquipmentBlessItemFail(int _reason_)
/*    */   {
/* 43 */     this.reason = _reason_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.reason);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.reason = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof SUseEquipmentBlessItemFail)) {
/* 66 */       SUseEquipmentBlessItemFail _o_ = (SUseEquipmentBlessItemFail)_o1_;
/* 67 */       if (this.reason != _o_.reason) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.reason;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.reason).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SUseEquipmentBlessItemFail _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.reason - _o_.reason;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\equipmentbless\SUseEquipmentBlessItemFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */