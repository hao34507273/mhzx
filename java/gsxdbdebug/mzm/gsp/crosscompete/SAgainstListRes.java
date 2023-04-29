/*     */ package mzm.gsp.crosscompete;
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
/*     */ public class SAgainstListRes
/*     */   extends __SAgainstListRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12616735;
/*     */   public ArrayList<Against> against_list;
/*     */   public ArrayList<AgainstFaction> miss_turn_list;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12616735;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SAgainstListRes()
/*     */   {
/*  34 */     this.against_list = new ArrayList();
/*  35 */     this.miss_turn_list = new ArrayList();
/*     */   }
/*     */   
/*     */   public SAgainstListRes(ArrayList<Against> _against_list_, ArrayList<AgainstFaction> _miss_turn_list_) {
/*  39 */     this.against_list = _against_list_;
/*  40 */     this.miss_turn_list = _miss_turn_list_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     for (Against _v_ : this.against_list)
/*  45 */       if (!_v_._validator_()) return false;
/*  46 */     for (AgainstFaction _v_ : this.miss_turn_list)
/*  47 */       if (!_v_._validator_()) return false;
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.compact_uint32(this.against_list.size());
/*  53 */     for (Against _v_ : this.against_list) {
/*  54 */       _os_.marshal(_v_);
/*     */     }
/*  56 */     _os_.compact_uint32(this.miss_turn_list.size());
/*  57 */     for (AgainstFaction _v_ : this.miss_turn_list) {
/*  58 */       _os_.marshal(_v_);
/*     */     }
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  65 */       Against _v_ = new Against();
/*  66 */       _v_.unmarshal(_os_);
/*  67 */       this.against_list.add(_v_);
/*     */     }
/*  69 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  70 */       AgainstFaction _v_ = new AgainstFaction();
/*  71 */       _v_.unmarshal(_os_);
/*  72 */       this.miss_turn_list.add(_v_);
/*     */     }
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SAgainstListRes)) {
/*  83 */       SAgainstListRes _o_ = (SAgainstListRes)_o1_;
/*  84 */       if (!this.against_list.equals(_o_.against_list)) return false;
/*  85 */       if (!this.miss_turn_list.equals(_o_.miss_turn_list)) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.against_list.hashCode();
/*  94 */     _h_ += this.miss_turn_list.hashCode();
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.against_list).append(",");
/* 102 */     _sb_.append(this.miss_turn_list).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\SAgainstListRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */