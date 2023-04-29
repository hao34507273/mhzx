/*     */ package mzm.gsp.wanted;
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
/*     */ 
/*     */ public class SNotifyPVEFightResult
/*     */   extends __SNotifyPVEFightResult__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12620291;
/*     */   public static final int SUCCESS = 1;
/*     */   public static final int FAIL = 2;
/*     */   public int result;
/*     */   public ArrayList<Octets> passivenamelist;
/*     */   public int fightcount;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12620291;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SNotifyPVEFightResult()
/*     */   {
/*  38 */     this.passivenamelist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SNotifyPVEFightResult(int _result_, ArrayList<Octets> _passivenamelist_, int _fightcount_) {
/*  42 */     this.result = _result_;
/*  43 */     this.passivenamelist = _passivenamelist_;
/*  44 */     this.fightcount = _fightcount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.result);
/*  53 */     _os_.compact_uint32(this.passivenamelist.size());
/*  54 */     for (Octets _v_ : this.passivenamelist) {
/*  55 */       _os_.marshal(_v_);
/*     */     }
/*  57 */     _os_.marshal(this.fightcount);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.result = _os_.unmarshal_int();
/*  63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  65 */       Octets _v_ = _os_.unmarshal_Octets();
/*  66 */       this.passivenamelist.add(_v_);
/*     */     }
/*  68 */     this.fightcount = _os_.unmarshal_int();
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof SNotifyPVEFightResult)) {
/*  78 */       SNotifyPVEFightResult _o_ = (SNotifyPVEFightResult)_o1_;
/*  79 */       if (this.result != _o_.result) return false;
/*  80 */       if (!this.passivenamelist.equals(_o_.passivenamelist)) return false;
/*  81 */       if (this.fightcount != _o_.fightcount) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.result;
/*  90 */     _h_ += this.passivenamelist.hashCode();
/*  91 */     _h_ += this.fightcount;
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.result).append(",");
/*  99 */     _sb_.append(this.passivenamelist).append(",");
/* 100 */     _sb_.append(this.fightcount).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\SNotifyPVEFightResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */