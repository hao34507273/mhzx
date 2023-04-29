/*    */ package mzm.gsp.market;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class EquipConditions implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public ArrayList<EquipCondition> equipcons;
/*    */   public ArrayList<Integer> conditionstate;
/*    */   
/*    */   public EquipConditions()
/*    */   {
/* 13 */     this.equipcons = new ArrayList();
/* 14 */     this.conditionstate = new ArrayList();
/*    */   }
/*    */   
/*    */   public EquipConditions(ArrayList<EquipCondition> _equipcons_, ArrayList<Integer> _conditionstate_) {
/* 18 */     this.equipcons = _equipcons_;
/* 19 */     this.conditionstate = _conditionstate_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     for (EquipCondition _v_ : this.equipcons)
/* 24 */       if (!_v_._validator_()) return false;
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.compact_uint32(this.equipcons.size());
/* 30 */     for (EquipCondition _v_ : this.equipcons) {
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
/* 42 */       EquipCondition _v_ = new EquipCondition();
/* 43 */       _v_.unmarshal(_os_);
/* 44 */       this.equipcons.add(_v_);
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
/* 56 */     if ((_o1_ instanceof EquipConditions)) {
/* 57 */       EquipConditions _o_ = (EquipConditions)_o1_;
/* 58 */       if (!this.equipcons.equals(_o_.equipcons)) return false;
/* 59 */       if (!this.conditionstate.equals(_o_.conditionstate)) return false;
/* 60 */       return true;
/*    */     }
/* 62 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 66 */     int _h_ = 0;
/* 67 */     _h_ += this.equipcons.hashCode();
/* 68 */     _h_ += this.conditionstate.hashCode();
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.equipcons).append(",");
/* 76 */     _sb_.append(this.conditionstate).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\EquipConditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */