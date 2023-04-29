/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class OpSummonPet
/*    */   implements Marshal, Comparable<OpSummonPet>
/*    */ {
/*    */   public long pet_uuid;
/*    */   
/*    */   public OpSummonPet() {}
/*    */   
/*    */   public OpSummonPet(long _pet_uuid_)
/*    */   {
/* 17 */     this.pet_uuid = _pet_uuid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.pet_uuid);
/* 26 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 30 */     this.pet_uuid = _os_.unmarshal_long();
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 35 */     if (_o1_ == this) return true;
/* 36 */     if ((_o1_ instanceof OpSummonPet)) {
/* 37 */       OpSummonPet _o_ = (OpSummonPet)_o1_;
/* 38 */       if (this.pet_uuid != _o_.pet_uuid) return false;
/* 39 */       return true;
/*    */     }
/* 41 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 45 */     int _h_ = 0;
/* 46 */     _h_ += (int)this.pet_uuid;
/* 47 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 51 */     StringBuilder _sb_ = new StringBuilder();
/* 52 */     _sb_.append("(");
/* 53 */     _sb_.append(this.pet_uuid).append(",");
/* 54 */     _sb_.append(")");
/* 55 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(OpSummonPet _o_) {
/* 59 */     if (_o_ == this) return 0;
/* 60 */     int _c_ = 0;
/* 61 */     _c_ = Long.signum(this.pet_uuid - _o_.pet_uuid);
/* 62 */     if (0 != _c_) return _c_;
/* 63 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\OpSummonPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */