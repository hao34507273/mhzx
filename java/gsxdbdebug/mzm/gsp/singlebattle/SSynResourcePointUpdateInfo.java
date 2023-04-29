/*     */ package mzm.gsp.singlebattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynResourcePointUpdateInfo
/*     */   extends __SSynResourcePointUpdateInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12621588;
/*     */   public static final int REASON_JOIN = 0;
/*     */   public static final int REASON_FIGHT = 1;
/*     */   public static final int EXTRA_INFO_TYPE_WINNER_ID = 0;
/*     */   public static final int EXTRA_INFO_TYPE_LOSER_ID = 1;
/*     */   public byte reason;
/*     */   public HashMap<Long, Integer> resource_point_update_infos;
/*     */   public HashMap<Integer, Long> long_extra_infos;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12621588;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynResourcePointUpdateInfo()
/*     */   {
/*  40 */     this.resource_point_update_infos = new HashMap();
/*  41 */     this.long_extra_infos = new HashMap();
/*     */   }
/*     */   
/*     */   public SSynResourcePointUpdateInfo(byte _reason_, HashMap<Long, Integer> _resource_point_update_infos_, HashMap<Integer, Long> _long_extra_infos_) {
/*  45 */     this.reason = _reason_;
/*  46 */     this.resource_point_update_infos = _resource_point_update_infos_;
/*  47 */     this.long_extra_infos = _long_extra_infos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.reason);
/*  56 */     _os_.compact_uint32(this.resource_point_update_infos.size());
/*  57 */     for (Map.Entry<Long, Integer> _e_ : this.resource_point_update_infos.entrySet()) {
/*  58 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  59 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  61 */     _os_.compact_uint32(this.long_extra_infos.size());
/*  62 */     for (Map.Entry<Integer, Long> _e_ : this.long_extra_infos.entrySet()) {
/*  63 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  64 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  70 */     this.reason = _os_.unmarshal_byte();
/*  71 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  73 */       long _k_ = _os_.unmarshal_long();
/*     */       
/*  75 */       int _v_ = _os_.unmarshal_int();
/*  76 */       this.resource_point_update_infos.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  78 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  80 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  82 */       long _v_ = _os_.unmarshal_long();
/*  83 */       this.long_extra_infos.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*     */     }
/*  85 */     if (!_validator_()) {
/*  86 */       throw new VerifyError("validator failed");
/*     */     }
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  92 */     if (_o1_ == this) return true;
/*  93 */     if ((_o1_ instanceof SSynResourcePointUpdateInfo)) {
/*  94 */       SSynResourcePointUpdateInfo _o_ = (SSynResourcePointUpdateInfo)_o1_;
/*  95 */       if (this.reason != _o_.reason) return false;
/*  96 */       if (!this.resource_point_update_infos.equals(_o_.resource_point_update_infos)) return false;
/*  97 */       if (!this.long_extra_infos.equals(_o_.long_extra_infos)) return false;
/*  98 */       return true;
/*     */     }
/* 100 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 104 */     int _h_ = 0;
/* 105 */     _h_ += this.reason;
/* 106 */     _h_ += this.resource_point_update_infos.hashCode();
/* 107 */     _h_ += this.long_extra_infos.hashCode();
/* 108 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 112 */     StringBuilder _sb_ = new StringBuilder();
/* 113 */     _sb_.append("(");
/* 114 */     _sb_.append(this.reason).append(",");
/* 115 */     _sb_.append(this.resource_point_update_infos).append(",");
/* 116 */     _sb_.append(this.long_extra_infos).append(",");
/* 117 */     _sb_.append(")");
/* 118 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\SSynResourcePointUpdateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */