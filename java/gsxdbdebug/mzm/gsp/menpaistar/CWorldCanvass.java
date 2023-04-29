/*     */ package mzm.gsp.menpaistar;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.menpaistar.main.PCWorldCanvass;
/*     */ 
/*     */ public class CWorldCanvass extends __CWorldCanvass__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12612367;
/*     */   public long target_roleid;
/*     */   public byte use_yuanbao;
/*     */   public long client_yuanbao;
/*     */   public Octets text;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 1L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCWorldCanvass(roleId, this.target_roleid, this.use_yuanbao == 1, this.client_yuanbao, this.text));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12612367;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CWorldCanvass()
/*     */   {
/*  41 */     this.text = new Octets();
/*     */   }
/*     */   
/*     */   public CWorldCanvass(long _target_roleid_, byte _use_yuanbao_, long _client_yuanbao_, Octets _text_) {
/*  45 */     this.target_roleid = _target_roleid_;
/*  46 */     this.use_yuanbao = _use_yuanbao_;
/*  47 */     this.client_yuanbao = _client_yuanbao_;
/*  48 */     this.text = _text_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.target_roleid);
/*  57 */     _os_.marshal(this.use_yuanbao);
/*  58 */     _os_.marshal(this.client_yuanbao);
/*  59 */     _os_.marshal(this.text);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.target_roleid = _os_.unmarshal_long();
/*  65 */     this.use_yuanbao = _os_.unmarshal_byte();
/*  66 */     this.client_yuanbao = _os_.unmarshal_long();
/*  67 */     this.text = _os_.unmarshal_Octets();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof CWorldCanvass)) {
/*  77 */       CWorldCanvass _o_ = (CWorldCanvass)_o1_;
/*  78 */       if (this.target_roleid != _o_.target_roleid) return false;
/*  79 */       if (this.use_yuanbao != _o_.use_yuanbao) return false;
/*  80 */       if (this.client_yuanbao != _o_.client_yuanbao) return false;
/*  81 */       if (!this.text.equals(_o_.text)) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += (int)this.target_roleid;
/*  90 */     _h_ += this.use_yuanbao;
/*  91 */     _h_ += (int)this.client_yuanbao;
/*  92 */     _h_ += this.text.hashCode();
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.target_roleid).append(",");
/* 100 */     _sb_.append(this.use_yuanbao).append(",");
/* 101 */     _sb_.append(this.client_yuanbao).append(",");
/* 102 */     _sb_.append("B").append(this.text.size()).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\CWorldCanvass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */