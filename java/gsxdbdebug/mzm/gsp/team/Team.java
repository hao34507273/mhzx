/*     */ package mzm.gsp.team;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class Team implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public long teamid;
/*     */   public ArrayList<TeamMember> members;
/*     */   public ArrayList<TeamDispositionMemberInfo> disposition;
/*     */   public int zhenfaid;
/*     */   public int zhenfalv;
/*     */   
/*     */   public Team()
/*     */   {
/*  16 */     this.members = new ArrayList();
/*  17 */     this.disposition = new ArrayList();
/*     */   }
/*     */   
/*     */   public Team(long _teamid_, ArrayList<TeamMember> _members_, ArrayList<TeamDispositionMemberInfo> _disposition_, int _zhenfaid_, int _zhenfalv_) {
/*  21 */     this.teamid = _teamid_;
/*  22 */     this.members = _members_;
/*  23 */     this.disposition = _disposition_;
/*  24 */     this.zhenfaid = _zhenfaid_;
/*  25 */     this.zhenfalv = _zhenfalv_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  29 */     for (TeamMember _v_ : this.members)
/*  30 */       if (!_v_._validator_()) return false;
/*  31 */     for (TeamDispositionMemberInfo _v_ : this.disposition)
/*  32 */       if (!_v_._validator_()) return false;
/*  33 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  37 */     _os_.marshal(this.teamid);
/*  38 */     _os_.compact_uint32(this.members.size());
/*  39 */     for (TeamMember _v_ : this.members) {
/*  40 */       _os_.marshal(_v_);
/*     */     }
/*  42 */     _os_.compact_uint32(this.disposition.size());
/*  43 */     for (TeamDispositionMemberInfo _v_ : this.disposition) {
/*  44 */       _os_.marshal(_v_);
/*     */     }
/*  46 */     _os_.marshal(this.zhenfaid);
/*  47 */     _os_.marshal(this.zhenfalv);
/*  48 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  52 */     this.teamid = _os_.unmarshal_long();
/*  53 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  54 */       TeamMember _v_ = new TeamMember();
/*  55 */       _v_.unmarshal(_os_);
/*  56 */       this.members.add(_v_);
/*     */     }
/*  58 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  59 */       TeamDispositionMemberInfo _v_ = new TeamDispositionMemberInfo();
/*  60 */       _v_.unmarshal(_os_);
/*  61 */       this.disposition.add(_v_);
/*     */     }
/*  63 */     this.zhenfaid = _os_.unmarshal_int();
/*  64 */     this.zhenfalv = _os_.unmarshal_int();
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof Team)) {
/*  71 */       Team _o_ = (Team)_o1_;
/*  72 */       if (this.teamid != _o_.teamid) return false;
/*  73 */       if (!this.members.equals(_o_.members)) return false;
/*  74 */       if (!this.disposition.equals(_o_.disposition)) return false;
/*  75 */       if (this.zhenfaid != _o_.zhenfaid) return false;
/*  76 */       if (this.zhenfalv != _o_.zhenfalv) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += (int)this.teamid;
/*  85 */     _h_ += this.members.hashCode();
/*  86 */     _h_ += this.disposition.hashCode();
/*  87 */     _h_ += this.zhenfaid;
/*  88 */     _h_ += this.zhenfalv;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.teamid).append(",");
/*  96 */     _sb_.append(this.members).append(",");
/*  97 */     _sb_.append(this.disposition).append(",");
/*  98 */     _sb_.append(this.zhenfaid).append(",");
/*  99 */     _sb_.append(this.zhenfalv).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\Team.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */