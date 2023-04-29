/*     */ package mzm.gsp.role;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ public class PropSys implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int potential_point;
/*     */   public HashMap<Integer, Integer> propmap;
/*     */   public HashMap<Integer, Float> basepropmap;
/*     */   public int isautoassign;
/*     */   public HashMap<Integer, Integer> autoassignmap;
/*     */   public int iscanrefreshprop;
/*     */   
/*     */   public PropSys()
/*     */   {
/*  17 */     this.propmap = new HashMap();
/*  18 */     this.basepropmap = new HashMap();
/*  19 */     this.autoassignmap = new HashMap();
/*     */   }
/*     */   
/*     */   public PropSys(int _potential_point_, HashMap<Integer, Integer> _propmap_, HashMap<Integer, Float> _basepropmap_, int _isautoassign_, HashMap<Integer, Integer> _autoassignmap_, int _iscanrefreshprop_) {
/*  23 */     this.potential_point = _potential_point_;
/*  24 */     this.propmap = _propmap_;
/*  25 */     this.basepropmap = _basepropmap_;
/*  26 */     this.isautoassign = _isautoassign_;
/*  27 */     this.autoassignmap = _autoassignmap_;
/*  28 */     this.iscanrefreshprop = _iscanrefreshprop_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  32 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  36 */     _os_.marshal(this.potential_point);
/*  37 */     _os_.compact_uint32(this.propmap.size());
/*  38 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.propmap.entrySet()) {
/*  39 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  40 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  42 */     _os_.compact_uint32(this.basepropmap.size());
/*  43 */     for (java.util.Map.Entry<Integer, Float> _e_ : this.basepropmap.entrySet()) {
/*  44 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  45 */       _os_.marshal(((Float)_e_.getValue()).floatValue());
/*     */     }
/*  47 */     _os_.marshal(this.isautoassign);
/*  48 */     _os_.compact_uint32(this.autoassignmap.size());
/*  49 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.autoassignmap.entrySet()) {
/*  50 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  51 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  53 */     _os_.marshal(this.iscanrefreshprop);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  58 */     this.potential_point = _os_.unmarshal_int();
/*  59 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  61 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  63 */       int _v_ = _os_.unmarshal_int();
/*  64 */       this.propmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  66 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  68 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  70 */       float _v_ = _os_.unmarshal_float();
/*  71 */       this.basepropmap.put(Integer.valueOf(_k_), Float.valueOf(_v_));
/*     */     }
/*  73 */     this.isautoassign = _os_.unmarshal_int();
/*  74 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  76 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  78 */       int _v_ = _os_.unmarshal_int();
/*  79 */       this.autoassignmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  81 */     this.iscanrefreshprop = _os_.unmarshal_int();
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  86 */     if (_o1_ == this) return true;
/*  87 */     if ((_o1_ instanceof PropSys)) {
/*  88 */       PropSys _o_ = (PropSys)_o1_;
/*  89 */       if (this.potential_point != _o_.potential_point) return false;
/*  90 */       if (!this.propmap.equals(_o_.propmap)) return false;
/*  91 */       if (!this.basepropmap.equals(_o_.basepropmap)) return false;
/*  92 */       if (this.isautoassign != _o_.isautoassign) return false;
/*  93 */       if (!this.autoassignmap.equals(_o_.autoassignmap)) return false;
/*  94 */       if (this.iscanrefreshprop != _o_.iscanrefreshprop) return false;
/*  95 */       return true;
/*     */     }
/*  97 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 101 */     int _h_ = 0;
/* 102 */     _h_ += this.potential_point;
/* 103 */     _h_ += this.propmap.hashCode();
/* 104 */     _h_ += this.basepropmap.hashCode();
/* 105 */     _h_ += this.isautoassign;
/* 106 */     _h_ += this.autoassignmap.hashCode();
/* 107 */     _h_ += this.iscanrefreshprop;
/* 108 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 112 */     StringBuilder _sb_ = new StringBuilder();
/* 113 */     _sb_.append("(");
/* 114 */     _sb_.append(this.potential_point).append(",");
/* 115 */     _sb_.append(this.propmap).append(",");
/* 116 */     _sb_.append(this.basepropmap).append(",");
/* 117 */     _sb_.append(this.isautoassign).append(",");
/* 118 */     _sb_.append(this.autoassignmap).append(",");
/* 119 */     _sb_.append(this.iscanrefreshprop).append(",");
/* 120 */     _sb_.append(")");
/* 121 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\PropSys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */