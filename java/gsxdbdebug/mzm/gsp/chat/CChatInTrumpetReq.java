/*     */ package mzm.gsp.chat;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.chat.main.PCChatInTrumpet;
/*     */ 
/*     */ public class CChatInTrumpetReq
/*     */   extends __CChatInTrumpetReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12585272;
/*     */   public int trumpet_cfg_id;
/*     */   public int current_yuanbao_num;
/*     */   public int contenttype;
/*     */   public Octets content;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L) {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCChatInTrumpet(roleId, this.trumpet_cfg_id, this.current_yuanbao_num, this.contenttype, this.content));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12585272;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CChatInTrumpetReq()
/*     */   {
/*  41 */     this.content = new Octets();
/*     */   }
/*     */   
/*     */   public CChatInTrumpetReq(int _trumpet_cfg_id_, int _current_yuanbao_num_, int _contenttype_, Octets _content_) {
/*  45 */     this.trumpet_cfg_id = _trumpet_cfg_id_;
/*  46 */     this.current_yuanbao_num = _current_yuanbao_num_;
/*  47 */     this.contenttype = _contenttype_;
/*  48 */     this.content = _content_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.trumpet_cfg_id);
/*  57 */     _os_.marshal(this.current_yuanbao_num);
/*  58 */     _os_.marshal(this.contenttype);
/*  59 */     _os_.marshal(this.content);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.trumpet_cfg_id = _os_.unmarshal_int();
/*  65 */     this.current_yuanbao_num = _os_.unmarshal_int();
/*  66 */     this.contenttype = _os_.unmarshal_int();
/*  67 */     this.content = _os_.unmarshal_Octets();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof CChatInTrumpetReq)) {
/*  77 */       CChatInTrumpetReq _o_ = (CChatInTrumpetReq)_o1_;
/*  78 */       if (this.trumpet_cfg_id != _o_.trumpet_cfg_id) return false;
/*  79 */       if (this.current_yuanbao_num != _o_.current_yuanbao_num) return false;
/*  80 */       if (this.contenttype != _o_.contenttype) return false;
/*  81 */       if (!this.content.equals(_o_.content)) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.trumpet_cfg_id;
/*  90 */     _h_ += this.current_yuanbao_num;
/*  91 */     _h_ += this.contenttype;
/*  92 */     _h_ += this.content.hashCode();
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.trumpet_cfg_id).append(",");
/* 100 */     _sb_.append(this.current_yuanbao_num).append(",");
/* 101 */     _sb_.append(this.contenttype).append(",");
/* 102 */     _sb_.append("B").append(this.content.size()).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\CChatInTrumpetReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */