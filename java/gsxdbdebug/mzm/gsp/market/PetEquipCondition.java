/*    */ package mzm.gsp.market;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashSet;
/*    */ 
/*    */ public class PetEquipCondition implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int subid;
/*    */   public int property;
/*    */   public HashSet<Integer> skillids;
/*    */   public long custtime;
/*    */   
/*    */   public PetEquipCondition()
/*    */   {
/* 15 */     this.skillids = new HashSet();
/*    */   }
/*    */   
/*    */   public PetEquipCondition(int _subid_, int _property_, HashSet<Integer> _skillids_, long _custtime_) {
/* 19 */     this.subid = _subid_;
/* 20 */     this.property = _property_;
/* 21 */     this.skillids = _skillids_;
/* 22 */     this.custtime = _custtime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.subid);
/* 31 */     _os_.marshal(this.property);
/* 32 */     _os_.compact_uint32(this.skillids.size());
/* 33 */     for (Integer _v_ : this.skillids) {
/* 34 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 36 */     _os_.marshal(this.custtime);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 41 */     this.subid = _os_.unmarshal_int();
/* 42 */     this.property = _os_.unmarshal_int();
/* 43 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 45 */       int _v_ = _os_.unmarshal_int();
/* 46 */       this.skillids.add(Integer.valueOf(_v_));
/*    */     }
/* 48 */     this.custtime = _os_.unmarshal_long();
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 53 */     if (_o1_ == this) return true;
/* 54 */     if ((_o1_ instanceof PetEquipCondition)) {
/* 55 */       PetEquipCondition _o_ = (PetEquipCondition)_o1_;
/* 56 */       if (this.subid != _o_.subid) return false;
/* 57 */       if (this.property != _o_.property) return false;
/* 58 */       if (!this.skillids.equals(_o_.skillids)) return false;
/* 59 */       if (this.custtime != _o_.custtime) return false;
/* 60 */       return true;
/*    */     }
/* 62 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 66 */     int _h_ = 0;
/* 67 */     _h_ += this.subid;
/* 68 */     _h_ += this.property;
/* 69 */     _h_ += this.skillids.hashCode();
/* 70 */     _h_ += (int)this.custtime;
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.subid).append(",");
/* 78 */     _sb_.append(this.property).append(",");
/* 79 */     _sb_.append(this.skillids).append(",");
/* 80 */     _sb_.append(this.custtime).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\PetEquipCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */