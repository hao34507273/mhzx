/*     */ package mzm.gsp.shanggong;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.shanggong.main.PCShangGong;
/*     */ 
/*     */ public class CShangGongReq
/*     */   extends __CShangGongReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12610563;
/*     */   public int shanggong_id;
/*     */   public long sessionid;
/*     */   public int sort_id;
/*     */   public int money_type;
/*     */   public int money_num;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     if (roleid < 0L)
/*  22 */       return;
/*  23 */     Role.addRoleProcedure(roleid, new PCShangGong(roleid, this.shanggong_id, this.sessionid, this.sort_id, this.money_type, this.money_num));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12610563;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CShangGongReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CShangGongReq(int _shanggong_id_, long _sessionid_, int _sort_id_, int _money_type_, int _money_num_)
/*     */   {
/*  45 */     this.shanggong_id = _shanggong_id_;
/*  46 */     this.sessionid = _sessionid_;
/*  47 */     this.sort_id = _sort_id_;
/*  48 */     this.money_type = _money_type_;
/*  49 */     this.money_num = _money_num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.shanggong_id);
/*  58 */     _os_.marshal(this.sessionid);
/*  59 */     _os_.marshal(this.sort_id);
/*  60 */     _os_.marshal(this.money_type);
/*  61 */     _os_.marshal(this.money_num);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.shanggong_id = _os_.unmarshal_int();
/*  67 */     this.sessionid = _os_.unmarshal_long();
/*  68 */     this.sort_id = _os_.unmarshal_int();
/*  69 */     this.money_type = _os_.unmarshal_int();
/*  70 */     this.money_num = _os_.unmarshal_int();
/*  71 */     if (!_validator_()) {
/*  72 */       throw new VerifyError("validator failed");
/*     */     }
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  78 */     if (_o1_ == this) return true;
/*  79 */     if ((_o1_ instanceof CShangGongReq)) {
/*  80 */       CShangGongReq _o_ = (CShangGongReq)_o1_;
/*  81 */       if (this.shanggong_id != _o_.shanggong_id) return false;
/*  82 */       if (this.sessionid != _o_.sessionid) return false;
/*  83 */       if (this.sort_id != _o_.sort_id) return false;
/*  84 */       if (this.money_type != _o_.money_type) return false;
/*  85 */       if (this.money_num != _o_.money_num) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.shanggong_id;
/*  94 */     _h_ += (int)this.sessionid;
/*  95 */     _h_ += this.sort_id;
/*  96 */     _h_ += this.money_type;
/*  97 */     _h_ += this.money_num;
/*  98 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 102 */     StringBuilder _sb_ = new StringBuilder();
/* 103 */     _sb_.append("(");
/* 104 */     _sb_.append(this.shanggong_id).append(",");
/* 105 */     _sb_.append(this.sessionid).append(",");
/* 106 */     _sb_.append(this.sort_id).append(",");
/* 107 */     _sb_.append(this.money_type).append(",");
/* 108 */     _sb_.append(this.money_num).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CShangGongReq _o_) {
/* 114 */     if (_o_ == this) return 0;
/* 115 */     int _c_ = 0;
/* 116 */     _c_ = this.shanggong_id - _o_.shanggong_id;
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     _c_ = Long.signum(this.sessionid - _o_.sessionid);
/* 119 */     if (0 != _c_) return _c_;
/* 120 */     _c_ = this.sort_id - _o_.sort_id;
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     _c_ = this.money_type - _o_.money_type;
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = this.money_num - _o_.money_num;
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanggong\CShangGongReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */