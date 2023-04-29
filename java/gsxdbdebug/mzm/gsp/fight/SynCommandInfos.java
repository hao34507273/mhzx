/*     */ package mzm.gsp.fight;
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
/*     */ 
/*     */ public class SynCommandInfos
/*     */   extends __SynCommandInfos__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594201;
/*     */   public ArrayList<String> commandfriendinfos;
/*     */   public ArrayList<String> commandenermyinfos;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12594201;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SynCommandInfos()
/*     */   {
/*  34 */     this.commandfriendinfos = new ArrayList();
/*  35 */     this.commandenermyinfos = new ArrayList();
/*     */   }
/*     */   
/*     */   public SynCommandInfos(ArrayList<String> _commandfriendinfos_, ArrayList<String> _commandenermyinfos_) {
/*  39 */     this.commandfriendinfos = _commandfriendinfos_;
/*  40 */     this.commandenermyinfos = _commandenermyinfos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.compact_uint32(this.commandfriendinfos.size());
/*  49 */     for (String _v_ : this.commandfriendinfos) {
/*  50 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  52 */     _os_.compact_uint32(this.commandenermyinfos.size());
/*  53 */     for (String _v_ : this.commandenermyinfos) {
/*  54 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  62 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  63 */       this.commandfriendinfos.add(_v_);
/*     */     }
/*  65 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  67 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  68 */       this.commandenermyinfos.add(_v_);
/*     */     }
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof SynCommandInfos)) {
/*  79 */       SynCommandInfos _o_ = (SynCommandInfos)_o1_;
/*  80 */       if (!this.commandfriendinfos.equals(_o_.commandfriendinfos)) return false;
/*  81 */       if (!this.commandenermyinfos.equals(_o_.commandenermyinfos)) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.commandfriendinfos.hashCode();
/*  90 */     _h_ += this.commandenermyinfos.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.commandfriendinfos).append(",");
/*  98 */     _sb_.append(this.commandenermyinfos).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\SynCommandInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */