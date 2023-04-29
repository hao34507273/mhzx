/*     */ package mzm.gsp.fight;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ public class HitAgain implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public java.util.ArrayList<Integer> targets;
/*     */   public HashMap<Integer, AttackResult> status_map;
/*     */   public HashMap<Integer, InfluenceOther> influencemap;
/*     */   
/*     */   public HitAgain()
/*     */   {
/*  14 */     this.targets = new java.util.ArrayList();
/*  15 */     this.status_map = new HashMap();
/*  16 */     this.influencemap = new HashMap();
/*     */   }
/*     */   
/*     */   public HitAgain(java.util.ArrayList<Integer> _targets_, HashMap<Integer, AttackResult> _status_map_, HashMap<Integer, InfluenceOther> _influencemap_) {
/*  20 */     this.targets = _targets_;
/*  21 */     this.status_map = _status_map_;
/*  22 */     this.influencemap = _influencemap_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  26 */     for (java.util.Map.Entry<Integer, AttackResult> _e_ : this.status_map.entrySet()) {
/*  27 */       if (!((AttackResult)_e_.getValue())._validator_()) return false;
/*     */     }
/*  29 */     for (java.util.Map.Entry<Integer, InfluenceOther> _e_ : this.influencemap.entrySet()) {
/*  30 */       if (!((InfluenceOther)_e_.getValue())._validator_()) return false;
/*     */     }
/*  32 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  36 */     _os_.compact_uint32(this.targets.size());
/*  37 */     for (Integer _v_ : this.targets) {
/*  38 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  40 */     _os_.compact_uint32(this.status_map.size());
/*  41 */     for (java.util.Map.Entry<Integer, AttackResult> _e_ : this.status_map.entrySet()) {
/*  42 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  43 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  45 */     _os_.compact_uint32(this.influencemap.size());
/*  46 */     for (java.util.Map.Entry<Integer, InfluenceOther> _e_ : this.influencemap.entrySet()) {
/*  47 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  48 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  50 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  54 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  56 */       int _v_ = _os_.unmarshal_int();
/*  57 */       this.targets.add(Integer.valueOf(_v_));
/*     */     }
/*  59 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  61 */       int _k_ = _os_.unmarshal_int();
/*  62 */       AttackResult _v_ = new AttackResult();
/*  63 */       _v_.unmarshal(_os_);
/*  64 */       this.status_map.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  66 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  68 */       int _k_ = _os_.unmarshal_int();
/*  69 */       InfluenceOther _v_ = new InfluenceOther();
/*  70 */       _v_.unmarshal(_os_);
/*  71 */       this.influencemap.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof HitAgain)) {
/*  79 */       HitAgain _o_ = (HitAgain)_o1_;
/*  80 */       if (!this.targets.equals(_o_.targets)) return false;
/*  81 */       if (!this.status_map.equals(_o_.status_map)) return false;
/*  82 */       if (!this.influencemap.equals(_o_.influencemap)) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += this.targets.hashCode();
/*  91 */     _h_ += this.status_map.hashCode();
/*  92 */     _h_ += this.influencemap.hashCode();
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.targets).append(",");
/* 100 */     _sb_.append(this.status_map).append(",");
/* 101 */     _sb_.append(this.influencemap).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\HitAgain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */