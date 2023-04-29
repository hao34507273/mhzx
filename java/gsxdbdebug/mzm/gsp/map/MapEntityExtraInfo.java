/*     */ package mzm.gsp.map;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class MapEntityExtraInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public HashMap<Integer, Integer> int_extra_infos;
/*     */   public HashMap<Integer, Long> long_extra_infos;
/*     */   public HashMap<Integer, Octets> string_extra_infos;
/*     */   
/*     */   public MapEntityExtraInfo()
/*     */   {
/*  16 */     this.int_extra_infos = new HashMap();
/*  17 */     this.long_extra_infos = new HashMap();
/*  18 */     this.string_extra_infos = new HashMap();
/*     */   }
/*     */   
/*     */   public MapEntityExtraInfo(HashMap<Integer, Integer> _int_extra_infos_, HashMap<Integer, Long> _long_extra_infos_, HashMap<Integer, Octets> _string_extra_infos_) {
/*  22 */     this.int_extra_infos = _int_extra_infos_;
/*  23 */     this.long_extra_infos = _long_extra_infos_;
/*  24 */     this.string_extra_infos = _string_extra_infos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  28 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  32 */     _os_.compact_uint32(this.int_extra_infos.size());
/*  33 */     for (Map.Entry<Integer, Integer> _e_ : this.int_extra_infos.entrySet()) {
/*  34 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  35 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  37 */     _os_.compact_uint32(this.long_extra_infos.size());
/*  38 */     for (Map.Entry<Integer, Long> _e_ : this.long_extra_infos.entrySet()) {
/*  39 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  40 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*     */     }
/*  42 */     _os_.compact_uint32(this.string_extra_infos.size());
/*  43 */     for (Map.Entry<Integer, Octets> _e_ : this.string_extra_infos.entrySet()) {
/*  44 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  45 */       _os_.marshal((Octets)_e_.getValue());
/*     */     }
/*  47 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  51 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  53 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  55 */       int _v_ = _os_.unmarshal_int();
/*  56 */       this.int_extra_infos.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  58 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  60 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  62 */       long _v_ = _os_.unmarshal_long();
/*  63 */       this.long_extra_infos.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*     */     }
/*  65 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  67 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  69 */       Octets _v_ = _os_.unmarshal_Octets();
/*  70 */       this.string_extra_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof MapEntityExtraInfo)) {
/*  78 */       MapEntityExtraInfo _o_ = (MapEntityExtraInfo)_o1_;
/*  79 */       if (!this.int_extra_infos.equals(_o_.int_extra_infos)) return false;
/*  80 */       if (!this.long_extra_infos.equals(_o_.long_extra_infos)) return false;
/*  81 */       if (!this.string_extra_infos.equals(_o_.string_extra_infos)) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.int_extra_infos.hashCode();
/*  90 */     _h_ += this.long_extra_infos.hashCode();
/*  91 */     _h_ += this.string_extra_infos.hashCode();
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.int_extra_infos).append(",");
/*  99 */     _sb_.append(this.long_extra_infos).append(",");
/* 100 */     _sb_.append(this.string_extra_infos).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\MapEntityExtraInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */