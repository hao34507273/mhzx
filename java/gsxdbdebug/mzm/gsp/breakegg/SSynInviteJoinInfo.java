/*     */ package mzm.gsp.breakegg;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynInviteJoinInfo
/*     */   extends __SSynInviteJoinInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12623371;
/*     */   public long inviter_id;
/*     */   public ArrayList<RoleInfo> role_info_list;
/*     */   public int invite_type;
/*     */   public long session_id;
/*     */   public Octets extro_info;
/*     */   public long end_time;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12623371;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynInviteJoinInfo()
/*     */   {
/*  38 */     this.role_info_list = new ArrayList();
/*  39 */     this.extro_info = new Octets();
/*     */   }
/*     */   
/*     */   public SSynInviteJoinInfo(long _inviter_id_, ArrayList<RoleInfo> _role_info_list_, int _invite_type_, long _session_id_, Octets _extro_info_, long _end_time_) {
/*  43 */     this.inviter_id = _inviter_id_;
/*  44 */     this.role_info_list = _role_info_list_;
/*  45 */     this.invite_type = _invite_type_;
/*  46 */     this.session_id = _session_id_;
/*  47 */     this.extro_info = _extro_info_;
/*  48 */     this.end_time = _end_time_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     for (RoleInfo _v_ : this.role_info_list)
/*  53 */       if (!_v_._validator_()) return false;
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.inviter_id);
/*  59 */     _os_.compact_uint32(this.role_info_list.size());
/*  60 */     for (RoleInfo _v_ : this.role_info_list) {
/*  61 */       _os_.marshal(_v_);
/*     */     }
/*  63 */     _os_.marshal(this.invite_type);
/*  64 */     _os_.marshal(this.session_id);
/*  65 */     _os_.marshal(this.extro_info);
/*  66 */     _os_.marshal(this.end_time);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  71 */     this.inviter_id = _os_.unmarshal_long();
/*  72 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  73 */       RoleInfo _v_ = new RoleInfo();
/*  74 */       _v_.unmarshal(_os_);
/*  75 */       this.role_info_list.add(_v_);
/*     */     }
/*  77 */     this.invite_type = _os_.unmarshal_int();
/*  78 */     this.session_id = _os_.unmarshal_long();
/*  79 */     this.extro_info = _os_.unmarshal_Octets();
/*  80 */     this.end_time = _os_.unmarshal_long();
/*  81 */     if (!_validator_()) {
/*  82 */       throw new VerifyError("validator failed");
/*     */     }
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  88 */     if (_o1_ == this) return true;
/*  89 */     if ((_o1_ instanceof SSynInviteJoinInfo)) {
/*  90 */       SSynInviteJoinInfo _o_ = (SSynInviteJoinInfo)_o1_;
/*  91 */       if (this.inviter_id != _o_.inviter_id) return false;
/*  92 */       if (!this.role_info_list.equals(_o_.role_info_list)) return false;
/*  93 */       if (this.invite_type != _o_.invite_type) return false;
/*  94 */       if (this.session_id != _o_.session_id) return false;
/*  95 */       if (!this.extro_info.equals(_o_.extro_info)) return false;
/*  96 */       if (this.end_time != _o_.end_time) return false;
/*  97 */       return true;
/*     */     }
/*  99 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 103 */     int _h_ = 0;
/* 104 */     _h_ += (int)this.inviter_id;
/* 105 */     _h_ += this.role_info_list.hashCode();
/* 106 */     _h_ += this.invite_type;
/* 107 */     _h_ += (int)this.session_id;
/* 108 */     _h_ += this.extro_info.hashCode();
/* 109 */     _h_ += (int)this.end_time;
/* 110 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder _sb_ = new StringBuilder();
/* 115 */     _sb_.append("(");
/* 116 */     _sb_.append(this.inviter_id).append(",");
/* 117 */     _sb_.append(this.role_info_list).append(",");
/* 118 */     _sb_.append(this.invite_type).append(",");
/* 119 */     _sb_.append(this.session_id).append(",");
/* 120 */     _sb_.append("B").append(this.extro_info.size()).append(",");
/* 121 */     _sb_.append(this.end_time).append(",");
/* 122 */     _sb_.append(")");
/* 123 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\SSynInviteJoinInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */