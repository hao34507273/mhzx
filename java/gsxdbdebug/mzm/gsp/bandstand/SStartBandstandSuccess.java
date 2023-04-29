/*     */ package mzm.gsp.bandstand;
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
/*     */ public class SStartBandstandSuccess
/*     */   extends __SStartBandstandSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12627979;
/*     */   public int activity_id;
/*     */   public int music_id;
/*     */   public int start_fragment_index;
/*     */   public HashMap<Integer, FragmentInfo> fragment_info_map;
/*     */   public int start_time;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12627979;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SStartBandstandSuccess()
/*     */   {
/*  37 */     this.fragment_info_map = new HashMap();
/*     */   }
/*     */   
/*     */   public SStartBandstandSuccess(int _activity_id_, int _music_id_, int _start_fragment_index_, HashMap<Integer, FragmentInfo> _fragment_info_map_, int _start_time_) {
/*  41 */     this.activity_id = _activity_id_;
/*  42 */     this.music_id = _music_id_;
/*  43 */     this.start_fragment_index = _start_fragment_index_;
/*  44 */     this.fragment_info_map = _fragment_info_map_;
/*  45 */     this.start_time = _start_time_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     for (Map.Entry<Integer, FragmentInfo> _e_ : this.fragment_info_map.entrySet()) {
/*  50 */       if (!((FragmentInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.activity_id);
/*  57 */     _os_.marshal(this.music_id);
/*  58 */     _os_.marshal(this.start_fragment_index);
/*  59 */     _os_.compact_uint32(this.fragment_info_map.size());
/*  60 */     for (Map.Entry<Integer, FragmentInfo> _e_ : this.fragment_info_map.entrySet()) {
/*  61 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  62 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  64 */     _os_.marshal(this.start_time);
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  69 */     this.activity_id = _os_.unmarshal_int();
/*  70 */     this.music_id = _os_.unmarshal_int();
/*  71 */     this.start_fragment_index = _os_.unmarshal_int();
/*  72 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  74 */       int _k_ = _os_.unmarshal_int();
/*  75 */       FragmentInfo _v_ = new FragmentInfo();
/*  76 */       _v_.unmarshal(_os_);
/*  77 */       this.fragment_info_map.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  79 */     this.start_time = _os_.unmarshal_int();
/*  80 */     if (!_validator_()) {
/*  81 */       throw new VerifyError("validator failed");
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  87 */     if (_o1_ == this) return true;
/*  88 */     if ((_o1_ instanceof SStartBandstandSuccess)) {
/*  89 */       SStartBandstandSuccess _o_ = (SStartBandstandSuccess)_o1_;
/*  90 */       if (this.activity_id != _o_.activity_id) return false;
/*  91 */       if (this.music_id != _o_.music_id) return false;
/*  92 */       if (this.start_fragment_index != _o_.start_fragment_index) return false;
/*  93 */       if (!this.fragment_info_map.equals(_o_.fragment_info_map)) return false;
/*  94 */       if (this.start_time != _o_.start_time) return false;
/*  95 */       return true;
/*     */     }
/*  97 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 101 */     int _h_ = 0;
/* 102 */     _h_ += this.activity_id;
/* 103 */     _h_ += this.music_id;
/* 104 */     _h_ += this.start_fragment_index;
/* 105 */     _h_ += this.fragment_info_map.hashCode();
/* 106 */     _h_ += this.start_time;
/* 107 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 111 */     StringBuilder _sb_ = new StringBuilder();
/* 112 */     _sb_.append("(");
/* 113 */     _sb_.append(this.activity_id).append(",");
/* 114 */     _sb_.append(this.music_id).append(",");
/* 115 */     _sb_.append(this.start_fragment_index).append(",");
/* 116 */     _sb_.append(this.fragment_info_map).append(",");
/* 117 */     _sb_.append(this.start_time).append(",");
/* 118 */     _sb_.append(")");
/* 119 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bandstand\SStartBandstandSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */