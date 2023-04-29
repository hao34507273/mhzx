/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Protect implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public ArrayList<Integer> protecterids;
/*    */   public ArrayList<FighterStatus> protecterstatuses;
/*    */   public java.util.HashMap<Integer, InfluenceOther> influencemap;
/*    */   
/*    */   public Protect()
/*    */   {
/* 14 */     this.protecterids = new ArrayList();
/* 15 */     this.protecterstatuses = new ArrayList();
/* 16 */     this.influencemap = new java.util.HashMap();
/*    */   }
/*    */   
/*    */   public Protect(ArrayList<Integer> _protecterids_, ArrayList<FighterStatus> _protecterstatuses_, java.util.HashMap<Integer, InfluenceOther> _influencemap_) {
/* 20 */     this.protecterids = _protecterids_;
/* 21 */     this.protecterstatuses = _protecterstatuses_;
/* 22 */     this.influencemap = _influencemap_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     for (FighterStatus _v_ : this.protecterstatuses)
/* 27 */       if (!_v_._validator_()) return false;
/* 28 */     for (java.util.Map.Entry<Integer, InfluenceOther> _e_ : this.influencemap.entrySet()) {
/* 29 */       if (!((InfluenceOther)_e_.getValue())._validator_()) return false;
/*    */     }
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.compact_uint32(this.protecterids.size());
/* 36 */     for (Integer _v_ : this.protecterids) {
/* 37 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 39 */     _os_.compact_uint32(this.protecterstatuses.size());
/* 40 */     for (FighterStatus _v_ : this.protecterstatuses) {
/* 41 */       _os_.marshal(_v_);
/*    */     }
/* 43 */     _os_.compact_uint32(this.influencemap.size());
/* 44 */     for (java.util.Map.Entry<Integer, InfluenceOther> _e_ : this.influencemap.entrySet()) {
/* 45 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 46 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*    */     }
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 52 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 54 */       int _v_ = _os_.unmarshal_int();
/* 55 */       this.protecterids.add(Integer.valueOf(_v_));
/*    */     }
/* 57 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 58 */       FighterStatus _v_ = new FighterStatus();
/* 59 */       _v_.unmarshal(_os_);
/* 60 */       this.protecterstatuses.add(_v_);
/*    */     }
/* 62 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 64 */       int _k_ = _os_.unmarshal_int();
/* 65 */       InfluenceOther _v_ = new InfluenceOther();
/* 66 */       _v_.unmarshal(_os_);
/* 67 */       this.influencemap.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof Protect)) {
/* 75 */       Protect _o_ = (Protect)_o1_;
/* 76 */       if (!this.protecterids.equals(_o_.protecterids)) return false;
/* 77 */       if (!this.protecterstatuses.equals(_o_.protecterstatuses)) return false;
/* 78 */       if (!this.influencemap.equals(_o_.influencemap)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.protecterids.hashCode();
/* 87 */     _h_ += this.protecterstatuses.hashCode();
/* 88 */     _h_ += this.influencemap.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.protecterids).append(",");
/* 96 */     _sb_.append(this.protecterstatuses).append(",");
/* 97 */     _sb_.append(this.influencemap).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\Protect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */