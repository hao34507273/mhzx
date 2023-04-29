/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class PointRaceCorpsBaseInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public long corpsid;
/*     */   public int zoneid;
/*     */   public Octets name;
/*     */   public int icon;
/*     */   public int win;
/*     */   public int lose;
/*     */   public int point;
/*     */   public long update_time;
/*     */   public HashMap<Long, HubCorpsCVCInfo> cvc_infos;
/*     */   
/*     */   public PointRaceCorpsBaseInfo()
/*     */   {
/*  22 */     this.name = new Octets();
/*  23 */     this.icon = 0;
/*  24 */     this.win = 0;
/*  25 */     this.lose = 0;
/*  26 */     this.point = 0;
/*  27 */     this.update_time = 0L;
/*  28 */     this.cvc_infos = new HashMap();
/*     */   }
/*     */   
/*     */   public PointRaceCorpsBaseInfo(long _corpsid_, int _zoneid_, Octets _name_, int _icon_, int _win_, int _lose_, int _point_, long _update_time_, HashMap<Long, HubCorpsCVCInfo> _cvc_infos_) {
/*  32 */     this.corpsid = _corpsid_;
/*  33 */     this.zoneid = _zoneid_;
/*  34 */     this.name = _name_;
/*  35 */     this.icon = _icon_;
/*  36 */     this.win = _win_;
/*  37 */     this.lose = _lose_;
/*  38 */     this.point = _point_;
/*  39 */     this.update_time = _update_time_;
/*  40 */     this.cvc_infos = _cvc_infos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     for (Map.Entry<Long, HubCorpsCVCInfo> _e_ : this.cvc_infos.entrySet()) {
/*  45 */       if (!((HubCorpsCVCInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.corpsid);
/*  52 */     _os_.marshal(this.zoneid);
/*  53 */     _os_.marshal(this.name);
/*  54 */     _os_.marshal(this.icon);
/*  55 */     _os_.marshal(this.win);
/*  56 */     _os_.marshal(this.lose);
/*  57 */     _os_.marshal(this.point);
/*  58 */     _os_.marshal(this.update_time);
/*  59 */     _os_.compact_uint32(this.cvc_infos.size());
/*  60 */     for (Map.Entry<Long, HubCorpsCVCInfo> _e_ : this.cvc_infos.entrySet()) {
/*  61 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  62 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  68 */     this.corpsid = _os_.unmarshal_long();
/*  69 */     this.zoneid = _os_.unmarshal_int();
/*  70 */     this.name = _os_.unmarshal_Octets();
/*  71 */     this.icon = _os_.unmarshal_int();
/*  72 */     this.win = _os_.unmarshal_int();
/*  73 */     this.lose = _os_.unmarshal_int();
/*  74 */     this.point = _os_.unmarshal_int();
/*  75 */     this.update_time = _os_.unmarshal_long();
/*  76 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  78 */       long _k_ = _os_.unmarshal_long();
/*  79 */       HubCorpsCVCInfo _v_ = new HubCorpsCVCInfo();
/*  80 */       _v_.unmarshal(_os_);
/*  81 */       this.cvc_infos.put(Long.valueOf(_k_), _v_);
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  87 */     if (_o1_ == this) return true;
/*  88 */     if ((_o1_ instanceof PointRaceCorpsBaseInfo)) {
/*  89 */       PointRaceCorpsBaseInfo _o_ = (PointRaceCorpsBaseInfo)_o1_;
/*  90 */       if (this.corpsid != _o_.corpsid) return false;
/*  91 */       if (this.zoneid != _o_.zoneid) return false;
/*  92 */       if (!this.name.equals(_o_.name)) return false;
/*  93 */       if (this.icon != _o_.icon) return false;
/*  94 */       if (this.win != _o_.win) return false;
/*  95 */       if (this.lose != _o_.lose) return false;
/*  96 */       if (this.point != _o_.point) return false;
/*  97 */       if (this.update_time != _o_.update_time) return false;
/*  98 */       if (!this.cvc_infos.equals(_o_.cvc_infos)) return false;
/*  99 */       return true;
/*     */     }
/* 101 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 105 */     int _h_ = 0;
/* 106 */     _h_ += (int)this.corpsid;
/* 107 */     _h_ += this.zoneid;
/* 108 */     _h_ += this.name.hashCode();
/* 109 */     _h_ += this.icon;
/* 110 */     _h_ += this.win;
/* 111 */     _h_ += this.lose;
/* 112 */     _h_ += this.point;
/* 113 */     _h_ += (int)this.update_time;
/* 114 */     _h_ += this.cvc_infos.hashCode();
/* 115 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 119 */     StringBuilder _sb_ = new StringBuilder();
/* 120 */     _sb_.append("(");
/* 121 */     _sb_.append(this.corpsid).append(",");
/* 122 */     _sb_.append(this.zoneid).append(",");
/* 123 */     _sb_.append("B").append(this.name.size()).append(",");
/* 124 */     _sb_.append(this.icon).append(",");
/* 125 */     _sb_.append(this.win).append(",");
/* 126 */     _sb_.append(this.lose).append(",");
/* 127 */     _sb_.append(this.point).append(",");
/* 128 */     _sb_.append(this.update_time).append(",");
/* 129 */     _sb_.append(this.cvc_infos).append(",");
/* 130 */     _sb_.append(")");
/* 131 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\PointRaceCorpsBaseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */