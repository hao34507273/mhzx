/*    */ package mzm.gsp.market;
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
/*    */ public class SAddEquipConditionRes
/*    */   extends __SAddEquipConditionRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601418;
/*    */   public int index;
/*    */   public EquipCondition condition;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12601418;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SAddEquipConditionRes()
/*    */   {
/* 32 */     this.condition = new EquipCondition();
/*    */   }
/*    */   
/*    */   public SAddEquipConditionRes(int _index_, EquipCondition _condition_) {
/* 36 */     this.index = _index_;
/* 37 */     this.condition = _condition_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.condition._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.index);
/* 47 */     _os_.marshal(this.condition);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.index = _os_.unmarshal_int();
/* 53 */     this.condition.unmarshal(_os_);
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SAddEquipConditionRes)) {
/* 63 */       SAddEquipConditionRes _o_ = (SAddEquipConditionRes)_o1_;
/* 64 */       if (this.index != _o_.index) return false;
/* 65 */       if (!this.condition.equals(_o_.condition)) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.index;
/* 74 */     _h_ += this.condition.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.index).append(",");
/* 82 */     _sb_.append(this.condition).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SAddEquipConditionRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */