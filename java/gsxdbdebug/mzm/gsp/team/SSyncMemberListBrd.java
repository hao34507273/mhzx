/*     */ package mzm.gsp.team;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSyncMemberListBrd
/*     */   extends __SSyncMemberListBrd__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12588318;
/*     */   public ArrayList<Long> members;
/*     */   public ArrayList<TeamDispositionMemberInfo> disposition;
/*     */   public ArrayList<TeamMemberInfo> teammemberinfos;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12588318;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncMemberListBrd()
/*     */   {
/*  35 */     this.members = new ArrayList();
/*  36 */     this.disposition = new ArrayList();
/*  37 */     this.teammemberinfos = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSyncMemberListBrd(ArrayList<Long> _members_, ArrayList<TeamDispositionMemberInfo> _disposition_, ArrayList<TeamMemberInfo> _teammemberinfos_) {
/*  41 */     this.members = _members_;
/*  42 */     this.disposition = _disposition_;
/*  43 */     this.teammemberinfos = _teammemberinfos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     for (TeamDispositionMemberInfo _v_ : this.disposition)
/*  48 */       if (!_v_._validator_()) return false;
/*  49 */     for (TeamMemberInfo _v_ : this.teammemberinfos)
/*  50 */       if (!_v_._validator_()) return false;
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.compact_uint32(this.members.size());
/*  56 */     for (Long _v_ : this.members) {
/*  57 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  59 */     _os_.compact_uint32(this.disposition.size());
/*  60 */     for (TeamDispositionMemberInfo _v_ : this.disposition) {
/*  61 */       _os_.marshal(_v_);
/*     */     }
/*  63 */     _os_.compact_uint32(this.teammemberinfos.size());
/*  64 */     for (TeamMemberInfo _v_ : this.teammemberinfos) {
/*  65 */       _os_.marshal(_v_);
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  71 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  73 */       long _v_ = _os_.unmarshal_long();
/*  74 */       this.members.add(Long.valueOf(_v_));
/*     */     }
/*  76 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  77 */       TeamDispositionMemberInfo _v_ = new TeamDispositionMemberInfo();
/*  78 */       _v_.unmarshal(_os_);
/*  79 */       this.disposition.add(_v_);
/*     */     }
/*  81 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  82 */       TeamMemberInfo _v_ = new TeamMemberInfo();
/*  83 */       _v_.unmarshal(_os_);
/*  84 */       this.teammemberinfos.add(_v_);
/*     */     }
/*  86 */     if (!_validator_()) {
/*  87 */       throw new VerifyError("validator failed");
/*     */     }
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  93 */     if (_o1_ == this) return true;
/*  94 */     if ((_o1_ instanceof SSyncMemberListBrd)) {
/*  95 */       SSyncMemberListBrd _o_ = (SSyncMemberListBrd)_o1_;
/*  96 */       if (!this.members.equals(_o_.members)) return false;
/*  97 */       if (!this.disposition.equals(_o_.disposition)) return false;
/*  98 */       if (!this.teammemberinfos.equals(_o_.teammemberinfos)) return false;
/*  99 */       return true;
/*     */     }
/* 101 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 105 */     int _h_ = 0;
/* 106 */     _h_ += this.members.hashCode();
/* 107 */     _h_ += this.disposition.hashCode();
/* 108 */     _h_ += this.teammemberinfos.hashCode();
/* 109 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 113 */     StringBuilder _sb_ = new StringBuilder();
/* 114 */     _sb_.append("(");
/* 115 */     _sb_.append(this.members).append(",");
/* 116 */     _sb_.append(this.disposition).append(",");
/* 117 */     _sb_.append(this.teammemberinfos).append(",");
/* 118 */     _sb_.append(")");
/* 119 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\SSyncMemberListBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */