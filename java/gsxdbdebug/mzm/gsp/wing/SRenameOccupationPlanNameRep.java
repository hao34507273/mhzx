/*     */ package mzm.gsp.wing;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SRenameOccupationPlanNameRep
/*     */   extends __SRenameOccupationPlanNameRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596549;
/*     */   public static final int RES_SUC = 1;
/*     */   public static final int RES_ERR__NOT_OPEN_THIS_OCCUPATION = 2;
/*     */   public static final int RES_ERR__NAME_ILLEGAL = 3;
/*     */   public int occupationid;
/*     */   public Octets newname;
/*     */   public int result;
/*     */   public ArrayList<String> args;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12596549;
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
/*     */   public SRenameOccupationPlanNameRep()
/*     */   {
/*  40 */     this.newname = new Octets();
/*  41 */     this.args = new ArrayList();
/*     */   }
/*     */   
/*     */   public SRenameOccupationPlanNameRep(int _occupationid_, Octets _newname_, int _result_, ArrayList<String> _args_) {
/*  45 */     this.occupationid = _occupationid_;
/*  46 */     this.newname = _newname_;
/*  47 */     this.result = _result_;
/*  48 */     this.args = _args_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.occupationid);
/*  57 */     _os_.marshal(this.newname);
/*  58 */     _os_.marshal(this.result);
/*  59 */     _os_.compact_uint32(this.args.size());
/*  60 */     for (String _v_ : this.args) {
/*  61 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.occupationid = _os_.unmarshal_int();
/*  68 */     this.newname = _os_.unmarshal_Octets();
/*  69 */     this.result = _os_.unmarshal_int();
/*  70 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  72 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  73 */       this.args.add(_v_);
/*     */     }
/*  75 */     if (!_validator_()) {
/*  76 */       throw new VerifyError("validator failed");
/*     */     }
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  82 */     if (_o1_ == this) return true;
/*  83 */     if ((_o1_ instanceof SRenameOccupationPlanNameRep)) {
/*  84 */       SRenameOccupationPlanNameRep _o_ = (SRenameOccupationPlanNameRep)_o1_;
/*  85 */       if (this.occupationid != _o_.occupationid) return false;
/*  86 */       if (!this.newname.equals(_o_.newname)) return false;
/*  87 */       if (this.result != _o_.result) return false;
/*  88 */       if (!this.args.equals(_o_.args)) return false;
/*  89 */       return true;
/*     */     }
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  95 */     int _h_ = 0;
/*  96 */     _h_ += this.occupationid;
/*  97 */     _h_ += this.newname.hashCode();
/*  98 */     _h_ += this.result;
/*  99 */     _h_ += this.args.hashCode();
/* 100 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 104 */     StringBuilder _sb_ = new StringBuilder();
/* 105 */     _sb_.append("(");
/* 106 */     _sb_.append(this.occupationid).append(",");
/* 107 */     _sb_.append("B").append(this.newname.size()).append(",");
/* 108 */     _sb_.append(this.result).append(",");
/* 109 */     _sb_.append(this.args).append(",");
/* 110 */     _sb_.append(")");
/* 111 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\SRenameOccupationPlanNameRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */