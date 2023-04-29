/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.children.main.GiveBirthTimeOutObserver;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class GiveBirthObserver extends XBean implements xbean.GiveBirthObserver
/*     */ {
/*     */   private GiveBirthTimeOutObserver observer;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.observer = null;
/*     */   }
/*     */   
/*     */   GiveBirthObserver(int __, XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.observer = null;
/*     */   }
/*     */   
/*     */   public GiveBirthObserver()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public GiveBirthObserver(GiveBirthObserver _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   GiveBirthObserver(xbean.GiveBirthObserver _o1_, XBean _xp_, String _vn_)
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
/*     */   public xbean.GiveBirthObserver copy()
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     return new GiveBirthObserver(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GiveBirthObserver toData()
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GiveBirthObserver toBean()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     return new GiveBirthObserver(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GiveBirthObserver toDataIf()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GiveBirthObserver toBeanIf()
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
/*     */   public GiveBirthTimeOutObserver getObserver()
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/* 118 */     return this.observer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setObserver(GiveBirthTimeOutObserver _v_)
/*     */   {
/* 125 */     _xdb_verify_unsafe_();
/* 126 */     xdb.Logs.logIf(new LogKey(this, "observer")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 130 */         new xdb.logs.LogObject(this, GiveBirthObserver.this.observer)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 134 */             GiveBirthObserver.this.observer = ((GiveBirthTimeOutObserver)this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 138 */     });
/* 139 */     this.observer = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 145 */     _xdb_verify_unsafe_();
/* 146 */     GiveBirthObserver _o_ = null;
/* 147 */     if ((_o1_ instanceof GiveBirthObserver)) { _o_ = (GiveBirthObserver)_o1_;
/* 148 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 149 */       return false;
/* 150 */     if (((null == this.observer) && (null != _o_.observer)) || ((null != this.observer) && (null == _o_.observer)) || ((null != this.observer) && (null != _o_.observer) && (!this.observer.equals(_o_.observer)))) return false;
/* 151 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     int _h_ = 0;
/* 159 */     _h_ += (this.observer == null ? 0 : this.observer.hashCode());
/* 160 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 166 */     _xdb_verify_unsafe_();
/* 167 */     StringBuilder _sb_ = new StringBuilder();
/* 168 */     _sb_.append("(");
/* 169 */     _sb_.append(this.observer);
/* 170 */     _sb_.append(")");
/* 171 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 177 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 178 */     lb.add(new xdb.logs.ListenableChanged().setVarName("observer"));
/* 179 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.GiveBirthObserver {
/*     */     private Const() {}
/*     */     
/*     */     GiveBirthObserver nThis() {
/* 186 */       return GiveBirthObserver.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 192 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GiveBirthObserver copy()
/*     */     {
/* 198 */       return GiveBirthObserver.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GiveBirthObserver toData()
/*     */     {
/* 204 */       return GiveBirthObserver.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.GiveBirthObserver toBean()
/*     */     {
/* 209 */       return GiveBirthObserver.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GiveBirthObserver toDataIf()
/*     */     {
/* 215 */       return GiveBirthObserver.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.GiveBirthObserver toBeanIf()
/*     */     {
/* 220 */       return GiveBirthObserver.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public GiveBirthTimeOutObserver getObserver()
/*     */     {
/* 227 */       GiveBirthObserver.this._xdb_verify_unsafe_();
/* 228 */       return GiveBirthObserver.this.observer;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setObserver(GiveBirthTimeOutObserver _v_)
/*     */     {
/* 235 */       GiveBirthObserver.this._xdb_verify_unsafe_();
/* 236 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 242 */       GiveBirthObserver.this._xdb_verify_unsafe_();
/* 243 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 249 */       GiveBirthObserver.this._xdb_verify_unsafe_();
/* 250 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 256 */       return GiveBirthObserver.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 262 */       return GiveBirthObserver.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 268 */       GiveBirthObserver.this._xdb_verify_unsafe_();
/* 269 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 275 */       return GiveBirthObserver.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 281 */       return GiveBirthObserver.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 287 */       GiveBirthObserver.this._xdb_verify_unsafe_();
/* 288 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 294 */       return GiveBirthObserver.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 300 */       return GiveBirthObserver.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 306 */       return GiveBirthObserver.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 312 */       return GiveBirthObserver.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 318 */       return GiveBirthObserver.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 324 */       return GiveBirthObserver.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 330 */       return GiveBirthObserver.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.GiveBirthObserver
/*     */   {
/*     */     private GiveBirthTimeOutObserver observer;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 342 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 347 */       this.observer = null;
/*     */     }
/*     */     
/*     */     Data(xbean.GiveBirthObserver _o1_)
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
/*     */     public xbean.GiveBirthObserver copy()
/*     */     {
/* 388 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GiveBirthObserver toData()
/*     */     {
/* 394 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.GiveBirthObserver toBean()
/*     */     {
/* 399 */       return new GiveBirthObserver(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GiveBirthObserver toDataIf()
/*     */     {
/* 405 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.GiveBirthObserver toBeanIf()
/*     */     {
/* 410 */       return new GiveBirthObserver(this, null, null);
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
/*     */     public GiveBirthTimeOutObserver getObserver()
/*     */     {
/* 447 */       return this.observer;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setObserver(GiveBirthTimeOutObserver _v_)
/*     */     {
/* 454 */       this.observer = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 460 */       if (!(_o1_ instanceof Data)) return false;
/* 461 */       Data _o_ = (Data)_o1_;
/* 462 */       if (((null == this.observer) && (null != _o_.observer)) || ((null != this.observer) && (null == _o_.observer)) || ((null != this.observer) && (null != _o_.observer) && (!this.observer.equals(_o_.observer)))) return false;
/* 463 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 469 */       int _h_ = 0;
/* 470 */       _h_ += (this.observer == null ? 0 : this.observer.hashCode());
/* 471 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 477 */       StringBuilder _sb_ = new StringBuilder();
/* 478 */       _sb_.append("(");
/* 479 */       _sb_.append(this.observer);
/* 480 */       _sb_.append(")");
/* 481 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GiveBirthObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */