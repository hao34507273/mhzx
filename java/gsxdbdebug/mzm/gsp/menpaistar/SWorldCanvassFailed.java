/*     */ package mzm.gsp.menpaistar;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class SWorldCanvassFailed
/*     */   extends __SWorldCanvassFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12612368;
/*     */   public static final int ERROR_NOT_CAMPAIGN = -1;
/*     */   public static final int ERROR_CD = -2;
/*     */   public static final int ERROR_YUANBAO_NOT_ENOUGH = -3;
/*     */   public static final int ERROR_ACTIVITY_IN_AWARD = -4;
/*     */   public static final int ERROR_SEND_CHANNEL_FAILED = -5;
/*     */   public static final int ERROR_SWITH_OCCUPATION = -6;
/*     */   public long target_roleid;
/*     */   public long client_yuanbao;
/*     */   public byte use_yuanbao;
/*     */   public Octets text;
/*     */   public int retcode;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12612368;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SWorldCanvassFailed()
/*     */   {
/*  44 */     this.text = new Octets();
/*     */   }
/*     */   
/*     */   public SWorldCanvassFailed(long _target_roleid_, long _client_yuanbao_, byte _use_yuanbao_, Octets _text_, int _retcode_) {
/*  48 */     this.target_roleid = _target_roleid_;
/*  49 */     this.client_yuanbao = _client_yuanbao_;
/*  50 */     this.use_yuanbao = _use_yuanbao_;
/*  51 */     this.text = _text_;
/*  52 */     this.retcode = _retcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  56 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  60 */     _os_.marshal(this.target_roleid);
/*  61 */     _os_.marshal(this.client_yuanbao);
/*  62 */     _os_.marshal(this.use_yuanbao);
/*  63 */     _os_.marshal(this.text);
/*  64 */     _os_.marshal(this.retcode);
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  69 */     this.target_roleid = _os_.unmarshal_long();
/*  70 */     this.client_yuanbao = _os_.unmarshal_long();
/*  71 */     this.use_yuanbao = _os_.unmarshal_byte();
/*  72 */     this.text = _os_.unmarshal_Octets();
/*  73 */     this.retcode = _os_.unmarshal_int();
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SWorldCanvassFailed)) {
/*  83 */       SWorldCanvassFailed _o_ = (SWorldCanvassFailed)_o1_;
/*  84 */       if (this.target_roleid != _o_.target_roleid) return false;
/*  85 */       if (this.client_yuanbao != _o_.client_yuanbao) return false;
/*  86 */       if (this.use_yuanbao != _o_.use_yuanbao) return false;
/*  87 */       if (!this.text.equals(_o_.text)) return false;
/*  88 */       if (this.retcode != _o_.retcode) return false;
/*  89 */       return true;
/*     */     }
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  95 */     int _h_ = 0;
/*  96 */     _h_ += (int)this.target_roleid;
/*  97 */     _h_ += (int)this.client_yuanbao;
/*  98 */     _h_ += this.use_yuanbao;
/*  99 */     _h_ += this.text.hashCode();
/* 100 */     _h_ += this.retcode;
/* 101 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuilder _sb_ = new StringBuilder();
/* 106 */     _sb_.append("(");
/* 107 */     _sb_.append(this.target_roleid).append(",");
/* 108 */     _sb_.append(this.client_yuanbao).append(",");
/* 109 */     _sb_.append(this.use_yuanbao).append(",");
/* 110 */     _sb_.append("B").append(this.text.size()).append(",");
/* 111 */     _sb_.append(this.retcode).append(",");
/* 112 */     _sb_.append(")");
/* 113 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\SWorldCanvassFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */