/*     */ package gnet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SysSendMail2 extends __SysSendMail2__ {
/*     */   public static final int PROTOCOL_TYPE = 4216;
/*     */   public int tid;
/*     */   public int sysid;
/*     */   public byte sys_type;
/*     */   public long receiver;
/*     */   public com.goldhuman.Common.Octets title;
/*     */   public com.goldhuman.Common.Octets context;
/*     */   public GRoleInventory attach_obj;
/*     */   public int attach_money;
/*     */   
/*     */   protected void process() {
/*  17 */     GdeliveryHelper.sendAuSysMail(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  25 */     return 4216;
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
/*     */   public SysSendMail2()
/*     */   {
/*  38 */     this.title = new com.goldhuman.Common.Octets();
/*  39 */     this.context = new com.goldhuman.Common.Octets();
/*  40 */     this.attach_obj = new GRoleInventory();
/*     */   }
/*     */   
/*     */   public SysSendMail2(int _tid_, int _sysid_, byte _sys_type_, long _receiver_, com.goldhuman.Common.Octets _title_, com.goldhuman.Common.Octets _context_, GRoleInventory _attach_obj_, int _attach_money_) {
/*  44 */     this.tid = _tid_;
/*  45 */     this.sysid = _sysid_;
/*  46 */     this.sys_type = _sys_type_;
/*  47 */     this.receiver = _receiver_;
/*  48 */     this.title = _title_;
/*  49 */     this.context = _context_;
/*  50 */     this.attach_obj = _attach_obj_;
/*  51 */     this.attach_money = _attach_money_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     if (!this.attach_obj._validator_()) return false;
/*  56 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  60 */     _os_.marshal(this.tid);
/*  61 */     _os_.marshal(this.sysid);
/*  62 */     _os_.marshal(this.sys_type);
/*  63 */     _os_.marshal(this.receiver);
/*  64 */     _os_.marshal(this.title);
/*  65 */     _os_.marshal(this.context);
/*  66 */     _os_.marshal(this.attach_obj);
/*  67 */     _os_.marshal(this.attach_money);
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  72 */     this.tid = _os_.unmarshal_int();
/*  73 */     this.sysid = _os_.unmarshal_int();
/*  74 */     this.sys_type = _os_.unmarshal_byte();
/*  75 */     this.receiver = _os_.unmarshal_long();
/*  76 */     this.title = _os_.unmarshal_Octets();
/*  77 */     this.context = _os_.unmarshal_Octets();
/*  78 */     this.attach_obj.unmarshal(_os_);
/*  79 */     this.attach_money = _os_.unmarshal_int();
/*  80 */     if (!_validator_()) {
/*  81 */       throw new VerifyError("validator failed");
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  87 */     if (_o1_ == this) return true;
/*  88 */     if ((_o1_ instanceof SysSendMail2)) {
/*  89 */       SysSendMail2 _o_ = (SysSendMail2)_o1_;
/*  90 */       if (this.tid != _o_.tid) return false;
/*  91 */       if (this.sysid != _o_.sysid) return false;
/*  92 */       if (this.sys_type != _o_.sys_type) return false;
/*  93 */       if (this.receiver != _o_.receiver) return false;
/*  94 */       if (!this.title.equals(_o_.title)) return false;
/*  95 */       if (!this.context.equals(_o_.context)) return false;
/*  96 */       if (!this.attach_obj.equals(_o_.attach_obj)) return false;
/*  97 */       if (this.attach_money != _o_.attach_money) return false;
/*  98 */       return true;
/*     */     }
/* 100 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 104 */     int _h_ = 0;
/* 105 */     _h_ += this.tid;
/* 106 */     _h_ += this.sysid;
/* 107 */     _h_ += this.sys_type;
/* 108 */     _h_ += (int)this.receiver;
/* 109 */     _h_ += this.title.hashCode();
/* 110 */     _h_ += this.context.hashCode();
/* 111 */     _h_ += this.attach_obj.hashCode();
/* 112 */     _h_ += this.attach_money;
/* 113 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 117 */     StringBuilder _sb_ = new StringBuilder();
/* 118 */     _sb_.append("(");
/* 119 */     _sb_.append(this.tid).append(",");
/* 120 */     _sb_.append(this.sysid).append(",");
/* 121 */     _sb_.append(this.sys_type).append(",");
/* 122 */     _sb_.append(this.receiver).append(",");
/* 123 */     _sb_.append("B").append(this.title.size()).append(",");
/* 124 */     _sb_.append("B").append(this.context.size()).append(",");
/* 125 */     _sb_.append(this.attach_obj).append(",");
/* 126 */     _sb_.append(this.attach_money).append(",");
/* 127 */     _sb_.append(")");
/* 128 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\SysSendMail2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */