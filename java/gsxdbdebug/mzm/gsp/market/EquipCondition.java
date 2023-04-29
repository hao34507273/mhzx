/*    */ package mzm.gsp.market;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashSet;
/*    */ 
/*    */ public class EquipCondition implements Marshal
/*    */ {
/*    */   public int subid;
/*    */   public int level;
/*    */   public HashSet<Integer> colors;
/*    */   public HashSet<Integer> skillids;
/*    */   public long custtime;
/*    */   
/*    */   public EquipCondition()
/*    */   {
/* 18 */     this.colors = new HashSet();
/* 19 */     this.skillids = new HashSet();
/*    */   }
/*    */   
/*    */   public EquipCondition(int _subid_, int _level_, HashSet<Integer> _colors_, HashSet<Integer> _skillids_, long _custtime_) {
/* 23 */     this.subid = _subid_;
/* 24 */     this.level = _level_;
/* 25 */     this.colors = _colors_;
/* 26 */     this.skillids = _skillids_;
/* 27 */     this.custtime = _custtime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.marshal(this.subid);
/* 36 */     _os_.marshal(this.level);
/* 37 */     _os_.compact_uint32(this.colors.size());
/* 38 */     for (Integer _v_ : this.colors) {
/* 39 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 41 */     _os_.compact_uint32(this.skillids.size());
/* 42 */     for (Integer _v_ : this.skillids) {
/* 43 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 45 */     _os_.marshal(this.custtime);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.subid = _os_.unmarshal_int();
/* 51 */     this.level = _os_.unmarshal_int();
/* 52 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 54 */       int _v_ = _os_.unmarshal_int();
/* 55 */       this.colors.add(Integer.valueOf(_v_));
/*    */     }
/* 57 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 59 */       int _v_ = _os_.unmarshal_int();
/* 60 */       this.skillids.add(Integer.valueOf(_v_));
/*    */     }
/* 62 */     this.custtime = _os_.unmarshal_long();
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof EquipCondition)) {
/* 69 */       EquipCondition _o_ = (EquipCondition)_o1_;
/* 70 */       if (this.subid != _o_.subid) return false;
/* 71 */       if (this.level != _o_.level) return false;
/* 72 */       if (!this.colors.equals(_o_.colors)) return false;
/* 73 */       if (!this.skillids.equals(_o_.skillids)) return false;
/* 74 */       if (this.custtime != _o_.custtime) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.subid;
/* 83 */     _h_ += this.level;
/* 84 */     _h_ += this.colors.hashCode();
/* 85 */     _h_ += this.skillids.hashCode();
/* 86 */     _h_ += (int)this.custtime;
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.subid).append(",");
/* 94 */     _sb_.append(this.level).append(",");
/* 95 */     _sb_.append(this.colors).append(",");
/* 96 */     _sb_.append(this.skillids).append(",");
/* 97 */     _sb_.append(this.custtime).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\EquipCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */