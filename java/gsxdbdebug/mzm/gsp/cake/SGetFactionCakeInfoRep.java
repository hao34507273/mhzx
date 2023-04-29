/*     */ package mzm.gsp.cake;
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
/*     */ public class SGetFactionCakeInfoRep
/*     */   extends __SGetFactionCakeInfoRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12627720;
/*     */   public int activityid;
/*     */   public long factionid;
/*     */   public HashMap<Long, RoleCakeBaseInfo> factioncakeinfo;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12627720;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetFactionCakeInfoRep()
/*     */   {
/*  35 */     this.factioncakeinfo = new HashMap();
/*     */   }
/*     */   
/*     */   public SGetFactionCakeInfoRep(int _activityid_, long _factionid_, HashMap<Long, RoleCakeBaseInfo> _factioncakeinfo_) {
/*  39 */     this.activityid = _activityid_;
/*  40 */     this.factionid = _factionid_;
/*  41 */     this.factioncakeinfo = _factioncakeinfo_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (Map.Entry<Long, RoleCakeBaseInfo> _e_ : this.factioncakeinfo.entrySet()) {
/*  46 */       if (!((RoleCakeBaseInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.activityid);
/*  53 */     _os_.marshal(this.factionid);
/*  54 */     _os_.compact_uint32(this.factioncakeinfo.size());
/*  55 */     for (Map.Entry<Long, RoleCakeBaseInfo> _e_ : this.factioncakeinfo.entrySet()) {
/*  56 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  57 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.activityid = _os_.unmarshal_int();
/*  64 */     this.factionid = _os_.unmarshal_long();
/*  65 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  67 */       long _k_ = _os_.unmarshal_long();
/*  68 */       RoleCakeBaseInfo _v_ = new RoleCakeBaseInfo();
/*  69 */       _v_.unmarshal(_os_);
/*  70 */       this.factioncakeinfo.put(Long.valueOf(_k_), _v_);
/*     */     }
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SGetFactionCakeInfoRep)) {
/*  81 */       SGetFactionCakeInfoRep _o_ = (SGetFactionCakeInfoRep)_o1_;
/*  82 */       if (this.activityid != _o_.activityid) return false;
/*  83 */       if (this.factionid != _o_.factionid) return false;
/*  84 */       if (!this.factioncakeinfo.equals(_o_.factioncakeinfo)) return false;
/*  85 */       return true;
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  91 */     int _h_ = 0;
/*  92 */     _h_ += this.activityid;
/*  93 */     _h_ += (int)this.factionid;
/*  94 */     _h_ += this.factioncakeinfo.hashCode();
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.activityid).append(",");
/* 102 */     _sb_.append(this.factionid).append(",");
/* 103 */     _sb_.append(this.factioncakeinfo).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\SGetFactionCakeInfoRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */