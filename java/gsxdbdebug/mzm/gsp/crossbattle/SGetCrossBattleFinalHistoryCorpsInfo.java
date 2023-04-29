/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetCrossBattleFinalHistoryCorpsInfo
/*     */   extends __SGetCrossBattleFinalHistoryCorpsInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617085;
/*     */   public int session;
/*     */   public int rank;
/*     */   public long corps_id;
/*     */   public Octets corps_name;
/*     */   public int corps_zone_id;
/*     */   public int corps_badge_id;
/*     */   public HashSet<CorpsMemberInfo> corps_member_set;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617085;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetCrossBattleFinalHistoryCorpsInfo()
/*     */   {
/*  39 */     this.corps_name = new Octets();
/*  40 */     this.corps_member_set = new HashSet();
/*     */   }
/*     */   
/*     */   public SGetCrossBattleFinalHistoryCorpsInfo(int _session_, int _rank_, long _corps_id_, Octets _corps_name_, int _corps_zone_id_, int _corps_badge_id_, HashSet<CorpsMemberInfo> _corps_member_set_) {
/*  44 */     this.session = _session_;
/*  45 */     this.rank = _rank_;
/*  46 */     this.corps_id = _corps_id_;
/*  47 */     this.corps_name = _corps_name_;
/*  48 */     this.corps_zone_id = _corps_zone_id_;
/*  49 */     this.corps_badge_id = _corps_badge_id_;
/*  50 */     this.corps_member_set = _corps_member_set_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     for (CorpsMemberInfo _v_ : this.corps_member_set)
/*  55 */       if (!_v_._validator_()) return false;
/*  56 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  60 */     _os_.marshal(this.session);
/*  61 */     _os_.marshal(this.rank);
/*  62 */     _os_.marshal(this.corps_id);
/*  63 */     _os_.marshal(this.corps_name);
/*  64 */     _os_.marshal(this.corps_zone_id);
/*  65 */     _os_.marshal(this.corps_badge_id);
/*  66 */     _os_.compact_uint32(this.corps_member_set.size());
/*  67 */     for (CorpsMemberInfo _v_ : this.corps_member_set) {
/*  68 */       _os_.marshal(_v_);
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  74 */     this.session = _os_.unmarshal_int();
/*  75 */     this.rank = _os_.unmarshal_int();
/*  76 */     this.corps_id = _os_.unmarshal_long();
/*  77 */     this.corps_name = _os_.unmarshal_Octets();
/*  78 */     this.corps_zone_id = _os_.unmarshal_int();
/*  79 */     this.corps_badge_id = _os_.unmarshal_int();
/*  80 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  81 */       CorpsMemberInfo _v_ = new CorpsMemberInfo();
/*  82 */       _v_.unmarshal(_os_);
/*  83 */       this.corps_member_set.add(_v_);
/*     */     }
/*  85 */     if (!_validator_()) {
/*  86 */       throw new VerifyError("validator failed");
/*     */     }
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  92 */     if (_o1_ == this) return true;
/*  93 */     if ((_o1_ instanceof SGetCrossBattleFinalHistoryCorpsInfo)) {
/*  94 */       SGetCrossBattleFinalHistoryCorpsInfo _o_ = (SGetCrossBattleFinalHistoryCorpsInfo)_o1_;
/*  95 */       if (this.session != _o_.session) return false;
/*  96 */       if (this.rank != _o_.rank) return false;
/*  97 */       if (this.corps_id != _o_.corps_id) return false;
/*  98 */       if (!this.corps_name.equals(_o_.corps_name)) return false;
/*  99 */       if (this.corps_zone_id != _o_.corps_zone_id) return false;
/* 100 */       if (this.corps_badge_id != _o_.corps_badge_id) return false;
/* 101 */       if (!this.corps_member_set.equals(_o_.corps_member_set)) return false;
/* 102 */       return true;
/*     */     }
/* 104 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 108 */     int _h_ = 0;
/* 109 */     _h_ += this.session;
/* 110 */     _h_ += this.rank;
/* 111 */     _h_ += (int)this.corps_id;
/* 112 */     _h_ += this.corps_name.hashCode();
/* 113 */     _h_ += this.corps_zone_id;
/* 114 */     _h_ += this.corps_badge_id;
/* 115 */     _h_ += this.corps_member_set.hashCode();
/* 116 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 120 */     StringBuilder _sb_ = new StringBuilder();
/* 121 */     _sb_.append("(");
/* 122 */     _sb_.append(this.session).append(",");
/* 123 */     _sb_.append(this.rank).append(",");
/* 124 */     _sb_.append(this.corps_id).append(",");
/* 125 */     _sb_.append("B").append(this.corps_name.size()).append(",");
/* 126 */     _sb_.append(this.corps_zone_id).append(",");
/* 127 */     _sb_.append(this.corps_badge_id).append(",");
/* 128 */     _sb_.append(this.corps_member_set).append(",");
/* 129 */     _sb_.append(")");
/* 130 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SGetCrossBattleFinalHistoryCorpsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */