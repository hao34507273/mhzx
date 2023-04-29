/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.marriage.main.ForceDivorceSession;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class ForcedDivorceTimer extends XBean implements xbean.ForcedDivorceTimer
/*     */ {
/*     */   private ForceDivorceSession forcedivorcetimer;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.forcedivorcetimer = null;
/*     */   }
/*     */   
/*     */   ForcedDivorceTimer(int __, XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.forcedivorcetimer = null;
/*     */   }
/*     */   
/*     */   public ForcedDivorceTimer()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ForcedDivorceTimer(ForcedDivorceTimer _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ForcedDivorceTimer(xbean.ForcedDivorceTimer _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  46 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  52 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  58 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  64 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  70 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ForcedDivorceTimer copy()
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     return new ForcedDivorceTimer(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ForcedDivorceTimer toData()
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ForcedDivorceTimer toBean()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     return new ForcedDivorceTimer(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ForcedDivorceTimer toDataIf()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ForcedDivorceTimer toBeanIf()
/*     */   {
/* 102 */     _xdb_verify_unsafe_();
/* 103 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 109 */     _xdb_verify_unsafe_();
/* 110 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ForceDivorceSession getForcedivorcetimer()
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/* 118 */     return this.forcedivorcetimer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setForcedivorcetimer(ForceDivorceSession _v_)
/*     */   {
/* 125 */     _xdb_verify_unsafe_();
/* 126 */     xdb.Logs.logIf(new LogKey(this, "forcedivorcetimer")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 130 */         new xdb.logs.LogObject(this, ForcedDivorceTimer.this.forcedivorcetimer)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 134 */             ForcedDivorceTimer.this.forcedivorcetimer = ((ForceDivorceSession)this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 138 */     });
/* 139 */     this.forcedivorcetimer = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 145 */     _xdb_verify_unsafe_();
/* 146 */     ForcedDivorceTimer _o_ = null;
/* 147 */     if ((_o1_ instanceof ForcedDivorceTimer)) { _o_ = (ForcedDivorceTimer)_o1_;
/* 148 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 149 */       return false;
/* 150 */     if (((null == this.forcedivorcetimer) && (null != _o_.forcedivorcetimer)) || ((null != this.forcedivorcetimer) && (null == _o_.forcedivorcetimer)) || ((null != this.forcedivorcetimer) && (null != _o_.forcedivorcetimer) && (!this.forcedivorcetimer.equals(_o_.forcedivorcetimer)))) return false;
/* 151 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     int _h_ = 0;
/* 159 */     _h_ += (this.forcedivorcetimer == null ? 0 : this.forcedivorcetimer.hashCode());
/* 160 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 166 */     _xdb_verify_unsafe_();
/* 167 */     StringBuilder _sb_ = new StringBuilder();
/* 168 */     _sb_.append("(");
/* 169 */     _sb_.append(this.forcedivorcetimer);
/* 170 */     _sb_.append(")");
/* 171 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 177 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 178 */     lb.add(new xdb.logs.ListenableChanged().setVarName("forcedivorcetimer"));
/* 179 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ForcedDivorceTimer {
/*     */     private Const() {}
/*     */     
/*     */     ForcedDivorceTimer nThis() {
/* 186 */       return ForcedDivorceTimer.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 192 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ForcedDivorceTimer copy()
/*     */     {
/* 198 */       return ForcedDivorceTimer.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ForcedDivorceTimer toData()
/*     */     {
/* 204 */       return ForcedDivorceTimer.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ForcedDivorceTimer toBean()
/*     */     {
/* 209 */       return ForcedDivorceTimer.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ForcedDivorceTimer toDataIf()
/*     */     {
/* 215 */       return ForcedDivorceTimer.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ForcedDivorceTimer toBeanIf()
/*     */     {
/* 220 */       return ForcedDivorceTimer.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public ForceDivorceSession getForcedivorcetimer()
/*     */     {
/* 227 */       ForcedDivorceTimer.this._xdb_verify_unsafe_();
/* 228 */       return ForcedDivorceTimer.this.forcedivorcetimer;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setForcedivorcetimer(ForceDivorceSession _v_)
/*     */     {
/* 235 */       ForcedDivorceTimer.this._xdb_verify_unsafe_();
/* 236 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 242 */       ForcedDivorceTimer.this._xdb_verify_unsafe_();
/* 243 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 249 */       ForcedDivorceTimer.this._xdb_verify_unsafe_();
/* 250 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 256 */       return ForcedDivorceTimer.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 262 */       return ForcedDivorceTimer.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 268 */       ForcedDivorceTimer.this._xdb_verify_unsafe_();
/* 269 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 275 */       return ForcedDivorceTimer.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 281 */       return ForcedDivorceTimer.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 287 */       ForcedDivorceTimer.this._xdb_verify_unsafe_();
/* 288 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 294 */       return ForcedDivorceTimer.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 300 */       return ForcedDivorceTimer.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 306 */       return ForcedDivorceTimer.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 312 */       return ForcedDivorceTimer.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 318 */       return ForcedDivorceTimer.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 324 */       return ForcedDivorceTimer.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 330 */       return ForcedDivorceTimer.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ForcedDivorceTimer
/*     */   {
/*     */     private ForceDivorceSession forcedivorcetimer;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 342 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 347 */       this.forcedivorcetimer = null;
/*     */     }
/*     */     
/*     */     Data(xbean.ForcedDivorceTimer _o1_)
/*     */     {
/* 352 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 358 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 364 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 370 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 376 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 382 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ForcedDivorceTimer copy()
/*     */     {
/* 388 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ForcedDivorceTimer toData()
/*     */     {
/* 394 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ForcedDivorceTimer toBean()
/*     */     {
/* 399 */       return new ForcedDivorceTimer(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ForcedDivorceTimer toDataIf()
/*     */     {
/* 405 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ForcedDivorceTimer toBeanIf()
/*     */     {
/* 410 */       return new ForcedDivorceTimer(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 416 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 420 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 424 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 428 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 432 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 436 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 440 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public ForceDivorceSession getForcedivorcetimer()
/*     */     {
/* 447 */       return this.forcedivorcetimer;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setForcedivorcetimer(ForceDivorceSession _v_)
/*     */     {
/* 454 */       this.forcedivorcetimer = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 460 */       if (!(_o1_ instanceof Data)) return false;
/* 461 */       Data _o_ = (Data)_o1_;
/* 462 */       if (((null == this.forcedivorcetimer) && (null != _o_.forcedivorcetimer)) || ((null != this.forcedivorcetimer) && (null == _o_.forcedivorcetimer)) || ((null != this.forcedivorcetimer) && (null != _o_.forcedivorcetimer) && (!this.forcedivorcetimer.equals(_o_.forcedivorcetimer)))) return false;
/* 463 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 469 */       int _h_ = 0;
/* 470 */       _h_ += (this.forcedivorcetimer == null ? 0 : this.forcedivorcetimer.hashCode());
/* 471 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 477 */       StringBuilder _sb_ = new StringBuilder();
/* 478 */       _sb_.append("(");
/* 479 */       _sb_.append(this.forcedivorcetimer);
/* 480 */       _sb_.append(")");
/* 481 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ForcedDivorceTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */