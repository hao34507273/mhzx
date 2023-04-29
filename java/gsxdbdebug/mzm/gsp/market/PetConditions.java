/*    */ package mzm.gsp.market;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class PetConditions implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public ArrayList<PetCondition> petcons;
/*    */   public ArrayList<Integer> conditionstate;
/*    */   
/*    */   public PetConditions()
/*    */   {
/* 13 */     this.petcons = new ArrayList();
/* 14 */     this.conditionstate = new ArrayList();
/*    */   }
/*    */   
/*    */   public PetConditions(ArrayList<PetCondition> _petcons_, ArrayList<Integer> _conditionstate_) {
/* 18 */     this.petcons = _petcons_;
/* 19 */     this.conditionstate = _conditionstate_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     for (PetCondition _v_ : this.petcons)
/* 24 */       if (!_v_._validator_()) return false;
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.compact_uint32(this.petcons.size());
/* 30 */     for (PetCondition _v_ : this.petcons) {
/* 31 */       _os_.marshal(_v_);
/*    */     }
/* 33 */     _os_.compact_uint32(this.conditionstate.size());
/* 34 */     for (Integer _v_ : this.conditionstate) {
/* 35 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 41 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 42 */       PetCondition _v_ = new PetCondition();
/* 43 */       _v_.unmarshal(_os_);
/* 44 */       this.petcons.add(_v_);
/*    */     }
/* 46 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 48 */       int _v_ = _os_.unmarshal_int();
/* 49 */       this.conditionstate.add(Integer.valueOf(_v_));
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 55 */     if (_o1_ == this) return true;
/* 56 */     if ((_o1_ instanceof PetConditions)) {
/* 57 */       PetConditions _o_ = (PetConditions)_o1_;
/* 58 */       if (!this.petcons.equals(_o_.petcons)) return false;
/* 59 */       if (!this.conditionstate.equals(_o_.conditionstate)) return false;
/* 60 */       return true;
/*    */     }
/* 62 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 66 */     int _h_ = 0;
/* 67 */     _h_ += this.petcons.hashCode();
/* 68 */     _h_ += this.conditionstate.hashCode();
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.petcons).append(",");
/* 76 */     _sb_.append(this.conditionstate).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\PetConditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */