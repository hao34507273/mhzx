/*     */ package mzm.gsp.breakegg;
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
/*     */ public class SSynBreakEggJoinInfo
/*     */   extends __SSynBreakEggJoinInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12623367;
/*     */   public int activity_id;
/*     */   public long inviter_id;
/*     */   public ArrayList<RoleInfo> role_info_list;
/*     */   public long session_id;
/*     */   public long end_time;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12623367;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynBreakEggJoinInfo()
/*     */   {
/*  37 */     this.role_info_list = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSynBreakEggJoinInfo(int _activity_id_, long _inviter_id_, ArrayList<RoleInfo> _role_info_list_, long _session_id_, long _end_time_) {
/*  41 */     this.activity_id = _activity_id_;
/*  42 */     this.inviter_id = _inviter_id_;
/*  43 */     this.role_info_list = _role_info_list_;
/*  44 */     this.session_id = _session_id_;
/*  45 */     this.end_time = _end_time_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     for (RoleInfo _v_ : this.role_info_list)
/*  50 */       if (!_v_._validator_()) return false;
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.activity_id);
/*  56 */     _os_.marshal(this.inviter_id);
/*  57 */     _os_.compact_uint32(this.role_info_list.size());
/*  58 */     for (RoleInfo _v_ : this.role_info_list) {
/*  59 */       _os_.marshal(_v_);
/*     */     }
/*  61 */     _os_.marshal(this.session_id);
/*  62 */     _os_.marshal(this.end_time);
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.activity_id = _os_.unmarshal_int();
/*  68 */     this.inviter_id = _os_.unmarshal_long();
/*  69 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  70 */       RoleInfo _v_ = new RoleInfo();
/*  71 */       _v_.unmarshal(_os_);
/*  72 */       this.role_info_list.add(_v_);
/*     */     }
/*  74 */     this.session_id = _os_.unmarshal_long();
/*  75 */     this.end_time = _os_.unmarshal_long();
/*  76 */     if (!_validator_()) {
/*  77 */       throw new VerifyError("validator failed");
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof SSynBreakEggJoinInfo)) {
/*  85 */       SSynBreakEggJoinInfo _o_ = (SSynBreakEggJoinInfo)_o1_;
/*  86 */       if (this.activity_id != _o_.activity_id) return false;
/*  87 */       if (this.inviter_id != _o_.inviter_id) return false;
/*  88 */       if (!this.role_info_list.equals(_o_.role_info_list)) return false;
/*  89 */       if (this.session_id != _o_.session_id) return false;
/*  90 */       if (this.end_time != _o_.end_time) return false;
/*  91 */       return true;
/*     */     }
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  97 */     int _h_ = 0;
/*  98 */     _h_ += this.activity_id;
/*  99 */     _h_ += (int)this.inviter_id;
/* 100 */     _h_ += this.role_info_list.hashCode();
/* 101 */     _h_ += (int)this.session_id;
/* 102 */     _h_ += (int)this.end_time;
/* 103 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 107 */     StringBuilder _sb_ = new StringBuilder();
/* 108 */     _sb_.append("(");
/* 109 */     _sb_.append(this.activity_id).append(",");
/* 110 */     _sb_.append(this.inviter_id).append(",");
/* 111 */     _sb_.append(this.role_info_list).append(",");
/* 112 */     _sb_.append(this.session_id).append(",");
/* 113 */     _sb_.append(this.end_time).append(",");
/* 114 */     _sb_.append(")");
/* 115 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\SSynBreakEggJoinInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */