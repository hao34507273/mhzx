/*     */ package mzm.gsp.mounts;
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
/*     */ 
/*     */ 
/*     */ public class SSyncMountsInfo
/*     */   extends __SSyncMountsInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12606218;
/*     */   public HashMap<Long, MountsInfo> mounts_info_map;
/*     */   public HashMap<Integer, BattleMountsInfo> battle_mounts_info_map;
/*     */   public long current_ride_mounts;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12606218;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncMountsInfo()
/*     */   {
/*  35 */     this.mounts_info_map = new HashMap();
/*  36 */     this.battle_mounts_info_map = new HashMap();
/*     */   }
/*     */   
/*     */   public SSyncMountsInfo(HashMap<Long, MountsInfo> _mounts_info_map_, HashMap<Integer, BattleMountsInfo> _battle_mounts_info_map_, long _current_ride_mounts_) {
/*  40 */     this.mounts_info_map = _mounts_info_map_;
/*  41 */     this.battle_mounts_info_map = _battle_mounts_info_map_;
/*  42 */     this.current_ride_mounts = _current_ride_mounts_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     for (Map.Entry<Long, MountsInfo> _e_ : this.mounts_info_map.entrySet()) {
/*  47 */       if (!((MountsInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  49 */     for (Map.Entry<Integer, BattleMountsInfo> _e_ : this.battle_mounts_info_map.entrySet()) {
/*  50 */       if (!((BattleMountsInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.compact_uint32(this.mounts_info_map.size());
/*  57 */     for (Map.Entry<Long, MountsInfo> _e_ : this.mounts_info_map.entrySet()) {
/*  58 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  59 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  61 */     _os_.compact_uint32(this.battle_mounts_info_map.size());
/*  62 */     for (Map.Entry<Integer, BattleMountsInfo> _e_ : this.battle_mounts_info_map.entrySet()) {
/*  63 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  64 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  66 */     _os_.marshal(this.current_ride_mounts);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  71 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  73 */       long _k_ = _os_.unmarshal_long();
/*  74 */       MountsInfo _v_ = new MountsInfo();
/*  75 */       _v_.unmarshal(_os_);
/*  76 */       this.mounts_info_map.put(Long.valueOf(_k_), _v_);
/*     */     }
/*  78 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  80 */       int _k_ = _os_.unmarshal_int();
/*  81 */       BattleMountsInfo _v_ = new BattleMountsInfo();
/*  82 */       _v_.unmarshal(_os_);
/*  83 */       this.battle_mounts_info_map.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  85 */     this.current_ride_mounts = _os_.unmarshal_long();
/*  86 */     if (!_validator_()) {
/*  87 */       throw new VerifyError("validator failed");
/*     */     }
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  93 */     if (_o1_ == this) return true;
/*  94 */     if ((_o1_ instanceof SSyncMountsInfo)) {
/*  95 */       SSyncMountsInfo _o_ = (SSyncMountsInfo)_o1_;
/*  96 */       if (!this.mounts_info_map.equals(_o_.mounts_info_map)) return false;
/*  97 */       if (!this.battle_mounts_info_map.equals(_o_.battle_mounts_info_map)) return false;
/*  98 */       if (this.current_ride_mounts != _o_.current_ride_mounts) return false;
/*  99 */       return true;
/*     */     }
/* 101 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 105 */     int _h_ = 0;
/* 106 */     _h_ += this.mounts_info_map.hashCode();
/* 107 */     _h_ += this.battle_mounts_info_map.hashCode();
/* 108 */     _h_ += (int)this.current_ride_mounts;
/* 109 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 113 */     StringBuilder _sb_ = new StringBuilder();
/* 114 */     _sb_.append("(");
/* 115 */     _sb_.append(this.mounts_info_map).append(",");
/* 116 */     _sb_.append(this.battle_mounts_info_map).append(",");
/* 117 */     _sb_.append(this.current_ride_mounts).append(",");
/* 118 */     _sb_.append(")");
/* 119 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\SSyncMountsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */