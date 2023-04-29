/*     */ package mzm.gsp.drawandguess;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynDrawAndGuessQuestionInfo
/*     */   extends __SSynDrawAndGuessQuestionInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617242;
/*     */   public long drawerid;
/*     */   public ArrayList<Long> roleid_list;
/*     */   public int questioncfgid;
/*     */   public long timestamp;
/*     */   public long sessionid;
/*     */   public ArrayList<RoleGetJifenInfo> jifen_list;
/*     */   public int sendtype;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617242;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynDrawAndGuessQuestionInfo()
/*     */   {
/*  39 */     this.roleid_list = new ArrayList();
/*  40 */     this.jifen_list = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSynDrawAndGuessQuestionInfo(long _drawerid_, ArrayList<Long> _roleid_list_, int _questioncfgid_, long _timestamp_, long _sessionid_, ArrayList<RoleGetJifenInfo> _jifen_list_, int _sendtype_) {
/*  44 */     this.drawerid = _drawerid_;
/*  45 */     this.roleid_list = _roleid_list_;
/*  46 */     this.questioncfgid = _questioncfgid_;
/*  47 */     this.timestamp = _timestamp_;
/*  48 */     this.sessionid = _sessionid_;
/*  49 */     this.jifen_list = _jifen_list_;
/*  50 */     this.sendtype = _sendtype_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     for (RoleGetJifenInfo _v_ : this.jifen_list)
/*  55 */       if (!_v_._validator_()) return false;
/*  56 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  60 */     _os_.marshal(this.drawerid);
/*  61 */     _os_.compact_uint32(this.roleid_list.size());
/*  62 */     for (Long _v_ : this.roleid_list) {
/*  63 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  65 */     _os_.marshal(this.questioncfgid);
/*  66 */     _os_.marshal(this.timestamp);
/*  67 */     _os_.marshal(this.sessionid);
/*  68 */     _os_.compact_uint32(this.jifen_list.size());
/*  69 */     for (RoleGetJifenInfo _v_ : this.jifen_list) {
/*  70 */       _os_.marshal(_v_);
/*     */     }
/*  72 */     _os_.marshal(this.sendtype);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  77 */     this.drawerid = _os_.unmarshal_long();
/*  78 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  80 */       long _v_ = _os_.unmarshal_long();
/*  81 */       this.roleid_list.add(Long.valueOf(_v_));
/*     */     }
/*  83 */     this.questioncfgid = _os_.unmarshal_int();
/*  84 */     this.timestamp = _os_.unmarshal_long();
/*  85 */     this.sessionid = _os_.unmarshal_long();
/*  86 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  87 */       RoleGetJifenInfo _v_ = new RoleGetJifenInfo();
/*  88 */       _v_.unmarshal(_os_);
/*  89 */       this.jifen_list.add(_v_);
/*     */     }
/*  91 */     this.sendtype = _os_.unmarshal_int();
/*  92 */     if (!_validator_()) {
/*  93 */       throw new VerifyError("validator failed");
/*     */     }
/*  95 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  99 */     if (_o1_ == this) return true;
/* 100 */     if ((_o1_ instanceof SSynDrawAndGuessQuestionInfo)) {
/* 101 */       SSynDrawAndGuessQuestionInfo _o_ = (SSynDrawAndGuessQuestionInfo)_o1_;
/* 102 */       if (this.drawerid != _o_.drawerid) return false;
/* 103 */       if (!this.roleid_list.equals(_o_.roleid_list)) return false;
/* 104 */       if (this.questioncfgid != _o_.questioncfgid) return false;
/* 105 */       if (this.timestamp != _o_.timestamp) return false;
/* 106 */       if (this.sessionid != _o_.sessionid) return false;
/* 107 */       if (!this.jifen_list.equals(_o_.jifen_list)) return false;
/* 108 */       if (this.sendtype != _o_.sendtype) return false;
/* 109 */       return true;
/*     */     }
/* 111 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 115 */     int _h_ = 0;
/* 116 */     _h_ += (int)this.drawerid;
/* 117 */     _h_ += this.roleid_list.hashCode();
/* 118 */     _h_ += this.questioncfgid;
/* 119 */     _h_ += (int)this.timestamp;
/* 120 */     _h_ += (int)this.sessionid;
/* 121 */     _h_ += this.jifen_list.hashCode();
/* 122 */     _h_ += this.sendtype;
/* 123 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 127 */     StringBuilder _sb_ = new StringBuilder();
/* 128 */     _sb_.append("(");
/* 129 */     _sb_.append(this.drawerid).append(",");
/* 130 */     _sb_.append(this.roleid_list).append(",");
/* 131 */     _sb_.append(this.questioncfgid).append(",");
/* 132 */     _sb_.append(this.timestamp).append(",");
/* 133 */     _sb_.append(this.sessionid).append(",");
/* 134 */     _sb_.append(this.jifen_list).append(",");
/* 135 */     _sb_.append(this.sendtype).append(",");
/* 136 */     _sb_.append(")");
/* 137 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\SSynDrawAndGuessQuestionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */