/*     */ package mzm.gsp.sworn;
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
/*     */ public class SSwornCreateNotify
/*     */   extends __SSwornCreateNotify__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12597818;
/*     */   public int membercount;
/*     */   public String name1;
/*     */   public String name2;
/*     */   public ArrayList<String> names;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12597818;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSwornCreateNotify()
/*     */   {
/*  36 */     this.name1 = "";
/*  37 */     this.name2 = "";
/*  38 */     this.names = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSwornCreateNotify(int _membercount_, String _name1_, String _name2_, ArrayList<String> _names_) {
/*  42 */     this.membercount = _membercount_;
/*  43 */     this.name1 = _name1_;
/*  44 */     this.name2 = _name2_;
/*  45 */     this.names = _names_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.membercount);
/*  54 */     _os_.marshal(this.name1, "UTF-16LE");
/*  55 */     _os_.marshal(this.name2, "UTF-16LE");
/*  56 */     _os_.compact_uint32(this.names.size());
/*  57 */     for (String _v_ : this.names) {
/*  58 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.membercount = _os_.unmarshal_int();
/*  65 */     this.name1 = _os_.unmarshal_String("UTF-16LE");
/*  66 */     this.name2 = _os_.unmarshal_String("UTF-16LE");
/*  67 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  69 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  70 */       this.names.add(_v_);
/*     */     }
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SSwornCreateNotify)) {
/*  81 */       SSwornCreateNotify _o_ = (SSwornCreateNotify)_o1_;
/*  82 */       if (this.membercount != _o_.membercount) return false;
/*  83 */       if (!this.name1.equals(_o_.name1)) return false;
/*  84 */       if (!this.name2.equals(_o_.name2)) return false;
/*  85 */       if (!this.names.equals(_o_.names)) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.membercount;
/*  94 */     _h_ += this.name1.hashCode();
/*  95 */     _h_ += this.name2.hashCode();
/*  96 */     _h_ += this.names.hashCode();
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.membercount).append(",");
/* 104 */     _sb_.append("T").append(this.name1.length()).append(",");
/* 105 */     _sb_.append("T").append(this.name2.length()).append(",");
/* 106 */     _sb_.append(this.names).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\SSwornCreateNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */