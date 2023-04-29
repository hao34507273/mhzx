/*     */ package mzm.gsp.market;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SAllCustomizedConditionsRes
/*     */   extends __SAllCustomizedConditionsRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601443;
/*     */   public HashMap<Integer, EquipConditions> subid2equipcons;
/*     */   public HashMap<Integer, PetEquipConditions> subid2petequipcons;
/*     */   public HashMap<Integer, PetConditions> subid2petcons;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12601443;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAllCustomizedConditionsRes()
/*     */   {
/*  33 */     this.subid2equipcons = new HashMap();
/*  34 */     this.subid2petequipcons = new HashMap();
/*  35 */     this.subid2petcons = new HashMap();
/*     */   }
/*     */   
/*     */   public SAllCustomizedConditionsRes(HashMap<Integer, EquipConditions> _subid2equipcons_, HashMap<Integer, PetEquipConditions> _subid2petequipcons_, HashMap<Integer, PetConditions> _subid2petcons_) {
/*  39 */     this.subid2equipcons = _subid2equipcons_;
/*  40 */     this.subid2petequipcons = _subid2petequipcons_;
/*  41 */     this.subid2petcons = _subid2petcons_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (Map.Entry<Integer, EquipConditions> _e_ : this.subid2equipcons.entrySet()) {
/*  46 */       if (!((EquipConditions)_e_.getValue())._validator_()) return false;
/*     */     }
/*  48 */     for (Map.Entry<Integer, PetEquipConditions> _e_ : this.subid2petequipcons.entrySet()) {
/*  49 */       if (!((PetEquipConditions)_e_.getValue())._validator_()) return false;
/*     */     }
/*  51 */     for (Map.Entry<Integer, PetConditions> _e_ : this.subid2petcons.entrySet()) {
/*  52 */       if (!((PetConditions)_e_.getValue())._validator_()) return false;
/*     */     }
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.compact_uint32(this.subid2equipcons.size());
/*  59 */     for (Map.Entry<Integer, EquipConditions> _e_ : this.subid2equipcons.entrySet()) {
/*  60 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  61 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  63 */     _os_.compact_uint32(this.subid2petequipcons.size());
/*  64 */     for (Map.Entry<Integer, PetEquipConditions> _e_ : this.subid2petequipcons.entrySet()) {
/*  65 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  66 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  68 */     _os_.compact_uint32(this.subid2petcons.size());
/*  69 */     for (Map.Entry<Integer, PetConditions> _e_ : this.subid2petcons.entrySet()) {
/*  70 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  71 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  77 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  79 */       int _k_ = _os_.unmarshal_int();
/*  80 */       EquipConditions _v_ = new EquipConditions();
/*  81 */       _v_.unmarshal(_os_);
/*  82 */       this.subid2equipcons.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  84 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  86 */       int _k_ = _os_.unmarshal_int();
/*  87 */       PetEquipConditions _v_ = new PetEquipConditions();
/*  88 */       _v_.unmarshal(_os_);
/*  89 */       this.subid2petequipcons.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  91 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  93 */       int _k_ = _os_.unmarshal_int();
/*  94 */       PetConditions _v_ = new PetConditions();
/*  95 */       _v_.unmarshal(_os_);
/*  96 */       this.subid2petcons.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  98 */     if (!_validator_()) {
/*  99 */       throw new VerifyError("validator failed");
/*     */     }
/* 101 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 105 */     if (_o1_ == this) return true;
/* 106 */     if ((_o1_ instanceof SAllCustomizedConditionsRes)) {
/* 107 */       SAllCustomizedConditionsRes _o_ = (SAllCustomizedConditionsRes)_o1_;
/* 108 */       if (!this.subid2equipcons.equals(_o_.subid2equipcons)) return false;
/* 109 */       if (!this.subid2petequipcons.equals(_o_.subid2petequipcons)) return false;
/* 110 */       if (!this.subid2petcons.equals(_o_.subid2petcons)) return false;
/* 111 */       return true;
/*     */     }
/* 113 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 117 */     int _h_ = 0;
/* 118 */     _h_ += this.subid2equipcons.hashCode();
/* 119 */     _h_ += this.subid2petequipcons.hashCode();
/* 120 */     _h_ += this.subid2petcons.hashCode();
/* 121 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 125 */     StringBuilder _sb_ = new StringBuilder();
/* 126 */     _sb_.append("(");
/* 127 */     _sb_.append(this.subid2equipcons).append(",");
/* 128 */     _sb_.append(this.subid2petequipcons).append(",");
/* 129 */     _sb_.append(this.subid2petcons).append(",");
/* 130 */     _sb_.append(")");
/* 131 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SAllCustomizedConditionsRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */