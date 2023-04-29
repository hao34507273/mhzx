/*     */ package mzm.gsp.partner;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class RolePartnerInfo implements Marshal
/*     */ {
/*     */   public static final int LINEUP_A = 0;
/*     */   public static final int LINEUP_B = 1;
/*     */   public static final int LINEUP_C = 2;
/*     */   public ArrayList<Integer> ownpartners;
/*     */   public HashMap<Integer, LineUp> lineups;
/*     */   public int defaultlineupnum;
/*     */   public HashMap<Integer, Property> partner2property;
/*     */   
/*     */   public RolePartnerInfo()
/*     */   {
/*  21 */     this.ownpartners = new ArrayList();
/*  22 */     this.lineups = new HashMap();
/*  23 */     this.partner2property = new HashMap();
/*     */   }
/*     */   
/*     */   public RolePartnerInfo(ArrayList<Integer> _ownpartners_, HashMap<Integer, LineUp> _lineups_, int _defaultlineupnum_, HashMap<Integer, Property> _partner2property_) {
/*  27 */     this.ownpartners = _ownpartners_;
/*  28 */     this.lineups = _lineups_;
/*  29 */     this.defaultlineupnum = _defaultlineupnum_;
/*  30 */     this.partner2property = _partner2property_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  34 */     for (Map.Entry<Integer, LineUp> _e_ : this.lineups.entrySet()) {
/*  35 */       if (!((LineUp)_e_.getValue())._validator_()) return false;
/*     */     }
/*  37 */     for (Map.Entry<Integer, Property> _e_ : this.partner2property.entrySet()) {
/*  38 */       if (!((Property)_e_.getValue())._validator_()) return false;
/*     */     }
/*  40 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  44 */     _os_.compact_uint32(this.ownpartners.size());
/*  45 */     for (Integer _v_ : this.ownpartners) {
/*  46 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  48 */     _os_.compact_uint32(this.lineups.size());
/*  49 */     for (Map.Entry<Integer, LineUp> _e_ : this.lineups.entrySet()) {
/*  50 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  51 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  53 */     _os_.marshal(this.defaultlineupnum);
/*  54 */     _os_.compact_uint32(this.partner2property.size());
/*  55 */     for (Map.Entry<Integer, Property> _e_ : this.partner2property.entrySet()) {
/*  56 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  57 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  65 */       int _v_ = _os_.unmarshal_int();
/*  66 */       this.ownpartners.add(Integer.valueOf(_v_));
/*     */     }
/*  68 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  70 */       int _k_ = _os_.unmarshal_int();
/*  71 */       LineUp _v_ = new LineUp();
/*  72 */       _v_.unmarshal(_os_);
/*  73 */       this.lineups.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  75 */     this.defaultlineupnum = _os_.unmarshal_int();
/*  76 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  78 */       int _k_ = _os_.unmarshal_int();
/*  79 */       Property _v_ = new Property();
/*  80 */       _v_.unmarshal(_os_);
/*  81 */       this.partner2property.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  87 */     if (_o1_ == this) return true;
/*  88 */     if ((_o1_ instanceof RolePartnerInfo)) {
/*  89 */       RolePartnerInfo _o_ = (RolePartnerInfo)_o1_;
/*  90 */       if (!this.ownpartners.equals(_o_.ownpartners)) return false;
/*  91 */       if (!this.lineups.equals(_o_.lineups)) return false;
/*  92 */       if (this.defaultlineupnum != _o_.defaultlineupnum) return false;
/*  93 */       if (!this.partner2property.equals(_o_.partner2property)) return false;
/*  94 */       return true;
/*     */     }
/*  96 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 100 */     int _h_ = 0;
/* 101 */     _h_ += this.ownpartners.hashCode();
/* 102 */     _h_ += this.lineups.hashCode();
/* 103 */     _h_ += this.defaultlineupnum;
/* 104 */     _h_ += this.partner2property.hashCode();
/* 105 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 109 */     StringBuilder _sb_ = new StringBuilder();
/* 110 */     _sb_.append("(");
/* 111 */     _sb_.append(this.ownpartners).append(",");
/* 112 */     _sb_.append(this.lineups).append(",");
/* 113 */     _sb_.append(this.defaultlineupnum).append(",");
/* 114 */     _sb_.append(this.partner2property).append(",");
/* 115 */     _sb_.append(")");
/* 116 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\RolePartnerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */